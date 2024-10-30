package misterhyacinth.pumpkinseason.mixin;

import misterhyacinth.pumpkinseason.util.PumpkinBlockTags;
import net.minecraft.block.Blocks;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.tag.BlockTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(SwordItem.class)
public class SwordItemMixin {

    // exempt from any license restrictions -
    // please re-use this freely (with your own registrations of the same common tags)
    // until fabric implements something similar again

    @Inject(at = @At("HEAD"), method = "createToolComponent", cancellable = true)
    private static void createToolComponent(CallbackInfoReturnable<ToolComponent> cir) {
        cir.setReturnValue(
                new ToolComponent(List.of(
                        ToolComponent.Rule.ofAlwaysDropping(PumpkinBlockTags.SWORD_ALWAYS_DROPS, 15.0F),
                        ToolComponent.Rule.of(BlockTags.SWORD_EFFICIENT, 1.5F)), 1.0F, 2)
        );

    }

}
