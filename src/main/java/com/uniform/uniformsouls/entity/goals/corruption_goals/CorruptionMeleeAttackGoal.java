//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.uniform.uniformsouls.entity.goals.corruption_goals;

import com.uniform.uniformsouls.entity.mob.CorruptionEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class CorruptionMeleeAttackGoal extends MeleeAttackGoal {
    public final CorruptionEntity corruption;
    public int ticks;

    public CorruptionMeleeAttackGoal(CorruptionEntity corruption, double speed, boolean pauseWhenMobIdle) {
        super(corruption, speed, pauseWhenMobIdle);
        this.corruption = corruption;
    }

    public void start() {
        super.start();
        this.ticks = 0;
    }

    public void stop() {
        super.stop();
        this.corruption.setAttacking(false);
    }

    public void tick() {
        super.tick();
        ++this.ticks;
        if (this.ticks >= 5 && this.method_28348() < this.method_28349() / 2) {
            this.corruption.setAttacking(true);
        } else {
            this.corruption.setAttacking(false);
        }

    }
}
