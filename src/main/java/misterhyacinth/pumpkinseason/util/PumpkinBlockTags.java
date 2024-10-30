package misterhyacinth.pumpkinseason.util;

import misterhyacinth.pumpkinseason.PumpkinSeason;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class PumpkinBlockTags {

    public static final TagKey<Block> SWORD_ALWAYS_DROPS = createCommonTag("sword_always_drops");

    public static final TagKey<Block> SHEARS_ALWAYS_DROP = createCommonTag("shears_always_drop");
    public static final TagKey<Block> SHEARS_SPEED_15 = createCommonTag("shears_speed_15");
    public static final TagKey<Block> SHEARS_SPEED_5 = createCommonTag("shears_speed_5");
    public static final TagKey<Block> SHEARS_SPEED_2 = createCommonTag("shears_speed_2");
    public static final TagKey<Block> SHEARS_POST_MINE = createCommonTag("shears_post_mine");


    public static final TagKey<Block> SPOOKY_CANDLES = createTag("spooky_candles");
    public static final TagKey<Block> PUMPKIN_CANDLE_CAKES = createTag("pumpkin_candle_cakes");
    public static final TagKey<Block> STEMS = createTag("stems");
    public static final TagKey<Block> ATTACHED_STEMS = createTag("attached_stems");
    public static final TagKey<Block> SQUASH = createTag("squash");
    public static final TagKey<Block> CARVED_SQUASH = createTag("carved_squash");
    public static final TagKey<Block> JACK_O_LANTERNS = createTag("jack_o_lanterns");
    public static final TagKey<Block> SOUL_JACK_O_LANTERNS = createTag("soul_jack_o_lanterns");
    public static final TagKey<Block> EERIE_JACK_O_LANTERNS = createTag("eerie_jack_o_lanterns");


    private static TagKey<Block> createTag(String name) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(PumpkinSeason.MOD_ID, name));
    }
    private static TagKey<Block> createCommonTag(String name) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", name));
    }



}
