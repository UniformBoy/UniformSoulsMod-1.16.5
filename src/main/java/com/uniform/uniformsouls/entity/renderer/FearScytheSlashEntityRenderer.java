package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.model.DeterminationSwordSlashEntityModel;
import com.uniform.uniformsouls.entity.projectile.DeterminationSwordSlashEntity;
import com.uniform.uniformsouls.entity.projectile.FearScytheSlashEntity;
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

public class FearScytheSlashEntityRenderer extends EntityRenderer<FearScytheSlashEntity> {

    public static final Identifier TEXTURE = new Identifier("uniformsouls", "textures/entity/projectile/fear_scythe_slash/fear_scythe_slash.png");
    public final DeterminationSwordSlashEntityModel model = new DeterminationSwordSlashEntityModel();

    public FearScytheSlashEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(FearScytheSlashEntity feaEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, feaEntity.prevYaw, feaEntity.yaw) - 90.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, feaEntity.prevPitch, feaEntity.pitch) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(feaEntity)), false, feaEntity.hasNoGravity());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(feaEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(FearScytheSlashEntity feaentity) {
        return TEXTURE;
    }
}
