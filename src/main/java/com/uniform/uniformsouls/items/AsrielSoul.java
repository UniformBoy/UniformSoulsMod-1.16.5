package com.uniform.uniformsouls.items;

import com.uniform.uniformsouls.UniformSouls;
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
        ItemStack itemStack = playerEntity.getStackInHand(hand); // creates a new ItemStack instance of the user's itemStack in-hand
        playerEntity.getItemCooldownManager().set(this, 60);
        playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));


        // playerEntity.setVelocity(playerEntity.getVelocity().x,playerEntity.getVelocity().y,2);
        // playerEntity.setVelocity(playerEntity.getVelocity().x,2,playerEntity.getVelocity().z);

        playerEntity.playSound(UniformSouls.ASRIEL_SOUL_SOUND_1_EVENT, 1.0F, 1.0F);

        return TypedActionResult.success(itemStack, world.isClient());

    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext)
    {
        //Basic Info
        tooltip.add(new TranslatableText("An §4Intere§6sting §eSoul, §bFilled §1With §5Most §2Traits").formatted());

    }


}
