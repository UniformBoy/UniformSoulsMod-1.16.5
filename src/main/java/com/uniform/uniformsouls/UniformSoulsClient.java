package com.uniform.uniformsouls;

import com.mojang.blaze3d.systems.RenderSystem;
import com.uniform.uniformsouls.enchantments.PureEnchantment;
import com.uniform.uniformsouls.entity.projectile.*;
import com.uniform.uniformsouls.entity.renderer.*;
import com.uniform.uniformsouls.items.DragonElytra;
import com.uniform.uniformsouls.registry.ModBlocks;
import com.uniform.uniformsouls.registry.ModItems;
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
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.FireworksSparkParticle;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import software.bernie.example.client.renderer.entity.ExampleGeoRenderer;
import software.bernie.example.entity.GeoExampleEntity;
import software.bernie.example.registry.EntityRegistry;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;

import java.util.UUID;

@Environment(EnvType.CLIENT)
public class UniformSoulsClient implements ClientModInitializer {

    public static final Identifier SCARED_EFFECT_SCREEN_1 = new Identifier(UniformSouls.MOD_ID, "textures/misc/scaredeffectscreen1.png");
    public static final Identifier CORRUPTION_CORRUPTING_EFFECT_SCREEN_1 = new Identifier(UniformSouls.MOD_ID, "textures/misc/corruptioncorruptingeffectscreen1.png");
    public final MinecraftClient client = MinecraftClient.getInstance();



    @Override
    public void onInitializeClient() {

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
