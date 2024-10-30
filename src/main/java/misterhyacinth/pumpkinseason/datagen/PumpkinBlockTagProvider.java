package misterhyacinth.pumpkinseason.datagen;

import misterhyacinth.pumpkinseason.PumpkinRegistry;
import misterhyacinth.pumpkinseason.util.PumpkinBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class PumpkinBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public PumpkinBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(PumpkinBlockTags.PUMPKIN_CANDLE_CAKES)
                .add(PumpkinRegistry.SKULL_CANDLE_PUMPKIN_CAKE)
                .add(PumpkinRegistry.SKULL_CANDLE_BOOBERRY_PUMPKIN_CAKE)
                .add(PumpkinRegistry.SKULL_CANDLE_DARK_CHOCOLATE_PUMPKIN_CAKE)
                .add(PumpkinRegistry.BAT_CANDLE_PUMPKIN_CAKE)
                .add(PumpkinRegistry.BAT_CANDLE_BOOBERRY_PUMPKIN_CAKE)
                .add(PumpkinRegistry.BAT_CANDLE_DARK_CHOCOLATE_PUMPKIN_CAKE)
                .add(PumpkinRegistry.PUMPKIN_CANDLE_PUMPKIN_CAKE)
                .add(PumpkinRegistry.PUMPKIN_CANDLE_BOOBERRY_PUMPKIN_CAKE)
                .add(PumpkinRegistry.PUMPKIN_CANDLE_DARK_CHOCOLATE_PUMPKIN_CAKE)
                .add(PumpkinRegistry.CREEPY_PUMPKIN_CANDLE_PUMPKIN_CAKE)
                .add(PumpkinRegistry.CREEPY_PUMPKIN_CANDLE_BOOBERRY_PUMPKIN_CAKE)
                .add(PumpkinRegistry.CREEPY_PUMPKIN_CANDLE_DARK_CHOCOLATE_PUMPKIN_CAKE);

        getOrCreateTagBuilder(PumpkinBlockTags.SPOOKY_CANDLES)
                .add(PumpkinRegistry.BAT_CANDLE)
                .add(PumpkinRegistry.PUMPKIN_CANDLE)
                .add(PumpkinRegistry.CREEPY_PUMPKIN_CANDLE)
                .add(PumpkinRegistry.SKULL_CANDLE);

        getOrCreateTagBuilder(PumpkinBlockTags.SQUASH)
                .add(PumpkinRegistry.BUTTERNUT_SQUASH)
                .add(PumpkinRegistry.GHOST_PUMPKIN)
                .add(PumpkinRegistry.KABOCHA)
                .add(PumpkinRegistry.MIDNIGHT_PUMPKIN)
                .add(PumpkinRegistry.MINI_PUMPKIN)
                .add(PumpkinRegistry.SUGAR_PUMPKIN)
                .add(PumpkinRegistry.TINY_PUMPKIN);

        getOrCreateTagBuilder(PumpkinBlockTags.CARVED_SQUASH)
                .add(PumpkinRegistry.CARVED_BUTTERNUT_SQUASH)
                .add(PumpkinRegistry.CARVED_GHOST_PUMPKIN)
                .add(PumpkinRegistry.CARVED_KABOCHA)
                .add(PumpkinRegistry.CARVED_MIDNIGHT_PUMPKIN)
                .add(PumpkinRegistry.CARVED_MINI_PUMPKIN)
                .add(PumpkinRegistry.CARVED_SUGAR_PUMPKIN)
                .add(PumpkinRegistry.TINY_CARVED_PUMPKIN);

        getOrCreateTagBuilder(PumpkinBlockTags.JACK_O_LANTERNS)
                .add(PumpkinRegistry.BUTTERNUT_LANTERN)
                .add(PumpkinRegistry.GHOST_O_LANTERN)
                .add(PumpkinRegistry.KABOCHA_LANTERN)
                .add(PumpkinRegistry.MIDNIGHT_O_LANTERN)
                .add(PumpkinRegistry.MINI_JACK_O_LANTERN)
                .add(PumpkinRegistry.SUGAR_O_LANTERN)
                .add(PumpkinRegistry.TINY_JACK_O_LANTERN);

        getOrCreateTagBuilder(PumpkinBlockTags.SOUL_JACK_O_LANTERNS)
                .add(PumpkinRegistry.JACK_O_SOUL_LANTERN)
                .add(PumpkinRegistry.BUTTERNUT_SOUL_LANTERN)
                .add(PumpkinRegistry.GHOST_O_SOUL_LANTERN)
                .add(PumpkinRegistry.KABOCHA_SOUL_LANTERN)
                .add(PumpkinRegistry.MIDNIGHT_O_SOUL_LANTERN)
                .add(PumpkinRegistry.MINI_JACK_O_SOUL_LANTERN)
                .add(PumpkinRegistry.SUGAR_O_SOUL_LANTERN)
                .add(PumpkinRegistry.TINY_JACK_O_SOUL_LANTERN);

        getOrCreateTagBuilder(PumpkinBlockTags.EERIE_JACK_O_LANTERNS)
                .add(PumpkinRegistry.EERIE_JACK_O_LANTERN)
                .add(PumpkinRegistry.EERIE_BUTTERNUT_LANTERN)
                .add(PumpkinRegistry.EERIE_GHOST_O_LANTERN)
                .add(PumpkinRegistry.EERIE_KABOCHA_LANTERN)
                .add(PumpkinRegistry.EERIE_MIDNIGHT_O_LANTERN)
                .add(PumpkinRegistry.EERIE_MINI_JACK_O_LANTERN)
                .add(PumpkinRegistry.EERIE_SUGAR_O_LANTERN)
                .add(PumpkinRegistry.TINY_EERIE_JACK_O_LANTERN);

        getOrCreateTagBuilder(PumpkinBlockTags.STEMS)
                .add(PumpkinRegistry.BUTTERNUT_STEM)
                .add(PumpkinRegistry.GHOST_PUMPKIN_STEM)
                .add(PumpkinRegistry.KABOCHA_STEM)
                .add(PumpkinRegistry.MIDNIGHT_PUMPKIN_STEM)
                .add(PumpkinRegistry.MINI_PUMPKIN_STEM)
                .add(PumpkinRegistry.SUGAR_PUMPKIN_STEM)
                .add(PumpkinRegistry.TINY_PUMPKIN_STEM);

        getOrCreateTagBuilder(PumpkinBlockTags.ATTACHED_STEMS)
                .add(PumpkinRegistry.ATTACHED_BUTTERNUT_STEM)
                .add(PumpkinRegistry.ATTACHED_GHOST_PUMPKIN_STEM)
                .add(PumpkinRegistry.ATTACHED_KABOCHA_STEM)
                .add(PumpkinRegistry.ATTACHED_MIDNIGHT_PUMPKIN_STEM)
                .add(PumpkinRegistry.ATTACHED_MINI_PUMPKIN_STEM)
                .add(PumpkinRegistry.ATTACHED_SUGAR_PUMPKIN_STEM)
                .add(PumpkinRegistry.ATTACHED_TINY_PUMPKIN_STEM);



        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(PumpkinRegistry.SKULL_LANTERN)
                .add(PumpkinRegistry.WITHER_SKULL_LANTERN)
                .add(PumpkinRegistry.BAT_LANTERN)
                .add(PumpkinRegistry.SPIDER_LANTERN)
                .add(PumpkinRegistry.PUMPKIN_LANTERN)
                .add(PumpkinRegistry.CREEPY_PUMPKIN_LANTERN)
                .add(PumpkinRegistry.GHASTLY_LANTERN)
                .add(PumpkinRegistry.CRESCENT_MOON_LANTERN)
                .add(PumpkinRegistry.BLACK_CAT_LANTERN)

                .add(PumpkinRegistry.STONE_GARGOYLE)
                .add(PumpkinRegistry.BLACKSTONE_GARGOYLE)
                .add(PumpkinRegistry.EERIE_STONE_GARGOYLE)
                .add(PumpkinRegistry.EERIE_BLACKSTONE_GARGOYLE)

                .add(PumpkinRegistry.STONE_ANGEL)
                .add(PumpkinRegistry.BLACKSTONE_ANGEL)
                .add(PumpkinRegistry.EERIE_STONE_ANGEL)
                .add(PumpkinRegistry.EERIE_BLACKSTONE_ANGEL)

                .add(PumpkinRegistry.STONE_GRAVE_MARKER)
                .add(PumpkinRegistry.BLACKSTONE_GRAVE_MARKER)
                .add(PumpkinRegistry.EERIE_STONE_GRAVE_MARKER)
                .add(PumpkinRegistry.EERIE_BLACKSTONE_GRAVE_MARKER)

                .add(PumpkinRegistry.STONE_CROSS_GRAVE_MARKER)
                .add(PumpkinRegistry.BLACKSTONE_CROSS_GRAVE_MARKER)
                .add(PumpkinRegistry.STONE_OBELISK_GRAVE_MARKER)
                .add(PumpkinRegistry.BLACKSTONE_OBELISK_GRAVE_MARKER)

                .add(PumpkinRegistry.ENGRAVED_STONE)
                .add(PumpkinRegistry.MOSSY_ENGRAVED_STONE)
                .add(PumpkinRegistry.ENGRAVED_BLACKSTONE)

                .add(PumpkinRegistry.ENGRAVED_STONE_STAIRS)
                .add(PumpkinRegistry.MOSSY_ENGRAVED_STONE_STAIRS)
                .add(PumpkinRegistry.ENGRAVED_BLACKSTONE_STAIRS)

                .add(PumpkinRegistry.ENGRAVED_STONE_SLAB)
                .add(PumpkinRegistry.MOSSY_ENGRAVED_STONE_SLAB)
                .add(PumpkinRegistry.ENGRAVED_BLACKSTONE_SLAB)

                .add(PumpkinRegistry.ENGRAVED_STONE_PILLAR)
                .add(PumpkinRegistry.MOSSY_ENGRAVED_STONE_PILLAR)
                .add(PumpkinRegistry.ENGRAVED_BLACKSTONE_PILLAR)

                .add(PumpkinRegistry.ENGRAVED_STONE_PILLAR_CAP)
                .add(PumpkinRegistry.MOSSY_ENGRAVED_STONE_PILLAR_CAP)
                .add(PumpkinRegistry.ENGRAVED_BLACKSTONE_PILLAR_CAP);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(PumpkinRegistry.ENGRAVED_STONE_STAIRS)
                .add(PumpkinRegistry.MOSSY_ENGRAVED_STONE_STAIRS)
                .add(PumpkinRegistry.ENGRAVED_BLACKSTONE_STAIRS);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(PumpkinRegistry.ENGRAVED_STONE_SLAB)
                .add(PumpkinRegistry.MOSSY_ENGRAVED_STONE_SLAB)
                .add(PumpkinRegistry.ENGRAVED_BLACKSTONE_SLAB);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(PumpkinRegistry.ENGRAVED_STONE_SLAB)
                .add(PumpkinRegistry.MOSSY_ENGRAVED_STONE_SLAB)
                .add(PumpkinRegistry.ENGRAVED_BLACKSTONE_SLAB);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(PumpkinRegistry.ENGRAVED_STONE_WALL)
                .add(PumpkinRegistry.MOSSY_ENGRAVED_STONE_WALL)
                .add(PumpkinRegistry.ENGRAVED_BLACKSTONE_WALL);


        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .addTag(PumpkinBlockTags.SQUASH)
                .addTag(PumpkinBlockTags.CARVED_SQUASH)
                .addTag(PumpkinBlockTags.JACK_O_LANTERNS)
                .addTag(PumpkinBlockTags.SOUL_JACK_O_LANTERNS)
                .addTag(PumpkinBlockTags.EERIE_JACK_O_LANTERNS)
                .addTag(PumpkinBlockTags.STEMS)
                .addTag(PumpkinBlockTags.ATTACHED_STEMS)
                .add(PumpkinRegistry.BOOBERRY_BUSH);

        getOrCreateTagBuilder(BlockTags.CROPS)
                .addTag(PumpkinBlockTags.STEMS);

        getOrCreateTagBuilder(BlockTags.SWORD_EFFICIENT)
                .add(PumpkinRegistry.BOOBERRY_BUSH);

        getOrCreateTagBuilder(PumpkinBlockTags.SWORD_ALWAYS_DROPS)
                .add(Blocks.COBWEB)
                .add(PumpkinRegistry.GLOW_IN_THE_DARK_COBWEB)
                .add(PumpkinRegistry.GREEN_COBWEB)
                .add(PumpkinRegistry.ORANGE_COBWEB)
                .add(PumpkinRegistry.PURPLE_COBWEB);

        getOrCreateTagBuilder(PumpkinBlockTags.SHEARS_ALWAYS_DROP)
                .add(Blocks.COBWEB)
                .add(PumpkinRegistry.GLOW_IN_THE_DARK_COBWEB)
                .add(PumpkinRegistry.GREEN_COBWEB)
                .add(PumpkinRegistry.ORANGE_COBWEB)
                .add(PumpkinRegistry.PURPLE_COBWEB);

        getOrCreateTagBuilder(BlockTags.LEAVES);
        getOrCreateTagBuilder(PumpkinBlockTags.SHEARS_SPEED_15)
                .addTag(BlockTags.LEAVES);

        getOrCreateTagBuilder(BlockTags.WOOL);
        getOrCreateTagBuilder(PumpkinBlockTags.SHEARS_SPEED_5)
                .addTag(BlockTags.WOOL);

        getOrCreateTagBuilder(PumpkinBlockTags.SHEARS_SPEED_2)
                .add(Blocks.VINE)
                .add(Blocks.GLOW_LICHEN);

        getOrCreateTagBuilder(PumpkinBlockTags.SHEARS_POST_MINE)
                .addTag(BlockTags.LEAVES)
                .addTag(BlockTags.WOOL)
                .add(Blocks.COBWEB)
                .add(PumpkinRegistry.GLOW_IN_THE_DARK_COBWEB)
                .add(PumpkinRegistry.GREEN_COBWEB)
                .add(PumpkinRegistry.ORANGE_COBWEB)
                .add(PumpkinRegistry.PURPLE_COBWEB)
                .add(Blocks.SHORT_GRASS)
                .add(Blocks.FERN)
                .add(Blocks.DEAD_BUSH)
                .add(Blocks.HANGING_ROOTS)
                .add(Blocks.VINE)
                .add(Blocks.TRIPWIRE);

        getOrCreateTagBuilder(BlockTags.FALL_DAMAGE_RESETTING)
                .add(PumpkinRegistry.BOOBERRY_BUSH)
                .add(PumpkinRegistry.GLOW_IN_THE_DARK_COBWEB)
                .add(PumpkinRegistry.GREEN_COBWEB)
                .add(PumpkinRegistry.ORANGE_COBWEB)
                .add(PumpkinRegistry.PURPLE_COBWEB);

        getOrCreateTagBuilder(BlockTags.MAINTAINS_FARMLAND)
                .addTag(PumpkinBlockTags.STEMS)
                .addTag(PumpkinBlockTags.ATTACHED_STEMS);

        getOrCreateTagBuilder(BlockTags.PIGLIN_REPELLENTS)
                .addTag(PumpkinBlockTags.SOUL_JACK_O_LANTERNS)
                .add(PumpkinRegistry.WITHER_SKULL_LANTERN);

    }
}
