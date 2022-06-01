package com.uniform.uniformsouls.mixins;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.misc.DragonTag;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantmentHelper.class)
public abstract class UniEfficiencyMixin {

    @Inject(method = "getEfficiency", at = @At("RETURN"), cancellable = true)
    private static void UniformSouls$getEfficiency(LivingEntity entity, CallbackInfoReturnable cir) {
        cir.setReturnValue(Math.max((Integer) cir.getReturnValue(), EnchantmentHelper.getEquipmentLevel(UniformSouls.EFFICIENCY, entity)));
    }
}

