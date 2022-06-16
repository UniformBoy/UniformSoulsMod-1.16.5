package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.model.BraveryGloveEntityModel;
import com.uniform.uniformsouls.entity.model.PerseveranceLaserEntityModel;
import com.uniform.uniformsouls.entity.projectile.BraveryGloveEntity;
import com.uniform.uniformsouls.entity.projectile.FireProjEntity;
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

public class FireProjEntityRenderer extends EntityRenderer<FireProjEntity> {

    public static final Identifier TEXTURE = new Identifier("uniformsouls", "textures/entity/projectile/fire_proj/fire_proj.png");
    public final PerseveranceLaserEntityModel model = new PerseveranceLaserEntityModel();

    public FireProjEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(FireProjEntity fireProjEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, fireProjEntity.prevYaw, fireProjEntity.yaw) - 90.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, fireProjEntity.prevPitch, fireProjEntity.pitch) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(fireProjEntity)), false, fireProjEntity.hasNoGravity());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(fireProjEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(FireProjEntity fireProjEntity) {
        return TEXTURE;
    }
}
