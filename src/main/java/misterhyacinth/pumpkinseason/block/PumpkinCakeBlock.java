package misterhyacinth.pumpkinseason.block;

import misterhyacinth.pumpkinseason.util.PumpkinItemTags;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;

public class PumpkinCakeBlock extends CakeBlock {
    public PumpkinCakeBlock(Settings settings) {
        super(settings);
    }


    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos,
                                             PlayerEntity player, Hand hand, BlockHitResult hit) {
        Item item = stack.getItem();
        if (stack.isIn(PumpkinItemTags.SPOOKY_CANDLES) && state.get(BITES) == 0) {
            Block block = Block.getBlockFromItem(item);
            if (block instanceof SpookyCandleBlock candleBlock) {
                stack.decrementUnlessCreative(1, player);
                world.playSound(null, pos, SoundEvents.BLOCK_CAKE_ADD_CANDLE,
                        SoundCategory.BLOCKS, 1.0F, 1.0F);
                world.setBlockState(pos, PumpkinCandleCakeBlock.getCandleCake(candleBlock, this)
                        .with(PumpkinCandleCakeBlock.FACING, player.getHorizontalFacing().getOpposite()));
                world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                player.incrementStat(Stats.USED.getOrCreateStat(item));
                return ItemActionResult.SUCCESS;
            }
        }

        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }


    public static ActionResult tryEat(WorldAccess world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!player.canConsume(false)) {
            return ActionResult.PASS;
        } else {
            player.incrementStat(Stats.EAT_CAKE_SLICE);
            player.getHungerManager().add(2, 0.1F);
            int i = state.get(BITES);
            world.emitGameEvent(player, GameEvent.EAT, pos);
            if (i < 6) {
                world.setBlockState(pos, state.with(BITES, i + 1), 3);
            } else {
                world.removeBlock(pos, false);
                world.emitGameEvent(player, GameEvent.BLOCK_DESTROY, pos);
            }

            return ActionResult.SUCCESS;
        }
    }


}
