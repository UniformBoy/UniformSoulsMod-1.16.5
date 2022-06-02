//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.uniform.uniformsouls.entity.goals.gaster_blaster_goals;

import java.util.EnumSet;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.predicate.entity.EntityPredicates;

public class LookWithPlayerGoal extends Goal {

    public final MobEntity mob;
    public Entity target;
    public final float range;
    private int lookTime;
    public final float chance;
    public final Class<? extends LivingEntity> targetType;
    public final TargetPredicate targetPredicate;

    public LookWithPlayerGoal(MobEntity mob, Class<? extends LivingEntity> targetType, float range) {
        this(mob, targetType, range, 0.02F);
    }

    public LookWithPlayerGoal(MobEntity mob, Class<? extends LivingEntity> targetType, float range, float chance) {
        this.mob = mob;
        this.targetType = targetType;
        this.range = range;
        this.chance = chance;
        this.setControls(EnumSet.of(Control.LOOK));
        if (targetType == PlayerEntity.class) {
            this.targetPredicate = (new TargetPredicate()).setBaseMaxDistance((double)range).includeTeammates().includeInvulnerable().ignoreEntityTargetRules().setPredicate((livingEntity) -> {
                return EntityPredicates.rides(mob).test(livingEntity);
            });
        } else {
            this.targetPredicate = (new TargetPredicate()).setBaseMaxDistance((double)range).includeTeammates().includeInvulnerable().ignoreEntityTargetRules();
        }

    }

    public boolean canStart() {
        if (this.mob.getRandom().nextFloat() >= this.chance) {
            return false;
        } else {
            if (this.mob.getTarget() != null) {
                this.target = this.mob.getTarget();
            }

            if (this.targetType == PlayerEntity.class) {
                this.target = this.mob.world.getClosestPlayer(this.targetPredicate, this.mob, this.mob.getX(), this.mob.getEyeY(), this.mob.getZ());
            } else {
                this.target = this.mob.world.getClosestEntityIncludingUngeneratedChunks(this.targetType, this.targetPredicate, this.mob, this.mob.getX(), this.mob.getEyeY(), this.mob.getZ(), this.mob.getBoundingBox().expand((double)this.range, 3.0D, (double)this.range));
            }

            return this.target != null;
        }
    }

    public boolean shouldContinue() {
        if (!this.target.isAlive()) {
            return false;
        } else if (this.mob.squaredDistanceTo(this.target) > (double)(this.range * this.range)) {
            return false;
        } else {
            return this.lookTime > 0;
        }
    }

    public void start() {
        this.lookTime = 40 + this.mob.getRandom().nextInt(40);
    }

    public void stop() {
        this.target = null;
    }

    public void tick() {
        this.mob.getLookControl().lookAt(this.target.getX(), this.target.getEyeY(), this.target.getZ());
        --this.lookTime;
    }
}
