package com.uniform.uniformsouls.blocks;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.Iterator;
import java.util.List;

public class UniPressurePlateBlock extends AbstractPressurePlateBlock {
    public static final BooleanProperty POWERED;
    private final PressurePlateBlock.ActivationRule type;

    public UniPressurePlateBlock(PressurePlateBlock.ActivationRule type, Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(POWERED, false));
        this.type = type;
    }

    public int getRedstoneOutput(BlockState state) {
        return (Boolean)state.get(POWERED) ? 15 : 0;
    }

    public BlockState setRedstoneOutput(BlockState state, int rsOut) {
        return (BlockState)state.with(POWERED, rsOut > 0);
    }

    public void playPressSound(WorldAccess world, BlockPos pos) {
        if (this.material != Material.WOOD && this.material != Material.NETHER_WOOD) {
            world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_STONE_PRESSURE_PLATE_CLICK_ON, SoundCategory.BLOCKS, 0.3F, 0.6F);
        } else {
            world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON, SoundCategory.BLOCKS, 0.3F, 0.8F);
        }

    }

    public void playDepressSound(WorldAccess world, BlockPos pos) {
        if (this.material != Material.WOOD && this.material != Material.NETHER_WOOD) {
            world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_STONE_PRESSURE_PLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.5F);
        } else {
            world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.7F);
        }

    }

    public int getRedstoneOutput(World world, BlockPos pos) {
        Box box = BOX.offset(pos);
        List list3;
        switch(this.type) {
            case EVERYTHING:
                list3 = world.getOtherEntities((Entity)null, box);
                break;
            case MOBS:
                list3 = world.getNonSpectatingEntities(LivingEntity.class, box);
                break;
            default:
                return 0;
        }

        if (!list3.isEmpty()) {
            Iterator var5 = list3.iterator();

            while(var5.hasNext()) {
                Entity entity = (Entity)var5.next();
                if (!entity.canAvoidTraps()) {
                    return 15;
                }
            }
        }

        return 0;
    }

    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{POWERED});
    }

    static {
        POWERED = Properties.POWERED;
    }

    public static enum ActivationRule {
        EVERYTHING,
        MOBS;

        private ActivationRule() {
        }
    }
}
