package com.uniform.uniformsouls.mixins;

import com.uniform.uniformsouls.misc.DragonTag;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(ClientPlayerEntity.class)
public abstract class DragonElytraClientPlayerEntityMixin extends DragonElytraPlayerEntityMixin {

    protected DragonElytraClientPlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow
    @Final
    public ClientPlayNetworkHandler networkHandler;

    @Inject(at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/client/network/ClientPlayerEntity;getEquippedStack(Lnet/minecraft/entity/EquipmentSlot;)Lnet/minecraft/item/ItemStack;"), method = "tickMovement")
    public void tickMovement(CallbackInfo info) {
        ItemStack itemStack = this.getEquippedStack(EquipmentSlot.CHEST);
        if (itemStack.getItem().isIn(DragonTag.DRAGON_ELYTRA)) {
            // Send packet that player is fall flying when he got enderite elytra and should
            // be fall flying
            this.networkHandler.sendPacket(new ClientCommandC2SPacket((ClientPlayerEntity) ((Object) this),
                    ClientCommandC2SPacket.Mode.START_FALL_FLYING));
        }
    }
}