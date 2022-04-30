//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.uniform.uniformsouls.entity.goals.corruption_goals;

import com.uniform.uniformsouls.entity.mob.CorruptionEntity;
import com.uniform.uniformsouls.mixins.CorruptionMeleeAttackCooldown1;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;

import java.util.EnumSet;

public class CorruptionMeleeAttackGoal extends MeleeAttackGoal {
    public final CorruptionEntity corruption;
    public int field_24667;


    public CorruptionMeleeAttackGoal(CorruptionEntity corruption, double speed, boolean pauseWhenMobIdle) {
        super(corruption, speed, pauseWhenMobIdle);
        this.corruption = corruption;
    }

    @Override
    public void method_28346() {
        ((CorruptionMeleeAttackCooldown1)this).Uniformsouls$setCooldown(this.method_28349());
    }

    @Override
    public int method_28349() {
        return 40;
    }


}
