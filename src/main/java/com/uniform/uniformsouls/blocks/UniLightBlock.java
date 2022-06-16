//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.uniform.uniformsouls.blocks;

import java.util.function.ToIntFunction;

import com.uniform.uniformsouls.registry.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class UniLightBlock extends Block implements Waterloggable {
    public static final int field_33722 = 15;
    public static final IntProperty LEVEL_15;
    public static final BooleanProperty WATERLOGGED;
    public static final ToIntFunction<BlockState> STATE_TO_LUMINANCE;

    public UniLightBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(LEVEL_15, 15)).with(WATERLOGGED, false));
    }

    protected void appendProperties(Builder<Block, BlockState> builder) {
        builder.add(new Property[]{LEVEL_15, WATERLOGGED});
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            world.setBlockState(pos, (BlockState)state.cycle(LEVEL_15), 2);
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.CONSUME;
        }
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return context.isHolding(ModItems.UNI_LIGHT_BLOCK) ? VoxelShapes.fullCube() : VoxelShapes.empty();
    }

    public boolean isTranslucent(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.INVISIBLE;
    }

    public float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
        return 1.0F;
    }

    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    static {
        LEVEL_15 = Properties.LEVEL_15;
        WATERLOGGED = Properties.WATERLOGGED;
        STATE_TO_LUMINANCE = (state) -> {
            return (Integer)state.get(LEVEL_15);
        };
    }
}
