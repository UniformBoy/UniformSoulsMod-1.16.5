package com.uniform.uniformsouls.effects;

import com.mojang.blaze3d.systems.RenderSystem;
import com.uniform.uniformsouls.UniformSouls;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.effect.StatusEffects;

public class ScaredEffect extends StatusEffect {


    public ScaredEffect() {
        super(
                StatusEffectType.HARMFUL, // whether beneficial or harmful for entities
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
            ((Entity) entity).setVelocity(0,-10,0);
            this.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635", -100.0D, EntityAttributeModifier.Operation.ADDITION);
            this.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3", -0.45000000596046448D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        }

        if (entity.hasStatusEffect(UniformSouls.INTEGRITYEFFECT1)) {
            entity.removeStatusEffect(UniformSouls.INTEGRITYEFFECT1);
        }

        if (entity.hasStatusEffect(UniformSouls.BRAVERYEFFECT1)) {
            entity.removeStatusEffect(UniformSouls.BRAVERYEFFECT1);
        }

        if (entity.hasStatusEffect(UniformSouls.DETERMINATIONEFFECT1)) {
            entity.removeStatusEffect(UniformSouls.DETERMINATIONEFFECT1);
        }

        if (entity.hasStatusEffect(UniformSouls.JUSTICEEFFECT1)) {
            entity.removeStatusEffect(UniformSouls.JUSTICEEFFECT1);
        }

        if (entity.hasStatusEffect(UniformSouls.KINDNESSEFFECT1)) {
            entity.removeStatusEffect(UniformSouls.KINDNESSEFFECT1);
        }

        if (entity.hasStatusEffect(UniformSouls.KINDNESSEFFECT2)) {
            entity.removeStatusEffect(UniformSouls.KINDNESSEFFECT2);
        }

        if (entity.hasStatusEffect(UniformSouls.PATIENCEEFFECT1)) {
            entity.removeStatusEffect(UniformSouls.PATIENCEEFFECT1);
        }

        if (entity.hasStatusEffect(UniformSouls.PERSEVERANCEEFFECT1)) {
            entity.removeStatusEffect(UniformSouls.PERSEVERANCEEFFECT1);
        }

        if (entity.hasStatusEffect(UniformSouls.CREATIVITYEFFECT1)) {
            entity.removeStatusEffect(UniformSouls.CREATIVITYEFFECT1);
        }

    }
}