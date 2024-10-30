package misterhyacinth.pumpkinseason.block;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

import java.util.Objects;

public class CarvedSquashBlock extends CarvedPumpkinBlock implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    protected static VoxelShape SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 16.0);
    private final String squashType;


    public CarvedSquashBlock(String squashType, Settings settings) {
        super(settings);
        this.squashType = squashType;
        setDefaultState(this.stateManager.getDefaultState()
                .with(Properties.HORIZONTAL_FACING, Direction.NORTH)
                .with(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (Objects.equals(this.squashType, "butternut")) {
            return SquashShapes.BUTTERNUT_SHAPE;
        } else if (Objects.equals(this.squashType, "ghost") || Objects.equals(this.squashType, "midnight")){
            return SquashShapes.GHOST_SHAPE;
        } else if (Objects.equals(this.squashType, "kabocha")){
            return SquashShapes.KABOCHA_SHAPE;
        } else if (Objects.equals(this.squashType, "mini")){
            return SquashShapes.MINI_SHAPE;
        } else if (Objects.equals(this.squashType, "sugar")){
            return SquashShapes.SUGAR_SHAPE;
        } else {
            return SHAPE;
        }
    }


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING, WATERLOGGED);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
                .with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite())
                .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER);
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING,rotation.rotate(state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction,
                                                BlockState neighborState, WorldAccess world,
                                                BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

}
