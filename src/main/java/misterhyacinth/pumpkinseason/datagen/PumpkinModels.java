package misterhyacinth.pumpkinseason.datagen;

import misterhyacinth.pumpkinseason.PumpkinSeason;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class PumpkinModels {


    //TEXTURE MAPS =====================================================================================================


    public static TextureMap frontMap(Block block) {
        return TextureMap.of(TextureKey.FRONT, TextureMap.getId(block));
    }

    public static TextureMap sideAsFrontMap(Block block) {
        return TextureMap.of(TextureKey.FRONT, TextureMap.getSubId(block, "_side"));
    }

    public static TextureMap cakeMap(Block block) {
        return new TextureMap()
                .put(TextureKey.PARTICLE, TextureMap.getSubId(block, "_side"))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(block, "_bottom"))
                .put(TextureKey.TOP, TextureMap.getSubId(block, "_top"))
                .put(TextureKey.SIDE, TextureMap.getSubId(block, "_side"));
    }

    public static TextureMap cakeSliceMap(Block block) {
        return new TextureMap()
                .put(TextureKey.PARTICLE, TextureMap.getSubId(block, "_side"))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(block, "_bottom"))
                .put(TextureKey.TOP, TextureMap.getSubId(block, "_top"))
                .put(TextureKey.SIDE, TextureMap.getSubId(block, "_side"))
                .put(TextureKey.INSIDE, TextureMap.getSubId(block, "_inner"));
    }

    public static TextureMap sidedStairsMap(Block block) {
        return new TextureMap()
                .put(TextureKey.BOTTOM, TextureMap.getId(block))
                .put(TextureKey.BACK, TextureMap.getId(block))
                .put(TextureKey.SIDE, TextureMap.getSubId(block, "_corners"))
                .put(TextureKey.FRONT, TextureMap.getSubId(block, "_horizontal"))
                .put(TextureKey.TOP, TextureMap.getSubId(block, "_vertical"));
    }
    public static TextureMap sidedStairsZMap(Block block) {
        return new TextureMap()
                .put(TextureKey.BOTTOM, TextureMap.getId(block))
                .put(TextureKey.BACK, TextureMap.getId(block))
                .put(TextureKey.SIDE, TextureMap.getSubId(block, "_corners"))
                .put(TextureKey.FRONT, TextureMap.getSubId(block, "_horizontal"))
                .put(TextureKey.TOP, TextureMap.getSubId(block, "_horizontal"));
    }
    public static TextureMap sidedStairsInnerMap(Block block) {
        return new TextureMap()
                .put(TextureKey.BOTTOM, TextureMap.getId(block))
                .put(TextureKey.BACK, TextureMap.getId(block))
                .put(TextureKey.SIDE, TextureMap.getSubId(block, "_corners"))
                .put(TextureKey.FRONT, TextureMap.getSubId(block, "_horizontal"))
                .put(TextureKey.TOP, TextureMap.getSubId(block, "_corners"));
    }
    public static TextureMap sidedStairsOuterMap(Block block) {
        return new TextureMap()
                .put(TextureKey.BOTTOM, TextureMap.getId(block))
                .put(TextureKey.SIDE, TextureMap.getSubId(block, "_corners"))
                .put(TextureKey.FRONT, TextureMap.getSubId(block, "_horizontal"))
                .put(TextureKey.TOP, TextureMap.getSubId(block, "_corners"));
    }

    public static TextureMap sidedSlabMap(Block block) {
        return new TextureMap()
                .put(TextureKey.BOTTOM, TextureMap.getId(block))
                .put(TextureKey.SIDE, TextureMap.getSubId(block, "_horizontal"))
                .put(TextureKey.TOP, TextureMap.getId(block));
    }

    public static TextureMap doubleSidedSlabMap(Block block) {
        return new TextureMap()
                .put(TextureKey.END, TextureMap.getId(block))
                .put(TextureKey.SIDE, TextureMap.getSubId(block, "_horizontal"));
    }


    public static TextureMap wallMap(Block block) {
        return new TextureMap()
                .put(TextureKey.SIDE, TextureMap.getId(block))
                .put(TextureKey.TOP, TextureMap.getSubId(block, "_top"));
    }

    public static TextureMap wallSideMap(Block block) {
        return new TextureMap()
                .put(TextureKey.SIDE, TextureMap.getSubId(block, "_side"))
                .put(TextureKey.TOP, TextureMap.getSubId(block, "_side_top"));
    }


    public static TextureMap columnMap(Block block) {
        return (new TextureMap())
                .put(TextureKey.SIDE, TextureMap.getId(block))
                .put(TextureKey.END, TextureMap.getSubId(block, "_end"));
    }

    public static TextureMap columnTopMap(Block block) {
        return (new TextureMap())
                .put(TextureKey.SIDE, TextureMap.getSubId(block, "_top"))
                .put(TextureKey.END, TextureMap.getSubId(block, "_end"));
    }

    public static TextureMap columnBottomMap(Block block) {
        return (new TextureMap())
                .put(TextureKey.SIDE, TextureMap.getSubId(block, "_bottom"))
                .put(TextureKey.END, TextureMap.getSubId(block, "_end"));
    }

    public static TextureMap columnMiddleMap(Block block) {
        return (new TextureMap())
                .put(TextureKey.SIDE, TextureMap.getSubId(block, "_middle"))
                .put(TextureKey.END, TextureMap.getSubId(block, "_end"));
    }

    public static TextureMap pillarCapMap(Block block) {
        return (new TextureMap())
                .put(TextureKey.SIDE, TextureMap.getSubId(block, "_cap"))
                .put(TextureKey.END, TextureMap.getSubId(block, "_end"));
    }

    public static TextureMap cobweb0(Block block) {
        return TextureMap.of(TextureKey.TEXTURE, TextureMap.getSubId(block, "0"));
    }
    public static TextureMap cobweb1(Block block) {
        return TextureMap.of(TextureKey.TEXTURE, TextureMap.getSubId(block, "1"));
    }
    public static TextureMap cobweb2(Block block) {
        return TextureMap.of(TextureKey.TEXTURE, TextureMap.getSubId(block, "2"));
    }
    public static TextureMap cobweb_corner(Block block) {
        return TextureMap.of(TextureKey.TEXTURE, TextureMap.getSubId(block, "_corner0"));
    }
    public static TextureMap cobweb_corner1(Block block) {
        return TextureMap.of(TextureKey.TEXTURE, TextureMap.getSubId(block, "_corner1"));
    }
    public static TextureMap cobweb_corner_both(Block block) {
        return TextureMap.of(TextureKey.TEXTURE, TextureMap.getSubId(block, "_corner_both"));
    }


    //MODELS ===========================================================================================================

    public static final Model HANGING_COBWEB = new Model(
            Optional.of(Identifier.of(PumpkinSeason.MOD_ID, "block/template/hanging_cobweb")),
            Optional.empty(),
            TextureKey.TEXTURE);


    public static final Model WALL_INVENTORY = new Model(
            Optional.of(Identifier.of(PumpkinSeason.MOD_ID, "block/template/wall_inventory")),
            Optional.empty(), TextureKey.SIDE, TextureKey.TOP);
    public static final Model WALL_POST = new Model(
            Optional.of(Identifier.of(PumpkinSeason.MOD_ID, "block/template/wall_post")),
            Optional.empty(), TextureKey.SIDE, TextureKey.TOP);
    public static final Model WALL_SIDE = new Model(
            Optional.of(Identifier.of(PumpkinSeason.MOD_ID, "block/template/wall_side")),
            Optional.empty(), TextureKey.SIDE, TextureKey.TOP);
    public static final Model WALL_SIDE_TALL = new Model(
            Optional.of(Identifier.of(PumpkinSeason.MOD_ID, "block/template/wall_side_tall")),
            Optional.empty(), TextureKey.SIDE, TextureKey.TOP);



    public static final Model SIDED_STAIRS = new Model(
            Optional.of(Identifier.of(PumpkinSeason.MOD_ID, "block/template/sided_stairs")),
            Optional.empty(), TextureKey.BOTTOM, TextureKey.SIDE, TextureKey.FRONT, TextureKey.TOP, TextureKey.BACK);
    public static final Model INNER_SIDED_STAIRS = new Model(
            Optional.of(Identifier.of(PumpkinSeason.MOD_ID, "block/template/inner_sided_stairs")),
            Optional.empty(), TextureKey.BOTTOM, TextureKey.SIDE, TextureKey.FRONT, TextureKey.TOP, TextureKey.BACK);
    public static final Model OUTER_SIDED_STAIRS = new Model(
            Optional.of(Identifier.of(PumpkinSeason.MOD_ID, "block/template/outer_sided_stairs")),
            Optional.empty(), TextureKey.BOTTOM, TextureKey.SIDE, TextureKey.FRONT, TextureKey.TOP);




    public static final Model CAKE = new Model(
            Optional.of(Identifier.ofVanilla("block/cake")),
            Optional.empty(), TextureKey.PARTICLE, TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE);
    public static final Model CAKE_SLICE1 = new Model(
            Optional.of(Identifier.ofVanilla("block/cake_slice1")),
            Optional.empty(), TextureKey.PARTICLE, TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE, TextureKey.INSIDE);
    public static final Model CAKE_SLICE2 = new Model(
            Optional.of(Identifier.ofVanilla("block/cake_slice2")),
            Optional.empty(), TextureKey.PARTICLE, TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE, TextureKey.INSIDE);
    public static final Model CAKE_SLICE3 = new Model(
            Optional.of(Identifier.ofVanilla("block/cake_slice3")),
            Optional.empty(), TextureKey.PARTICLE, TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE, TextureKey.INSIDE);
    public static final Model CAKE_SLICE4 = new Model(
            Optional.of(Identifier.ofVanilla("block/cake_slice4")),
            Optional.empty(), TextureKey.PARTICLE, TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE, TextureKey.INSIDE);
    public static final Model CAKE_SLICE5 = new Model(
            Optional.of(Identifier.ofVanilla("block/cake_slice5")),
            Optional.empty(), TextureKey.PARTICLE, TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE, TextureKey.INSIDE);
    public static final Model CAKE_SLICE6 = new Model(
            Optional.of(Identifier.ofVanilla("block/cake_slice6")),
            Optional.empty(), TextureKey.PARTICLE, TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE, TextureKey.INSIDE);



    public static final Model PUMPKIN = new Model(
            Optional.of(Identifier.ofVanilla("block/pumpkin_template")),
            Optional.empty(), TextureKey.FRONT);


    public static final Model BUTTERNUT_SQUASH = new Model(
            Optional.of(Identifier.of(PumpkinSeason.MOD_ID, "block/template/butternut_squash")),
            Optional.empty(), TextureKey.FRONT);

    public static final Model GHOST_PUMPKIN = new Model(
            Optional.of(Identifier.of(PumpkinSeason.MOD_ID, "block/template/ghost_pumpkin")),
            Optional.empty(), TextureKey.FRONT);

    public static final Model KABOCHA = new Model(
            Optional.of(Identifier.of(PumpkinSeason.MOD_ID, "block/template/kabocha")),
            Optional.empty(), TextureKey.FRONT);

    public static final Model MIDNIGHT_PUMPKIN = new Model(
            Optional.of(Identifier.of(PumpkinSeason.MOD_ID, "block/template/midnight_pumpkin")),
            Optional.empty(), TextureKey.FRONT);

    public static final Model MINI_PUMPKIN = new Model(
            Optional.of(Identifier.of(PumpkinSeason.MOD_ID, "block/template/mini_pumpkin")),
            Optional.empty(), TextureKey.FRONT);

    public static final Model SUGAR_PUMPKIN = new Model(
            Optional.of(Identifier.of(PumpkinSeason.MOD_ID, "block/template/sugar_pumpkin")),
            Optional.empty(), TextureKey.FRONT);

    public static final Model ONE_TINY_PUMPKIN = new Model(
            Optional.of(Identifier.of(PumpkinSeason.MOD_ID, "block/template/one_tiny_pumpkin")),
            Optional.empty(), TextureKey.FRONT);
    public static final Model TWO_TINY_PUMPKINS = new Model(
            Optional.of(Identifier.of(PumpkinSeason.MOD_ID, "block/template/two_tiny_pumpkins")),
            Optional.empty(), TextureKey.FRONT);
    public static final Model THREE_TINY_PUMPKINS = new Model(
            Optional.of(Identifier.of(PumpkinSeason.MOD_ID, "block/template/three_tiny_pumpkins")),
            Optional.empty(), TextureKey.FRONT);
    public static final Model FOUR_TINY_PUMPKINS = new Model(
            Optional.of(Identifier.of(PumpkinSeason.MOD_ID, "block/template/four_tiny_pumpkins")),
            Optional.empty(), TextureKey.FRONT);


    //TEXTURED MODELS ==================================================================================================


    public static final TexturedModel.Factory TINY_PUMPKIN_1 =
            TexturedModel.makeFactory(PumpkinModels::frontMap, ONE_TINY_PUMPKIN);
    public static final TexturedModel.Factory TINY_PUMPKIN_2 =
            TexturedModel.makeFactory(PumpkinModels::frontMap, TWO_TINY_PUMPKINS);
    public static final TexturedModel.Factory TINY_PUMPKIN_3 =
            TexturedModel.makeFactory(PumpkinModels::frontMap, THREE_TINY_PUMPKINS);
    public static final TexturedModel.Factory TINY_PUMPKIN_4 =
            TexturedModel.makeFactory(PumpkinModels::frontMap, FOUR_TINY_PUMPKINS);

}
