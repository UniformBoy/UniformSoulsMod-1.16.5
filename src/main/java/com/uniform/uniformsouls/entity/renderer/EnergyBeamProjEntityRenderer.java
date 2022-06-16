package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.model.PerseveranceLaserEntityModel;
import com.uniform.uniformsouls.entity.projectile.EnergyBeamProjEntity;
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

public class EnergyBeamProjEntityRenderer extends EntityRenderer<EnergyBeamProjEntity> {

    public static final Identifier TEXTURE = new Identifier("uniformsouls", "textures/entity/projectile/energy_beam_proj/energy_beam_proj.png");
    public final PerseveranceLaserEntityModel model = new PerseveranceLaserEntityModel();

    public EnergyBeamProjEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(EnergyBeamProjEntity energyBeamProjEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, energyBeamProjEntity.prevYaw, energyBeamProjEntity.yaw) - 90.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, energyBeamProjEntity.prevPitch, energyBeamProjEntity.pitch) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(energyBeamProjEntity)), false, energyBeamProjEntity.hasNoGravity());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(energyBeamProjEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(EnergyBeamProjEntity energyBeamProjEntity) {
        return TEXTURE;
    }
}
