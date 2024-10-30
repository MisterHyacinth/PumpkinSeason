package misterhyacinth.pumpkinseason.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class ObeliskGravestoneBlock extends AbstractGraveyardDecorBlock {

    protected static final VoxelShape NORTH_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(3.0, 0.0, 6.0, 13.0, 2.0, 16.0),
            Block.createCuboidShape(4.0, 2.0, 7.0, 12.0, 4.0, 15.0),
            Block.createCuboidShape(5.0, 4.0, 8.0, 11.0, 20.0, 14.0),
            Block.createCuboidShape(6.0, 20.0, 9.0, 10.0, 22.0, 13.0),
            Block.createCuboidShape(7.0, 22.0, 10.0, 9.0, 23.0, 12.0)
    );
    protected static final VoxelShape EAST_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(0.0, 0.0, 3.0, 10.0, 2.0, 13.0),
            Block.createCuboidShape(1.0, 2.0, 4.0, 9.0, 4.0, 12.0),
            Block.createCuboidShape(2.0, 4.0, 5.0, 8.0, 20.0, 11.0),
            Block.createCuboidShape(3.0, 20.0, 6.0, 7.0, 22.0, 10.0),
            Block.createCuboidShape(4.0, 22.0, 7.0, 6.0, 23.0, 9.0)
    );
    protected static final VoxelShape SOUTH_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(3.0, 0.0, 0.0, 13.0, 2.0, 10.0),
            Block.createCuboidShape(4.0, 2.0, 1.0, 12.0, 4.0, 9.0),
            Block.createCuboidShape(5.0, 4.0, 2.0, 11.0, 20.0, 8.0),
            Block.createCuboidShape(6.0, 20.0, 3.0, 10.0, 22.0, 7.0),
            Block.createCuboidShape(7.0, 22.0, 4.0, 9.0, 23.0, 6.0)
    );
    protected static final VoxelShape WEST_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(6.0, 0.0, 3.0, 16.0, 2.0, 13.0),
            Block.createCuboidShape(7.0, 2.0, 4.0, 15.0, 4.0, 12.0),
            Block.createCuboidShape(8.0, 4.0, 5.0, 14.0, 20.0, 11.0),
            Block.createCuboidShape(9.0, 20.0, 6.0, 13.0, 22.0, 10.0),
            Block.createCuboidShape(10.0, 22.0, 7.0, 12.0, 23.0, 9.0)
    );


    public ObeliskGravestoneBlock(Settings settings) {
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
