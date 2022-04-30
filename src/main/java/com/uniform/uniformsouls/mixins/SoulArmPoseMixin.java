package com.uniform.uniformsouls.mixins;

import com.uniform.uniformsouls.UniformSouls;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BipedEntityModel.class)
public abstract class SoulArmPoseMixin {

    //@Inject(method = "method_30154", at = @At("HEAD"))
   // private void UniformSouls$method_30154(T livingEntity, CallbackInfo ci) {

   // }
}

