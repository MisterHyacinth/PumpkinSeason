package misterhyacinth.pumpkinseason.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;

public class PieBlock extends Block {


    public static final IntProperty BITES = IntProperty.of("bites", 0, 4);

    protected static final VoxelShape FULL_SHAPE =
            Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 5.0, 15.0);
    protected static final VoxelShape TIN_SHAPE =
            Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 3.0, 15.0);
    protected static final VoxelShape NW_SLICE_SHAPE =
            Block.createCuboidShape(1.0, 3.0, 1.0, 8.0, 5.0, 8.0);
    protected static final VoxelShape NE_SLICE_SHAPE =
            Block.createCuboidShape(1.0, 3.0, 8.0, 8.0, 5.0, 15.0);
    protected static final VoxelShape SW_SLICE_SHAPE =
            Block.createCuboidShape(8.0, 3.0, 1.0, 15.0, 5.0, 8.0);
    protected static final VoxelShape SE_SLICE_SHAPE =
            Block.createCuboidShape(8.0, 3.0, 8.0, 15.0, 5.0, 15.0);



    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;


    public PieBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(BITES, 0)
                .with(FACING, Direction.NORTH));
    }


    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        int bites = state.get(BITES);
        Direction facing = state.get(FACING);
        if (bites == 0) {
            return FULL_SHAPE;
        } else if(bites == 4) {
            return TIN_SHAPE;
        } else {
            VoxelShape PIE_SHAPE = TIN_SHAPE;

            if (facing == Direction.SOUTH) {
                PIE_SHAPE = VoxelShapes.union(PIE_SHAPE, NW_SLICE_SHAPE);
                if(bites == 1) {
                    PIE_SHAPE = VoxelShapes.union(PIE_SHAPE, SW_SLICE_SHAPE);
                }
                if(bites < 3){
                    PIE_SHAPE = VoxelShapes.union(PIE_SHAPE, NE_SLICE_SHAPE);
                }
            } else if (facing == Direction.EAST) {
                PIE_SHAPE = VoxelShapes.union(PIE_SHAPE, NE_SLICE_SHAPE);
                if(bites == 1) {
                    PIE_SHAPE = VoxelShapes.union(PIE_SHAPE, NW_SLICE_SHAPE);
                }
                if(bites < 3){
                    PIE_SHAPE = VoxelShapes.union(PIE_SHAPE, SE_SLICE_SHAPE);
                }
            } else if (facing == Direction.NORTH) {
                PIE_SHAPE = VoxelShapes.union(PIE_SHAPE, SE_SLICE_SHAPE);
                if(bites == 1) {
                    PIE_SHAPE = VoxelShapes.union(PIE_SHAPE, NE_SLICE_SHAPE);
                }
                if(bites < 3){
                    PIE_SHAPE = VoxelShapes.union(PIE_SHAPE, SW_SLICE_SHAPE);
                }
            } else if (facing == Direction.WEST ) {
                PIE_SHAPE = VoxelShapes.union(PIE_SHAPE, SW_SLICE_SHAPE);
                if(bites == 1) {
                    PIE_SHAPE = VoxelShapes.union(PIE_SHAPE, SE_SLICE_SHAPE);
                }
                if(bites < 3){
                    PIE_SHAPE = VoxelShapes.union(PIE_SHAPE, NW_SLICE_SHAPE);
                }
            }

            return PIE_SHAPE;
        }
    }


    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
                .with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING,rotation.rotate(state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) {
            if (tryEat(world, pos, state, player).isAccepted()) {
                return ActionResult.SUCCESS;
            }

            if (player.getStackInHand(Hand.MAIN_HAND).isEmpty()) {
                return ActionResult.CONSUME;
            }
        }

        return tryEat(world, pos, state, player);
    }

    protected static ActionResult tryEat(WorldAccess world, BlockPos pos, BlockState state, PlayerEntity player) {

        int i = state.get(BITES);
        if (i < 4) {
            if (!player.canConsume(false)) {
                return ActionResult.PASS;
            } else {
                world.emitGameEvent(player, GameEvent.EAT, pos);
                player.getHungerManager().add(2, 0.1F);
                world.setBlockState(pos, state.with(BITES, i + 1), 3);
                return ActionResult.SUCCESS;
            }
        } else {
            world.removeBlock(pos, false);
            world.emitGameEvent(player, GameEvent.BLOCK_DESTROY, pos);
            ItemEntity itemEntity =
                    new ItemEntity(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(),
                            new ItemStack(Items.BOWL, 1));
            world.spawnEntity(itemEntity);
            return ActionResult.SUCCESS;
        }
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState()
                : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }



    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isSolid();
    }


    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(BITES, FACING);
    }

    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return getComparatorOutput(state.get(BITES));
    }

    public static int getComparatorOutput(int bites) {
        return (5 - bites) * 2;
    }

    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }





}
