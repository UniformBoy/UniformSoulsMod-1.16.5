package com.uniform.uniformsouls.mixins;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.entity.EntityType;
import net.minecraft.resource.ReloadableResourceManager;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;
import java.util.Map;

@Mixin(EntityRenderDispatcher.class)

public abstract class UniPlayerEntityRendererMixin {

   /* @Shadow @Final private Map<String, PlayerEntityRenderer> modelRenderers;
    @Mutable
    @Shadow @Final private final PlayerEntityRenderer playerRenderer;

    protected UniPlayerEntityRendererMixin(PlayerEntityRenderer playerRenderer) {
        this.playerRenderer = playerRenderer;
    }

    @Inject(at = @At("TAIL"), method = "<init>")
   private void UniformSouls$replacePlayerRenderers(TextureManager textureManager, ItemRenderer itemRenderer, ReloadableResourceManager reloadableResourceManager, TextRenderer textRenderer, GameOptions gameOptions, CallbackInfo ci) {
     modelRenderers.put("default", this.playerRenderer);
     modelRenderers.put("slim", new PlayerEntityRenderer(this, true));

    }
*/}