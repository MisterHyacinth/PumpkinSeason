package misterhyacinth.pumpkinseason.mixin.client;

import misterhyacinth.pumpkinseason.PumpkinRegistry;
import misterhyacinth.pumpkinseason.PumpkinSeasonClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {

    @Shadow protected abstract void renderVignetteOverlay(DrawContext context, @Nullable Entity entity);

    @Shadow @Final private MinecraftClient client;



    @Shadow protected abstract void renderOverlay(DrawContext context, Identifier texture, float opacity);

    @Inject(at = @At("HEAD"), method = "renderMiscOverlays")
    private void renderMiscOverlays(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        if (MinecraftClient.isFancyGraphicsOrBetter()) {
            this.renderVignetteOverlay(context, this.client.getCameraEntity());
        }

        if (this.client.options.getPerspective().isFirstPerson() && !this.client.player.isUsingSpyglass()) {
            ItemStack itemStack = this.client.player.getInventory().getArmorStack(3);
            Identifier pumpkinBlur = null;

            if (itemStack.isOf(PumpkinRegistry.CARVED_BUTTERNUT_SQUASH.asItem())) {
                pumpkinBlur = PumpkinSeasonClient.BUTTERNUT_BLUR;
            } else if (itemStack.isOf(PumpkinRegistry.CARVED_GHOST_PUMPKIN.asItem())) {
                pumpkinBlur = PumpkinSeasonClient.GHOST_PUMPKIN_BLUR;
            } else if (itemStack.isOf(PumpkinRegistry.CARVED_KABOCHA.asItem())) {
                pumpkinBlur = PumpkinSeasonClient.KABOCHA_BLUR;
            } else if (itemStack.isOf(PumpkinRegistry.CARVED_MIDNIGHT_PUMPKIN.asItem())) {
                pumpkinBlur = PumpkinSeasonClient.MIDNIGHT_PUMPKIN_BLUR;
            } else if (itemStack.isOf(PumpkinRegistry.CARVED_SUGAR_PUMPKIN.asItem())) {
                pumpkinBlur = PumpkinSeasonClient.SUGAR_PUMPKIN_BLUR;
            }


            if (pumpkinBlur != null) {
                this.renderOverlay(context, pumpkinBlur, 1.0F);
            }

        }


    }

}
