package com.uniform.uniformsouls;

import com.uniform.uniformsouls.effects.*;
import com.uniform.uniformsouls.enchantments.*;
import com.uniform.uniformsouls.entity.damage.UniDamageSource;
import com.uniform.uniformsouls.entity.misc.LightningRedEntity;
import com.uniform.uniformsouls.entity.misc.UniPlayerEntity;
import com.uniform.uniformsouls.entity.mob.*;
import com.uniform.uniformsouls.entity.passive.*;
import com.uniform.uniformsouls.entity.projectile.*;
import com.uniform.uniformsouls.registry.ModBlocks;
import com.uniform.uniformsouls.registry.ModItems;
import com.uniform.uniformsouls.registry.SpawnInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.fabricmc.fabric.mixin.object.builder.SpawnRestrictionAccessor;
import net.kyrptonaught.customportalapi.CustomPortalApiRegistry;
import net.kyrptonaught.customportalapi.portal.PortalIgnitionSource;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.GeckoLib;


public class UniformSouls implements ModInitializer{

    public static final String MOD_ID = "uniformsouls";

    //Souls Group

    public static final ItemGroup SOULS = FabricItemGroupBuilder.create(
                    new Identifier(MOD_ID, "souls"))
            .icon(() -> new ItemStack(ModItems.DETERMINATION_SOUL))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(ModItems.JUSTICE_SOUL));
                stacks.add(new ItemStack(ModItems.KINDNESS_SOUL));
                stacks.add(new ItemStack(ModItems.BRAVERY_SOUL));
                stacks.add(new ItemStack(ModItems.PERSEVERANCE_SOUL));
                stacks.add(new ItemStack(ModItems.PATIENCE_SOUL));
                stacks.add(new ItemStack(ModItems.INTEGRITY_SOUL));
                stacks.add(new ItemStack(ModItems.DETERMINATION_SOUL));
                stacks.add(new ItemStack(ModItems.CORRUPTION_SOUL));
                stacks.add(new ItemStack(ModItems.HATE_SOUL));
                stacks.add(new ItemStack(ModItems.FEAR_SOUL));
                stacks.add(new ItemStack(ModItems.MONSTER_SOUL));
                stacks.add(new ItemStack(ModItems.ASRIEL_SOUL));
            })
            .build();

    //Blocks Group

    public static final ItemGroup BLOCKS = FabricItemGroupBuilder.create(
                    new Identifier(MOD_ID, "blocks"))
            .icon(() -> new ItemStack(ModBlocks.MONSTER_SOUL_LIGHT_BLOCK1))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(ModBlocks.CORRUPTION));
                stacks.add(new ItemStack(ModBlocks.CHAOTIC_CORRUPTION));
                stacks.add(new ItemStack(ModBlocks.UNDERGROUND_PORTAL));
                stacks.add(new ItemStack(ModBlocks.YELLOW_FLOWER_BED));
                stacks.add(new ItemStack(ModBlocks.KINDNESS_SHIELD_BLOCK));
                stacks.add(new ItemStack(ModBlocks.BARRIER));
                stacks.add(new ItemStack(ModBlocks.OMEGA_STONE_BRICKS1));
                stacks.add(new ItemStack(ModBlocks.SUPERHEATED_OBSIDIAN));
                stacks.add(new ItemStack(ModBlocks.MONSTER_SOUL_LIGHT_BLOCK1));
                stacks.add(new ItemStack(ModBlocks.JUSTICE_SOUL_LIGHT_BLOCK1));
                stacks.add(new ItemStack(ModBlocks.BRAVERY_SOUL_LIGHT_BLOCK1));
                stacks.add(new ItemStack(ModBlocks.KINDNESS_SOUL_LIGHT_BLOCK1));
                stacks.add(new ItemStack(ModBlocks.PERSEVERANCE_SOUL_LIGHT_BLOCK1));
                stacks.add(new ItemStack(ModBlocks.PATIENCE_SOUL_LIGHT_BLOCK1));
                stacks.add(new ItemStack(ModBlocks.INTEGRITY_SOUL_LIGHT_BLOCK1));
                stacks.add(new ItemStack(ModBlocks.DETERMINATION_SOUL_LIGHT_BLOCK1));
                stacks.add(new ItemStack(ModBlocks.DARK_GLOWSTONE));
                stacks.add(new ItemStack(ModBlocks.MENU_BLOCK_BLACK1));
                stacks.add(new ItemStack(ModBlocks.MENU_BLOCK_WHITE1));
                stacks.add(new ItemStack(ModBlocks.SOUL_CRAFTING_TABLE));
                stacks.add(new ItemStack(ModBlocks.THE_RUINS_GRASS_BLOCK));
                stacks.add(new ItemStack(ModBlocks.THE_RUINS_DIRT));
                stacks.add(new ItemStack(ModBlocks.NETHERGROUND_PORTAL));
                stacks.add(new ItemStack(ModBlocks.KINDNESS_SHIELD2_BLOCK));
                stacks.add(new ItemStack(ModBlocks.DETERMINATION_SHIELD_BLOCK));
                stacks.add(new ItemStack(ModBlocks.FEAR_SHIELD_BLOCK));
                stacks.add(new ItemStack(ModBlocks.AETHER_CLOUD_BLOCK_WHITE_1));
            })
            .build();

    //Soul Combat Group

    public static final ItemGroup SOUL_COMBAT = FabricItemGroupBuilder.create(
                    new Identifier(MOD_ID, "soul_combat"))
            .icon(() -> new ItemStack(ModItems.DETERMINATION_SWORD))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(ModItems.DETERMINATION_SWORD));
                stacks.add(new ItemStack(ModItems.FEAR_SCYTHE));
                stacks.add(new ItemStack(ModItems.JUSTICE_PISTOL));
                stacks.add(new ItemStack(ModItems.INTEGRITY_BALLET_SHOES));
                stacks.add(new ItemStack(ModItems.KINDNESS_FRYING_PAN));
                stacks.add(new ItemStack(ModItems.PERSEVERANCE_TORN_NOTEBOOK));
                stacks.add(new ItemStack(ModItems.PATIENCE_TOY_KNIFE));
                stacks.add(new ItemStack(ModItems.BRAVERY_TOUGH_GLOVE));
                stacks.add(new ItemStack(ModItems.SANS_GASTER_BLASTER));
                stacks.add(new ItemStack(ModItems.ASRIEL_CHAOS_SABER));
                stacks.add(new ItemStack(ModItems.DETERMINATION_KNIFE));
            })
            .build();

    //Combat Group

    public static final ItemGroup COMBAT = FabricItemGroupBuilder.create(
                    new Identifier(MOD_ID, "combat"))
            .icon(() -> new ItemStack(ModItems.TITANIUM_QUARTZ_SWORD))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(ModItems.TITANIUM_QUARTZ_SWORD));
                stacks.add(new ItemStack(ModItems.KNIFE));
                stacks.add(new ItemStack(ModItems.DRAGON_SWORD));
            })
            .build();

    //Tools Group

    public static final ItemGroup TOOLS = FabricItemGroupBuilder.create(
                    new Identifier(MOD_ID, "tools"))
            .icon(() -> new ItemStack(ModItems.FLINT_AND_DIAMOND))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(ModItems.FLINT_AND_DIAMOND));
                stacks.add(new ItemStack(ModItems.TITANIUM_QUARTZ_PICKAXE));
                stacks.add(new ItemStack(ModItems.TITANIUM_QUARTZ_AXE));
                stacks.add(new ItemStack(ModItems.TITANIUM_QUARTZ_SHOVEL));
                stacks.add(new ItemStack(ModItems.TITANIUM_QUARTZ_HOE));
                stacks.add(new ItemStack(ModItems.DRAGON_PICKAXE));
                stacks.add(new ItemStack(ModItems.DRAGON_AXE));
                stacks.add(new ItemStack(ModItems.DRAGON_SHOVEL));
                stacks.add(new ItemStack(ModItems.DRAGON_HOE));
            })
            .build();

    //Armor Group

    public static final ItemGroup ARMOR = FabricItemGroupBuilder.create(
                    new Identifier(MOD_ID, "armor"))
            .icon(() -> new ItemStack(ModItems.INVIS_HELMET))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(ModItems.INVIS_HELMET));
                stacks.add(new ItemStack(ModItems.INVIS_CHESTPLATE));
                stacks.add(new ItemStack(ModItems.INVIS_LEGGINGS));
                stacks.add(new ItemStack(ModItems.INVIS_BOOTS));
                stacks.add(new ItemStack(ModItems.TITANIUM_QUARTZ_HELMET));
                stacks.add(new ItemStack(ModItems.TITANIUM_QUARTZ_CHESTPLATE));
                stacks.add(new ItemStack(ModItems.TITANIUM_QUARTZ_LEGGINGS));
                stacks.add(new ItemStack(ModItems.TITANIUM_QUARTZ_BOOTS));
                stacks.add(new ItemStack(ModItems.DRAGON_HELMET));
                stacks.add(new ItemStack(ModItems.DRAGON_CHESTPLATE));
                stacks.add(new ItemStack(ModItems.DRAGON_LEGGINGS));
                stacks.add(new ItemStack(ModItems.DRAGON_BOOTS));
                stacks.add(new ItemStack(ModItems.DRAGON_ELYTRA));
                stacks.add(new ItemStack(ModItems.DRAGON_CHESTPLATE_ELYTRA));
            })
            .build();

    //Spawn Eggs Group
    public static final ItemGroup SPAWN_EGGS = FabricItemGroupBuilder.create(
                    new Identifier(MOD_ID, "spawn_eggs"))
            .icon(() -> new ItemStack(ModItems.CORRUPTION_SPAWN_EGG))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(ModItems.CORRUPTION_SPAWN_EGG));
                stacks.add(new ItemStack(ModItems.HATE_SPAWN_EGG));
                stacks.add(new ItemStack(ModItems.CATBOYMAID_SPAWN_EGG));
                stacks.add(new ItemStack(ModItems.FOUNDERLAB_SPAWN_EGG));
                stacks.add(new ItemStack(ModItems.GOLEM_SOUL_MONSTER_SPAWN_EGG));
            })
            .build();

    //Music Discs Group
    public static final ItemGroup MUSIC = FabricItemGroupBuilder.create(
                    new Identifier(MOD_ID, "music"))
            .icon(() -> new ItemStack(ModItems.MUSIC_DISC_FALLEN_DOWN_REPRISE))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(ModItems.MUSIC_DISC_BLANK));
                stacks.add(new ItemStack(ModItems.MUSIC_DISC_FALLEN_DOWN_REPRISE));
                stacks.add(new ItemStack(ModItems.MUSIC_DISC_FALLEN_PETALS));
                stacks.add(new ItemStack(ModItems.MUSIC_DISC_HOME_EXTENDED));
                stacks.add(new ItemStack(ModItems.MUSIC_DISC_RUINS_EXTENDED));
                stacks.add(new ItemStack(ModItems.MUSIC_DISC_SNOWDIN_EXTENDED));
                stacks.add(new ItemStack(ModItems.MUSIC_DISC_WATERFALL_EXTENDED));
                stacks.add(new ItemStack(ModItems.MUSIC_DISC_UNDERTALE));
                stacks.add(new ItemStack(ModItems.MUSIC_DISC_ANOTHER_MEDIUM));
            })
            .build();


    //Food Item Group
    public static final ItemGroup FOOD = FabricItemGroupBuilder.create(
                    new Identifier(MOD_ID, "food"))
            .icon(() -> new ItemStack(ModItems.BUTTERSCOTCH_PIE))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(ModItems.BUTTERSCOTCH_PIE));
                stacks.add(new ItemStack(ModItems.LEGENDARYHERO));
                stacks.add(new ItemStack(ModItems.GLAMBURGER));
                stacks.add(new ItemStack(ModItems.NICECREAM));
                stacks.add(new ItemStack(ModItems.SNOWMANPIECE));
                stacks.add(new ItemStack(ModItems.SPIDERDONUT));
                stacks.add(new ItemStack(ModItems.MONSTERCANDY));
            })
            .build();

    //Ore Item Group
    public static final ItemGroup ORE = FabricItemGroupBuilder.create(
                    new Identifier(MOD_ID, "ore"))
            .icon(() -> new ItemStack(ModItems.TITANIUM_QUARTZ_INGOT))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(ModItems.TITANIUM_INGOT));
                stacks.add(new ItemStack(ModItems.RAINBOW_QUARTZ));
                stacks.add(new ItemStack(ModItems.TITANIUM_QUARTZ_INGOT));
                stacks.add(new ItemStack(ModItems.DRAGON_INGOT));
                stacks.add(new ItemStack(ModItems.DRAGON_SCALE));
            })
            .build();




    //Effects

    public static final StatusEffect DETERMINED = new DeterminedEffect();

    public static final StatusEffect NOGRAVITY = new NoGravityEffect();
    public static final StatusEffect GRAVITY = new GravityEffect();
    public static final StatusEffect FLY = new FlyEffect();
    public static final StatusEffect NOFLY = new NoFlyEffect();

    public static final StatusEffect DETDAMAGE1 = new DetDamage1Effect();
    public static final StatusEffect JUSDAMAGE1 = new JusDamage1Effect();
    public static final StatusEffect INTDAMAGE1 = new IntDamage1Effect();
    public static final StatusEffect PERDAMAGE1 = new PerDamage1Effect();
    public static final StatusEffect PATDAMAGE1 = new PatDamage1Effect();
    public static final StatusEffect BRADAMAGE1 = new BraDamage1Effect();
    public static final StatusEffect SANSKARMADAMAGE1 = new SansKarmaDamage1Effect();
    public static final StatusEffect ASRIELCHAOSSABERDAMAGE1 = new AsrielChaosSaberDamage1Effect();
    public static final StatusEffect FEADAMAGE1 = new FeaDamage1Effect();
    public static final StatusEffect DESPAIRDAMAGE1 = new DespairDamage1Effect();
    public static final StatusEffect TERDAMAGE1 = new TerDamage1Effect();

    public static final StatusEffect SCARED = new ScaredEffect();
    public static final StatusEffect JUSDEBUFFEFFECT1 = new JusDebuff1Effect();
    public static final StatusEffect INTDEBUFFEFFECT1 = new IntDebuff1Effect();
    public static final StatusEffect PERDEBUFFEFFECT1 = new PerDebuff1Effect();
    public static final StatusEffect PATDEBUFFEFFECT1 = new PatDebuff1Effect();
    public static final StatusEffect BRADEBUFFEFFECT1 = new BraDebuff1Effect();
    public static final StatusEffect KINDEBUFFEFFECT1 = new KinDebuff1Effect();
    public static final StatusEffect CORRUPTIONCORRUPTINGEFFECT1 = new CorruptionCorrupting1Effect();

    public static final StatusEffect JUSTICEEFFECT1 = new Justice1Effect();
    public static final StatusEffect INTEGRITYEFFECT1 = new Integrity1Effect();
    public static final StatusEffect PERSEVERANCEEFFECT1 = new Perseverance1Effect();
    public static final StatusEffect PATIENCEEFFECT1 = new Patience1Effect();
    public static final StatusEffect BRAVERYEFFECT1 = new Bravery1Effect();
    public static final StatusEffect KINDNESSEFFECT1 = new Kindness1Effect();
    public static final StatusEffect KINDNESSEFFECT2 = new Kindness2Effect();
    public static final StatusEffect DETERMINATIONEFFECT1 = new Determination1Effect();
    public static final StatusEffect FEAREFFECT1 = new Fear1Effect();




    //Sounds Music

    public static final Identifier FALLEN_DOWN_REPRISE_ID = new Identifier("uniformsouls:fallendownreprise");
    public static SoundEvent FALLEN_DOWN_REPRISE_EVENT = new SoundEvent(FALLEN_DOWN_REPRISE_ID);

    public static final Identifier FALLEN_PETALS_ID = new Identifier("uniformsouls:fallenpetals");
    public static SoundEvent FALLEN_PETALS_EVENT = new SoundEvent(FALLEN_PETALS_ID);

    public static final Identifier GASTER_VANTABLACK_ID = new Identifier("uniformsouls:gastervantablack");
    public static SoundEvent GASTER_VANTABLACK_EVENT = new SoundEvent(GASTER_VANTABLACK_ID);

    public static final Identifier FRISK_TRUE_LOVE_ID = new Identifier("uniformsouls:frisktruelove");
    public static SoundEvent FRISK_TRUE_LOVE_EVENT = new SoundEvent(FRISK_TRUE_LOVE_ID);

    public static final Identifier MEGALOVANIA_ID = new Identifier("uniformsouls:megalovania");
    public static SoundEvent MEGALOVANIA_EVENT = new SoundEvent(MEGALOVANIA_ID);

    public static final Identifier FLOWERFELL_MEGALOVANIA_ID = new Identifier("uniformsouls:flowerfellmegalovania");
    public static SoundEvent FLOWERFELL_MEGALOVANIA_EVENT = new SoundEvent(FLOWERFELL_MEGALOVANIA_ID);

    public static final Identifier FRISKSTY_ID = new Identifier("uniformsouls:frisksty");
    public static SoundEvent FRISKSTY_EVENT = new SoundEvent(FRISKSTY_ID);

    public static final Identifier MEMORY_ID = new Identifier("uniformsouls:memory");
    public static SoundEvent MEMORY_EVENT = new SoundEvent(MEMORY_ID);

    public static final Identifier WATERFALL_EXTENDED_ID = new Identifier("uniformsouls:waterfall_extended");
    public static SoundEvent WATERFALL_EXTENDED_EVENT = new SoundEvent(WATERFALL_EXTENDED_ID);

    public static final Identifier RUINS_EXTENDED_ID = new Identifier("uniformsouls:ruins_extended");
    public static SoundEvent RUINS_EXTENDED_EVENT = new SoundEvent(RUINS_EXTENDED_ID);

    public static final Identifier HOME_EXTENDED_ID = new Identifier("uniformsouls:home_extended");
    public static SoundEvent HOME_EXTENDED_EVENT = new SoundEvent(HOME_EXTENDED_ID);

    public static final Identifier SNOWDIN_EXTENDED_ID = new Identifier("uniformsouls:snowdin_extended");
    public static SoundEvent SNOWDIN_EXTENDED_EVENT = new SoundEvent(SNOWDIN_EXTENDED_ID);

    public static final Identifier YOURBESTFRIEND_EXTENDED_ID = new Identifier("uniformsouls:yourbestfriend_extended");
    public static SoundEvent YOURBESTFRIEND_EXTENDED_EVENT = new SoundEvent(YOURBESTFRIEND_EXTENDED_ID);

    public static final Identifier DETERMINATION_EXTENDED_ID = new Identifier("uniformsouls:determination_extended");
    public static SoundEvent DETERMINATION_EXTENDED_EVENT = new SoundEvent(DETERMINATION_EXTENDED_ID);

    public static final Identifier BERGENTRUCKUNG_ASGORE_EXTENDED_ID = new Identifier("uniformsouls:bergentruckung_asgore_extended");
    public static SoundEvent BERGENTRUCKUNG_ASGORE_EXTENDED_EVENT = new SoundEvent(BERGENTRUCKUNG_ASGORE_EXTENDED_ID);

    public static final Identifier DUSTTALEMEGALOVANIA_NITRO_ID = new Identifier("uniformsouls:dusttalemegalovania_nitro");
    public static SoundEvent DUSTTALEMEGALOVANIA_NITRO_EVENT = new SoundEvent(DUSTTALEMEGALOVANIA_NITRO_ID);

    public static final Identifier FRISK_TRUE_LOVE_NITRO_ID = new Identifier("uniformsouls:frisktruelove_nitro");
    public static SoundEvent FRISK_TRUE_LOVE_NITRO_EVENT = new SoundEvent(FRISK_TRUE_LOVE_NITRO_ID);

    public static final Identifier UNDERTALE_EXTENDED_ID = new Identifier("uniformsouls:undertale_extended");
    public static SoundEvent UNDERTALE_EXTENDED_EVENT = new SoundEvent(UNDERTALE_EXTENDED_ID);

    public static final Identifier ANOTHER_MEDIUM_ID = new Identifier("uniformsouls:another_medium");
    public static SoundEvent ANOTHER_MEDIUM_EVENT = new SoundEvent(ANOTHER_MEDIUM_ID);




    //Sounds Attacks

    public static final Identifier GASTERBLASTERSOUNDEFFECT_ID = new Identifier("uniformsouls:gasterblastersoundeffect");
    public static SoundEvent GASTERBLASTERSOUNDEFFECT_EVENT = new SoundEvent(GASTERBLASTERSOUNDEFFECT_ID);

    public static final Identifier GASTERBLASTERSOUNDEFFECT_TRIM_ID = new Identifier("uniformsouls:gasterblastersoundeffect_trim");
    public static SoundEvent GASTERBLASTERSOUNDEFFECT_TRIM_EVENT = new SoundEvent(GASTERBLASTERSOUNDEFFECT_TRIM_ID);

    public static final Identifier DETERMINATION_SWORD_SLASH_1_ID = new Identifier("uniformsouls:determination_sword_slash_1");
    public static SoundEvent DETERMINATION_SWORD_SLASH_1_EVENT = new SoundEvent(DETERMINATION_SWORD_SLASH_1_ID);

    public static final Identifier JUSTICE_PISTOL_GUNSHOT_ID = new Identifier("uniformsouls:justice_pistol_gunshot");
    public static SoundEvent JUSTICE_PISTOL_GUNSHOT_EVENT = new SoundEvent(JUSTICE_PISTOL_GUNSHOT_ID);

    public static final Identifier INTEGRITY_SAWBLADE_FIRE_ID = new Identifier("uniformsouls:integrity_sawblade_fire");
    public static SoundEvent INTEGRITY_SAWBLADE_FIRE_EVENT = new SoundEvent(INTEGRITY_SAWBLADE_FIRE_ID);

    public static final Identifier SUMMON_SWORD_OR_SHIELD_1_ID = new Identifier("uniformsouls:summon_sword_or_shield_1");
    public static SoundEvent SUMMON_SWORD_OR_SHIELD_1_EVENT = new SoundEvent(SUMMON_SWORD_OR_SHIELD_1_ID);

    public static final Identifier PERSEVERANCE_LASER_BLAST_ID = new Identifier("uniformsouls:perseverance_laser_blast");
    public static SoundEvent PERSEVERANCE_LASER_BLAST_EVENT = new SoundEvent(PERSEVERANCE_LASER_BLAST_ID);

    public static final Identifier PATIENCE_STRING_THROW_ID = new Identifier("uniformsouls:patience_string_throw");
    public static SoundEvent PATIENCE_STRING_THROW_EVENT = new SoundEvent(PATIENCE_STRING_THROW_ID);

    public static final Identifier ASRIEL_CHAOS_SABER_LIGHTNING_1_ID = new Identifier("uniformsouls:asriel_chaos_saber_lightning_1");
    public static SoundEvent ASRIEL_CHAOS_SABER_LIGHTNING_1_EVENT = new SoundEvent(ASRIEL_CHAOS_SABER_LIGHTNING_1_ID);

    public static final Identifier FEAR_SCYTHE_SLASH_1_ID = new Identifier("uniformsouls:fear_scythe_slash_1");
    public static SoundEvent FEAR_SCYTHE_SLASH_1_EVENT = new SoundEvent(FEAR_SCYTHE_SLASH_1_ID);

    public static final Identifier BONE_SUMMON_1_ID = new Identifier("uniformsouls:bone_summon_1");
    public static SoundEvent BONE_SUMMON_1_EVENT = new SoundEvent(BONE_SUMMON_1_ID);




    //Sounds Entitys

    public static final Identifier MONSTER_GENERIC_DEATH_1_ID = new Identifier("uniformsouls:monster_generic_death_1");
    public static SoundEvent MONSTER_GENERIC_DEATH_1_EVENT = new SoundEvent(MONSTER_GENERIC_DEATH_1_ID);

    public static final Identifier SOUL_GENERIC_SHATTER_1_ID = new Identifier("uniformsouls:soul_generic_shatter_1");
    public static SoundEvent SOUL_GENERIC_SHATTER_1_EVENT = new SoundEvent(SOUL_GENERIC_SHATTER_1_ID);

    public static final Identifier SHADOW_WALKER_1_ID = new Identifier("uniformsouls:shadow_walker_1");
    public static SoundEvent SHADOW_WALKER_1_EVENT = new SoundEvent(SHADOW_WALKER_1_ID);




    //Sounds Items

    public static final Identifier ASRIEL_SOUL_SOUND_1_ID = new Identifier("uniformsouls:asriel_soul_sound_1");
    public static SoundEvent ASRIEL_SOUL_SOUND_1_EVENT = new SoundEvent(ASRIEL_SOUL_SOUND_1_ID);
    public static final Identifier OVERWRITE_SOUL_SOUND_1_ID = new Identifier("uniformsouls:overwrite_soul_sound_1");
    public static SoundEvent OVERWRITE_SOUL_SOUND_1_EVENT = new SoundEvent(OVERWRITE_SOUL_SOUND_1_ID);
    public static final Identifier UNDERTALE_BUTTON_CLICK_SOUND_1_ID = new Identifier("uniformsouls:undertale_button_click_sound_1");
    public static SoundEvent UNDERTALE_BUTTON_CLICK_SOUND_1_EVENT = new SoundEvent(UNDERTALE_BUTTON_CLICK_SOUND_1_ID);
    public static final Identifier UNDERTALE_INTRO_SOUND_1_ID = new Identifier("uniformsouls:undertale_intro_sound_1");
    public static SoundEvent UNDERTALE_INTRO_SOUND_1_EVENT = new SoundEvent(UNDERTALE_INTRO_SOUND_1_ID);



    //Sounds Armors

    public static final Identifier TITANIUM_QUARTZ_ARMOR_EQUIP_1_ID = new Identifier("uniformsouls:titanium_quartz_armor_equip_1");
    public static SoundEvent TITANIUM_QUARTZ_ARMOR_EQUIP_1_EVENT = new SoundEvent(TITANIUM_QUARTZ_ARMOR_EQUIP_1_ID);



    //Sounds Misc

    public static final Identifier WOOSH_NORMAL_OUT_1_ID = new Identifier("uniformsouls:woosh_normal_out_1");
    public static SoundEvent WOOSH_NORMAL_OUT_1_EVENT = new SoundEvent(WOOSH_NORMAL_OUT_1_ID);






    //Entitys

    public static final EntityType<CubeEntity> CUBE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "cube"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CubeEntity::new).dimensions(EntityDimensions.fixed(0.75F, 0.75F)).build());

    public static final EntityType<SkellyEntity> SKELLY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "skelly"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SkellyEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.99F)).build());

    public static final EntityType<HateEntity> HATE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "hate"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HateEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.99F)).build());

    public static final EntityType<CatBoyMaidEntity> CATBOYMAID = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "catboymaid"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CatBoyMaidEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.99F)).build());

    public static final EntityType<FounderLabEntity> FOUNDERLAB = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "founderlab"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, FounderLabEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.99F)).build());

    public static final EntityType<CorruptionEntity> CORRUPTION = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "corruption"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CorruptionEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.99F)).build());

    public static final EntityType<GolemSoulMonsterEntity> GOLEMSOULMONSTER = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "golem_soul_monster"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GolemSoulMonsterEntity::new).dimensions(EntityDimensions.fixed(1.55F, 2.70F)).build());

    public static final EntityType<BoneGroundEntity> BONEGROUND = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "boneground"),
            FabricEntityTypeBuilder.<BoneGroundEntity>create(SpawnGroup.MISC, BoneGroundEntity::new).trackedUpdateRate(2).dimensions(EntityDimensions.fixed(2.5F, 1.75F)).build());

    public static final EntityType<KindnessShield2Entity> KINDNESS_SHIELD2_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "kindness_shield2"),
            FabricEntityTypeBuilder.<KindnessShield2Entity>create(SpawnGroup.CREATURE, KindnessShield2Entity::new).dimensions(EntityDimensions.fixed(2.5F, 3.8F)).build());

    public static final EntityType<WrathShield2Entity> WRATH_SHIELD2_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "wrath_shield2"),
            FabricEntityTypeBuilder.<WrathShield2Entity>create(SpawnGroup.CREATURE, WrathShield2Entity::new).dimensions(EntityDimensions.fixed(2.5F, 3.8F)).build());

    public static final EntityType<SoulDetermination1Entity> SOUL_DETERMINATION_1 = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "soul_determination_1"),
            FabricEntityTypeBuilder.<SoulDetermination1Entity>create(SpawnGroup.CREATURE, SoulDetermination1Entity::new).dimensions(EntityDimensions.fixed(0.5F, 1.5F)).build());

    //Entity Projectiles

    public static final EntityType<DeterminationSwordSlashEntity> DETERMINATION_SWORD_SLASH_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "determination_sword_slash"),
            FabricEntityTypeBuilder.<DeterminationSwordSlashEntity>create(SpawnGroup.MISC, DeterminationSwordSlashEntity::new).dimensions(EntityDimensions.fixed(3.0F, 3.0F)).build());

    public static final EntityType<JusticeBulletEntity> JUSTICE_BULLET_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "justice_bullet"),
            FabricEntityTypeBuilder.<JusticeBulletEntity>create(SpawnGroup.MISC, JusticeBulletEntity::new).dimensions(EntityDimensions.fixed(1.0F, 1.0F)).build());


    public static final EntityType<IntegritySawbladeEntity> INTEGRITY_SAWBLADE_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "integrity_sawblade"),
            FabricEntityTypeBuilder.<IntegritySawbladeEntity>create(SpawnGroup.MISC, IntegritySawbladeEntity::new).dimensions(EntityDimensions.fixed(1.0F, 1.0F)).build());


    public static final EntityType<KindnessShieldEntity> KINDNESS_SHIELD_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "kindness_shield"),
            FabricEntityTypeBuilder.<KindnessShieldEntity>create(SpawnGroup.MISC, KindnessShieldEntity::new).dimensions(EntityDimensions.fixed(2.5F, 3.8F)).build());

    public static final EntityType<PerseveranceLaserEntity> PERSEVERANCE_LASER_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "perseverance_laser"),
            FabricEntityTypeBuilder.<PerseveranceLaserEntity>create(SpawnGroup.MISC, PerseveranceLaserEntity::new).dimensions(EntityDimensions.fixed(2.0F, 2.0F)).build());

    public static final EntityType<PatienceStringEntity> PATIENCE_STRING_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "patience_string"),
            FabricEntityTypeBuilder.<PatienceStringEntity>create(SpawnGroup.MISC, PatienceStringEntity::new).dimensions(EntityDimensions.fixed(1.0F, 1.0F)).build());

    public static final EntityType<BraveryGloveEntity> BRAVERY_GLOVE_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "bravery_glove"),
            FabricEntityTypeBuilder.<BraveryGloveEntity>create(SpawnGroup.MISC, BraveryGloveEntity::new).dimensions(EntityDimensions.fixed(1.0F, 1.0F)).build());

    public static final EntityType<SansGasterBlasterLaserEntity> SANS_GASTER_BLASTER_LASER_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "sans_gaster_blaster_laser"),
            FabricEntityTypeBuilder.<SansGasterBlasterLaserEntity>create(SpawnGroup.MISC, SansGasterBlasterLaserEntity::new).dimensions(EntityDimensions.fixed(1.0F, 1.0F)).build());

    public static final EntityType<AsrielChaosSaberLightningEntity> ASRIEL_CHAOS_SABER_LIGHTNING_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "asriel_chaos_saber_lightning"),
            FabricEntityTypeBuilder.<AsrielChaosSaberLightningEntity>create(SpawnGroup.MISC, AsrielChaosSaberLightningEntity::new).dimensions(EntityDimensions.fixed(1.0F, 1.0F)).build());

    public static final EntityType<FearScytheSlashEntity> FEAR_SCYTHE_SLASH_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "fear_scythe_slash"),
            FabricEntityTypeBuilder.<FearScytheSlashEntity>create(SpawnGroup.MISC, FearScytheSlashEntity::new).dimensions(EntityDimensions.fixed(3.0F, 3.0F)).build());

    public static final EntityType<DespairSwordSlashEntity> DESPAIR_SWORD_SLASH_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "despair_sword_slash"),
            FabricEntityTypeBuilder.<DespairSwordSlashEntity>create(SpawnGroup.MISC, DespairSwordSlashEntity::new).dimensions(EntityDimensions.fixed(3.0F, 3.0F)).build());

    public static final EntityType<ImmoralityBulletEntity> IMMORALITY_BULLET_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "immorality_bullet"),
            FabricEntityTypeBuilder.<ImmoralityBulletEntity>create(SpawnGroup.MISC, ImmoralityBulletEntity::new).dimensions(EntityDimensions.fixed(1.0F, 1.0F)).build());

    public static final EntityType<DeceitSawbladeEntity> DECEIT_SAWBLADE_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "deceit_sawblade"),
            FabricEntityTypeBuilder.<DeceitSawbladeEntity>create(SpawnGroup.MISC, DeceitSawbladeEntity::new).dimensions(EntityDimensions.fixed(1.0F, 1.0F)).build());

    public static final EntityType<ApathyLaserEntity> APATHY_LASER_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "apathy_laser"),
            FabricEntityTypeBuilder.<ApathyLaserEntity>create(SpawnGroup.MISC, ApathyLaserEntity::new).dimensions(EntityDimensions.fixed(2.5F, 3.8F)).build());

    public static final EntityType<RecklessnessStringEntity> RECKLESSNESS_STRING_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "recklessness_string"),
            FabricEntityTypeBuilder.<RecklessnessStringEntity>create(SpawnGroup.MISC, RecklessnessStringEntity::new).dimensions(EntityDimensions.fixed(1.0F, 1.0F)).build());

    public static final EntityType<DishonorGloveEntity> DISHONOR_GLOVE_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "dishonor_glove"),
            FabricEntityTypeBuilder.<DishonorGloveEntity>create(SpawnGroup.MISC, DishonorGloveEntity::new).dimensions(EntityDimensions.fixed(1.0F, 1.0F)).build());

    public static final EntityType<WrathShieldEntity> WRATH_SHIELD_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "wrath_shield"),
            FabricEntityTypeBuilder.<WrathShieldEntity>create(SpawnGroup.MISC, WrathShieldEntity::new).dimensions(EntityDimensions.fixed(2.5F, 3.8F)).build());

    public static final EntityType<TerrorScytheSlashEntity> TERROR_SCYTHE_SLASH_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "terror_scythe_slash"),
            FabricEntityTypeBuilder.<TerrorScytheSlashEntity>create(SpawnGroup.MISC, TerrorScytheSlashEntity::new).dimensions(EntityDimensions.fixed(3.0F, 3.0F)).build());

    public static final EntityType<XCharaKnifeSlashEntity> XCHARA_KNIFE_SLASH_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "xchara_knife_slash"),
            FabricEntityTypeBuilder.<XCharaKnifeSlashEntity>create(SpawnGroup.MISC, XCharaKnifeSlashEntity::new).dimensions(EntityDimensions.fixed(3.0F, 3.0F)).build());

    public static final EntityType<BoneProjEntity> BONE_PROJ_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "bone_proj"),
            FabricEntityTypeBuilder.<BoneProjEntity>create(SpawnGroup.MISC, BoneProjEntity::new).dimensions(EntityDimensions.fixed(1.0F, 1.0F)).build());








    //Entity Misc
    public static final EntityType<LightningRedEntity> LIGHTNINGREDENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "lightningred"),
            FabricEntityTypeBuilder.<LightningRedEntity>create(SpawnGroup.MISC, LightningRedEntity::new).dimensions(EntityDimensions.fixed(1.0F, 1.75F)).disableSaving().build());


    public static final EntityType<UniPlayerEntity> UNIPLAYER = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("uniformsouls", "uniplayer"),
            FabricEntityTypeBuilder.<UniPlayerEntity>create(SpawnGroup.CREATURE, UniPlayerEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.99F)).build());



    //Block Entitys
   /* public static BlockEntityType<JusticeSoulBlockEntity> JUSTICE_SOUL_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier("uniformsouls", "justice_soul_block_entity"),
            FabricBlockEntityTypeBuilder.create(JusticeSoulBlockEntity::new, JUSTICE_SOUL_BLOCK).build(null));


    */


    //Boss



    //Damage Sources

    public static final DamageSource CORRUPTION_DAMAGE = (new UniDamageSource("Corruption_Damage")).setBypassesArmor();

    public static final DamageSource DETERMINATION_SWORD_SLASH_DAMAGE = (new UniDamageSource("Determination_Sword_Slash_Damage")).setBypass();

    public static final DamageSource JUSTICE_BULLET_DAMAGE = (new UniDamageSource("Justice_Bullet_Damage")).setBypass();

    public static final DamageSource INTEGRITY_SAWBLADE_DAMAGE = (new UniDamageSource("Integrity_Sawblade_Damage")).setBypass();

    public static final DamageSource PERSEVERANCE_LASER_DAMAGE = (new UniDamageSource("Perseverance_Laser_Damage")).setBypass();

    public static final DamageSource PATIENCE_STRING_DAMAGE = (new UniDamageSource("Patience_String_Damage")).setBypass();

    public static final DamageSource BRAVERY_GLOVE_DAMAGE = (new UniDamageSource("Bravery_Glove_Damage")).setBypass();

    public static final DamageSource KINDNESS_PAN_DAMAGE = (new UniDamageSource("Kindness_Pan_Damage")).setBypass();

    public static final DamageSource GASTER_BLASTER_SANS_DAMAGE = (new UniDamageSource("Gaster_Blaster_Sans_Damage")).setBypass();

    public static final DamageSource ASRIEL_CHAOS_SABER_DAMAGE = (new UniDamageSource("Asriel_Chaos_Saber_Damage")).setBypass();

    public static final DamageSource FEAR_SCYTHE_SLASH_DAMAGE = (new UniDamageSource("Fear_Scythe_Slash_Damage")).setBypass();

    public static final DamageSource DESPAIR_SWORD_SLASH_DAMAGE = (new UniDamageSource("Despair_Sword_Slash_Damage")).setBypass();

    public static final DamageSource IMMORALITY_BULLET_DAMAGE = (new UniDamageSource("Immorality_Bullet_Damage")).setBypass();

    public static final DamageSource DECEIT_SAWBLADE_DAMAGE = (new UniDamageSource("Deceit_Sawblade_Damage")).setBypass();

    public static final DamageSource APATHY_LASER_DAMAGE = (new UniDamageSource("Apathy_Laser_Damage")).setBypass();

    public static final DamageSource RECKLESSNESS_STRING_DAMAGE = (new UniDamageSource("Recklessness_String_Damage")).setBypass();

    public static final DamageSource DISHONOR_GLOVE_DAMAGE = (new UniDamageSource("Dishonor_Glove_Damage")).setBypass();

    public static final DamageSource WRATH_PAN_DAMAGE = (new UniDamageSource("Wrath_Pan_Damage")).setBypass();

    public static final DamageSource TERROR_SCYTHE_SLASH_DAMAGE = (new UniDamageSource("Terror_Scythe_Slash_Damage")).setBypass();



    //Enchantments

    public static final Enchantment PURE = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier("uniformsouls", "pure"),
            new PureEnchantment()
    );

    public static final Enchantment AUTO_SMELT = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier("uniformsouls", "auto_smelt"),
            new AutoSmeltEnchantment()
    );

    public static final Enchantment HEALTH_BOOST = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier("uniformsouls", "health_boost"),
            new HealthBoostEnchantment()
    );

    public static final Enchantment FORTUNE = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier("uniformsouls", "fortune"),
            new FortuneEnchantment()
    );

    public static final Enchantment SHARPNESS = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier("uniformsouls", "sharpness"),
            new SharpnessEnchantment()
    );

    public static final Enchantment PROTECTION = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier("uniformsouls", "protection"),
            new UniProtectionEnchantment()
    );

    public static final Enchantment EFFICIENCY = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier("uniformsouls", "efficiency"),
            new UniEfficiencyEnchantment()
    );

    public static final Enchantment XP = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier("uniformsouls", "xp"),
            new XpEnchantment()
    );

    //Particles

    public static final DefaultParticleType FLASH_RED = FabricParticleTypes.simple();

    public static final DefaultParticleType FLASH_YELLOW = FabricParticleTypes.simple();

    public static final DefaultParticleType FLASH_BLUE = FabricParticleTypes.simple();

    public static final DefaultParticleType FLASH_GREEN = FabricParticleTypes.simple();

    public static final DefaultParticleType FLASH_PURPLE = FabricParticleTypes.simple();

    public static final DefaultParticleType FLASH_PURPLE_2 = FabricParticleTypes.simple();

    public static final DefaultParticleType FLASH_LIGHT_BLUE = FabricParticleTypes.simple();

    public static final DefaultParticleType FLASH_ORANGE = FabricParticleTypes.simple();

    public static final DefaultParticleType FLASH_WHITE = FabricParticleTypes.simple();

    public static final DefaultParticleType FLASH_PINK = FabricParticleTypes.simple();

    public static final DefaultParticleType FLASH_DESPAIR = FabricParticleTypes.simple();

    public static final DefaultParticleType FLASH_IMMORALITY = FabricParticleTypes.simple();

    public static final DefaultParticleType FLASH_DECEIT = FabricParticleTypes.simple();

    public static final DefaultParticleType FLASH_APATHY = FabricParticleTypes.simple();

    public static final DefaultParticleType FLASH_RECKLESSNESS = FabricParticleTypes.simple();

    public static final DefaultParticleType FLASH_DISHONOR = FabricParticleTypes.simple();

    public static final DefaultParticleType FLASH_WRATH = FabricParticleTypes.simple();

    public static final DefaultParticleType FLASH_TERROR = FabricParticleTypes.simple();

    public static final DefaultParticleType FLASH_OVERWRITE_DETERMINATION = FabricParticleTypes.simple();

    public static final DefaultParticleType SOUL_DETERMINATION = FabricParticleTypes.simple();

    public static final DefaultParticleType SOUL_JUSTICE = FabricParticleTypes.simple();

    public static final DefaultParticleType SOUL_INTEGRITY = FabricParticleTypes.simple();

    public static final DefaultParticleType SOUL_PERSEVERANCE = FabricParticleTypes.simple();

    public static final DefaultParticleType SOUL_PATIENCE = FabricParticleTypes.simple();

    public static final DefaultParticleType SOUL_BRAVERY = FabricParticleTypes.simple();

    public static final DefaultParticleType SOUL_KINDNESS = FabricParticleTypes.simple();

    public static final DefaultParticleType SOUL_MONSTER = FabricParticleTypes.simple();

    public static final DefaultParticleType SOUL_FEAR = FabricParticleTypes.simple();

    public static final DefaultParticleType SOUL_DESPAIR = FabricParticleTypes.simple();

    public static final DefaultParticleType SOUL_IMMORALITY = FabricParticleTypes.simple();

    public static final DefaultParticleType SOUL_DECEIT = FabricParticleTypes.simple();

    public static final DefaultParticleType SOUL_APATHY = FabricParticleTypes.simple();

    public static final DefaultParticleType SOUL_RECKLESSNESS = FabricParticleTypes.simple();

    public static final DefaultParticleType SOUL_DISHONOR = FabricParticleTypes.simple();

    public static final DefaultParticleType SOUL_WRATH = FabricParticleTypes.simple();

    public static final DefaultParticleType SOUL_TERROR = FabricParticleTypes.simple();

    public static final DefaultParticleType SOUL_OVERWRITE_DETERMINATION = FabricParticleTypes.simple();

    public static final DefaultParticleType PERSEVERANCE_LASER_1 = FabricParticleTypes.simple();

    public static final DefaultParticleType APATHY_LASER_1 = FabricParticleTypes.simple();

    public static final DefaultParticleType PATIENCE_STRING_1 = FabricParticleTypes.simple();

    public static final DefaultParticleType RECKLESSNESS_STRING_1 = FabricParticleTypes.simple();

    public static final DefaultParticleType ASRIEL_CHAOS_SABER_LIGHTNING = FabricParticleTypes.simple();




    //Dimensions



    // Structures




    //Biomes

    public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> THE_RUINS_SURFACE_BUILDER = SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(
            ModBlocks.THE_RUINS_GRASS_BLOCK.getDefaultState(),
            ModBlocks.THE_RUINS_DIRT.getDefaultState(),
            Blocks.SAND.getDefaultState()));

    public static final Biome THE_RUINS = createTheRuins();

    public static Biome createTheRuins() {

        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addMonsters(spawnSettings, 0, 0, 0);
        DefaultBiomeFeatures.addFarmAnimals(spawnSettings);

        GenerationSettings.Builder generatorSettings =  new GenerationSettings.Builder();
        generatorSettings.surfaceBuilder(THE_RUINS_SURFACE_BUILDER);
        DefaultBiomeFeatures.addDungeons(generatorSettings);
        DefaultBiomeFeatures.addMineables(generatorSettings);
        DefaultBiomeFeatures.addLandCarvers(generatorSettings);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(generatorSettings);

        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.RAIN)
                .category(Biome.Category.NONE)
                .depth(0.125F)
                .scale(0.05F)
                .temperature(0.5F)
                .downfall(0.4F)
                .effects((new BiomeEffects.Builder())
                        .waterColor(6160505)
                        .waterFogColor(6168185)
                        .fogColor(8021407)
                        .skyColor(8018847)
                        .grassColor(8018833)
                        .foliageColor(8018833)
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generatorSettings.build())
                .build();
    }

    public static final RegistryKey<Biome> THE_RUINS_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier(UniformSouls.MOD_ID, "the_ruins"));

    //Inventory Slots

    @Override
    public void onInitialize() {

        //Geckolib
        GeckoLibMod.DISABLE_IN_DEV = true;
        GeckoLib.initialize();


        //Other


        //Effects

        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "determined"), DETERMINED);

        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "nogravity"), NOGRAVITY);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "gravity"), GRAVITY);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "fly"), FLY);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "nofly"), NOFLY);

        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "detdamage1"), DETDAMAGE1);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "jusdamage1"), JUSDAMAGE1);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "intdamage1"), INTDAMAGE1);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "perdamage1"), PERDAMAGE1);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "patdamage1"), PATDAMAGE1);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "bradamage1"), BRADAMAGE1);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "sanskarmadamage1"), SANSKARMADAMAGE1);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "asrielchaossaberdamage1"), ASRIELCHAOSSABERDAMAGE1);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "feadamage1"), FEADAMAGE1);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "despairdamage1"), DESPAIRDAMAGE1);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "terdamage1"), TERDAMAGE1);

        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "scared"), SCARED);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "jusdebuff1"), JUSDEBUFFEFFECT1);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "intdebuff1"), INTDEBUFFEFFECT1);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "perdebuff1"), PERDEBUFFEFFECT1);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "patdebuff1"), PATDEBUFFEFFECT1);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "bradebuff1"), BRADEBUFFEFFECT1);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "kindebuff1"), KINDEBUFFEFFECT1);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "corruptioncorrupting1"), CORRUPTIONCORRUPTINGEFFECT1);

        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "justice1"), JUSTICEEFFECT1);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "integrity1"), INTEGRITYEFFECT1);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "perseverance1"), PERSEVERANCEEFFECT1);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "patience1"), PATIENCEEFFECT1);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "bravery1"), BRAVERYEFFECT1);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "kindness1"), KINDNESSEFFECT1);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "kindness2"), KINDNESSEFFECT2);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "determination1"), DETERMINATIONEFFECT1);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(UniformSouls.MOD_ID, "fear1"), FEAREFFECT1);





        //Sounds Music

        Registry.register(Registry.SOUND_EVENT, FALLEN_DOWN_REPRISE_ID, FALLEN_DOWN_REPRISE_EVENT);
        Registry.register(Registry.SOUND_EVENT, FALLEN_PETALS_ID, FALLEN_PETALS_EVENT);
        Registry.register(Registry.SOUND_EVENT, GASTER_VANTABLACK_ID, GASTER_VANTABLACK_EVENT);
        Registry.register(Registry.SOUND_EVENT, FRISK_TRUE_LOVE_ID, FRISK_TRUE_LOVE_EVENT);
        Registry.register(Registry.SOUND_EVENT, MEGALOVANIA_ID, MEGALOVANIA_EVENT);
        Registry.register(Registry.SOUND_EVENT, FLOWERFELL_MEGALOVANIA_ID, FLOWERFELL_MEGALOVANIA_EVENT);
        Registry.register(Registry.SOUND_EVENT, FRISKSTY_ID, FRISKSTY_EVENT);
        Registry.register(Registry.SOUND_EVENT, MEMORY_ID, MEMORY_EVENT);
        Registry.register(Registry.SOUND_EVENT, WATERFALL_EXTENDED_ID, WATERFALL_EXTENDED_EVENT);
        Registry.register(Registry.SOUND_EVENT, RUINS_EXTENDED_ID, RUINS_EXTENDED_EVENT);
        Registry.register(Registry.SOUND_EVENT, HOME_EXTENDED_ID, HOME_EXTENDED_EVENT);
        Registry.register(Registry.SOUND_EVENT, SNOWDIN_EXTENDED_ID, SNOWDIN_EXTENDED_EVENT);
        Registry.register(Registry.SOUND_EVENT, YOURBESTFRIEND_EXTENDED_ID, YOURBESTFRIEND_EXTENDED_EVENT);
        Registry.register(Registry.SOUND_EVENT, DETERMINATION_EXTENDED_ID, DETERMINATION_EXTENDED_EVENT);
        Registry.register(Registry.SOUND_EVENT, BERGENTRUCKUNG_ASGORE_EXTENDED_ID, BERGENTRUCKUNG_ASGORE_EXTENDED_EVENT);
        Registry.register(Registry.SOUND_EVENT, DUSTTALEMEGALOVANIA_NITRO_ID, DUSTTALEMEGALOVANIA_NITRO_EVENT);
        Registry.register(Registry.SOUND_EVENT, FRISK_TRUE_LOVE_NITRO_ID, FRISK_TRUE_LOVE_NITRO_EVENT);
        Registry.register(Registry.SOUND_EVENT, UNDERTALE_EXTENDED_ID, UNDERTALE_EXTENDED_EVENT);
        Registry.register(Registry.SOUND_EVENT, ANOTHER_MEDIUM_ID, ANOTHER_MEDIUM_EVENT);




        //Sounds Attacks
        Registry.register(Registry.SOUND_EVENT, GASTERBLASTERSOUNDEFFECT_ID, GASTERBLASTERSOUNDEFFECT_EVENT);
        Registry.register(Registry.SOUND_EVENT, GASTERBLASTERSOUNDEFFECT_TRIM_ID, GASTERBLASTERSOUNDEFFECT_TRIM_EVENT);
        Registry.register(Registry.SOUND_EVENT, DETERMINATION_SWORD_SLASH_1_ID, DETERMINATION_SWORD_SLASH_1_EVENT);
        Registry.register(Registry.SOUND_EVENT, JUSTICE_PISTOL_GUNSHOT_ID, JUSTICE_PISTOL_GUNSHOT_EVENT);
        Registry.register(Registry.SOUND_EVENT, INTEGRITY_SAWBLADE_FIRE_ID, INTEGRITY_SAWBLADE_FIRE_EVENT);
        Registry.register(Registry.SOUND_EVENT, SUMMON_SWORD_OR_SHIELD_1_ID, SUMMON_SWORD_OR_SHIELD_1_EVENT);
        Registry.register(Registry.SOUND_EVENT, PERSEVERANCE_LASER_BLAST_ID, PERSEVERANCE_LASER_BLAST_EVENT);
        Registry.register(Registry.SOUND_EVENT, PATIENCE_STRING_THROW_ID, PATIENCE_STRING_THROW_EVENT);
        Registry.register(Registry.SOUND_EVENT, ASRIEL_CHAOS_SABER_LIGHTNING_1_ID, ASRIEL_CHAOS_SABER_LIGHTNING_1_EVENT);
        Registry.register(Registry.SOUND_EVENT, FEAR_SCYTHE_SLASH_1_ID, FEAR_SCYTHE_SLASH_1_EVENT);
        Registry.register(Registry.SOUND_EVENT, BONE_SUMMON_1_ID, BONE_SUMMON_1_EVENT);





        //Sounds Entitys
        Registry.register(Registry.SOUND_EVENT, MONSTER_GENERIC_DEATH_1_ID, MONSTER_GENERIC_DEATH_1_EVENT);
        Registry.register(Registry.SOUND_EVENT, SOUL_GENERIC_SHATTER_1_ID, SOUL_GENERIC_SHATTER_1_EVENT);
        Registry.register(Registry.SOUND_EVENT, SHADOW_WALKER_1_ID, SHADOW_WALKER_1_EVENT);




        //Sounds Items

        Registry.register(Registry.SOUND_EVENT, ASRIEL_SOUL_SOUND_1_ID, ASRIEL_SOUL_SOUND_1_EVENT);
        Registry.register(Registry.SOUND_EVENT, OVERWRITE_SOUL_SOUND_1_ID, OVERWRITE_SOUL_SOUND_1_EVENT);
        Registry.register(Registry.SOUND_EVENT, UNDERTALE_BUTTON_CLICK_SOUND_1_ID, UNDERTALE_BUTTON_CLICK_SOUND_1_EVENT);
        Registry.register(Registry.SOUND_EVENT, UNDERTALE_INTRO_SOUND_1_ID, UNDERTALE_INTRO_SOUND_1_EVENT);



        //Sounds Armors

        Registry.register(Registry.SOUND_EVENT, TITANIUM_QUARTZ_ARMOR_EQUIP_1_ID, TITANIUM_QUARTZ_ARMOR_EQUIP_1_EVENT);




        //Sounds Misc

        Registry.register(Registry.SOUND_EVENT, WOOSH_NORMAL_OUT_1_ID, WOOSH_NORMAL_OUT_1_EVENT);





        //Portals

        CustomPortalApiRegistry.addPortal(ModBlocks.MONSTER_SOUL_LIGHT_BLOCK1, PortalIgnitionSource.ItemUseSource(ModItems.MONSTER_SOUL), new Identifier("underground", "underground"), 0, 0, 0);
        CustomPortalApiRegistry.addPortal(ModBlocks.SUPERHEATED_OBSIDIAN, PortalIgnitionSource.ItemUseSource(ModItems.FLINT_AND_DIAMOND), new Identifier("netherground", "netherground"), 120, 0, 0);
        CustomPortalApiRegistry.addPortal(ModBlocks.DARK_GLOWSTONE, PortalIgnitionSource.ItemUseSource(ModItems.FLINT_AND_DIAMOND), new Identifier("aboveground", "aboveground"), 255, 255, 255);



        //Entities
        FabricDefaultAttributeRegistry.register(CUBE, CubeEntity.createMobAttributes());

        FabricDefaultAttributeRegistry.register(SKELLY, SkellyEntity.createskellyAttributes());

        FabricDefaultAttributeRegistry.register(HATE, HateEntity.createhateAttributes());

        FabricDefaultAttributeRegistry.register(CATBOYMAID, CatBoyMaidEntity.createcatboymaidAttributes());

        FabricDefaultAttributeRegistry.register(FOUNDERLAB, FounderLabEntity.createfounderlabAttributes());

        FabricDefaultAttributeRegistry.register(FOUNDERLAB, FounderLabEntity.createfounderlabAttributes());

        FabricDefaultAttributeRegistry.register(CORRUPTION, CorruptionEntity.createcorruptionAttributes());

       SpawnRestrictionAccessor.callRegister(UniformSouls.CORRUPTION, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, CorruptionEntity::canMobSpawn);

        SpawnInit.init();

        FabricDefaultAttributeRegistry.register(GOLEMSOULMONSTER, GolemSoulMonsterEntity.creategolemmonstersoulAttributes());

        FabricDefaultAttributeRegistry.register(KINDNESS_SHIELD2_ENTITY, KindnessShield2Entity.createkindnessshieldAttributes());

        FabricDefaultAttributeRegistry.register(BONEGROUND, BoneGroundEntity.createbonegroundAttributes());

        FabricDefaultAttributeRegistry.register(WRATH_SHIELD2_ENTITY, WrathShield2Entity.createwrathshieldAttributes());

        FabricDefaultAttributeRegistry.register(SOUL_DETERMINATION_1, SoulDetermination1Entity.createsoulAttributes());

        FabricDefaultAttributeRegistry.register(UNIPLAYER, UniPlayerEntity.createMobAttributes());



        //Block Entitys



        //Boss






        //Damage Sources


        //Particles

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "flash_red"), FLASH_RED);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "flash_yellow"), FLASH_YELLOW);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "flash_blue"), FLASH_BLUE);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "flash_green"), FLASH_GREEN);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "flash_purple"), FLASH_PURPLE);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "flash_purple_2"), FLASH_PURPLE_2);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "flash_light_blue"), FLASH_LIGHT_BLUE);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "flash_orange"), FLASH_ORANGE);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "flash_white"), FLASH_WHITE);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "flash_pink"), FLASH_PINK);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "flash_despair"), FLASH_DESPAIR);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "flash_immorality"), FLASH_IMMORALITY);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "flash_deceit"), FLASH_DECEIT);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "flash_apathy"), FLASH_APATHY);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "flash_recklessness"), FLASH_RECKLESSNESS);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "flash_dishonor"), FLASH_DISHONOR);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "flash_wrath"), FLASH_WRATH);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "flash_terror"), FLASH_TERROR);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "flash_overwrite_determination"), FLASH_OVERWRITE_DETERMINATION);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "soul_determination"), SOUL_DETERMINATION);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "soul_justice"), SOUL_JUSTICE);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "soul_integrity"), SOUL_INTEGRITY);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "soul_perseverance"), SOUL_PERSEVERANCE);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "soul_patience"), SOUL_PATIENCE);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "soul_bravery"), SOUL_BRAVERY);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "soul_kindness"), SOUL_KINDNESS);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "soul_monster"), SOUL_MONSTER);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "soul_fear"), SOUL_FEAR);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "soul_despair"), SOUL_DESPAIR);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "soul_immorality"), SOUL_IMMORALITY);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "soul_deceit"), SOUL_DECEIT);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "soul_apathy"), SOUL_APATHY);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "soul_recklessness"), SOUL_RECKLESSNESS);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "soul_dishonor"), SOUL_DISHONOR);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "soul_wrath"), SOUL_WRATH);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "soul_terror"), SOUL_TERROR);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "soul_overwrite_determination"), SOUL_OVERWRITE_DETERMINATION);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "perseverance_laser_1"), PERSEVERANCE_LASER_1);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "apathy_laser_1"), APATHY_LASER_1);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "patience_string_1"), PATIENCE_STRING_1);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "recklessness_string_1"), RECKLESSNESS_STRING_1);

        Registry.register(Registry.PARTICLE_TYPE, new Identifier(UniformSouls.MOD_ID, "asriel_chaos_saber_lightning"), ASRIEL_CHAOS_SABER_LIGHTNING);



        //Dimensions



        //Structures


        //Biomes

        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier(UniformSouls.MOD_ID, "the_ruins"), THE_RUINS_SURFACE_BUILDER);
        Registry.register(BuiltinRegistries.BIOME, THE_RUINS_KEY.getValue(), THE_RUINS);

        OverworldBiomes.addContinentalBiome(THE_RUINS_KEY, OverworldClimate.TEMPERATE, 2D);
        OverworldBiomes.addContinentalBiome(THE_RUINS_KEY, OverworldClimate.TEMPERATE, 2D);



    //Classes
        ModItems.registerItems();
        ModBlocks.registerBlocks();



    }
}
