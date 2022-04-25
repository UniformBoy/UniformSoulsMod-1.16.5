
package com.uniform.uniformsouls.blocks;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.enchantments.PureEnchantment;
import com.uniform.uniformsouls.entity.mob.CorruptionEntity;
import com.uniform.uniformsouls.entity.mob.HateEntity;
import com.uniform.uniformsouls.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
import net.minecraft.block.SnowyBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;

import java.util.Random;

public abstract class ChaoticCorruption extends SnowyBlock {
    public ChaoticCorruption(Settings settings) {
        super(settings);
    }

    public void onSteppedOn(World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity && !PureEnchantment.hasPure((LivingEntity)entity) && !(entity instanceof CorruptionEntity) && !(entity instanceof HateEntity)) {
            entity.damage(UniformSouls.CORRUPTION_DAMAGE, 1.5F);
        }

        super.onSteppedOn(world, pos, entity);
    }

    private static boolean canSurvive(BlockState state, WorldView worldView, BlockPos pos) {
        BlockPos blockPos = pos.up();
        BlockState blockState = worldView.getBlockState(blockPos);
        if (blockState.isOf(Blocks.SNOW) && (Integer)blockState.get(SnowBlock.LAYERS) == 1) {
            return true;
        } else if (blockState.getFluidState().getLevel() == 8) {
            return false;
        } else {
            int i = ChunkLightProvider.getRealisticOpacity(worldView, state, pos, blockState, blockPos, Direction.UP, blockState.getOpacity(worldView, blockPos));
            return i < worldView.getMaxLightLevel();
        }
    }

    private static boolean canSpread(BlockState state, WorldView worldView, BlockPos pos) {
        BlockPos blockPos = pos.up();
        return canSurvive(state, worldView, pos) && !worldView.getFluidState(blockPos).isIn(FluidTags.LAVA);
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!canSurvive(state, world, pos)) {
            world.setBlockState(pos, ModBlocks.CHAOTIC_CORRUPTION.getDefaultState());
        } else {
            if (world.getLightLevel(pos.up()) <= 15) {
                BlockState blockState = this.getDefaultState();

                for(int i = 0; i < 120; ++i) {
                    BlockPos blockPos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                    if (!world.getBlockState(blockPos).isOf(Blocks.BARRIER)
                            && (!world.getBlockState(blockPos).isOf(Blocks.BEDROCK)
                            && (!world.getBlockState(blockPos).isOf(ModBlocks.MENU_BLOCK_BLACK1)
                            && (!world.getBlockState(blockPos).isOf(ModBlocks.MENU_BLOCK_WHITE1)
                            && (!world.getBlockState(blockPos).isOf(ModBlocks.BARRIER)
                            && (!world.getBlockState(blockPos).isOf(ModBlocks.CORRUPTION)
                            && (!world.getBlockState(blockPos).isOf(ModBlocks.KINDNESS_SHIELD_BLOCK)
                            && (!world.getBlockState(blockPos).isOf(ModBlocks.KINDNESS_SHIELD2_BLOCK)
                            && (!world.getBlockState(blockPos).isOf(ModBlocks.DETERMINATION_SHIELD_BLOCK)
                            && (!world.getBlockState(blockPos).isOf(ModBlocks.UNDERGROUND_PORTAL)
                            && (!world.getBlockState(blockPos).isOf(ModBlocks.NETHERGROUND_PORTAL)
                            && (!world.getBlockState(blockPos).isOf(ModBlocks.PURIFIED_CORRUPTION)
                            && (!world.getBlockState(blockPos).isOf(ModBlocks.CORRUPTION_INACTIVE)
                            && (!world.getBlockState(blockPos).isOf(ModBlocks.CORRUPTION_PORTAL)
                            && canSpread(blockState, world, blockPos))))))))))))))) {
                        world.setBlockState(blockPos, (BlockState)blockState.with(SNOWY, world.getBlockState(blockPos.up()).isOf(Blocks.SNOW)));
                    }
                }
            }

        }
    }
}
