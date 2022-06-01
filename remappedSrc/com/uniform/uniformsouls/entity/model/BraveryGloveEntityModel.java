// Made with Blockbench 4.0.3
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

	package com.uniform.uniformsouls.entity.model;

import com.uniform.uniformsouls.entity.projectile.BraveryGloveEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class BraveryGloveEntityModel extends EntityModel<BraveryGloveEntity> {
private final ModelPart voxel_file;
	private final ModelPart voxel_file2;
	private final ModelPart group;
	private final ModelPart bb_main;
	private final ModelPart cube_r1;
	private final ModelPart cube_r2;
public BraveryGloveEntityModel() {
		textureWidth = 64;
		textureHeight = 64;
		voxel_file = new ModelPart(this);
		voxel_file.setPivot(0.0F, 24.0F, 0.0F);
		

		voxel_file2 = new ModelPart(this);
		voxel_file2.setPivot(-8.0F, 16.0F, 8.0F);
		

		group = new ModelPart(this);
		group.setPivot(0.0F, 24.0F, 0.0F);
		

		bb_main = new ModelPart(this);
		bb_main.setPivot(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(0, 0).addCuboid(-1.0F, -1.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 0).addCuboid(-1.0F, -5.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r1 = new ModelPart(this);
		cube_r1.setPivot(1.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, 1.5708F, 0.0F, 1.5708F);
		cube_r1.setTextureOffset(0, 0).addCuboid(-4.0F, -2.0F, -2.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 0).addCuboid(-4.0F, 2.0F, -2.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r2 = new ModelPart(this);
		cube_r2.setPivot(1.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 1.5708F);
		cube_r2.setTextureOffset(0, 0).addCuboid(-4.0F, 2.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r2.setTextureOffset(0, 0).addCuboid(-4.0F, -2.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
}
@Override
public void setAngles(BraveryGloveEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
}
@Override
public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		
		voxel_file.render(matrixStack, buffer, packedLight, packedOverlay);
		voxel_file2.render(matrixStack, buffer, packedLight, packedOverlay);
		group.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
}
public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
}

	}