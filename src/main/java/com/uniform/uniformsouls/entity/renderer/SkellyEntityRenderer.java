package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.mob.SkellyEntity;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.model.SkeletonEntityModel;
import net.minecraft.util.Identifier;

/*
 * A renderer is used to provide an entity model, shadow size, and texture.
 */
public class SkellyEntityRenderer extends BipedEntityRenderer<SkellyEntity, SkeletonEntityModel<SkellyEntity>> {

    public SkellyEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new SkeletonEntityModel<>(), 0.5F);
    }

    @Override
    public Identifier getTexture(SkellyEntity entity) {
        return new Identifier("uniformsouls", "textures/entity/skelly/skelly.png");
    }
}