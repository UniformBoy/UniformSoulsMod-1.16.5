package com.uniform.uniformsouls.mixins;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.misc.SoulTag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class SoulDropMixin extends Entity {

    @Shadow
    public abstract ItemStack getStack();

    @Shadow public abstract boolean isAttackable();

    protected SoulDropMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("TAIL"), method = "tick()V")
    private void dropItem(CallbackInfo info) {
        // If enderite item entity has gravity, turn it off
        if (!hasNoGravity() && !world.isClient && !getStack().isEmpty()
                && getStack().getItem().isIn(SoulTag.SOUL_ITEM)) {
            setNoGravity(true);
            setGlowing(true);
            setInvulnerable(true);
            isImmuneToExplosion();

        }
        // Slow down enderite item y velocity (to stop vertical spread)
        if (getStack().getItem().isIn(SoulTag.SOUL_ITEM)) {
            this.setVelocity(this.getVelocity().multiply(1.0D, 0.96D, 1.0D));
        }
    }
}
