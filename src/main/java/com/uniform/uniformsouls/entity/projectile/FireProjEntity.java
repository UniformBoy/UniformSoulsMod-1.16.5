package com.uniform.uniformsouls.entity.projectile;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.entity.mob.BoneGroundEntity;
import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.List;
import java.util.UUID;

public class FireProjEntity extends ThrownEntity implements DefaultSoulProjectile {

    public static final Identifier SPAWN_PACKET = new Identifier(UniformSouls.MOD_ID, "fire_proj");
    private Object PlayerEntity;

    public FireProjEntity(EntityType<? extends FireProjEntity> entityType, World world) {
        super(entityType, world);
    }

    @Environment(EnvType.CLIENT)
    public FireProjEntity(World world, double x, double y, double z, int id, UUID uuid) {
        super(UniformSouls.FIRE_PROJ_ENTITY, world);
        setPosition(x, y, z);
        updateTrackedPosition(x, y, z);
        setEntityId(id);
        setUuid(uuid);
    }

    @Override
    public void initDataTracker() {

    }

    @Override
    public Packet<?> createSpawnPacket() {
        PacketByteBuf packet = new PacketByteBuf(Unpooled.buffer());

        //Entity Position
        packet.writeDouble(getX());
        packet.writeDouble(getY());
        packet.writeDouble(getZ());

        //Entity Id & UUID
        packet.writeInt(getEntityId());
        packet.writeUuid(getUuid());

        return ServerSidePacketRegistry.INSTANCE.toPacket(SPAWN_PACKET, packet);

    }

    public void tick() {
        super.tick();
        this.setNoGravity(true);

        if (this.age >= 100F) {
            this.setNoGravity(false);
        }

    }

    public boolean isOnFire() {
        return true;
    }

    public void onEntityHit(EntityHitResult entityHitResult) {
        if (!this.world.isClient) {
            Entity entity = entityHitResult.getEntity();
            Entity entity2 = this.getOwner();
            if (!entity.isFireImmune()) {
                int i = entity.getFireTicks();
                entity.setOnFireFor(5);
            }
            boolean bl2;
            if (entity2 instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity)entity2;
                bl2 = entity.damage(DamageSource.MAGIC, 2.5F);
                if (bl2) {
                    if (entity.isAlive()) {
                        this.dealDamage(livingEntity, entity);
                    }
                }
            } else {
                bl2 = entity.damage(DamageSource.MAGIC, 2.5F);
            }

            if (bl2 && entity instanceof LivingEntity) {
                int i = 0;
                if (this.world.getDifficulty() == Difficulty.NORMAL) {
                    i = 10;
                } else if (this.world.getDifficulty() == Difficulty.HARD) {
                    i = 40;
                }

            }

        }
    }
@Override
    public void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        if (!this.world.isClient) {
            Entity entity = this.getOwner();
            if (entity == null || !(entity instanceof MobEntity) || this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                BlockPos blockPos = blockHitResult.getBlockPos().offset(blockHitResult.getSide());
                if (this.world.isAir(blockPos)) {
                    this.world.setBlockState(blockPos, AbstractFireBlock.getState(this.world, blockPos));
                }
            }

        }
    }

    @Override
    public void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        Entity entity = this.getOwner();
        if (hitResult.getType() != HitResult.Type.ENTITY || !((EntityHitResult)hitResult).getEntity().isPartOf(entity)) {
            if (!this.world.isClient) {
                List<LivingEntity> list = this.world.getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(4.0D, 2.0D, 4.0D));
                world.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.PLAYERS, 2F, 1F); // plays a globalSoundEvent
            }
            this.remove();
        }
    }
}

