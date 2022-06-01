package com.uniform.uniformsouls.mixins;

import com.uniform.uniformsouls.entity.projectile.DefaultSoulProjectile;
import com.uniform.uniformsouls.entity.projectile.DespairSwordSlashEntity;
import com.uniform.uniformsouls.entity.projectile.DeterminationSwordSlashEntity;
import com.uniform.uniformsouls.misc.DragonTag;
import com.uniform.uniformsouls.misc.TitaniumQuartzTag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ThrownEntity.class)

public abstract class ProjectileDrag{

    @ModifyConstant(method = "tick", constant = @Constant(floatValue = 0.99f))
    private float injected(float value) {
        if(this instanceof DefaultSoulProjectile && ((ThrownEntity)(Object)this).hasNoGravity()){
            return 1F;
        }
        if(this instanceof DefaultSoulProjectile && !((ThrownEntity)(Object)this).hasNoGravity()){
            return 1.01F;
        }
        return value;
    }

}
