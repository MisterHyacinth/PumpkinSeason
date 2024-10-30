package misterhyacinth.pumpkinseason;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class PumpkinSeasonClient implements ClientModInitializer {
	private static final String MOD_ID = PumpkinSeason.MOD_ID;

	public static final Identifier BUTTERNUT_BLUR =
			Identifier.of(MOD_ID,"textures/misc/butternut_blur.png");
	public static final Identifier GHOST_PUMPKIN_BLUR =
			Identifier.of(MOD_ID,"textures/misc/ghost_pumpkin_blur.png");
	public static final Identifier KABOCHA_BLUR =
			Identifier.of(MOD_ID,"textures/misc/kabocha_blur.png");
	public static final Identifier MIDNIGHT_PUMPKIN_BLUR =
			Identifier.of(MOD_ID,"textures/misc/midnight_pumpkin_blur.png");
	public static final Identifier SUGAR_PUMPKIN_BLUR =
			Identifier.of(MOD_ID,"textures/misc/sugar_pumpkin_blur.png");

	@Override
	public void onInitializeClient() {

		makeCutout(PumpkinRegistry.GLOW_IN_THE_DARK_COBWEB);
		makeCutout(PumpkinRegistry.GREEN_COBWEB);
		makeCutout(PumpkinRegistry.ORANGE_COBWEB);
		makeCutout(PumpkinRegistry.PURPLE_COBWEB);

		makeTranslucent(PumpkinRegistry.HANGING_COBWEB);
		makeTranslucent(PumpkinRegistry.GLOW_IN_THE_DARK_HANGING_COBWEB);
		makeTranslucent(PumpkinRegistry.GREEN_HANGING_COBWEB);
		makeTranslucent(PumpkinRegistry.ORANGE_HANGING_COBWEB);
		makeTranslucent(PumpkinRegistry.PURPLE_HANGING_COBWEB);


		makeCutout(PumpkinRegistry.BAT_CANDLE);
		makeCutout(PumpkinRegistry.BAT_CANDLE_PUMPKIN_CAKE);
		makeCutout(PumpkinRegistry.BAT_CANDLE_BOOBERRY_PUMPKIN_CAKE);
		makeCutout(PumpkinRegistry.BAT_CANDLE_DARK_CHOCOLATE_PUMPKIN_CAKE);

		makeCutout(PumpkinRegistry.BOWL_OF_SWEETS);

		makeCutout(PumpkinRegistry.BOOBERRY_BUSH);

		makeCutout(PumpkinRegistry.SKULL_LANTERN);
		makeCutout(PumpkinRegistry.WITHER_SKULL_LANTERN);
		makeCutout(PumpkinRegistry.BAT_LANTERN);
		makeCutout(PumpkinRegistry.SPIDER_LANTERN);
		makeCutout(PumpkinRegistry.PUMPKIN_LANTERN);
		makeCutout(PumpkinRegistry.CREEPY_PUMPKIN_LANTERN);
		makeCutout(PumpkinRegistry.GHASTLY_LANTERN);
		makeCutout(PumpkinRegistry.CRESCENT_MOON_LANTERN);
		makeCutout(PumpkinRegistry.BLACK_CAT_LANTERN);


		makeCutout(PumpkinRegistry.BUTTERNUT_STEM);
		makeCutout(PumpkinRegistry.ATTACHED_BUTTERNUT_STEM);

		makeCutout(PumpkinRegistry.GHOST_PUMPKIN_STEM);
		makeCutout(PumpkinRegistry.ATTACHED_GHOST_PUMPKIN_STEM);

		makeCutout(PumpkinRegistry.KABOCHA_STEM);
		makeCutout(PumpkinRegistry.ATTACHED_KABOCHA_STEM);

		makeCutout(PumpkinRegistry.MIDNIGHT_PUMPKIN_STEM);
		makeCutout(PumpkinRegistry.ATTACHED_MIDNIGHT_PUMPKIN_STEM);

		makeCutout(PumpkinRegistry.MINI_PUMPKIN_STEM);
		makeCutout(PumpkinRegistry.ATTACHED_MINI_PUMPKIN_STEM);

		makeCutout(PumpkinRegistry.SUGAR_PUMPKIN_STEM);
		makeCutout(PumpkinRegistry.ATTACHED_SUGAR_PUMPKIN_STEM);

		makeCutout(PumpkinRegistry.TINY_PUMPKIN_STEM);
		makeCutout(PumpkinRegistry.ATTACHED_TINY_PUMPKIN_STEM);


	}

	private static void makeCutout(Block block) {
		BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
	}

	private static void makeTranslucent(Block block) {
		BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
	}

}