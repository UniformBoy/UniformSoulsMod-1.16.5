package com.uniform.uniformsouls.mixins;

import com.uniform.uniformsouls.misc.DragonTag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class DragonElytraPlayerEntityMixin extends DragonElytraLivingEntityMixin {

    @Shadow
    public abstract void startFallFlying();

    protected DragonElytraPlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/entity/player/PlayerEntity;getEquippedStack(Lnet/minecraft/entity/EquipmentSlot;)Lnet/minecraft/item/ItemStack;"), method = "checkFallFlying", cancellable = true)
    public void uniformsouls$checkFallFlying(CallbackInfoReturnable<Boolean> info) {
        // Check if player is wearing usable gear to start flying
        ItemStack itemStack = this.getEquippedStack(EquipmentSlot.CHEST);
        if (itemStack.getItem().isIn(DragonTag.DRAGON_ELYTRA)
                && itemStack.getDamage() < itemStack.getMaxDamage() - 10) {
            this.startFallFlying();
            info.setReturnValue(true);
        }
    }
}