package misterhyacinth.pumpkinseason.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class GravestoneBlock extends AbstractGraveyardDecorBlock {
    protected static final VoxelShape NORTH_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(0.0, 0.0, 10.0, 16.0, 3.0, 16.0),
            Block.createCuboidShape(1.0, 3.0, 11.0, 15.0, 19.0, 15.0),
            Block.createCuboidShape(2.0, 19.0, 11.0, 14.0, 20.0, 15.0)
    );
    protected static final VoxelShape EAST_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(0.0, 0.0, 0.0, 6.0, 3.0, 16.0),
            Block.createCuboidShape(1.0, 3.0, 1.0, 5.0, 19.0, 15.0),
            Block.createCuboidShape(1.0, 19.0, 2.0, 5.0, 20.0, 14.0)
    );

    protected static final VoxelShape SOUTH_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 3.0, 6.0),
            Block.createCuboidShape(1.0, 3.0, 1.0, 15.0, 19.0, 5.0),
            Block.createCuboidShape(2.0, 19.0, 1.0, 14.0, 20.0, 5.0)
    );


    protected static final VoxelShape WEST_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(10.0, 0.0, 0.0, 16.0, 3.0, 16.0),
            Block.createCuboidShape(11.0, 3.0, 1.0, 15.0, 19.0, 15.0),
            Block.createCuboidShape(11.0, 19.0, 2.0, 15.0, 20.0, 14.0)
    );


    public GravestoneBlock(Settings settings) {
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
