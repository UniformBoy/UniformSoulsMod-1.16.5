//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.uniform.uniformsouls.entity.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.uniform.uniformsouls.entity.passive.VexPetEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class VexPetEntityModel extends BipedEntityModel<VexPetEntity> {
    private final ModelPart leftWing;
    private final ModelPart rightWing;

    public VexPetEntityModel() {
        super(0.0F, 0.0F, 64, 64);
        this.leftLeg.visible = false;
        this.hat.visible = false;
        this.rightLeg = new ModelPart(this, 32, 0);
        this.rightLeg.addCuboid(-1.0F, -1.0F, -2.0F, 6.0F, 10.0F, 4.0F, 0.0F);
        this.rightLeg.setPivot(-1.9F, 12.0F, 0.0F);
        this.rightWing = new ModelPart(this, 0, 32);
        this.rightWing.addCuboid(-20.0F, 0.0F, 0.0F, 20.0F, 12.0F, 1.0F);
        this.leftWing = new ModelPart(this, 0, 32);
        this.leftWing.mirror = true;
        this.leftWing.addCuboid(0.0F, 0.0F, 0.0F, 20.0F, 12.0F, 1.0F);
    }

    protected Iterable<ModelPart> getBodyParts() {
        return Iterables.concat(super.getBodyParts(), ImmutableList.of(this.rightWing, this.leftWing));
    }

    public void setAngles(VexPetEntity vexEntity, float f, float g, float h, float i, float j) {
        super.setAngles(vexEntity, f, g, h, i, j);


        ModelPart var10000 = this.rightLeg;
        var10000.pitch += 0.62831855F;
        this.rightWing.pivotZ = 2.0F;
        this.leftWing.pivotZ = 2.0F;
        this.rightWing.pivotY = 1.0F;
        this.leftWing.pivotY = 1.0F;
        this.rightWing.yaw = 0.47123894F + MathHelper.cos(h * 0.8F) * 3.1415927F * 0.05F;
        this.leftWing.yaw = -this.rightWing.yaw;
        this.leftWing.roll = -0.47123894F;
        this.leftWing.pitch = 0.47123894F;
        this.rightWing.pitch = 0.47123894F;
        this.rightWing.roll = 0.47123894F;
    }

    }

