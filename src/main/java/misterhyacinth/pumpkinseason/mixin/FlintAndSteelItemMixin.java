package misterhyacinth.pumpkinseason.mixin;

import misterhyacinth.pumpkinseason.block.PumpkinCandleCakeBlock;
import misterhyacinth.pumpkinseason.block.SpookyCandleBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FlintAndSteelItem.class)
public class FlintAndSteelItemMixin {


    @Inject(at = @At("TAIL"), method = "useOnBlock", cancellable = true)
    public final void makeSpookyCandlesLightable(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir){
        PlayerEntity playerEntity = context.getPlayer();
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        if (SpookyCandleBlock.canBeLit(blockState) || PumpkinCandleCakeBlock.canBeLit(blockState)) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_FLINTANDSTEEL_USE,
                    SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.4F + 0.8F);
            world.setBlockState(blockPos, blockState.with(Properties.LIT, true), 11);
            world.emitGameEvent(playerEntity, GameEvent.BLOCK_CHANGE, blockPos);
            if (playerEntity != null) {
                context.getStack().damage(1, playerEntity, LivingEntity.getSlotForHand(context.getHand()));
            }
            cir.setReturnValue(ActionResult.success(world.isClient()));
        }

    }


}
