package misterhyacinth.pumpkinseason.datagen;

import misterhyacinth.pumpkinseason.PumpkinItemRegistry;
import misterhyacinth.pumpkinseason.PumpkinRegistry;
import misterhyacinth.pumpkinseason.block.*;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.AbstractCandleBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.StairShape;
import net.minecraft.data.client.*;
import net.minecraft.item.Items;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.List;

public class PumpkinModelProvider extends FabricModelProvider {
    public PumpkinModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {


        generator.registerTintableCross(PumpkinRegistry.GLOW_IN_THE_DARK_COBWEB, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerTintableCross(PumpkinRegistry.GREEN_COBWEB, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerTintableCross(PumpkinRegistry.ORANGE_COBWEB, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerTintableCross(PumpkinRegistry.PURPLE_COBWEB, BlockStateModelGenerator.TintType.NOT_TINTED);

        registerHangingCobweb(PumpkinRegistry.HANGING_COBWEB, generator);
        registerHangingCobweb(PumpkinRegistry.GLOW_IN_THE_DARK_HANGING_COBWEB, generator);
        registerHangingCobweb(PumpkinRegistry.GREEN_HANGING_COBWEB, generator);
        registerHangingCobweb(PumpkinRegistry.ORANGE_HANGING_COBWEB, generator);
        registerHangingCobweb(PumpkinRegistry.PURPLE_HANGING_COBWEB, generator);

        registerStatue(PumpkinRegistry.STONE_GARGOYLE, generator);
        registerStatue(PumpkinRegistry.BLACKSTONE_GARGOYLE, generator);
        registerStatue(PumpkinRegistry.EERIE_STONE_GARGOYLE, generator);
        registerStatue(PumpkinRegistry.EERIE_BLACKSTONE_GARGOYLE, generator);

        registerStatue(PumpkinRegistry.STONE_ANGEL, generator);
        registerStatue(PumpkinRegistry.BLACKSTONE_ANGEL, generator);
        registerStatue(PumpkinRegistry.EERIE_STONE_ANGEL, generator);
        registerStatue(PumpkinRegistry.EERIE_BLACKSTONE_ANGEL, generator);

        registerStatue(PumpkinRegistry.STONE_GRAVE_MARKER, generator);
        registerStatue(PumpkinRegistry.BLACKSTONE_GRAVE_MARKER, generator);
        registerStatue(PumpkinRegistry.EERIE_STONE_GRAVE_MARKER, generator);
        registerStatue(PumpkinRegistry.EERIE_BLACKSTONE_GRAVE_MARKER, generator);

        registerStatue(PumpkinRegistry.STONE_CROSS_GRAVE_MARKER, generator);
        registerStatue(PumpkinRegistry.BLACKSTONE_CROSS_GRAVE_MARKER, generator);
        registerStatue(PumpkinRegistry.STONE_OBELISK_GRAVE_MARKER, generator);
        registerStatue(PumpkinRegistry.BLACKSTONE_OBELISK_GRAVE_MARKER, generator);

        generator.registerSimpleCubeAll(PumpkinRegistry.ENGRAVED_STONE);
        registerEngravedStairs(PumpkinRegistry.ENGRAVED_STONE, PumpkinRegistry.ENGRAVED_STONE_STAIRS, generator);
        registerEngravedSlab(PumpkinRegistry.ENGRAVED_STONE, PumpkinRegistry.ENGRAVED_STONE_SLAB, generator);
        registerEngravedWall(PumpkinRegistry.ENGRAVED_STONE_WALL, generator);
        registerPillar(PumpkinRegistry.ENGRAVED_STONE_PILLAR, generator);
        registerPillarCap(PumpkinRegistry.ENGRAVED_STONE_PILLAR_CAP, PumpkinRegistry.ENGRAVED_STONE_PILLAR, generator);

        generator.registerSimpleCubeAll(PumpkinRegistry.MOSSY_ENGRAVED_STONE);
        registerEngravedStairs(PumpkinRegistry.MOSSY_ENGRAVED_STONE, PumpkinRegistry.MOSSY_ENGRAVED_STONE_STAIRS, generator);
        registerEngravedSlab(PumpkinRegistry.MOSSY_ENGRAVED_STONE, PumpkinRegistry.MOSSY_ENGRAVED_STONE_SLAB, generator);
        registerEngravedWall(PumpkinRegistry.MOSSY_ENGRAVED_STONE_WALL, generator);
        registerPillar(PumpkinRegistry.MOSSY_ENGRAVED_STONE_PILLAR, generator);
        registerPillarCap(PumpkinRegistry.MOSSY_ENGRAVED_STONE_PILLAR_CAP, PumpkinRegistry.MOSSY_ENGRAVED_STONE_PILLAR, generator);

        generator.registerSimpleCubeAll(PumpkinRegistry.ENGRAVED_BLACKSTONE);
        registerEngravedStairs(PumpkinRegistry.ENGRAVED_BLACKSTONE, PumpkinRegistry.ENGRAVED_BLACKSTONE_STAIRS, generator);
        registerEngravedSlab(PumpkinRegistry.ENGRAVED_BLACKSTONE, PumpkinRegistry.ENGRAVED_BLACKSTONE_SLAB, generator);
        registerEngravedWall(PumpkinRegistry.ENGRAVED_BLACKSTONE_WALL, generator);
        registerPillar(PumpkinRegistry.ENGRAVED_BLACKSTONE_PILLAR, generator);
        registerPillarCap(PumpkinRegistry.ENGRAVED_BLACKSTONE_PILLAR_CAP, PumpkinRegistry.ENGRAVED_BLACKSTONE_PILLAR, generator);


        registerPie(PumpkinRegistry.JACK_O_LANTERN_PIE, generator);
        registerPie(PumpkinRegistry.BOOBERRY_PIE, generator);

        registerCake(PumpkinRegistry.PUMPKIN_CAKE, generator);
        registerCake(PumpkinRegistry.BOOBERRY_PUMPKIN_CAKE, generator);
        registerCake(PumpkinRegistry.DARK_CHOCOLATE_PUMPKIN_CAKE, generator);

        registerSpookyCandle(PumpkinRegistry.BAT_CANDLE, generator);
        registerSpookyCandle(PumpkinRegistry.PUMPKIN_CANDLE, generator);
        registerSpookyCandle(PumpkinRegistry.CREEPY_PUMPKIN_CANDLE, generator);
        registerSpookyCandle(PumpkinRegistry.SKULL_CANDLE, generator);

        registerSpookyCandle(PumpkinRegistry.BAT_CANDLE_PUMPKIN_CAKE, generator);
        registerSpookyCandle(PumpkinRegistry.BAT_CANDLE_BOOBERRY_PUMPKIN_CAKE, generator);
        registerSpookyCandle(PumpkinRegistry.BAT_CANDLE_DARK_CHOCOLATE_PUMPKIN_CAKE, generator);

        registerSpookyCandle(PumpkinRegistry.PUMPKIN_CANDLE_PUMPKIN_CAKE, generator);
        registerSpookyCandle(PumpkinRegistry.PUMPKIN_CANDLE_BOOBERRY_PUMPKIN_CAKE, generator);
        registerSpookyCandle(PumpkinRegistry.PUMPKIN_CANDLE_DARK_CHOCOLATE_PUMPKIN_CAKE, generator);

        registerSpookyCandle(PumpkinRegistry.CREEPY_PUMPKIN_CANDLE_PUMPKIN_CAKE, generator);
        registerSpookyCandle(PumpkinRegistry.CREEPY_PUMPKIN_CANDLE_BOOBERRY_PUMPKIN_CAKE, generator);
        registerSpookyCandle(PumpkinRegistry.CREEPY_PUMPKIN_CANDLE_DARK_CHOCOLATE_PUMPKIN_CAKE, generator);

        registerSpookyCandle(PumpkinRegistry.SKULL_CANDLE_PUMPKIN_CAKE, generator);
        registerSpookyCandle(PumpkinRegistry.SKULL_CANDLE_BOOBERRY_PUMPKIN_CAKE, generator);
        registerSpookyCandle(PumpkinRegistry.SKULL_CANDLE_DARK_CHOCOLATE_PUMPKIN_CAKE, generator);


        registerSpookyLantern(PumpkinRegistry.SKULL_LANTERN, generator);
        registerSpookyLantern(PumpkinRegistry.WITHER_SKULL_LANTERN, generator);
        registerSpookyLantern(PumpkinRegistry.BAT_LANTERN, generator);
        registerSpookyLantern(PumpkinRegistry.SPIDER_LANTERN, generator);
        registerSpookyLantern(PumpkinRegistry.PUMPKIN_LANTERN, generator);
        registerSpookyLantern(PumpkinRegistry.CREEPY_PUMPKIN_LANTERN, generator);
        registerSpookyLantern(PumpkinRegistry.GHASTLY_LANTERN, generator);
        registerSpookyLantern(PumpkinRegistry.CRESCENT_MOON_LANTERN, generator);
        registerSpookyLantern(PumpkinRegistry.BLACK_CAT_LANTERN, generator);

        registerCandyBowl(PumpkinRegistry.BOWL_OF_SWEETS, generator);

        registerNorthDefaultHorizontalRotatable(PumpkinRegistry.JACK_O_SOUL_LANTERN, PumpkinModels.PUMPKIN, generator);
        registerNorthDefaultHorizontalRotatable(PumpkinRegistry.EERIE_JACK_O_LANTERN, PumpkinModels.PUMPKIN, generator);

        registerSquash(PumpkinRegistry.BUTTERNUT_SQUASH, PumpkinRegistry.CARVED_BUTTERNUT_SQUASH,
                PumpkinRegistry.BUTTERNUT_LANTERN, PumpkinRegistry.BUTTERNUT_SOUL_LANTERN,
                PumpkinRegistry.EERIE_BUTTERNUT_LANTERN,
                PumpkinModels.BUTTERNUT_SQUASH, generator);
        registerSquash(PumpkinRegistry.GHOST_PUMPKIN, PumpkinRegistry.CARVED_GHOST_PUMPKIN,
                PumpkinRegistry.GHOST_O_LANTERN, PumpkinRegistry.GHOST_O_SOUL_LANTERN,
                PumpkinRegistry.EERIE_GHOST_O_LANTERN,
                PumpkinModels.GHOST_PUMPKIN, generator);
        registerSquash(PumpkinRegistry.KABOCHA, PumpkinRegistry.CARVED_KABOCHA,
                PumpkinRegistry.KABOCHA_LANTERN, PumpkinRegistry.KABOCHA_SOUL_LANTERN,
                PumpkinRegistry.EERIE_KABOCHA_LANTERN,
                PumpkinModels.KABOCHA, generator);
        registerSquash(PumpkinRegistry.MIDNIGHT_PUMPKIN, PumpkinRegistry.CARVED_MIDNIGHT_PUMPKIN,
                PumpkinRegistry.MIDNIGHT_O_LANTERN, PumpkinRegistry.MIDNIGHT_O_SOUL_LANTERN,
                PumpkinRegistry.EERIE_MIDNIGHT_O_LANTERN,
                PumpkinModels.MIDNIGHT_PUMPKIN, generator);
        registerSquash(PumpkinRegistry.MINI_PUMPKIN, PumpkinRegistry.CARVED_MINI_PUMPKIN,
                PumpkinRegistry.MINI_JACK_O_LANTERN, PumpkinRegistry.MINI_JACK_O_SOUL_LANTERN,
                PumpkinRegistry.EERIE_MINI_JACK_O_LANTERN,
                PumpkinModels.MINI_PUMPKIN, generator);
        registerSquash(PumpkinRegistry.SUGAR_PUMPKIN, PumpkinRegistry.CARVED_SUGAR_PUMPKIN,
                PumpkinRegistry.SUGAR_O_LANTERN, PumpkinRegistry.SUGAR_O_SOUL_LANTERN,
                PumpkinRegistry.EERIE_SUGAR_O_LANTERN,
                PumpkinModels.SUGAR_PUMPKIN, generator);

        registerTinyPumpkin(PumpkinRegistry.TINY_PUMPKIN, generator);
        registerTinyPumpkin(PumpkinRegistry.TINY_CARVED_PUMPKIN, generator);
        registerTinyPumpkin(PumpkinRegistry.TINY_JACK_O_LANTERN, generator);
        registerTinyPumpkin(PumpkinRegistry.TINY_JACK_O_SOUL_LANTERN, generator);
        registerTinyPumpkin(PumpkinRegistry.TINY_EERIE_JACK_O_LANTERN, generator);

        generator.registerGourd(PumpkinRegistry.BUTTERNUT_STEM, PumpkinRegistry.ATTACHED_BUTTERNUT_STEM);
        generator.registerGourd(PumpkinRegistry.GHOST_PUMPKIN_STEM, PumpkinRegistry.ATTACHED_GHOST_PUMPKIN_STEM);
        generator.registerGourd(PumpkinRegistry.KABOCHA_STEM, PumpkinRegistry.ATTACHED_KABOCHA_STEM);
        generator.registerGourd(PumpkinRegistry.MIDNIGHT_PUMPKIN_STEM, PumpkinRegistry.ATTACHED_MIDNIGHT_PUMPKIN_STEM);
        generator.registerGourd(PumpkinRegistry.MINI_PUMPKIN_STEM, PumpkinRegistry.ATTACHED_MINI_PUMPKIN_STEM);
        generator.registerGourd(PumpkinRegistry.SUGAR_PUMPKIN_STEM, PumpkinRegistry.ATTACHED_SUGAR_PUMPKIN_STEM);
        generator.registerGourd(PumpkinRegistry.TINY_PUMPKIN_STEM, PumpkinRegistry.ATTACHED_TINY_PUMPKIN_STEM);

        //BOOBERRIES ===================================================================================================


        generator.registerItemModel(PumpkinItemRegistry.BOOBERRIES);

        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(PumpkinRegistry.BOOBERRY_BUSH)
                .coordinate(BlockStateVariantMap.create(Properties.AGE_3).register((stage) -> {
                    return BlockStateVariant.create().put(VariantSettings.MODEL,
                            generator.createSubModel(PumpkinRegistry.BOOBERRY_BUSH, "_stage" + stage,
                                    Models.CROSS, TextureMap::cross));
                })));



    }


    //METHODS ==========================================================================================================


    public final void registerHangingCobweb(Block cobweb, BlockStateModelGenerator generator) {
        generator.registerItemModel(cobweb, "0");

        TextureMap textureMap = PumpkinModels.cobweb0(cobweb);
        TextureMap textureMap1 = PumpkinModels.cobweb1(cobweb);
        TextureMap textureMap2 = PumpkinModels.cobweb2(cobweb);
        TextureMap textureMapCorner = PumpkinModels.cobweb_corner(cobweb);
        TextureMap textureMapCorner1 = PumpkinModels.cobweb_corner1(cobweb);
        TextureMap textureMapCornerBoth = PumpkinModels.cobweb_corner_both(cobweb);

        Identifier identifier = PumpkinModels.HANGING_COBWEB.upload(cobweb, textureMap, generator.modelCollector);
        Identifier identifier1 = PumpkinModels.HANGING_COBWEB.upload(cobweb, "1", textureMap1, generator.modelCollector);
        Identifier identifier2 = PumpkinModels.HANGING_COBWEB.upload(cobweb, "2", textureMap2, generator.modelCollector);
        Identifier identifier_corner = PumpkinModels.HANGING_COBWEB.upload(cobweb, "_corner", textureMapCorner, generator.modelCollector);
        Identifier identifier_corner1 = PumpkinModels.HANGING_COBWEB.upload(cobweb, "_corner1", textureMapCorner1, generator.modelCollector);
        Identifier identifier_corner_both = PumpkinModels.HANGING_COBWEB.upload(cobweb, "_corner_both", textureMapCornerBoth, generator.modelCollector);

        generator.blockStateCollector.accept(VariantsBlockStateSupplier
                .create(cobweb)
                .coordinate(BlockStateVariantMap.create(Properties.HORIZONTAL_FACING, HangingCobwebBlock.CORNER)
                        .register(Direction.EAST, CobwebCorner.NONE,
                                List.of(
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R90),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier1)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R90),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier2)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R90),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier1)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier2)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                                ))
                        .register(Direction.EAST, CobwebCorner.LEFT,
                                List.of(
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier_corner)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier_corner1)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                                ))
                        .register(Direction.EAST, CobwebCorner.RIGHT,
                                List.of(
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier_corner)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R90),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier_corner1)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                ))
                        .register(Direction.EAST, CobwebCorner.BOTH,
                                List.of(
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier_corner_both)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R90),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier_corner_both)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                                ))

                        .register(Direction.NORTH, CobwebCorner.NONE,
                                List.of(
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier1),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier2),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R180),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier1)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R180),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier2)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                                ))
                        .register(Direction.NORTH, CobwebCorner.LEFT,
                                List.of(
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier_corner)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R180),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier_corner1)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                                ))
                        .register(Direction.NORTH, CobwebCorner.RIGHT,
                                List.of(
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier_corner),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier_corner1)
                                ))
                        .register(Direction.NORTH, CobwebCorner.BOTH,
                                List.of(
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier_corner_both),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier_corner_both)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                                ))

                        .register(Direction.SOUTH, CobwebCorner.NONE,
                                List.of(
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R180),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier1)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R180),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier2)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R180),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier1),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier2)
                                ))
                        .register(Direction.SOUTH, CobwebCorner.LEFT,
                                List.of(
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier_corner),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier_corner1)
                                ))
                        .register(Direction.SOUTH, CobwebCorner.RIGHT,
                                List.of(
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier_corner)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R180),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier_corner1)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                                ))
                        .register(Direction.SOUTH, CobwebCorner.BOTH,
                                List.of(
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier_corner_both)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R180),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier_corner_both)
                                ))

                        .register(Direction.WEST, CobwebCorner.NONE,
                                List.of(
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier1)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier2)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R90),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier1)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R90),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier2)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                ))
                        .register(Direction.WEST, CobwebCorner.LEFT,
                                List.of(
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier_corner)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R90),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier_corner1)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                ))
                        .register(Direction.WEST, CobwebCorner.RIGHT,
                                List.of(
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier_corner)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier_corner1)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                                ))
                        .register(Direction.WEST, CobwebCorner.BOTH,
                                List.of(
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier_corner_both)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, identifier_corner_both)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                ))
                ));
    }



    public final void registerPillarCap(Block block, Block pillarBlock, BlockStateModelGenerator generator) {
        TextureMap textureMap = PumpkinModels.pillarCapMap(pillarBlock);
        Identifier verticalID = Models.CUBE_COLUMN.upload(block, textureMap, generator.modelCollector);
        Identifier horizontalID = Models.CUBE_COLUMN_HORIZONTAL.upload(block, textureMap, generator.modelCollector);

        generator.blockStateCollector.accept(createPillarCapBlockState(block, verticalID, horizontalID));

    }

    public static BlockStateSupplier createPillarCapBlockState(Block block,
                                                            Identifier verticalId, Identifier horizontalId) {
        return VariantsBlockStateSupplier
                .create(block)
                .coordinate(BlockStateVariantMap.create(Properties.FACING)
                        .register(Direction.UP, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, verticalId))
                        .register(Direction.DOWN, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, verticalId)
                                .put(VariantSettings.X, VariantSettings.Rotation.R180))
                        .register(Direction.EAST, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, horizontalId)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .register(Direction.NORTH, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, horizontalId)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90))
                        .register(Direction.WEST, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, horizontalId)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R270))
                        .register(Direction.SOUTH, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, horizontalId)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R180))

                );
    }




    public final void registerPillar(Block block, BlockStateModelGenerator generator) {
        TextureMap textureMap = PumpkinModels.columnMap(block);
        TextureMap topMap = PumpkinModels.columnTopMap(block);
        TextureMap bottomMap = PumpkinModels.columnBottomMap(block);
        TextureMap middleMap = PumpkinModels.columnMiddleMap(block);

        Identifier verticalID = Models.CUBE_COLUMN.upload(block, textureMap, generator.modelCollector);
        Identifier verticalTopID = Models.CUBE_COLUMN.upload(block, "_top", topMap, generator.modelCollector);
        Identifier verticalBottomID = Models.CUBE_COLUMN.upload(block, "_bottom", bottomMap, generator.modelCollector);
        Identifier verticalMiddleID = Models.CUBE_COLUMN.upload(block, "_middle", middleMap, generator.modelCollector);

        Identifier horizontalID = Models.CUBE_COLUMN_HORIZONTAL.upload(block, textureMap, generator.modelCollector);
        Identifier horizontalTopID = Models.CUBE_COLUMN_HORIZONTAL.upload(block, "_top", topMap, generator.modelCollector);
        Identifier horizontalBottomID = Models.CUBE_COLUMN_HORIZONTAL.upload(block, "_bottom", bottomMap, generator.modelCollector);
        Identifier horizontalMiddleID = Models.CUBE_COLUMN_HORIZONTAL.upload(block,  "_middle", middleMap, generator.modelCollector);

        generator.blockStateCollector.accept(createPillarBlockState(block,
                verticalID, verticalTopID, verticalBottomID, verticalMiddleID,
                horizontalID, horizontalTopID, horizontalBottomID, horizontalMiddleID));
    }



    public static BlockStateSupplier createPillarBlockState(Block block,
                                                            Identifier verticalId, Identifier verticalTopId,
                                                            Identifier verticalBottomId, Identifier verticalMiddleId,
                                                            Identifier horizontalId, Identifier horizontalTopId,
                                                            Identifier horizontalBottomId, Identifier horizontalMiddleId
    ) {
        return VariantsBlockStateSupplier
                .create(block)
                .coordinate(BlockStateVariantMap.create(Properties.AXIS, ColumnBlock.PART)
                        .register(Direction.Axis.Y, ColumnPart.SINGLET, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, verticalId))
                        .register(Direction.Axis.Y, ColumnPart.TOP, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, verticalTopId))
                        .register(Direction.Axis.Y, ColumnPart.BOTTOM, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, verticalBottomId))
                        .register(Direction.Axis.Y, ColumnPart.MIDDLE, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, verticalMiddleId))


                        .register(Direction.Axis.Z, ColumnPart.SINGLET, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, horizontalId)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90))
                        .register(Direction.Axis.Z, ColumnPart.TOP, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, horizontalTopId)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90))
                        .register(Direction.Axis.Z, ColumnPart.BOTTOM, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, horizontalBottomId)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90))
                        .register(Direction.Axis.Z, ColumnPart.MIDDLE, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, horizontalMiddleId)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90))

                        .register(Direction.Axis.X, ColumnPart.SINGLET, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, horizontalId)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .register(Direction.Axis.X, ColumnPart.TOP, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, horizontalTopId)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .register(Direction.Axis.X, ColumnPart.BOTTOM, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, horizontalBottomId)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .register(Direction.Axis.X, ColumnPart.MIDDLE, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, horizontalMiddleId)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                );
    }

    private void registerEngravedWall(Block wallBlock, BlockStateModelGenerator generator) {
        TextureMap textureMap = PumpkinModels.wallMap(wallBlock);
        TextureMap sideMap = PumpkinModels.wallSideMap(wallBlock);
        Identifier idInventory = PumpkinModels.WALL_INVENTORY.upload(wallBlock, "_inventory", textureMap, generator.modelCollector);
        Identifier idPost = PumpkinModels.WALL_POST.upload(wallBlock, "_post", textureMap, generator.modelCollector);
        Identifier idSide = PumpkinModels.WALL_SIDE.upload(wallBlock, "_side", sideMap, generator.modelCollector);
        Identifier idSideTall = PumpkinModels.WALL_SIDE_TALL.upload(wallBlock, "_side_tall", sideMap, generator.modelCollector);
        generator.blockStateCollector.accept(
                BlockStateModelGenerator.createWallBlockState(wallBlock, idPost, idSide, idSideTall));
        generator.registerParentedItemModel(wallBlock.asItem(), idInventory);
    }


    private void registerEngravedSlab(Block block, Block slabBlock, BlockStateModelGenerator generator) {
        TextureMap textureMap = PumpkinModels.sidedSlabMap(block);
        TextureMap doubleMap = PumpkinModels.doubleSidedSlabMap(block);
        Identifier identifier = Models.SLAB.upload(slabBlock, textureMap, generator.modelCollector);
        Identifier identifierTop = Models.SLAB_TOP.upload(slabBlock, "_top", textureMap, generator.modelCollector);
        Identifier identifierDouble = Models.CUBE_COLUMN.upload(slabBlock, "_double", doubleMap, generator.modelCollector);
        generator.blockStateCollector.accept(
                BlockStateModelGenerator.createSlabBlockState(slabBlock, identifier, identifierTop, identifierDouble));
    }


    public final void registerEngravedStairs(Block block, Block stairsBlock, BlockStateModelGenerator generator) {
        TextureMap stairsMap = PumpkinModels.sidedStairsMap(block);
        TextureMap stairsZMap = PumpkinModels.sidedStairsZMap(block);
        TextureMap innerStairsMap = PumpkinModels.sidedStairsInnerMap(block);
        TextureMap outerStairsMap = PumpkinModels.sidedStairsOuterMap(block);

        Identifier modelID = PumpkinModels.SIDED_STAIRS.upload(stairsBlock, stairsMap, generator.modelCollector);
        Identifier modelZID = PumpkinModels.SIDED_STAIRS.upload(stairsBlock, "_z", stairsZMap, generator.modelCollector);
        Identifier innerModelID = PumpkinModels.INNER_SIDED_STAIRS.upload(stairsBlock, "_inner", innerStairsMap, generator.modelCollector);
        Identifier outerModelID = PumpkinModels.OUTER_SIDED_STAIRS.upload(stairsBlock, "_outer", outerStairsMap, generator.modelCollector);

        generator.blockStateCollector.accept(
                createSidedStairsBlockState(stairsBlock, innerModelID, modelID, modelZID, outerModelID));

    }

    public static BlockStateSupplier createSidedStairsBlockState(Block stairsBlock,
                                                                 Identifier innerModelId, Identifier regularModelId,
                                                                 Identifier regularModelZId, Identifier outerModelId) {
        return VariantsBlockStateSupplier.create(stairsBlock)
                .coordinate(
                        BlockStateVariantMap.create(Properties.HORIZONTAL_FACING, Properties.BLOCK_HALF, Properties.STAIR_SHAPE)
                                .register(Direction.EAST, BlockHalf.BOTTOM, StairShape.STRAIGHT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, regularModelId))
                                .register(Direction.WEST, BlockHalf.BOTTOM, StairShape.STRAIGHT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, regularModelId)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.UVLOCK, true))
                                .register(Direction.SOUTH, BlockHalf.BOTTOM, StairShape.STRAIGHT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, regularModelZId)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                                .put(VariantSettings.UVLOCK, true))
                                .register(Direction.NORTH, BlockHalf.BOTTOM, StairShape.STRAIGHT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, regularModelZId)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                                                .put(VariantSettings.UVLOCK, true))

                                .register(Direction.EAST, BlockHalf.BOTTOM, StairShape.OUTER_RIGHT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, outerModelId))
                                .register(Direction.WEST, BlockHalf.BOTTOM, StairShape.OUTER_RIGHT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, outerModelId)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.UVLOCK, true))
                                .register(Direction.SOUTH, BlockHalf.BOTTOM, StairShape.OUTER_RIGHT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, outerModelId)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                                .put(VariantSettings.UVLOCK, true))
                                .register(Direction.NORTH, BlockHalf.BOTTOM, StairShape.OUTER_RIGHT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, outerModelId)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                                                .put(VariantSettings.UVLOCK, true))

                                .register(Direction.EAST, BlockHalf.BOTTOM, StairShape.OUTER_LEFT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, outerModelId)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                                                .put(VariantSettings.UVLOCK, true))
                                .register(Direction.WEST, BlockHalf.BOTTOM, StairShape.OUTER_LEFT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, outerModelId)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                                .put(VariantSettings.UVLOCK, true))
                                .register(Direction.SOUTH, BlockHalf.BOTTOM, StairShape.OUTER_LEFT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, outerModelId))
                                .register(Direction.NORTH, BlockHalf.BOTTOM, StairShape.OUTER_LEFT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, outerModelId)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.UVLOCK, true))

                                .register(Direction.EAST, BlockHalf.BOTTOM, StairShape.INNER_RIGHT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, innerModelId))
                                .register(Direction.WEST, BlockHalf.BOTTOM, StairShape.INNER_RIGHT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, innerModelId)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.UVLOCK, true))
                                .register(Direction.SOUTH, BlockHalf.BOTTOM, StairShape.INNER_RIGHT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, innerModelId)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                                .put(VariantSettings.UVLOCK, true))
                                .register(Direction.NORTH, BlockHalf.BOTTOM, StairShape.INNER_RIGHT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, innerModelId)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                                                .put(VariantSettings.UVLOCK, true))

                                .register(Direction.EAST, BlockHalf.BOTTOM, StairShape.INNER_LEFT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, innerModelId)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                                                .put(VariantSettings.UVLOCK, true))
                                .register(Direction.WEST, BlockHalf.BOTTOM, StairShape.INNER_LEFT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, innerModelId)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                                .put(VariantSettings.UVLOCK, true))
                                .register(Direction.SOUTH, BlockHalf.BOTTOM, StairShape.INNER_LEFT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, innerModelId))
                                .register(Direction.NORTH, BlockHalf.BOTTOM, StairShape.INNER_LEFT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, innerModelId)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.UVLOCK, true))

                                .register(Direction.EAST, BlockHalf.TOP, StairShape.STRAIGHT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, regularModelId)
                                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.UVLOCK, true))
                                .register(Direction.WEST, BlockHalf.TOP, StairShape.STRAIGHT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, regularModelId)
                                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.UVLOCK, true))
                                .register(Direction.SOUTH, BlockHalf.TOP, StairShape.STRAIGHT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, regularModelZId)
                                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                                .put(VariantSettings.UVLOCK, true))
                                .register(Direction.NORTH, BlockHalf.TOP, StairShape.STRAIGHT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, regularModelZId)
                                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                                                .put(VariantSettings.UVLOCK, true))

                                .register(Direction.EAST, BlockHalf.TOP, StairShape.OUTER_RIGHT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, outerModelId)
                                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                                .put(VariantSettings.UVLOCK, true))
                                .register(Direction.WEST, BlockHalf.TOP, StairShape.OUTER_RIGHT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, outerModelId)
                                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                                                .put(VariantSettings.UVLOCK, true))
                                .register(Direction.SOUTH, BlockHalf.TOP, StairShape.OUTER_RIGHT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, outerModelId)
                                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.UVLOCK, true))
                                .register(Direction.NORTH, BlockHalf.TOP, StairShape.OUTER_RIGHT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, outerModelId)
                                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.UVLOCK, true))

                                .register(Direction.EAST, BlockHalf.TOP, StairShape.OUTER_LEFT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, outerModelId)
                                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.UVLOCK, true))
                                .register(Direction.WEST, BlockHalf.TOP, StairShape.OUTER_LEFT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, outerModelId)
                                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.UVLOCK, true))
                                .register(Direction.SOUTH, BlockHalf.TOP, StairShape.OUTER_LEFT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, outerModelId)
                                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                                .put(VariantSettings.UVLOCK, true))
                                .register(Direction.NORTH, BlockHalf.TOP, StairShape.OUTER_LEFT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, outerModelId)
                                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                                                .put(VariantSettings.UVLOCK, true))

                                .register(Direction.EAST, BlockHalf.TOP, StairShape.INNER_RIGHT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, innerModelId)
                                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                                .put(VariantSettings.UVLOCK, true))
                                .register(Direction.WEST, BlockHalf.TOP, StairShape.INNER_RIGHT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, innerModelId)
                                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                                                .put(VariantSettings.UVLOCK, true))
                                .register(Direction.SOUTH, BlockHalf.TOP, StairShape.INNER_RIGHT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, innerModelId)
                                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.UVLOCK, true))
                                .register(Direction.NORTH, BlockHalf.TOP, StairShape.INNER_RIGHT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, innerModelId)
                                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.UVLOCK, true))

                                .register(Direction.EAST, BlockHalf.TOP, StairShape.INNER_LEFT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, innerModelId)
                                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.UVLOCK, true))
                                .register(Direction.WEST, BlockHalf.TOP, StairShape.INNER_LEFT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, innerModelId)
                                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.UVLOCK, true))
                                .register(Direction.SOUTH, BlockHalf.TOP, StairShape.INNER_LEFT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, innerModelId)
                                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                                .put(VariantSettings.UVLOCK, true))
                                .register(Direction.NORTH, BlockHalf.TOP, StairShape.INNER_LEFT,
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, innerModelId)
                                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                                                .put(VariantSettings.UVLOCK, true))
                );
    }

    public final void registerStatue(Block block, BlockStateModelGenerator generator) {
        Identifier identifier = ModelIds.getBlockModelId(block);
        generator.blockStateCollector.accept(VariantsBlockStateSupplier
                .create(block, BlockStateVariant.create().put(VariantSettings.MODEL, identifier))
                .coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates()));
    }


    private void registerCake(Block cake, BlockStateModelGenerator generator) {
        generator.registerItemModel(cake.asItem());
        TextureMap cakeMap = PumpkinModels.cakeMap(cake);
        TextureMap cakeSliceMap = PumpkinModels.cakeSliceMap(cake);
        Identifier id = PumpkinModels.CAKE.upload(cake, cakeMap, generator.modelCollector);
        Identifier id1 = PumpkinModels.CAKE_SLICE1.upload(cake, "_slice1", cakeSliceMap, generator.modelCollector);
        Identifier id2 = PumpkinModels.CAKE_SLICE2.upload(cake, "_slice2", cakeSliceMap, generator.modelCollector);
        Identifier id3 = PumpkinModels.CAKE_SLICE3.upload(cake, "_slice3", cakeSliceMap, generator.modelCollector);
        Identifier id4 = PumpkinModels.CAKE_SLICE4.upload(cake, "_slice4", cakeSliceMap, generator.modelCollector);
        Identifier id5 = PumpkinModels.CAKE_SLICE5.upload(cake, "_slice5", cakeSliceMap, generator.modelCollector);
        Identifier id6 = PumpkinModels.CAKE_SLICE6.upload(cake, "_slice6", cakeSliceMap, generator.modelCollector);

        generator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(cake)
                        .coordinate(BlockStateVariantMap.create(Properties.BITES)
                                .register(0, BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, id))
                                .register(1, BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, id1))
                                .register(2, BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, id2))
                                .register(3, BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, id3))
                                .register(4, BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, id4))
                                .register(5, BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, id5))
                                .register(6, BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, id6))));
    }



    public final void registerCandyBowl(Block bowl, BlockStateModelGenerator generator) {
        Identifier id = ModelIds.getBlockModelId(bowl);
        Identifier id1 = ModelIds.getBlockSubModelId(bowl, "_level1");
        Identifier id2 = ModelIds.getBlockSubModelId(bowl, "_level2");
        Identifier id3 = ModelIds.getBlockSubModelId(bowl, "_level3");
        Identifier id4 = ModelIds.getBlockSubModelId(bowl, "_level4");
        generator.registerItemModel(bowl.asItem());
        generator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(bowl)
                        .coordinate(
                                BlockStateVariantMap
                                        .create(CandyBowlBlock.BITES)
                                        .register(0,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id))
                                        .register(1,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id1))
                                        .register(2,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id2))
                                        .register(3,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id3))
                                        .register(4,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id4))
                        )
        );
    }


    public final void registerSpookyLantern(Block lantern, BlockStateModelGenerator generator) {
        Identifier identifier = ModelIds.getBlockModelId(lantern);
        Identifier identifier2 = ModelIds.getBlockSubModelId(lantern, "_hanging");
        Identifier identifier3 = ModelIds.getBlockSubModelId(lantern, "_hanging_east");
        generator.registerItemModel(lantern.asItem());
        generator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(lantern)
                        .coordinate(
                                BlockStateVariantMap
                                        .create(Properties.HANGING, Properties.HORIZONTAL_FACING)
                                        .register(false, Direction.NORTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, identifier))
                                        .register(true, Direction.NORTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, identifier2))

                                        .register(false, Direction.EAST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, identifier)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                        .register(true, Direction.EAST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, identifier3))

                                        .register(false, Direction.SOUTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, identifier)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                                        .register(true, Direction.SOUTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, identifier2)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))

                                        .register(false, Direction.WEST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, identifier)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))
                                        .register(true, Direction.WEST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, identifier3)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))

                        ));
    }


    private void registerSquash(Block squash, Block carvedSquash, Block jackOLantern, Block jackOSoulLantern,
                                Block eerieJackOLantern, Model model, BlockStateModelGenerator generator) {
        TextureMap textureMap = PumpkinModels.sideAsFrontMap(squash);
        generator.registerSingleton(squash, textureMap, model);
        registerNorthDefaultHorizontalRotatable(carvedSquash, model, generator);
        registerNorthDefaultHorizontalRotatable(jackOLantern, model, generator);
        registerNorthDefaultHorizontalRotatable(jackOSoulLantern, model, generator);
        registerNorthDefaultHorizontalRotatable(eerieJackOLantern, model, generator);
    }

    public final void registerNorthDefaultHorizontalRotatable(Block block, Model model,
                                                              BlockStateModelGenerator generator) {
        TextureMap textureMap = PumpkinModels.frontMap(block);
        Identifier identifier = model.upload(block, textureMap, generator.modelCollector);
        generator.blockStateCollector.accept(VariantsBlockStateSupplier
                .create(block, BlockStateVariant.create().put(VariantSettings.MODEL, identifier))
                .coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates()));
    }

    public final void registerPie(Block pie, BlockStateModelGenerator generator) {

        generator.registerItemModel(pie.asItem());

        Identifier id = ModelIds.getBlockModelId(pie);
        Identifier id1 = ModelIds.getBlockSubModelId(pie, "_slice1");
        Identifier id2 = ModelIds.getBlockSubModelId(pie, "_slice2");
        Identifier id3 = ModelIds.getBlockSubModelId(pie, "_slice3");
        Identifier id4 = ModelIds.getBlockSubModelId(pie, "_slice4");
        generator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(pie)
                        .coordinate(
                                BlockStateVariantMap
                                        .create(PieBlock.BITES, Properties.HORIZONTAL_FACING)
                                        .register(0, Direction.SOUTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id))
                                        .register(0, Direction.WEST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                        .register(0, Direction.NORTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                                        .register(0, Direction.EAST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))


                                        .register(1, Direction.SOUTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id1))
                                        .register(1, Direction.WEST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id1)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                        .register(1, Direction.NORTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id1)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                                        .register(1, Direction.EAST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id1)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))

                                        .register(2, Direction.SOUTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id2))
                                        .register(2, Direction.WEST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id2)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                        .register(2, Direction.NORTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id2)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                                        .register(2, Direction.EAST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id2)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))


                                        .register(3, Direction.SOUTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id3))
                                        .register(3, Direction.WEST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id3)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                        .register(3, Direction.NORTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id3)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                                        .register(3, Direction.EAST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id3)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))

                                        .register(4, Direction.SOUTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id4))
                                        .register(4, Direction.WEST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id4)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                        .register(4, Direction.NORTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id4)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                                        .register(4, Direction.EAST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id4)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))
                        ));

    }

    public final void registerSpookyCandle(Block candle,
                                          BlockStateModelGenerator generator) {
        Identifier id = ModelIds.getBlockModelId(candle);
        Identifier idLit = ModelIds.getBlockSubModelId(candle, "_lit");

        generator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(candle)
                        .coordinate(
                                BlockStateVariantMap
                                        .create(AbstractCandleBlock.LIT, Properties.HORIZONTAL_FACING)
                                        .register(false, Direction.NORTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id))
                                        .register(true, Direction.NORTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, idLit))
                                        .register(false, Direction.EAST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                        .register(true, Direction.EAST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, idLit)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                        .register(false, Direction.SOUTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                                        .register(true, Direction.SOUTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, idLit)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                                        .register(false, Direction.WEST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, id)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))
                                        .register(true, Direction.WEST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, idLit)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))
                        ));

    }

    public final void registerTinyPumpkin(Block pumpkin,
                                          BlockStateModelGenerator generator) {
        Identifier identifier = PumpkinModels.TINY_PUMPKIN_1.upload(pumpkin, "_1", generator.modelCollector);
        Identifier identifier2 = PumpkinModels.TINY_PUMPKIN_2.upload(pumpkin, "_2", generator.modelCollector);
        Identifier identifier3 = PumpkinModels.TINY_PUMPKIN_3.upload(pumpkin, "_3", generator.modelCollector);
        Identifier identifier4 = PumpkinModels.TINY_PUMPKIN_4.upload(pumpkin, "_4", generator.modelCollector);
        generator.registerParentedItemModel(pumpkin, identifier);
        generator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(pumpkin)
                        .coordinate(
                                BlockStateVariantMap
                                        .create(TinySquashBlock.COUNT, Properties.HORIZONTAL_FACING)
                                        .register(1, Direction.NORTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, identifier))
                                        .register(1, Direction.EAST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, identifier)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                        .register(1, Direction.SOUTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, identifier)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                                        .register(1, Direction.WEST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, identifier)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))

                                        .register(2, Direction.NORTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, identifier2))
                                        .register(2, Direction.EAST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, identifier2)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                        .register(2, Direction.SOUTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, identifier2)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                                        .register(2, Direction.WEST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, identifier2)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))

                                        .register(3, Direction.NORTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, identifier3))
                                        .register(3, Direction.EAST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, identifier3)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                        .register(3, Direction.SOUTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, identifier3)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                                        .register(3, Direction.WEST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, identifier3)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))

                                        .register(4,  Direction.NORTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, identifier4))
                                        .register(4,  Direction.EAST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, identifier4)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                        .register(4,  Direction.SOUTH,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, identifier4)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                                        .register(4,  Direction.WEST,
                                                BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, identifier4)
                                                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))
                                    ));


    }


    //ITEMS ============================================================================================================


    @Override
    public void generateItemModels(ItemModelGenerator generator) {

        generator.register(PumpkinItemRegistry.PEPITAS, Models.GENERATED);

        generator.register(PumpkinItemRegistry.PUMPKIN_COOKIE, Models.GENERATED);
        generator.register(PumpkinItemRegistry.BOOBERRY_PUMPKIN_COOKIE, Models.GENERATED);
        generator.register(PumpkinItemRegistry.DARK_CHOCOLATE_PUMPKIN_COOKIE, Models.GENERATED);

        generator.register(PumpkinItemRegistry.CHOCOLATE_CANDY, Models.GENERATED);
        generator.register(PumpkinItemRegistry.BOOBERRY_CANDY, Models.GENERATED);
        generator.register(PumpkinItemRegistry.GLOWBERRY_CANDY, Models.GENERATED);
        generator.register(PumpkinItemRegistry.MELON_CANDY, Models.GENERATED);
        generator.register(PumpkinItemRegistry.SWEET_BERRY_CANDY, Models.GENERATED);


    }
}
