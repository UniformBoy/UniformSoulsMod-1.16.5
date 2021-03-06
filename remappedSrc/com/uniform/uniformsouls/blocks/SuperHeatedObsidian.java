
package com.uniform.uniformsouls.blocks;

        import java.util.Random;

        import net.minecraft.block.Block;
        import net.minecraft.block.BlockState;
        import net.minecraft.block.Blocks;
        import net.minecraft.block.BubbleColumnBlock;
        import net.minecraft.enchantment.EnchantmentHelper;
        import net.minecraft.entity.Entity;
        import net.minecraft.entity.LivingEntity;
        import net.minecraft.entity.damage.DamageSource;
        import net.minecraft.entity.player.PlayerEntity;
        import net.minecraft.particle.ParticleTypes;
        import net.minecraft.server.world.ServerWorld;
        import net.minecraft.sound.SoundCategory;
        import net.minecraft.sound.SoundEvents;
        import net.minecraft.tag.FluidTags;
        import net.minecraft.util.math.BlockPos;
        import net.minecraft.util.math.Direction;
        import net.minecraft.world.World;
        import net.minecraft.world.WorldAccess;

public class SuperHeatedObsidian extends Block {
    public SuperHeatedObsidian(Settings settings) {
        super(settings);
    }

    public void onSteppedOn(World world, BlockPos pos, Entity entity) {
        if (!entity.isFireImmune() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entity)) {
            entity.damage(DamageSource.HOT_FLOOR, 1.5F);
        }

        super.onSteppedOn(world, pos, entity);
    }

    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BubbleColumnBlock.update(world, pos.up(), true);
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        if (direction == Direction.UP && newState.isOf(Blocks.WATER)) {
            world.getBlockTickScheduler().schedule(pos, this, 20);
        }

        return super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockPos blockPos = pos.up();
        if (world.getFluidState(pos).isIn(FluidTags.WATER)) {
            world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (world.random.nextFloat() - world.random.nextFloat()) * 0.8F);
            world.spawnParticles(ParticleTypes.LARGE_SMOKE, (double)blockPos.getX() + 0.5D, (double)blockPos.getY() + 0.25D, (double)blockPos.getZ() + 0.5D, 8, 0.5D, 0.25D, 0.5D, 0.0D);
        }

    }

    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        world.getBlockTickScheduler().schedule(pos, this, 20);
    }
}
