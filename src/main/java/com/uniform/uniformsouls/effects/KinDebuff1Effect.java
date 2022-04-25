package com.uniform.uniformsouls.effects;

import com.uniform.uniformsouls.UniformSouls;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class KinDebuff1Effect extends StatusEffect {
    public KinDebuff1Effect() {
        super(
                StatusEffectType.BENEFICIAL, // whether beneficial or harmful for entities
                5177089); // color in RGB
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
            entity.damage(UniformSouls.KINDNESS_PAN_DAMAGE, 0.015F);
            entity.timeUntilRegen = 60;
        }
    }
}