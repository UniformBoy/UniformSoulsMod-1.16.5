package com.uniform.uniformsouls.entity.projectile;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.entity.damage.UniDamageSource;
import com.uniform.uniformsouls.entity.misc.LightningRedEntity;
import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ExplosiveProjectileEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionBehavior;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class DeterminationSwordSlashEntity extends ThrownEntity {

    public static final Identifier SPAWN_PACKET = new Identifier(UniformSouls.MOD_ID, "determination_sword_slash");
    private Object PlayerEntity;

    public DeterminationSwordSlashEntity(EntityType<? extends DeterminationSwordSlashEntity> entityType, World world) {
        super(entityType, world);
    }

    public DeterminationSwordSlashEntity(EntityType<? extends DeterminationSwordSlashEntity> type, double x, double y, double z, World world) {
        this(type, world);
        this.setPosition(x, y, z);
    }

    @Environment(EnvType.CLIENT)
    public DeterminationSwordSlashEntity(World world, double x, double y, double z, int id, UUID uuid) {
        super(UniformSouls.DETERMINATION_SWORD_SLASH_ENTITY, world);
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
        if (this.world.isClient) {
            this.world.addParticle(UniformSouls.FLASH_RED, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
        }
 this.setNoGravity(true);

        world.playSound(null, getX(), getY(), getZ(), UniformSouls.WOOSH_NORMAL_OUT_1_EVENT, SoundCategory.PLAYERS, 0.5F, 1.0F);

        if (this.age >= 200F) {
            this.setNoGravity(false);
        }

    }

    public boolean isOnFire() {
        return false;
    }

    public void onEntityHit(EntityHitResult entityHitResult) {
        if (!this.world.isClient) {
            Entity entity = entityHitResult.getEntity();
            Entity entity2 = this.getOwner();
            boolean bl2;
            if (entity2 instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity)entity2;
                bl2 = entity.damage(UniformSouls.DETERMINATION_SWORD_SLASH_DAMAGE, 5.0F);
                if (bl2) {
                    if (entity.isAlive()) {
                        this.dealDamage(livingEntity, entity);
                    }
                }
            } else {
                bl2 = entity.damage(UniformSouls.DETERMINATION_SWORD_SLASH_DAMAGE, 5.0F);
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
    public void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        Entity entity = this.getOwner();
        if (hitResult.getType() != HitResult.Type.ENTITY || !((EntityHitResult)hitResult).getEntity().isPartOf(entity)) {
            if (!this.world.isClient) {
                world.createExplosion(this, getX(), getY(), getZ(), 5, Explosion.DestructionType.NONE);
                List<LivingEntity> list = this.world.getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(4.0D, 2.0D, 4.0D));
                AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(this.world, this.getX(), this.getY(), this.getZ());
                if (entity instanceof LivingEntity) {
                    areaEffectCloudEntity.setOwner((LivingEntity)entity);
                }

                areaEffectCloudEntity.setParticleType(UniformSouls.SOUL_DETERMINATION);
                areaEffectCloudEntity.setRadius(1.0F);
                areaEffectCloudEntity.setDuration(25);
                areaEffectCloudEntity.setRadiusGrowth((3.0F - areaEffectCloudEntity.getRadius()) / (float)areaEffectCloudEntity.getDuration());
                areaEffectCloudEntity.addEffect(new StatusEffectInstance(UniformSouls.DETDAMAGE1, 20, 0));
                if (!list.isEmpty()) {
                    Iterator var5 = list.iterator();



                    while(var5.hasNext()) {
                        LivingEntity livingEntity = (LivingEntity)var5.next();
                        double d = this.squaredDistanceTo(livingEntity);
                        if (d < 16.0D) {
                            areaEffectCloudEntity.setPosition(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ());
                            break;
                        }
                    }
                }

                this.world.spawnEntity(areaEffectCloudEntity);
                world.addParticle(UniformSouls.FLASH_RED, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
                this.remove();
            }

        }
    }
}

