package com.uniform.uniformsouls.mixins;

import com.uniform.uniformsouls.misc.TitaniumQuartzTag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class TitaniumQuartzArmorItemEffectMixin extends LivingEntity {

    @Shadow
    public abstract Iterable<ItemStack> getArmorItems();

    protected TitaniumQuartzArmorItemEffectMixin(EntityType<? extends LivingEntity> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("TAIL"), method = "tick")
    private void hasFullTitaniumQuartzArmor(CallbackInfo info) {
        boolean notFull = false;
        for (ItemStack item : getArmorItems()) {
            if (!item.getItem().isIn(TitaniumQuartzTag.TITANIUM_QUARTZ_ITEM) && item.getItem() != Items.ELYTRA) {
                notFull = true;
            }
        }
        if (notFull == false) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 5, 0, false, false, false));
        }
    }

}