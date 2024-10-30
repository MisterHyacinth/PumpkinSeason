package misterhyacinth.pumpkinseason.block;

import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class SquashShapes {

    public static VoxelShape BUTTERNUT_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 7.0, 14.0),
            Block.createCuboidShape(3.0, 7.0, 3.0, 13.0, 16.0, 13.0));

    public static VoxelShape GHOST_SHAPE =
            Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 11.0, 14.0);

    public static VoxelShape KABOCHA_SHAPE =
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 12.0, 16.0);

    public static VoxelShape MINI_SHAPE =
            Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 9.0, 13.0);

    public static VoxelShape SUGAR_SHAPE =
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 8.0, 16.0);


    public static VoxelShape ONE_TINY_PUMPKIN_SHAPE =
            Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 5.0, 11.0);


    public static VoxelShape TWO_TINY_PUMPKINS_NORTH_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(8.0, 0.0, 5.0, 14.0, 5.0, 11.0),
            Block.createCuboidShape(2.0, 0.0, 5.5, 7.0, 8.0, 10.5));

    public static VoxelShape TWO_TINY_PUMPKINS_EAST_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(5.0, 0.0, 8.0, 11.0, 5.0, 14.0),
            Block.createCuboidShape(5.5, 0.0, 2.0, 10.5, 8.0, 7.0));

    public static VoxelShape TWO_TINY_PUMPKINS_SOUTH_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(2.0, 0.0, 5.0, 8.0, 5.0, 11.0),
            Block.createCuboidShape(9.0, 0.0, 5.5, 14.0, 8.0, 10.5));

    public static VoxelShape TWO_TINY_PUMPKINS_WEST_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(5.0, 0.0, 2.0, 11.0, 5.0, 8.0),
            Block.createCuboidShape(5.5, 0.0, 9.0, 10.5, 8.0, 14.0));


    public static VoxelShape THREE_TINY_PUMPKINS_NORTH_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(9.5, 0.0, 2.0, 15.5, 5.0, 8.0),
            Block.createCuboidShape(5.0, 0.0, 8.5, 10.0, 8.0, 13.5),
            Block.createCuboidShape(0.5, 0.0, 2.0, 5.5, 6.0, 7.0));

    public static VoxelShape THREE_TINY_PUMPKINS_EAST_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(8.0, 0.0, 9.5, 14.0, 5.0, 15.5),
            Block.createCuboidShape(2.5, 0.0, 5.0, 7.5, 8.0, 10.0),
            Block.createCuboidShape(9.0, 0.0, 0.5, 14.0, 6.0, 5.5));

    public static VoxelShape THREE_TINY_PUMPKINS_SOUTH_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(0.5, 0.0, 8.0, 6.5, 5.0, 14.0),
            Block.createCuboidShape(6.0, 0.0, 2.5, 11.0, 8.0, 7.5),
            Block.createCuboidShape(10.5, 0.0, 9.0, 15.5, 6.0, 14.0));

    public static VoxelShape THREE_TINY_PUMPKINS_WEST_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(2.0, 0.0, 0.5, 8.0, 5.0, 6.5),
            Block.createCuboidShape(8.5, 0.0, 6.0, 13.5, 8.0, 11.0),
            Block.createCuboidShape(2.0, 0.0, 10.5, 7.0, 6.0, 15.5));



    public static VoxelShape FOUR_TINY_PUMPKINS_NORTH_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(10.0, 0.0, 4.0, 16.0, 5.0, 10.0),
            Block.createCuboidShape(6.0, 0.0, 11.0, 11.0, 8.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 6.0, 5.0, 6.0, 11.0),
            Block.createCuboidShape(4.5, 0.0, 0.0, 9.5, 4.0, 5.0));

    public static VoxelShape FOUR_TINY_PUMPKINS_EAST_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(6.0, 0.0, 10.0, 12.0, 5.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 6.0, 5.0, 8.0, 11.0),
            Block.createCuboidShape(5.0, 0.0, 0.0, 10.0, 6.0, 5.0),
            Block.createCuboidShape(11.0, 0.0, 4.5, 16.0, 4.0, 9.5));

    public static VoxelShape FOUR_TINY_PUMPKINS_SOUTH_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(0.0, 0.0, 6.0, 6.0, 5.0, 12.0),
            Block.createCuboidShape(5.0, 0.0, 0.0, 10.0, 8.0, 5.0),
            Block.createCuboidShape(11.0, 0.0, 5.0, 16.0, 6.0, 10.0),
            Block.createCuboidShape(6.5, 0.0, 11.0, 11.5, 4.0, 16.0));

    public static VoxelShape FOUR_TINY_PUMPKINS_WEST_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(4.0, 0.0, 0.0, 10.0, 5.0, 6.0),
            Block.createCuboidShape(11.0, 0.0, 5.0, 16.0, 8.0, 10.0),
            Block.createCuboidShape(6.0, 0.0, 11.0, 11.0, 6.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 6.5, 5.0, 4.0, 11.5));


}
