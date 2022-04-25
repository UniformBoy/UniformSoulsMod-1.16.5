package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.model.JusticeBulletEntityModel;
import com.uniform.uniformsouls.entity.model.PerseveranceLaserEntityModel;
import com.uniform.uniformsouls.entity.projectile.JusticeBulletEntity;
import com.uniform.uniformsouls.entity.projectile.PatienceStringEntity;
import com.uniform.uniformsouls.entity.projectile.PerseveranceLaserEntity;
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

public class PatienceStringEntityRenderer extends EntityRenderer<PatienceStringEntity> {

    public static final Identifier TEXTURE = new Identifier("uniformsouls", "textures/entity/projectile/patience_string/patience_string.png");
    //Model will be hidden, so I am just  leaving it as this
    public final JusticeBulletEntityModel model = new JusticeBulletEntityModel();

    public PatienceStringEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(PatienceStringEntity patienceStringEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, patienceStringEntity.prevYaw, patienceStringEntity.yaw) - 90.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, patienceStringEntity.prevPitch, patienceStringEntity.pitch) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(patienceStringEntity)), false, patienceStringEntity.hasNoGravity());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(patienceStringEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(PatienceStringEntity patienceStringEntity) {
        return TEXTURE;
    }
}
