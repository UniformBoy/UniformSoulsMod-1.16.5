package com.uniform.uniformsouls.mixins;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.misc.IntegritySoulTag;
import com.uniform.uniformsouls.misc.IntegrityWeaponTag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
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
public abstract class IntegrityWeaponItemEffectMixin extends LivingEntity {

    @Shadow
    public abstract Iterable<ItemStack> getItemsHand();

    @Shadow @Final public PlayerAbilities abilities;

    protected IntegrityWeaponItemEffectMixin(EntityType<? extends LivingEntity> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("TAIL"), method = "tick")
    private void hasIntegritySoulItem(CallbackInfo info) {
        boolean Full = false;
        for (ItemStack item : getItemsHand()) {
            if (item.getItem().isIn(IntegrityWeaponTag.INTEGRITY_WEAPON_ITEM)) {
                Full = true;
            }
        }
        if (Full) {
            this.addStatusEffect(new StatusEffectInstance(UniformSouls.INTEGRITYEFFECT1, 40, 1, false, false, false));
        }
    }

}