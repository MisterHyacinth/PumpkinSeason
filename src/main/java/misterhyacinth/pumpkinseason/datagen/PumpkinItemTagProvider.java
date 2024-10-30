package misterhyacinth.pumpkinseason.datagen;

import misterhyacinth.pumpkinseason.PumpkinItemRegistry;
import misterhyacinth.pumpkinseason.PumpkinRegistry;
import misterhyacinth.pumpkinseason.util.PumpkinBlockTags;
import misterhyacinth.pumpkinseason.util.PumpkinItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class PumpkinItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public PumpkinItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(PumpkinItemTags.SPOOKY_CANDLES)
                .add(PumpkinRegistry.BAT_CANDLE.asItem())
                .add(PumpkinRegistry.PUMPKIN_CANDLE.asItem())
                .add(PumpkinRegistry.CREEPY_PUMPKIN_CANDLE.asItem())
                .add(PumpkinRegistry.SKULL_CANDLE.asItem());

        getOrCreateTagBuilder(PumpkinItemTags.RAW_PUMPKIN_SEEDS)
                .add(Items.PUMPKIN_SEEDS)
                .add(PumpkinItemRegistry.BUTTERNUT_SEEDS)
                .add(PumpkinItemRegistry.GHOST_PUMPKIN_SEEDS)
                .add(PumpkinItemRegistry.KABOCHA_SEEDS)
                .add(PumpkinItemRegistry.MIDNIGHT_PUMPKIN_SEEDS)
                .add(PumpkinItemRegistry.MINI_PUMPKIN_SEEDS)
                .add(PumpkinItemRegistry.SUGAR_PUMPKIN_SEEDS)
                .add(PumpkinItemRegistry.TINY_PUMPKIN_SEEDS);

        getOrCreateTagBuilder(PumpkinItemTags.BIRD_SEED)
                .add(PumpkinItemRegistry.BUTTERNUT_SEEDS)
                .add(PumpkinItemRegistry.GHOST_PUMPKIN_SEEDS)
                .add(PumpkinItemRegistry.KABOCHA_SEEDS)
                .add(PumpkinItemRegistry.MIDNIGHT_PUMPKIN_SEEDS)
                .add(PumpkinItemRegistry.MINI_PUMPKIN_SEEDS)
                .add(PumpkinItemRegistry.SUGAR_PUMPKIN_SEEDS)
                .add(PumpkinItemRegistry.TINY_PUMPKIN_SEEDS)
                .add(PumpkinItemRegistry.PEPITAS);

        getOrCreateTagBuilder(PumpkinItemTags.SEEDS)
                .addTag(PumpkinItemTags.BIRD_SEED);

        getOrCreateTagBuilder(PumpkinItemTags.CANDY)
                .add(PumpkinItemRegistry.CHOCOLATE_CANDY)
                .add(PumpkinItemRegistry.BOOBERRY_CANDY)
                .add(PumpkinItemRegistry.GLOWBERRY_CANDY)
                .add(PumpkinItemRegistry.MELON_CANDY)
                .add(PumpkinItemRegistry.SWEET_BERRY_CANDY);

        getOrCreateTagBuilder(PumpkinItemTags.CARVED_SQUASH)
                .add(PumpkinRegistry.CARVED_BUTTERNUT_SQUASH.asItem())
                .add(PumpkinRegistry.CARVED_GHOST_PUMPKIN.asItem())
                .add(PumpkinRegistry.CARVED_KABOCHA.asItem())
                .add(PumpkinRegistry.CARVED_MIDNIGHT_PUMPKIN.asItem())
                .add(PumpkinRegistry.CARVED_MINI_PUMPKIN.asItem())
                .add(PumpkinRegistry.CARVED_SUGAR_PUMPKIN.asItem());

        getOrCreateTagBuilder(PumpkinItemTags.PUMPKINS)
                .add(Items.PUMPKIN)
                .add(PumpkinRegistry.BUTTERNUT_SQUASH.asItem())
                .add(PumpkinRegistry.GHOST_PUMPKIN.asItem())
                .add(PumpkinRegistry.KABOCHA.asItem())
                .add(PumpkinRegistry.MIDNIGHT_PUMPKIN.asItem())
                .add(PumpkinRegistry.MINI_PUMPKIN.asItem())
                .add(PumpkinRegistry.SUGAR_PUMPKIN.asItem());

        getOrCreateTagBuilder(ItemTags.STAIRS)
                .add(PumpkinRegistry.ENGRAVED_STONE_STAIRS.asItem())
                .add(PumpkinRegistry.MOSSY_ENGRAVED_STONE_STAIRS.asItem())
                .add(PumpkinRegistry.ENGRAVED_BLACKSTONE_STAIRS.asItem());

        getOrCreateTagBuilder(ItemTags.SLABS)
                .add(PumpkinRegistry.ENGRAVED_STONE_SLAB.asItem())
                .add(PumpkinRegistry.MOSSY_ENGRAVED_STONE_SLAB.asItem())
                .add(PumpkinRegistry.ENGRAVED_BLACKSTONE_SLAB.asItem());

        getOrCreateTagBuilder(ItemTags.WALLS)
                .add(PumpkinRegistry.ENGRAVED_STONE_WALL.asItem())
                .add(PumpkinRegistry.MOSSY_ENGRAVED_STONE_WALL.asItem())
                .add(PumpkinRegistry.ENGRAVED_BLACKSTONE_WALL.asItem());


        getOrCreateTagBuilder(ItemTags.CHICKEN_FOOD)
                .addTag(PumpkinItemTags.BIRD_SEED);

        getOrCreateTagBuilder(ItemTags.PARROT_FOOD)
                .addTag(PumpkinItemTags.BIRD_SEED);

        getOrCreateTagBuilder(ItemTags.FOX_FOOD)
                .add(PumpkinItemRegistry.BOOBERRIES);

    }
}
