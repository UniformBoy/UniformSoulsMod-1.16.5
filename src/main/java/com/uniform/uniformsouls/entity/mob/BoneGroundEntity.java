package com.uniform.uniformsouls.entity.mob;

import com.uniform.uniformsouls.UniformSouls;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.EvokerFangsEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class BoneGroundEntity extends PathAwareEntity {

    public int ticksLeft;
    public int lifespan;
    public int duration;
    private LivingEntity owner;
    private UUID ownerUuid;


    public BoneGroundEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        this.duration = 100;
        this.noClip = true;
    }

    public void tick() {
        super.tick();
        List<LivingEntity> list = this.world.getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(0.5D, 0.5D, 0.5D));
        Iterator var15 = list.iterator();
        LivingEntity livingEntity = (LivingEntity)var15.next();
        this.damage(livingEntity);
        duration --;
        if (duration == 0) {
            this.remove();
        }
    }

    public void tickMovement() {
        super.tickMovement();
        this.setVelocity(Vec3d.ZERO);
        if (this.onGround) {
            this.prevBodyYaw = 0.0F;
            this.bodyYaw = 0.0F;
        }

        if (!this.onGround) {
            this.prevBodyYaw = 1.0F;
            this.bodyYaw = 1.0F;
        }

    }

    @Override
    public boolean isPushable() {
        if (!this.onGround) {
            return true;
        } else
        return false;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = 10;
    }

    public SoundEvent getHurtSound(DamageSource source) {
        return null;
    }

    public SoundEvent getDeathSound() {
        return null;
    }


    public EntityGroup getGroup() {
        return EntityGroup.DEFAULT;
    }



    public static DefaultAttributeContainer.Builder createbonegroundAttributes() {
        return PassiveEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 9999)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,10)
                .add(EntityAttributes.GENERIC_ARMOR, 0);
    }

    public void setOwner(@Nullable LivingEntity owner) {
        this.owner = owner;
        this.ownerUuid = owner == null ? null : owner.getUuid();
    }

    @Nullable
    public LivingEntity getOwner() {
        if (this.owner == null && this.ownerUuid != null && this.world instanceof ServerWorld) {
            Entity entity = ((ServerWorld)this.world).getEntity(this.ownerUuid);
            if (entity instanceof LivingEntity) {
                this.owner = (LivingEntity)entity;
            }
        }

        return this.owner;
    }

    private void damage(LivingEntity target) {
        LivingEntity livingEntity = this.getOwner();
        if (target.isAlive() && !target.isInvulnerable() && target != livingEntity) {
            if (livingEntity == null) {
                target.damage(DamageSource.MAGIC, 5.0F);
            } else {
                if (livingEntity.isTeammate(target)) {
                    return;
                }

                target.damage(DamageSource.magic(this, livingEntity), 5.0F);
            }

        }
    }
}
