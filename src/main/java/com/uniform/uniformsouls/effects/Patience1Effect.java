package com.uniform.uniformsouls.effects;

import com.uniform.uniformsouls.UniformSouls;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.effect.StatusEffects;

public class Patience1Effect extends StatusEffect {
    public Patience1Effect() {
        super(
                StatusEffectType.BENEFICIAL, // whether beneficial or harmful for entities
                63999); // color in RGB
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

            if (entity.hasStatusEffect(StatusEffects.SLOWNESS)) {
                entity.removeStatusEffect(StatusEffects.SLOWNESS);
            }

            if (entity.hasStatusEffect(StatusEffects.MINING_FATIGUE)) {
                entity.removeStatusEffect(StatusEffects.MINING_FATIGUE);
            }

            if (entity.hasStatusEffect(UniformSouls.PATDEBUFFEFFECT1)) {
                entity.removeStatusEffect(UniformSouls.PATDEBUFFEFFECT1);
            }

        }
    }
}