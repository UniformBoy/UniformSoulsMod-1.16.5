package com.uniform.uniformsouls.entity.passive;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.VexEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableShoulderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;

public class VexPetEntity extends TameableShoulderEntity implements Flutterer {
    private static final TrackedData<Integer> VARIANT;
    private static final Predicate<MobEntity> CAN_IMITATE;
    private static final Item COOKIE;
    private static final Set<Item> TAMING_INGREDIENTS;
    public float flapProgress;
    public float maxWingDeviation;
    public float prevMaxWingDeviation;
    public float prevFlapProgress;
    private float flapSpeed = 1.0F;
    private boolean songPlaying;
    private BlockPos songSource;
    private boolean alive;
    private int lifeTicks;

    public VexPetEntity(EntityType<? extends VexPetEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new VexPetEntity.VexPetMoveControl(this);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, -1.0F);
        this.setPathfindingPenalty(PathNodeType.DAMAGE_FIRE, -1.0F);
    }


    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        if (entityData == null) {
            entityData = new PassiveData(false);
        }

        return super.initialize(world, difficulty, spawnReason, (EntityData)entityData, entityNbt);
    }

    public boolean isBaby() {
        return false;
    }

    protected void initGoals() {
        this.goalSelector.add(0, new EscapeDangerGoal(this, 1.25D));
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(2, new SitGoal(this));
        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerGoal(this));
        this.goalSelector.add(2, new FollowOwnerGoal(this, 1.0D, 5.0F, 1.0F, true));
        //this.goalSelector.add(3, new SitOnOwnerShoulderGoal(this));
    }

    public static DefaultAttributeContainer.Builder createParrotAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 6.0D).add(EntityAttributes.GENERIC_FLYING_SPEED, 0.4000000059604645D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.20000000298023224D);
    }

    protected EntityNavigation createNavigation(World world) {
        BirdNavigation birdNavigation = new BirdNavigation(this, world);
        birdNavigation.setCanPathThroughDoors(false);
        birdNavigation.setCanSwim(true);
        birdNavigation.setCanEnterOpenDoors(true);
        return birdNavigation;
    }

    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return dimensions.height * 0.6F;
    }

    public void tickMovement() {
        if (this.songSource == null || !this.songSource.isWithinDistance(this.getPos(), 3.46D) || !this.world.getBlockState(this.songSource).isOf(Blocks.JUKEBOX)) {
            this.songPlaying = false;
            this.songSource = null;
        }


        super.tickMovement();
        this.flapWings();
    }

    @Environment(EnvType.CLIENT)
    public void setNearbySongPlaying(BlockPos songPosition, boolean playing) {
        this.songSource = songPosition;
        this.songPlaying = playing;
    }

    @Environment(EnvType.CLIENT)
    public boolean isSongPlaying() {
        return this.songPlaying;
    }

    private void flapWings() {
        this.prevFlapProgress = this.flapProgress;
        this.prevMaxWingDeviation = this.maxWingDeviation;
        this.maxWingDeviation = (float)((double)this.maxWingDeviation + (double)(!this.onGround && !this.hasVehicle() ? 4 : -1) * 0.3D);
        this.maxWingDeviation = MathHelper.clamp(this.maxWingDeviation, 0.0F, 1.0F);
        if (!this.onGround && this.flapSpeed < 1.0F) {
            this.flapSpeed = 1.0F;
        }

        this.flapSpeed = (float)((double)this.flapSpeed * 0.9D);
        Vec3d vec3d = this.getVelocity();
        if (!this.onGround && vec3d.y < 0.0D) {
            this.setVelocity(vec3d.multiply(1.0D, 0.6D, 1.0D));
        }

        this.flapProgress += this.flapSpeed * 2.0F;
    }

    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (!this.isTamed() && TAMING_INGREDIENTS.contains(itemStack.getItem())) {
            if (!player.abilities.creativeMode) {
                itemStack.decrement(1);
            }

            if (!this.isSilent()) {
                this.world.playSound((PlayerEntity)null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_PARROT_EAT, this.getSoundCategory(), 1.0F, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.2F);
            }

            if (!this.world.isClient) {
                if (this.random.nextInt(10) == 0) {
                    this.setOwner(player);
                    this.world.sendEntityStatus(this, (byte)7);
                } else {
                    this.world.sendEntityStatus(this, (byte)6);
                }
            }

            return ActionResult.success(this.world.isClient);
        } else if (itemStack.getItem() == COOKIE) {
            if (!player.abilities.creativeMode) {
                itemStack.decrement(1);
            }

            this.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 900));

            return ActionResult.success(this.world.isClient);
        } else if (!this.isInAir() && this.isTamed() && this.isOwner(player)) {
            if (!this.world.isClient) {
                this.setSitting(!this.isSitting());
            }

            return ActionResult.success(this.world.isClient);
        } else {
            return super.interactMob(player, hand);
        }
    }

    public boolean isBreedingItem(ItemStack stack) {
        return false;
    }

    /*public static boolean canSpawn(EntityType<ParrotEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        BlockState blockState = world.getBlockState(pos.down());
        return (blockState.isIn(BlockTags.LEAVES) || blockState.isOf(Blocks.GRASS_BLOCK) || blockState.isIn(BlockTags.LOGS) || blockState.isOf(Blocks.AIR)) && world.getBaseLightLevel(pos, 0) > 8;
    }

     */

    public boolean handleFallDamage(float fallDistance, float damageMultiplier) {
        return false;
    }

    protected void fall(double heightDifference, boolean onGround, BlockState landedState, BlockPos landedPosition) {
    }

    public boolean canBreedWith(AnimalEntity other) {
        return false;
    }

    @Nullable
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    public boolean tryAttack(Entity target) {
        return target.damage(DamageSource.mob(this), 3.0F);
    }

    @Nullable
    public SoundEvent getAmbientSound() {
        return getRandomSound(this.world, this.world.random);
    }

    public static SoundEvent getRandomSound(World world, Random random) {
        if (world.getDifficulty() != Difficulty.PEACEFUL && random.nextInt(1000) == 0) {

        } else {
            return SoundEvents.ENTITY_VEX_AMBIENT;
        }
        return SoundEvents.ENTITY_VEX_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_VEX_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_VEX_DEATH;
    }

    protected float playFlySound(float distance) {
        this.playSound(SoundEvents.ENTITY_PARROT_FLY, 0.15F, 1.0F);
        return distance + this.maxWingDeviation / 2.0F;
    }

    protected boolean hasWings() {
        return true;
    }

    protected float getSoundPitch() {
        return getSoundPitch(this.random);
    }

    public static float getSoundPitch(Random random) {
        return (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F;
    }

    public SoundCategory getSoundCategory() {
        return SoundCategory.NEUTRAL;
    }

    public boolean isPushable() {
        return true;
    }

    protected void pushAway(Entity entity) {
        if (!(entity instanceof PlayerEntity)) {
            super.pushAway(entity);
        }
    }

    public boolean damage(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else {
            this.setSitting(false);
            return super.damage(source, amount);
        }
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(VARIANT, 0);
    }

    public boolean isInAir() {
        return !this.onGround;
    }

    @Environment(EnvType.CLIENT)
    public Vec3d method_29919() {
        return new Vec3d(0.0D, (double)(0.5F * this.getStandingEyeHeight()), (double)(this.getWidth() * 0.4F));
    }

    static {
        VARIANT = DataTracker.registerData(ParrotEntity.class, TrackedDataHandlerRegistry.INTEGER);
        CAN_IMITATE = new Predicate<MobEntity>() {
            public boolean test(@Nullable MobEntity mobEntity) {
                return mobEntity != null;
            }
        };
        COOKIE = Items.COOKIE;
        TAMING_INGREDIENTS = Sets.newHashSet(new Item[]{Items.EMERALD, Items.IRON_SWORD, Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS});
    }

    class VexPetMoveControl extends MoveControl {
        public VexPetMoveControl(VexPetEntity owner) {
            super(owner);
        }

        public void tick() {
            if (this.state == State.MOVE_TO) {
                Vec3d vec3d = new Vec3d(this.targetX - VexPetEntity.this.getX(), this.targetY - VexPetEntity.this.getY(), this.targetZ - VexPetEntity.this.getZ());
                double d = vec3d.length();
                if (d < VexPetEntity.this.getBoundingBox().getAverageSideLength()) {
                    this.state = State.WAIT;
                    VexPetEntity.this.setVelocity(VexPetEntity.this.getVelocity().multiply(0.5D));
                } else {
                    VexPetEntity.this.setVelocity(VexPetEntity.this.getVelocity().add(vec3d.multiply(this.speed * 0.05D / d)));
                    if (VexPetEntity.this.getTarget() == null) {
                        Vec3d vec3d2 = VexPetEntity.this.getVelocity();
                        VexPetEntity.this.yaw = -((float)MathHelper.atan2(vec3d2.x, vec3d2.z)) * 57.295776F;
                        VexPetEntity.this.bodyYaw = VexPetEntity.this.yaw;
                    } else {
                        double e = VexPetEntity.this.getTarget().getX() - VexPetEntity.this.getX();
                        double f = VexPetEntity.this.getTarget().getZ() - VexPetEntity.this.getZ();
                        VexPetEntity.this.yaw = -((float)MathHelper.atan2(e, f)) * 57.295776F;
                        VexPetEntity.this.bodyYaw = VexPetEntity.this.yaw;
                    }
                }

            }
        }
    }

    public void tick() {
        this.noClip = true;
        super.tick();
        this.noClip = false;
        this.setNoGravity(true);

    }

    public static DefaultAttributeContainer.Builder createvexpetAttributes() {
        return PassiveEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.6)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,1)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 30.0)
                .add(EntityAttributes.GENERIC_ARMOR, 0);
    }

}

