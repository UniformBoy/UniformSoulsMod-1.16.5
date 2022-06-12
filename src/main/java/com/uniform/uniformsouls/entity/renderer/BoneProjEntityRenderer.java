package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.model.BoneGroundEntityModel;
import com.uniform.uniformsouls.entity.model.BoneProjEntityModel;
import com.uniform.uniformsouls.entity.model.BraveryGloveEntityModel;
import com.uniform.uniformsouls.entity.projectile.BoneProjEntity;
import com.uniform.uniformsouls.entity.projectile.BraveryGloveEntity;
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

public class BoneProjEntityRenderer extends EntityRenderer<BoneProjEntity> {

    public static final Identifier TEXTURE = new Identifier("uniformsouls", "textures/entity/bone/boneground.png");
    public final BoneProjEntityModel model = new BoneProjEntityModel();

    public BoneProjEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(BoneProjEntity boneProjEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, boneProjEntity.prevYaw, boneProjEntity.yaw) - 90.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, boneProjEntity.prevPitch, boneProjEntity.pitch) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(boneProjEntity)), false, boneProjEntity.hasNoGravity());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(boneProjEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(BoneProjEntity boneProjEntity) {
        return TEXTURE;
    }
}
