package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.model.KindnessShield2EntityModel;
import com.uniform.uniformsouls.entity.model.KindnessShieldEntityModel;
import com.uniform.uniformsouls.entity.passive.KindnessShield2Entity;
import com.uniform.uniformsouls.entity.projectile.KindnessShieldEntity;
import com.uniform.uniformsouls.entity.projectile.KindnessShieldProjEntity;
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

public class KindnessShieldProjEntityRenderer extends EntityRenderer<KindnessShieldProjEntity> {

    public static final Identifier TEXTURE = new Identifier("uniformsouls", "textures/entity/projectile/kindness_shield/kindness_shield.png");
    public final KindnessShieldEntityModel model = new KindnessShieldEntityModel();

    public KindnessShieldProjEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(KindnessShieldProjEntity kindnessShieldProjEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, kindnessShieldProjEntity.prevYaw, kindnessShieldProjEntity.yaw) - 90.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, kindnessShieldProjEntity.prevPitch, kindnessShieldProjEntity.pitch) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(kindnessShieldProjEntity)), true, kindnessShieldProjEntity.hasNoGravity());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(kindnessShieldProjEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(KindnessShieldProjEntity kindnessShieldProjEntity) {
        return TEXTURE;
    }
}
