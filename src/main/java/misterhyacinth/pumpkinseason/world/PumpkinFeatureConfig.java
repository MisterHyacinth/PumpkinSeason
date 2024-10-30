package misterhyacinth.pumpkinseason.world;

import misterhyacinth.pumpkinseason.PumpkinRegistry;
import misterhyacinth.pumpkinseason.PumpkinSeason;
import misterhyacinth.pumpkinseason.block.TinySquashBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerbedBlock;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

import java.util.Iterator;
import java.util.List;

public class PumpkinFeatureConfig {


    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_BUTTERNUT_SQUASH =
            registerKey("patch_butternut_squash");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_GHOST_PUMPKIN =
            registerKey("patch_ghost_pumpkin");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_KABOCHA =
            registerKey("patch_kabocha");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_MIDNIGHT_PUMPKIN =
            registerKey("patch_midnight_pumpkin");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_MINI_PUMPKIN =
            registerKey("patch_mini_pumpkin");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_SUGAR_PUMPKIN =
            registerKey("patch_sugar_pumpkin");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_TINY_PUMPKIN =
            registerKey("patch_tiny_pumpkin");


    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_BOOBERRY_BUSH =
            registerKey("patch_booberry_bush");





    public static void bootStrap(Registerable<ConfiguredFeature<?, ?>> context) {


        DataPool.Builder<BlockState> TINY_PUMPKINS_POOL = DataPool.builder();
        for(int i = 1; i <= 4; ++i) {
            Iterator var35 = Direction.Type.HORIZONTAL.iterator();

            while(var35.hasNext()) {
                Direction direction = (Direction)var35.next();
                TINY_PUMPKINS_POOL.add(PumpkinRegistry.TINY_PUMPKIN.getDefaultState()
                        .with(TinySquashBlock.COUNT, i).with(TinySquashBlock.FACING, direction), 1);
            }
        }

        register(context, PATCH_BUTTERNUT_SQUASH, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(PumpkinRegistry.BUTTERNUT_SQUASH)),
                        List.of(Blocks.GRASS_BLOCK, Blocks.RED_SAND, Blocks.SAND, Blocks.COARSE_DIRT)));
        register(context, PATCH_GHOST_PUMPKIN, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(PumpkinRegistry.GHOST_PUMPKIN)),
                        List.of(Blocks.GRASS_BLOCK, Blocks.PODZOL, Blocks.SNOW_BLOCK, Blocks.COARSE_DIRT)));
        register(context, PATCH_KABOCHA, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(PumpkinRegistry.KABOCHA)),
                        List.of(Blocks.GRASS_BLOCK, Blocks.PODZOL)));
        register(context, PATCH_MIDNIGHT_PUMPKIN, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(PumpkinRegistry.MIDNIGHT_PUMPKIN)),
                        List.of(Blocks.GRASS_BLOCK, Blocks.PODZOL)));
        register(context, PATCH_MINI_PUMPKIN, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(PumpkinRegistry.MINI_PUMPKIN)),
                        List.of(Blocks.GRASS_BLOCK)));
        register(context, PATCH_SUGAR_PUMPKIN, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(PumpkinRegistry.SUGAR_PUMPKIN)),
                        List.of(Blocks.GRASS_BLOCK)));
        register(context, PATCH_TINY_PUMPKIN, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(TINY_PUMPKINS_POOL)),
                        List.of(Blocks.GRASS_BLOCK)));

        register(context, PATCH_BOOBERRY_BUSH, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(
                                PumpkinRegistry.BOOBERRY_BUSH.getDefaultState()
                                        .with(SweetBerryBushBlock.AGE, 3))),
                        List.of(Blocks.GRASS_BLOCK, Blocks.PODZOL, Blocks.COARSE_DIRT)));



    }



    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(PumpkinSeason.MOD_ID, name));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> void register(
            Registerable<ConfiguredFeature<?, ?>> registerable,
            RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        registerable.register(key, new ConfiguredFeature(feature, config));
    }



}
