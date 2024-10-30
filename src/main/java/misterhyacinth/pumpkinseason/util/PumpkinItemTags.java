package misterhyacinth.pumpkinseason.util;

import misterhyacinth.pumpkinseason.PumpkinSeason;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class PumpkinItemTags {

    public static final TagKey<Item> CARVED_SQUASH = createTag("carved_squash");
    public static final TagKey<Item> RAW_PUMPKIN_SEEDS = createTag("raw_pumpkin_seeds");
    public static final TagKey<Item> PUMPKINS = createTag("pumpkins");
    public static final TagKey<Item> SPOOKY_CANDLES = createTag("spooky_candles");

    public static final TagKey<Item> BIRD_SEED = createTag("bird_seed");
    public static final TagKey<Item> SEEDS = createCommonTag("seeds");
    public static final TagKey<Item> CANDY = createCommonTag("candy");

    private static TagKey<Item> createTag(String name) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(PumpkinSeason.MOD_ID, name));
    }
    private static TagKey<Item> createCommonTag(String name) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of("c", name));
    }



}
