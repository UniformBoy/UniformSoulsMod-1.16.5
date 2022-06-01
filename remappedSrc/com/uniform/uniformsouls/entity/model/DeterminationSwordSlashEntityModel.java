// Made with Blockbench 4.0.1
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

	package com.uniform.uniformsouls.entity.model;

import com.uniform.uniformsouls.entity.projectile.DeterminationSwordSlashEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class DeterminationSwordSlashEntityModel extends EntityModel<DeterminationSwordSlashEntity> {
private final ModelPart bb_main;
	private final ModelPart cube_r1;
public DeterminationSwordSlashEntityModel() {
	textureWidth = 64;
	textureHeight = 64;
	bb_main = new ModelPart(this);
	bb_main.setPivot(0.0F, 24.0F, 0.0F);


	cube_r1 = new ModelPart(this);
	cube_r1.setPivot(0.0F, 0.0F, 0.0F);
	bb_main.addChild(cube_r1);
	setRotationAngle(cube_r1, 0.0F, 0.0F, 0.0F);
	cube_r1.setTextureOffset(2, 31).addCuboid(28.0F, 4.0F, -0.325F, 2.0F, 10.0F, 1.0F, 0.0F, false);
	cube_r1.setTextureOffset(12, 24).addCuboid(26.0F, 2.0F, -0.325F, 2.0F, 8.0F, 1.0F, 0.0F, false);
	cube_r1.setTextureOffset(12, 24).addCuboid(22.0F, 0.0F, -0.325F, 4.0F, 6.0F, 1.0F, 0.0F, false);
	cube_r1.setTextureOffset(12, 24).addCuboid(16.0F, -2.0F, -0.325F, 6.0F, 8.0F, 1.0F, 0.0F, false);
	cube_r1.setTextureOffset(12, 24).addCuboid(8.0F, -4.0F, -0.325F, 8.0F, 8.0F, 1.0F, 0.0F, false);
	cube_r1.setTextureOffset(12, 24).addCuboid(-8.0F, -6.0F, -0.325F, 16.0F, 10.0F, 1.0F, 0.0F, false);
	cube_r1.setTextureOffset(12, 24).addCuboid(-16.0F, -4.0F, -0.325F, 8.0F, 8.0F, 1.0F, 0.0F, false);
	cube_r1.setTextureOffset(12, 24).addCuboid(-22.0F, -2.0F, -0.325F, 6.0F, 8.0F, 1.0F, 0.0F, false);
	cube_r1.setTextureOffset(12, 24).addCuboid(-24.0F, 0.0F, -0.325F, 2.0F, 6.0F, 1.0F, 0.0F, false);
	cube_r1.setTextureOffset(12, 24).addCuboid(-26.0F, 0.0F, -0.325F, 2.0F, 8.0F, 1.0F, 0.0F, false);
	cube_r1.setTextureOffset(12, 24).addCuboid(-28.0F, 2.0F, -0.325F, 2.0F, 8.0F, 1.0F, 0.0F, false);
	cube_r1.setTextureOffset(31, 21).addCuboid(-30.0F, 4.0F, -0.325F, 2.0F, 10.0F, 1.0F, 0.0F, false);
}

	@Override
	public void setAngles(DeterminationSwordSlashEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

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