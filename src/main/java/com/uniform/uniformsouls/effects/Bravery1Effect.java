package com.uniform.uniformsouls.effects;

import com.uniform.uniformsouls.UniformSouls;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.effect.StatusEffects;

public class Bravery1Effect extends StatusEffect {
    public Bravery1Effect() {
        super(
                StatusEffectType.BENEFICIAL, // whether beneficial or harmful for entities
                16679168); // color in RGB
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
            this.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CC", 4.0D, EntityAttributeModifier.Operation.ADDITION);
        }

        if (entity.hasStatusEffect(UniformSouls.BRADEBUFFEFFECT1)) {
            entity.removeStatusEffect(UniformSouls.BRADEBUFFEFFECT1);
        }

    }
}