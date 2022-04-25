package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.model.IntegritySawbladeEntityModel;
import com.uniform.uniformsouls.entity.projectile.DeceitSawbladeEntity;
import com.uniform.uniformsouls.entity.projectile.IntegritySawbladeEntity;
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

public class DeceitSawbladeEntityRenderer extends EntityRenderer<DeceitSawbladeEntity> {

    public static final Identifier TEXTURE = new Identifier("uniformsouls", "textures/entity/projectile/deceit_sawblade/deceit_sawblade.png");
    public final IntegritySawbladeEntityModel model = new IntegritySawbladeEntityModel();

    public DeceitSawbladeEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(DeceitSawbladeEntity deceitSawbladeEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, deceitSawbladeEntity.prevYaw, deceitSawbladeEntity.yaw) - 90.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, deceitSawbladeEntity.prevPitch, deceitSawbladeEntity.pitch) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(deceitSawbladeEntity)), false, deceitSawbladeEntity.hasNoGravity());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(deceitSawbladeEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(DeceitSawbladeEntity deceitSawbladeEntity) {
        return TEXTURE;
    }
}
