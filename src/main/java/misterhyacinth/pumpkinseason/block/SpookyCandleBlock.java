package misterhyacinth.pumpkinseason.block;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import misterhyacinth.pumpkinseason.PumpkinRegistry;
import misterhyacinth.pumpkinseason.util.PumpkinBlockTags;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class SpookyCandleBlock extends AbstractCandleBlock implements Waterloggable {

    public static final BooleanProperty LIT = AbstractCandleBlock.LIT;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    protected static final VoxelShape SHAPE =
            Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 8.0, 12.0);
    protected static final VoxelShape BAT_SHAPE =
            Block.createCuboidShape(5.5, 0.0, 5.5, 10.5, 8.0, 10.5);

    private static final Iterable<Vec3d> PARTICLE_OFFSETS =
            ImmutableList.of(new Vec3d(0.5, 0.625, 0.5));

    public SpookyCandleBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(LIT, false)
                .with(WATERLOGGED, false)
                .with(FACING, Direction.NORTH));
    }

    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos,
                                             PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.isEmpty() && player.getAbilities().allowModifyWorld && state.get(LIT)) {
            extinguish(player, state, world, pos);
            return ItemActionResult.success(world.isClient);
        } else {
            return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
        }
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
                .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER)
                .with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING,rotation.rotate(state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.isOf(PumpkinRegistry.BAT_CANDLE)) {
            return BAT_SHAPE;
        }else{
            return SHAPE;
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT, WATERLOGGED, FACING);
    }

    public boolean tryFillWithFluid(WorldAccess world, BlockPos pos, BlockState state, FluidState fluidState) {
        if (!(Boolean)state.get(WATERLOGGED) && fluidState.getFluid() == Fluids.WATER) {
            BlockState blockState = state.with(WATERLOGGED, true);
            if (state.get(LIT)) {
                extinguish(null, blockState, world, pos);
            } else {
                world.setBlockState(pos, blockState, 3);
            }

            world.scheduleFluidTick(pos, fluidState.getFluid(), fluidState.getFluid().getTickRate(world));
            return true;
        } else {
            return false;
        }
    }

    public static boolean canBeLit(BlockState state) {
        return state.isIn(PumpkinBlockTags.SPOOKY_CANDLES, (statex) -> {
            return statex.contains(LIT) && statex.contains(WATERLOGGED);
        }) && !(Boolean)state.get(LIT) && !(Boolean)state.get(WATERLOGGED);
    }

    @Override
    protected Iterable<Vec3d> getParticleOffsets(BlockState state) {
        return PARTICLE_OFFSETS;
    }
    protected boolean isNotLit(BlockState state) {
        return !(Boolean)state.get(WATERLOGGED) && super.isNotLit(state);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return Block.sideCoversSmallSquare(world, pos.down(), Direction.UP);
    }



    @Override
    protected MapCodec<? extends AbstractCandleBlock> getCodec() {
        return null;
    }


}
