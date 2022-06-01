package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.model.KindnessShield2EntityModel;
import com.uniform.uniformsouls.entity.passive.KindnessShield2Entity;
import com.uniform.uniformsouls.entity.passive.WrathShield2Entity;
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

public class WrathShield2EntityRenderer extends EntityRenderer<WrathShield2Entity> {

    public static final Identifier TEXTURE = new Identifier("uniformsouls", "textures/entity/projectile/wrath_shield/wrath_shield.png");
    public final KindnessShield2EntityModel model = new KindnessShield2EntityModel();

    public WrathShield2EntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(WrathShield2Entity wrathShield2Entity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, wrathShield2Entity.prevYaw, wrathShield2Entity.yaw) - 90.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, wrathShield2Entity.prevPitch, wrathShield2Entity.pitch) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(wrathShield2Entity)), true, wrathShield2Entity.hasNoGravity());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(wrathShield2Entity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(WrathShield2Entity wrathShield2Entity) {
        return TEXTURE;
    }
}
