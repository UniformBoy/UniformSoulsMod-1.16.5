package com.uniform.uniformsouls.effects;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class PerDebuff1Effect extends StatusEffect {
    public PerDebuff1Effect() {
        super(
                StatusEffectType.HARMFUL, // whether beneficial or harmful for entities
                13828351); // color in RGB
    }

    // This method is called every tick to check whether it should apply the status effect or not
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof Entity) {
            this.addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.25000000596046448D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        }
    }
}