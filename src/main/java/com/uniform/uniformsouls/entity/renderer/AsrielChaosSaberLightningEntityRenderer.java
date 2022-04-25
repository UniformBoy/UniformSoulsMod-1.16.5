package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.model.JusticeBulletEntityModel;
import com.uniform.uniformsouls.entity.projectile.AsrielChaosSaberLightningEntity;
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

public class AsrielChaosSaberLightningEntityRenderer extends EntityRenderer<AsrielChaosSaberLightningEntity> {

    public static final Identifier TEXTURE = new Identifier("uniformsouls", "textures/entity/projectile/asriel/asriel_chaos_saber_lightning_1.png");
    public final JusticeBulletEntityModel model = new JusticeBulletEntityModel();

    public AsrielChaosSaberLightningEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(AsrielChaosSaberLightningEntity asrielChaosSaberLightningEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, asrielChaosSaberLightningEntity.prevYaw, asrielChaosSaberLightningEntity.yaw) - 90.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, asrielChaosSaberLightningEntity.prevPitch, asrielChaosSaberLightningEntity.pitch) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(asrielChaosSaberLightningEntity)), false, asrielChaosSaberLightningEntity.hasNoGravity());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(asrielChaosSaberLightningEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(AsrielChaosSaberLightningEntity asrielChaosSaberLightningEntity) {
        return TEXTURE;
    }
}
