package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.model.BoneProjEntityModel;
import com.uniform.uniformsouls.entity.model.SpearProjEntityModel;
import com.uniform.uniformsouls.entity.projectile.BoneProjEntity;
import com.uniform.uniformsouls.entity.projectile.SpearProjEntity;
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

public class SpearProjEntityRenderer extends EntityRenderer<SpearProjEntity> {

    public static final Identifier TEXTURE = new Identifier("uniformsouls", "textures/entity/spear/spearground.png");
    public final SpearProjEntityModel model = new SpearProjEntityModel();

    public SpearProjEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(SpearProjEntity spearProjEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, spearProjEntity.prevYaw, spearProjEntity.yaw) - 90.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, spearProjEntity.prevPitch, spearProjEntity.pitch) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(spearProjEntity)), false, spearProjEntity.hasNoGravity());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(spearProjEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(SpearProjEntity spearProjEntity) {
        return TEXTURE;
    }
}
