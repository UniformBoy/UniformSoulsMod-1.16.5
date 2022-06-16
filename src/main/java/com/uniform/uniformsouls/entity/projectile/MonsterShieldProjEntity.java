package com.uniform.uniformsouls.entity.projectile;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.entity.passive.KindnessShield2Entity;
import com.uniform.uniformsouls.entity.passive.MonsterShield2Entity;
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

public class MonsterShieldProjEntity extends ThrownEntity implements DefaultSoulProjectile {

    public static final Identifier SPAWN_PACKET = new Identifier(UniformSouls.MOD_ID, "monster_shield_proj");
    private Object PlayerEntity;

    public MonsterShieldProjEntity(EntityType<? extends MonsterShieldProjEntity> entityType, World world) {
        super(entityType, world);
    }

    @Environment(EnvType.CLIENT)
    public MonsterShieldProjEntity(World world, double x, double y, double z, int id, UUID uuid) {
        super(UniformSouls.MONSTER_SHIELD_PROJ_ENTITY, world);
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
            this.world.addParticle(UniformSouls.FLASH_WHITE, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
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
                    MonsterShield2Entity monsterShield2Entity = UniformSouls.MONSTER_SHIELD2_ENTITY.create(this.world);
                    monsterShield2Entity.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.yaw, 0.0F);
                    this.world.spawnEntity(monsterShield2Entity);
                }

                world.addParticle(UniformSouls.FLASH_WHITE, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
                this.remove();
            }
        }
    }

