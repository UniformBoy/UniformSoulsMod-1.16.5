package com.uniform.uniformsouls.mixins;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.misc.DefenseMonsterSoulTag;
import com.uniform.uniformsouls.misc.FearSoulTag;
import net.minecraft.entity.AreaEffectCloudEntity;
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

import java.util.Iterator;
import java.util.List;

@Mixin(PlayerEntity.class)
public abstract class DefenseMonsterSoulItemEffectMixin extends LivingEntity {

    @Shadow
    public abstract Iterable<ItemStack> getItemsHand();

    @Shadow @Final public PlayerAbilities abilities;

    protected DefenseMonsterSoulItemEffectMixin(EntityType<? extends LivingEntity> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("TAIL"), method = "tick")
    private void hasFearSoulItem(CallbackInfo info) {
        boolean Full = false;
        for (ItemStack item : getItemsHand()) {
            if (item.getItem().isIn(DefenseMonsterSoulTag.DEFENSE_MONSTER_SOUL_ITEM)) {
                Full = true;
            }
        }
        if (isSneaking() && Full && !this.world.isClient) {
            List<LivingEntity> list = this.world.getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(4.0D, 2.0D, 4.0D));
            AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(this.world, this.getX(), this.getY(), this.getZ());
            if (this instanceof LivingEntity) {
                areaEffectCloudEntity.setOwner((LivingEntity)this);
            }

            areaEffectCloudEntity.setParticleType(UniformSouls.SOUL_MONSTER);
            areaEffectCloudEntity.setRadius(1.2F);
            areaEffectCloudEntity.setDuration(10);
            areaEffectCloudEntity.setRadiusGrowth((0.0F - areaEffectCloudEntity.getRadius()) / (float)areaEffectCloudEntity.getDuration());
            areaEffectCloudEntity.addEffect(new StatusEffectInstance(UniformSouls.KINDNESSEFFECT2, 20, 0));
            if (!list.isEmpty()) {
                Iterator var5 = list.iterator();



                while(var5.hasNext()) {
                    LivingEntity livingEntity = (LivingEntity)var5.next();
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