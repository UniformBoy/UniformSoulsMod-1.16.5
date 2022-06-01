// Made with Blockbench 4.0.3
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

	package com.uniform.uniformsouls.entity.model;

import com.uniform.uniformsouls.entity.projectile.IntegritySawbladeEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class IntegritySawbladeEntityModel extends EntityModel<IntegritySawbladeEntity> {
private final ModelPart Integrity_Sawblade;
public IntegritySawbladeEntityModel() {
		textureWidth = 16;
		textureHeight = 16;
		Integrity_Sawblade = new ModelPart(this);
		Integrity_Sawblade.setPivot(-7.5F, 17.0F, 0.0F);
		setRotationAngle(Integrity_Sawblade, -1.5708F, -1.5708F, 0.0F);
		Integrity_Sawblade.setTextureOffset(0, 0).addCuboid(-3.0F, 7.0F, -7.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		Integrity_Sawblade.setTextureOffset(0, 0).addCuboid(3.0F, 7.0F, -6.0F, 2.0F, 1.0F, 12.0F, 0.0F, false);
		Integrity_Sawblade.setTextureOffset(0, 0).addCuboid(-5.0F, 7.0F, -6.0F, 2.0F, 1.0F, 12.0F, 0.0F, false);
		Integrity_Sawblade.setTextureOffset(0, 0).addCuboid(5.0F, 7.0F, -5.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
		Integrity_Sawblade.setTextureOffset(0, 0).addCuboid(-6.0F, 7.0F, -5.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
		Integrity_Sawblade.setTextureOffset(0, 0).addCuboid(6.0F, 7.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		Integrity_Sawblade.setTextureOffset(0, 0).addCuboid(-7.0F, 7.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		Integrity_Sawblade.setTextureOffset(0, 0).addCuboid(1.0F, 7.0F, -1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
		Integrity_Sawblade.setTextureOffset(0, 0).addCuboid(-3.0F, 7.0F, -1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
		Integrity_Sawblade.setTextureOffset(0, 0).addCuboid(-1.0F, 7.0F, 1.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
}
@Override
public void setAngles(IntegritySawbladeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
}
@Override
public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		
		Integrity_Sawblade.render(matrixStack, buffer, packedLight, packedOverlay);
}
public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
}

	}