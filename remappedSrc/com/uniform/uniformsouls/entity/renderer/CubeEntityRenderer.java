package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.passive.CubeEntity;
import com.uniform.uniformsouls.entity.model.CubeEntityModel;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/*
 * A renderer is used to provide an entity model, shadow size, and texture.
 */
public class CubeEntityRenderer extends MobEntityRenderer<CubeEntity, CubeEntityModel> {

    public CubeEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new CubeEntityModel(), 0.5F);
    }

    @Override
    public Identifier getTexture(CubeEntity entity) {
        return new Identifier("uniformsouls", "textures/entity/cube/cube.png");
    }
}