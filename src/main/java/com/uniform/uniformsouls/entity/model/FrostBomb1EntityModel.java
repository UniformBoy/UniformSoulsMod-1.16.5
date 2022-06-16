package com.uniform.uniformsouls.entity.model;

import com.uniform.uniformsouls.entity.projectile.BoneProjEntity;
import com.uniform.uniformsouls.entity.projectile.FrostBomb1Entity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class FrostBomb1EntityModel extends EntityModel<FrostBomb1Entity> {
    private final ModelPart bb_main;
    public FrostBomb1EntityModel() {
        textureWidth = 64;
        textureHeight = 64;
        bb_main = new ModelPart(this);
        bb_main.setPivot(0.0F, 24.0F, 0.0F);
        bb_main.setTextureOffset(0, 31).addCuboid(-9.0F, -17.0F, -8.0F, 17.0F, 17.0F, 16.0F, 0.0F, false);
    }
    @Override
    public void setAngles(FrostBomb1Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }
    @Override
    public void render(MatrixStack matrixStack, VertexConsumer	buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

        bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
    }
    public void setRotationAngle(ModelPart bone, float x, float y, float z) {
        bone.pitch = x;
        bone.yaw = y;
        bone.roll = z;
    }

}