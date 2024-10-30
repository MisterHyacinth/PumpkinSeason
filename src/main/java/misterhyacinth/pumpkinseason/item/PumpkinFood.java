package misterhyacinth.pumpkinseason.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class PumpkinFood {

    public static final FoodComponent PEPITAS =
            new FoodComponent.Builder().nutrition(1).saturationModifier(0.3F)
                    .snack().build();

    public static final FoodComponent BOOBERRIES =
            new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 300, 0), 1.0F)
                    .build();

    public static final FoodComponent PUMPKIN_COOKIE =
            new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 300, 0), 1.0F)
                    .build();
    public static final FoodComponent BOOBERRY_PUMPKIN_COOKIE =
            new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 300, 0), 1.0F)
                    .build();
    public static final FoodComponent DARK_CHOCOLATE_PUMPKIN_COOKIE =
            new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 300, 0), 1.0F)
                    .build();


    public static final FoodComponent BOOBERRY_CANDY =
            new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 300, 0), 1.0F)
                    .build();
    public static final FoodComponent CHOCOLATE_CANDY =
            new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 300, 0), 1.0F)
                    .build();
    public static final FoodComponent GLOWBERRY_CANDY =
            new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 300, 0), 1.0F)
                    .build();
    public static final FoodComponent MELON_CANDY =
            new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 300, 0), 1.0F)
                    .build();
    public static final FoodComponent SWEET_BERRY_CANDY =
            new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 300, 0), 1.0F)
                    .build();


}
