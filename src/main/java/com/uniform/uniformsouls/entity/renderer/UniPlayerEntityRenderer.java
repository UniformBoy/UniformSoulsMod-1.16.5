package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.misc.UniPlayerEntity;
import com.uniform.uniformsouls.entity.model.UniPlayerEntityModelGeo;
import com.uniform.uniformsouls.mixins.UniPlayerEntityRendererMixin;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;

/*
 * A renderer is used to provide an entity model, shadow size, and texture.
 */
    public class UniPlayerEntityRenderer extends GeoEntityRenderer<UniPlayerEntity> {

    public UniPlayerEntityRenderer(EntityRenderDispatcher entityRenderDispatcher, EntityRendererRegistry.Context context) {
        super(entityRenderDispatcher, new UniPlayerEntityModelGeo());
    }


    @Override
    public Identifier getTexture(UniPlayerEntity entity)  {
        return MinecraftClient.getInstance().player.getSkinTexture();
    }
}

