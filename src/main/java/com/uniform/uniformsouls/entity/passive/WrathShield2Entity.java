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
import net.minecraft.world.World;

public class WrathShield2Entity extends PathAwareEntity {

    public int ticksLeft;
    public int lifespan;
    public int duration;


    public WrathShield2Entity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        this.duration = 10;
    }

    public void tick() {
        super.tick();
        if (duration == 0) {
            this.remove();
        }
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



    public static DefaultAttributeContainer.Builder createwrathshieldAttributes() {
        return PassiveEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 200)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,10)
                .add(EntityAttributes.GENERIC_ARMOR, 0);
    }
}

