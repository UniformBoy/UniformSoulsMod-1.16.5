package com.uniform.uniformsouls.items.soul_weapons;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.entity.projectile.BraveryGloveEntity;
import com.uniform.uniformsouls.entity.projectile.DeterminationSwordSlashEntity;
import com.uniform.uniformsouls.entity.projectile.SansGasterBlasterLaserEntity;
import com.uniform.uniformsouls.registry.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SansGasterBlaster extends SwordItem {

    public SansGasterBlaster(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!user.isSneaking()) {
            ItemStack itemStack = user.getStackInHand(hand); // creates a new ItemStack instance of the user's itemStack in-hand
            world.playSound(null, user.getX(), user.getY(), user.getZ(), UniformSouls.GASTERBLASTERSOUNDEFFECT_TRIM_EVENT, SoundCategory.PLAYERS, 1.0F, 1.0F); // plays a globalSoundEvent
            user.getItemCooldownManager().set(this, 50);

            if (!world.isClient) {
                SansGasterBlasterLaserEntity proj = new SansGasterBlasterLaserEntity(UniformSouls.SANS_GASTER_BLASTER_LASER_ENTITY, world);
                proj.setPos(user.getX(), user.getY() + 1.8, user.getZ());
                proj.setOwner(user);
                proj.setProperties(user, user.pitch, user.yaw, 0, 2.0F, 0.1F );
                world.spawnEntity(proj);
            }

            return TypedActionResult.success(itemStack, world.isClient());
        } else {
            ItemStack itemStack = new ItemStack(ModItems.SANS_GASTER_BLASTER);
            ItemStack itemStack2 = user.getStackInHand(hand);
            NbtCompound nbtCompound = itemStack2.getTag();
            if (nbtCompound != null) {
                itemStack.setTag(nbtCompound.copy());
            }
            itemStack2.decrement(1);
            user.getItemCooldownManager().set(this, 50);

            user.incrementStat(Stats.USED.getOrCreateStat(this));
            user.playSound(UniformSouls.SUMMON_SWORD_OR_SHIELD_1_EVENT, 0.5F, 1.0F);
            if (itemStack2.isEmpty()) {
                return TypedActionResult.success(itemStack, world.isClient());
            } else {
                if (!user.inventory.insertStack(itemStack.copy())) {
                    user.dropItem(itemStack, false);
                }

                return TypedActionResult.success(itemStack2, world.isClient());
            }
        }
    }
}