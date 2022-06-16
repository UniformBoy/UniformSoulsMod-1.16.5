package com.uniform.uniformsouls.mixins;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.entity.projectile.BraveryGloveEntity;
import com.uniform.uniformsouls.entity.projectile.KindnessShieldProjEntity;
import com.uniform.uniformsouls.misc.KindnessSoulTag;
import com.uniform.uniformsouls.misc.KindnessWeaponTag;
import com.uniform.uniformsouls.registry.ModItems;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;
import java.util.List;

@Mixin(PlayerEntity.class)
public abstract class KindnessWeaponItemShieldMixin extends LivingEntity {

    @Shadow
    public abstract Iterable<ItemStack> getItemsHand();

    @Shadow @Final public PlayerAbilities abilities;

private PlayerEntity playerEntity;

    protected KindnessWeaponItemShieldMixin(EntityType<? extends LivingEntity> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("TAIL"), method = "tick")
    private void hasKindnessWeaponItem(CallbackInfo info) {
        boolean Full = false;
        for (ItemStack item : getItemsHand()) {
            if (item.getItem().isIn(KindnessWeaponTag.KINDNESS_WEAPON_ITEM)) {
                Full = true;
            }
        }

        if (isSneaking() && handSwinging && handSwingTicks >= 5 && !isOnGround() && Full && !this.world.isClient) {


            this.damage(DamageSource.MAGIC, 2.5F);

            KindnessShieldProjEntity proj = new KindnessShieldProjEntity(UniformSouls.KINDNESS_SHEILD_PROJ_ENTITY, world);
            proj.setPos(this.getX(), this.getY() + 1.8, this.getZ());
            proj.setOwner(this);
            proj.setProperties(this, this.pitch, this.yaw, 0, 2.0F, 0.1F );
            world.spawnEntity(proj);

        }
    }

}