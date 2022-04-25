package com.uniform.uniformsouls.effects;

import com.uniform.uniformsouls.UniformSouls;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class AsrielChaosSaberDamage1Effect extends StatusEffect {
    public AsrielChaosSaberDamage1Effect() {
        super(
                StatusEffectType.HARMFUL, // whether beneficial or harmful for entities
                16777215); // color in RGB
    }

    // This method is called every tick to check whether it should apply the status effect or not
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return true;
    }

    // This method is called when it applies the status effect. We implement custom functionality here.
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof Entity) {
            entity.damage(UniformSouls.ASRIEL_CHAOS_SABER_DAMAGE, 5.0F);
        }
    }
}

