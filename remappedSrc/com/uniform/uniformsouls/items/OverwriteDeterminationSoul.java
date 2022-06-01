package com.uniform.uniformsouls.items;

import com.uniform.uniformsouls.UniformSouls;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class OverwriteDeterminationSoul extends Item {

    public OverwriteDeterminationSoul(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){
        ItemStack itemStack = playerEntity.getStackInHand(hand);

        // playerEntity.setVelocity(playerEntity.getVelocity().x,playerEntity.getVelocity().y,2);
        // playerEntity.setVelocity(playerEntity.getVelocity().x,2,playerEntity.getVelocity().z);

        playerEntity.playSound(UniformSouls.OVERWRITE_SOUL_SOUND_1_EVENT, 0.5F, 1.0F/(RANDOM.nextFloat()*.4F + .8F));
        playerEntity.playSound(SoundEvents.BLOCK_NOTE_BLOCK_CHIME, 2.0F, 1.0F/(RANDOM.nextFloat()*.4F + .8F));
        playerEntity.getItemCooldownManager().set(this, 10);
        playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));

        return TypedActionResult.success(playerEntity.getStackInHand(hand));

    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext)
    {
        //Basic Info
        tooltip.add(new TranslatableText("§4You §3Are §4Filled §3With §4Determi§3nation").formatted(Formatting.DARK_AQUA));

    }


}
