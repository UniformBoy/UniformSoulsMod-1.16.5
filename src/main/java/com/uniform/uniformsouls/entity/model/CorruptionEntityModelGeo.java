package com.uniform.uniformsouls.entity.model;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.entity.mob.CorruptionEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CorruptionEntityModelGeo extends AnimatedGeoModel<CorruptionEntity> {
    @Override
    public void setLivingAnimations(CorruptionEntity o, Integer integer, AnimationEvent animationEvent) {

    }

    @Override
    public Identifier getModelLocation(CorruptionEntity object) {
        return new Identifier(UniformSouls.MOD_ID, "geo/corruptionentitymodel.geo.json");
    }

    @Override
    public Identifier getTextureLocation(CorruptionEntity object) {
        return new Identifier(UniformSouls.MOD_ID, "textures/entity/corruption/corruption.png");
    }

    @Override
    public Identifier getAnimationFileLocation(CorruptionEntity animatable) {
        return new Identifier(UniformSouls.MOD_ID, "animations/entity/corruption/corruption.animation.json");
    }
}
