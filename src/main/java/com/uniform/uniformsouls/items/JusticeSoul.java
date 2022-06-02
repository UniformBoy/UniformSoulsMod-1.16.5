package com.uniform.uniformsouls.items;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.registry.ModItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
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

public class JusticeSoul extends Item {

    public JusticeSoul(Item.Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {

            if (!playerEntity.world.isClient && !playerEntity.isSneaking()) {

                FireballEntity FireballEntity = (FireballEntity)EntityType.FIREBALL.create(playerEntity.world);
                FireballEntity.refreshPositionAndAngles(playerEntity.getX(), playerEntity.getY() + 1, playerEntity.getZ(), playerEntity.yaw, 0.0F);
                FireballEntity.explosionPower = 1;
                playerEntity.world.spawnEntity(FireballEntity);

                if(FireballEntity.age >= 600)  {
                    FireballEntity.setVelocity(FireballEntity.getVelocity().x,FireballEntity.getVelocity().y - 5,FireballEntity.getVelocity().z);
                }

            return TypedActionResult.success(playerEntity.getStackInHand(hand));
        }

        if (!playerEntity.isSneaking()) {

            playerEntity.playSound(SoundEvents.BLOCK_NOTE_BLOCK_BANJO, 2.0F, 1.0F / (RANDOM.nextFloat() * .4F + .8F));
            playerEntity.getItemCooldownManager().set(this, 0);
            //playerEntity.addStatusEffect(new StatusEffectInstance(UniformSouls.JUSTICEEFFECT1, 600, 4, false, false, false));
            playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));

            return TypedActionResult.success(playerEntity.getStackInHand(hand));
        }

        else {
                ItemStack itemStack = new ItemStack(ModItems.JUSTICE_PISTOL);
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
        tooltip.add(new TranslatableText("You Are Filled With Justice").formatted(Formatting.YELLOW));

    }


}
/* Placing Soul
public class JusticeSoul extends BlockItem {

    public JusticeSoul(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){

        // playerEntity.setVelocity(playerEntity.getVelocity().x,playerEntity.getVelocity().y,2);
        // playerEntity.setVelocity(playerEntity.getVelocity().x,2,playerEntity.getVelocity().z);

        playerEntity.playSound(SoundEvents.BLOCK_NOTE_BLOCK_BANJO, 2.0F, 1.0F/(RANDOM.nextFloat()*.4F + .8F));
        playerEntity.getItemCooldownManager().set(this, 10);
        playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));

        return TypedActionResult.success(playerEntity.getStackInHand(hand));

    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        if (player != null && player.isSneaking()) {
   return super.useOnBlock(context);
}
  return ActionResult.FAIL;
}



    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext)
    {
        //Basic Info
        tooltip.add(new TranslatableText("You Are Filled With Justice").formatted(Formatting.YELLOW));

    }


}


 */