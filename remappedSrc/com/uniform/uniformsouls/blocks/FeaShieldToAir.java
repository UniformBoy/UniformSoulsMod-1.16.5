
package com.uniform.uniformsouls.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public abstract class FeaShieldToAir extends UniGlassBlock {

    public FeaShieldToAir(Settings settings) {
            super(settings);
    }


    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!world.isClient) {
            world.setBlockState(pos, Blocks.AIR.getDefaultState());
        }
    }

    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        worldIn.getBlockTickScheduler().schedule(pos, this, 300);
        super.onBlockAdded(state, worldIn, pos, oldState, isMoving);
    }
}