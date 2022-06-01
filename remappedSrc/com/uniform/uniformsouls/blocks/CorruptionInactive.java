
package com.uniform.uniformsouls.blocks;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.enchantments.PureEnchantment;
import com.uniform.uniformsouls.entity.mob.CorruptionEntity;
import com.uniform.uniformsouls.entity.mob.HateEntity;
import com.uniform.uniformsouls.registry.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;

import java.util.Random;

public abstract class CorruptionInactive extends Block {
    public CorruptionInactive(Settings settings) {
        super(settings);
    }

    public void onSteppedOn(World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity && !PureEnchantment.hasPure((LivingEntity) entity) && !(entity instanceof CorruptionEntity) && !(entity instanceof HateEntity)) {
            entity.damage(UniformSouls.CORRUPTION_DAMAGE, 1.0F);
        }

        super.onSteppedOn(world, pos, entity);
    }

}