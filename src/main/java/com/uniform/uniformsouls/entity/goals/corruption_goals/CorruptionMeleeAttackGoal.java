//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.uniform.uniformsouls.entity.goals.corruption_goals;

import com.uniform.uniformsouls.entity.mob.CorruptionEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

import java.util.EnumSet;

public class CorruptionMeleeAttackGoal extends MeleeAttackGoal {
    public final CorruptionEntity corruption;
    public int ticks;
    public double moveSpeedAmp = 1;
    public int attackTime = -1;

    public CorruptionMeleeAttackGoal(CorruptionEntity corruption, double speed, boolean pauseWhenMobIdle) {
        super(corruption, speed, pauseWhenMobIdle);
        this.corruption = corruption;
        this.moveSpeedAmp = speed;
        this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
    }

    public void start() {
        super.start();
        this.ticks = 0;
        this.corruption.setAttacking(true);
    }

    public void stop() {
        super.stop();
        this.corruption.setAttacking(false);
        this.corruption.setAttackingState(false);
    }

    public void tick() {
        LivingEntity livingentity = this.corruption.getTarget();
        if (livingentity != null) {
            boolean inLineOfSight = this.corruption.getVisibilityCache().canSee(livingentity);
            this.attackTime++;
            this.corruption.lookAtEntity(livingentity, 30.0F, 30.0F);
            double d0 = this.corruption.squaredDistanceTo(livingentity.getX(), livingentity.getY(), livingentity.getZ());
            double d1 = livingentity.getWidth() * 2.5F * livingentity.getWidth() * 2.5F + livingentity.getWidth();
            if (inLineOfSight) {
                if (this.corruption.distanceTo(livingentity) >= 3.0D) {
                    this.corruption.getNavigation().startMovingTo(livingentity, this.moveSpeedAmp);
                    this.attackTime = -5;
                } else {
                    if (this.attackTime == 4) {
                        this.corruption.getNavigation().startMovingTo(livingentity, this.moveSpeedAmp);
                        if (d0 <= d1) {
                            this.corruption.tryAttack(livingentity);
                            this.corruption.setAttackingState(true);
                        }
                        livingentity.timeUntilRegen = 0;
                    }
                    if (this.attackTime == 8) {
                        this.attackTime = -5;
                        this.corruption.setAttackingState(false);
                    }
                }
            }
        }
    }
}