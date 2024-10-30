package misterhyacinth.pumpkinseason.util;

import misterhyacinth.pumpkinseason.PumpkinItemRegistry;
import misterhyacinth.pumpkinseason.PumpkinRegistry;
import misterhyacinth.pumpkinseason.PumpkinSeason;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

public class PumpkinUtils {

    private static final String MOD_ID = PumpkinSeason.MOD_ID;

    public static void register() {
        registerCompostables();
        registerTrades();
    }

    private static void registerFlammableBlocks() {
        PumpkinSeason.LOGGER.debug("Registering flammables for " + MOD_ID);
        FlammableBlockRegistry instance = FlammableBlockRegistry.getDefaultInstance();
        instance.add(PumpkinRegistry.BOOBERRY_BUSH, 60, 100);
    }

    private static void registerCompostables() {
        CompostingChanceRegistry registry = CompostingChanceRegistry.INSTANCE;

        registry.add(PumpkinRegistry.JACK_O_LANTERN_PIE, 1.0F);
        registry.add(PumpkinRegistry.BOOBERRY_PIE, 1.0F);

        registry.add(PumpkinRegistry.PUMPKIN_CAKE, 1.0F);
        registry.add(PumpkinRegistry.BOOBERRY_PUMPKIN_CAKE, 1.0F);
        registry.add(PumpkinRegistry.DARK_CHOCOLATE_PUMPKIN_CAKE, 1.0F);

        registry.add(PumpkinItemRegistry.PUMPKIN_COOKIE, 0.85F);
        registry.add(PumpkinItemRegistry.BOOBERRY_PUMPKIN_COOKIE, 0.85F);
        registry.add(PumpkinItemRegistry.DARK_CHOCOLATE_PUMPKIN_COOKIE, 0.85F);

        registry.add(PumpkinItemRegistry.BOOBERRIES, 0.3F);

        registry.add(PumpkinItemRegistry.BUTTERNUT_SEEDS, 0.3F);
        registry.add(PumpkinRegistry.BUTTERNUT_SQUASH, 0.65F);
        registry.add(PumpkinRegistry.CARVED_BUTTERNUT_SQUASH, 0.65F);

        registry.add(PumpkinItemRegistry.GHOST_PUMPKIN_SEEDS, 0.3F);
        registry.add(PumpkinRegistry.GHOST_PUMPKIN, 0.65F);
        registry.add(PumpkinRegistry.CARVED_GHOST_PUMPKIN, 0.65F);

        registry.add(PumpkinItemRegistry.KABOCHA_SEEDS, 0.3F);
        registry.add(PumpkinRegistry.KABOCHA, 0.65F);
        registry.add(PumpkinRegistry.CARVED_KABOCHA, 0.65F);

        registry.add(PumpkinItemRegistry.MIDNIGHT_PUMPKIN_SEEDS, 0.3F);
        registry.add(PumpkinRegistry.MIDNIGHT_PUMPKIN, 0.65F);
        registry.add(PumpkinRegistry.CARVED_MIDNIGHT_PUMPKIN, 0.65F);

        registry.add(PumpkinItemRegistry.MINI_PUMPKIN_SEEDS, 0.3F);
        registry.add(PumpkinRegistry.MINI_PUMPKIN, 0.65F);
        registry.add(PumpkinRegistry.CARVED_MINI_PUMPKIN, 0.65F);

        registry.add(PumpkinItemRegistry.SUGAR_PUMPKIN_SEEDS, 0.3F);
        registry.add(PumpkinRegistry.SUGAR_PUMPKIN, 0.65F);
        registry.add(PumpkinRegistry.CARVED_SUGAR_PUMPKIN, 0.65F);

        registry.add(PumpkinItemRegistry.TINY_PUMPKIN_SEEDS, 0.3F);
        registry.add(PumpkinRegistry.TINY_PUMPKIN, 0.3F);
        registry.add(PumpkinRegistry.TINY_CARVED_PUMPKIN, 0.3F);

        registry.add(PumpkinItemRegistry.PEPITAS, 0.5F);

    }

    private static void registerTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, factories -> factories.add((entity, random) ->
                new TradeOffer(
                        new TradedItem(PumpkinRegistry.BUTTERNUT_SQUASH, 6),
                        new ItemStack(Items.EMERALD),
                        12, 10, 0.05F)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, factories -> factories.add((entity, random) ->
                new TradeOffer(
                        new TradedItem(PumpkinRegistry.GHOST_PUMPKIN, 6),
                        new ItemStack(Items.EMERALD),
                        12, 10, 0.05F)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, factories -> factories.add((entity, random) ->
                new TradeOffer(
                        new TradedItem(PumpkinRegistry.KABOCHA, 6),
                        new ItemStack(Items.EMERALD),
                        12, 10, 0.05F)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, factories -> factories.add((entity, random) ->
                new TradeOffer(
                        new TradedItem(PumpkinRegistry.MIDNIGHT_PUMPKIN, 6),
                        new ItemStack(Items.EMERALD),
                        12, 10, 0.05F)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, factories -> factories.add((entity, random) ->
                new TradeOffer(
                        new TradedItem(PumpkinRegistry.MINI_PUMPKIN, 6),
                        new ItemStack(Items.EMERALD),
                        12, 10, 0.05F)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, factories -> factories.add((entity, random) ->
                new TradeOffer(
                        new TradedItem(PumpkinRegistry.SUGAR_PUMPKIN, 6),
                        new ItemStack(Items.EMERALD),
                        12, 10, 0.05F)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, factories -> factories.add((entity, random) ->
                new TradeOffer(
                        new TradedItem(PumpkinRegistry.TINY_PUMPKIN, 24),
                        new ItemStack(Items.EMERALD),
                        12, 10, 0.05F)));
    }


}
