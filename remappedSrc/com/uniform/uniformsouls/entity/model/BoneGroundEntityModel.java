// Made with Blockbench 3.9.3
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

	package com.uniform.uniformsouls.entity.model;

import com.uniform.uniformsouls.entity.mob.BoneGroundEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class BoneGroundEntityModel extends EntityModel<BoneGroundEntity> {
private final ModelPart base;
public BoneGroundEntityModel() {
		textureWidth = 64;
		textureHeight = 64;
		base = new ModelPart(this);
		base.setPivot(5.0F, 12.0F, -5.0F);
		base.setTextureOffset(0, 0).addCuboid(-9.0F, -13.0F, 1.0F, 8.0F, 22.0F, 8.0F, 0.0F, false);
		base.setTextureOffset(0, 0).addCuboid(-12.0F, -16.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
		base.setTextureOffset(0, 0).addCuboid(-12.0F, 9.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
		base.setTextureOffset(0, 0).addCuboid(-1.0F, 9.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
		base.setTextureOffset(0, 0).addCuboid(-1.0F, -16.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
		base.setTextureOffset(0, 0).addCuboid(-4.0F, -14.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
		base.setTextureOffset(0, 0).addCuboid(-9.0F, -14.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
		base.setTextureOffset(0, 0).addCuboid(-9.0F, 9.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
		base.setTextureOffset(0, 0).addCuboid(-4.0F, 9.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
		base.setTextureOffset(0, 0).addCuboid(-3.0F, 10.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
		base.setTextureOffset(0, 0).addCuboid(-9.0F, 10.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
		base.setTextureOffset(0, 0).addCuboid(-9.0F, -15.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
		base.setTextureOffset(0, 0).addCuboid(-3.0F, -15.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
		base.setTextureOffset(0, 0).addCuboid(-11.0F, 8.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
		base.setTextureOffset(0, 0).addCuboid(0.0F, 8.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
		base.setTextureOffset(0, 0).addCuboid(0.0F, -13.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
		base.setTextureOffset(0, 0).addCuboid(-11.0F, -13.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
		base.setTextureOffset(0, 0).addCuboid(-10.0F, -13.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
		base.setTextureOffset(0, 0).addCuboid(-1.0F, -13.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
		base.setTextureOffset(0, 0).addCuboid(-1.0F, 6.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
		base.setTextureOffset(0, 0).addCuboid(-10.0F, 6.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
}
@Override
public void setAngles(BoneGroundEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
}
@Override
public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		
		base.render(matrixStack, buffer, packedLight, packedOverlay);
}
public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
}

	}