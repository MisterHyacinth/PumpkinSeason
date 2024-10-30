package misterhyacinth.pumpkinseason;

import misterhyacinth.pumpkinseason.util.PumpkinUtils;
import misterhyacinth.pumpkinseason.world.PumpkinWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PumpkinSeason implements ModInitializer {
	public static final String MOD_ID = "pumpkinseason";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	//ITEM GROUP=======================================================================================================
	public static final ItemGroup PUMPKINSEASON_ITEMGROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(Blocks.PUMPKIN))
			.displayName(Text.translatable("itemGroup.pumpkinseason.pumpkinseason"))
			.build();
	public static final RegistryKey<ItemGroup> ITEM_GROUP =
			RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(MOD_ID, "pumpkinseason"));

	//SOUNDS============================================================================================================
	public static final Identifier EERIE_AMBIENT_SOUND_ID = Identifier.of(MOD_ID, "block.eerie.ambient");
	public static SoundEvent EERIE_AMBIENT_SOUND = SoundEvent.of(EERIE_AMBIENT_SOUND_ID);


	@Override
	public void onInitialize() {

		Registry.register(Registries.SOUND_EVENT, EERIE_AMBIENT_SOUND_ID, EERIE_AMBIENT_SOUND);
		Registry.register(Registries.ITEM_GROUP, Identifier.of(MOD_ID, "pumpkinseason"), PUMPKINSEASON_ITEMGROUP);

		PumpkinRegistry.registerPumpkins();
		PumpkinItemRegistry.registerPumpkinItems();

		PumpkinWorldGeneration.generate();
		PumpkinUtils.register();

	}
}