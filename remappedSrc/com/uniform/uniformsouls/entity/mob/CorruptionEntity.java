package com.uniform.uniformsouls.entity.mob;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.blocks.Corruption;
import com.uniform.uniformsouls.entity.goals.corruption_goals.CorruptionAttackGoal;
import com.uniform.uniformsouls.entity.passive.KindnessShield2Entity;
import com.uniform.uniformsouls.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.NavigationConditions;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.MobNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtOps;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;
import net.minecraft.world.explosion.Explosion;

import java.util.Random;

public class CorruptionEntity extends HostileEntity {


    public CorruptionEntity(EntityType<? extends CorruptionEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 5;
    }

    public void initGoals() {
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.initCustomGoals();
    }

    public void initCustomGoals() {
        this.goalSelector.add(2, new CorruptionAttackGoal(this, 1.0D, false));
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0D));
        this.targetSelector.add(1, new FollowTargetGoal(this, PlayerEntity.class, true));
        this.targetSelector.add(1, new FollowTargetGoal(this, KindnessShield2Entity.class, true));
        this.targetSelector.add(2, new FollowTargetGoal(this, MerchantEntity.class, false));
        this.targetSelector.add(3, new FollowTargetGoal(this, IronGolemEntity.class, true));
        this.targetSelector.add(4, new FollowTargetGoal(this, PassiveEntity.class, true));
    }

    public boolean CorruptionCanSpawn = true;


    // //
    public float getPathfindingFavor(BlockPos pos) {
        return this.getPathfindingFavor(pos, this.world);
    }

    public float getPathfindingFavor(BlockPos pos, WorldView world) {
        return 0.0F;
    }

    public boolean canSpawn(WorldAccess world, SpawnReason spawnReason) {
        return this.getPathfindingFavor(this.getBlockPos(), world) >= 0.0F;
    }
    // //

    public SoundEvent getAmbientSound() {
        return UniformSouls.SHADOW_WALKER_1_EVENT;
    }

    public void playAmbientSound() {
        this.playSound(this.getAmbientSound(), 1.2F, 0.5F);
    }

    public SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_PLAYER_HURT;
    }

    public SoundEvent getDeathSound() {
        return UniformSouls.SOUL_GENERIC_SHATTER_1_EVENT;
    }

    public void playDeathSound() {
        this.playSound(this.getDeathSound(), 1.0F, 0.5F);
    }

    public SoundEvent getStepSound() {
        return SoundEvents.BLOCK_WART_BLOCK_STEP;
    }

    public void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    public boolean tryAttack(Entity target) {
        boolean bl = super.tryAttack(target);
        if (bl && this.getMainHandStack().isEmpty() && target instanceof LivingEntity) {
            float f = this.world.getLocalDifficulty(this.getBlockPos()).getLocalDifficulty();
            ((LivingEntity)target).addStatusEffect(new StatusEffectInstance(UniformSouls.CORRUPTIONCORRUPTINGEFFECT1, 300 * (int)f));
        }

        return bl;
    }

    public EntityGroup getGroup() {
        return EntityGroup.DEFAULT;
    }

    public static DefaultAttributeContainer.Builder createcorruptionAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 50)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 15)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 80.0)
                .add(EntityAttributes.GENERIC_ARMOR, 10)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1);
    }

    @Override
    public boolean canSpawn(WorldView view) {
        BlockPos blockunderentity = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        BlockPos posentity = new BlockPos(this.getX(), this.getY(), this.getZ());
        return view.intersectsEntities(this) && !world.containsFluid(this.getBoundingBox())
                && this.world.getBlockState(posentity).getBlock().canMobSpawnInside()
                && this.world.getBlockState(blockunderentity).allowsSpawning(view, blockunderentity, UniformSouls.CORRUPTION)
                && CorruptionCanSpawn;
    }

    public static boolean canMobSpawn(EntityType<? extends MobEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        BlockPos blockPos = pos.down();
        return spawnReason == SpawnReason.SPAWNER || world.getBlockState(blockPos).equals(ModBlocks.CORRUPTION.getDefaultState()) || world.getBlockState(blockPos).equals(ModBlocks.CORRUPTION_INACTIVE.getDefaultState());
    }

    public void onKilledOther(ServerWorld serverWorld, LivingEntity livingEntity) {

            CorruptionEntity corruptionEntity = (CorruptionEntity) UniformSouls.CORRUPTION.create(this.world);
            corruptionEntity.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.yaw, 0.0F);
            this.world.spawnEntity(corruptionEntity);
        }
            }


