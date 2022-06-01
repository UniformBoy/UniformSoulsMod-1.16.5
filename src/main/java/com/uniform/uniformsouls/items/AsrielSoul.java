package com.uniform.uniformsouls.items;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.registry.ModItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class AsrielSoul extends Item {

    public AsrielSoul(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {

        if (!playerEntity.isSneaking()) {

            playerEntity.playSound(UniformSouls.ASRIEL_SOUL_SOUND_1_EVENT, 1.0F, 1.0F);
            playerEntity.getItemCooldownManager().set(this, 60);
            playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));

            return TypedActionResult.success(playerEntity.getStackInHand(hand));
        } else {
            ItemStack itemStack = new ItemStack(ModItems.ASRIEL_CHAOS_SABER);
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
        tooltip.add(new TranslatableText("An §4Intere§6sting §eSoul, §bFilled §1With §5Most §2Traits").formatted());

    }


}
