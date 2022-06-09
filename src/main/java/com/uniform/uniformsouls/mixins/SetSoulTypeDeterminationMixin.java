package com.uniform.uniformsouls.mixins;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.cardinal.SoulMagicIntComponent;
import com.uniform.uniformsouls.misc.DeterminationSoulTag;
import com.uniform.uniformsouls.misc.KindnessSoulTag;
import com.uniform.uniformsouls.registry.SoulType;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.TrackedData;
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

import java.util.Iterator;
import java.util.List;

@Mixin(PlayerEntity.class)
public abstract class SetSoulTypeDeterminationMixin extends LivingEntity {

    @Shadow
    public abstract Iterable<ItemStack> getItemsHand();

    @Shadow @Final public PlayerAbilities abilities;

    @Shadow @Final private static TrackedData<Float> ABSORPTION_AMOUNT;
    private SoulType soulType;
    private SoulMagicIntComponent soulMagicIntComponent;

    protected SetSoulTypeDeterminationMixin(EntityType<? extends LivingEntity> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("TAIL"), method = "tick")
    private void hasDeterminationSoulItem(CallbackInfo info) {
        boolean Full = false;
        for (ItemStack item : getItemsHand()) {
            if (item.getItem().isIn(DeterminationSoulTag.DETERMINATION_SOUL_ITEM)) {
                Full = true;
            }
        }

        if (Full) {

        }
    }

}