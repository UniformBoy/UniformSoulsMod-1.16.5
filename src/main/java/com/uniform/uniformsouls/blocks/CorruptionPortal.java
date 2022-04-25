//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.uniform.uniformsouls.blocks;

import com.uniform.uniformsouls.UniformSouls;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;

import java.util.Random;

public class CorruptionPortal extends UniGlassBlock {

    public CorruptionPortal(Settings settings) {
        super(settings);
    }


    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getDimension().isNatural() && world.getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING) && random.nextInt(2000) < world.getDifficulty().getId()) {
            while(world.getBlockState(pos).isOf(this)) {
                pos = pos.down();
            }

            if (world.getBlockState(pos).allowsSpawning(world, pos, UniformSouls.CORRUPTION)) {
                Entity entity = UniformSouls.CORRUPTION.spawn(world, (NbtCompound)null, (Text)null, (PlayerEntity)null, pos.up(), SpawnReason.STRUCTURE, false, false);
                if (entity != null) {
                    entity.resetNetherPortalCooldown();
                }
            }
        }

    }

}
