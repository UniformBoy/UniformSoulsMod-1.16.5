package com.uniform.uniformsouls.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class SnowdinFlowerBlock extends SnowdinPlantBlock {
    public static final VoxelShape SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);
    private final StatusEffect effectInStew;
    private final int effectInStewDuration;

    public SnowdinFlowerBlock(StatusEffect suspiciousStewEffect, int effectDuration, Settings settings) {
        super(settings);
        this.effectInStew = suspiciousStewEffect;
        if (suspiciousStewEffect.isInstant()) {
            this.effectInStewDuration = effectDuration;
        } else {
            this.effectInStewDuration = effectDuration * 20;
        }

    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3d = state.getModelOffset(world, pos);
        return SHAPE.offset(vec3d.x, vec3d.y, vec3d.z);
    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public StatusEffect getEffectInStew() {
        return this.effectInStew;
    }

    public int getEffectInStewDuration() {
        return this.effectInStewDuration;
    }
}
