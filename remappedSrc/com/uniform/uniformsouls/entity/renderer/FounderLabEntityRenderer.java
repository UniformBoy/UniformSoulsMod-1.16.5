package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.passive.FounderLabEntity;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.util.Identifier;

/*
 * A renderer is used to provide an entity model, shadow size, and texture.
 */
public class FounderLabEntityRenderer extends BipedEntityRenderer<FounderLabEntity, PlayerEntityModel<FounderLabEntity>> {

    public FounderLabEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new PlayerEntityModel<>(0.0F, true), 0.5F);
    }

    @Override
    public Identifier getTexture(FounderLabEntity entity) {
        return new Identifier("uniformsouls", "textures/entity/founderlab/founderlab.png");
    }
}
