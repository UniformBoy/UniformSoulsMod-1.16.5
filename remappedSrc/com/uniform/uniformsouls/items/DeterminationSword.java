package com.uniform.uniformsouls.items;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.entity.projectile.DeterminationSwordSlashEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class DeterminationSword extends SwordItem {

    public DeterminationSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand); // creates a new ItemStack instance of the user's itemStack in-hand
        world.playSound(null, user.getX(), user.getY(), user.getZ(), UniformSouls.DETERMINATION_SWORD_SLASH_1_EVENT, SoundCategory.PLAYERS, 0.75F, 1F); // plays a globalSoundEvent
        user.getItemCooldownManager().set(this, 50);

        /*
		user.getItemCooldownManager().set(this, 5);
		Optionally, you can add a cooldown to your item's right-click use, similar to Ender Pearls.
		*/

        if (!world.isClient) {
            DeterminationSwordSlashEntity proj = new DeterminationSwordSlashEntity(UniformSouls.DETERMINATION_SWORD_SLASH_ENTITY, world);
            proj.setPos(user.getX(), user.getY() + 1.8, user.getZ());
            proj.setOwner(user);
            proj.setProperties(user, user.pitch, user.yaw, 0, 2.0F, 0.1F );
            world.spawnEntity(proj);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
}