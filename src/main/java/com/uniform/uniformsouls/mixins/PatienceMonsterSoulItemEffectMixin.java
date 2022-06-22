package com.uniform.uniformsouls.mixins;

import com.uniform.uniformsouls.items.souls.PatienceMonsterSoul;
import com.uniform.uniformsouls.misc.PatienceMonsterSoulTag;
import com.uniform.uniformsouls.misc.PatienceSoulTag;
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
public abstract class PatienceMonsterSoulItemEffectMixin extends LivingEntity {

    @Shadow
    public abstract Iterable<ItemStack> getItemsHand();

    @Shadow @Final public PlayerAbilities abilities;

    protected PatienceMonsterSoulItemEffectMixin(EntityType<? extends LivingEntity> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("TAIL"), method = "tick")
    private void hasPatienceMonsterSoulItem(CallbackInfo info) {
        boolean Full = false;
        for (ItemStack item : getItemsHand()) {
            if (item.getItem().isIn(PatienceMonsterSoulTag.PATIENCE_MONSTER_SOUL_ITEM)) {
                Full = true;
            }
        }
        if ((isSneaking() && Full)) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 5, 0, false, false, false));
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 5, 0, false, false, false));
        }
    }

}