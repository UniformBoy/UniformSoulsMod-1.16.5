package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.model.KindnessShield2EntityModel;
import com.uniform.uniformsouls.entity.passive.DeterminationShield2Entity;
import com.uniform.uniformsouls.entity.passive.KindnessShield2Entity;
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

public class DeterminationShield2EntityRenderer extends EntityRenderer<DeterminationShield2Entity> {

    public static final Identifier TEXTURE = new Identifier("uniformsouls", "textures/entity/projectile/determination_shield/determination_shield.png");
    public final KindnessShield2EntityModel model = new KindnessShield2EntityModel();

    public DeterminationShield2EntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(DeterminationShield2Entity determinationShield2Entity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, determinationShield2Entity.prevYaw, determinationShield2Entity.yaw) - 90.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, determinationShield2Entity.prevPitch, determinationShield2Entity.pitch) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(determinationShield2Entity)), true, determinationShield2Entity.hasNoGravity());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(determinationShield2Entity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(DeterminationShield2Entity determinationShield2Entity) {
        return TEXTURE;
    }
}
