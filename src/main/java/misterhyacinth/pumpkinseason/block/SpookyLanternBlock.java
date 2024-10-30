package misterhyacinth.pumpkinseason.block;

import misterhyacinth.pumpkinseason.PumpkinRegistry;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class SpookyLanternBlock extends LanternBlock {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public static final BooleanProperty HANGING = Properties.HANGING;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    protected static final VoxelShape SKULL_SHAPE =
            VoxelShapes.union(
                    Block.createCuboidShape(6.0, 9.0, 6.0, 10.0, 11.0, 10.0),
                    Block.createCuboidShape(4.0, 2.0, 4.0, 12.0, 9.0, 12.0),
                    Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 2.0, 11.0));

    protected static final VoxelShape PUMPKIN_SHAPE =
            VoxelShapes.union(
                    Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 9.0, 12.0),
                    Block.createCuboidShape(6.0, 9.0, 6.0, 10.0, 11.0, 10.0));

    protected static final VoxelShape BAT_SHAPE =
            Block.createCuboidShape(5.5, 0.0, 5.5, 10.5, 9.0, 10.5);

    protected static final VoxelShape HANGING_BAT_SHAPE =
            Block.createCuboidShape(5.5, 2.0, 5.5, 10.5, 11.0, 10.5);

    protected static final VoxelShape SPIDER_SHAPE =
            VoxelShapes.union(
                    Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 7.0, 12.0),
                    Block.createCuboidShape(6.0, 7.0, 6.0, 10.0, 9.0, 10.0));
    protected static final VoxelShape HANGING_SPIDER_SHAPE =
            VoxelShapes.union(
                    Block.createCuboidShape(4.0, 1.0, 4.0, 12.0, 8.0, 12.0),
                    Block.createCuboidShape(6.0, 8.0, 6.0, 10.0, 10.0, 10.0));

    protected static final VoxelShape GHASTLY_SHAPE =
            VoxelShapes.union(
                    Block.createCuboidShape(4.0, 2.0, 4.0, 12.0, 10.0, 12.0),
                    Block.createCuboidShape(6.0, 10.0, 6.0, 10.0, 12.0, 10.0));

    protected static final VoxelShape HANGING_GHASTLY_SHAPE =
            VoxelShapes.union(
                    Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 8.0, 12.0),
                    Block.createCuboidShape(6.0, 8.0, 6.0, 10.0, 10.0, 10.0));

    protected static final VoxelShape MOON_SHAPE =
            VoxelShapes.union(
                    Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 1.0, 11.0),
                    Block.createCuboidShape(4.0, 1.0, 4.0, 12.0, 9.0, 12.0),
                    Block.createCuboidShape(5.0, 9.0, 5.0, 11.0, 10.0, 11.0),
                    Block.createCuboidShape(6.0, 10.0, 6.0, 10.0, 12.0, 10.0));


    public SpookyLanternBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(HANGING, false)
                .with(WATERLOGGED, false)
                .with(FACING, Direction.NORTH));
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        Direction[] var3 = ctx.getPlacementDirections();

        for (Direction direction : var3) {
            if (direction.getAxis() == Direction.Axis.Y) {
                BlockState blockState = this.getDefaultState()
                        .with(HANGING, direction == Direction.UP)
                        .with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
                if (blockState.canPlaceAt(ctx.getWorld(), ctx.getBlockPos())) {
                    return blockState.with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
                }
            }
        }

        return null;
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING,rotation.rotate(state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.isOf(PumpkinRegistry.BAT_LANTERN)) {
            return state.get(HANGING) ? HANGING_BAT_SHAPE : BAT_SHAPE;
        } else if (state.isOf(PumpkinRegistry.SPIDER_LANTERN)) {
            return state.get(HANGING) ? HANGING_SPIDER_SHAPE : SPIDER_SHAPE;
        } else if (state.isOf(PumpkinRegistry.GHASTLY_LANTERN)) {
            return state.get(HANGING) ? HANGING_GHASTLY_SHAPE : GHASTLY_SHAPE;
        } else if (state.isOf(PumpkinRegistry.SKULL_LANTERN) || state.isOf(PumpkinRegistry.WITHER_SKULL_LANTERN)) {
            return SKULL_SHAPE;
        } else if (state.isOf(PumpkinRegistry.PUMPKIN_LANTERN) || state.isOf(PumpkinRegistry.CREEPY_PUMPKIN_LANTERN)) {
            return PUMPKIN_SHAPE;
        } else {
            return MOON_SHAPE;
        }
    }


    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HANGING, WATERLOGGED, FACING);
    }


    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = attachedDirection(state).getOpposite();
        return Block.sideCoversSmallSquare(world, pos.offset(direction), direction.getOpposite());
    }

    protected static Direction attachedDirection(BlockState state) {
        return state.get(HANGING) ? Direction.DOWN : Direction.UP;
    }



    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return attachedDirection(state).getOpposite() == direction && !state.canPlaceAt(world, pos) ?
                Blocks.AIR.getDefaultState()
                : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }




}
