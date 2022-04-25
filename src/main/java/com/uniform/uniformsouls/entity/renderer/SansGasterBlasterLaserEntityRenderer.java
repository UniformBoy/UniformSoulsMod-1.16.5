package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.model.JusticeBulletEntityModel;
import com.uniform.uniformsouls.entity.projectile.JusticeBulletEntity;
import com.uniform.uniformsouls.entity.projectile.SansGasterBlasterLaserEntity;
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

public class SansGasterBlasterLaserEntityRenderer extends EntityRenderer<SansGasterBlasterLaserEntity> {

    public static final Identifier TEXTURE = new Identifier("uniformsouls", "textures/entity/projectile/sans_gaster_blaster/sans_gaster_blaster_laser.png");
    public final JusticeBulletEntityModel model = new JusticeBulletEntityModel();

    public SansGasterBlasterLaserEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(SansGasterBlasterLaserEntity sansGasterBlasterLaserEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, sansGasterBlasterLaserEntity.prevYaw, sansGasterBlasterLaserEntity.yaw) - 90.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, sansGasterBlasterLaserEntity.prevPitch, sansGasterBlasterLaserEntity.pitch) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(sansGasterBlasterLaserEntity)), false, sansGasterBlasterLaserEntity.hasNoGravity());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(sansGasterBlasterLaserEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(SansGasterBlasterLaserEntity sansGasterBlasterLaserEntity) {
        return TEXTURE;
    }
}
