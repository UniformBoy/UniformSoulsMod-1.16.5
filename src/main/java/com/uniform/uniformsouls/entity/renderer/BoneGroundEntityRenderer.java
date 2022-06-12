//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.mob.BoneGroundEntity;
import com.uniform.uniformsouls.entity.model.BoneGroundEntityModel;
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

public class BoneGroundEntityRenderer extends EntityRenderer<BoneGroundEntity> {
    public static final Identifier TEXTURE = new Identifier("uniformsouls", "textures/entity/bone/boneground.png");
    private final BoneGroundEntityModel model = new BoneGroundEntityModel();

    public BoneGroundEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher);
    }

    @Override
    public void render(BoneGroundEntity boneGroundEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, boneGroundEntity.prevYaw, boneGroundEntity.yaw)));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, boneGroundEntity.prevPitch, boneGroundEntity.pitch)));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(boneGroundEntity)), true, boneGroundEntity.hasNoGravity());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(boneGroundEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(BoneGroundEntity entity) {
        return TEXTURE;
    }

}
