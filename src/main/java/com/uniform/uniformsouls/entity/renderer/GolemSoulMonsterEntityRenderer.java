package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.model.GolemSoulMonsterEntityModel;
import com.uniform.uniformsouls.entity.passive.GolemSoulMonsterEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.IronGolemEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3f;

/*
 * A renderer is used to provide an entity model, shadow size, and texture.
 */
public class GolemSoulMonsterEntityRenderer extends MobEntityRenderer<GolemSoulMonsterEntity, GolemSoulMonsterEntityModel<GolemSoulMonsterEntity>> {

    public GolemSoulMonsterEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new GolemSoulMonsterEntityModel(), 0.7F);
    }

    @Override
    public Identifier getTexture(GolemSoulMonsterEntity entity) {
        return new Identifier("uniformsouls", "textures/entity/golem/soul/monster/golem_soul_monster.png");
    }
    public void setupTransforms(GolemSoulMonsterEntity GolemSoulMonsterEntity, MatrixStack matrixStack, float f, float g, float h) {
        super.setupTransforms(GolemSoulMonsterEntity, matrixStack, f, g, h);
        if (!((double)GolemSoulMonsterEntity.limbDistance < 0.01D)) {
            float i = 13.0F;
            float j = GolemSoulMonsterEntity.limbAngle - GolemSoulMonsterEntity.limbDistance * (1.0F - h) + 6.0F;
            float k = (Math.abs(j % 13.0F - 6.5F) - 3.25F) / 3.25F;
            matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(6.5F * k));
        }
    }
}