package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.model.KindnessShieldEntityModel;
import com.uniform.uniformsouls.entity.projectile.FearShieldProjEntity;
import com.uniform.uniformsouls.entity.projectile.MonsterShieldProjEntity;
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

public class MonsterShieldProjEntityRenderer extends EntityRenderer<MonsterShieldProjEntity> {

    public static final Identifier TEXTURE = new Identifier("uniformsouls", "textures/entity/projectile/monster_shield/monster_shield.png");
    public final KindnessShieldEntityModel model = new KindnessShieldEntityModel();

    public MonsterShieldProjEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(MonsterShieldProjEntity monsterShieldProjEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, monsterShieldProjEntity.prevYaw, monsterShieldProjEntity.yaw) - 90.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, monsterShieldProjEntity.prevPitch, monsterShieldProjEntity.pitch) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(monsterShieldProjEntity)), true, monsterShieldProjEntity.hasNoGravity());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(monsterShieldProjEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(MonsterShieldProjEntity monsterShieldProjEntity) {
        return TEXTURE;
    }
}
