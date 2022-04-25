package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.model.BraveryGloveEntityModel;
import com.uniform.uniformsouls.entity.projectile.BraveryGloveEntity;
import com.uniform.uniformsouls.entity.projectile.DishonorGloveEntity;
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

public class DishonorGloveEntityRenderer extends EntityRenderer<DishonorGloveEntity> {

    public static final Identifier TEXTURE = new Identifier("uniformsouls", "textures/entity/projectile/dishonor_glove/dishonor_glove.png");
    public final BraveryGloveEntityModel model = new BraveryGloveEntityModel();

    public DishonorGloveEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(DishonorGloveEntity dishonorGloveEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, dishonorGloveEntity.prevYaw, dishonorGloveEntity.yaw) - 90.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, dishonorGloveEntity.prevPitch, dishonorGloveEntity.pitch) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(dishonorGloveEntity)), false, dishonorGloveEntity.hasNoGravity());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(dishonorGloveEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(DishonorGloveEntity dishonorGloveEntity) {
        return TEXTURE;
    }
}
