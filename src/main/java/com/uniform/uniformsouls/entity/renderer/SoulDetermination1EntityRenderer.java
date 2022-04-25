package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.model.SoulDetermination1EntityModel;
import com.uniform.uniformsouls.entity.passive.SoulDetermination1Entity;
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

public class SoulDetermination1EntityRenderer extends EntityRenderer<SoulDetermination1Entity> {

    public static final Identifier TEXTURE = new Identifier("uniformsouls", "textures/entity/projectile/soul/soul_determination.png");
    public final SoulDetermination1EntityModel model = new SoulDetermination1EntityModel();

    public SoulDetermination1EntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(SoulDetermination1Entity soulDetermination1Entity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, soulDetermination1Entity.prevYaw, soulDetermination1Entity.yaw) - 90.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, soulDetermination1Entity.prevPitch, soulDetermination1Entity.pitch) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(soulDetermination1Entity)), true, soulDetermination1Entity.hasNoGravity());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(soulDetermination1Entity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(SoulDetermination1Entity soulDetermination1Entity) {
        return TEXTURE;
    }
}
