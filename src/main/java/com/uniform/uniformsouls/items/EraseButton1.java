package com.uniform.uniformsouls.items;

import com.uniform.uniformsouls.UniformSouls;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class EraseButton1 extends Item {

    public EraseButton1(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){

        // playerEntity.setVelocity(playerEntity.getVelocity().x,playerEntity.getVelocity().y,2);
        // playerEntity.setVelocity(playerEntity.getVelocity().x,2,playerEntity.getVelocity().z);

        playerEntity.playSound(UniformSouls.UNDERTALE_INTRO_SOUND_1_EVENT, 2.0F, 0.8F);
        playerEntity.playSound(UniformSouls.SOUL_GENERIC_SHATTER_1_EVENT, 1.0F, 0.8F);
        playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));

        playerEntity.getItemCooldownManager().set(this, 10);

        return TypedActionResult.success(playerEntity.getStackInHand(hand));

    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext)
    {
        //Basic Info
        tooltip.add(new TranslatableText("Let Us Erase This Pointless World").formatted(Formatting.DARK_RED));

    }


}
