package misterhyacinth.pumpkinseason.datagen;

import misterhyacinth.pumpkinseason.PumpkinItemRegistry;
import misterhyacinth.pumpkinseason.PumpkinRegistry;
import misterhyacinth.pumpkinseason.block.CandyBowlBlock;
import misterhyacinth.pumpkinseason.block.PieBlock;
import misterhyacinth.pumpkinseason.block.PumpkinCandleCakeBlock;
import misterhyacinth.pumpkinseason.block.TinySquashBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.*;
import net.minecraft.block.enums.SlabType;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.StringIdentifiable;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PumpkinLootTableProvider extends FabricBlockLootTableProvider {


    public PumpkinLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        addCobwebDrop(PumpkinRegistry.GLOW_IN_THE_DARK_COBWEB);
        addCobwebDrop(PumpkinRegistry.GREEN_COBWEB);
        addCobwebDrop(PumpkinRegistry.ORANGE_COBWEB);
        addCobwebDrop(PumpkinRegistry.PURPLE_COBWEB);

        addCobwebDrop(PumpkinRegistry.HANGING_COBWEB);
        addCobwebDrop(PumpkinRegistry.GLOW_IN_THE_DARK_HANGING_COBWEB);
        addCobwebDrop(PumpkinRegistry.GREEN_HANGING_COBWEB);
        addCobwebDrop(PumpkinRegistry.ORANGE_HANGING_COBWEB);
        addCobwebDrop(PumpkinRegistry.PURPLE_HANGING_COBWEB);


        addDrop(PumpkinRegistry.STONE_GARGOYLE);
        addDrop(PumpkinRegistry.BLACKSTONE_GARGOYLE);
        addDrop(PumpkinRegistry.EERIE_STONE_GARGOYLE);
        addDrop(PumpkinRegistry.EERIE_BLACKSTONE_GARGOYLE);

        addDrop(PumpkinRegistry.STONE_ANGEL);
        addDrop(PumpkinRegistry.BLACKSTONE_ANGEL);
        addDrop(PumpkinRegistry.EERIE_STONE_ANGEL);
        addDrop(PumpkinRegistry.EERIE_BLACKSTONE_ANGEL);

        addDrop(PumpkinRegistry.STONE_GRAVE_MARKER);
        addDrop(PumpkinRegistry.BLACKSTONE_GRAVE_MARKER);
        addDrop(PumpkinRegistry.EERIE_STONE_GRAVE_MARKER);
        addDrop(PumpkinRegistry.EERIE_BLACKSTONE_GRAVE_MARKER);

        addDrop(PumpkinRegistry.STONE_CROSS_GRAVE_MARKER);
        addDrop(PumpkinRegistry.BLACKSTONE_CROSS_GRAVE_MARKER);
        addDrop(PumpkinRegistry.STONE_OBELISK_GRAVE_MARKER);
        addDrop(PumpkinRegistry.BLACKSTONE_OBELISK_GRAVE_MARKER);


        addDrop(PumpkinRegistry.ENGRAVED_STONE);
        addDrop(PumpkinRegistry.MOSSY_ENGRAVED_STONE);
        addDrop(PumpkinRegistry.ENGRAVED_BLACKSTONE);

        addDrop(PumpkinRegistry.ENGRAVED_STONE_STAIRS);
        addDrop(PumpkinRegistry.MOSSY_ENGRAVED_STONE_STAIRS);
        addDrop(PumpkinRegistry.ENGRAVED_BLACKSTONE_STAIRS);

        addSlabDrop(PumpkinRegistry.ENGRAVED_STONE_SLAB);
        addSlabDrop(PumpkinRegistry.MOSSY_ENGRAVED_STONE_SLAB);
        addSlabDrop(PumpkinRegistry.ENGRAVED_BLACKSTONE_SLAB);

        addDrop(PumpkinRegistry.ENGRAVED_STONE_WALL);
        addDrop(PumpkinRegistry.MOSSY_ENGRAVED_STONE_WALL);
        addDrop(PumpkinRegistry.ENGRAVED_BLACKSTONE_WALL);

        addDrop(PumpkinRegistry.ENGRAVED_STONE_PILLAR);
        addDrop(PumpkinRegistry.MOSSY_ENGRAVED_STONE_PILLAR);
        addDrop(PumpkinRegistry.ENGRAVED_BLACKSTONE_PILLAR);

        addDrop(PumpkinRegistry.ENGRAVED_STONE_PILLAR_CAP);
        addDrop(PumpkinRegistry.MOSSY_ENGRAVED_STONE_PILLAR_CAP);
        addDrop(PumpkinRegistry.ENGRAVED_BLACKSTONE_PILLAR_CAP);




        addDrop(PumpkinRegistry.JACK_O_LANTERN_PIE, pieDrops(PumpkinRegistry.JACK_O_LANTERN_PIE));
        addDrop(PumpkinRegistry.BOOBERRY_PIE, pieDrops(PumpkinRegistry.BOOBERRY_PIE));

        addDrop(PumpkinRegistry.PUMPKIN_CAKE, cakeDrops(PumpkinRegistry.PUMPKIN_CAKE));
        addDrop(PumpkinRegistry.BOOBERRY_PUMPKIN_CAKE, cakeDrops(PumpkinRegistry.BOOBERRY_PUMPKIN_CAKE));
        addDrop(PumpkinRegistry.DARK_CHOCOLATE_PUMPKIN_CAKE, cakeDrops(PumpkinRegistry.DARK_CHOCOLATE_PUMPKIN_CAKE));


        addDrop(PumpkinRegistry.SKULL_CANDLE_PUMPKIN_CAKE,
                pumpkinCandleCakeDrops(PumpkinRegistry.PUMPKIN_CAKE, PumpkinRegistry.SKULL_CANDLE));
        addDrop(PumpkinRegistry.SKULL_CANDLE_BOOBERRY_PUMPKIN_CAKE,
                pumpkinCandleCakeDrops(PumpkinRegistry.BOOBERRY_PUMPKIN_CAKE, PumpkinRegistry.SKULL_CANDLE));
        addDrop(PumpkinRegistry.SKULL_CANDLE_DARK_CHOCOLATE_PUMPKIN_CAKE,
                pumpkinCandleCakeDrops(PumpkinRegistry.DARK_CHOCOLATE_PUMPKIN_CAKE, PumpkinRegistry.SKULL_CANDLE));

        addDrop(PumpkinRegistry.BAT_CANDLE_PUMPKIN_CAKE,
                pumpkinCandleCakeDrops(PumpkinRegistry.PUMPKIN_CAKE, PumpkinRegistry.BAT_CANDLE));
        addDrop(PumpkinRegistry.BAT_CANDLE_BOOBERRY_PUMPKIN_CAKE,
                pumpkinCandleCakeDrops(PumpkinRegistry.BOOBERRY_PUMPKIN_CAKE, PumpkinRegistry.BAT_CANDLE));
        addDrop(PumpkinRegistry.BAT_CANDLE_DARK_CHOCOLATE_PUMPKIN_CAKE,
                pumpkinCandleCakeDrops(PumpkinRegistry.DARK_CHOCOLATE_PUMPKIN_CAKE, PumpkinRegistry.BAT_CANDLE));

        addDrop(PumpkinRegistry.PUMPKIN_CANDLE_PUMPKIN_CAKE,
                pumpkinCandleCakeDrops(PumpkinRegistry.PUMPKIN_CAKE, PumpkinRegistry.PUMPKIN_CANDLE));
        addDrop(PumpkinRegistry.PUMPKIN_CANDLE_BOOBERRY_PUMPKIN_CAKE,
                pumpkinCandleCakeDrops(PumpkinRegistry.BOOBERRY_PUMPKIN_CAKE, PumpkinRegistry.PUMPKIN_CANDLE));
        addDrop(PumpkinRegistry.PUMPKIN_CANDLE_DARK_CHOCOLATE_PUMPKIN_CAKE,
                pumpkinCandleCakeDrops(PumpkinRegistry.DARK_CHOCOLATE_PUMPKIN_CAKE, PumpkinRegistry.PUMPKIN_CANDLE));

        addDrop(PumpkinRegistry.CREEPY_PUMPKIN_CANDLE_PUMPKIN_CAKE,
                pumpkinCandleCakeDrops(PumpkinRegistry.PUMPKIN_CAKE, PumpkinRegistry.CREEPY_PUMPKIN_CANDLE));
        addDrop(PumpkinRegistry.CREEPY_PUMPKIN_CANDLE_BOOBERRY_PUMPKIN_CAKE,
                pumpkinCandleCakeDrops(PumpkinRegistry.BOOBERRY_PUMPKIN_CAKE, PumpkinRegistry.CREEPY_PUMPKIN_CANDLE));
        addDrop(PumpkinRegistry.CREEPY_PUMPKIN_CANDLE_DARK_CHOCOLATE_PUMPKIN_CAKE,
                pumpkinCandleCakeDrops(PumpkinRegistry.DARK_CHOCOLATE_PUMPKIN_CAKE, PumpkinRegistry.CREEPY_PUMPKIN_CANDLE));


        addDrop(PumpkinRegistry.BOOBERRY_BUSH, berryBushDrops(PumpkinRegistry.BOOBERRY_BUSH, PumpkinItemRegistry.BOOBERRIES));

        addDrop(PumpkinRegistry.BOWL_OF_SWEETS, candyBowlDrops(PumpkinRegistry.BOWL_OF_SWEETS));


        addDrop(PumpkinRegistry.BAT_CANDLE);
        addDrop(PumpkinRegistry.PUMPKIN_CANDLE);
        addDrop(PumpkinRegistry.CREEPY_PUMPKIN_CANDLE);
        addDrop(PumpkinRegistry.SKULL_CANDLE);


        addDrop(PumpkinRegistry.SKULL_LANTERN);
        addDrop(PumpkinRegistry.WITHER_SKULL_LANTERN);
        addDrop(PumpkinRegistry.BAT_LANTERN);
        addDrop(PumpkinRegistry.SPIDER_LANTERN);
        addDrop(PumpkinRegistry.PUMPKIN_LANTERN);
        addDrop(PumpkinRegistry.CREEPY_PUMPKIN_LANTERN);
        addDrop(PumpkinRegistry.GHASTLY_LANTERN);
        addDrop(PumpkinRegistry.CRESCENT_MOON_LANTERN);
        addDrop(PumpkinRegistry.BLACK_CAT_LANTERN);


        addDrop(PumpkinRegistry.BUTTERNUT_SQUASH);
        addDrop(PumpkinRegistry.GHOST_PUMPKIN);
        addDrop(PumpkinRegistry.KABOCHA);
        addDrop(PumpkinRegistry.MIDNIGHT_PUMPKIN);
        addDrop(PumpkinRegistry.MINI_PUMPKIN);
        addDrop(PumpkinRegistry.SUGAR_PUMPKIN);
        addTinyPumpkinDrop(PumpkinRegistry.TINY_PUMPKIN);

        addDrop(PumpkinRegistry.CARVED_BUTTERNUT_SQUASH);
        addDrop(PumpkinRegistry.CARVED_GHOST_PUMPKIN);
        addDrop(PumpkinRegistry.CARVED_KABOCHA);
        addDrop(PumpkinRegistry.CARVED_MIDNIGHT_PUMPKIN);
        addDrop(PumpkinRegistry.CARVED_MINI_PUMPKIN);
        addDrop(PumpkinRegistry.CARVED_SUGAR_PUMPKIN);
        addTinyPumpkinDrop(PumpkinRegistry.TINY_CARVED_PUMPKIN);

        addDrop(PumpkinRegistry.BUTTERNUT_LANTERN);
        addDrop(PumpkinRegistry.GHOST_O_LANTERN);
        addDrop(PumpkinRegistry.KABOCHA_LANTERN);
        addDrop(PumpkinRegistry.MIDNIGHT_O_LANTERN);
        addDrop(PumpkinRegistry.MINI_JACK_O_LANTERN);
        addDrop(PumpkinRegistry.SUGAR_O_LANTERN);
        addTinyPumpkinDrop(PumpkinRegistry.TINY_JACK_O_LANTERN);

        addDrop(PumpkinRegistry.JACK_O_SOUL_LANTERN);
        addDrop(PumpkinRegistry.BUTTERNUT_SOUL_LANTERN);
        addDrop(PumpkinRegistry.GHOST_O_SOUL_LANTERN);
        addDrop(PumpkinRegistry.KABOCHA_SOUL_LANTERN);
        addDrop(PumpkinRegistry.MIDNIGHT_O_SOUL_LANTERN);
        addDrop(PumpkinRegistry.MINI_JACK_O_SOUL_LANTERN);
        addDrop(PumpkinRegistry.SUGAR_O_SOUL_LANTERN);
        addTinyPumpkinDrop(PumpkinRegistry.TINY_JACK_O_SOUL_LANTERN);

        addDrop(PumpkinRegistry.EERIE_JACK_O_LANTERN);
        addDrop(PumpkinRegistry.EERIE_BUTTERNUT_LANTERN);
        addDrop(PumpkinRegistry.EERIE_GHOST_O_LANTERN);
        addDrop(PumpkinRegistry.EERIE_KABOCHA_LANTERN);
        addDrop(PumpkinRegistry.EERIE_MIDNIGHT_O_LANTERN);
        addDrop(PumpkinRegistry.EERIE_MINI_JACK_O_LANTERN);
        addDrop(PumpkinRegistry.EERIE_SUGAR_O_LANTERN);
        addTinyPumpkinDrop(PumpkinRegistry.TINY_EERIE_JACK_O_LANTERN);



        addStemDrops(PumpkinRegistry.BUTTERNUT_STEM, PumpkinRegistry.ATTACHED_BUTTERNUT_STEM,
                PumpkinItemRegistry.BUTTERNUT_SEEDS);
        addStemDrops(PumpkinRegistry.GHOST_PUMPKIN_STEM, PumpkinRegistry.ATTACHED_GHOST_PUMPKIN_STEM,
                PumpkinItemRegistry.GHOST_PUMPKIN_SEEDS);
        addStemDrops(PumpkinRegistry.KABOCHA_STEM, PumpkinRegistry.ATTACHED_KABOCHA_STEM,
                PumpkinItemRegistry.KABOCHA_SEEDS);
        addStemDrops(PumpkinRegistry.MIDNIGHT_PUMPKIN_STEM, PumpkinRegistry.ATTACHED_MIDNIGHT_PUMPKIN_STEM,
                PumpkinItemRegistry.MIDNIGHT_PUMPKIN_SEEDS);
        addStemDrops(PumpkinRegistry.MINI_PUMPKIN_STEM, PumpkinRegistry.ATTACHED_MINI_PUMPKIN_STEM,
                PumpkinItemRegistry.MINI_PUMPKIN_SEEDS);
        addStemDrops(PumpkinRegistry.SUGAR_PUMPKIN_STEM, PumpkinRegistry.ATTACHED_SUGAR_PUMPKIN_STEM,
                PumpkinItemRegistry.SUGAR_PUMPKIN_SEEDS);
        addStemDrops(PumpkinRegistry.TINY_PUMPKIN_STEM, PumpkinRegistry.ATTACHED_TINY_PUMPKIN_STEM,
                PumpkinItemRegistry.TINY_PUMPKIN_SEEDS);

    }


    //METHODS

    public void addSlabDrop(Block slab) {
        addDrop(slab, slabDrops(slab));
    }


    public void addStemDrops(Block stem, Block attachedStem, Item seeds) {
        addDrop(stem, cropStemDrops(stem, seeds));
        addDrop(attachedStem, attachedCropStemDrops(attachedStem, seeds));
    }

    public void addTinyPumpkinDrop(Block pumpkin) {
        addDrop(pumpkin, tinyPumpkinDrops(pumpkin));
    }

    public LootTable.Builder tinyPumpkinDrops(Block pumpkin) {
        return LootTable.builder().pool(
                LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(this.applyExplosionDecay(pumpkin,
                                ItemEntry.builder(pumpkin).apply(List.of(2, 3, 4), (count) -> {
                                    return SetCountLootFunction.builder(ConstantLootNumberProvider.create((float)count))
                                            .conditionally(BlockStatePropertyLootCondition.builder(pumpkin)
                                                    .properties(net.minecraft.predicate.StatePredicate.Builder.create()
                                                            .exactMatch(TinySquashBlock.COUNT, count)));
        }))));
    }

    public LootTable.Builder berryBushDrops(Block bush, Item berries) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.applyExplosionDecay(bush,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(berries)
                                        .conditionally(BlockStatePropertyLootCondition.builder(bush)
                                                .properties(StatePredicate.Builder.create()
                                                        .exactMatch(SweetBerryBushBlock.AGE, 3)))
                                        .apply(ApplyBonusLootFunction
                                                .uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                                        .apply(SetCountLootFunction.builder(
                                                UniformLootNumberProvider.create(2.0F, 3.0F))))
                        )
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(berries)
                                        .conditionally(BlockStatePropertyLootCondition.builder(bush)
                                                .properties(StatePredicate.Builder.create()
                                                        .exactMatch(SweetBerryBushBlock.AGE, 2)))
                                        .apply(ApplyBonusLootFunction
                                                .uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                                        .apply(SetCountLootFunction.builder(
                                                UniformLootNumberProvider.create(1.0F, 2.0F))))
                        ));

    }

    public LootTable.Builder pieDrops(Block bowl) {
        return this.applyExplosionDecay(bowl,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .with((ItemEntry.builder(bowl)
                                        .conditionally(createSilkTouchCondition())
                                        .conditionally(
                                                BlockStatePropertyLootCondition.builder(bowl)
                                                        .properties(StatePredicate.Builder.create()
                                                                .exactMatch(PieBlock.BITES, 0)))
                                        .alternatively(
                                                ItemEntry.builder(Items.BOWL))))));
    }

    public LootTable.Builder candyBowlDrops(Block bowl) {
        return this.applyExplosionDecay(bowl,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .with((ItemEntry.builder(bowl)
                                        .conditionally(createSilkTouchCondition())
                                        .conditionally(
                                                BlockStatePropertyLootCondition.builder(bowl)
                                                        .properties(StatePredicate.Builder.create()
                                                                .exactMatch(CandyBowlBlock.BITES, 0)))
                                        .alternatively(
                                                ItemEntry.builder(Items.BOWL))))));
    }

    public LootTable.Builder cakeDrops(Block cake) {
        return this.applyExplosionDecay(cake,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .with((ItemEntry.builder(cake)
                                        .conditionally(createSilkTouchCondition())
                                        .conditionally(
                                                BlockStatePropertyLootCondition.builder(cake)
                                                        .properties(StatePredicate.Builder.create()
                                                                .exactMatch(Properties.BITES, 0)))
                                ))));
    }

    public final LootTable.Builder pumpkinCandleCakeDrops(Block cake, Block candle) {
        return LootTable.builder()
                .pool(this.addSurvivesExplosionCondition(
                        cake, LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(cake)
                                        .conditionally(createSilkTouchCondition()))))
                .pool(this.addSurvivesExplosionCondition(
                        candle, LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(candle))));
    }

    public void addCobwebDrop(Block cobweb){
        addDrop(cobweb,
                dropsWithSilkTouchOrShears(cobweb,
                        this.addSurvivesExplosionCondition(cobweb, ItemEntry.builder(Items.STRING))));
    }


}
