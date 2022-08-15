package com.uniform.uniformsouls.mixins;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.misc.SoulTag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(ItemEntity.class)
public abstract class SoulDropMixin extends Entity {

    @Shadow
    public abstract ItemStack getStack();

    @Shadow
    public abstract boolean isAttackable();

    @Shadow
    private int itemAge;

    @Shadow
    private int health;

    protected SoulDropMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("TAIL"), method = "tick()V")
    private void dropItem(CallbackInfo info) {
        // If item entity has gravity, turn it off
        if (!hasNoGravity() && !world.isClient && !getStack().isEmpty()
                && getStack().getItem().isIn(SoulTag.SOUL_ITEM)) {
            setNoGravity(true);
            setGlowing(true);
            setInvulnerable(true);
            isInvulnerable();
            isImmuneToExplosion();
            this.health = 9999999;

        }
        // Slow down item y velocity (to stop vertical spread)
        if (getStack().getItem().isIn(SoulTag.SOUL_ITEM)) {
            this.setVelocity(this.getVelocity().multiply(1.0D, 0.96D, 1.0D));
        }

        //Lets item fall
        if (itemAge >= 400F && this.getY() > 10.0D) {
            setNoGravity(false);
        }

        //Prevents item despawn
        if (this.itemAge >= 5000F) {
            --this.itemAge;
        }

        //Prevents Void
        if (this.getY() < 0.0D) {
            if (getStack().getItem().isIn(SoulTag.SOUL_ITEM)) {
                this.removed = false;
                // ItemEntity itemEntity = new ItemEntity(this.world, this.getX(), 10,
                // this.getZ(), getStack());
                this.requestTeleport(this.getX(), 10, this.getZ());
                this.setVelocity(0, 0, 0);
                this.setNoGravity(true);
                this.setGlowing(true);
            }

        }
    }
}
