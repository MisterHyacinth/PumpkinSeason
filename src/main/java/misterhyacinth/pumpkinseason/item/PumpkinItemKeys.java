package misterhyacinth.pumpkinseason.item;

import misterhyacinth.pumpkinseason.PumpkinSeason;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class PumpkinItemKeys {
    private static final String MOD_ID = PumpkinSeason.MOD_ID;

    public static final RegistryKey<Item> BUTTERNUT_SEEDS = of("butternut_seeds");
    public static final RegistryKey<Item> GHOST_PUMPKIN_SEEDS = of("ghost_pumpkin_seeds");
    public static final RegistryKey<Item> KABOCHA_SEEDS = of("kabocha_seeds");
    public static final RegistryKey<Item> MIDNIGHT_PUMPKIN_SEEDS = of("midnight_pumpkin_seeds");
    public static final RegistryKey<Item> MINI_PUMPKIN_SEEDS = of("mini_pumpkin_seeds");
    public static final RegistryKey<Item> SUGAR_PUMPKIN_SEEDS = of("sugar_pumpkin_seeds");
    public static final RegistryKey<Item> TINY_PUMPKIN_SEEDS = of("tiny_pumpkin_seeds");

    public PumpkinItemKeys() {
    }

    private static RegistryKey<Item> of(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, id));
    }

}
