package com.uniform.uniformsouls.items.souls;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.registry.ModItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class DishonorSoul extends Item {

    public DishonorSoul(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {

        if (!playerEntity.isSneaking()) {

            playerEntity.playSound(SoundEvents.BLOCK_NOTE_BLOCK_BASEDRUM, 2.0F, 1.0F/(RANDOM.nextFloat()*.4F - .8F));
            playerEntity.getItemCooldownManager().set(this, 60);
            playerEntity.addStatusEffect(new StatusEffectInstance(UniformSouls.BRAVERYEFFECT1, 600, 6, false, false, false));
            playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));

            return TypedActionResult.success(playerEntity.getStackInHand(hand));
        } else {
            ItemStack itemStack = new ItemStack(ModItems.DISHONOR_STURDY_GLOVE);
            ItemStack itemStack2 = playerEntity.getStackInHand(hand);
            itemStack2.decrement(1);
            playerEntity.getItemCooldownManager().set(this, 50);

            playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
            playerEntity.playSound(UniformSouls.SUMMON_SWORD_OR_SHIELD_1_EVENT, 0.5F, 1.0F);
            if (itemStack2.isEmpty()) {
                return TypedActionResult.success(itemStack, world.isClient());
            } else {
                if (!playerEntity.inventory.insertStack(itemStack.copy())) {
                    playerEntity.dropItem(itemStack, false);
                }

                return TypedActionResult.success(itemStack2, world.isClient());
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext)
    {
        //Basic Info
        tooltip.add(new TranslatableText("§6§n§m§o§keee §r§6§n§m§oDishonor §keee"));

    }


}
