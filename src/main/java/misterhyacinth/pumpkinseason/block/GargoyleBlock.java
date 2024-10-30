package misterhyacinth.pumpkinseason.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class GargoyleBlock extends AbstractGraveyardDecorBlock {

    protected static final VoxelShape NORTH_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 3.0, 15.0),

            Block.createCuboidShape(3.0, 3.0, 5.0, 13.0, 18.0, 11.0),
            Block.createCuboidShape(3.0, 3.0, 11.0, 13.0, 12.0, 15.0),

            Block.createCuboidShape(-2.5, 7.0, 12.5, 18.5, 14.0, 16.5),
            Block.createCuboidShape(-2.5, 11.5, 10.5, 18.5, 18.5, 14.5),
            Block.createCuboidShape(-2.5, 16.0, 8.5, 18.5, 23.0, 12.5),

            Block.createCuboidShape(4.5, 17.0, 3.0, 11.5, 24.0, 9.0),
            Block.createCuboidShape(5.5, 17.0, 0.0, 10.5, 20.0, 3.0)
    );
    protected static final VoxelShape EAST_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 3.0, 15.0),

            Block.createCuboidShape(5.0, 3.0, 3.0, 11.0, 18.0, 13.0),
            Block.createCuboidShape(1.0, 3.0, 3.0, 5.0, 12.0, 13.0),

            Block.createCuboidShape(-0.5, 7.0, -2.5, 3.5, 14.0, 18.5),
            Block.createCuboidShape(1.5, 11.5, -2.5, 5.5, 18.5, 18.5),
            Block.createCuboidShape(3.5, 16.0, -2.5, 7.5, 23.0, 18.5),

            Block.createCuboidShape(7.0, 17.0, 4.5, 13.0, 24.0, 11.5),
            Block.createCuboidShape(13.0, 17.0, 5.5, 16.0, 20.0, 10.5)
    );
    protected static final VoxelShape SOUTH_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 3.0, 15.0),

            Block.createCuboidShape(3.0, 3.0, 5.0, 13.0, 18.0, 11.0),
            Block.createCuboidShape(3.0, 3.0, 1.0, 13.0, 12.0, 5.0),

            Block.createCuboidShape(-2.5, 7.0, -0.5, 18.5, 14.0, 3.5),
            Block.createCuboidShape(-2.5, 11.5, 1.5, 18.5, 18.5, 5.5),
            Block.createCuboidShape(-2.5, 16.0, 3.5, 18.5, 23.0, 7.5),

            Block.createCuboidShape(4.5, 17.0, 7.0, 11.5, 24.0, 13.0),
            Block.createCuboidShape(5.5, 17.0, 13.0, 10.5, 20.0, 16.0)
    );
    protected static final VoxelShape WEST_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 3.0, 15.0),

            Block.createCuboidShape(5.0, 3.0, 3.0, 11.0, 18.0, 13.0),
            Block.createCuboidShape(11.0, 3.0, 3.0, 15.0, 12.0, 13.0),

            Block.createCuboidShape(12.5, 7.0, -2.5, 16.5, 14.0, 18.5),
            Block.createCuboidShape(10.5, 11.5, -2.5, 14.5, 18.5, 18.5),
            Block.createCuboidShape(8.5, 16.0, -2.5, 12.5, 23.0, 18.5),

            Block.createCuboidShape(3.0, 17.0, 4.5, 9.0, 24.0, 11.5),
            Block.createCuboidShape(0.0, 17.0, 5.5, 3.0, 20.0, 10.5)
    );


    public GargoyleBlock(Settings settings) {
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
