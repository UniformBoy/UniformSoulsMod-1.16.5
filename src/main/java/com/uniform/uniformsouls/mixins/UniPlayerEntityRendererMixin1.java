package com.uniform.uniformsouls.mixins;

import com.uniform.uniformsouls.misc.SwingAnim1Tag;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityRenderer.class)
public abstract class UniPlayerEntityRendererMixin1 extends LivingEntityRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> {

    public abstract Iterable<ItemStack> getItemsHand();

    public UniPlayerEntityRendererMixin1(EntityRenderDispatcher dispatcher, boolean bl) {
        super(dispatcher, new PlayerEntityModel(0.0F, bl), 0.5F);
    }

    @Override
    public Identifier getTexture(AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity.getSkinTexture();
    }

    @Redirect(at = @At("TAIL"), method = "setModelPose")
    private void setModelPose(AbstractClientPlayerEntity player , CallbackInfo ci) {
        boolean notFull = false;
        for (ItemStack item : getItemsHand()) {
            if (item.getItem().isIn(SwingAnim1Tag.SWING_ANIM_1_ITEM)) {
                notFull = true;
            }
        }
        PlayerEntityModel<AbstractClientPlayerEntity> playerEntityModel = (PlayerEntityModel)this.getModel();
        if (notFull) {
            playerEntityModel.setVisible(false);
            playerEntityModel.head.visible = true;
            playerEntityModel.hat.visible = true;
        }
    }
}