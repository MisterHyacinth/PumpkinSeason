package misterhyacinth.pumpkinseason.block;

import misterhyacinth.pumpkinseason.PumpkinSeason;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class PumpkinBlockKeys {

    private static final String MOD_ID = PumpkinSeason.MOD_ID;

    public static final RegistryKey<Block> BUTTERNUT_SQUASH = of("butternut_squash");
    public static final RegistryKey<Block> GHOST_PUMPKIN = of("ghost_pumpkin");
    public static final RegistryKey<Block> KABOCHA = of("kabocha");
    public static final RegistryKey<Block> MIDNIGHT_PUMPKIN = of("midnight_pumpkin");
    public static final RegistryKey<Block> MINI_PUMPKIN = of("mini_pumpkin");
    public static final RegistryKey<Block> SUGAR_PUMPKIN = of("sugar_pumpkin");
    public static final RegistryKey<Block> TINY_PUMPKIN = of("tiny_pumpkin");


    public static final RegistryKey<Block> BUTTERNUT_STEM = of("butternut_stem");
    public static final RegistryKey<Block> GHOST_PUMPKIN_STEM = of("ghost_pumpkin_stem");
    public static final RegistryKey<Block> KABOCHA_STEM = of("kabocha_stem");
    public static final RegistryKey<Block> MIDNIGHT_PUMPKIN_STEM = of("midnight_pumpkin_stem");
    public static final RegistryKey<Block> MINI_PUMPKIN_STEM = of("mini_pumpkin_stem");
    public static final RegistryKey<Block> SUGAR_PUMPKIN_STEM = of("sugar_pumpkin_stem");
    public static final RegistryKey<Block> TINY_PUMPKIN_STEM = of("tiny_pumpkin_stem");


    public static final RegistryKey<Block> ATTACHED_BUTTERNUT_STEM = of("attached_butternut_stem");
    public static final RegistryKey<Block> ATTACHED_GHOST_PUMPKIN_STEM = of("attached_ghost_pumpkin_stem");
    public static final RegistryKey<Block> ATTACHED_KABOCHA_STEM = of("attached_kabocha_stem");
    public static final RegistryKey<Block> ATTACHED_MIDNIGHT_PUMPKIN_STEM = of("attached_midnight_pumpkin_stem");
    public static final RegistryKey<Block> ATTACHED_MINI_PUMPKIN_STEM = of("attached_mini_pumpkin_stem");
    public static final RegistryKey<Block> ATTACHED_SUGAR_PUMPKIN_STEM = of("attached_sugar_pumpkin_stem");
    public static final RegistryKey<Block> ATTACHED_TINY_PUMPKIN_STEM = of("attached_tiny_pumpkin_stem");



    public PumpkinBlockKeys() {
    }

    private static RegistryKey<Block> of(String id) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, id));
    }


}
