package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.model.DeterminationSwordSlashEntityModel;
import com.uniform.uniformsouls.entity.projectile.DespairSwordSlashEntity;
import com.uniform.uniformsouls.entity.projectile.DeterminationSwordSlashEntity;
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

public class DespairSwordSlashEntityRenderer extends EntityRenderer<DespairSwordSlashEntity> {

    public static final Identifier TEXTURE = new Identifier("uniformsouls", "textures/entity/projectile/despair_sword_slash/despair_sword_slash_slash.png");
    public final DeterminationSwordSlashEntityModel model = new DeterminationSwordSlashEntityModel();

    public DespairSwordSlashEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(DespairSwordSlashEntity despairSwordSlashEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, despairSwordSlashEntity.prevYaw, despairSwordSlashEntity.yaw) - 90.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, despairSwordSlashEntity.prevPitch, despairSwordSlashEntity.pitch) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(despairSwordSlashEntity)), false, despairSwordSlashEntity.hasNoGravity());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(despairSwordSlashEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(DespairSwordSlashEntity despairSwordSlashEntity) {
        return TEXTURE;
    }
}
