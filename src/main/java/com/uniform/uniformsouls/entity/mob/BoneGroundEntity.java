package com.uniform.uniformsouls.entity.mob;

import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class BoneGroundEntity extends PathAwareEntity {


    public BoneGroundEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    public EntityGroup getGroup() {
        return EntityGroup.DEFAULT;
    }
}

