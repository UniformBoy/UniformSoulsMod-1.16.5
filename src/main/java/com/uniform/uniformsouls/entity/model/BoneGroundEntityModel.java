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
	private final ModelPart base2;
	private final ModelPart base3;
	private final ModelPart base4;
	private final ModelPart base5;
	private final ModelPart base6;
	private final ModelPart base7;
	private final ModelPart base8;
	private final ModelPart base9;
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

	base2 = new ModelPart(this);
	base2.setPivot(5.0F, 12.0F, -16.0F);
	base2.setTextureOffset(0, 0).addCuboid(-9.0F, -13.0F, 1.0F, 8.0F, 22.0F, 8.0F, 0.0F, false);
	base2.setTextureOffset(0, 0).addCuboid(-12.0F, -16.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base2.setTextureOffset(0, 0).addCuboid(-12.0F, 9.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base2.setTextureOffset(0, 0).addCuboid(-1.0F, 9.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base2.setTextureOffset(0, 0).addCuboid(-1.0F, -16.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base2.setTextureOffset(0, 0).addCuboid(-4.0F, -14.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base2.setTextureOffset(0, 0).addCuboid(-9.0F, -14.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base2.setTextureOffset(0, 0).addCuboid(-9.0F, 9.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base2.setTextureOffset(0, 0).addCuboid(-4.0F, 9.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base2.setTextureOffset(0, 0).addCuboid(-3.0F, 10.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base2.setTextureOffset(0, 0).addCuboid(-9.0F, 10.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base2.setTextureOffset(0, 0).addCuboid(-9.0F, -15.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base2.setTextureOffset(0, 0).addCuboid(-3.0F, -15.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base2.setTextureOffset(0, 0).addCuboid(-11.0F, 8.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base2.setTextureOffset(0, 0).addCuboid(0.0F, 8.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base2.setTextureOffset(0, 0).addCuboid(0.0F, -13.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base2.setTextureOffset(0, 0).addCuboid(-11.0F, -13.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base2.setTextureOffset(0, 0).addCuboid(-10.0F, -13.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
	base2.setTextureOffset(0, 0).addCuboid(-1.0F, -13.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
	base2.setTextureOffset(0, 0).addCuboid(-1.0F, 6.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
	base2.setTextureOffset(0, 0).addCuboid(-10.0F, 6.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);

	base3 = new ModelPart(this);
	base3.setPivot(-12.0F, 12.0F, -16.0F);
	base3.setTextureOffset(0, 0).addCuboid(-9.0F, -13.0F, 1.0F, 8.0F, 22.0F, 8.0F, 0.0F, false);
	base3.setTextureOffset(0, 0).addCuboid(-12.0F, -16.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base3.setTextureOffset(0, 0).addCuboid(-12.0F, 9.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base3.setTextureOffset(0, 0).addCuboid(-1.0F, 9.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base3.setTextureOffset(0, 0).addCuboid(-1.0F, -16.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base3.setTextureOffset(0, 0).addCuboid(-4.0F, -14.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base3.setTextureOffset(0, 0).addCuboid(-9.0F, -14.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base3.setTextureOffset(0, 0).addCuboid(-9.0F, 9.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base3.setTextureOffset(0, 0).addCuboid(-4.0F, 9.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base3.setTextureOffset(0, 0).addCuboid(-3.0F, 10.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base3.setTextureOffset(0, 0).addCuboid(-9.0F, 10.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base3.setTextureOffset(0, 0).addCuboid(-9.0F, -15.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base3.setTextureOffset(0, 0).addCuboid(-3.0F, -15.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base3.setTextureOffset(0, 0).addCuboid(-11.0F, 8.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base3.setTextureOffset(0, 0).addCuboid(0.0F, 8.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base3.setTextureOffset(0, 0).addCuboid(0.0F, -13.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base3.setTextureOffset(0, 0).addCuboid(-11.0F, -13.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base3.setTextureOffset(0, 0).addCuboid(-10.0F, -13.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
	base3.setTextureOffset(0, 0).addCuboid(-1.0F, -13.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
	base3.setTextureOffset(0, 0).addCuboid(-1.0F, 6.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
	base3.setTextureOffset(0, 0).addCuboid(-10.0F, 6.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);

	base4 = new ModelPart(this);
	base4.setPivot(-12.0F, 12.0F, -5.0F);
	base4.setTextureOffset(0, 0).addCuboid(-9.0F, -13.0F, 1.0F, 8.0F, 22.0F, 8.0F, 0.0F, false);
	base4.setTextureOffset(0, 0).addCuboid(-12.0F, -16.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base4.setTextureOffset(0, 0).addCuboid(-12.0F, 9.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base4.setTextureOffset(0, 0).addCuboid(-1.0F, 9.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base4.setTextureOffset(0, 0).addCuboid(-1.0F, -16.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base4.setTextureOffset(0, 0).addCuboid(-4.0F, -14.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base4.setTextureOffset(0, 0).addCuboid(-9.0F, -14.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base4.setTextureOffset(0, 0).addCuboid(-9.0F, 9.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base4.setTextureOffset(0, 0).addCuboid(-4.0F, 9.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base4.setTextureOffset(0, 0).addCuboid(-3.0F, 10.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base4.setTextureOffset(0, 0).addCuboid(-9.0F, 10.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base4.setTextureOffset(0, 0).addCuboid(-9.0F, -15.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base4.setTextureOffset(0, 0).addCuboid(-3.0F, -15.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base4.setTextureOffset(0, 0).addCuboid(-11.0F, 8.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base4.setTextureOffset(0, 0).addCuboid(0.0F, 8.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base4.setTextureOffset(0, 0).addCuboid(0.0F, -13.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base4.setTextureOffset(0, 0).addCuboid(-11.0F, -13.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base4.setTextureOffset(0, 0).addCuboid(-10.0F, -13.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
	base4.setTextureOffset(0, 0).addCuboid(-1.0F, -13.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
	base4.setTextureOffset(0, 0).addCuboid(-1.0F, 6.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
	base4.setTextureOffset(0, 0).addCuboid(-10.0F, 6.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);

	base5 = new ModelPart(this);
	base5.setPivot(-12.0F, 12.0F, 6.0F);
	base5.setTextureOffset(0, 0).addCuboid(-9.0F, -13.0F, 1.0F, 8.0F, 22.0F, 8.0F, 0.0F, false);
	base5.setTextureOffset(0, 0).addCuboid(-12.0F, -16.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base5.setTextureOffset(0, 0).addCuboid(-12.0F, 9.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base5.setTextureOffset(0, 0).addCuboid(-1.0F, 9.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base5.setTextureOffset(0, 0).addCuboid(-1.0F, -16.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base5.setTextureOffset(0, 0).addCuboid(-4.0F, -14.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base5.setTextureOffset(0, 0).addCuboid(-9.0F, -14.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base5.setTextureOffset(0, 0).addCuboid(-9.0F, 9.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base5.setTextureOffset(0, 0).addCuboid(-4.0F, 9.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base5.setTextureOffset(0, 0).addCuboid(-3.0F, 10.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base5.setTextureOffset(0, 0).addCuboid(-9.0F, 10.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base5.setTextureOffset(0, 0).addCuboid(-9.0F, -15.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base5.setTextureOffset(0, 0).addCuboid(-3.0F, -15.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base5.setTextureOffset(0, 0).addCuboid(-11.0F, 8.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base5.setTextureOffset(0, 0).addCuboid(0.0F, 8.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base5.setTextureOffset(0, 0).addCuboid(0.0F, -13.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base5.setTextureOffset(0, 0).addCuboid(-11.0F, -13.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base5.setTextureOffset(0, 0).addCuboid(-10.0F, -13.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
	base5.setTextureOffset(0, 0).addCuboid(-1.0F, -13.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
	base5.setTextureOffset(0, 0).addCuboid(-1.0F, 6.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
	base5.setTextureOffset(0, 0).addCuboid(-10.0F, 6.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);

	base6 = new ModelPart(this);
	base6.setPivot(5.0F, 12.0F, 6.0F);
	base6.setTextureOffset(0, 0).addCuboid(-9.0F, -13.0F, 1.0F, 8.0F, 22.0F, 8.0F, 0.0F, false);
	base6.setTextureOffset(0, 0).addCuboid(-12.0F, -16.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base6.setTextureOffset(0, 0).addCuboid(-12.0F, 9.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base6.setTextureOffset(0, 0).addCuboid(-1.0F, 9.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base6.setTextureOffset(0, 0).addCuboid(-1.0F, -16.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base6.setTextureOffset(0, 0).addCuboid(-4.0F, -14.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base6.setTextureOffset(0, 0).addCuboid(-9.0F, -14.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base6.setTextureOffset(0, 0).addCuboid(-9.0F, 9.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base6.setTextureOffset(0, 0).addCuboid(-4.0F, 9.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base6.setTextureOffset(0, 0).addCuboid(-3.0F, 10.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base6.setTextureOffset(0, 0).addCuboid(-9.0F, 10.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base6.setTextureOffset(0, 0).addCuboid(-9.0F, -15.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base6.setTextureOffset(0, 0).addCuboid(-3.0F, -15.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base6.setTextureOffset(0, 0).addCuboid(-11.0F, 8.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base6.setTextureOffset(0, 0).addCuboid(0.0F, 8.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base6.setTextureOffset(0, 0).addCuboid(0.0F, -13.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base6.setTextureOffset(0, 0).addCuboid(-11.0F, -13.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base6.setTextureOffset(0, 0).addCuboid(-10.0F, -13.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
	base6.setTextureOffset(0, 0).addCuboid(-1.0F, -13.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
	base6.setTextureOffset(0, 0).addCuboid(-1.0F, 6.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
	base6.setTextureOffset(0, 0).addCuboid(-10.0F, 6.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);

	base7 = new ModelPart(this);
	base7.setPivot(22.0F, 12.0F, 6.0F);
	base7.setTextureOffset(0, 0).addCuboid(-9.0F, -13.0F, 1.0F, 8.0F, 22.0F, 8.0F, 0.0F, false);
	base7.setTextureOffset(0, 0).addCuboid(-12.0F, -16.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base7.setTextureOffset(0, 0).addCuboid(-12.0F, 9.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base7.setTextureOffset(0, 0).addCuboid(-1.0F, 9.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base7.setTextureOffset(0, 0).addCuboid(-1.0F, -16.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base7.setTextureOffset(0, 0).addCuboid(-4.0F, -14.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base7.setTextureOffset(0, 0).addCuboid(-9.0F, -14.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base7.setTextureOffset(0, 0).addCuboid(-9.0F, 9.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base7.setTextureOffset(0, 0).addCuboid(-4.0F, 9.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base7.setTextureOffset(0, 0).addCuboid(-3.0F, 10.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base7.setTextureOffset(0, 0).addCuboid(-9.0F, 10.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base7.setTextureOffset(0, 0).addCuboid(-9.0F, -15.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base7.setTextureOffset(0, 0).addCuboid(-3.0F, -15.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base7.setTextureOffset(0, 0).addCuboid(-11.0F, 8.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base7.setTextureOffset(0, 0).addCuboid(0.0F, 8.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base7.setTextureOffset(0, 0).addCuboid(0.0F, -13.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base7.setTextureOffset(0, 0).addCuboid(-11.0F, -13.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base7.setTextureOffset(0, 0).addCuboid(-10.0F, -13.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
	base7.setTextureOffset(0, 0).addCuboid(-1.0F, -13.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
	base7.setTextureOffset(0, 0).addCuboid(-1.0F, 6.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
	base7.setTextureOffset(0, 0).addCuboid(-10.0F, 6.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);

	base8 = new ModelPart(this);
	base8.setPivot(22.0F, 12.0F, -6.0F);
	base8.setTextureOffset(0, 0).addCuboid(-9.0F, -13.0F, 1.0F, 8.0F, 22.0F, 8.0F, 0.0F, false);
	base8.setTextureOffset(0, 0).addCuboid(-12.0F, -16.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base8.setTextureOffset(0, 0).addCuboid(-12.0F, 9.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base8.setTextureOffset(0, 0).addCuboid(-1.0F, 9.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base8.setTextureOffset(0, 0).addCuboid(-1.0F, -16.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base8.setTextureOffset(0, 0).addCuboid(-4.0F, -14.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base8.setTextureOffset(0, 0).addCuboid(-9.0F, -14.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base8.setTextureOffset(0, 0).addCuboid(-9.0F, 9.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base8.setTextureOffset(0, 0).addCuboid(-4.0F, 9.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base8.setTextureOffset(0, 0).addCuboid(-3.0F, 10.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base8.setTextureOffset(0, 0).addCuboid(-9.0F, 10.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base8.setTextureOffset(0, 0).addCuboid(-9.0F, -15.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base8.setTextureOffset(0, 0).addCuboid(-3.0F, -15.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base8.setTextureOffset(0, 0).addCuboid(-11.0F, 8.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base8.setTextureOffset(0, 0).addCuboid(0.0F, 8.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base8.setTextureOffset(0, 0).addCuboid(0.0F, -13.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base8.setTextureOffset(0, 0).addCuboid(-11.0F, -13.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base8.setTextureOffset(0, 0).addCuboid(-10.0F, -13.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
	base8.setTextureOffset(0, 0).addCuboid(-1.0F, -13.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
	base8.setTextureOffset(0, 0).addCuboid(-1.0F, 6.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
	base8.setTextureOffset(0, 0).addCuboid(-10.0F, 6.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);

	base9 = new ModelPart(this);
	base9.setPivot(22.0F, 12.0F, -16.0F);
	base9.setTextureOffset(0, 0).addCuboid(-9.0F, -13.0F, 1.0F, 8.0F, 22.0F, 8.0F, 0.0F, false);
	base9.setTextureOffset(0, 0).addCuboid(-12.0F, -16.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base9.setTextureOffset(0, 0).addCuboid(-12.0F, 9.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base9.setTextureOffset(0, 0).addCuboid(-1.0F, 9.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base9.setTextureOffset(0, 0).addCuboid(-1.0F, -16.0F, 1.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);
	base9.setTextureOffset(0, 0).addCuboid(-4.0F, -14.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base9.setTextureOffset(0, 0).addCuboid(-9.0F, -14.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base9.setTextureOffset(0, 0).addCuboid(-9.0F, 9.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base9.setTextureOffset(0, 0).addCuboid(-4.0F, 9.0F, 1.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
	base9.setTextureOffset(0, 0).addCuboid(-3.0F, 10.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base9.setTextureOffset(0, 0).addCuboid(-9.0F, 10.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base9.setTextureOffset(0, 0).addCuboid(-9.0F, -15.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base9.setTextureOffset(0, 0).addCuboid(-3.0F, -15.0F, 1.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
	base9.setTextureOffset(0, 0).addCuboid(-11.0F, 8.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base9.setTextureOffset(0, 0).addCuboid(0.0F, 8.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base9.setTextureOffset(0, 0).addCuboid(0.0F, -13.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base9.setTextureOffset(0, 0).addCuboid(-11.0F, -13.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	base9.setTextureOffset(0, 0).addCuboid(-10.0F, -13.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
	base9.setTextureOffset(0, 0).addCuboid(-1.0F, -13.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
	base9.setTextureOffset(0, 0).addCuboid(-1.0F, 6.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
	base9.setTextureOffset(0, 0).addCuboid(-10.0F, 6.0F, 1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
}
	@Override
	public void setAngles(BoneGroundEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}
	@Override
	public void render(MatrixStack matrixStack, VertexConsumer	buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

		base.render(matrixStack, buffer, packedLight, packedOverlay);
		base2.render(matrixStack, buffer, packedLight, packedOverlay);
		base3.render(matrixStack, buffer, packedLight, packedOverlay);
		base4.render(matrixStack, buffer, packedLight, packedOverlay);
		base5.render(matrixStack, buffer, packedLight, packedOverlay);
		base6.render(matrixStack, buffer, packedLight, packedOverlay);
		base7.render(matrixStack, buffer, packedLight, packedOverlay);
		base8.render(matrixStack, buffer, packedLight, packedOverlay);
		base9.render(matrixStack, buffer, packedLight, packedOverlay);
	}
	public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
	}

}