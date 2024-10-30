package misterhyacinth.pumpkinseason.mixin;

import misterhyacinth.pumpkinseason.util.PumpkinItemTags;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EndermanEntity.class)
public class EndermanEntityMixin {

    @Inject(at = @At("HEAD"), method = "isPlayerStaring", cancellable = true)
    void isPlayerStaring(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        ItemStack itemStack = player.getInventory().armor.get(3);
        if (itemStack.isIn(PumpkinItemTags.CARVED_SQUASH)) {
            cir.setReturnValue(false);
        }
    }
}
