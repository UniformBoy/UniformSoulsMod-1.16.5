package com.uniform.uniformsouls.items;

import com.uniform.uniformsouls.UniformSouls;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class RainbowQuartz extends Item {

    public RainbowQuartz(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){
        ItemStack itemStack = playerEntity.getStackInHand(hand);

        // playerEntity.setVelocity(playerEntity.getVelocity().x,playerEntity.getVelocity().y,2);
        // playerEntity.setVelocity(playerEntity.getVelocity().x,2,playerEntity.getVelocity().z);

        playerEntity.playSound(UniformSouls.TITANIUM_QUARTZ_ARMOR_EQUIP_1_EVENT, 2.0F, 1.5F/(RANDOM.nextFloat()*.4F + .8F));
        playerEntity.getItemCooldownManager().set(this, 45);

        return TypedActionResult.success(playerEntity.getStackInHand(hand));

    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext)
    {
        //Basic Info
        tooltip.add(new TranslatableText("A Quartz Infused With Various Ores").formatted(Formatting.WHITE));

    }


}
