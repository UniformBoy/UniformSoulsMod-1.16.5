
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
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;

import java.util.Random;

public abstract class PurifiedCorruption extends SnowyBlock {
    public PurifiedCorruption(Settings settings) {
        super(settings);
    }

    public void onSteppedOn(World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity && !(entity instanceof CorruptionEntity) && !(entity instanceof HateEntity)) {
            ((LivingEntity) entity).heal(0.01F);
        }

        if (entity instanceof CorruptionEntity) {
            entity.damage(UniformSouls.CORRUPTION_DAMAGE, 5.0F);
            ((CorruptionEntity) entity).applyStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS));
            ((CorruptionEntity) entity).applyStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS));
        }

        if (entity instanceof HateEntity) {
            entity.damage(UniformSouls.CORRUPTION_DAMAGE, 5.0F);
            ((HateEntity) entity).applyStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS));
            ((HateEntity) entity).applyStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS));
        }

        super.onSteppedOn(world, pos, entity);
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(5) == 0) {
            Direction direction = Direction.random(random);
            if (direction != Direction.UP) {
                BlockPos blockPos = pos.offset(direction);
                BlockState blockState = world.getBlockState(blockPos);
                if (!state.isOpaque() || !blockState.isSideSolidFullSquare(world, blockPos, direction.getOpposite())) {
                    double d = direction.getOffsetX() == 0 ? random.nextDouble() : 0.5D + (double)direction.getOffsetX() * 0.6D;
                    double e = direction.getOffsetY() == 0 ? random.nextDouble() : 0.5D + (double)direction.getOffsetY() * 0.6D;
                    double f = direction.getOffsetZ() == 0 ? random.nextDouble() : 0.5D + (double)direction.getOffsetZ() * 0.6D;
                    world.addParticle(ParticleTypes.WHITE_ASH, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 0.0D, 0.0D, 0.0D);
                }
            }
        }
    }

    public static boolean cantSurvive(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.up();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.isOf(Blocks.SNOW) && (Integer)blockState.get(SnowBlock.LAYERS) == 1) {
            return true;
        } else if (blockState.getFluidState().getLevel() == 8) {
            return false;
        }
        return true;
    }

    private static boolean canSpread(BlockState state, WorldView worldView, BlockPos pos) {
        BlockPos blockPos = pos.up();
        return cantSurvive(state, worldView, pos) && !worldView.getFluidState(blockPos).isIn(FluidTags.LAVA);
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!cantSurvive(state, world, pos)) {
            world.setBlockState(pos, ModBlocks.PURIFIED_CORRUPTION.getDefaultState());
        } else {
            if (world.getLightLevel(pos.up()) <= 15) {
                BlockState blockState = this.getDefaultState();

                for(int i = 0; i < 500; ++i) {
                    BlockPos blockPos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                    if (world.getBlockState(blockPos).isOf(ModBlocks.CORRUPTION)
                            || (world.getBlockState(blockPos).isOf(ModBlocks.CHAOTIC_CORRUPTION)
                            || (world.getBlockState(blockPos).isOf(ModBlocks.CORRUPTION_INACTIVE)
                            && canSpread(blockState, world, blockPos)))) {
                        world.setBlockState(blockPos, (BlockState)blockState.with(SNOWY, world.getBlockState(blockPos.up()).isOf(Blocks.SNOW)));
                    }
                }
            }

        }
    }
}
