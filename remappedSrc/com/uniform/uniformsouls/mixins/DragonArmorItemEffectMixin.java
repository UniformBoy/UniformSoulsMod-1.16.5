package com.uniform.uniformsouls.mixins;

import com.uniform.uniformsouls.misc.DragonTag;
import com.uniform.uniformsouls.misc.TitaniumQuartzTag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class DragonArmorItemEffectMixin extends LivingEntity {

    @Shadow
    public abstract Iterable<ItemStack> getArmorItems();

    protected DragonArmorItemEffectMixin(EntityType<? extends LivingEntity> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("TAIL"), method = "tick")
    private void hasFullDragonArmor(CallbackInfo info) {
        boolean notFull = false;
        for (ItemStack item : getArmorItems()) {
            if (!item.getItem().isIn(DragonTag.DRAGON_ITEM)) {
                notFull = true;
            }
        }
        if (notFull == false && (isSneaking())) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 5, 0, false, false, false));
        }
    }

}