package misterhyacinth.pumpkinseason.datagen;

import misterhyacinth.pumpkinseason.PumpkinItemRegistry;
import misterhyacinth.pumpkinseason.PumpkinRegistry;
import misterhyacinth.pumpkinseason.util.PumpkinItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

public class PumpkinRecipeProvider extends FabricRecipeProvider {
    public PumpkinRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, PumpkinRegistry.HANGING_COBWEB, 3)
                .input('S', Items.STRING)
                .pattern("S S")
                .pattern(" S ")
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(exporter);

        offerCobwebRecipe(exporter, PumpkinRegistry.GLOW_IN_THE_DARK_COBWEB, PumpkinRegistry.GLOW_IN_THE_DARK_HANGING_COBWEB,
                Ingredient.ofItems(Items.GLOW_INK_SAC, Items.GLOWSTONE_DUST));
        offerCobwebRecipe(exporter, PumpkinRegistry.GREEN_COBWEB, PumpkinRegistry.GREEN_HANGING_COBWEB,
                Ingredient.ofItems(Items.GREEN_DYE, Items.LIME_DYE));
        offerCobwebRecipe(exporter, PumpkinRegistry.ORANGE_COBWEB, PumpkinRegistry.ORANGE_HANGING_COBWEB,
                Ingredient.ofItems(Items.ORANGE_DYE));
        offerCobwebRecipe(exporter, PumpkinRegistry.PURPLE_COBWEB, PumpkinRegistry.PURPLE_HANGING_COBWEB,
                Ingredient.ofItems(Items.PURPLE_DYE, Items.MAGENTA_DYE));




        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,
                PumpkinRegistry.ENGRAVED_STONE, Blocks.CHISELED_STONE_BRICKS);
        StonecuttingRecipeJsonBuilder.createStonecutting(
                        Ingredient.ofItems(Items.STONE, Items.STONE_BRICKS, Items.CHISELED_STONE_BRICKS),
                        RecipeCategory.BUILDING_BLOCKS, PumpkinRegistry.ENGRAVED_STONE, 1)
                .criterion(hasItem(Items.CHISELED_STONE_BRICKS), conditionsFromItem(Items.CHISELED_STONE_BRICKS))
                .offerTo(exporter, "engraved_stone_from_stonecutting");
        offerEngravedRecipes(exporter, PumpkinRegistry.ENGRAVED_STONE_STAIRS,
                PumpkinRegistry.ENGRAVED_STONE_SLAB, PumpkinRegistry.ENGRAVED_STONE_WALL,
                PumpkinRegistry.ENGRAVED_STONE_PILLAR, PumpkinRegistry.ENGRAVED_STONE_PILLAR_CAP,
                PumpkinRegistry.ENGRAVED_STONE, PumpkinRegistry.ENGRAVED_STONE_SLAB,
                Ingredient.ofItems(Items.STONE, Items.STONE_BRICKS, Items.CHISELED_STONE_BRICKS,
                        PumpkinRegistry.ENGRAVED_STONE));


        offerMossyRecipe(exporter, PumpkinRegistry.MOSSY_ENGRAVED_STONE, PumpkinRegistry.ENGRAVED_STONE);
        offerEngravedRecipes(exporter, PumpkinRegistry.MOSSY_ENGRAVED_STONE_STAIRS,
                PumpkinRegistry.MOSSY_ENGRAVED_STONE_SLAB, PumpkinRegistry.MOSSY_ENGRAVED_STONE_WALL,
                PumpkinRegistry.MOSSY_ENGRAVED_STONE_PILLAR, PumpkinRegistry.MOSSY_ENGRAVED_STONE_PILLAR_CAP,
                PumpkinRegistry.MOSSY_ENGRAVED_STONE, PumpkinRegistry.MOSSY_ENGRAVED_STONE_SLAB,
                Ingredient.ofItems(PumpkinRegistry.MOSSY_ENGRAVED_STONE));


        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,
                PumpkinRegistry.ENGRAVED_BLACKSTONE, Blocks.CHISELED_POLISHED_BLACKSTONE);
        StonecuttingRecipeJsonBuilder.createStonecutting(
                        Ingredient.ofItems(Items.BLACKSTONE, Items.POLISHED_BLACKSTONE, Items.CHISELED_POLISHED_BLACKSTONE),
                        RecipeCategory.BUILDING_BLOCKS, PumpkinRegistry.ENGRAVED_BLACKSTONE, 1)
                .criterion(hasItem(Items.CHISELED_POLISHED_BLACKSTONE), conditionsFromItem(Items.CHISELED_POLISHED_BLACKSTONE))
                .offerTo(exporter, "engraved_blackstone_from_stonecutting");
        offerEngravedRecipes(exporter, PumpkinRegistry.ENGRAVED_BLACKSTONE_STAIRS,
                PumpkinRegistry.ENGRAVED_BLACKSTONE_SLAB, PumpkinRegistry.ENGRAVED_BLACKSTONE_WALL,
                PumpkinRegistry.ENGRAVED_BLACKSTONE_PILLAR, PumpkinRegistry.ENGRAVED_BLACKSTONE_PILLAR_CAP,
                PumpkinRegistry.ENGRAVED_BLACKSTONE, PumpkinRegistry.ENGRAVED_BLACKSTONE_SLAB,
                Ingredient.ofItems(Items.BLACKSTONE, Items.POLISHED_BLACKSTONE, Items.CHISELED_POLISHED_BLACKSTONE,
                        PumpkinRegistry.ENGRAVED_BLACKSTONE));




        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, PumpkinRegistry.STONE_GARGOYLE, 1)
                .input('S', Items.STONE)
                .input('L', Items.STONE_SLAB)
                .input('C', Ingredient.ofItems(Items.GRAY_CARPET, Items.LIGHT_GRAY_CARPET))
                .pattern(" S")
                .pattern("CS")
                .pattern("LL")
                .criterion("has_item", conditionsFromItem(Items.STONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, PumpkinRegistry.BLACKSTONE_GARGOYLE, 1)
                .input('S', Items.BLACKSTONE)
                .input('L', Items.BLACKSTONE_SLAB)
                .input('C', Items.BLACK_CARPET)
                .pattern(" S")
                .pattern("CS")
                .pattern("LL")
                .criterion("has_item", conditionsFromItem(Items.BLACKSTONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, PumpkinRegistry.STONE_ANGEL, 1)
                .input('S', Items.STONE)
                .input('L', Items.STONE_SLAB)
                .input('F', Items.FEATHER)
                .pattern(" S ")
                .pattern("FSF")
                .pattern(" L ")
                .criterion("has_item", conditionsFromItem(Items.STONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, PumpkinRegistry.BLACKSTONE_ANGEL, 1)
                .input('S', Items.BLACKSTONE)
                .input('L', Items.BLACKSTONE_SLAB)
                .input('F', Items.FEATHER)
                .pattern(" S ")
                .pattern("FSF")
                .pattern(" L ")
                .criterion("has_item", conditionsFromItem(Items.BLACKSTONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, PumpkinRegistry.STONE_GRAVE_MARKER, 1)
                .input('S', Items.STONE)
                .input('L', Items.STONE_SLAB)
                .pattern("S")
                .pattern("L")
                .criterion("has_item", conditionsFromItem(Items.STONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, PumpkinRegistry.BLACKSTONE_GRAVE_MARKER, 1)
                .input('S', Items.BLACKSTONE)
                .input('L', Items.BLACKSTONE_SLAB)
                .pattern("S")
                .pattern("L")
                .criterion("has_item", conditionsFromItem(Items.BLACKSTONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, PumpkinRegistry.STONE_CROSS_GRAVE_MARKER, 3)
                .input('S', Items.STONE)
                .pattern(" S ")
                .pattern("SSS")
                .pattern(" S ")
                .criterion("has_item", conditionsFromItem(Items.STONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, PumpkinRegistry.BLACKSTONE_CROSS_GRAVE_MARKER, 3)
                .input('S', Items.BLACKSTONE)
                .pattern(" S ")
                .pattern("SSS")
                .pattern(" S ")
                .criterion("has_item", conditionsFromItem(Items.BLACKSTONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, PumpkinRegistry.STONE_OBELISK_GRAVE_MARKER, 2)
                .input('S', Items.STONE)
                .input('L', Items.STONE_SLAB)
                .pattern("S")
                .pattern("S")
                .pattern("L")
                .criterion("has_item", conditionsFromItem(Items.STONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, PumpkinRegistry.BLACKSTONE_OBELISK_GRAVE_MARKER, 2)
                .input('S', Items.BLACKSTONE)
                .input('L', Items.BLACKSTONE_SLAB)
                .pattern("S")
                .pattern("S")
                .pattern("L")
                .criterion("has_item", conditionsFromItem(Items.BLACKSTONE))
                .offerTo(exporter);




        ShapelessRecipeJsonBuilder
                .create(RecipeCategory.DECORATIONS, PumpkinRegistry.EERIE_STONE_GARGOYLE)
                .input(PumpkinRegistry.STONE_GARGOYLE)
                .input(Items.REDSTONE_TORCH)
                .criterion("has_item", conditionsFromItem(PumpkinRegistry.STONE_GARGOYLE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder
                .create(RecipeCategory.DECORATIONS, PumpkinRegistry.EERIE_BLACKSTONE_GARGOYLE)
                .input(PumpkinRegistry.BLACKSTONE_GARGOYLE)
                .input(Items.REDSTONE_TORCH)
                .criterion("has_item", conditionsFromItem(PumpkinRegistry.BLACKSTONE_GARGOYLE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder
                .create(RecipeCategory.DECORATIONS, PumpkinRegistry.EERIE_STONE_ANGEL)
                .input(PumpkinRegistry.STONE_ANGEL)
                .input(Items.REDSTONE_TORCH)
                .criterion("has_item", conditionsFromItem(PumpkinRegistry.STONE_ANGEL))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder
                .create(RecipeCategory.DECORATIONS, PumpkinRegistry.EERIE_BLACKSTONE_ANGEL)
                .input(PumpkinRegistry.BLACKSTONE_ANGEL)
                .input(Items.REDSTONE_TORCH)
                .criterion("has_item", conditionsFromItem(PumpkinRegistry.BLACKSTONE_ANGEL))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder
                .create(RecipeCategory.DECORATIONS, PumpkinRegistry.EERIE_STONE_GRAVE_MARKER)
                .input(PumpkinRegistry.STONE_GRAVE_MARKER)
                .input(Items.REDSTONE_TORCH)
                .criterion("has_item", conditionsFromItem(PumpkinRegistry.STONE_GRAVE_MARKER))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder
                .create(RecipeCategory.DECORATIONS, PumpkinRegistry.EERIE_BLACKSTONE_GRAVE_MARKER)
                .input(PumpkinRegistry.BLACKSTONE_GRAVE_MARKER)
                .input(Items.REDSTONE_TORCH)
                .criterion("has_item", conditionsFromItem(PumpkinRegistry.BLACKSTONE_GRAVE_MARKER))
                .offerTo(exporter);


        //PIES =========================================================================================================

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, PumpkinRegistry.BOOBERRY_PIE, 1)
                .input('W', Items.WHEAT)
                .input('S', Items.SUGAR)
                .input('#', PumpkinItemRegistry.BOOBERRIES)
                .input('B', Items.BOWL)
                .pattern(" W ")
                .pattern("#S#")
                .pattern(" B ")
                .criterion("has_item", conditionsFromItem(PumpkinItemRegistry.BOOBERRIES))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, PumpkinRegistry.JACK_O_LANTERN_PIE, 1)
                .input('W', Items.WHEAT)
                .input('S', Items.SUGAR)
                .input('#', PumpkinItemTags.PUMPKINS)
                .input('B', Items.BOWL)
                .pattern(" W ")
                .pattern("#S#")
                .pattern(" B ")
                .criterion("has_item", conditionsFromTag(PumpkinItemTags.PUMPKINS))
                .offerTo(exporter);

        offerPumpkinCakeRecipe(exporter, PumpkinRegistry.PUMPKIN_CAKE, Items.EGG);
        offerPumpkinCakeRecipe(exporter, PumpkinRegistry.BOOBERRY_PUMPKIN_CAKE, PumpkinItemRegistry.BOOBERRIES);
        offerPumpkinCakeRecipe(exporter, PumpkinRegistry.DARK_CHOCOLATE_PUMPKIN_CAKE, Items.COCOA_BEANS);

        offerCookieRecipe(exporter, PumpkinItemRegistry.PUMPKIN_COOKIE, Items.SUGAR);
        offerCookieRecipe(exporter, PumpkinItemRegistry.DARK_CHOCOLATE_PUMPKIN_COOKIE, Items.COCOA_BEANS);
        offerCookieRecipe(exporter, PumpkinItemRegistry.BOOBERRY_PUMPKIN_COOKIE, PumpkinItemRegistry.BOOBERRIES);

        offerCandyRecipe(exporter, PumpkinItemRegistry.CHOCOLATE_CANDY, Items.COCOA_BEANS);
        offerCandyRecipe(exporter, PumpkinItemRegistry.BOOBERRY_CANDY, PumpkinItemRegistry.BOOBERRIES);
        offerCandyRecipe(exporter, PumpkinItemRegistry.GLOWBERRY_CANDY, Items.GLOW_BERRIES);
        offerCandyRecipe(exporter, PumpkinItemRegistry.MELON_CANDY, Items.MELON_SLICE);
        offerCandyRecipe(exporter, PumpkinItemRegistry.SWEET_BERRY_CANDY, Items.SWEET_BERRIES);

        ShapelessRecipeJsonBuilder
                .create(RecipeCategory.MISC, PumpkinRegistry.BOWL_OF_SWEETS)
                .input(Ingredient.fromTag(PumpkinItemTags.CANDY), 4)
                .input(Items.BOWL)
                .criterion("has_item", conditionsFromTag(PumpkinItemTags.CANDY))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder
                .create(RecipeCategory.DECORATIONS, Items.PURPLE_DYE)
                .input(PumpkinItemRegistry.BOOBERRIES)
                .criterion("has_item", conditionsFromItem(PumpkinItemRegistry.BOOBERRIES))
                .offerTo(exporter, "purple_dye_from_booberries");

        //CANDLES

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, PumpkinRegistry.BAT_CANDLE, 1)
                .input('S', Items.STRING)
                .input('H', Items.HONEYCOMB)
                .input('C', Items.BLACK_CARPET)
                .pattern("S")
                .pattern("H")
                .pattern("C")
                .criterion("has_item", conditionsFromItem(Items.HONEYCOMB))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, PumpkinRegistry.PUMPKIN_CANDLE, 1)
                .input('S', Items.STRING)
                .input('H', Items.HONEYCOMB)
                .input('P', PumpkinItemTags.RAW_PUMPKIN_SEEDS)
                .pattern("S")
                .pattern("H")
                .pattern("P")
                .criterion("has_item", conditionsFromItem(Items.HONEYCOMB))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, PumpkinRegistry.SKULL_CANDLE, 1)
                .input('S', Items.STRING)
                .input('H', Items.HONEYCOMB)
                .input('B', Items.BONE_MEAL)
                .pattern("S")
                .pattern("H")
                .pattern("B")
                .criterion("has_item", conditionsFromItem(Items.HONEYCOMB))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder
                .create(RecipeCategory.DECORATIONS, PumpkinRegistry.CREEPY_PUMPKIN_CANDLE)
                .input(PumpkinRegistry.PUMPKIN_CANDLE)
                .input(Items.GREEN_DYE)
                .group("spooky_lanterns")
                .criterion("has_item", conditionsFromItem(PumpkinRegistry.PUMPKIN_CANDLE))
                .offerTo(exporter);


        //LANTERNS

        ShapelessRecipeJsonBuilder
                .create(RecipeCategory.DECORATIONS, PumpkinRegistry.SKULL_LANTERN)
                .input(Items.LANTERN)
                .input(Items.BONE_MEAL)
                .group("spooky_lanterns")
                .criterion("has_item", conditionsFromItem(Items.LANTERN))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder
                .create(RecipeCategory.DECORATIONS, PumpkinRegistry.WITHER_SKULL_LANTERN)
                .input(Items.LANTERN)
                .input(Items.COAL)
                .group("spooky_lanterns")
                .criterion("has_item", conditionsFromItem(Items.LANTERN))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder
                .create(RecipeCategory.DECORATIONS, PumpkinRegistry.BAT_LANTERN)
                .input(Items.LANTERN)
                .input(Items.BLACK_CARPET)
                .group("spooky_lanterns")
                .criterion("has_item", conditionsFromItem(Items.LANTERN))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, PumpkinRegistry.SPIDER_LANTERN, 1)
                .input('L', Items.LANTERN)
                .input('S', Items.STICK)
                .pattern("S S")
                .pattern("SLS")
                .pattern("S S")
                .criterion("has_item", conditionsFromItem(Items.LANTERN))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder
                .create(RecipeCategory.DECORATIONS, PumpkinRegistry.PUMPKIN_LANTERN)
                .input(Items.LANTERN)
                .input(PumpkinItemTags.RAW_PUMPKIN_SEEDS)
                .group("spooky_lanterns")
                .criterion("has_item", conditionsFromItem(Items.LANTERN))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder
                .create(RecipeCategory.DECORATIONS, PumpkinRegistry.CREEPY_PUMPKIN_LANTERN)
                .input(PumpkinRegistry.PUMPKIN_LANTERN)
                .input(Items.GREEN_DYE)
                .group("spooky_lanterns")
                .criterion("has_item", conditionsFromItem(PumpkinRegistry.PUMPKIN_LANTERN))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder
                .create(RecipeCategory.DECORATIONS, PumpkinRegistry.GHASTLY_LANTERN)
                .input(Items.LANTERN)
                .input(Items.WHITE_CARPET)
                .group("spooky_lanterns")
                .criterion("has_item", conditionsFromItem(Items.LANTERN))
                .offerTo(exporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, PumpkinRegistry.CRESCENT_MOON_LANTERN, 1)
                .input('L', Items.LANTERN)
                .input('A', Items.AMETHYST_SHARD)
                .input('G', Items.GLOWSTONE_DUST)
                .pattern("ALG")
                .criterion("has_item", conditionsFromItem(Items.LANTERN))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder
                .create(RecipeCategory.DECORATIONS, PumpkinRegistry.BLACK_CAT_LANTERN)
                .input(Items.LANTERN)
                .input(Ingredient.ofItems(Items.COD, Items.SALMON, Items.STRING))
                .input(Items.BLACK_DYE)
                .group("spooky_lanterns")
                .criterion("has_item", conditionsFromItem(Items.LANTERN))
                .offerTo(exporter);


        offerJackOLanternRecipe(exporter, PumpkinRegistry.BUTTERNUT_LANTERN, PumpkinRegistry.CARVED_BUTTERNUT_SQUASH);
        offerJackOLanternRecipe(exporter, PumpkinRegistry.GHOST_O_LANTERN, PumpkinRegistry.CARVED_GHOST_PUMPKIN);
        offerJackOLanternRecipe(exporter, PumpkinRegistry.KABOCHA_LANTERN, PumpkinRegistry.CARVED_KABOCHA);
        offerJackOLanternRecipe(exporter, PumpkinRegistry.MIDNIGHT_O_LANTERN, PumpkinRegistry.CARVED_MIDNIGHT_PUMPKIN);
        offerJackOLanternRecipe(exporter, PumpkinRegistry.MINI_JACK_O_LANTERN, PumpkinRegistry.CARVED_MINI_PUMPKIN);
        offerJackOLanternRecipe(exporter, PumpkinRegistry.SUGAR_O_LANTERN, PumpkinRegistry.CARVED_SUGAR_PUMPKIN);

        offerJackOSoulLanternRecipe(exporter, PumpkinRegistry.JACK_O_SOUL_LANTERN, Items.CARVED_PUMPKIN);
        offerJackOSoulLanternRecipe(exporter, PumpkinRegistry.BUTTERNUT_SOUL_LANTERN, PumpkinRegistry.CARVED_BUTTERNUT_SQUASH);
        offerJackOSoulLanternRecipe(exporter, PumpkinRegistry.GHOST_O_SOUL_LANTERN, PumpkinRegistry.CARVED_GHOST_PUMPKIN);
        offerJackOSoulLanternRecipe(exporter, PumpkinRegistry.KABOCHA_SOUL_LANTERN, PumpkinRegistry.CARVED_KABOCHA);
        offerJackOSoulLanternRecipe(exporter, PumpkinRegistry.MIDNIGHT_O_SOUL_LANTERN, PumpkinRegistry.CARVED_MIDNIGHT_PUMPKIN);
        offerJackOSoulLanternRecipe(exporter, PumpkinRegistry.MINI_JACK_O_SOUL_LANTERN, PumpkinRegistry.CARVED_MINI_PUMPKIN);
        offerJackOSoulLanternRecipe(exporter, PumpkinRegistry.SUGAR_O_SOUL_LANTERN, PumpkinRegistry.CARVED_SUGAR_PUMPKIN);

        offerEerieJackOLanternRecipe(exporter, PumpkinRegistry.EERIE_JACK_O_LANTERN, Items.CARVED_PUMPKIN);
        offerEerieJackOLanternRecipe(exporter, PumpkinRegistry.EERIE_BUTTERNUT_LANTERN, PumpkinRegistry.CARVED_BUTTERNUT_SQUASH);
        offerEerieJackOLanternRecipe(exporter, PumpkinRegistry.EERIE_GHOST_O_LANTERN, PumpkinRegistry.CARVED_GHOST_PUMPKIN);
        offerEerieJackOLanternRecipe(exporter, PumpkinRegistry.EERIE_KABOCHA_LANTERN, PumpkinRegistry.CARVED_KABOCHA);
        offerEerieJackOLanternRecipe(exporter, PumpkinRegistry.EERIE_MIDNIGHT_O_LANTERN, PumpkinRegistry.CARVED_MIDNIGHT_PUMPKIN);
        offerEerieJackOLanternRecipe(exporter, PumpkinRegistry.EERIE_MINI_JACK_O_LANTERN, PumpkinRegistry.CARVED_MINI_PUMPKIN);
        offerEerieJackOLanternRecipe(exporter, PumpkinRegistry.EERIE_SUGAR_O_LANTERN, PumpkinRegistry.CARVED_SUGAR_PUMPKIN);

        offerTinyJackOLanternRecipe(exporter, PumpkinRegistry.TINY_JACK_O_LANTERN,
                PumpkinRegistry.TINY_CARVED_PUMPKIN, Items.TORCH);
        offerTinyJackOLanternRecipe(exporter, PumpkinRegistry.TINY_JACK_O_SOUL_LANTERN,
                PumpkinRegistry.TINY_CARVED_PUMPKIN, Items.SOUL_TORCH);
        offerTinyJackOLanternRecipe(exporter, PumpkinRegistry.TINY_EERIE_JACK_O_LANTERN,
                PumpkinRegistry.TINY_CARVED_PUMPKIN, Items.REDSTONE_TORCH);


        offerShapelessRecipe(exporter, PumpkinItemRegistry.BUTTERNUT_SEEDS, PumpkinRegistry.BUTTERNUT_SQUASH,
                "", 4);
        offerShapelessRecipe(exporter, PumpkinItemRegistry.GHOST_PUMPKIN_SEEDS, PumpkinRegistry.GHOST_PUMPKIN,
                "", 4);
        offerShapelessRecipe(exporter, PumpkinItemRegistry.KABOCHA_SEEDS, PumpkinRegistry.KABOCHA,
                "", 4);
        offerShapelessRecipe(exporter, PumpkinItemRegistry.MIDNIGHT_PUMPKIN_SEEDS, PumpkinRegistry.MIDNIGHT_PUMPKIN,
                "", 4);
        offerShapelessRecipe(exporter, PumpkinItemRegistry.MINI_PUMPKIN_SEEDS, PumpkinRegistry.MINI_PUMPKIN,
                "", 4);
        offerShapelessRecipe(exporter, PumpkinItemRegistry.TINY_PUMPKIN_SEEDS, PumpkinRegistry.TINY_PUMPKIN,
                "", 1);

        offerFoodCookingRecipeFromTag(exporter, PumpkinItemTags.RAW_PUMPKIN_SEEDS,
                PumpkinItemRegistry.PEPITAS, 0.1F);




    }

    //METHODS ==========================================================================================================

    public static void offerCobwebRecipe(RecipeExporter exporter, ItemConvertible cobweb, ItemConvertible hangingCobweb,
                                         Ingredient ingredients) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, cobweb, 4)
                .input('#', Items.COBWEB)
                .input('I', ingredients)
                .pattern(" # ")
                .pattern("#I#")
                .pattern(" # ")
                .criterion(hasItem(Items.COBWEB), conditionsFromItem(Items.COBWEB))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, hangingCobweb, 3)
                .input('S', Items.STRING)
                .input('I', ingredients)
                .pattern("SIS")
                .pattern(" S ")
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(exporter);

    }




    public static void offerEngravedRecipes(RecipeExporter exporter, ItemConvertible stairsBlock,
                                            ItemConvertible slabBlock, ItemConvertible wallBlock,
                                            ItemConvertible pillarBlock, ItemConvertible pillarCapBlock,
                                            ItemConvertible input, ItemConvertible slab,
                                            Ingredient ingredients) {

        offerEngravedStairsRecipe(exporter, stairsBlock, input, ingredients);
        offerEngravedSlabRecipe(exporter, slabBlock, input, ingredients);
        offerEngravedWallRecipe(exporter, wallBlock, input, ingredients);
        offerEngravedPillarRecipe(exporter, pillarBlock, input, ingredients);
        offerEngravedPillarCapRecipe(exporter, pillarCapBlock, input, slab, ingredients);

    }

    public static void offerEngravedStairsRecipe(RecipeExporter exporter, ItemConvertible output,
                                         ItemConvertible input, Ingredient ingredients) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 6)
                .input('#', input)
                .pattern("  #")
                .pattern(" ##")
                .pattern("###")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(
                        ingredients, RecipeCategory.BUILDING_BLOCKS, output, 1)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, getItemPath(output) + "_from_stonecutting");
    }

    public static void offerEngravedSlabRecipe(RecipeExporter exporter, ItemConvertible output,
                                                 ItemConvertible input, Ingredient ingredients) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 6)
                .input('#', input)
                .pattern("###")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(
                        ingredients, RecipeCategory.BUILDING_BLOCKS, output, 2)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, getItemPath(output) + "_from_stonecutting");
    }

    public static void offerEngravedWallRecipe(RecipeExporter exporter, ItemConvertible output,
                                                 ItemConvertible input, Ingredient ingredients) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 6)
                .input('#', input)
                .pattern("###")
                .pattern("###")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(
                        ingredients, RecipeCategory.BUILDING_BLOCKS, output, 1)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, getItemPath(output) + "_from_stonecutting");
    }

    public static void offerEngravedPillarRecipe(RecipeExporter exporter, ItemConvertible output,
                                               ItemConvertible input, Ingredient ingredients) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 2)
                .input('#', input)
                .pattern("#")
                .pattern("#")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(
                        ingredients, RecipeCategory.BUILDING_BLOCKS, output, 1)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, getItemPath(output) + "_from_stonecutting");
    }

    public static void offerEngravedPillarCapRecipe(RecipeExporter exporter, ItemConvertible output,
                                                 ItemConvertible input, ItemConvertible slab, Ingredient ingredients) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 1)
                .input('#', slab)
                .pattern("#")
                .pattern("#")
                .criterion(hasItem(slab), conditionsFromItem(slab))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(
                        ingredients, RecipeCategory.BUILDING_BLOCKS, output, 1)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, getItemPath(output) + "_from_stonecutting");
    }


    public static void offerMossyRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapelessRecipeJsonBuilder
                .create(RecipeCategory.BUILDING_BLOCKS, output, 1)
                .input(input)
                .input(Ingredient.ofItems(Blocks.MOSS_BLOCK, Blocks.VINE))
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, getItemPath(output) + "_from_" + getItemPath(input));
    }

    public static void offerCookieRecipe(RecipeExporter exporter, ItemConvertible output,
                                        ItemConvertible ingredient) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, output, 8)
                .input('P', Ingredient.fromTag(PumpkinItemTags.PUMPKINS))
                .input('W', Items.WHEAT)
                .input('#', ingredient)
                .pattern(" # ")
                .pattern("WPW")
                .pattern(" # ")
                .criterion(hasItem(ingredient), conditionsFromItem(ingredient))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder
                .create(RecipeCategory.FOOD, output, 8)
                .input(PumpkinRegistry.TINY_PUMPKIN, 4)
                .input(Items.WHEAT, 2)
                .input(ingredient, 2)
                .criterion(hasItem(ingredient), conditionsFromItem(ingredient))
                .offerTo(exporter, getItemPath(output) + "_from_tiny_pumpkin");
    }


    public static void offerCandyRecipe(RecipeExporter exporter, ItemConvertible output,
                                                ItemConvertible ingredient) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, output, 4)
                .input('S', Items.SUGAR)
                .input('#', ingredient)
                .pattern(" S ")
                .pattern("S#S")
                .pattern(" S ")
                .criterion(hasItem(ingredient), conditionsFromItem(ingredient))
                .offerTo(exporter);
    }




    public static void offerPumpkinCakeRecipe(RecipeExporter exporter, ItemConvertible output,
                                        ItemConvertible ingredient) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, output, 4)
                .input('M', Items.MILK_BUCKET)
                .input('S', Items.SUGAR)
                .input('#', ingredient)
                .input('W', Items.WHEAT)
                .input('P', PumpkinItemTags.PUMPKINS)
                .pattern("MMM")
                .pattern("S#S")
                .pattern("WPW")
                .criterion(hasItem(ingredient), conditionsFromItem(ingredient))
                .offerTo(exporter);
    }


    public static void offerJackOLanternRecipe(RecipeExporter exporter, ItemConvertible jackOLantern, ItemConvertible carvedSquash) {
        offerSquashLanternRecipe(exporter, jackOLantern, carvedSquash, Items.TORCH);
    }

    public static void offerJackOSoulLanternRecipe(RecipeExporter exporter, ItemConvertible jackOLantern, ItemConvertible carvedSquash) {
        offerSquashLanternRecipe(exporter, jackOLantern, carvedSquash, Items.SOUL_TORCH);
    }

    public static void offerEerieJackOLanternRecipe(RecipeExporter exporter, ItemConvertible jackOLantern, ItemConvertible carvedSquash) {
        offerSquashLanternRecipe(exporter, jackOLantern, carvedSquash, Items.REDSTONE_TORCH);
    }

    public static void offerSquashLanternRecipe(RecipeExporter exporter, ItemConvertible output,
                                               ItemConvertible carvedSquash, ItemConvertible torch) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 1)
                .input('S', carvedSquash)
                .input('T', torch)
                .pattern("S")
                .pattern("T")
                .criterion(hasItem(carvedSquash), conditionsFromItem(carvedSquash))
                .offerTo(exporter);
    }

    public static void offerTinyJackOLanternRecipe(RecipeExporter exporter, ItemConvertible output,
                                                ItemConvertible carvedSquash, ItemConvertible torch) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 4)
                .input('S', carvedSquash)
                .input('T', torch)
                .pattern(" S ")
                .pattern("STS")
                .pattern(" S ")
                .criterion(hasItem(carvedSquash), conditionsFromItem(carvedSquash))
                .offerTo(exporter);
    }

    public static <T extends AbstractCookingRecipe> void offerFoodCookingRecipeFromTag(
            RecipeExporter exporter, TagKey<Item> input, ItemConvertible output, float experience) {

        CookingRecipeJsonBuilder.create(Ingredient.fromTag(input), RecipeCategory.FOOD,
                        output, experience, 200, RecipeSerializer.SMELTING,
                        SmeltingRecipe::new)
                .criterion("has_item", conditionsFromTag(input))
                .offerTo(exporter, getItemPath(output) + "_from_smelting");

        CookingRecipeJsonBuilder.create(Ingredient.fromTag(input), RecipeCategory.FOOD,
                        output, experience, 100, RecipeSerializer.SMOKING,
                        SmokingRecipe::new)
                .criterion("has_item", conditionsFromTag(input))
                .offerTo(exporter, getItemPath(output) + "_from_smoking");

        CookingRecipeJsonBuilder.create(Ingredient.fromTag(input), RecipeCategory.FOOD,
                        output, experience, 600, RecipeSerializer.CAMPFIRE_COOKING,
                        CampfireCookingRecipe::new)
                .criterion("has_item", conditionsFromTag(input))
                .offerTo(exporter, getItemPath(output) + "_from_campfire_cooking");

    }

}
