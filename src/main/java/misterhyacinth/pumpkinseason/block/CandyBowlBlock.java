package misterhyacinth.pumpkinseason.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
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

public class CandyBowlBlock extends Block {

    public static final IntProperty BITES = IntProperty.of("bites", 0, 4);

    protected static final VoxelShape SHAPE = VoxelShapes.union(
            Block.createCuboidShape(1.0, 2.0, 1.0, 15.0, 8.0, 15.0),
            Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 2.0, 13.0)
    );


    public CandyBowlBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(BITES, 0));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(BITES);
    }


    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
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

                if (!world.isClient()) {
                    int randomInt = world.getRandom().nextInt(5);
                    RegistryEntry<StatusEffect> randomEffect;
                    if (randomInt == 1) {
                        randomEffect = StatusEffects.INVISIBILITY;
                    } else if (randomInt == 2) {
                        randomEffect = StatusEffects.SPEED;
                    } else if (randomInt == 3) {
                        randomEffect = StatusEffects.NIGHT_VISION;
                    } else if (randomInt == 4) {
                        randomEffect = StatusEffects.REGENERATION;
                    } else {
                        randomEffect = StatusEffects.JUMP_BOOST;
                    }

                    player.addStatusEffect(new StatusEffectInstance(randomEffect, 300, 0));
                }

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
