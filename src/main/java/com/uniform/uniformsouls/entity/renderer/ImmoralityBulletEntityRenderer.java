package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.model.JusticeBulletEntityModel;
import com.uniform.uniformsouls.entity.projectile.ImmoralityBulletEntity;
import com.uniform.uniformsouls.entity.projectile.JusticeBulletEntity;
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

public class ImmoralityBulletEntityRenderer extends EntityRenderer<ImmoralityBulletEntity> {

    public static final Identifier TEXTURE = new Identifier("uniformsouls", "textures/entity/projectile/immorality_bullet/immorality_bullet.png");
    public final JusticeBulletEntityModel model = new JusticeBulletEntityModel();

    public ImmoralityBulletEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(ImmoralityBulletEntity immoralityBulletEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, immoralityBulletEntity.prevYaw, immoralityBulletEntity.yaw) - 90.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, immoralityBulletEntity.prevPitch, immoralityBulletEntity.pitch) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(immoralityBulletEntity)), false, immoralityBulletEntity.hasNoGravity());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(immoralityBulletEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(ImmoralityBulletEntity immoralityBulletEntity) {
        return TEXTURE;
    }
}
