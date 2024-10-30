package misterhyacinth.pumpkinseason;

import misterhyacinth.pumpkinseason.item.PumpkinFood;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PumpkinItemRegistry {

    public static final Item BUTTERNUT_SEEDS = registerItem("butternut_seeds",
            new AliasedBlockItem(PumpkinRegistry.BUTTERNUT_STEM, new Item.Settings()));
    public static final Item GHOST_PUMPKIN_SEEDS = registerItem("ghost_pumpkin_seeds",
            new AliasedBlockItem(PumpkinRegistry.GHOST_PUMPKIN_STEM, new Item.Settings()));
    public static final Item KABOCHA_SEEDS = registerItem("kabocha_seeds",
            new AliasedBlockItem(PumpkinRegistry.KABOCHA_STEM, new Item.Settings()));
    public static final Item MIDNIGHT_PUMPKIN_SEEDS = registerItem("midnight_pumpkin_seeds",
            new AliasedBlockItem(PumpkinRegistry.MIDNIGHT_PUMPKIN_STEM, new Item.Settings()));
    public static final Item MINI_PUMPKIN_SEEDS = registerItem("mini_pumpkin_seeds",
            new AliasedBlockItem(PumpkinRegistry.MINI_PUMPKIN_STEM, new Item.Settings()));
    public static final Item SUGAR_PUMPKIN_SEEDS = registerItem("sugar_pumpkin_seeds",
            new AliasedBlockItem(PumpkinRegistry.SUGAR_PUMPKIN_STEM, new Item.Settings()));
    public static final Item TINY_PUMPKIN_SEEDS = registerItem("tiny_pumpkin_seeds",
            new AliasedBlockItem(PumpkinRegistry.TINY_PUMPKIN_STEM, new Item.Settings()));


    public static final Item PEPITAS =
            registerItem("pepitas",
                    new Item(new Item.Settings().food(PumpkinFood.PEPITAS)));

    public static final Item BOOBERRIES = registerItem("booberries",
            new AliasedBlockItem(PumpkinRegistry.BOOBERRY_BUSH, new Item.Settings()
                    .food(PumpkinFood.BOOBERRIES)));


    public static final Item PUMPKIN_COOKIE =
            registerItem("pumpkin_cookie",
                    new Item(new Item.Settings().food(PumpkinFood.PUMPKIN_COOKIE)));
    public static final Item BOOBERRY_PUMPKIN_COOKIE =
            registerItem("booberry_pumpkin_cookie",
                    new Item(new Item.Settings().food(PumpkinFood.BOOBERRY_PUMPKIN_COOKIE)));
    public static final Item DARK_CHOCOLATE_PUMPKIN_COOKIE =
            registerItem("dark_chocolate_pumpkin_cookie",
                    new Item(new Item.Settings().food(PumpkinFood.DARK_CHOCOLATE_PUMPKIN_COOKIE)));


    public static final Item CHOCOLATE_CANDY =
            registerItem("chocolate_candy",
                    new Item(new Item.Settings().food(PumpkinFood.CHOCOLATE_CANDY)));
    public static final Item BOOBERRY_CANDY =
            registerItem("booberry_candy",
                    new Item(new Item.Settings().food(PumpkinFood.BOOBERRY_CANDY)));
    public static final Item GLOWBERRY_CANDY =
            registerItem("glowberry_candy",
                    new Item(new Item.Settings().food(PumpkinFood.GLOWBERRY_CANDY)));
    public static final Item MELON_CANDY =
            registerItem("melon_candy",
                    new Item(new Item.Settings().food(PumpkinFood.MELON_CANDY)));
    public static final Item SWEET_BERRY_CANDY =
            registerItem("sweet_berry_candy",
                    new Item(new Item.Settings().food(PumpkinFood.SWEET_BERRY_CANDY)));

    //METHODS===========================================================================================================
    private static Item registerItem(String name, Item item) {

        Item newItem = Registry.register(Registries.ITEM, Identifier.of(PumpkinSeason.MOD_ID, name), item);
        ItemGroupEvents.modifyEntriesEvent(PumpkinSeason.ITEM_GROUP).register(content -> {
            content.add(newItem);
        });

        return newItem;
    }

    public static void registerPumpkinItems() {
        PumpkinSeason.LOGGER.debug("Registering Mod Items for " + PumpkinSeason.MOD_ID);

    }

}
