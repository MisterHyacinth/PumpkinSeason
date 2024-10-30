package misterhyacinth.pumpkinseason;

import misterhyacinth.pumpkinseason.datagen.*;
import misterhyacinth.pumpkinseason.world.PumpkinFeatureConfig;
import misterhyacinth.pumpkinseason.world.PumpkinFeaturesPlaced;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class PumpkinSeasonDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		FabricDataGenerator.Pack pack = generator.createPack();

		pack.addProvider(PumpkinBlockTagProvider::new);
		pack.addProvider(PumpkinItemTagProvider::new);
		pack.addProvider(PumpkinLootTableProvider::new);
		pack.addProvider(PumpkinModelProvider::new);
		pack.addProvider(PumpkinRecipeProvider::new);
		pack.addProvider(PumpkinSeasonWorldGenerator::new);

	}


	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, PumpkinFeatureConfig::bootStrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, PumpkinFeaturesPlaced::bootStrap);

	}

}
