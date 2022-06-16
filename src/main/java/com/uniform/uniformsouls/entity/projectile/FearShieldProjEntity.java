package com.uniform.uniformsouls.entity.projectile;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.entity.passive.DeterminationShield2Entity;
import com.uniform.uniformsouls.entity.passive.FearShield2Entity;
import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.UUID;

public class FearShieldProjEntity extends ThrownEntity implements DefaultSoulProjectile {

    public static final Identifier SPAWN_PACKET = new Identifier(UniformSouls.MOD_ID, "fear_shield_proj");
    private Object PlayerEntity;

    public FearShieldProjEntity(EntityType<? extends FearShieldProjEntity> entityType, World world) {
        super(entityType, world);
    }

    @Environment(EnvType.CLIENT)
    public FearShieldProjEntity(World world, double x, double y, double z, int id, UUID uuid) {
        super(UniformSouls.FEAR_SHEILD_PROJ_ENTITY, world);
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
            this.world.addParticle(UniformSouls.FLASH_PINK, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
        }
        this.setNoGravity(true);

        if (this.age >= 100F) {
            this.setNoGravity(false);
        }

    }

    public boolean isOnFire() {
        return false;
    }

    public void onEntityHit(EntityHitResult entityHitResult) {
    }

        @Override
        public void onCollision(HitResult hitResult) {
            super.onCollision(hitResult);
            Entity entity = this.getOwner();
            if (hitResult.getType() != HitResult.Type.ENTITY || !((EntityHitResult)hitResult).getEntity().isPartOf(entity)) {
                if (!this.world.isClient) {
                    List<LivingEntity> list = this.world.getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(4.0D, 2.0D, 4.0D));
                    world.playSound(null, this.getX(), this.getY(), this.getZ(), UniformSouls.SUMMON_SWORD_OR_SHIELD_1_EVENT, SoundCategory.PLAYERS, .8F, 1F); // plays a globalSoundEvent
                    FearShield2Entity fearShield2Entity = UniformSouls.FEAR_SHIELD2_ENTITY.create(this.world);
                    fearShield2Entity.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.yaw, 0.0F);
                    this.world.spawnEntity(fearShield2Entity);
                }

                world.addParticle(UniformSouls.FLASH_PINK, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
                this.remove();
            }
        }
    }

