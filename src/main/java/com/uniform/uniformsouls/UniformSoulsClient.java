package com.uniform.uniformsouls;

import com.mojang.blaze3d.systems.RenderSystem;
import com.uniform.uniformsouls.cardinal.SoulMagicIntComponent;
import com.uniform.uniformsouls.enchantments.PureEnchantment;
import com.uniform.uniformsouls.entity.projectile.*;
import com.uniform.uniformsouls.entity.renderer.*;
import com.uniform.uniformsouls.items.DragonElytra;
import com.uniform.uniformsouls.registry.ModBlocks;
import com.uniform.uniformsouls.registry.ModItems;
import com.uniform.uniformsouls.registry.SoulType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.particle.FireworksSparkParticle;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;

import java.util.UUID;

@Environment(EnvType.CLIENT)
public class UniformSoulsClient implements ClientModInitializer {

    public static final Identifier SCARED_EFFECT_SCREEN_1 = new Identifier(UniformSouls.MOD_ID, "textures/misc/scaredeffectscreen1.png");
    public static final Identifier CORRUPTION_CORRUPTING_EFFECT_SCREEN_1 = new Identifier(UniformSouls.MOD_ID, "textures/misc/corruptioncorruptingeffectscreen1.png");
    public static final Identifier CHILLED_EFFECT_SCREEN_1 = new Identifier(UniformSouls.MOD_ID, "textures/misc/chilledeffectscreen1.png");
    public final MinecraftClient client = MinecraftClient.getInstance();

    /*
    public static final Identifier UNI_SOUL_ICONS_TEXTURE = new Identifier(UniformSouls.MOD_ID, "textures/gui/soul_icons.png");
     protected int x;
    protected int y;
    private SoulType soulType;
    private SoulMagicIntComponent soulMagicIntComponent;
    int min = 50;
    private ItemStack itemStack;
    int max = this.getMaxMagic();
    int current = this.getCurrentMagic();


    public int getMaxMagic() {
        if (this.soulType != null) { return soulType.getMaxMagic(); } else {
            return 100;
        }
    }

    public int getCurrentMagic() {
        if (this.soulType != null) { return soulType.getCurrentMagic(); } else {
            return 100;
        }
    }

    private int scaledWidth;
    private int scaledHeight;




     */

    @Override
    public void onInitializeClient() {

/*
        if (MinecraftClient.getInstance() == null) return;

        //Hud

       HudRenderCallback.EVENT.register((matrices, delta) -> {
        // your rendering code
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.client.getTextureManager().bindTexture(UNI_SOUL_ICONS_TEXTURE);
           int modifiedHeight = current * 16 / max;
           this.scaledWidth = this.client.getWindow().getScaledWidth();
           this.scaledHeight = this.client.getWindow().getScaledHeight();
           int x = this.scaledWidth / 2 - 7;
           int y = this.scaledHeight - 51;
            if(MinecraftClient.getInstance().player.isHolding(ModItems.DETERMINATION_SOUL) || MinecraftClient.getInstance().player.isHolding(ModItems.DETERMINATION_SWORD) || MinecraftClient.getInstance().player.isHolding(ModItems.DETERMINATION_KNIFE)) {
                DrawableHelper.drawTexture(matrices, x, y, 0, 0, 16, 16, 576, 16);
                DrawableHelper.drawTexture(matrices, x, y + 16 - modifiedHeight, 16, 16 - modifiedHeight, 16, modifiedHeight, 576, 16);
            }
        });

        HudRenderCallback.EVENT.register((matrices, delta) -> {
            // your rendering code
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.client.getTextureManager().bindTexture(UNI_SOUL_ICONS_TEXTURE);
            int modifiedHeight = current * 16 / max;
            this.scaledWidth = this.client.getWindow().getScaledWidth();
            this.scaledHeight = this.client.getWindow().getScaledHeight();
            int x = this.scaledWidth / 2 - 7;
            int y = this.scaledHeight - 51;
            if(MinecraftClient.getInstance().player.isHolding(ModItems.JUSTICE_SOUL) || MinecraftClient.getInstance().player.isHolding(ModItems.JUSTICE_PISTOL)) {
                DrawableHelper.drawTexture(matrices, x, y, 32, 0, 16, 16, 576, 16);
                DrawableHelper.drawTexture(matrices, x, y + 16 - modifiedHeight, 48, 16 - modifiedHeight, 16, modifiedHeight, 576, 16);
            }
        });

        HudRenderCallback.EVENT.register((matrices, delta) -> {
            // your rendering code
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.client.getTextureManager().bindTexture(UNI_SOUL_ICONS_TEXTURE);
            int modifiedHeight = current * 16 / max;
            this.scaledWidth = this.client.getWindow().getScaledWidth();
            this.scaledHeight = this.client.getWindow().getScaledHeight();
            int x = this.scaledWidth / 2 - 7;
            int y = this.scaledHeight - 51;
            if(MinecraftClient.getInstance().player.isHolding(ModItems.KINDNESS_SOUL) || MinecraftClient.getInstance().player.isHolding(ModItems.KINDNESS_FRYING_PAN)) {
                DrawableHelper.drawTexture(matrices, x, y, 64, 0, 16, 16, 576, 16);
                DrawableHelper.drawTexture(matrices, x, y + 16 - modifiedHeight, 80, 16 - modifiedHeight, 16, modifiedHeight, 576, 16);
            }
        });

        HudRenderCallback.EVENT.register((matrices, delta) -> {
            // your rendering code
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.client.getTextureManager().bindTexture(UNI_SOUL_ICONS_TEXTURE);
            int modifiedHeight = current * 16 / max;
            this.scaledWidth = this.client.getWindow().getScaledWidth();
            this.scaledHeight = this.client.getWindow().getScaledHeight();
            int x = this.scaledWidth / 2 - 7;
            int y = this.scaledHeight - 51;
            if(MinecraftClient.getInstance().player.isHolding(ModItems.BRAVERY_SOUL) || MinecraftClient.getInstance().player.isHolding(ModItems.BRAVERY_TOUGH_GLOVE)) {
                DrawableHelper.drawTexture(matrices, x, y, 96, 0, 16, 16, 576, 16);
                DrawableHelper.drawTexture(matrices, x, y + 16 - modifiedHeight, 112, 16 - modifiedHeight, 16, modifiedHeight, 576, 16);
            }
        });

        HudRenderCallback.EVENT.register((matrices, delta) -> {
            // your rendering code
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.client.getTextureManager().bindTexture(UNI_SOUL_ICONS_TEXTURE);
            int modifiedHeight = current * 16 / max;
            this.scaledWidth = this.client.getWindow().getScaledWidth();
            this.scaledHeight = this.client.getWindow().getScaledHeight();
            int x = this.scaledWidth / 2 - 7;
            int y = this.scaledHeight - 51;
            if(MinecraftClient.getInstance().player.isHolding(ModItems.PERSEVERANCE_SOUL) || MinecraftClient.getInstance().player.isHolding(ModItems.PERSEVERANCE_TORN_NOTEBOOK)) {
                DrawableHelper.drawTexture(matrices, x, y, 128, 0, 16, 16, 576, 16);
                DrawableHelper.drawTexture(matrices, x, y + 16 - modifiedHeight, 144, 16 - modifiedHeight, 16, modifiedHeight, 576, 16);
            }
        });

        HudRenderCallback.EVENT.register((matrices, delta) -> {
            // your rendering code
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.client.getTextureManager().bindTexture(UNI_SOUL_ICONS_TEXTURE);
            int modifiedHeight = current * 16 / max;
            this.scaledWidth = this.client.getWindow().getScaledWidth();
            this.scaledHeight = this.client.getWindow().getScaledHeight();
            int x = this.scaledWidth / 2 - 7;
            int y = this.scaledHeight - 51;
            if(MinecraftClient.getInstance().player.isHolding(ModItems.PATIENCE_SOUL) || MinecraftClient.getInstance().player.isHolding(ModItems.PATIENCE_TOY_KNIFE)) {
                DrawableHelper.drawTexture(matrices, x, y, 160, 0, 16, 16, 576, 16);
                DrawableHelper.drawTexture(matrices, x, y + 16 - modifiedHeight, 176, 16 - modifiedHeight, 16, modifiedHeight, 576, 16);
            }
        });

        HudRenderCallback.EVENT.register((matrices, delta) -> {
            // your rendering code
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.client.getTextureManager().bindTexture(UNI_SOUL_ICONS_TEXTURE);
            int modifiedHeight = current * 16 / max;
            this.scaledWidth = this.client.getWindow().getScaledWidth();
            this.scaledHeight = this.client.getWindow().getScaledHeight();
            int x = this.scaledWidth / 2 - 7;
            int y = this.scaledHeight - 51;
            if(MinecraftClient.getInstance().player.isHolding(ModItems.INTEGRITY_SOUL) || MinecraftClient.getInstance().player.isHolding(ModItems.INTEGRITY_BALLET_SHOES)) {
                DrawableHelper.drawTexture(matrices, x, y, 192, 0, 16, 16, 576, 16);
                DrawableHelper.drawTexture(matrices, x, y + 16 - modifiedHeight, 208, 16 - modifiedHeight, 16, modifiedHeight, 576, 16);
            }
        });

        HudRenderCallback.EVENT.register((matrices, delta) -> {
            // your rendering code
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.client.getTextureManager().bindTexture(UNI_SOUL_ICONS_TEXTURE);
            int modifiedHeight = current * 16 / max;
            this.scaledWidth = this.client.getWindow().getScaledWidth();
            this.scaledHeight = this.client.getWindow().getScaledHeight();
            int x = this.scaledWidth / 2 - 7;
            int y = this.scaledHeight - 51;
            if(MinecraftClient.getInstance().player.isHolding(ModItems.FEAR_SOUL) || MinecraftClient.getInstance().player.isHolding(ModItems.FEAR_SCYTHE)) {
                DrawableHelper.drawTexture(matrices, x, y, 224, 0, 16, 16, 576, 16);
                DrawableHelper.drawTexture(matrices, x, y + 16 - modifiedHeight, 240, 16 - modifiedHeight, 16, modifiedHeight, 576, 16);
            }
        });

        HudRenderCallback.EVENT.register((matrices, delta) -> {
            // your rendering code
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.client.getTextureManager().bindTexture(UNI_SOUL_ICONS_TEXTURE);
            int modifiedHeight = current * 16 / max;
            this.scaledWidth = this.client.getWindow().getScaledWidth();
            this.scaledHeight = this.client.getWindow().getScaledHeight();
            int x = this.scaledWidth / 2 - 7;
            int y = this.scaledHeight - 51;
            if(MinecraftClient.getInstance().player.isHolding(ModItems.MONSTER_SOUL) || MinecraftClient.getInstance().player.isHolding(ModItems.SANS_GASTER_BLASTER)) {
                DrawableHelper.drawTexture(matrices, x, y, 256, 0, 16, 16, 576, 16);
                DrawableHelper.drawTexture(matrices, x, y + 16 - modifiedHeight, 272, 16 - modifiedHeight, 16, modifiedHeight, 576, 16);
            }
        });

        HudRenderCallback.EVENT.register((matrices, delta) -> {
            // your rendering code
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.client.getTextureManager().bindTexture(UNI_SOUL_ICONS_TEXTURE);
            int modifiedHeight = current * 16 / max;
            this.scaledWidth = this.client.getWindow().getScaledWidth();
            this.scaledHeight = this.client.getWindow().getScaledHeight();
            int x = this.scaledWidth / 2 - 7;
            int y = this.scaledHeight - 51;
            if(MinecraftClient.getInstance().player.isHolding(ModItems.DESPAIR_SOUL) || MinecraftClient.getInstance().player.isHolding(ModItems.DESPAIR_SWORD)) {
                DrawableHelper.drawTexture(matrices, x, y, 288, 0, 16, 16, 576, 16);
                DrawableHelper.drawTexture(matrices, x, y + 16 - modifiedHeight, 304, 16 - modifiedHeight, 16, modifiedHeight, 576, 16);
            }
        });

        HudRenderCallback.EVENT.register((matrices, delta) -> {
            // your rendering code
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.client.getTextureManager().bindTexture(UNI_SOUL_ICONS_TEXTURE);
            int modifiedHeight = current * 16 / max;
            this.scaledWidth = this.client.getWindow().getScaledWidth();
            this.scaledHeight = this.client.getWindow().getScaledHeight();
            int x = this.scaledWidth / 2 - 7;
            int y = this.scaledHeight - 51;
            if(MinecraftClient.getInstance().player.isHolding(ModItems.IMMORALITY_SOUL) || MinecraftClient.getInstance().player.isHolding(ModItems.IMMORALITY_SHOTGUN)) {
                DrawableHelper.drawTexture(matrices, x, y, 320, 0, 16, 16, 576, 16);
                DrawableHelper.drawTexture(matrices, x, y + 16 - modifiedHeight, 336, 16 - modifiedHeight, 16, modifiedHeight, 576, 16);
            }
        });

        HudRenderCallback.EVENT.register((matrices, delta) -> {
            // your rendering code
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.client.getTextureManager().bindTexture(UNI_SOUL_ICONS_TEXTURE);
            int modifiedHeight = current * 16 / max;
            this.scaledWidth = this.client.getWindow().getScaledWidth();
            this.scaledHeight = this.client.getWindow().getScaledHeight();
            int x = this.scaledWidth / 2 - 7;
            int y = this.scaledHeight - 51;
            if(MinecraftClient.getInstance().player.isHolding(ModItems.WRATH_SOUL) || MinecraftClient.getInstance().player.isHolding(ModItems.WRATH_DOUBLE_FRYING_PAN)) {
                DrawableHelper.drawTexture(matrices, x, y, 352, 0, 16, 16, 576, 16);
                DrawableHelper.drawTexture(matrices, x, y + 16 - modifiedHeight, 368, 16 - modifiedHeight, 16, modifiedHeight, 576, 16);
            }
        });

        HudRenderCallback.EVENT.register((matrices, delta) -> {
            // your rendering code
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.client.getTextureManager().bindTexture(UNI_SOUL_ICONS_TEXTURE);
            int modifiedHeight = current * 16 / max;
            this.scaledWidth = this.client.getWindow().getScaledWidth();
            this.scaledHeight = this.client.getWindow().getScaledHeight();
            int x = this.scaledWidth / 2 - 7;
            int y = this.scaledHeight - 51;
            if(MinecraftClient.getInstance().player.isHolding(ModItems.DISHONOR_SOUL) || MinecraftClient.getInstance().player.isHolding(ModItems.DISHONOR_STURDY_GLOVE)) {
                DrawableHelper.drawTexture(matrices, x, y, 384, 0, 16, 16, 576, 16);
                DrawableHelper.drawTexture(matrices, x, y + 16 - modifiedHeight, 400, 16 - modifiedHeight, 16, modifiedHeight, 576, 16);
            }
        });

        HudRenderCallback.EVENT.register((matrices, delta) -> {
            // your rendering code
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.client.getTextureManager().bindTexture(UNI_SOUL_ICONS_TEXTURE);
            int modifiedHeight = current * 16 / max;
            this.scaledWidth = this.client.getWindow().getScaledWidth();
            this.scaledHeight = this.client.getWindow().getScaledHeight();
            int x = this.scaledWidth / 2 - 7;
            int y = this.scaledHeight - 51;
            if(MinecraftClient.getInstance().player.isHolding(ModItems.APATHY_SOUL) || MinecraftClient.getInstance().player.isHolding(ModItems.APATHY_CARELESS_JOURNAL)) {
                DrawableHelper.drawTexture(matrices, x, y, 416, 0, 16, 16, 576, 16);
                DrawableHelper.drawTexture(matrices, x, y + 16 - modifiedHeight, 432, 16 - modifiedHeight, 16, modifiedHeight, 576, 16);
            }
        });

        HudRenderCallback.EVENT.register((matrices, delta) -> {
            // your rendering code
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.client.getTextureManager().bindTexture(UNI_SOUL_ICONS_TEXTURE);
            int modifiedHeight = current * 16 / max;
            this.scaledWidth = this.client.getWindow().getScaledWidth();
            this.scaledHeight = this.client.getWindow().getScaledHeight();
            int x = this.scaledWidth / 2 - 7;
            int y = this.scaledHeight - 51;
            if(MinecraftClient.getInstance().player.isHolding(ModItems.RECKLESSNESS_SOUL) || MinecraftClient.getInstance().player.isHolding(ModItems.RECKLESSNESS_BALLISTIC_KNIFE)) {
                DrawableHelper.drawTexture(matrices, x, y, 448, 0, 16, 16, 576, 16);
                DrawableHelper.drawTexture(matrices, x, y + 16 - modifiedHeight, 464, 16 - modifiedHeight, 16, modifiedHeight, 576, 16);
            }
        });

        HudRenderCallback.EVENT.register((matrices, delta) -> {
            // your rendering code
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.client.getTextureManager().bindTexture(UNI_SOUL_ICONS_TEXTURE);
            int modifiedHeight = current * 16 / max;
            this.scaledWidth = this.client.getWindow().getScaledWidth();
            this.scaledHeight = this.client.getWindow().getScaledHeight();
            int x = this.scaledWidth / 2 - 7;
            int y = this.scaledHeight - 51;
            if(MinecraftClient.getInstance().player.isHolding(ModItems.DECEIT_SOUL) || MinecraftClient.getInstance().player.isHolding(ModItems.DECEIT_TENNIS_SHOE)) {
                DrawableHelper.drawTexture(matrices, x, y, 480, 0, 16, 16, 576, 16);
                DrawableHelper.drawTexture(matrices, x, y + 16 - modifiedHeight, 496, 16 - modifiedHeight, 16, modifiedHeight, 576, 16);
            }
        });

        HudRenderCallback.EVENT.register((matrices, delta) -> {
            // your rendering code
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.client.getTextureManager().bindTexture(UNI_SOUL_ICONS_TEXTURE);
            int modifiedHeight = current * 16 / max;
            this.scaledWidth = this.client.getWindow().getScaledWidth();
            this.scaledHeight = this.client.getWindow().getScaledHeight();
            int x = this.scaledWidth / 2 - 7;
            int y = this.scaledHeight - 51;
            if(MinecraftClient.getInstance().player.isHolding(ModItems.TERROR_SOUL) || MinecraftClient.getInstance().player.isHolding(ModItems.TERROR_SCYTHE)) {
                DrawableHelper.drawTexture(matrices, x, y, 512, 0, 16, 16, 576, 16);
                DrawableHelper.drawTexture(matrices, x, y + 16 - modifiedHeight, 528, 16 - modifiedHeight, 16, modifiedHeight, 576, 16);
            }
        });

        HudRenderCallback.EVENT.register((matrices, delta) -> {
            // your rendering code
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.client.getTextureManager().bindTexture(UNI_SOUL_ICONS_TEXTURE);
            int modifiedHeight = current * 16 / max;
            this.scaledWidth = this.client.getWindow().getScaledWidth();
            this.scaledHeight = this.client.getWindow().getScaledHeight();
            int x = this.scaledWidth / 2 - 7;
            int y = this.scaledHeight - 51;
            if(MinecraftClient.getInstance().player.isHolding(ModItems.CORRUPTED_MONSTER_SOUL) || MinecraftClient.getInstance().player.isHolding(ModItems.SANS_GASTER_BLASTER)) {
                DrawableHelper.drawTexture(matrices, x, y, 544, 0, 16, 16, 576, 16);
                DrawableHelper.drawTexture(matrices, x, y + 16 - modifiedHeight, 560, 16 - modifiedHeight, 16, modifiedHeight, 576, 16);
            }
        });


 */




        EntityRendererRegistry.INSTANCE.register(UniformSouls.CUBE, (dispatcher, context) -> {
            return new CubeEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.SKELLY, (dispatcher, context) -> {
            return new SkellyEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.HATE, (dispatcher, context) -> {
            return new HateEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.CATBOYMAID, (dispatcher, context) -> {
            return new CatBoyMaidEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.FOUNDERLAB, (dispatcher, context) -> {
            return new FounderLabEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.CORRUPTION, CorruptionEntityRenderer::new);

        EntityRendererRegistry.INSTANCE.register(UniformSouls.GOLEMSOULMONSTER, (dispatcher, context) -> {
            return new GolemSoulMonsterEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.BONEGROUND, (dispatcher, context) -> {
            return new BoneGroundEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.SPEARGROUND, (dispatcher, context) -> {
            return new SpearGroundEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.DETERMINATION_SWORD_SLASH_ENTITY, (dispatcher, context) -> {
            return new DeterminationSwordSlashEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.JUSTICE_BULLET_ENTITY, (dispatcher, context) -> {
            return new JusticeBulletEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.INTEGRITY_SAWBLADE_ENTITY, (dispatcher, context) -> {
            return new IntegritySawbladeEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.KINDNESS_SHIELD_ENTITY, (dispatcher, context) -> {
            return new KindnessShieldEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.KINDNESS_SHIELD2_ENTITY, (dispatcher, context) -> {
            return new KindnessShield2EntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.PERSEVERANCE_LASER_ENTITY, (dispatcher, context) -> {
            return new PerseveranceLaserEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.PATIENCE_STRING_ENTITY, (dispatcher, context) -> {
            return new PatienceStringEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.BRAVERY_GLOVE_ENTITY, (dispatcher, context) -> {
            return new BraveryGloveEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.SANS_GASTER_BLASTER_LASER_ENTITY, (dispatcher, context) -> {
            return new SansGasterBlasterLaserEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.ASRIEL_CHAOS_SABER_LIGHTNING_ENTITY, (dispatcher, context) -> {
            return new AsrielChaosSaberLightningEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.FEAR_SCYTHE_SLASH_ENTITY, (dispatcher, context) -> {
            return new FearScytheSlashEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.DESPAIR_SWORD_SLASH_ENTITY, (dispatcher, context) -> {
            return new DespairSwordSlashEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.IMMORALITY_BULLET_ENTITY, (dispatcher, context) -> {
            return new ImmoralityBulletEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.DECEIT_SAWBLADE_ENTITY, (dispatcher, context) -> {
            return new DeceitSawbladeEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.APATHY_LASER_ENTITY, (dispatcher, context) -> {
            return new ApathyLaserEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.RECKLESSNESS_STRING_ENTITY, (dispatcher, context) -> {
            return new RecklessnessStringEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.DISHONOR_GLOVE_ENTITY, (dispatcher, context) -> {
            return new DishonorGloveEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.WRATH_SHIELD_ENTITY, (dispatcher, context) -> {
            return new WrathShieldEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.WRATH_SHIELD2_ENTITY, (dispatcher, context) -> {
            return new WrathShield2EntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.TERROR_SCYTHE_SLASH_ENTITY, (dispatcher, context) -> {
            return new TerrorScytheSlashEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.XCHARA_KNIFE_SLASH_ENTITY, (dispatcher, context) -> {
            return new XCharaKnifeSlashEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.BONE_PROJ_ENTITY, (dispatcher, context) -> {
            return new BoneProjEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.SPEAR_PROJ_ENTITY, (dispatcher, context) -> {
            return new SpearProjEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.FROST_BOMB_ENTITY, (dispatcher, context) -> {
            return new FrostBomb1EntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.FIRE_PROJ_ENTITY, (dispatcher, context) -> {
            return new FireProjEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.KINDNESS_SHEILD_PROJ_ENTITY, (dispatcher, context) -> {
            return new KindnessShieldProjEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.DETERMINATION_SHEILD_PROJ_ENTITY, (dispatcher, context) -> {
            return new DeterminationShieldProjEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.DETERMINATION_SHIELD2_ENTITY, (dispatcher, context) -> {
            return new DeterminationShield2EntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.FEAR_SHEILD_PROJ_ENTITY, (dispatcher, context) -> {
            return new FearShieldProjEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.FEAR_SHIELD2_ENTITY, (dispatcher, context) -> {
            return new FearShield2EntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.GHOST_PROJ_ENTITY, (dispatcher, context) -> {
            return new GhostProjEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.MONSTER_SHIELD_PROJ_ENTITY, (dispatcher, context) -> {
            return new MonsterShieldProjEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.MONSTER_SHIELD2_ENTITY, (dispatcher, context) -> {
            return new MonsterShield2EntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.ENERGY_BEAM_PROJ_ENTITY, (dispatcher, context) -> {
            return new EnergyBeamProjEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(UniformSouls.VEX_PET_ENTITY, (dispatcher, context) -> {
            return new VexPetEntityRenderer(dispatcher);
        });






        EntityRendererRegistry.INSTANCE.register(UniformSouls.SOUL_DETERMINATION_1, (dispatcher, context) -> {
            return new SoulDetermination1EntityRenderer(dispatcher);
        });




        EntityRendererRegistry.INSTANCE.register(UniformSouls.LIGHTNINGREDENTITY, (dispatcher, context) -> {
            return new LightningRedEntityRenderer(dispatcher);
        });


        EntityRendererRegistry.INSTANCE.register(UniformSouls.UNIPLAYER, UniPlayerEntityRenderer::new);



        //Packets

        ClientSidePacketRegistry.INSTANCE.register(DeterminationSwordSlashEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                DeterminationSwordSlashEntity proj = new DeterminationSwordSlashEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(JusticeBulletEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                JusticeBulletEntity proj = new JusticeBulletEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(IntegritySawbladeEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                IntegritySawbladeEntity proj = new IntegritySawbladeEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(KindnessShieldEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                KindnessShieldEntity proj = new KindnessShieldEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(PerseveranceLaserEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                PerseveranceLaserEntity proj = new PerseveranceLaserEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(PatienceStringEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                PatienceStringEntity proj = new PatienceStringEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(BraveryGloveEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                BraveryGloveEntity proj = new BraveryGloveEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(SansGasterBlasterLaserEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                SansGasterBlasterLaserEntity proj = new SansGasterBlasterLaserEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(AsrielChaosSaberLightningEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                AsrielChaosSaberLightningEntity proj = new AsrielChaosSaberLightningEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(FearScytheSlashEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                FearScytheSlashEntity proj = new FearScytheSlashEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(DespairSwordSlashEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                DespairSwordSlashEntity proj = new DespairSwordSlashEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(ImmoralityBulletEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                ImmoralityBulletEntity proj = new ImmoralityBulletEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(DeceitSawbladeEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                DeceitSawbladeEntity proj = new DeceitSawbladeEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(ApathyLaserEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                ApathyLaserEntity proj = new ApathyLaserEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(RecklessnessStringEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                RecklessnessStringEntity proj = new RecklessnessStringEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(DishonorGloveEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                DishonorGloveEntity proj = new DishonorGloveEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(WrathShieldEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                WrathShieldEntity proj = new WrathShieldEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(TerrorScytheSlashEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                TerrorScytheSlashEntity proj = new TerrorScytheSlashEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(XCharaKnifeSlashEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                XCharaKnifeSlashEntity proj = new XCharaKnifeSlashEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(BoneProjEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                BoneProjEntity proj = new BoneProjEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(SpearProjEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                SpearProjEntity proj = new SpearProjEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(FrostBomb1Entity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                FrostBomb1Entity proj = new FrostBomb1Entity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(FireProjEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                FireProjEntity proj = new FireProjEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(KindnessShieldProjEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                KindnessShieldProjEntity proj = new KindnessShieldProjEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(DeterminationShieldProjEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                DeterminationShieldProjEntity proj = new DeterminationShieldProjEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(FearShieldProjEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                FearShieldProjEntity proj = new FearShieldProjEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(GhostProjEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                GhostProjEntity proj = new GhostProjEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(MonsterShieldProjEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                MonsterShieldProjEntity proj = new MonsterShieldProjEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });

        ClientSidePacketRegistry.INSTANCE.register(EnergyBeamProjEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                EnergyBeamProjEntity proj = new EnergyBeamProjEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        });


        //Armor



        //Elytra
        FabricModelPredicateProviderRegistry.register(ModItems.DRAGON_ELYTRA.asItem(),
                new Identifier("broken"), (itemStack, clientWorld, livingEntity) -> {
                    return DragonElytra.isUsable(itemStack) ? 0.0F : 1.0F;
                });



        //Particles

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/flash_red"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.FLASH_RED, FireworksSparkParticle.FlashFactory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/flash_yellow"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.FLASH_YELLOW, FireworksSparkParticle.FlashFactory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/flash_blue"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.FLASH_BLUE, FireworksSparkParticle.FlashFactory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/flash_green"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.FLASH_GREEN, FireworksSparkParticle.FlashFactory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/flash_purple"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.FLASH_PURPLE, FireworksSparkParticle.FlashFactory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/flash_light_blue"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.FLASH_LIGHT_BLUE, FireworksSparkParticle.FlashFactory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/flash_orange"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.FLASH_ORANGE, FireworksSparkParticle.FlashFactory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/flash_white"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.FLASH_WHITE, FireworksSparkParticle.FlashFactory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/flash_pink"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.FLASH_PINK, FireworksSparkParticle.FlashFactory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/flash_despair"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.FLASH_DESPAIR, FireworksSparkParticle.FlashFactory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/flash_immorality"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.FLASH_IMMORALITY, FireworksSparkParticle.FlashFactory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/flash_deceit"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.FLASH_DECEIT, FireworksSparkParticle.FlashFactory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/flash_apathy"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.FLASH_APATHY, FireworksSparkParticle.FlashFactory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/flash_recklessness"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.FLASH_RECKLESSNESS, FireworksSparkParticle.FlashFactory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/flash_dishonor"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.FLASH_DISHONOR, FireworksSparkParticle.FlashFactory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/flash_wrath"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.FLASH_WRATH, FireworksSparkParticle.FlashFactory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/flash_terror"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.FLASH_TERROR, FireworksSparkParticle.FlashFactory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/flash_overwrite_determination"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.FLASH_OVERWRITE_DETERMINATION, FireworksSparkParticle.FlashFactory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/soul_determination"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.SOUL_DETERMINATION, FlameParticle.Factory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/soul_justice"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.SOUL_JUSTICE, FlameParticle.Factory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/soul_integrity"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.SOUL_INTEGRITY, FlameParticle.Factory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/soul_perseverance"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.SOUL_PERSEVERANCE, FlameParticle.Factory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/soul_patience"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.SOUL_PATIENCE, FlameParticle.Factory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/soul_bravery"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.SOUL_BRAVERY, FlameParticle.Factory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/soul_kindness"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.SOUL_KINDNESS, FlameParticle.Factory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/soul_monster"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.SOUL_MONSTER, FlameParticle.Factory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/soul_fear"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.SOUL_FEAR, FlameParticle.Factory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/soul_despair"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.SOUL_DESPAIR, FlameParticle.Factory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/soul_immorality"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.SOUL_IMMORALITY, FlameParticle.Factory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/soul_deceit"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.SOUL_DECEIT, FlameParticle.Factory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/soul_apathy"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.SOUL_APATHY, FlameParticle.Factory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/soul_recklessness"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.SOUL_RECKLESSNESS, FlameParticle.Factory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/soul_dishonor"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.SOUL_DISHONOR, FlameParticle.Factory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/soul_wrath"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.SOUL_WRATH, FlameParticle.Factory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/soul_terror"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.SOUL_TERROR, FlameParticle.Factory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/soul_overwrite_determination"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.SOUL_OVERWRITE_DETERMINATION, FlameParticle.Factory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/flash_purple_2"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.FLASH_PURPLE_2, FlameParticle.Factory::new);



        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/perseverance_laser_1"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.PERSEVERANCE_LASER_1, FlameParticle.Factory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/apathy_laser_1"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.APATHY_LASER_1, FlameParticle.Factory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/patience_string_1"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.PATIENCE_STRING_1, FlameParticle.Factory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/recklessness_string_1"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.RECKLESSNESS_STRING_1, FlameParticle.Factory::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {
            registry.register(new Identifier(UniformSouls.MOD_ID, "particle/asriel_chaos_saber_lightning"));
        })));

        ParticleFactoryRegistry.getInstance().register(UniformSouls.ASRIEL_CHAOS_SABER_LIGHTNING, FlameParticle.Factory::new);


        //Blocks

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NETHERGROUND_PORTAL, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KINDNESS_SHIELD2_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DETERMINATION_SHIELD_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AETHER_CLOUD_BLOCK_WHITE_1, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DETERMINATION_SHIELD_BLOCK_TO_AIR, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KINDNESS_SHIELD2_BLOCK_TO_AIR, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FEAR_SHIELD_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FEAR_SHIELD_BLOCK_TO_AIR, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORRUPTION_PORTAL, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AETHER_CLOUD_BLOCK_CYAN_1, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.THE_BENEATH_PORTAL, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STATUE_PLAYER_1, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OMEGA_PORTAL_1, RenderLayer.getTranslucent());

        HudRenderCallback.EVENT.register((matrix, delta)-> {

            if (client.player.hasStatusEffect(UniformSouls.SCARED)) {

                RenderSystem.disableDepthTest();
                RenderSystem.depthMask(false);
                RenderSystem.defaultBlendFunc();
                RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
                RenderSystem.disableAlphaTest();
                this.client.getTextureManager().bindTexture(SCARED_EFFECT_SCREEN_1);
                Tessellator tessellator = Tessellator.getInstance();
                BufferBuilder bufferBuilder = tessellator.getBuffer();
                bufferBuilder.begin(7, VertexFormats.POSITION_TEXTURE);
                bufferBuilder.vertex(0.0D, (double) this.client.getWindow().getScaledHeight(), -90.0D).texture(0.0F, 1.0F).next();
                bufferBuilder.vertex((double) this.client.getWindow().getScaledWidth(), (double) this.client.getWindow().getScaledHeight(), -90.0D).texture(1.0F, 1.0F).next();
                bufferBuilder.vertex((double) this.client.getWindow().getScaledWidth(), 0.0D, -90.0D).texture(1.0F, 0.0F).next();
                bufferBuilder.vertex(0.0D, 0.0D, -90.0D).texture(0.0F, 0.0F).next();
                tessellator.draw();
                RenderSystem.depthMask(true);
                RenderSystem.enableDepthTest();
                RenderSystem.enableAlphaTest();
                RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            }

            if(client.player.hasStatusEffect(UniformSouls.CHILLEDEFFECT1)) {
                RenderSystem.disableDepthTest();
                RenderSystem.depthMask(false);
                RenderSystem.defaultBlendFunc();
                RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
                RenderSystem.disableAlphaTest();
                this.client.getTextureManager().bindTexture(CHILLED_EFFECT_SCREEN_1);
                Tessellator tessellator = Tessellator.getInstance();
                BufferBuilder bufferBuilder = tessellator.getBuffer();
                bufferBuilder.begin(7, VertexFormats.POSITION_TEXTURE);
                bufferBuilder.vertex(0.0D, (double) this.client.getWindow().getScaledHeight(), -90.0D).texture(0.0F, 1.0F).next();
                bufferBuilder.vertex((double) this.client.getWindow().getScaledWidth(), (double) this.client.getWindow().getScaledHeight(), -90.0D).texture(1.0F, 1.0F).next();
                bufferBuilder.vertex((double) this.client.getWindow().getScaledWidth(), 0.0D, -90.0D).texture(1.0F, 0.0F).next();
                bufferBuilder.vertex(0.0D, 0.0D, -90.0D).texture(0.0F, 0.0F).next();
                tessellator.draw();
                RenderSystem.depthMask(true);
                RenderSystem.enableDepthTest();
                RenderSystem.enableAlphaTest();
                RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            }

            else {
                if (client.player.hasStatusEffect(UniformSouls.CORRUPTIONCORRUPTINGEFFECT1) && !(PureEnchantment.hasPure(client.player))) {

                    RenderSystem.disableDepthTest();
                    RenderSystem.depthMask(false);
                    RenderSystem.defaultBlendFunc();
                    RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
                    RenderSystem.disableAlphaTest();
                    this.client.getTextureManager().bindTexture(CORRUPTION_CORRUPTING_EFFECT_SCREEN_1);
                    Tessellator tessellator = Tessellator.getInstance();
                    BufferBuilder bufferBuilder = tessellator.getBuffer();
                    bufferBuilder.begin(7, VertexFormats.POSITION_TEXTURE);
                    bufferBuilder.vertex(0.0D, (double) this.client.getWindow().getScaledHeight(), -90.0D).texture(0.0F, 1.0F).next();
                    bufferBuilder.vertex((double) this.client.getWindow().getScaledWidth(), (double) this.client.getWindow().getScaledHeight(), -90.0D).texture(1.0F, 1.0F).next();
                    bufferBuilder.vertex((double) this.client.getWindow().getScaledWidth(), 0.0D, -90.0D).texture(1.0F, 0.0F).next();
                    bufferBuilder.vertex(0.0D, 0.0D, -90.0D).texture(0.0F, 0.0F).next();
                    tessellator.draw();
                    RenderSystem.depthMask(true);
                    RenderSystem.enableDepthTest();
                    RenderSystem.enableAlphaTest();
                    RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
                }

            }

        });


    }
}
