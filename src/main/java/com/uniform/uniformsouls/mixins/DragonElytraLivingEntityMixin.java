package com.uniform.uniformsouls.mixins;

import com.uniform.uniformsouls.items.DragonElytra;
import com.uniform.uniformsouls.misc.DragonTag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.function.Consumer;

@Mixin(LivingEntity.class)
public abstract class DragonElytraLivingEntityMixin extends Entity {

    @Shadow
    public abstract ItemStack getEquippedStack(EquipmentSlot slot);

    public DragonElytraLivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @ModifyArg(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;setFlag(IZ)V"), method = "initAi", index = 1)
    private boolean flagSevenFix(boolean value) {
        // Mixin to overwrite check of flag 7
        boolean bl = this.getFlag(7);
        if (bl && !this.isOnGround() && !this.hasVehicle()) {
            ItemStack itemStack = this.getEquippedStack(EquipmentSlot.CHEST);
            if (itemStack.getItem().isIn(DragonTag.DRAGON_ELYTRA) && DragonElytra.isUsable(itemStack)) {
                if (this.random.nextFloat() > 0.96) {
                    itemStack.damage(1, (LivingEntity) (Entity) this, (Consumer<LivingEntity>) ((livingEntity) -> {
                        livingEntity.sendEquipmentBreakStatus(EquipmentSlot.CHEST);
                    }));
                }
            }
            return itemStack.getItem().isIn(DragonTag.DRAGON_ELYTRA) || value;
        }
        return value;
    }
}