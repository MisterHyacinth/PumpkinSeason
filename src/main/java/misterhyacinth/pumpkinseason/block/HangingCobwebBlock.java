package misterhyacinth.pumpkinseason.block;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class HangingCobwebBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final EnumProperty<CobwebCorner> CORNER = EnumProperty.of("corner", CobwebCorner.class);
    public static VoxelShape NS_SHAPE =
            Block.createCuboidShape(0.0, 0.0, 7.9, 16.0, 16.0, 8.1);
    public static VoxelShape WE_SHAPE =
            Block.createCuboidShape(7.9, 0.0, 0.0, 8.1, 16.0, 16.0);


    public HangingCobwebBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(CORNER, CobwebCorner.NONE)
                .with(FACING, Direction.NORTH));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        World blockView = ctx.getWorld();
        BlockPos pos = ctx.getBlockPos();
        Direction facing = ctx.getHorizontalPlayerFacing().getOpposite();

        BlockPos posNorth = pos.north();
        BlockPos posSouth = pos.south();
        BlockPos posEast = pos.east();
        BlockPos posWest = pos.west();

        boolean north = blockView.getBlockState(posNorth).isSideSolidFullSquare(blockView, posNorth, Direction.SOUTH);
        boolean south = blockView.getBlockState(posSouth).isSideSolidFullSquare(blockView, posSouth, Direction.NORTH);
        boolean east = blockView.getBlockState(posEast).isSideSolidFullSquare(blockView, posEast, Direction.WEST);
        boolean west = blockView.getBlockState(posWest).isSideSolidFullSquare(blockView, posWest, Direction.EAST);

        return this.getDefaultState()
                .with(CORNER, getCornerState(facing, north, south, east, west))
                .with(FACING, facing);
    }


    public CobwebCorner getCornerState(Direction facing,
                                       boolean north, boolean south,
                                       boolean east, boolean west) {
        boolean left = false;
        boolean right = false;

        if (facing == Direction.NORTH) {
            right = west;
            left = east;
        } else if (facing == Direction.SOUTH) {
            right = east;
            left = west;
        } else if (facing == Direction.EAST) {
            right = north;
            left = south;
        } else if (facing == Direction.WEST) {
            right = south;
            left = north;
        }

        if (left && right) {
            return CobwebCorner.BOTH;
        } else if (left) {
            return CobwebCorner.LEFT;
        } else if (right) {
            return CobwebCorner.RIGHT;
        } else {
            return CobwebCorner.NONE;
        }

    }


    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING,rotation.rotate(state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(FACING) == Direction.NORTH || state.get(FACING) == Direction.SOUTH) {
            return NS_SHAPE;
        } else {
            return WE_SHAPE;
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, CORNER);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return ( Block.sideCoversSmallSquare(world, pos.up(), Direction.DOWN)
                || world.getBlockState(pos.up()).getBlock() instanceof LeavesBlock)
                && !world.isWater(pos);
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (direction == Direction.UP && !this.canPlaceAt(state, world, pos)) {
            return Blocks.AIR.getDefaultState();
        } else if (direction.getAxis().getType() == Direction.Type.HORIZONTAL) {

            BlockPos posNorth = pos.north();
            BlockPos posSouth = pos.south();
            BlockPos posEast = pos.east();
            BlockPos posWest = pos.west();

            boolean north = world.getBlockState(posNorth).isSideSolidFullSquare(world, posNorth, Direction.SOUTH);
            boolean south = world.getBlockState(posSouth).isSideSolidFullSquare(world, posSouth, Direction.NORTH);
            boolean east = world.getBlockState(posEast).isSideSolidFullSquare(world, posEast, Direction.WEST);
            boolean west = world.getBlockState(posWest).isSideSolidFullSquare(world, posWest, Direction.EAST);

            return state.with(CORNER, getCornerState(state.get(FACING), north, south, east, west));

        } else {
            return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        }

    }



}
