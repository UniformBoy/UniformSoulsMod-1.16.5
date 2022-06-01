package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.mob.CorruptionEntity;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.util.Identifier;

/*
 * A renderer is used to provide an entity model, shadow size, and texture.
 */
public class CorruptionEntityRenderer extends BipedEntityRenderer<CorruptionEntity, PlayerEntityModel<CorruptionEntity>> {

    public CorruptionEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new PlayerEntityModel<>(0.0F, true), 0.5F);
    }

    @Override
    public Identifier getTexture(CorruptionEntity entity) {
        return new Identifier("uniformsouls", "textures/entity/corruption/corruption.png");
    }
}
