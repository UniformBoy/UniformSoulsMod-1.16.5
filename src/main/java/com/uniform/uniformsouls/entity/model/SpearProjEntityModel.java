package com.uniform.uniformsouls.entity.model;

import com.uniform.uniformsouls.entity.projectile.BoneProjEntity;
import com.uniform.uniformsouls.entity.projectile.SpearProjEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class SpearProjEntityModel extends EntityModel<SpearProjEntity> {
    private final ModelPart download;
    private final ModelPart octagon;
    private final ModelPart base;
    public SpearProjEntityModel() {
        textureWidth = 64;
        textureHeight = 64;
        download = new ModelPart(this);
        download.setPivot(0.0F, 8.0F, 7.0F);
        setRotationAngle(download, -1.5708F, 0.0F, 0.0F);


        octagon = new ModelPart(this);
        octagon.setPivot(1.025F, 24.6F, -1.5F);


        base = new ModelPart(this);
        base.setPivot(0.0F, -9.0F, 7.0F);
        setRotationAngle(base, -1.5708F, 0.0F, 0.0F);
        base.setTextureOffset(0, 0).addCuboid(-1.0F, 6.5F, 0.825F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(-0.125F, 6.5F, 1.375F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(0.65F, 6.5F, 3.05F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(-2.325F, 6.5F, 2.975F, 1.0F, 2.0F, 3.0F, 0.0F, false);
        base.setTextureOffset(0, 37).addCuboid(-1.325F, 6.5F, 3.35F, 2.0F, 2.0F, 26.0F, 0.0F, false);
        base.setTextureOffset(0, 37).addCuboid(-1.425F, 6.5F, 28.35F, 3.0F, 2.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 37).addCuboid(-0.875F, 6.5F, 28.35F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        base.setTextureOffset(0, 37).addCuboid(-0.875F, 6.5F, 28.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        base.setTextureOffset(0, 37).addCuboid(-0.3F, 6.5F, 30.4F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 37).addCuboid(-0.3F, 6.5F, 30.85F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 37).addCuboid(-0.525F, 6.5F, 30.85F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 37).addCuboid(-0.525F, 6.5F, 30.275F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 37).addCuboid(0.575F, 6.5F, 4.975F, 1.0F, 2.0F, 24.0F, 0.0F, false);
        base.setTextureOffset(0, 37).addCuboid(1.375F, 6.5F, 6.25F, 1.0F, 2.0F, 5.0F, 0.0F, false);
        base.setTextureOffset(0, 37).addCuboid(2.1F, 6.5F, 8.2F, 1.0F, 2.0F, 4.0F, 0.0F, false);
        base.setTextureOffset(0, 37).addCuboid(-2.3F, 6.5F, 5.325F, 1.0F, 2.0F, 6.0F, 0.0F, false);
        base.setTextureOffset(0, 37).addCuboid(-3.25F, 6.5F, 8.2F, 1.0F, 2.0F, 4.0F, 0.0F, false);
        base.setTextureOffset(0, 37).addCuboid(-3.975F, 6.5F, 8.85F, 1.0F, 2.0F, 3.0F, 0.0F, false);
        base.setTextureOffset(0, 37).addCuboid(-4.15F, 6.5F, 10.9F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        base.setTextureOffset(0, 37).addCuboid(-4.7F, 6.5F, 10.525F, 1.0F, 2.0F, 4.0F, 0.0F, false);
        base.setTextureOffset(0, 37).addCuboid(2.975F, 6.5F, 9.575F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        base.setTextureOffset(8, 44).addCuboid(2.975F, 6.5F, 10.875F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        base.setTextureOffset(0, 37).addCuboid(3.9F, 6.5F, 11.5F, 1.0F, 2.0F, 3.0F, 0.0F, false);
        base.setTextureOffset(0, 37).addCuboid(4.25F, 6.5F, 10.975F, 0.0F, 2.0F, 2.0F, 0.0F, false);
        base.setTextureOffset(0, 37).addCuboid(-0.925F, 6.5F, 1.4F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(-3.225F, 6.5F, 5.2F, 1.0F, 2.0F, 3.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(-3.925F, 6.5F, 7.975F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(-4.675F, 6.5F, 14.325F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(3.925F, 6.5F, 14.325F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(-3.15F, 6.5F, 12.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(2.35F, 6.5F, 12.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(1.525F, 6.5F, 11.275F, 1.0F, 2.0F, 18.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(1.1F, 6.5F, 28.275F, 1.0F, 2.0F, 3.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(0.65F, 6.5F, 30.475F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(-0.875F, 6.5F, 31.775F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(-1.4F, 6.5F, 30.475F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(0.875F, 6.2F, 28.375F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(-1.625F, 6.2F, 28.375F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(-1.85F, 6.5F, 28.275F, 1.0F, 2.0F, 3.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(-2.325F, 6.5F, 11.275F, 1.0F, 2.0F, 18.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(-3.9F, 6.5F, 12.65F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(3.2F, 6.5F, 12.65F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(-4.725F, 6.5F, 8.625F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(3.925F, 6.5F, 9.45F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(3.925F, 6.5F, 10.85F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(3.1F, 6.5F, 7.825F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(2.35F, 6.5F, 6.2F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(1.5F, 6.5F, 4.675F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(-5.55F, 6.5F, 10.525F, 1.0F, 2.0F, 4.0F, 0.0F, false);
        base.setTextureOffset(30, 17).addCuboid(4.825F, 6.5F, 10.875F, 1.0F, 2.0F, 4.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(-1.75F, 6.5F, 1.375F, 1.0F, 2.0F, 2.0F, 0.0F, false);
    }
    @Override
    public void setAngles(SpearProjEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }
    @Override
    public void render(MatrixStack matrixStack, VertexConsumer	buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

        download.render(matrixStack, buffer, packedLight, packedOverlay);
        octagon.render(matrixStack, buffer, packedLight, packedOverlay);
        base.render(matrixStack, buffer, packedLight, packedOverlay);
    }
    public void setRotationAngle(ModelPart bone, float x, float y, float z) {
        bone.pitch = x;
        bone.yaw = y;
        bone.roll = z;
    }

}