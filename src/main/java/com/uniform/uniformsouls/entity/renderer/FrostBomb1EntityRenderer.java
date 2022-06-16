package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.model.BoneProjEntityModel;
import com.uniform.uniformsouls.entity.model.FrostBomb1EntityModel;
import com.uniform.uniformsouls.entity.projectile.BoneProjEntity;
import com.uniform.uniformsouls.entity.projectile.FrostBomb1Entity;
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

public class FrostBomb1EntityRenderer extends EntityRenderer<FrostBomb1Entity> {

    public static final Identifier TEXTURE = new Identifier("uniformsouls", "textures/entity/frost/frost_bomb_1.png");
    public final FrostBomb1EntityModel model = new FrostBomb1EntityModel();

    public FrostBomb1EntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(FrostBomb1Entity frostBomb1Entity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, frostBomb1Entity.prevYaw, frostBomb1Entity.yaw) - 90.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, frostBomb1Entity.prevPitch, frostBomb1Entity.pitch) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(frostBomb1Entity)), false, frostBomb1Entity.hasNoGravity());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(frostBomb1Entity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(FrostBomb1Entity frostBomb1Entity) {
        return TEXTURE;
    }
}
