package misterhyacinth.pumpkinseason.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class CrossGravestoneBlock extends AbstractGraveyardDecorBlock {

    protected static final VoxelShape NORTH_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(2.0, 0.0, 10.0, 14.0, 2.0, 16.0),
            Block.createCuboidShape(4.0, 2.0, 10.5, 12.0, 4.0, 15.5),
            Block.createCuboidShape(6.0, 4.0, 11.0, 10.0, 12.0, 15.0),
            Block.createCuboidShape(4.0, 12.0, 11.0, 12.0, 20.0, 15.0),
            Block.createCuboidShape(12.0, 14.0, 11.0, 15.0, 18.0, 15.0),
            Block.createCuboidShape(1.0, 14.0, 11.0, 4.0, 18.0, 15.0),
            Block.createCuboidShape(6.0, 20.0, 11.0, 10.0, 24.0, 15.0)
    );
    protected static final VoxelShape EAST_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(0.0, 0.0, 2.0, 6.0, 2.0, 14.0),
            Block.createCuboidShape(0.5, 2.0, 4.0, 5.5, 4.0, 12.0),
            Block.createCuboidShape(1.0, 4.0, 6.0, 5.0, 12.0, 10.0),
            Block.createCuboidShape(1.0, 12.0, 4.0, 5.0, 20.0, 12.0),
            Block.createCuboidShape(1.0, 14.0, 12.0, 5.0, 18.0, 15.0),
            Block.createCuboidShape(1.0, 14.0, 1.0, 5.0, 18.0, 4.0),
            Block.createCuboidShape(1.0, 20.0, 6.0, 5.0, 24.0, 10.0)
    );
    protected static final VoxelShape SOUTH_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(2.0, 0.0, 0.0, 14.0, 2.0, 6.0),
            Block.createCuboidShape(4.0, 2.0, 0.5, 12.0, 4.0, 5.5),
            Block.createCuboidShape(6.0, 4.0, 1.0, 10.0, 12.0, 5.0),
            Block.createCuboidShape(4.0, 12.0, 1.0, 12.0, 20.0, 5.0),
            Block.createCuboidShape(1.0, 14.0, 1.0, 4.0, 18.0, 5.0),
            Block.createCuboidShape(12.0, 14.0, 1.0, 15.0, 18.0, 5.0),
            Block.createCuboidShape(6.0, 20.0, 1.0, 10.0, 24.0, 5.0)
    );
    protected static final VoxelShape WEST_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(10.0, 0.0, 2.0, 16.0, 2.0, 14.0),
            Block.createCuboidShape(10.5, 2.0, 4.0, 15.5, 4.0, 12.0),
            Block.createCuboidShape(11.0, 4.0, 6.0, 15.0, 12.0, 10.0),
            Block.createCuboidShape(11.0, 12.0, 4.0, 15.0, 20.0, 12.0),
            Block.createCuboidShape(11.0, 14.0, 1.0, 15.0, 18.0, 4.0),
            Block.createCuboidShape(11.0, 14.0, 12.0, 15.0, 18.0, 15.0),
            Block.createCuboidShape(11.0, 20.0, 6.0, 15.0, 24.0, 10.0)
    );

    public CrossGravestoneBlock(Settings settings) {
        super(settings);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction facing = state.get(FACING);
        return switch (facing) {
            case EAST -> EAST_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_SHAPE;
            default -> NORTH_SHAPE;
        };
    }
}
