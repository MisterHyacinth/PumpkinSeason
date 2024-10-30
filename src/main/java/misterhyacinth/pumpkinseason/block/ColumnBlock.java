package misterhyacinth.pumpkinseason.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class ColumnBlock extends PillarBlock {

    public static final EnumProperty<ColumnPart> PART = EnumProperty.of("part", ColumnPart.class);


    public ColumnBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(PART, ColumnPart.SINGLET).with(AXIS, Direction.Axis.Y));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(PART, AXIS);
    }


    private static ColumnPart getPart(BlockState state, Direction.Axis axis, World world, BlockPos pos) {
        BlockState stateAbove;
        BlockState stateBelow;
        if (axis == Direction.Axis.Y) {
            stateAbove = world.getBlockState(pos.up());
            stateBelow = world.getBlockState(pos.down());
        } else if (axis == Direction.Axis.X) {
            stateAbove = world.getBlockState(pos.east());
            stateBelow = world.getBlockState(pos.west());
        } else {
            stateAbove = world.getBlockState(pos.north());
            stateBelow = world.getBlockState(pos.south());
        }

        Block blockAbove = stateAbove.getBlock();
        Block blockBelow = stateBelow.getBlock();


        Block thisBlock = state.getBlock();
        if (blockAbove == thisBlock && blockBelow == thisBlock && stateAbove.get(AXIS) == axis && stateBelow.get(AXIS) == axis) {
            return ColumnPart.MIDDLE;
        } else if (blockAbove == thisBlock && stateAbove.get(AXIS) == axis) {
            return ColumnPart.BOTTOM;
        } else if (blockBelow == thisBlock && stateBelow.get(AXIS) == axis) {
            return ColumnPart.TOP;
        } else {
            return ColumnPart.SINGLET;
        }
    }


    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos pos = ctx.getBlockPos();
        World world = ctx.getWorld();
        Direction.Axis axis = ctx.getSide().getAxis();
        return this.getDefaultState()
                .with(PART, getPart(this.getDefaultState(), axis, world, pos))
                .with(AXIS, axis);
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState,
                                                WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return state.with(PART, getPart(this.getDefaultState(), state.get(AXIS), (World) world, pos));
    }


}
