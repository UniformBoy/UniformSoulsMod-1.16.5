package com.uniform.uniformsouls.mixins;

import com.uniform.uniformsouls.entity.goals.corruption_goals.CorruptionMeleeAttackGoal;
import com.uniform.uniformsouls.misc.SoulTag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MeleeAttackGoal.class)

    public interface CorruptionMeleeAttackCooldown1 {
        @Accessor("field_24667")
        public void Uniformsouls$setCooldown(int cooldown);
    }
