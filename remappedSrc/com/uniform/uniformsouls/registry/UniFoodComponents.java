package com.uniform.uniformsouls.registry;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class UniFoodComponents {
    public static final FoodComponent BUTTERSCOTCH_PIE;
    public static final FoodComponent LEGENDARYHERO;
    public static final FoodComponent GLAMBURGER;
    public static final FoodComponent NICECREAM;
    public static final FoodComponent SNOWMANPIECE;
    public static final FoodComponent SPIDERDONUT;
    public static final FoodComponent MONSTERCANDY;





    public static FoodComponent create(int hunger) {
        return (new FoodComponent.Builder()).hunger(hunger).saturationModifier(0.6F).build();
    }
    static {
        BUTTERSCOTCH_PIE = (new FoodComponent.Builder()).hunger(20).saturationModifier(1.8F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 40, 5), 1.0F).alwaysEdible().build();
        LEGENDARYHERO = (new FoodComponent.Builder()).hunger(14).saturationModifier(1.5F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 40, 1), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 250, 2), 1.0F).alwaysEdible().build();
        GLAMBURGER = (new FoodComponent.Builder()).hunger(10).saturationModifier(1.2F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 40, 0), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 200, 1), 1.0F).alwaysEdible().build();
        NICECREAM = (new FoodComponent.Builder()).hunger(8).saturationModifier(1.1F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 40, 0), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 5), 1.0F).alwaysEdible().build();
        SNOWMANPIECE = (new FoodComponent.Builder()).hunger(12).saturationModifier(1.6F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20, 2), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.BAD_OMEN, 500, 5), 1.0F).alwaysEdible().build();
        SPIDERDONUT = (new FoodComponent.Builder()).hunger(8).saturationModifier(1.1F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20, 0), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 100, 4), 1.0F).alwaysEdible().build();
        MONSTERCANDY = (new FoodComponent.Builder()).hunger(8).saturationModifier(1.1F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20, 0), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 600, 4), 1.0F).alwaysEdible().build();


        }
    }

