package com.uniform.uniformsouls.mixins;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.misc.KindnessSoulTag;
import com.uniform.uniformsouls.misc.PatienceSoulTag;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;
import java.util.List;

@Mixin(PlayerEntity.class)
public abstract class KindnessSoulItemEffectMixin extends LivingEntity {

    @Shadow
    public abstract Iterable<ItemStack> getItemsHand();

    @Shadow @Final public PlayerAbilities abilities;

    protected KindnessSoulItemEffectMixin(EntityType<? extends LivingEntity> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("TAIL"), method = "tick")
    private void hasKindnessSoulItem(CallbackInfo info) {
        boolean Full = false;
        for (ItemStack item : getItemsHand()) {
            if (item.getItem().isIn(KindnessSoulTag.KINDNESS_SOUL_ITEM)) {
                Full = true;
            }
        }
        if (Full) {
            this.addStatusEffect(new StatusEffectInstance(UniformSouls.KINDNESSEFFECT1, 40, 1, false, false, false));

            if (isSneaking() && !this.world.isClient) {
                List<LivingEntity> list = this.world.getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(4.0D, 2.0D, 4.0D));
                AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(this.world, this.getX(), this.getY(), this.getZ());
                if (this instanceof LivingEntity) {
                    areaEffectCloudEntity.setOwner((LivingEntity) this);
                }

                areaEffectCloudEntity.setParticleType(UniformSouls.SOUL_KINDNESS);
                areaEffectCloudEntity.setRadius(1.5F);
                areaEffectCloudEntity.setDuration(15);
                areaEffectCloudEntity.setRadiusGrowth((0.0F - areaEffectCloudEntity.getRadius()) / (float) areaEffectCloudEntity.getDuration());
                areaEffectCloudEntity.addEffect(new StatusEffectInstance(UniformSouls.KINDNESSEFFECT2, 20, 0));
                if (!list.isEmpty()) {
                    Iterator var5 = list.iterator();


                    while (var5.hasNext()) {
                        LivingEntity livingEntity = (LivingEntity) var5.next();
                        double d = this.squaredDistanceTo(livingEntity);
                        if (d < 16.0D) {
                            areaEffectCloudEntity.setPosition(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ());
                            break;
                        }
                    }
                }

                this.world.spawnEntity(areaEffectCloudEntity);

                if (areaEffectCloudEntity.getDuration() <= 0) {
                    this.remove();
                }
            }
        }
    }

}