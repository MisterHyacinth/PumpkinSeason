package misterhyacinth.pumpkinseason.mixin;

import misterhyacinth.pumpkinseason.util.PumpkinBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.block.HorizontalFacingBlock;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.function.Predicate;

@Mixin(CarvedPumpkinBlock.class)
public class CarvedPumpkinBlockMixin {


    @Shadow @Final private static final Predicate<BlockState> IS_GOLEM_HEAD_PREDICATE = (state) -> {
        return state != null && (state.isOf(Blocks.CARVED_PUMPKIN) || state.isOf(Blocks.JACK_O_LANTERN)
                || state.isIn(PumpkinBlockTags.CARVED_SQUASH)
                || state.isIn(PumpkinBlockTags.JACK_O_LANTERNS)
                || state.isIn(PumpkinBlockTags.SOUL_JACK_O_LANTERNS)
                || state.isIn(PumpkinBlockTags.EERIE_JACK_O_LANTERNS));
    };


}
