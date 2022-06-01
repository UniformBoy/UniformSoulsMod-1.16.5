// Made with Blockbench 3.9.3
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

	package com.uniform.uniformsouls.entity.model;

import com.google.common.collect.ImmutableList;
import com.uniform.uniformsouls.entity.passive.GolemSoulMonsterEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.CompositeEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.IronGolemEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.util.math.MathHelper;

public class GolemSoulMonsterEntityModel <T extends GolemSoulMonsterEntity> extends CompositeEntityModel<T> {
private final ModelPart torso;
	public final ModelPart head;
	public final ModelPart right_arm;
	public final ModelPart left_arm;
	public final ModelPart right_leg;
	public final ModelPart left_leg;
public GolemSoulMonsterEntityModel() {
	textureWidth = 128;
	textureHeight = 128;
	torso = new ModelPart(this);
	torso.setPivot(0.0F, -7.0F, 0.0F);
	torso.setTextureOffset(0, 40).addCuboid(-9.0F, -2.0F, -6.0F, 18.0F, 12.0F, 11.0F, 0.0F, false);
	torso.setTextureOffset(0, 70).addCuboid(-4.5F, 10.0F, -3.0F, 9.0F, 5.0F, 6.0F, 0.5F, false);
	torso.setTextureOffset(48, 41).addCuboid(-3.0F, 2.375F, -6.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
	torso.setTextureOffset(48, 41).addCuboid(1.0F, 2.375F, -6.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
	torso.setTextureOffset(48, 41).addCuboid(1.0F, 4.375F, -6.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
	torso.setTextureOffset(48, 41).addCuboid(-3.0F, 4.375F, -6.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
	torso.setTextureOffset(48, 41).addCuboid(-1.0F, 0.375F, -6.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
	torso.setTextureOffset(48, 41).addCuboid(-1.0F, 2.375F, -6.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);

	head = new ModelPart(this);
	head.setPivot(0.0F, -7.0F, -2.0F);
	head.setTextureOffset(0, 0).addCuboid(-4.0F, -12.0F, -5.5F, 8.0F, 10.0F, 8.0F, 0.0F, false);
	head.setTextureOffset(24, 0).addCuboid(-1.0F, -5.0F, -7.5F, 2.0F, 4.0F, 2.0F, 0.0F, false);

	right_arm = new ModelPart(this);
	right_arm.setPivot(0.0F, -7.0F, 0.0F);
	right_arm.setTextureOffset(60, 21).addCuboid(-13.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F, 0.0F, false);

	left_arm = new ModelPart(this);
	left_arm.setPivot(0.0F, -7.0F, 0.0F);
	left_arm.setTextureOffset(60, 58).addCuboid(9.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F, 0.0F, false);

	right_leg = new ModelPart(this);
	right_leg.setPivot(4.0F, 11.0F, 0.0F);
	right_leg.setTextureOffset(37, 0).addCuboid(-11.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, 0.0F, false);

	left_leg = new ModelPart(this);
	left_leg.setPivot(-5.0F, 11.0F, 0.0F);
	left_leg.setTextureOffset(60, 0).addCuboid(6.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, 0.0F, false);
}

@Override
public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

		torso.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
}
public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
}
	public Iterable<ModelPart> getParts() {
		return ImmutableList.of(this.head, this.torso, this.right_leg, this.left_leg, this.right_arm, this.left_arm);
	}

	public void setAngles(T ironGolemEntity, float f, float g, float h, float i, float j) {
		this.head.yaw = i * 0.017453292F;
		this.head.pitch = j * 0.017453292F;
		this.right_leg.pitch = -1.5F * MathHelper.method_24504(f, 13.0F) * g;
		this.left_leg.pitch = 1.5F * MathHelper.method_24504(f, 13.0F) * g;
		this.right_leg.yaw = 0.0F;
		this.left_leg.yaw = 0.0F;
	}

	public void animateModel(GolemSoulMonsterEntity ironGolemEntity, float f, float g, float h) {
		int i = ironGolemEntity.getAttackTicksLeft();
		if (i > 0) {
			this.right_arm.pitch = -2.0F + 1.5F * MathHelper.method_24504((float)i - h, 10.0F);
			this.left_arm.pitch = -2.0F + 1.5F * MathHelper.method_24504((float)i - h, 10.0F);
		} else {
			int j = ironGolemEntity.getLookingAtVillagerTicks();
			if (j > 0) {
				this.right_arm.pitch = -0.8F + 0.025F * MathHelper.method_24504((float)j, 70.0F);
				this.left_arm.pitch = 0.0F;
			} else {
				this.right_arm.pitch = (-0.2F + 1.5F * MathHelper.method_24504(f, 13.0F)) * g;
				this.left_arm.pitch = (-0.2F - 1.5F * MathHelper.method_24504(f, 13.0F)) * g;
			}
		}

	}

	public ModelPart getRightArm() {
		return this.right_arm;
	}
}