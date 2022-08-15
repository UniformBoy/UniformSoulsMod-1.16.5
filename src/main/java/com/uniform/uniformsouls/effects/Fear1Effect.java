package com.uniform.uniformsouls.effects;

import com.uniform.uniformsouls.UniformSouls;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class Fear1Effect extends StatusEffect {
    public Fear1Effect() {
        super(
                StatusEffectType.BENEFICIAL, // whether beneficial or harmful for entities
                16020466); // color in RGB
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
            this.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "648D7064-6A60-4F59-8ABE-C2C23A6DD7A9", 0.35000000596046448D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
            this.addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, "7107DE5E-7CE8-4030-940E-514C1F160890", 0.35000000596046448D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
            this.addAttributeModifier(EntityAttributes.GENERIC_ARMOR, "7107DE5E-7CE8-4030-940E-514C1F160890", 0.35000000596046448D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);

            entity.heal(0.05F);

            if (entity.hasStatusEffect(UniformSouls.SCARED)) {
                entity.removeStatusEffect(UniformSouls.SCARED);
            }

        }
    }
}