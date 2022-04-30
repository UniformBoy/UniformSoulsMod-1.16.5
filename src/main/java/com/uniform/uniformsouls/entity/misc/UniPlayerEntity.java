package com.uniform.uniformsouls.entity.misc;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class UniPlayerEntity extends PathAwareEntity implements IAnimatable {

    private final AnimationFactory factory = new AnimationFactory(this);

    public UniPlayerEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void updatePositionAndAngles(double x, double y, double z, float yaw, float pitch) {
       // ClientPlayerEntity player = MinecraftClient.getInstance().player;
        //this.setYaw(player.getYaw(1));
        this.bodyYaw = this.getYaw(1);
        this.headYaw = this.getYaw(1);
        super.updatePositionAndAngles(x, y, z, this.getYaw(1), this.getPitch(1));
    }

    @Override
    public void updatePosition(double x, double y, double z) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        super.updatePosition(player.getX(), player.getY(), player.getZ());
    }

    @Override
    public void registerControllers(AnimationData animationData) {

    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
