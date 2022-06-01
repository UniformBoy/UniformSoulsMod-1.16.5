package com.uniform.uniformsouls.blocks;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FlowerBed extends Block {
    public FlowerBed(Settings settings) {
        super(settings);
    }

    public void onLandedUpon(World world, BlockPos pos, Entity entity, float distance) {
        entity.handleFallDamage(distance, 0.0F);
    }
}
