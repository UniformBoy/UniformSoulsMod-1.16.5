// Made with Blockbench 4.0.3
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

	package com.uniform.uniformsouls.entity.model;

import com.uniform.uniformsouls.entity.projectile.PerseveranceLaserEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class PerseveranceLaserEntityModel extends EntityModel<PerseveranceLaserEntity> {
private final ModelPart bb_main;
	private final ModelPart voxel_r1;
public PerseveranceLaserEntityModel() {
		textureWidth = 64;
		textureHeight = 64;
		bb_main = new ModelPart(this);
		bb_main.setPivot(0.0F, 24.0F, 0.0F);
		

		voxel_r1 = new ModelPart(this);
		voxel_r1.setPivot(0.0F, 0.0F, 0.0F);
		bb_main.addChild(voxel_r1);
		setRotationAngle(voxel_r1, 1.5708F, 0.0F, 0.0F);
		voxel_r1.setTextureOffset(0, 0).addCuboid(11.0F, -2.0F, -96.0F, 1.0F, 7.0F, 203.0F, 0.0F, false);
		voxel_r1.setTextureOffset(0, 0).addCuboid(-11.0F, -2.0F, -96.0F, 1.0F, 7.0F, 203.0F, 0.0F, false);
		voxel_r1.setTextureOffset(0, 0).addCuboid(10.0F, -4.0F, -96.0F, 1.0F, 11.0F, 203.0F, 0.0F, false);
		voxel_r1.setTextureOffset(0, 0).addCuboid(11.0F, -5.0F, -96.0F, 1.0F, 3.0F, 203.0F, 0.0F, false);
		voxel_r1.setTextureOffset(0, 0).addCuboid(-11.0F, -5.0F, -96.0F, 1.0F, 3.0F, 203.0F, 0.0F, false);
		voxel_r1.setTextureOffset(0, 0).addCuboid(9.0F, -6.0F, -96.0F, 1.0F, 14.0F, 203.0F, 0.0F, false);
		voxel_r1.setTextureOffset(0, 0).addCuboid(-10.0F, -6.0F, -96.0F, 2.0F, 13.0F, 203.0F, 0.0F, false);
		voxel_r1.setTextureOffset(0, 0).addCuboid(-9.0F, -8.0F, -96.0F, 2.0F, 1.0F, 203.0F, 0.0F, false);
		voxel_r1.setTextureOffset(0, 0).addCuboid(-7.0F, -8.0F, -96.0F, 1.0F, 18.0F, 203.0F, 0.0F, false);
		voxel_r1.setTextureOffset(0, 0).addCuboid(9.0F, -8.0F, -96.0F, 1.0F, 2.0F, 203.0F, 0.0F, false);
		voxel_r1.setTextureOffset(0, 0).addCuboid(-10.0F, -7.0F, -96.0F, 2.0F, 1.0F, 203.0F, 0.0F, false);
		voxel_r1.setTextureOffset(0, 0).addCuboid(-8.0F, -7.0F, -96.0F, 1.0F, 16.0F, 203.0F, 0.0F, false);
		voxel_r1.setTextureOffset(0, 0).addCuboid(10.0F, -7.0F, -96.0F, 1.0F, 3.0F, 203.0F, 0.0F, false);
		voxel_r1.setTextureOffset(0, 0).addCuboid(-5.0F, -11.0F, -96.0F, 3.0F, 1.0F, 203.0F, 0.0F, false);
		voxel_r1.setTextureOffset(0, 0).addCuboid(-2.0F, -11.0F, -96.0F, 8.0F, 22.0F, 203.0F, 0.0F, false);
		voxel_r1.setTextureOffset(0, 0).addCuboid(-7.0F, -10.0F, -96.0F, 2.0F, 1.0F, 203.0F, 0.0F, false);
		voxel_r1.setTextureOffset(0, 0).addCuboid(-5.0F, -10.0F, -96.0F, 3.0F, 21.0F, 203.0F, 0.0F, false);
		voxel_r1.setTextureOffset(0, 0).addCuboid(6.0F, -10.0F, -96.0F, 2.0F, 1.0F, 203.0F, 0.0F, false);
		voxel_r1.setTextureOffset(0, 0).addCuboid(-8.0F, -9.0F, -96.0F, 2.0F, 1.0F, 203.0F, 0.0F, false);
		voxel_r1.setTextureOffset(0, 0).addCuboid(-6.0F, -9.0F, -96.0F, 1.0F, 19.0F, 203.0F, 0.0F, false);
		voxel_r1.setTextureOffset(0, 0).addCuboid(6.0F, -9.0F, -96.0F, 3.0F, 18.0F, 203.0F, 0.0F, false);
		voxel_r1.setTextureOffset(0, 0).addCuboid(-3.0F, -12.0F, -96.0F, 7.0F, 1.0F, 203.0F, 0.0F, false);
}
@Override
public void setAngles(PerseveranceLaserEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
}
@Override
public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
}
public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
}

	}