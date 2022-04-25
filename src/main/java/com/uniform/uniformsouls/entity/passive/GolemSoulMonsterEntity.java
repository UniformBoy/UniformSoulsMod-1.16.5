package com.uniform.uniformsouls.entity.passive;

import com.uniform.uniformsouls.UniformSouls;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GolemSoulMonsterEntity extends IronGolemEntity {

    public boolean IronGolemCanSpawn = true;

    public GolemSoulMonsterEntity(EntityType<? extends IronGolemEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 5;
    }

    public SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_IRON_GOLEM_HURT;
    }

    public void playHurtSound(DamageSource source) {
        this.playSound(this.getHurtSound(source), 1.0F, 0.5F);
    }

    public SoundEvent getDeathSound() {
        return UniformSouls.MONSTER_GENERIC_DEATH_1_EVENT;
    }

    public void playDeathSound() {
        this.playSound(this.getDeathSound(), 5.0F, 1.0F);
    }

    public SoundEvent getStepSound() {
        return SoundEvents.ENTITY_IRON_GOLEM_STEP;
    }

    public void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(this.getStepSound(), 1.0F, 0.85F);
    }

    public EntityGroup getGroup() {
        return EntityGroup.DEFAULT;
    }

    public static DefaultAttributeContainer.Builder creategolemmonstersoulAttributes() {
        return PassiveEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 150)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.19)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 0.5)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,2)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 15.0)
                .add(EntityAttributes.GENERIC_ARMOR, 5)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1);
    }
}

