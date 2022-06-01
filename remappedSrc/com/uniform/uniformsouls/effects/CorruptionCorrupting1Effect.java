package com.uniform.uniformsouls.effects;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.enchantments.PureEnchantment;
import com.uniform.uniformsouls.entity.mob.CorruptionEntity;
import com.uniform.uniformsouls.entity.mob.HateEntity;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.item.ItemStack;

public class CorruptionCorrupting1Effect extends StatusEffect {

    public CorruptionCorrupting1Effect() {
        super(
                StatusEffectType.HARMFUL, // whether beneficial or harmful for entities
                0); // color in RGB
    }

    // This method is called every tick to check whether it should apply the status effect or not
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {

        if (entity instanceof LivingEntity && PureEnchantment.hasPure((LivingEntity)entity)) {
            entity.removeStatusEffect(UniformSouls.CORRUPTIONCORRUPTINGEFFECT1);
        }

    }
}