package com.uniform.uniformsouls.blocks;

import net.minecraft.block.TransparentBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class CloudBlock extends TransparentBlock {

    public CloudBlock(Settings settings) {
        super(settings);
    }

    public void onLandedUpon(World world, BlockPos pos, Entity entity, float distance) {
        if (entity.bypassesLandingEffects()) {
            super.onLandedUpon(world, pos, entity, distance);
        } else {
            entity.handleFallDamage(distance, 0.0F);
        }

    }

    public void onEntityLand(BlockView world, Entity entity) {
        if (entity.bypassesLandingEffects()) {
            super.onEntityLand(world, entity);
        } else {
            this.bounce(entity);
        }

    }

    private void bounce(Entity entity) {
        Vec3d vec3d = entity.getVelocity();
        if (vec3d.y < 0.0D) {
            double d = entity instanceof LivingEntity ? 1.0D : 0.8D;
            entity.setVelocity(vec3d.x, -vec3d.y * d, vec3d.z);
        }

    }

    public void onSteppedOn(World world, BlockPos pos, Entity entity) {
        double d = Math.abs(entity.getVelocity().y);
        if (d < 0.1D && !entity.bypassesSteppingEffects()) {
            double e = 0.4D + d * 0.2D;
            entity.setVelocity(entity.getVelocity().multiply(e, 1.0D, e));
        }

        super.onSteppedOn(world, pos, entity);
    }
}
