package com.uniform.uniformsouls.mixins;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.misc.AsrielSoulTag;
import com.uniform.uniformsouls.misc.JusticeSoulTag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class AsrielSoulItemEffectMixin extends LivingEntity {

    @Shadow
    public abstract Iterable<ItemStack> getItemsHand();

    @Shadow @Final public PlayerAbilities abilities;

    protected AsrielSoulItemEffectMixin(EntityType<? extends LivingEntity> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("TAIL"), method = "tick")
    private void hasJusticeSoulItem(CallbackInfo info) {
        boolean Full = false;
        for (ItemStack item : getItemsHand()) {
            if (item.getItem().isIn(AsrielSoulTag.ASRIEL_SOUL_ITEM)) {
                Full = true;
            }
        }
        if (Full) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 40, 0, false, false, false));
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 40, 0, false, false, false));
            if (isSneaking()) {
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 5, 0, false, false, false));
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 5, 0, false, false, false));
                this.addStatusEffect(new StatusEffectInstance(UniformSouls.BRAVERYEFFECT1, 600, 2, false, false, false));
                this.addStatusEffect(new StatusEffectInstance(UniformSouls.DETERMINATIONEFFECT1, 600, 2, false, false, false));
                this.addStatusEffect(new StatusEffectInstance(UniformSouls.JUSTICEEFFECT1, 600, 2, false, false, false));
                this.addStatusEffect(new StatusEffectInstance(UniformSouls.INTEGRITYEFFECT1, 600, 2, false, false, false));
                this.addStatusEffect(new StatusEffectInstance(UniformSouls.KINDNESSEFFECT1, 600, 2, false, false, false));
                this.addStatusEffect(new StatusEffectInstance(UniformSouls.PATIENCEEFFECT1, 600, 2, false, false, false));
                this.addStatusEffect(new StatusEffectInstance(UniformSouls.PERSEVERANCEEFFECT1, 600, 2, false, false, false));
            }
        }
    }

}