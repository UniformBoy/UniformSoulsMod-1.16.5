//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.model.VexPetEntityModel;
import com.uniform.uniformsouls.entity.passive.VexPetEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.model.VexEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.VexEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

@Environment(EnvType.CLIENT)
public class VexPetEntityRenderer extends BipedEntityRenderer<VexPetEntity, VexPetEntityModel> {
    private static final Identifier TEXTURE = new Identifier("uniformsouls", "textures/entity/vex_pet/vex_pet.png");

    public VexPetEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new VexPetEntityModel(), 0.3F);
    }

    protected int getBlockLight(VexPetEntity vexEntity, BlockPos blockPos) {
        return 15;
    }

    public Identifier getTexture(VexPetEntity vexEntity) {
        return TEXTURE;
    }

    protected void scale(VexPetEntity vexEntity, MatrixStack matrixStack, float f) {
        matrixStack.scale(0.4F, 0.4F, 0.4F);
    }
}
