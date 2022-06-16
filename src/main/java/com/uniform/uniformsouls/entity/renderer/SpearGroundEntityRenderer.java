//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.mob.BoneGroundEntity;
import com.uniform.uniformsouls.entity.mob.SpearGroundEntity;
import com.uniform.uniformsouls.entity.model.BoneGroundEntityModel;
import com.uniform.uniformsouls.entity.model.SpearGroundEntityModel;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;

public class SpearGroundEntityRenderer extends EntityRenderer<SpearGroundEntity> {
    public static final Identifier TEXTURE = new Identifier("uniformsouls", "textures/entity/spear/spearground.png");
    private final SpearGroundEntityModel model = new SpearGroundEntityModel();

    public SpearGroundEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher);
    }

    @Override
    public void render(SpearGroundEntity spearGroundEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, spearGroundEntity.prevYaw, spearGroundEntity.yaw)));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, spearGroundEntity.prevPitch, spearGroundEntity.pitch) + 180.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(spearGroundEntity)), true, spearGroundEntity.hasNoGravity());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(spearGroundEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(SpearGroundEntity entity) {
        return TEXTURE;
    }

}
