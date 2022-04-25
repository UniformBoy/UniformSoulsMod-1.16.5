// Made with Blockbench 4.0.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

	package com.uniform.uniformsouls.entity.model;

import com.uniform.uniformsouls.entity.passive.GolemSoulMonsterEntity;
import com.uniform.uniformsouls.entity.passive.SoulDetermination1Entity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class SoulDetermination1EntityModel extends EntityModel<SoulDetermination1Entity> {
private final ModelPart bb_main;
	private final ModelPart cube_r1;
public SoulDetermination1EntityModel() {
		textureWidth = 16;
		textureHeight = 16;
		bb_main = new ModelPart(this);
		bb_main.setPivot(0.0F, 24.0F, 0.0F);
		

		cube_r1 = new ModelPart(this);
		cube_r1.setPivot(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, 1.5708F, -1.5708F, 0.0F);
		cube_r1.setTextureOffset(0, 5).addCuboid(2.0F, -24.0F, 22.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 5).addCuboid(-5.0F, -24.0F, 22.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 5).addCuboid(1.0F, -23.0F, 22.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 5).addCuboid(-6.0F, -23.0F, 22.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 5).addCuboid(-6.0F, -22.0F, 22.0F, 12.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 5).addCuboid(-6.0F, -19.0F, 22.0F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 5).addCuboid(-5.0F, -18.0F, 22.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 5).addCuboid(-4.0F, -17.0F, 22.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 5).addCuboid(-3.0F, -16.0F, 22.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 0).addCuboid(-2.0F, -15.0F, 22.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 0).addCuboid(-1.0F, -14.0F, 22.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
}
@Override
public void setAngles(SoulDetermination1Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
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