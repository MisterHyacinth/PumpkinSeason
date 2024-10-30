package misterhyacinth.pumpkinseason.world;

import misterhyacinth.pumpkinseason.PumpkinSeason;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationConfiguredFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

public class PumpkinFeaturesPlaced {

    public static final RegistryKey<PlacedFeature> PATCH_BUTTERNUT_SQUASH =
            registerKey("patch_butternut_squash");
    public static final RegistryKey<PlacedFeature> PATCH_GHOST_PUMPKIN =
            registerKey("patch_ghost_pumpkin");
    public static final RegistryKey<PlacedFeature> PATCH_KABOCHA =
            registerKey("patch_kabocha");
    public static final RegistryKey<PlacedFeature> PATCH_MIDNIGHT_PUMPKIN =
            registerKey("patch_midnight_pumpkin");
    public static final RegistryKey<PlacedFeature> PATCH_MINI_PUMPKIN =
            registerKey("patch_mini_pumpkin");
    public static final RegistryKey<PlacedFeature> PATCH_SUGAR_PUMPKIN =
            registerKey("patch_sugar_pumpkin");
    public static final RegistryKey<PlacedFeature> PATCH_TINY_PUMPKIN =
            registerKey("patch_tiny_pumpkin");


    public static final RegistryKey<PlacedFeature> PATCH_BOOBERRY_COMMON =
            registerKey("patch_booberry_common");
    public static final RegistryKey<PlacedFeature> PATCH_BOOBERRY_RARE =
            registerKey("patch_booberry_rare");


    public static void bootStrap(Registerable<PlacedFeature> context) {
        var registryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, PATCH_BUTTERNUT_SQUASH,
                registryEntryLookup.getOrThrow(PumpkinFeatureConfig.PATCH_BUTTERNUT_SQUASH),
                List.of(
                        RarityFilterPlacementModifier.of(300),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()
                        ));

        register(context, PATCH_GHOST_PUMPKIN,
                registryEntryLookup.getOrThrow(PumpkinFeatureConfig.PATCH_GHOST_PUMPKIN),
                List.of(
                        RarityFilterPlacementModifier.of(300),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()
                ));

        register(context, PATCH_KABOCHA,
                registryEntryLookup.getOrThrow(PumpkinFeatureConfig.PATCH_KABOCHA),
                List.of(
                        RarityFilterPlacementModifier.of(300),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()
                ));

        register(context, PATCH_MIDNIGHT_PUMPKIN,
                registryEntryLookup.getOrThrow(PumpkinFeatureConfig.PATCH_MIDNIGHT_PUMPKIN),
                List.of(
                        RarityFilterPlacementModifier.of(300),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()
                ));

        register(context, PATCH_MINI_PUMPKIN,
                registryEntryLookup.getOrThrow(PumpkinFeatureConfig.PATCH_MINI_PUMPKIN),
                List.of(
                        RarityFilterPlacementModifier.of(300),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()
                ));

        register(context, PATCH_SUGAR_PUMPKIN,
                registryEntryLookup.getOrThrow(PumpkinFeatureConfig.PATCH_SUGAR_PUMPKIN),
                List.of(
                        RarityFilterPlacementModifier.of(300),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()
                ));

        register(context, PATCH_TINY_PUMPKIN,
                registryEntryLookup.getOrThrow(PumpkinFeatureConfig.PATCH_TINY_PUMPKIN),
                List.of(
                        RarityFilterPlacementModifier.of(300),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()
                ));

        register(context, PATCH_BOOBERRY_COMMON,
                registryEntryLookup.getOrThrow(PumpkinFeatureConfig.PATCH_BOOBERRY_BUSH),
                List.of(
                        RarityFilterPlacementModifier.of(32),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                        BiomePlacementModifier.of()
                ));

        register(context, PATCH_BOOBERRY_RARE,
                registryEntryLookup.getOrThrow(PumpkinFeatureConfig.PATCH_BOOBERRY_BUSH),
                List.of(
                        RarityFilterPlacementModifier.of(384),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                        BiomePlacementModifier.of()
                ));




    }



    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(PumpkinSeason.MOD_ID, name));
    }

    public static void register(Registerable<PlacedFeature> featureRegisterable, RegistryKey<PlacedFeature> key,
                                RegistryEntry<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers) {
        featureRegisterable.register(key, new PlacedFeature(feature, List.copyOf(modifiers)));
    }

}
