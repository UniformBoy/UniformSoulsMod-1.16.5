package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.mob.CorruptionEntity;
import com.uniform.uniformsouls.entity.model.CorruptionEntityModelGeo;
import com.uniform.uniformsouls.entity.model.DeterminationSwordSlashEntityModel;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;

/*
 * A renderer is used to provide an entity model, shadow size, and texture.
 */
    public class CorruptionEntityRenderer extends GeoEntityRenderer<CorruptionEntity> {
        public CorruptionEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
            super(entityRenderDispatcher, new CorruptionEntityModelGeo());
        }

    @Override
    public Identifier getTexture(CorruptionEntity entity) {
        return new Identifier("uniformsouls", "textures/entity/corruption/corruption.png");
    }
}

