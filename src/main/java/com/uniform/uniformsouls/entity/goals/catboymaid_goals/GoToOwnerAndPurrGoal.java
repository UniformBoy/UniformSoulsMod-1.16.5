//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.uniform.uniformsouls.entity.goals.catboymaid_goals;



import com.uniform.uniformsouls.entity.passive.CatBoyMaidEntity;
import net.minecraft.entity.ai.goal.Goal.Control;
import net.minecraft.entity.ai.goal.MoveToTargetPosGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

import java.util.EnumSet;

public class GoToOwnerAndPurrGoal extends MoveToTargetPosGoal {
    private final CatBoyMaidEntity cat;

    public GoToOwnerAndPurrGoal(CatBoyMaidEntity cat, double speed, int range) {
        super(cat, speed, range, 6);
        this.cat = cat;
        this.lowestY = -2;
        this.setControls(EnumSet.of(Control.JUMP, Control.MOVE));
    }

    public boolean canStart() {
        return this.cat.isTamed() && !this.cat.isSitting() && !this.cat.isSleepingWithOwner() && super.canStart();
    }

    public void start() {
        super.start();
        this.cat.setInSittingPose(false);
    }

    protected int getInterval(PathAwareEntity mob) {
        return 40;
    }

    public void stop() {
        super.stop();
        this.cat.setSleepingWithOwner(false);
    }

    public void tick() {
        super.tick();
        this.cat.setInSittingPose(false);
        if (!this.hasReached()) {
            this.cat.setSleepingWithOwner(false);
        } else if (!this.cat.isSleepingWithOwner()) {
            this.cat.setSleepingWithOwner(true);
        }

    }

    protected boolean isTargetPos(WorldView world, BlockPos pos) {
        return world.isAir(pos.up()) && world.getBlockState(pos).getBlock().isIn(BlockTags.BEDS);
    }
}
