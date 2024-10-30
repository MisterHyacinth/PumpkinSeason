package misterhyacinth.pumpkinseason;

import misterhyacinth.pumpkinseason.block.*;
import misterhyacinth.pumpkinseason.item.PumpkinItemKeys;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.function.ToIntFunction;

public class PumpkinRegistry {

    private static final String MOD_ID = PumpkinSeason.MOD_ID;

    public static final Block JACK_O_SOUL_LANTERN = registerBlock("jack_o_soul_lantern",
            new CarvedPumpkinBlock(AbstractBlock.Settings.create().mapColor(MapColor.ORANGE)
                    .strength(1.0f)
                    .sounds(BlockSoundGroup.WOOD).luminance((state) -> { return 10; })));
    public static final Block EERIE_JACK_O_LANTERN = registerBlock("eerie_jack_o_lantern",
            new EerieJackOLanternBlock(AbstractBlock.Settings.create().mapColor(MapColor.ORANGE)
                    .strength(1.0f)
                    .sounds(BlockSoundGroup.WOOD).luminance((state) -> { return 8; })));


    //BUTTERNUT SQUASH==================================================================================================
    public static final Block BUTTERNUT_SQUASH =
            registerSquashBlock("butternut_squash", MapColor.GOLD, "butternut");
    public static final Block CARVED_BUTTERNUT_SQUASH =
            registerCarvedSquashBlock("carved_butternut_squash", MapColor.GOLD, "butternut");
    public static final Block BUTTERNUT_LANTERN =
            registerSquashLanternBlock("butternut_lantern", MapColor.GOLD, "butternut");
    public static final Block BUTTERNUT_SOUL_LANTERN =
            registerSquashSoulLanternBlock("butternut_soul_lantern", MapColor.GOLD, "butternut");
    public static final Block EERIE_BUTTERNUT_LANTERN =
            registerEerieSquashBlock("eerie_butternut_lantern", MapColor.GOLD, "butternut");

    public static final Block BUTTERNUT_STEM =
            registerSquashStem("butternut_stem", PumpkinBlockKeys.BUTTERNUT_SQUASH,
                    PumpkinBlockKeys.ATTACHED_BUTTERNUT_STEM,
                    PumpkinItemKeys.BUTTERNUT_SEEDS, MapColor.YELLOW);

    public static final Block ATTACHED_BUTTERNUT_STEM =
            registerAttachedSquashStem("attached_butternut_stem", PumpkinBlockKeys.BUTTERNUT_STEM,
                    PumpkinBlockKeys.BUTTERNUT_SQUASH, PumpkinItemKeys.BUTTERNUT_SEEDS, MapColor.YELLOW);

    //GHOST PUMPKINS====================================================================================================
    public static final Block GHOST_PUMPKIN =
            registerSquashBlock("ghost_pumpkin", MapColor.WHITE, "ghost");
    public static final Block CARVED_GHOST_PUMPKIN =
            registerCarvedSquashBlock("carved_ghost_pumpkin", MapColor.WHITE, "ghost");
    public static final Block GHOST_O_LANTERN =
            registerSquashLanternBlock("ghost_o_lantern", MapColor.WHITE, "ghost");
    public static final Block GHOST_O_SOUL_LANTERN =
            registerSquashSoulLanternBlock("ghost_o_soul_lantern", MapColor.WHITE, "ghost");
    public static final Block EERIE_GHOST_O_LANTERN =
            registerEerieSquashBlock("eerie_ghost_o_lantern", MapColor.WHITE, "ghost");


    public static final Block GHOST_PUMPKIN_STEM =
            registerSquashStem("ghost_pumpkin_stem", PumpkinBlockKeys.GHOST_PUMPKIN,
                    PumpkinBlockKeys.ATTACHED_GHOST_PUMPKIN_STEM,
                    PumpkinItemKeys.GHOST_PUMPKIN_SEEDS, MapColor.OFF_WHITE);

    public static final Block ATTACHED_GHOST_PUMPKIN_STEM =
            registerAttachedSquashStem("attached_ghost_pumpkin_stem", PumpkinBlockKeys.GHOST_PUMPKIN_STEM,
                    PumpkinBlockKeys.GHOST_PUMPKIN, PumpkinItemKeys.GHOST_PUMPKIN_SEEDS, MapColor.OFF_WHITE);



    //KABOCHA===========================================================================================================
    public static final Block KABOCHA =
            registerSquashBlock("kabocha", MapColor.EMERALD_GREEN, "kabocha");
    public static final Block CARVED_KABOCHA =
            registerCarvedSquashBlock("carved_kabocha", MapColor.EMERALD_GREEN, "kabocha");
    public static final Block KABOCHA_LANTERN =
            registerSquashLanternBlock("kabocha_lantern", MapColor.EMERALD_GREEN, "kabocha");
    public static final Block KABOCHA_SOUL_LANTERN =
            registerSquashSoulLanternBlock("kabocha_soul_lantern", MapColor.EMERALD_GREEN, "kabocha");
    public static final Block EERIE_KABOCHA_LANTERN =
            registerEerieSquashBlock("eerie_kabocha_lantern", MapColor.EMERALD_GREEN, "kabocha");


    public static final Block KABOCHA_STEM =
            registerSquashStem("kabocha_stem", PumpkinBlockKeys.KABOCHA,
                    PumpkinBlockKeys.ATTACHED_KABOCHA_STEM,
                    PumpkinItemKeys.KABOCHA_SEEDS, MapColor.LIME);

    public static final Block ATTACHED_KABOCHA_STEM =
            registerAttachedSquashStem("attached_kabocha_stem", PumpkinBlockKeys.KABOCHA_STEM,
                    PumpkinBlockKeys.KABOCHA, PumpkinItemKeys.KABOCHA_SEEDS, MapColor.LIME);

    //MIDNIGHT PUMPKINS=================================================================================================

    public static final Block MIDNIGHT_PUMPKIN =
            registerSquashBlock("midnight_pumpkin", MapColor.DARK_AQUA, "midnight");
    public static final Block CARVED_MIDNIGHT_PUMPKIN =
            registerCarvedSquashBlock("carved_midnight_pumpkin", MapColor.DARK_AQUA, "midnight");
    public static final Block MIDNIGHT_O_LANTERN =
            registerSquashLanternBlock("midnight_o_lantern", MapColor.DARK_AQUA, "midnight");
    public static final Block MIDNIGHT_O_SOUL_LANTERN =
            registerSquashSoulLanternBlock("midnight_o_soul_lantern", MapColor.DARK_AQUA, "midnight");
    public static final Block EERIE_MIDNIGHT_O_LANTERN =
            registerEerieSquashBlock("eerie_midnight_o_lantern", MapColor.DARK_AQUA, "midnight");


    public static final Block MIDNIGHT_PUMPKIN_STEM =
            registerSquashStem("midnight_pumpkin_stem", PumpkinBlockKeys.MIDNIGHT_PUMPKIN,
                    PumpkinBlockKeys.ATTACHED_MIDNIGHT_PUMPKIN_STEM,
                    PumpkinItemKeys.MIDNIGHT_PUMPKIN_SEEDS, MapColor.DARK_GREEN);

    public static final Block ATTACHED_MIDNIGHT_PUMPKIN_STEM =
            registerAttachedSquashStem("attached_midnight_pumpkin_stem", PumpkinBlockKeys.MIDNIGHT_PUMPKIN_STEM,
                    PumpkinBlockKeys.MIDNIGHT_PUMPKIN, PumpkinItemKeys.MIDNIGHT_PUMPKIN_SEEDS, MapColor.DARK_GREEN);

    //MINI PUMPKINS=====================================================================================================
    public static final Block MINI_PUMPKIN =
            registerSquashBlock("mini_pumpkin", MapColor.ORANGE, "mini");
    public static final Block CARVED_MINI_PUMPKIN =
            registerCarvedSquashBlock("carved_mini_pumpkin", MapColor.ORANGE, "mini");
    public static final Block MINI_JACK_O_LANTERN =
            registerSquashLanternBlock("mini_jack_o_lantern", MapColor.ORANGE, "mini");
    public static final Block MINI_JACK_O_SOUL_LANTERN =
            registerSquashSoulLanternBlock("mini_jack_o_soul_lantern", MapColor.ORANGE, "mini");
    public static final Block EERIE_MINI_JACK_O_LANTERN =
            registerEerieSquashBlock("eerie_mini_jack_o_lantern", MapColor.ORANGE, "mini");


    public static final Block MINI_PUMPKIN_STEM =
            registerSquashStem("mini_pumpkin_stem", PumpkinBlockKeys.MINI_PUMPKIN,
                    PumpkinBlockKeys.ATTACHED_MINI_PUMPKIN_STEM,
                    PumpkinItemKeys.MINI_PUMPKIN_SEEDS, MapColor.YELLOW);

    public static final Block ATTACHED_MINI_PUMPKIN_STEM =
            registerAttachedSquashStem("attached_mini_pumpkin_stem", PumpkinBlockKeys.MINI_PUMPKIN_STEM,
                    PumpkinBlockKeys.MINI_PUMPKIN, PumpkinItemKeys.MINI_PUMPKIN_SEEDS, MapColor.YELLOW);

    //SUGAR PUMPKINS====================================================================================================
    public static final Block SUGAR_PUMPKIN =
            registerSquashBlock("sugar_pumpkin", MapColor.TERRACOTTA_RED, "sugar");
    public static final Block CARVED_SUGAR_PUMPKIN =
            registerCarvedSquashBlock("carved_sugar_pumpkin", MapColor.TERRACOTTA_RED, "sugar");
    public static final Block SUGAR_O_LANTERN =
            registerSquashLanternBlock("sugar_o_lantern", MapColor.TERRACOTTA_RED, "sugar");
    public static final Block SUGAR_O_SOUL_LANTERN =
            registerSquashSoulLanternBlock("sugar_o_soul_lantern", MapColor.TERRACOTTA_RED, "sugar");
    public static final Block EERIE_SUGAR_O_LANTERN =
            registerEerieSquashBlock("eerie_sugar_o_lantern", MapColor.TERRACOTTA_RED, "sugar");


    public static final Block SUGAR_PUMPKIN_STEM =
            registerSquashStem("sugar_pumpkin_stem", PumpkinBlockKeys.SUGAR_PUMPKIN,
                    PumpkinBlockKeys.ATTACHED_SUGAR_PUMPKIN_STEM,
                    PumpkinItemKeys.SUGAR_PUMPKIN_SEEDS, MapColor.ORANGE);

    public static final Block ATTACHED_SUGAR_PUMPKIN_STEM =
            registerAttachedSquashStem("attached_sugar_pumpkin_stem", PumpkinBlockKeys.SUGAR_PUMPKIN_STEM,
                    PumpkinBlockKeys.SUGAR_PUMPKIN, PumpkinItemKeys.SUGAR_PUMPKIN_SEEDS, MapColor.ORANGE);

    //TINY PUMPKINS ====================================================================================================

    public static final Block TINY_PUMPKIN = registerBlock("tiny_pumpkin",
            new TinyPumpkinBlock(AbstractBlock.Settings.create().mapColor(MapColor.ORANGE)
                    .strength(1.0f).instrument(NoteBlockInstrument.DIDGERIDOO)
                    .sounds(BlockSoundGroup.WOOD)));
    public static final Block TINY_CARVED_PUMPKIN = registerBlock("tiny_carved_pumpkin",
            new TinySquashBlock(AbstractBlock.Settings.create().mapColor(MapColor.ORANGE)
                    .strength(1.0f).sounds(BlockSoundGroup.WOOD)));
    public static final Block TINY_JACK_O_LANTERN = registerBlock("tiny_jack_o_lantern",
            new TinySquashBlock(AbstractBlock.Settings.create().mapColor(MapColor.ORANGE)
                    .luminance(TinySquashBlock.JACK_O_LANTERN_LUMINANCE)
                    .strength(1.0f).sounds(BlockSoundGroup.WOOD)));
    public static final Block TINY_JACK_O_SOUL_LANTERN = registerBlock("tiny_jack_o_soul_lantern",
            new TinySquashBlock(AbstractBlock.Settings.create().mapColor(MapColor.ORANGE)
                    .luminance(TinySquashBlock.JACK_O_SOUL_LANTERN_LUMINANCE)
                    .strength(1.0f).sounds(BlockSoundGroup.WOOD)));
    public static final Block TINY_EERIE_JACK_O_LANTERN = registerBlock("tiny_eerie_jack_o_lantern",
            new EerieTinySquashBlock(AbstractBlock.Settings.create().mapColor(MapColor.ORANGE)
                    .luminance(TinySquashBlock.EERIE_JACK_O_LANTERN_LUMINANCE)
                    .strength(1.0f).sounds(BlockSoundGroup.WOOD)));

    public static final Block TINY_PUMPKIN_STEM =
            registerBlockNoItem("tiny_pumpkin_stem", new TinyPumpkinStemBlock(AbstractBlock.Settings.create()
                            .mapColor(MapColor.PALE_GREEN).noCollision().ticksRandomly()
                            .breakInstantly().sounds(BlockSoundGroup.STEM).pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block ATTACHED_TINY_PUMPKIN_STEM =
            registerAttachedSquashStem("attached_tiny_pumpkin_stem", PumpkinBlockKeys.TINY_PUMPKIN_STEM,
                    PumpkinBlockKeys.TINY_PUMPKIN, PumpkinItemKeys.TINY_PUMPKIN_SEEDS, MapColor.PALE_GREEN);

    //SPOOKY LANTERNS===================================================================================================

    public static final Block SKULL_LANTERN = registerSpookyLantern("skull_lantern", 15);
    public static final Block WITHER_SKULL_LANTERN = registerSpookyLantern("wither_skull_lantern", 12);
    public static final Block BAT_LANTERN = registerSpookyLantern("bat_lantern", 12);
    public static final Block SPIDER_LANTERN = registerSpookyLantern("spider_lantern", 12);
    public static final Block PUMPKIN_LANTERN = registerSpookyLantern("pumpkin_lantern", 15);
    public static final Block CREEPY_PUMPKIN_LANTERN = registerSpookyLantern("creepy_pumpkin_lantern", 15);
    public static final Block GHASTLY_LANTERN = registerSpookyLantern("ghastly_lantern", 15);
    public static final Block CRESCENT_MOON_LANTERN = registerSpookyLantern("crescent_moon_lantern", 15);
    public static final Block BLACK_CAT_LANTERN = registerSpookyLantern("black_cat_lantern", 12);

    //BOOBERRY BUSH=====================================================================================================
    public static final Block BOOBERRY_BUSH = registerBlockNoItem("booberry_bush",
            new BooberryBushBlock(AbstractBlock.Settings.create().noCollision().ticksRandomly()
                    .luminance(BooberryBushBlock.getLuminanceSupplier(14)).sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));


    //CANDY BOWL========================================================================================================
    public static final Block BOWL_OF_SWEETS = registerBlock("bowl_of_sweets",
            new CandyBowlBlock(AbstractBlock.Settings.create().breakInstantly()
                    .sounds(BlockSoundGroup.AZALEA_LEAVES).mapColor(MapColor.DARK_AQUA)));

    //SPOOKY CANDLES====================================================================================================
    public static final Block SKULL_CANDLE = registerSpookyCandle("skull_candle", MapColor.PALE_YELLOW);
    public static final Block BAT_CANDLE = registerSpookyCandle("bat_candle", MapColor.BLACK);
    public static final Block PUMPKIN_CANDLE = registerSpookyCandle("pumpkin_candle", MapColor.ORANGE);
    public static final Block CREEPY_PUMPKIN_CANDLE =
            registerSpookyCandle("creepy_pumpkin_candle", MapColor.EMERALD_GREEN);

    //CAKES=============================================================================================================
    public static final Block PUMPKIN_CAKE = registerPumpkinCake("pumpkin_cake", MapColor.PALE_YELLOW);
    public static final Block DARK_CHOCOLATE_PUMPKIN_CAKE =
            registerPumpkinCake("dark_chocolate_pumpkin_cake", MapColor.SPRUCE_BROWN);
    public static final Block BOOBERRY_PUMPKIN_CAKE =
            registerPumpkinCake("booberry_pumpkin_cake", MapColor.PALE_PURPLE);

    //SKULL CANDLE CAKES================================================================================================
    public static final Block SKULL_CANDLE_PUMPKIN_CAKE =
            registerPumpkinCandleCake("skull_candle_pumpkin_cake", PUMPKIN_CAKE, SKULL_CANDLE);
    public static final Block SKULL_CANDLE_DARK_CHOCOLATE_PUMPKIN_CAKE =
            registerPumpkinCandleCake("skull_candle_dark_chocolate_pumpkin_cake", DARK_CHOCOLATE_PUMPKIN_CAKE, SKULL_CANDLE);
    public static final Block SKULL_CANDLE_BOOBERRY_PUMPKIN_CAKE =
            registerPumpkinCandleCake("skull_candle_booberry_pumpkin_cake", BOOBERRY_PUMPKIN_CAKE, SKULL_CANDLE);

    //BAT CANDLE CAKES==================================================================================================
    public static final Block BAT_CANDLE_PUMPKIN_CAKE =
            registerPumpkinCandleCake("bat_candle_pumpkin_cake", PUMPKIN_CAKE, BAT_CANDLE);
    public static final Block BAT_CANDLE_DARK_CHOCOLATE_PUMPKIN_CAKE =
            registerPumpkinCandleCake("bat_candle_dark_chocolate_pumpkin_cake",
                    DARK_CHOCOLATE_PUMPKIN_CAKE, BAT_CANDLE);
    public static final Block BAT_CANDLE_BOOBERRY_PUMPKIN_CAKE =
            registerPumpkinCandleCake("bat_candle_booberry_pumpkin_cake",
                    BOOBERRY_PUMPKIN_CAKE, BAT_CANDLE);


    //PUMPKIN CANDLE CAKES==============================================================================================
    public static final Block PUMPKIN_CANDLE_PUMPKIN_CAKE =
            registerPumpkinCandleCake("pumpkin_candle_pumpkin_cake", PUMPKIN_CAKE, PUMPKIN_CANDLE);
    public static final Block PUMPKIN_CANDLE_DARK_CHOCOLATE_PUMPKIN_CAKE =
            registerPumpkinCandleCake("pumpkin_candle_dark_chocolate_pumpkin_cake",
                    DARK_CHOCOLATE_PUMPKIN_CAKE, PUMPKIN_CANDLE);
    public static final Block PUMPKIN_CANDLE_BOOBERRY_PUMPKIN_CAKE =
            registerPumpkinCandleCake("pumpkin_candle_booberry_pumpkin_cake",
                    BOOBERRY_PUMPKIN_CAKE, PUMPKIN_CANDLE);


    //CREEPY PUMPKIN CANDLE CAKES=======================================================================================
    public static final Block CREEPY_PUMPKIN_CANDLE_PUMPKIN_CAKE =
            registerPumpkinCandleCake("creepy_pumpkin_candle_pumpkin_cake", PUMPKIN_CAKE, CREEPY_PUMPKIN_CANDLE);
    public static final Block CREEPY_PUMPKIN_CANDLE_DARK_CHOCOLATE_PUMPKIN_CAKE =
            registerPumpkinCandleCake("creepy_pumpkin_candle_dark_chocolate_pumpkin_cake",
                    DARK_CHOCOLATE_PUMPKIN_CAKE, CREEPY_PUMPKIN_CANDLE);
    public static final Block CREEPY_PUMPKIN_CANDLE_BOOBERRY_PUMPKIN_CAKE =
            registerPumpkinCandleCake("creepy_pumpkin_candle_booberry_pumpkin_cake",
                    BOOBERRY_PUMPKIN_CAKE, CREEPY_PUMPKIN_CANDLE);


    //PIES==============================================================================================================

    public static final Block JACK_O_LANTERN_PIE = registerPie("jack_o_lantern_pie");
    public static final Block BOOBERRY_PIE = registerPie("booberry_pie");

    //GARGOYLES=========================================================================================================

    public static final Block STONE_GARGOYLE = registerBlock("stone_gargoyle",
            new GargoyleBlock(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static final Block BLACKSTONE_GARGOYLE = registerBlock("blackstone_gargoyle",
            new GargoyleBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE)));
    public static final Block EERIE_STONE_GARGOYLE = registerBlock("eerie_stone_gargoyle",
            new EerieGargoyleBlock(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static final Block EERIE_BLACKSTONE_GARGOYLE = registerBlock("eerie_blackstone_gargoyle",
            new EerieGargoyleBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE)));

    //ANGEL STATUES=====================================================================================================
    public static final Block STONE_ANGEL = registerBlock("stone_angel",
            new AngelBlock(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static final Block BLACKSTONE_ANGEL = registerBlock("blackstone_angel",
            new AngelBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE)));
    public static final Block EERIE_STONE_ANGEL = registerBlock("eerie_stone_angel",
            new EerieAngelBlock(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static final Block EERIE_BLACKSTONE_ANGEL = registerBlock("eerie_blackstone_angel",
            new EerieAngelBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE)));


    //GRAVESTONES=======================================================================================================

    public static final Block STONE_GRAVE_MARKER = registerBlock("stone_grave_marker",
            new GravestoneBlock(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static final Block BLACKSTONE_GRAVE_MARKER = registerBlock("blackstone_grave_marker",
            new GravestoneBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE)));
    public static final Block EERIE_STONE_GRAVE_MARKER = registerBlock("eerie_stone_grave_marker",
            new EerieGravestoneBlock(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static final Block EERIE_BLACKSTONE_GRAVE_MARKER = registerBlock("eerie_blackstone_grave_marker",
            new EerieGravestoneBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE)));



    public static final Block STONE_CROSS_GRAVE_MARKER = registerBlock("stone_cross_grave_marker",
            new CrossGravestoneBlock(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static final Block BLACKSTONE_CROSS_GRAVE_MARKER = registerBlock("blackstone_cross_grave_marker",
            new CrossGravestoneBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE)));

    public static final Block STONE_OBELISK_GRAVE_MARKER = registerBlock("stone_obelisk_grave_marker",
            new ObeliskGravestoneBlock(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static final Block BLACKSTONE_OBELISK_GRAVE_MARKER = registerBlock("blackstone_obelisk_grave_marker",
            new ObeliskGravestoneBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE)));


    //ETCHED STONE =====================================================================================================

    public static final Block ENGRAVED_STONE =
            registerBlock("engraved_stone", new Block(AbstractBlock.Settings.copy(Blocks.COBBLESTONE)));
    public static final Block ENGRAVED_STONE_STAIRS =
            registerBlock("engraved_stone_stairs", new StairsBlock(ENGRAVED_STONE.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.COBBLESTONE_STAIRS)));
    public static final Block ENGRAVED_STONE_SLAB =
            registerBlock("engraved_stone_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.COBBLESTONE_SLAB)));
    public static final Block ENGRAVED_STONE_WALL =
            registerBlock("engraved_stone_wall", new WallBlock(AbstractBlock.Settings.copy(Blocks.COBBLESTONE_WALL)));
    public static final Block ENGRAVED_STONE_PILLAR =
            registerBlock("engraved_stone_pillar", new ColumnBlock(AbstractBlock.Settings.copy(Blocks.COBBLESTONE)));
    public static final Block ENGRAVED_STONE_PILLAR_CAP =
            registerBlock("engraved_stone_pillar_cap", new PillarCapBlock(AbstractBlock.Settings.copy(Blocks.COBBLESTONE)));


    public static final Block MOSSY_ENGRAVED_STONE =
            registerBlock("mossy_engraved_stone", new Block(AbstractBlock.Settings.copy(Blocks.MOSSY_COBBLESTONE)));
    public static final Block MOSSY_ENGRAVED_STONE_STAIRS =
            registerBlock("mossy_engraved_stone_stairs", new StairsBlock(MOSSY_ENGRAVED_STONE.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.MOSSY_COBBLESTONE_STAIRS)));
    public static final Block MOSSY_ENGRAVED_STONE_SLAB =
            registerBlock("mossy_engraved_stone_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.MOSSY_COBBLESTONE_SLAB)));
    public static final Block MOSSY_ENGRAVED_STONE_WALL =
            registerBlock("mossy_engraved_stone_wall", new WallBlock(AbstractBlock.Settings.copy(Blocks.MOSSY_COBBLESTONE_WALL)));
    public static final Block MOSSY_ENGRAVED_STONE_PILLAR =
            registerBlock("mossy_engraved_stone_pillar", new ColumnBlock(AbstractBlock.Settings.copy(Blocks.MOSSY_COBBLESTONE)));
    public static final Block MOSSY_ENGRAVED_STONE_PILLAR_CAP =
            registerBlock("mossy_engraved_stone_pillar_cap", new PillarCapBlock(AbstractBlock.Settings.copy(Blocks.MOSSY_COBBLESTONE)));


    public static final Block ENGRAVED_BLACKSTONE =
            registerBlock("engraved_blackstone", new Block(AbstractBlock.Settings.copy(Blocks.BLACKSTONE)));
    public static final Block ENGRAVED_BLACKSTONE_STAIRS =
            registerBlock("engraved_blackstone_stairs", new StairsBlock(ENGRAVED_BLACKSTONE.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.BLACKSTONE_STAIRS)));
    public static final Block ENGRAVED_BLACKSTONE_SLAB =
            registerBlock("engraved_blackstone_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE_SLAB)));
    public static final Block ENGRAVED_BLACKSTONE_WALL =
            registerBlock("engraved_blackstone_wall", new WallBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE_WALL)));
    public static final Block ENGRAVED_BLACKSTONE_PILLAR =
            registerBlock("engraved_blackstone_pillar", new ColumnBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE)));
    public static final Block ENGRAVED_BLACKSTONE_PILLAR_CAP =
            registerBlock("engraved_blackstone_pillar_cap", new PillarCapBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE)));

    //COBWEBS ==========================================================================================================

    public static final Block GLOW_IN_THE_DARK_COBWEB = registerCobweb("glow_in_the_dark_cobweb",
            MapColor.PALE_GREEN, 15);
    public static final Block GREEN_COBWEB = registerCobweb("green_cobweb",
            MapColor.LIME, 12);
    public static final Block ORANGE_COBWEB = registerCobweb("orange_cobweb",
            MapColor.ORANGE, 12);
    public static final Block PURPLE_COBWEB = registerCobweb("purple_cobweb",
            MapColor.PURPLE, 12);



    //HANGING COBWEBS ==================================================================================================

    public static final Block HANGING_COBWEB =
            registerHangingCobweb("hanging_cobweb",0);
    public static final Block GLOW_IN_THE_DARK_HANGING_COBWEB =
            registerHangingCobweb("glow_in_the_dark_hanging_cobweb",15);
    public static final Block GREEN_HANGING_COBWEB =
            registerHangingCobweb("green_hanging_cobweb",12);
    public static final Block ORANGE_HANGING_COBWEB =
            registerHangingCobweb("orange_hanging_cobweb",12);
    public static final Block PURPLE_HANGING_COBWEB =
            registerHangingCobweb("purple_hanging_cobweb",12);

    //METHODS ==========================================================================================================

    private static Block registerCobweb(String name, MapColor mapColor, int luminance) {
        return registerBlock(name,
                new CobwebBlock(AbstractBlock.Settings.copy(Blocks.COBWEB)
                        .mapColor(mapColor)
                        .luminance((state) -> { return luminance; })));
    }
    private static Block registerHangingCobweb(String name, int luminance) {
        return registerBlock(name,
                new HangingCobwebBlock(AbstractBlock.Settings.create().breakInstantly().noCollision()
                        .pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.WOOL)
                        .luminance((state) -> { return luminance; })));
    }

    private static Block registerPie(String name) {
        return registerBlock(name, new PieBlock(AbstractBlock.Settings.create().solid().strength(0.5F)
                .sounds(BlockSoundGroup.MUD).pistonBehavior(PistonBehavior.DESTROY)));
    }


    private static Block registerPumpkinCandleCake(String name, Block cakeBlock, Block candleBlock) {
        return registerBlockNoItem(name, new PumpkinCandleCakeBlock(candleBlock, cakeBlock,
                AbstractBlock.Settings.copy(cakeBlock).luminance(createLightLevelFromLitBlockState(7))));
    }

    private static Block registerPumpkinCake(String name, MapColor mapColor) {
        return registerBlock(name, new PumpkinCakeBlock(AbstractBlock.Settings.create().mapColor(mapColor)
                .strength(0.5F).sounds(BlockSoundGroup.WOOL)));
    }

    private static Block registerSpookyCandle(String name, MapColor mapColor) {
        return registerBlock(name, new SpookyCandleBlock(AbstractBlock.Settings.create().mapColor(mapColor)
                .nonOpaque().strength(0.1F).sounds(BlockSoundGroup.CANDLE)
                .luminance(createLightLevelFromLitBlockState(7))));
    }

    private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return (state) -> {
            return (Boolean)state.get(Properties.LIT) ? litLevel : 0;
        };
    }

    private static Block registerSquashBlock(String name, MapColor mapColor, String squashType) {
        return registerBlock(name, new SquashBlock(squashType, AbstractBlock.Settings.create()
                .mapColor(mapColor).strength(1.0f)
                .instrument(NoteBlockInstrument.DIDGERIDOO).sounds(BlockSoundGroup.WOOD)
                .pistonBehavior(PistonBehavior.DESTROY)));
    }

    private static Block registerCarvedSquashBlock(String name, MapColor mapColor, String squashType) {
        return registerBlock(name, new WearableCarvedSquashBlock(squashType, AbstractBlock.Settings.create()
                .mapColor(mapColor).strength(1.0f)
                .sounds(BlockSoundGroup.WOOD).allowsSpawning(Blocks::always).pistonBehavior(PistonBehavior.DESTROY)));
    }

    private static Block registerSquashLanternBlock(String name, MapColor mapColor, String squashType) {
        return registerBlock(name, new CarvedSquashBlock(squashType, AbstractBlock.Settings.create()
                .mapColor(mapColor).strength(1.0f)
                .sounds(BlockSoundGroup.WOOD).luminance((state) -> { return 15; })
                .allowsSpawning(Blocks::always).pistonBehavior(PistonBehavior.DESTROY)));
    }

    private static Block registerSquashSoulLanternBlock(String name, MapColor mapColor, String squashType) {
        return registerBlock(name, new CarvedSquashBlock(squashType, AbstractBlock.Settings.create()
                .mapColor(mapColor).strength(1.0f)
                .sounds(BlockSoundGroup.WOOD).luminance((state) -> { return 10; })
                .allowsSpawning(Blocks::always).pistonBehavior(PistonBehavior.DESTROY)));
    }

    private static Block registerEerieSquashBlock(String name, MapColor mapColor, String squashType) {
        return registerBlock(name, new EerieSquashBlock(squashType, AbstractBlock.Settings.create()
                .mapColor(mapColor).strength(1.0f)
                .sounds(BlockSoundGroup.WOOD).luminance((state) -> { return 8; })
                .allowsSpawning(Blocks::always).pistonBehavior(PistonBehavior.DESTROY)));
    }


    private static Block registerSquashStem(String name, RegistryKey<Block> squashBlock, RegistryKey<Block> attachedStemBlock,
                                            RegistryKey<Item> squashSeeds, MapColor mapColor) {
        return registerBlockNoItem(name, new StemBlock(squashBlock, attachedStemBlock, squashSeeds,
                AbstractBlock.Settings.create()
                        .mapColor(mapColor).noCollision().ticksRandomly()
                        .breakInstantly().sounds(BlockSoundGroup.STEM).pistonBehavior(PistonBehavior.DESTROY)));


    }
    private static Block registerAttachedSquashStem(String name, RegistryKey<Block> stem, RegistryKey<Block> squashBlock,
                                                    RegistryKey<Item> squashSeeds, MapColor mapColor) {
        return registerBlockNoItem(name, new AttachedStemBlock(stem, squashBlock, squashSeeds,
                AbstractBlock.Settings.create().mapColor(mapColor).noCollision()
                        .breakInstantly().sounds(BlockSoundGroup.WOOD)
                        .pistonBehavior(PistonBehavior.DESTROY)));
    }


    private static Block registerSpookyLantern(String name, int luminance) {
        return registerBlock(name, new SpookyLanternBlock(AbstractBlock.Settings.create().requiresTool()
                .nonOpaque().strength(3.5F).sounds(BlockSoundGroup.LANTERN).pistonBehavior(PistonBehavior.DESTROY)
                .luminance((state) -> { return luminance; })));
    }

    //GENERIC METHODS ==================================================================================================

    private static Block registerBlockNoItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, name), block);
    }

    public static Block registerBlock(String name, Block block){
        Item blockItem = registerBlockItem(name, block);
        ItemGroupEvents.modifyEntriesEvent(PumpkinSeason.ITEM_GROUP).register(content -> {
            content.add(blockItem);
        });
        return Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerPumpkins() {
        PumpkinSeason.LOGGER.info("Registering Pumpkins for " + MOD_ID);
    }

}
