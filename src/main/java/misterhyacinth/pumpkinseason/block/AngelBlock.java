package misterhyacinth.pumpkinseason.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class AngelBlock extends AbstractGraveyardDecorBlock {

    protected static final VoxelShape NORTH_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 2.0, 15.0),
            Block.createCuboidShape(4.0, 2.0, 6.0, 12.0, 15.0, 12.0),
            Block.createCuboidShape(1.0, 15.0, 6.0, 15.0, 24.0, 15.0),
            Block.createCuboidShape(4.5, 23.0, 3.0, 11.5, 31.0, 11.0),
            Block.createCuboidShape(-5.0, 8.0, 12.0, 3.0, 29.0, 15.0),
            Block.createCuboidShape(13.0, 8.0, 12.0, 21.0, 29.0, 15.0)
    );
    protected static final VoxelShape EAST_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 2.0, 15.0),
            Block.createCuboidShape(4.0, 2.0, 4.0, 10.0, 15.0, 12.0),
            Block.createCuboidShape(1.0, 15.0, 1.0, 10.0, 24.0, 15.0),
            Block.createCuboidShape(5.0, 23.0, 4.5, 13.0, 31.0, 11.5),
            Block.createCuboidShape(1.0, 8.0, -5.0, 4.0, 29.0, 3.0),
            Block.createCuboidShape(1.0, 8.0, 13.0, 4.0, 29.0, 21.0)
    );

    protected static final VoxelShape SOUTH_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 2.0, 15.0),
            Block.createCuboidShape(4.0, 2.0, 4.0, 12.0, 15.0, 10.0),
            Block.createCuboidShape(1.0, 15.0, 1.0, 15.0, 24.0, 10.0),
            Block.createCuboidShape(4.5, 23.0, 5.0, 11.5, 31.0, 13.0),
            Block.createCuboidShape(13.0, 8.0, 1.0, 21.0, 29.0, 4.0),
            Block.createCuboidShape(-5.0, 8.0, 1.0, 3.0, 29.0, 4.0)
    );


    protected static final VoxelShape WEST_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 2.0, 15.0),
            Block.createCuboidShape(6.0, 2.0, 4.0, 12.0, 15.0, 12.0),
            Block.createCuboidShape(6.0, 15.0, 1.0, 15.0, 24.0, 15.0),
            Block.createCuboidShape(3.0, 23.0, 4.5, 11.0, 31.0, 11.5),
            Block.createCuboidShape(12.0, 8.0, 13.0, 15.0, 29.0, 21.0),
            Block.createCuboidShape(12.0, 8.0, -5.0, 15.0, 29.0, 3.0)
    );


    public AngelBlock(Settings settings) {
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
