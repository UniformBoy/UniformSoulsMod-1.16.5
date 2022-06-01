package com.uniform.uniformsouls.entity.passive;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FounderLabEntity extends IronGolemEntity {

    public boolean IronGolemCanSpawn = true;

    public FounderLabEntity(EntityType<? extends IronGolemEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 5;
    }

    public boolean burnsInDaylight() {
        return false;
    }

    public SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_CAT_PURR;
    }

    public void playAmbientSound() {
        this.playSound(this.getAmbientSound(), 0.3F, 2.0F);
    }

    public SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_PLAYER_HURT;
    }

    public SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PLAYER_DEATH;
    }

    public SoundEvent getStepSound() {
        return SoundEvents.BLOCK_STONE_STEP;
    }

    public void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(this.getStepSound(), 0.15F, 0.8F);
    }

    public EntityGroup getGroup() {
        return EntityGroup.DEFAULT;
    }

    public static DefaultAttributeContainer.Builder createfounderlabAttributes() {
        return PassiveEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 50)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,1)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 30.0)
                .add(EntityAttributes.GENERIC_ARMOR, 0)
                .add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS, 0);
    }
}

