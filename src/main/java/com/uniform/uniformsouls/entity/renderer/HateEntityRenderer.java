package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.mob.HateEntity;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.model.*;
import net.minecraft.util.Identifier;

/*
 * A renderer is used to provide an entity model, shadow size, and texture.
 */
public class HateEntityRenderer extends BipedEntityRenderer<HateEntity, PlayerEntityModel<HateEntity>> {

    public HateEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new PlayerEntityModel<>(0.0F, true), 0.5F);
    }

    @Override
    public Identifier getTexture(HateEntity entity) {
        return new Identifier("uniformsouls", "textures/entity/hate/hate.png");
    }
}
