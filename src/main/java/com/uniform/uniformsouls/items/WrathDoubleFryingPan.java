package com.uniform.uniformsouls.items;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.entity.projectile.JusticeBulletEntity;
import com.uniform.uniformsouls.entity.projectile.KindnessShieldEntity;
import com.uniform.uniformsouls.entity.projectile.WrathShieldEntity;
import com.uniform.uniformsouls.registry.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class WrathDoubleFryingPan extends SwordItem {

    public WrathDoubleFryingPan(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!user.isSneaking()) {
            ItemStack itemStack = user.getStackInHand(hand);
            world.playSound(null, user.getX(), user.getY(), user.getZ(), UniformSouls.SUMMON_SWORD_OR_SHIELD_1_EVENT, SoundCategory.PLAYERS, 1.0F, 0.5F); // plays a globalSoundEvent
            user.getItemCooldownManager().set(this, 150);

            if (!world.isClient) {
                WrathShieldEntity proj = new WrathShieldEntity(UniformSouls.WRATH_SHIELD_ENTITY, world);
                proj.setPos(user.getX(), user.getY() + 1.8, user.getZ());
                proj.setOwner(user);
                proj.setProperties(user, user.pitch, user.yaw, 0, 2.0F, 0.1F );
                world.spawnEntity(proj);
            }

            return TypedActionResult.success(itemStack, world.isClient());

        } else {
            ItemStack itemStack = new ItemStack(ModItems.WRATH_SOUL);
            ItemStack itemStack2 = user.getStackInHand(hand);
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