package com.uniform.uniformsouls.entity.passive;

import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class MonsterShield2Entity extends PathAwareEntity {

    public int ticksLeft;
    public int lifespan;
    public int duration;


    public MonsterShield2Entity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        this.duration = 200;
        this.noClip = true;
    }

    public void tick() {
        super.tick();
        duration --;
        if (duration == 0) {
            this.remove();
        }
    }

    public void tickMovement() {
        super.tickMovement();
        this.setVelocity(Vec3d.ZERO);
        if (this.onGround) {
            this.prevBodyYaw = 0.0F;
            this.bodyYaw = 0.0F;
        }

        if (!this.onGround) {
            this.prevBodyYaw = 1.0F;
            this.bodyYaw = 1.0F;
        }

    }

    @Override
    public boolean isPushable() {
        if (!this.onGround) {
            return true;
        } else
            return false;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = 10;
    }

    public SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.BLOCK_GLASS_HIT;
    }

    public SoundEvent getDeathSound() {
        return SoundEvents.BLOCK_GLASS_BREAK;
    }


    public EntityGroup getGroup() {
        return EntityGroup.DEFAULT;
    }



    public static DefaultAttributeContainer.Builder createmonstershieldAttributes() {
        return PassiveEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 75)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,10)
                .add(EntityAttributes.GENERIC_ARMOR, 0);
    }
}

