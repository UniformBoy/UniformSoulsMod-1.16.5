package com.uniform.uniformsouls.entity.passive;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.entity.goals.catboymaid_goals.CatBoySitOnBlockGoal;
import com.uniform.uniformsouls.entity.goals.catboymaid_goals.GoToOwnerAndPurrGoal;
import com.uniform.uniformsouls.entity.passive.CatBoyMaidEntity.TemptGoal;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.StructureFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;

public class CatBoyMaidEntity extends TameableEntity {
    private static final Ingredient TAMING_INGREDIENT;
    private static final TrackedData<Integer> CAT_TYPE;
    private static final TrackedData<Boolean> SLEEPING_WITH_OWNER;
    private static final TrackedData<Boolean> HEAD_DOWN;
    private static final TrackedData<Integer> COLLAR_COLOR;
    private net.minecraft.entity.ai.goal.TemptGoal temptGoal;
    private float sleepAnimation;
    private float prevSleepAnimation;
    private float tailCurlAnimation;
    private float prevTailCurlAnimation;
    private float headDownAnimation;
    private float prevHeadDownAnimation;

    public boolean CatCanSpawn = true;

    public CatBoyMaidEntity(EntityType<? extends CatBoyMaidEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 5;
        this.isSitting();
    }

    public SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_CAT_PURR;
    }

    public SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_PLAYER_HURT;
    }

    public SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PLAYER_DEATH;
    }

    public void playStepSound(BlockPos pos, BlockState state) {}

    public EntityGroup getGroup() {
        return EntityGroup.DEFAULT;
    }

    public float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return dimensions.height * 0.85F;
    }


    public static DefaultAttributeContainer.Builder createcatboymaidAttributes() {
        return PassiveEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,1)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 30.0)
                .add(EntityAttributes.GENERIC_ARMOR, 0);
    }

    protected void initGoals() {
        this.temptGoal = new TemptGoal(this, 0.6D, TAMING_INGREDIENT, true);
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(1, new SitGoal(this));
        this.goalSelector.add(3, this.temptGoal);
        this.goalSelector.add(5, new GoToOwnerAndPurrGoal(this, 1.1D, 8));
        this.goalSelector.add(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 5.0F, false));
        this.goalSelector.add(7, new CatBoySitOnBlockGoal(this, 0.8D));
        this.goalSelector.add(8, new PounceAtTargetGoal(this, 0.3F));
        this.goalSelector.add(9, new AttackGoal(this));
        this.goalSelector.add(10, new AnimalMateGoal(this, 0.8D));
        this.goalSelector.add(11, new WanderAroundFarGoal(this, 0.8D, 1.0000001E-5F));
        this.goalSelector.add(12, new LookAtEntityGoal(this, PlayerEntity.class, 10.0F));
        this.targetSelector.add(1, new FollowTargetIfTamedGoal(this, RabbitEntity.class, false, (Predicate)null));
        this.targetSelector.add(1, new FollowTargetIfTamedGoal(this, TurtleEntity.class, false, TurtleEntity.BABY_TURTLE_ON_LAND_FILTER));
    }

    public int getCatType() {
        return (Integer)this.dataTracker.get(CAT_TYPE);
    }

    public void setCatType(int type) {
        if (type < 0 || type >= 11) {
            type = this.random.nextInt(10);
        }

        this.dataTracker.set(CAT_TYPE, type);
    }

    public void setSleepingWithOwner(boolean sleeping) {
        this.dataTracker.set(SLEEPING_WITH_OWNER, sleeping);
    }

    public boolean isSleepingWithOwner() {
        return (Boolean)this.dataTracker.get(SLEEPING_WITH_OWNER);
    }

    public void setHeadDown(boolean headDown) {
        this.dataTracker.set(HEAD_DOWN, headDown);
    }

    public boolean isHeadDown() {
        return (Boolean)this.dataTracker.get(HEAD_DOWN);
    }

    public DyeColor getCollarColor() {
        return DyeColor.byId((Integer)this.dataTracker.get(COLLAR_COLOR));
    }

    public void setCollarColor(DyeColor color) {
        this.dataTracker.set(COLLAR_COLOR, color.getId());
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(CAT_TYPE, 1);
        this.dataTracker.startTracking(SLEEPING_WITH_OWNER, false);
        this.dataTracker.startTracking(HEAD_DOWN, false);
        this.dataTracker.startTracking(COLLAR_COLOR, DyeColor.RED.getId());
    }

    public void writeCustomDataToNbt(NbtCompound tag) {
        super.writeCustomDataToNbt(tag);
        tag.putInt("CatType", this.getCatType());
        tag.putByte("CollarColor", (byte)this.getCollarColor().getId());
    }

    public void readCustomDataFromNbt(NbtCompound tag) {
        super.readCustomDataFromNbt(tag);
        this.setCatType(tag.getInt("CatType"));
        if (tag.contains("CollarColor", 99)) {
            this.setCollarColor(DyeColor.byId(tag.getInt("CollarColor")));
        }

    }

    public void mobTick() {
        if (this.getMoveControl().isMoving()) {
            double d = this.getMoveControl().getSpeed();
            if (d == 0.6D) {
                this.setPose(EntityPose.CROUCHING);
                this.setSprinting(false);
            } else if (d == 1.33D) {
                this.setPose(EntityPose.STANDING);
                this.setSprinting(true);
            } else {
                this.setPose(EntityPose.STANDING);
                this.setSprinting(false);
            }
        } else {
            this.setPose(EntityPose.STANDING);
            this.setSprinting(false);
        }

    }

    public int getMinAmbientSoundDelay() {
        return 120;
    }

    public void hiss() {
        this.playSound(SoundEvents.ENTITY_CAT_HISS, this.getSoundVolume(), this.getSoundPitch());
    }

    public static DefaultAttributeContainer.Builder createCatAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.30000001192092896D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0D);
    }

    public boolean handleFallDamage(float fallDistance, float damageMultiplier) {
        return false;
    }

    protected void eat(PlayerEntity player, ItemStack stack) {
        if (this.isBreedingItem(stack)) {
            this.playSound(SoundEvents.ENTITY_CAT_EAT, 1.0F, 1.0F);
        }

        super.eat(player, stack);
    }

    private float getAttackDamage() {
        return (float)this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
    }

    public boolean tryAttack(Entity target) {
        return target.damage(DamageSource.mob(this), this.getAttackDamage());
    }

    public void tick() {
        super.tick();
        if (this.temptGoal != null && this.temptGoal.isActive() && !this.isTamed() && this.age % 100 == 0) {
            this.playSound(SoundEvents.ENTITY_CAT_BEG_FOR_FOOD, 1.0F, 1.0F);
        }

        this.updateAnimations();

    }

    private void updateAnimations() {
        if ((this.isSleepingWithOwner() || this.isHeadDown()) && this.age % 5 == 0) {
            this.playSound(SoundEvents.ENTITY_CAT_PURR, 0.6F + 0.4F * (this.random.nextFloat() - this.random.nextFloat()), 1.0F);
        }

        this.updateSleepAnimation();
        this.updateHeadDownAnimation();
    }

    private void updateSleepAnimation() {
        this.prevSleepAnimation = this.sleepAnimation;
        this.prevTailCurlAnimation = this.tailCurlAnimation;
        if (this.isSleepingWithOwner()) {
            this.sleepAnimation = Math.min(1.0F, this.sleepAnimation + 0.15F);
            this.tailCurlAnimation = Math.min(1.0F, this.tailCurlAnimation + 0.08F);
        } else {
            this.sleepAnimation = Math.max(0.0F, this.sleepAnimation - 0.22F);
            this.tailCurlAnimation = Math.max(0.0F, this.tailCurlAnimation - 0.13F);
        }

    }

    private void updateHeadDownAnimation() {
        this.prevHeadDownAnimation = this.headDownAnimation;
        if (this.isHeadDown()) {
            this.headDownAnimation = Math.min(1.0F, this.headDownAnimation + 0.1F);
        } else {
            this.headDownAnimation = Math.max(0.0F, this.headDownAnimation - 0.13F);
        }

    }

    @Environment(EnvType.CLIENT)
    public float getSleepAnimation(float tickDelta) {
        return MathHelper.lerp(tickDelta, this.prevSleepAnimation, this.sleepAnimation);
    }

    @Environment(EnvType.CLIENT)
    public float getTailCurlAnimation(float tickDelta) {
        return MathHelper.lerp(tickDelta, this.prevTailCurlAnimation, this.tailCurlAnimation);
    }

    @Environment(EnvType.CLIENT)
    public float getHeadDownAnimation(float tickDelta) {
        return MathHelper.lerp(tickDelta, this.prevHeadDownAnimation, this.headDownAnimation);
    }

    public CatBoyMaidEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        CatBoyMaidEntity catBoyMaidEntity = (CatBoyMaidEntity) UniformSouls.CATBOYMAID.create(serverWorld);
        if (passiveEntity instanceof CatBoyMaidEntity) {
            if (this.random.nextBoolean()) {
                catBoyMaidEntity.setCatType(this.getCatType());
            } else {
                catBoyMaidEntity.setCatType(((CatBoyMaidEntity)passiveEntity).getCatType());
            }

            if (this.isTamed()) {
                catBoyMaidEntity.setOwnerUuid(this.getOwnerUuid());
                catBoyMaidEntity.setTamed(true);
                if (this.random.nextBoolean()) {
                    catBoyMaidEntity.setCollarColor(this.getCollarColor());
                } else {
                    catBoyMaidEntity.setCollarColor(((CatBoyMaidEntity)passiveEntity).getCollarColor());
                }
            }
        }

        return catBoyMaidEntity;
    }

    public boolean canBreedWith(AnimalEntity other) {
        if (!this.isTamed()) {
            return false;
        } else if (!(other instanceof CatBoyMaidEntity)) {
            return false;
        } else {
            CatBoyMaidEntity catBoyMaidEntity = (CatBoyMaidEntity) other;
            return catBoyMaidEntity.isTamed() && super.canBreedWith(other);
        }

    }

    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityTag) {
        entityData = super.initialize(world, difficulty, spawnReason, entityData, entityTag);
        if (world.getMoonSize() > 0.9F) {
            this.setCatType(this.random.nextInt(11));
        } else {
            this.setCatType(this.random.nextInt(10));
        }

        World world2 = world.toServerWorld();
        if (world2 instanceof ServerWorld && ((ServerWorld)world2).getStructureAccessor().getStructureAt(this.getBlockPos(), true, StructureFeature.SWAMP_HUT).hasChildren()) {
            this.setCatType(10);
            this.setPersistent();
        }

        return entityData;
    }

    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        Item item = itemStack.getItem();
        if (this.world.isClient) {
            if (this.isTamed() && this.isOwner(player)) {
                return ActionResult.SUCCESS;
            } else {
                return !this.isBreedingItem(itemStack) || !(this.getHealth() < this.getMaxHealth()) && this.isTamed() ? ActionResult.PASS : ActionResult.SUCCESS;
            }
        } else {
            ActionResult actionResult;
            if (this.isTamed()) {
                if (this.isOwner(player)) {
                    if (!(item instanceof DyeItem)) {
                        if (item.isFood() && this.isBreedingItem(itemStack) && this.getHealth() < this.getMaxHealth()) {
                            this.eat(player, itemStack);
                            this.heal((float)item.getFoodComponent().getHunger());
                            return ActionResult.CONSUME;
                        }

                        actionResult = super.interactMob(player, hand);
                        if (!actionResult.isAccepted() || this.isBaby()) {
                            this.setSitting(!this.isSitting());
                        }

                        return actionResult;
                    }

                    DyeColor dyeColor = ((DyeItem)item).getColor();
                    if (dyeColor != this.getCollarColor()) {
                        this.setCollarColor(dyeColor);
                        if (!player.abilities.creativeMode) {
                            itemStack.decrement(1);
                        }

                        this.setPersistent();
                        return ActionResult.CONSUME;
                    }
                }
            } else if (this.isBreedingItem(itemStack)) {
                this.eat(player, itemStack);
                if (this.random.nextInt(3) == 0) {
                    this.setOwner(player);
                    this.setSitting(true);
                    this.world.sendEntityStatus(this, (byte)7);
                } else {
                    this.world.sendEntityStatus(this, (byte)6);
                }

                this.setPersistent();
                return ActionResult.CONSUME;
            }

            actionResult = super.interactMob(player, hand);
            if (actionResult.isAccepted()) {
                this.setPersistent();
            }

            return actionResult;
        }
    }

    public boolean isBreedingItem(ItemStack stack) {
        return TAMING_INGREDIENT.test(stack);
    }

    public boolean canImmediatelyDespawn(double distanceSquared) {
        return !this.isTamed() && this.age > 2400;
    }

    static {
        TAMING_INGREDIENT = Ingredient.ofItems(new ItemConvertible[]{Items.COD, Items.SALMON});
        CAT_TYPE = DataTracker.registerData(CatEntity.class, TrackedDataHandlerRegistry.INTEGER);
        SLEEPING_WITH_OWNER = DataTracker.registerData(CatEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
        HEAD_DOWN = DataTracker.registerData(CatEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
        COLLAR_COLOR = DataTracker.registerData(CatEntity.class, TrackedDataHandlerRegistry.INTEGER);
    }

    static class SleepWithOwnerGoal extends Goal {
        private final CatEntity cat;
        private PlayerEntity owner;
        private BlockPos bedPos;
        private int ticksOnBed;

        public SleepWithOwnerGoal(CatEntity cat) {
            this.cat = cat;
        }

        public boolean canStart() {
            if (!this.cat.isTamed()) {
                return false;
            } else if (this.cat.isSitting()) {
                return false;
            } else {
                LivingEntity livingEntity = this.cat.getOwner();
                if (livingEntity instanceof PlayerEntity) {
                    this.owner = (PlayerEntity)livingEntity;
                    if (!livingEntity.isSleeping()) {
                        return false;
                    }

                    if (this.cat.squaredDistanceTo(this.owner) > 100.0D) {
                        return false;
                    }

                    BlockPos blockPos = this.owner.getBlockPos();
                    BlockState blockState = this.cat.world.getBlockState(blockPos);
                    if (blockState.getBlock().isIn(BlockTags.BEDS)) {
                        this.bedPos = (BlockPos)blockState.getOrEmpty(BedBlock.FACING).map((direction) -> {
                            return blockPos.offset(direction.getOpposite());
                        }).orElseGet(() -> {
                            return new BlockPos(blockPos);
                        });
                        return !this.method_16098();
                    }
                }

                return false;
            }
        }

        private boolean method_16098() {
            List<CatEntity> list = this.cat.world.getNonSpectatingEntities(CatEntity.class, (new Box(this.bedPos)).expand(2.0D));
            Iterator var2 = list.iterator();

            CatEntity catEntity;
            do {
                do {
                    if (!var2.hasNext()) {
                        return false;
                    }

                    catEntity = (CatEntity)var2.next();
                } while(catEntity == this.cat);
            } while(!catEntity.isSleepingWithOwner() && !catEntity.isHeadDown());

            return true;
        }

        public boolean shouldContinue() {
            return this.cat.isTamed() && !this.cat.isSitting() && this.owner != null && this.owner.isSleeping() && this.bedPos != null && !this.method_16098();
        }

        public void start() {
            if (this.bedPos != null) {
                this.cat.setInSittingPose(false);
                this.cat.getNavigation().startMovingTo((double)this.bedPos.getX(), (double)this.bedPos.getY(), (double)this.bedPos.getZ(), 1.100000023841858D);
            }

        }

        public void stop() {
            this.cat.setSleepingWithOwner(false);
            float f = this.cat.world.getSkyAngle(1.0F);
            if (this.owner.getSleepTimer() >= 100 && (double)f > 0.77D && (double)f < 0.8D && (double)this.cat.world.getRandom().nextFloat() < 0.7D) {
                this.dropMorningGifts();
            }

            this.ticksOnBed = 0;
            this.cat.setHeadDown(false);
            this.cat.getNavigation().stop();
        }

        private void dropMorningGifts() {
            Random random = this.cat.getRandom();
            BlockPos.Mutable mutable = new BlockPos.Mutable();
            mutable.set(this.cat.getBlockPos());
            this.cat.teleport((double)(mutable.getX() + random.nextInt(11) - 5), (double)(mutable.getY() + random.nextInt(5) - 2), (double)(mutable.getZ() + random.nextInt(11) - 5), false);
            mutable.set(this.cat.getBlockPos());
            LootTable lootTable = this.cat.world.getServer().getLootManager().getTable(LootTables.CAT_MORNING_GIFT_GAMEPLAY);
            net.minecraft.loot.context.LootContext.Builder builder = (new net.minecraft.loot.context.LootContext.Builder((ServerWorld)this.cat.world)).parameter(LootContextParameters.ORIGIN, this.cat.getPos()).parameter(LootContextParameters.THIS_ENTITY, this.cat).random(random);
            List<ItemStack> list = lootTable.generateLoot(builder.build(LootContextTypes.GIFT));
            Iterator var6 = list.iterator();

            while(var6.hasNext()) {
                ItemStack itemStack = (ItemStack)var6.next();
                this.cat.world.spawnEntity(new ItemEntity(this.cat.world, (double)mutable.getX() - (double)MathHelper.sin(this.cat.bodyYaw * 0.017453292F), (double)mutable.getY(), (double)mutable.getZ() + (double)MathHelper.cos(this.cat.bodyYaw * 0.017453292F), itemStack));
            }

        }

        public void tick() {
            if (this.owner != null && this.bedPos != null) {
                this.cat.setInSittingPose(false);
                this.cat.getNavigation().startMovingTo((double)this.bedPos.getX(), (double)this.bedPos.getY(), (double)this.bedPos.getZ(), 1.100000023841858D);
                if (this.cat.squaredDistanceTo(this.owner) < 2.5D) {
                    ++this.ticksOnBed;
                    if (this.ticksOnBed > 16) {
                        this.cat.setSleepingWithOwner(true);
                        this.cat.setHeadDown(false);
                    } else {
                        this.cat.lookAtEntity(this.owner, 45.0F, 45.0F);
                        this.cat.setHeadDown(true);
                    }
                } else {
                    this.cat.setSleepingWithOwner(false);
                }
            }

        }
    }

    static class TemptGoal extends net.minecraft.entity.ai.goal.TemptGoal {
        @Nullable
        private PlayerEntity player;
        private final CatBoyMaidEntity cat;

        public TemptGoal(CatBoyMaidEntity cat, double speed, Ingredient food, boolean canBeScared) {
            super(cat, speed, food, canBeScared);
            this.cat = cat;
        }

        public void tick() {
            super.tick();
            if (this.player == null && this.mob.getRandom().nextInt(600) == 0) {
                this.player = this.closestPlayer;
            } else if (this.mob.getRandom().nextInt(500) == 0) {
                this.player = null;
            }

        }

        public boolean canStart() {
            return super.canStart() && !this.cat.isTamed();
        }
    }

    }
