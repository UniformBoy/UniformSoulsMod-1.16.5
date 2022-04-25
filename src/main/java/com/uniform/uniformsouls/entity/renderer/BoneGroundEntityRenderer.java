//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.uniform.uniformsouls.entity.renderer;

import com.uniform.uniformsouls.entity.mob.BoneGroundEntity;
import com.uniform.uniformsouls.entity.model.BoneGroundEntityModel;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class BoneGroundEntityRenderer extends MobEntityRenderer<BoneGroundEntity, BoneGroundEntityModel> {
    public BoneGroundEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new BoneGroundEntityModel(), 0.5F);
    }

    public Identifier getTexture(BoneGroundEntity entity) {
        return new Identifier("uniformsouls", "textures/entity/bone/boneground.png");
    }
}
