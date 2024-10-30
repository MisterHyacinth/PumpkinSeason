package misterhyacinth.pumpkinseason.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class PumpkinWorldGeneration {

    public static void generate() {

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.VEGETAL_DECORATION, PumpkinFeaturesPlaced.PATCH_BUTTERNUT_SQUASH);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.VEGETAL_DECORATION, PumpkinFeaturesPlaced.PATCH_GHOST_PUMPKIN);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.VEGETAL_DECORATION, PumpkinFeaturesPlaced.PATCH_KABOCHA);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.VEGETAL_DECORATION, PumpkinFeaturesPlaced.PATCH_MIDNIGHT_PUMPKIN);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.VEGETAL_DECORATION, PumpkinFeaturesPlaced.PATCH_MINI_PUMPKIN);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.VEGETAL_DECORATION, PumpkinFeaturesPlaced.PATCH_SUGAR_PUMPKIN);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.VEGETAL_DECORATION, PumpkinFeaturesPlaced.PATCH_TINY_PUMPKIN);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, PumpkinFeaturesPlaced.PATCH_BOOBERRY_COMMON);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA,
                        BiomeKeys.OLD_GROWTH_PINE_TAIGA),
                GenerationStep.Feature.VEGETAL_DECORATION, PumpkinFeaturesPlaced.PATCH_BOOBERRY_RARE);



    }
}
