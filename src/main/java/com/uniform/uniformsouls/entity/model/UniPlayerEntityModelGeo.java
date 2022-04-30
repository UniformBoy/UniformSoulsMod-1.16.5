package com.uniform.uniformsouls.entity.model;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.entity.misc.UniPlayerEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class UniPlayerEntityModelGeo extends AnimatedGeoModel<UniPlayerEntity> {

    @Override
    public Identifier getModelLocation(UniPlayerEntity object) {
        return new Identifier(UniformSouls.MOD_ID, "geo/uniplayerentitymodel.geo.json");
    }

    @Override
    public Identifier getTextureLocation(UniPlayerEntity object)  {
        return MinecraftClient.getInstance().player.getSkinTexture();
    }


    @Override
    public Identifier getAnimationFileLocation(UniPlayerEntity animatable) {
        return new Identifier(UniformSouls.MOD_ID, "animations/entity/uniplayer/uniplayer.animation.json");
    }
}
