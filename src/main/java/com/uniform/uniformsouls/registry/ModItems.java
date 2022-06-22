package com.uniform.uniformsouls.registry;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.items.*;
import com.uniform.uniformsouls.items.soul_weapons.*;
import com.uniform.uniformsouls.items.souls.*;
import com.uniform.uniformsouls.materials.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {
    //Items

    //Soul Items

    //Block Placement
    //public static final Item JUSTICE_SOUL = new JusticeSoul(ModBlocks.CORRUPTION, new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());
    public static final Item JUSTICE_SOUL = new JusticeSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item KINDNESS_SOUL = new KindnessSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item PERSEVERANCE_SOUL = new PerseveranceSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item BRAVERY_SOUL = new BraverySoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item PATIENCE_SOUL = new PatienceSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item INTEGRITY_SOUL = new IntegritySoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item DETERMINATION_SOUL = new DeterminationSoul(SoulType.DETERMINATION, new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item HATE_SOUL = new HateSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item CORRUPTION_SOUL = new CorruptionSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item FEAR_SOUL = new FearSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item CORRUPTED_DETERMINATION_SOUL = new CorruptedDeterminationSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item EMPTY_DETERMINATION_SOUL = new EmptyDeterminationSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item MONSTER_SOUL = new MonsterSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item ASRIEL_SOUL = new AsrielSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item EMPATHY_SOUL = new EmpathySoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item HUMILITY_SOUL = new HumilitySoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item CONSTANCY_SOUL = new ConstancySoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item DEDICATION_SOUL = new DedicationSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item HEROISM_SOUL = new HeroismSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item HONOR_SOUL = new HonorSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item MERY_SOUL = new MercySoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item DESPAIR_SOUL = new DespairSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item DISHONOR_SOUL = new DishonorSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item IMMORALITY_SOUL = new ImmoralitySoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item WRATH_SOUL = new WrathSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item RECKLESSNESS_SOUL = new RecklessnessSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item DECEIT_SOUL = new DeceitSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item APATHY_SOUL = new ApathySoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item TERROR_SOUL = new TerrorSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item CORRUPTED_MONSTER_SOUL = new CorruptedMonsterSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item OVERWRITE_SOUL = new OverwriteSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item OVERWRITE_DETERMINATION_SOUL = new OverwriteDeterminationSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item DETERMINATION_OVERWRITE_SOUL = new DeterminationOverwriteSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item OG_JUSTICE_SOUL = new OgJusticeSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item EMPTY_SOUL_CONTAINER = new Item(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item OVERWRITE_DETERMINATION_SOUL_2 = new OverwriteDeterminationSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item SKELETON_MONSTER_SOUL = new SkeletonMonsterSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item SPEAR_MONSTER_SOUL = new SpearMonsterSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item FROST_MONSTER_SOUL = new FrostMonsterSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item FLAME_MONSTER_SOUL = new FlameMonsterSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item GHOST_MONSTER_SOUL = new GhostMonsterSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item DEFENSE_MONSTER_SOUL = new DefenseMonsterSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item METALIC_MONSTER_SOUL = new MetalicMonsterSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item MOBILITY_MONSTER_SOUL = new MobilityMonsterSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item MOBILITY_MONSTER_SOUL_2 = new MobilityMonsterSoul2(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item JUSTICE_MONSTER_SOUL = new JusticeMonsterSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item BRAVERY_MONSTER_SOUL = new BraveryMonsterSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());

    public static final Item PATIENCE_MONSTER_SOUL = new PatienceMonsterSoul(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());




    //Button Items
    public static final Item RESET_BUTTON_1 = new ResetButton1(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());
    public static final Item PAUSE_BUTTON_1 = new PauseButton1(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());
    public static final Item ERASE_BUTTON_1 = new EraseButton1(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());
    public static final Item OVERWRITE_BUTTON_1 = new OverwriteButton1(new FabricItemSettings().group(UniformSouls.SOULS).maxCount(1).fireproof());




    //Block Items
    public static final BlockItem CORRUPTION = new BlockItem(ModBlocks.CORRUPTION, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem CHAOTIC_CORRUPTION = new BlockItem(ModBlocks.CHAOTIC_CORRUPTION, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem UNDERGROUND_PORTAL = new BlockItem(ModBlocks.UNDERGROUND_PORTAL, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem NETHERGROUND_PORTAL = new BlockItem(ModBlocks.NETHERGROUND_PORTAL, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem YELLOW_FLOWER_BED = new BlockItem(ModBlocks.YELLOW_FLOWER_BED, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem KINDNESS_SHIELD_BLOCK = new BlockItem(ModBlocks.KINDNESS_SHIELD_BLOCK, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem BARRIER = new BlockItem(ModBlocks.BARRIER, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem OMEGA_STONE_BRICKS1 = new BlockItem(ModBlocks.OMEGA_STONE_BRICKS1, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem SUPERHEATED_OBSIDIAN = new BlockItem(ModBlocks.SUPERHEATED_OBSIDIAN, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem MONSTER_SOUL_LIGHT_BLOCK1 = new BlockItem(ModBlocks.MONSTER_SOUL_LIGHT_BLOCK1, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem KINDNESS_SOUL_LIGHT_BLOCK1 = new BlockItem(ModBlocks.KINDNESS_SOUL_LIGHT_BLOCK1, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem JUSTICE_SOUL_LIGHT_BLOCK1 = new BlockItem(ModBlocks.JUSTICE_SOUL_LIGHT_BLOCK1, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem BRAVERY_SOUL_LIGHT_BLOCK1 = new BlockItem(ModBlocks.BRAVERY_SOUL_LIGHT_BLOCK1, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem PERSEVERANCE_SOUL_LIGHT_BLOCK1 = new BlockItem(ModBlocks.PERSEVERANCE_SOUL_LIGHT_BLOCK1, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem PATIENCE_SOUL_LIGHT_BLOCK1 = new BlockItem(ModBlocks.PATIENCE_SOUL_LIGHT_BLOCK1, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem INTEGRITY_SOUL_LIGHT_BLOCK1 = new BlockItem(ModBlocks.INTEGRITY_SOUL_LIGHT_BLOCK1, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem DETERMINATION_SOUL_LIGHT_BLOCK1 = new BlockItem(ModBlocks.DETERMINATION_SOUL_LIGHT_BLOCK1, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem DARK_GLOWSTONE = new BlockItem(ModBlocks.DARK_GLOWSTONE, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem MENU_BLOCK_BLACK1 = new BlockItem(ModBlocks.MENU_BLOCK_BLACK1, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem MENU_BLOCK_WHITE1 = new BlockItem(ModBlocks.MENU_BLOCK_WHITE1, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem SOUL_CRAFTING_TABLE = new BlockItem(ModBlocks.SOUL_CRAFTING_TABLE, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem THE_RUINS_GRASS_BLOCK = new BlockItem(ModBlocks.THE_RUINS_GRASS_BLOCK, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem THE_RUINS_DIRT = new BlockItem(ModBlocks.THE_RUINS_DIRT, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem TITANIUM_QUARTZ_BLOCK = new BlockItem(ModBlocks.TITANIUM_QUARTZ_BLOCK, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem TITANIUM_BLOCK = new BlockItem(ModBlocks.TITANIUM_BLOCK, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem KINDNESS_SHIELD2_BLOCK = new BlockItem(ModBlocks.KINDNESS_SHIELD2_BLOCK, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem DETERMINATION_SHIELD_BLOCK = new BlockItem(ModBlocks.DETERMINATION_SHIELD_BLOCK, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem AETHER_CLOUD_BLOCK_WHITE_1 = new BlockItem(ModBlocks.AETHER_CLOUD_BLOCK_WHITE_1, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem PURIFIED_CORRUPTION = new BlockItem(ModBlocks.PURIFIED_CORRUPTION, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem DETERMINATION_SHIELD_BLOCK_TO_AIR = new BlockItem(ModBlocks.DETERMINATION_SHIELD_BLOCK_TO_AIR, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem KINDNESS_SHIELD2_BLOCK_TO_AIR = new BlockItem(ModBlocks.KINDNESS_SHIELD2_BLOCK_TO_AIR, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem FEAR_SHIELD_BLOCK = new BlockItem(ModBlocks.FEAR_SHIELD_BLOCK, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem FEAR_SHIELD_BLOCK_TO_AIR = new BlockItem(ModBlocks.FEAR_SHIELD_BLOCK_TO_AIR, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem CORRUPTION_INACTIVE = new BlockItem(ModBlocks.CORRUPTION_INACTIVE, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem CORRUPTION_PORTAL = new BlockItem(ModBlocks.CORRUPTION_PORTAL, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem DESPAIR_SOUL_LIGHT_BLOCK1 = new BlockItem(ModBlocks.DESPAIR_SOUL_LIGHT_BLOCK1, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem IMMORALITY_SOUL_LIGHT_BLOCK1 = new BlockItem(ModBlocks.IMMORALITY_SOUL_LIGHT_BLOCK1, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem DECEIT_SOUL_LIGHT_BLOCK1 = new BlockItem(ModBlocks.DECEIT_SOUL_LIGHT_BLOCK1, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem APATHY_SOUL_LIGHT_BLOCK1 = new BlockItem(ModBlocks.APATHY_SOUL_LIGHT_BLOCK1, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem RECKLESSNESS_SOUL_LIGHT_BLOCK1 = new BlockItem(ModBlocks.RECKLESSNESS_SOUL_LIGHT_BLOCK1, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem DISHONOR_SOUL_LIGHT_BLOCK1 = new BlockItem(ModBlocks.DISHONOR_SOUL_LIGHT_BLOCK1, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem WRATH_SOUL_LIGHT_BLOCK1 = new BlockItem(ModBlocks.WRATH_SOUL_LIGHT_BLOCK1, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem TERROR_SOUL_LIGHT_BLOCK1 = new BlockItem(ModBlocks.TERROR_SOUL_LIGHT_BLOCK1, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem HATE_SOUL_LIGHT_BLOCK1 = new BlockItem(ModBlocks.HATE_SOUL_LIGHT_BLOCK1, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem CORRUPTION_SOUL_LIGHT_BLOCK1 = new BlockItem(ModBlocks.CORRUPTION_SOUL_LIGHT_BLOCK1, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem HOPE_SOUL_LIGHT_BLOCK1 = new BlockItem(ModBlocks.HOPE_SOUL_LIGHT_BLOCK1, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem FEAR_SOUL_LIGHT_BLOCK1 = new BlockItem(ModBlocks.FEAR_SOUL_LIGHT_BLOCK1, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem CORRUPTED_MONSTER_SOUL_LIGHT_BLOCK1 = new BlockItem(ModBlocks.CORRUPTED_MONSTER_SOUL_LIGHT_BLOCK1, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem AETHER_CLOUD_BLOCK_CYAN_1 = new BlockItem(ModBlocks.AETHER_CLOUD_BLOCK_CYAN_1, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem THE_BENEATH_PORTAL = new BlockItem(ModBlocks.THE_BENEATH_PORTAL, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem STATUE_PLAYER_1 = new BlockItem(ModBlocks.STATUE_PLAYER_1, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem OMEGA_PORTAL_1 = new BlockItem(ModBlocks.OMEGA_PORTAL_1, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem DRAGON_BLOCK = new BlockItem(ModBlocks.DRAGON_BLOCK, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem OVERWRITE_DETERMINATION_SOUL_LIGHT_BLOCK1 = new BlockItem(ModBlocks.OVERWRITE_DETERMINATION_SOUL_LIGHT_BLOCK1, new Item.Settings().group(UniformSouls.BLOCKS).fireproof());
    public static final BlockItem TEAL_FLOWER_BED = new BlockItem(ModBlocks.TEAL_FLOWER_BED, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem RED_FLOWER_BED = new BlockItem(ModBlocks.RED_FLOWER_BED, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem DEEPSLATE = new BlockItem(ModBlocks.DEEPSLATE, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem COBBLED_DEEPSLATE = new BlockItem(ModBlocks.COBBLED_DEEPSLATE, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem POLISHED_DEEPSLATE = new BlockItem(ModBlocks.POLISHED_DEEPSLATE, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem DEEPSLATE_BRICKS = new BlockItem(ModBlocks.DEEPSLATE_BRICKS, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem DEEPSLATE_TILES = new BlockItem(ModBlocks.DEEPSLATE_TILES, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem CHISELED_DEEPSLATE = new BlockItem(ModBlocks.CHISELED_DEEPSLATE, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem CRACKED_DEEPSLATE_BRICKS = new BlockItem(ModBlocks.CRACKED_DEEPSLATE_BRICKS, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem CRACKED_DEEPSLATE_TILES = new BlockItem(ModBlocks.CRACKED_DEEPSLATE_TILES, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem COBBLED_DEEPSLATE_SLAB = new BlockItem(ModBlocks.COBBLED_DEEPSLATE_SLAB, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem DEEPSLATE_BRICK_SLAB = new BlockItem(ModBlocks.DEEPSLATE_BRICK_SLAB, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem POLISHED_DEEPSLATE_SLAB = new BlockItem(ModBlocks.POLISHED_DEEPSLATE_SLAB, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem DEEPSLATE_TILE_SLAB = new BlockItem(ModBlocks.DEEPSLATE_TILE_SLAB, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem COBBLED_DEEPSLATE_STAIRS = new BlockItem(ModBlocks.COBBLED_DEEPSLATE_STAIRS, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem DEEPSLATE_BRICK_STAIRS = new BlockItem(ModBlocks.DEEPSLATE_BRICK_STAIRS, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem DEEPSLATE_TILE_STAIRS = new BlockItem(ModBlocks.DEEPSLATE_TILE_STAIRS, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem POLISHED_DEEPSLATE_STAIRS = new BlockItem(ModBlocks.POLISHED_DEEPSLATE_STAIRS, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem COBBLED_DEEPSLATE_WALL = new BlockItem(ModBlocks.COBBLED_DEEPSLATE_WALL, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem DEEPSLATE_BRICK_WALL = new BlockItem(ModBlocks.DEEPSLATE_BRICK_WALL, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem DEEPSLATE_TILE_WALL = new BlockItem(ModBlocks.DEEPSLATE_TILE_WALL, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem POLISHED_DEEPSLATE_WALL = new BlockItem(ModBlocks.POLISHED_DEEPSLATE_WALL, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem UNI_LIGHT_BLOCK = new BlockItem(ModBlocks.UNI_LIGHT_BLOCK, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem START_GRASS = new BlockItem(ModBlocks.START_GRASS, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem START_PATH_1 = new BlockItem(ModBlocks.START_PATH_1, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem START_PATH_2 = new BlockItem(ModBlocks.START_PATH_2, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem START_PATH_3 = new BlockItem(ModBlocks.START_PATH_3, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem RUINS_BRICKS = new BlockItem(ModBlocks.RUINS_BRICKS, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem RUINS_BRICKS_2 = new BlockItem(ModBlocks.RUINS_BRICKS_2, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem PATH_R_1 = new BlockItem(ModBlocks.PATH_R_1, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem PATH_R_2 = new BlockItem(ModBlocks.PATH_R_2, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem PATH_R_3 = new BlockItem(ModBlocks.PATH_R_3, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem RED_LEAVES = new BlockItem(ModBlocks.RED_LEAVES, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem SNOWDIN_GRASS = new BlockItem(ModBlocks.SNOWDIN_GRASS, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem SNOWDIN_DIRT = new BlockItem(ModBlocks.SNOWDIN_DIRT, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem SNOWDIN_PATH_1 = new BlockItem(ModBlocks.SNOWDIN_PATH_1, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem WATERFALL_GROUND = new BlockItem(ModBlocks.WATERFALL_GROUND, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem WATERFALL_WALL_1 = new BlockItem(ModBlocks.WATERFALL_WALL_1, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem WATERFALL_WALL_2 = new BlockItem(ModBlocks.WATERFALL_WALL_2, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem HOTLAND_GROUND = new BlockItem(ModBlocks.HOTLAND_GROUND, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem HOTLAND_GROUND_CRACK = new BlockItem(ModBlocks.HOTLAND_GROUND_CRACK, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem HOTLAND_PIPE_TURN = new BlockItem(ModBlocks.HOTLAND_PIPE_TURN, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem HOTLAND_PIPE_STRAIGHT = new BlockItem(ModBlocks.HOTLAND_PIPE_STRAIGHT, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem HOTLAND_PIPE_TURN_2 = new BlockItem(ModBlocks.HOTLAND_PIPE_TURN_2, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem HOTLAND_PIPE_STRAIGHT_2 = new BlockItem(ModBlocks.HOTLAND_PIPE_STRAIGHT_2, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem HOTLAND_ARROW = new BlockItem(ModBlocks.HOTLAND_ARROW, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem NH_WALL = new BlockItem(ModBlocks.NH_WALL, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem NH_GROUND = new BlockItem(ModBlocks.NH_GROUND, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem GRAY_LEAVES = new BlockItem(ModBlocks.GRAY_LEAVES, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem LEAVES_1 = new BlockItem(ModBlocks.LEAVES_1, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem HOTLAND_CONVEYOR = new BlockItem(ModBlocks.HOTLAND_CONVEYOR, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem TL_GROUND = new BlockItem(ModBlocks.TL_GROUND, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem TL_WALL_1 = new BlockItem(ModBlocks.TL_WALL_1, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem TL_WALL_2 = new BlockItem(ModBlocks.TL_WALL_2, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem NH_GROUND_2 = new BlockItem(ModBlocks.NH_GROUND_2, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem NH_GROUND_3 = new BlockItem(ModBlocks.NH_GROUND_3, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem BLACK_1 = new BlockItem(ModBlocks.BLACK_1, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_PIPE = new BlockItem(ModBlocks.C_PIPE, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_PIPE_DAMAGED = new BlockItem(ModBlocks.C_PIPE_DAMAGED, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_PIPE_END = new BlockItem(ModBlocks.C_PIPE_END, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_PIPE_START = new BlockItem(ModBlocks.C_PIPE_START, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_PIPE_2 = new BlockItem(ModBlocks.C_PIPE_2, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_WIRE_1 = new BlockItem(ModBlocks.C_WIRE_1, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_WIRE_2 = new BlockItem(ModBlocks.C_WIRE_2, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_WIRE_3 = new BlockItem(ModBlocks.C_WIRE_3, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_WIRE_4 = new BlockItem(ModBlocks.C_WIRE_4, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_WALL_1 = new BlockItem(ModBlocks.C_WALL_1, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_WALL_2 = new BlockItem(ModBlocks.C_WALL_2, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_WALL_3 = new BlockItem(ModBlocks.C_WALL_3, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_WALL_4 = new BlockItem(ModBlocks.C_WALL_4, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_GROUND_1 = new BlockItem(ModBlocks.C_GROUND_1, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_VOID = new BlockItem(ModBlocks.C_VOID, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem WATERFALL_TALL_GRASS = new BlockItem(ModBlocks.WATERFALL_TALL_GRASS, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem WATERFALL_GRASS = new BlockItem(ModBlocks.WATERFALL_GRASS, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem WATERFALL_MUSHROOMS = new BlockItem(ModBlocks.WATERFALL_MUSHROOMS, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem WATERFALL_CRYSTALS_1 = new BlockItem(ModBlocks.WATERFALL_CRYSTALS_1, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem WATERFALL_CRYSTALS_2 = new BlockItem(ModBlocks.WATERFALL_CRYSTALS_2, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem WATERFALL_CRYSTALS_3 = new BlockItem(ModBlocks.WATERFALL_CRYSTALS_3, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem WATERFALL_CRYSTALS_4 = new BlockItem(ModBlocks.WATERFALL_CRYSTALS_4, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem WATERFALL_GROUND_CRACKED = new BlockItem(ModBlocks.WATERFALL_GROUND_CRACKED, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem WATERFALL_GROUND_2 = new BlockItem(ModBlocks.WATERFALL_GROUND_2, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem WATERFALL_GROUND_3 = new BlockItem(ModBlocks.WATERFALL_GROUND_3, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem WATERFALL_GROUND_4 = new BlockItem(ModBlocks.WATERFALL_GROUND_4, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem WATERFALL_GROUND_5 = new BlockItem(ModBlocks.WATERFALL_GROUND_5, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem WATERFALL_WATER = new BlockItem(ModBlocks.WATERFALL_WATER, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem ECHO_FLOWER = new BlockItem(ModBlocks.ECHO_FLOWER, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem SNOWDIN_FLOWER = new BlockItem(ModBlocks.SNOWDIN_FLOWER, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem WATERFALL_WOOD_SLAB = new BlockItem(ModBlocks.WATERFALL_WOOD_SLAB, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem WATERFALL_WOOD_WALL = new BlockItem(ModBlocks.WATERFALL_WOOD_WALL, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem WATERFALL_WOOD_SLAB_2 = new BlockItem(ModBlocks.WATERFALL_WOOD_SLAB_2, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem WATERFALL_WOOD_WALL_2 = new BlockItem(ModBlocks.WATERFALL_WOOD_WALL_2, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_WIRE_PLATE = new BlockItem(ModBlocks.C_WIRE_PLATE, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_GLASS = new BlockItem(ModBlocks.C_GLASS, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_GLASS_2 = new BlockItem(ModBlocks.C_GLASS_2, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_BRIDGE_LEFT = new BlockItem(ModBlocks.C_BRIDGE_LEFT, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_BRIDGE_RIGHT = new BlockItem(ModBlocks.C_BRIDGE_RIGHT, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem HOTLAND_WIRE = new BlockItem(ModBlocks.HOTLAND_WIRE, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_WIRE_5 = new BlockItem(ModBlocks.C_WIRE_5, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_WIRE_6 = new BlockItem(ModBlocks.C_WIRE_6, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_WIRE_PLATE_2 = new BlockItem(ModBlocks.C_WIRE_PLATE_2, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem ARCH_PURPLE_1 = new BlockItem(ModBlocks.ARCH_PURPLE_1, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem ARCH_PURPLE_2 = new BlockItem(ModBlocks.ARCH_PURPLE_2, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem ARCH_GRAY_1 = new BlockItem(ModBlocks.ARCH_GRAY_1, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem ARCH_GRAY_2 = new BlockItem(ModBlocks.ARCH_GRAY_2, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem LAB_WALL = new BlockItem(ModBlocks.LAB_WALL, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem LAB_GROUND = new BlockItem(ModBlocks.LAB_GROUND, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem LAB_GROUND_2 = new BlockItem(ModBlocks.LAB_GROUND_2, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem VINE = new BlockItem(ModBlocks.VINE, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem RED_LEAVES_CARPET = new BlockItem(ModBlocks.RED_LEAVES_CARPET, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem GREY_LEAVES_CARPET = new BlockItem(ModBlocks.GREY_LEAVES_CARPET, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem SPIKES_1 = new BlockItem(ModBlocks.SPIKES_1, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem SPIKES_2 = new BlockItem(ModBlocks.SPIKES_2, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_CARPET = new BlockItem(ModBlocks.C_CARPET, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_WIRE_WALL = new BlockItem(ModBlocks.C_WIRE_WALL, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_WIRE_7 = new BlockItem(ModBlocks.C_WIRE_7, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_WIRE_8 = new BlockItem(ModBlocks.C_WIRE_8, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_BRIDGE_LEFT_2 = new BlockItem(ModBlocks.C_BRIDGE_LEFT_2, new Item.Settings().group(UniformSouls.BLOCKS));
    public static final BlockItem C_BRIDGE_RIGHT_2 = new BlockItem(ModBlocks.C_BRIDGE_RIGHT_2, new Item.Settings().group(UniformSouls.BLOCKS));





    //Tool Items
    public static final Item FLINT_AND_DIAMOND = new FlintAndSteelItem(new FabricItemSettings().group(UniformSouls.TOOLS).maxDamage(100));
    public static final ToolItem TITANIUM_QUARTZ_PICKAXE = new TitaniumQuartzPickaxe(TitaniumQuartzToolMaterial.INSTANCE, 1, -2.8F, new Item.Settings().group(UniformSouls.TOOLS).fireproof());
    public static final ToolItem TITANIUM_QUARTZ_AXE = new TitaniumQuartzAxe(TitaniumQuartzToolMaterial.INSTANCE, 5, -3.2F, new Item.Settings().group(UniformSouls.TOOLS).fireproof());
    public static final ToolItem TITANIUM_QUARTZ_SHOVEL = new TitaniumQuartzShovel(TitaniumQuartzToolMaterial.INSTANCE, 1, -3.0F, new Item.Settings().group(UniformSouls.TOOLS).fireproof());
    public static final ToolItem TITANIUM_QUARTZ_HOE = new TitaniumQuartzHoe(TitaniumQuartzToolMaterial.INSTANCE, -4, 0.0F, new Item.Settings().group(UniformSouls.TOOLS).fireproof());
    public static final ToolItem DRAGON_PICKAXE = new UniPickaxeItem(DragonToolMaterial.INSTANCE, 1, -2.8F, new Item.Settings().group(UniformSouls.TOOLS).fireproof().rarity(Rarity.EPIC));
    public static final ToolItem DRAGON_AXE = new UniAxeItem(DragonToolMaterial.INSTANCE, 6, -3.2F, new Item.Settings().group(UniformSouls.TOOLS).fireproof().rarity(Rarity.EPIC));
    public static final ToolItem DRAGON_SHOVEL = new UniShovelItem(DragonToolMaterial.INSTANCE, 1, -3.0F, new Item.Settings().group(UniformSouls.TOOLS).fireproof().rarity(Rarity.EPIC));
    public static final ToolItem DRAGON_HOE = new UniHoeItem(DragonToolMaterial.INSTANCE, -4, 0.0F, new Item.Settings().group(UniformSouls.TOOLS).fireproof().rarity(Rarity.EPIC));




    //Soul-Weapon-Combat Items
    public static final ToolItem DETERMINATION_SWORD = new DeterminationSword(DefaultSoulToolMaterial.INSTANCE, 14, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem FEAR_SCYTHE = new FearScythe(DefaultSoulToolMaterial.INSTANCE, 14, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem JUSTICE_PISTOL = new JusticePistol(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem INTEGRITY_BALLET_SHOES = new IntegrityBalletShoes(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem KINDNESS_FRYING_PAN = new KindnessFryingPan(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem PERSEVERANCE_TORN_NOTEBOOK = new PerseveranceTornNotebook(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem PATIENCE_TOY_KNIFE = new PatienceToyKnife(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem BRAVERY_TOUGH_GLOVE = new BraveryToughGlove(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem SANS_GASTER_BLASTER = new SansGasterBlaster(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem ASRIEL_CHAOS_SABER = new AsrielChaosSaber(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem DETERMINATION_KNIFE = new DeterminationKnife(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem HATE_SWORD = new DeterminationSword(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem HATE_SCYTHE = new FearScythe(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem HATE_PISTOL = new JusticePistol(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem HATE_BALLET_SHOES = new IntegrityBalletShoes(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem HATE_FRYING_PAN = new KindnessFryingPan(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem HATE_TORN_NOTEBOOK = new PerseveranceTornNotebook(DefaultSoulToolMaterial.INSTANCE, 4, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem HATE_TOY_KNIFE = new PatienceToyKnife(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem HATE_TOUGH_GLOVE = new BraveryToughGlove(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem DESPAIR_SWORD = new DespairSword(DefaultSoulToolMaterial.INSTANCE, 19, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem IMMORALITY_SHOTGUN = new ImmoralityShotgun(DefaultSoulToolMaterial.INSTANCE, 14, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem DECEIT_TENNIS_SHOE = new DeceitTennisShoe(DefaultSoulToolMaterial.INSTANCE, 14, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem APATHY_CARELESS_JOURNAL = new ApathyCarelessJournal(DefaultSoulToolMaterial.INSTANCE, 14, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem RECKLESSNESS_BALLISTIC_KNIFE = new RecklessnessBallisticKnife(DefaultSoulToolMaterial.INSTANCE, 14, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem DISHONOR_STURDY_GLOVE = new DishonorSturdyGlove(DefaultSoulToolMaterial.INSTANCE, 14, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem WRATH_DOUBLE_FRYING_PAN = new WrathDoubleFryingPan(DefaultSoulToolMaterial.INSTANCE, 14, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem TERROR_SCYTHE = new TerrorScythe(DefaultSoulToolMaterial.INSTANCE, 19, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem XCHARA_KNIFE = new XCharaKnife(DefaultSoulToolMaterial.INSTANCE, 15, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem XCHARA_KNIFE_2 = new XCharaKnife(DefaultSoulToolMaterial.INSTANCE, 15, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem SKELETON_BONE_1 = new SkeletonBone1(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem SPEAR_1 = new Spear1(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem FROST_BOMB_1 = new FrostBomb1(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem FLAME_STAFF_1 = new FlameStaff1(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem GHOST_WEAPON_1 = new GhostWeapon1(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem MONSTER_SHIELD_1 = new MonsterShield1(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem ENERGY_BEAM_1 = new EnergyBeam1(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem ANCIENT_TOME = new AncientTome(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem DIRTY_SHOES = new DirtyShoes(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem EMPTY_GUN = new EmptyGun(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem DURABLE_GLOVE = new DurableGlove(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem STOIC_KNIFE = new StoicKnife(DefaultSoulToolMaterial.INSTANCE, 9, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());




    //Weapon-Combat Items
    public static final ToolItem KNIFE = new SwordItem(KnifeMaterial.INSTANCE, -1, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem TITANIUM_QUARTZ_SWORD = new TitaniumQuartzSword(TitaniumQuartzToolMaterial.INSTANCE, 3, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof());
    public static final ToolItem DRAGON_SWORD = new SwordItem(DragonToolMaterial.INSTANCE, 4, -2.4F, new Item.Settings().group(UniformSouls.COMBAT).fireproof().rarity(Rarity.EPIC));





    //Armor Items
    public static final ArmorItem INVIS_HELMET = new ArmorItem(InvisArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings().group(UniformSouls.ARMOR));
    public static final ArmorItem INVIS_CHESTPLATE = new ArmorItem(InvisArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().group(UniformSouls.ARMOR));
    public static final ArmorItem INVIS_LEGGINGS = new ArmorItem(InvisArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings().group(UniformSouls.ARMOR));
    public static final ArmorItem INVIS_BOOTS = new ArmorItem(InvisArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Item.Settings().group(UniformSouls.ARMOR));
    public static final ArmorItem HEART_LOCKET = new ArmorItem(HeartLocketArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().group(UniformSouls.ARMOR));
    public static final ArmorItem TITANIUM_QUARTZ_HELMET = new ArmorItem(TitaniumQuartzArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings().group(UniformSouls.ARMOR).fireproof());
    public static final ArmorItem TITANIUM_QUARTZ_CHESTPLATE = new ArmorItem(TitaniumQuartzArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().group(UniformSouls.ARMOR).fireproof());
    public static final ArmorItem TITANIUM_QUARTZ_LEGGINGS = new ArmorItem(TitaniumQuartzArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings().group(UniformSouls.ARMOR).fireproof());
    public static final ArmorItem TITANIUM_QUARTZ_BOOTS = new ArmorItem(TitaniumQuartzArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Item.Settings().group(UniformSouls.ARMOR).fireproof());
    public static final ArmorItem QUANTUM_HELMET = new ArmorItem(QuantumArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings().group(UniformSouls.ARMOR).fireproof());
    public static final ArmorItem QUANTUM_CHESTPLATE = new ArmorItem(QuantumArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().group(UniformSouls.ARMOR).fireproof());
    public static final ArmorItem QUANTUM_LEGGINGS = new ArmorItem(QuantumArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings().group(UniformSouls.ARMOR).fireproof());
    public static final ArmorItem QUANTUM_BOOTS = new ArmorItem(QuantumArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Item.Settings().group(UniformSouls.ARMOR).fireproof());
    public static final ArmorItem DRAGON_HELMET = new ArmorItem(DragonArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings().group(UniformSouls.ARMOR).fireproof().rarity(Rarity.EPIC));
    public static final ArmorItem DRAGON_CHESTPLATE = new ArmorItem(DragonArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().group(UniformSouls.ARMOR).fireproof().rarity(Rarity.EPIC));
    public static final ArmorItem DRAGON_LEGGINGS = new ArmorItem(DragonArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings().group(UniformSouls.ARMOR).fireproof().rarity(Rarity.EPIC));
    public static final ArmorItem DRAGON_BOOTS = new ArmorItem(DragonArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Item.Settings().group(UniformSouls.ARMOR).fireproof().rarity(Rarity.EPIC));


    //Elytras
    public static final DragonElytra DRAGON_ELYTRA = new DragonElytra((new Item.Settings().group(UniformSouls.ARMOR).fireproof().maxCount(1).maxDamage(1024).rarity(Rarity.EPIC)));
    public static final ArmorItem DRAGON_CHESTPLATE_ELYTRA = new ArmorItem(DragonArmorMaterial.INSTANCE, EquipmentSlot.CHEST, (new Item.Settings().group(UniformSouls.ARMOR).fireproof().rarity(Rarity.EPIC)));


    //Spawn Eggs
    public static final Item HATE_SPAWN_EGG = new SpawnEggItem(UniformSouls.HATE, 1315860, 13894695, new FabricItemSettings().group(UniformSouls.SPAWN_EGGS));
    public static final Item CATBOYMAID_SPAWN_EGG = new SpawnEggItem(UniformSouls.CATBOYMAID, 16777215, 13894695, new FabricItemSettings().group(UniformSouls.SPAWN_EGGS));
    public static final Item FOUNDERLAB_SPAWN_EGG = new SpawnEggItem(UniformSouls.FOUNDERLAB, 16777215, 3957587, new FabricItemSettings().group(UniformSouls.SPAWN_EGGS));
    public static final Item CORRUPTION_SPAWN_EGG = new SpawnEggItem(UniformSouls.CORRUPTION, 1315860, 1973790, new FabricItemSettings().group(UniformSouls.SPAWN_EGGS));
    public static final Item GOLEM_SOUL_MONSTER_SPAWN_EGG = new SpawnEggItem(UniformSouls.GOLEMSOULMONSTER, 1315860, 16777215, new FabricItemSettings().group(UniformSouls.SPAWN_EGGS));





    //Music Discs
    public static final Item MUSIC_DISC_BLANK = new Item(new Item.Settings().group(UniformSouls.MUSIC).maxCount(1));
    public static final Item MUSIC_DISC_FALLEN_DOWN_REPRISE = new MusicDisc(1, UniformSouls.FALLEN_DOWN_REPRISE_EVENT, new Item.Settings().group(UniformSouls.MUSIC).maxCount(1));
    public static final Item MUSIC_DISC_FALLEN_PETALS = new MusicDisc(2, UniformSouls.FALLEN_PETALS_EVENT, new Item.Settings().group(UniformSouls.MUSIC).maxCount(1));
    public static final Item MUSIC_DISC_HOME_EXTENDED = new MusicDisc(3, UniformSouls.HOME_EXTENDED_EVENT, new Item.Settings().group(UniformSouls.MUSIC).maxCount(1));
    public static final Item MUSIC_DISC_RUINS_EXTENDED = new MusicDisc(4, UniformSouls.RUINS_EXTENDED_EVENT, new Item.Settings().group(UniformSouls.MUSIC).maxCount(1));
    public static final Item MUSIC_DISC_SNOWDIN_EXTENDED = new MusicDisc(5, UniformSouls.SNOWDIN_EXTENDED_EVENT, new Item.Settings().group(UniformSouls.MUSIC).maxCount(1));
    public static final Item MUSIC_DISC_WATERFALL_EXTENDED = new MusicDisc(6, UniformSouls.WATERFALL_EXTENDED_EVENT, new Item.Settings().group(UniformSouls.MUSIC).maxCount(1));
    public static final Item MUSIC_DISC_UNDERTALE = new MusicDisc(7, UniformSouls.UNDERTALE_EXTENDED_EVENT, new Item.Settings().group(UniformSouls.MUSIC).maxCount(1));
    public static final Item MUSIC_DISC_ANOTHER_MEDIUM = new MusicDisc(8, UniformSouls.ANOTHER_MEDIUM_EVENT, new Item.Settings().group(UniformSouls.MUSIC).maxCount(1));





    //Food Items
    public static final Item BUTTERSCOTCH_PIE = new Item(new Item.Settings().group(UniformSouls.FOOD).food(UniFoodComponents.BUTTERSCOTCH_PIE).maxCount(1));
    public static final Item LEGENDARYHERO = new Item(new Item.Settings().group(UniformSouls.FOOD).food(UniFoodComponents.LEGENDARYHERO).maxCount(1));
    public static final Item GLAMBURGER = new Item(new Item.Settings().group(UniformSouls.FOOD).food(UniFoodComponents.GLAMBURGER).maxCount(1));
    public static final Item NICECREAM = new Item(new Item.Settings().group(UniformSouls.FOOD).food(UniFoodComponents.NICECREAM).maxCount(1));
    public static final Item SNOWMANPIECE = new Item(new Item.Settings().group(UniformSouls.FOOD).food(UniFoodComponents.SNOWMANPIECE).maxCount(1));
    public static final Item SPIDERDONUT = new Item(new Item.Settings().group(UniformSouls.FOOD).food(UniFoodComponents.SPIDERDONUT).maxCount(1));
    public static final Item MONSTERCANDY = new Item(new Item.Settings().group(UniformSouls.FOOD).food(UniFoodComponents.MONSTERCANDY).maxCount(1));




    //Ore Items
    public static final Item TITANIUM_QUARTZ_INGOT = new TitaniumQuartzIngot(new FabricItemSettings().group(UniformSouls.ORE).fireproof());
    public static final Item RAINBOW_QUARTZ = new RainbowQuartz(new FabricItemSettings().group(UniformSouls.ORE));
    public static final Item TITANIUM_INGOT = new Item(new Item.Settings().group(UniformSouls.ORE).fireproof());
    public static final Item DRAGON_INGOT = new Item(new Item.Settings().group(UniformSouls.ORE).fireproof());


    //Misc
    public static final Item QUANTUM_STABILIZER = new Item(new Item.Settings().group(UniformSouls.ORE).fireproof());
    public static final Item DRAGON_SCALE = new Item(new Item.Settings().group(UniformSouls.ORE).fireproof());
    public static final Item WITHER_ESSENCE = new Item(new Item.Settings().group(UniformSouls.ORE).fireproof());


    //Images
    public static final Item CORRUPTED_NEXUS_LOGO_1 = new Item(new FabricItemSettings().group(UniformSouls.ORE).fireproof());







    public  static  void registerItems() {

        //Items

        //Soul Items
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "justice_soul"), JUSTICE_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "kindness_soul"), KINDNESS_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "patience_soul"), PATIENCE_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "perseverance_soul"), PERSEVERANCE_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "bravery_soul"), BRAVERY_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "integrity_soul"), INTEGRITY_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "determination_soul"), DETERMINATION_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "hate_soul"), HATE_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "fear_soul"), FEAR_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "corrupted_determination_soul"), CORRUPTED_DETERMINATION_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "empty_determination_soul"), EMPTY_DETERMINATION_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "corruption_soul"), CORRUPTION_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "monster_soul"), MONSTER_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "asriel_soul"), ASRIEL_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "empathy_soul"), EMPATHY_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "humility_soul"), HUMILITY_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "constancy_soul"), CONSTANCY_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "dedication_soul"), DEDICATION_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "heroism_soul"), HEROISM_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "honor_soul"), HONOR_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "mercy_soul"), MERY_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "despair_soul"), DESPAIR_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "dishonor_soul"), DISHONOR_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "immorality_soul"), IMMORALITY_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "wrath_soul"), WRATH_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "recklessness_soul"), RECKLESSNESS_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "deceit_soul"), DECEIT_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "apathy_soul"), APATHY_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "terror_soul"), TERROR_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "corrupted_monster_soul"), CORRUPTED_MONSTER_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "overwrite_soul"), OVERWRITE_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "overwrite_determination_soul"), OVERWRITE_DETERMINATION_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "determination_overwrite_soul"), DETERMINATION_OVERWRITE_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "og_justice_soul"), OG_JUSTICE_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "empty_soul_container"), EMPTY_SOUL_CONTAINER);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "overwrite_determination_soul_2"), OVERWRITE_DETERMINATION_SOUL_2);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "skeleton_monster_soul"), SKELETON_MONSTER_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "spear_monster_soul"), SPEAR_MONSTER_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "frost_monster_soul"), FROST_MONSTER_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "flame_monster_soul"), FLAME_MONSTER_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "ghost_monster_soul"), GHOST_MONSTER_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "defense_monster_soul"),DEFENSE_MONSTER_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "metalic_monster_soul"),METALIC_MONSTER_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "mobility_monster_soul"),MOBILITY_MONSTER_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "mobility_monster_soul_2"),MOBILITY_MONSTER_SOUL_2);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "justice_monster_soul"),JUSTICE_MONSTER_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "bravery_monster_soul"),BRAVERY_MONSTER_SOUL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "patience_monster_soul"),PATIENCE_MONSTER_SOUL);



        //Button Items
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "reset_button_1"), RESET_BUTTON_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "pause_button_1"), PAUSE_BUTTON_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "erase_button_1"), ERASE_BUTTON_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "overwrite_button_1"), OVERWRITE_BUTTON_1);





        //Block Items
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "corruption"), CORRUPTION);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "chaotic_corruption"), CHAOTIC_CORRUPTION);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "underground_portal"), UNDERGROUND_PORTAL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "netherground_portal"), NETHERGROUND_PORTAL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "yellow_flower_bed"), YELLOW_FLOWER_BED);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "kindness_shield_block"), KINDNESS_SHIELD_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "barrier"), BARRIER);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "omega_stone_bricks1"), OMEGA_STONE_BRICKS1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "superheated_obsidian"), SUPERHEATED_OBSIDIAN);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "monster_soul_light_block1"), MONSTER_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "kindness_soul_light_block1"), KINDNESS_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "justice_soul_light_block1"), JUSTICE_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "bravery_soul_light_block1"), BRAVERY_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "perseverance_soul_light_block1"), PERSEVERANCE_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "patience_soul_light_block1"), PATIENCE_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "integrity_soul_light_block1"), INTEGRITY_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "determination_soul_light_block1"), DETERMINATION_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "dark_glowstone"), DARK_GLOWSTONE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "menu_block_black1"), MENU_BLOCK_BLACK1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "menu_block_white1"), MENU_BLOCK_WHITE1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "soul_crafting_table"), SOUL_CRAFTING_TABLE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "the_ruins_grass_block"), THE_RUINS_GRASS_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "the_ruins_dirt"), THE_RUINS_DIRT);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "titanium_quartz_block"), TITANIUM_QUARTZ_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "titanium_block"), TITANIUM_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "kindness_shield2_block"), KINDNESS_SHIELD2_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "determination_shield_block"), DETERMINATION_SHIELD_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "aether_cloud_block_white_1"), AETHER_CLOUD_BLOCK_WHITE_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "purified_corruption"), PURIFIED_CORRUPTION);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "determination_shield_block_to_air"), DETERMINATION_SHIELD_BLOCK_TO_AIR);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "kindness_shield2_block_to_air"), KINDNESS_SHIELD2_BLOCK_TO_AIR);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "fear_shield_block"), FEAR_SHIELD_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "fear_shield_block_to_air"), FEAR_SHIELD_BLOCK_TO_AIR);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "corruption_inactive"), CORRUPTION_INACTIVE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "corruption_portal"), CORRUPTION_PORTAL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "despair_soul_light_block1"), DESPAIR_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "immorality_soul_light_block1"), IMMORALITY_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "deceit_soul_light_block1"), DECEIT_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "apathy_soul_light_block1"), APATHY_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "recklessness_soul_light_block1"), RECKLESSNESS_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "dishonor_soul_light_block1"), DISHONOR_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "wrath_soul_light_block1"), WRATH_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "terror_soul_light_block1"), TERROR_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "hate_soul_light_block1"), HATE_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "corruption_soul_light_block1"), CORRUPTION_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "hope_soul_light_block1"), HOPE_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "fear_soul_light_block1"), FEAR_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "corrupted_monster_soul_light_block1"), CORRUPTED_MONSTER_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "aether_cloud_block_cyan_1"), AETHER_CLOUD_BLOCK_CYAN_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "the_beneath_portal"), THE_BENEATH_PORTAL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "statue_player_1"), STATUE_PLAYER_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "omega_portal_1"), OMEGA_PORTAL_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "dragon_block"), DRAGON_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "overwrite_determination_soul_light_block1"), OVERWRITE_DETERMINATION_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "teal_flower_bed"), TEAL_FLOWER_BED);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "red_flower_bed"), RED_FLOWER_BED);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "deepslate"), DEEPSLATE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "cobbled_deepslate"), COBBLED_DEEPSLATE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "polished_deepslate"), POLISHED_DEEPSLATE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "deepslate_bricks"), DEEPSLATE_BRICKS);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "deepslate_tiles"), DEEPSLATE_TILES);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "chiseled_deepslate"), CHISELED_DEEPSLATE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "cracked_deepslate_bricks"), CRACKED_DEEPSLATE_BRICKS);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "cracked_deepslate_tiles"), CRACKED_DEEPSLATE_TILES);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "cobbled_deepslate_slab"), COBBLED_DEEPSLATE_SLAB);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "deepslate_brick_slab"), DEEPSLATE_BRICK_SLAB);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "polished_deepslate_slab"), POLISHED_DEEPSLATE_SLAB);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "deepslate_tile_slab"), DEEPSLATE_TILE_SLAB);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "cobbled_deepslate_stairs"), COBBLED_DEEPSLATE_STAIRS);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "deepslate_brick_stairs"), DEEPSLATE_BRICK_STAIRS);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "deepslate_tile_stairs"), DEEPSLATE_TILE_STAIRS);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "polished_deepslate_stairs"), POLISHED_DEEPSLATE_STAIRS);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "cobbled_deepslate_wall"), COBBLED_DEEPSLATE_WALL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "deepslate_brick_wall"), DEEPSLATE_BRICK_WALL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "deepslate_tile_wall"), DEEPSLATE_TILE_WALL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "polished_deepslate_wall"), POLISHED_DEEPSLATE_WALL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "uni_light_block"), UNI_LIGHT_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "start_grass"), START_GRASS);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "start_path_1"), START_PATH_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "start_path_2"), START_PATH_2);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "start_path_3"), START_PATH_3);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "ruins_bricks"), RUINS_BRICKS);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "ruins_bricks_2"), RUINS_BRICKS_2);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "path_r_1"), PATH_R_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "path_r_2"), PATH_R_2);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "path_r_3"), PATH_R_3);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "red_leaves"), RED_LEAVES);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "snowdin_grass"), SNOWDIN_GRASS);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "snowdin_dirt"), SNOWDIN_DIRT);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "snowdin_path_1"), SNOWDIN_PATH_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "waterfall_ground"), WATERFALL_GROUND);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "waterfall_wall_1"), WATERFALL_WALL_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "waterfall_wall_2"), WATERFALL_WALL_2);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "hotland_ground"), HOTLAND_GROUND);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "hotland_ground_crack"), HOTLAND_GROUND_CRACK);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "hotland_pipe_turn"), HOTLAND_PIPE_TURN);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "hotland_pipe_straight"), HOTLAND_PIPE_STRAIGHT);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "hotland_pipe_turn_2"), HOTLAND_PIPE_TURN_2);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "hotland_pipe_straight_2"), HOTLAND_PIPE_STRAIGHT_2);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "hotland_arrow"), HOTLAND_ARROW);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "nh_wall"), NH_WALL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "nh_ground"), NH_GROUND);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "gray_leaves"), GRAY_LEAVES);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "leaves_1"), LEAVES_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "hotland_conveyor"), HOTLAND_CONVEYOR);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "tl_ground"), TL_GROUND);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "tl_wall_1"), TL_WALL_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "tl_wall_2"), TL_WALL_2);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "nh_ground_2"), NH_GROUND_2);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "nh_ground_3"), NH_GROUND_3);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "black_1"), BLACK_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_pipe"), C_PIPE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_pipe_damaged"), C_PIPE_DAMAGED);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_pipe_end"), C_PIPE_END);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_pipe_start"), C_PIPE_START);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_pipe_2"), C_PIPE_2);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_wire_1"), C_WIRE_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_wire_2"), C_WIRE_2);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_wire_3"), C_WIRE_3);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_wire_4"), C_WIRE_4);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_wall_1"), C_WALL_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_wall_2"), C_WALL_2);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_wall_3"), C_WALL_3);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_wall_4"), C_WALL_4);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_ground_1"), C_GROUND_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_void"), C_VOID);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "waterfall_tall_grass"), WATERFALL_TALL_GRASS);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "waterfall_grass"), WATERFALL_GRASS);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "waterfall_mushrooms"), WATERFALL_MUSHROOMS);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "waterfall_crystals_1"), WATERFALL_CRYSTALS_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "waterfall_crystals_2"), WATERFALL_CRYSTALS_2);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "waterfall_crystals_3"), WATERFALL_CRYSTALS_3);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "waterfall_crystals_4"), WATERFALL_CRYSTALS_4);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "waterfall_ground_cracked"), WATERFALL_GROUND_CRACKED);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "waterfall_ground_2"), WATERFALL_GROUND_2);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "waterfall_ground_3"), WATERFALL_GROUND_3);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "waterfall_ground_4"), WATERFALL_GROUND_4);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "waterfall_ground_5"), WATERFALL_GROUND_5);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "waterfall_water"), WATERFALL_WATER);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "echo_flower"), ECHO_FLOWER);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "snowdin_flower"), SNOWDIN_FLOWER);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "waterfall_wood_slab"), WATERFALL_WOOD_SLAB);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "waterfall_wood_wall"), WATERFALL_WOOD_WALL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "waterfall_wood_slab_2"), WATERFALL_WOOD_SLAB_2);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "waterfall_wood_wall_2"), WATERFALL_WOOD_WALL_2);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_wire_plate"), C_WIRE_PLATE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_glass"), C_GLASS);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_glass_2"), C_GLASS_2);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_bridge_left"), C_BRIDGE_LEFT);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_bridge_right"), C_BRIDGE_RIGHT);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "hotland_wire"), HOTLAND_WIRE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_wire_5"), C_WIRE_5);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_wire_6"), C_WIRE_6);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_wire_plate_2"), C_WIRE_PLATE_2);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "arch_purple_1"),ARCH_PURPLE_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "arch_purple_2"), ARCH_PURPLE_2);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "arch_gray_1"), ARCH_GRAY_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "arch_gray_2"), ARCH_GRAY_2);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "lab_wall"), LAB_WALL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "lab_ground"), LAB_GROUND);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "lab_ground_2"), LAB_GROUND_2);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "vine"), VINE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "red_leaves_carpet"), RED_LEAVES_CARPET);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "gray_leaves_carpet"), GREY_LEAVES_CARPET);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "spikes_1"), SPIKES_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "spikes_2"), SPIKES_2);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_carpet"), C_CARPET);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_wire_wall"), C_WIRE_WALL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_wire_7"), C_WIRE_7);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_wire_8"), C_WIRE_8);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_bridge_left_2"), C_BRIDGE_LEFT_2);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "c_bridge_right_2"), C_BRIDGE_RIGHT_2);






        //Tool Items
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "flint_and_diamond"), FLINT_AND_DIAMOND);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "titanium_quartz_pickaxe"), TITANIUM_QUARTZ_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "titanium_quartz_axe"), TITANIUM_QUARTZ_AXE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "titanium_quartz_shovel"), TITANIUM_QUARTZ_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "titanium_quartz_hoe"), TITANIUM_QUARTZ_HOE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "dragon_pickaxe"), DRAGON_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "dragon_axe"), DRAGON_AXE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "dragon_shovel"), DRAGON_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "dragon_hoe"), DRAGON_HOE);




        //Soul-Weapon-Combat Items
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "determination_sword"), DETERMINATION_SWORD);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "fear_scythe"), FEAR_SCYTHE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "justice_pistol"), JUSTICE_PISTOL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "integrity_ballet_shoes"), INTEGRITY_BALLET_SHOES);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "kindness_frying_pan"), KINDNESS_FRYING_PAN);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "perseverance_torn_notebook"), PERSEVERANCE_TORN_NOTEBOOK);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "patience_toy_knife"), PATIENCE_TOY_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "bravery_tough_glove"), BRAVERY_TOUGH_GLOVE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "sans_gaster_blaster"), SANS_GASTER_BLASTER);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "asriel_chaos_saber"), ASRIEL_CHAOS_SABER);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "determination_knife"), DETERMINATION_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "hate_sword"), HATE_SWORD);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "hate_scythe"), HATE_SCYTHE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "hate_pistol"), HATE_PISTOL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "hate_ballet_shoes"), HATE_BALLET_SHOES);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "hate_frying_pan"), HATE_FRYING_PAN);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "hate_torn_notebook"), HATE_TORN_NOTEBOOK);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "hate_toy_knife"), HATE_TOY_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "hate_tough_glove"), HATE_TOUGH_GLOVE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "despair_sword"), DESPAIR_SWORD);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "immorality_shotgun"), IMMORALITY_SHOTGUN);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "deceit_tennis_shoe"), DECEIT_TENNIS_SHOE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "apathy_careless_journal"), APATHY_CARELESS_JOURNAL);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "recklessness_ballistic_knife"), RECKLESSNESS_BALLISTIC_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "dishonor_sturdy_glove"), DISHONOR_STURDY_GLOVE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "wrath_double_frying_pan"), WRATH_DOUBLE_FRYING_PAN);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "terror_scythe"), TERROR_SCYTHE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "xchara_knife"), XCHARA_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "xchara_knife_2"), XCHARA_KNIFE_2);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "skeleton_bone_1"), SKELETON_BONE_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "spear_1"), SPEAR_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "frost_bomb_1"), FROST_BOMB_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "flame_staff_1"), FLAME_STAFF_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "ghost_weapon_1"), GHOST_WEAPON_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "monster_shield_1"), MONSTER_SHIELD_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "energy_beam_1"), ENERGY_BEAM_1);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "ancient_tome"), ANCIENT_TOME);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "dirty_shoes"), DIRTY_SHOES);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "empty_gun"), EMPTY_GUN);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "durable_glove"), DURABLE_GLOVE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "stoic_knife"), STOIC_KNIFE);




        //Weapon-Combat Items
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "knife"), KNIFE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "titanium_quartz_sword"), TITANIUM_QUARTZ_SWORD);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "dragon_sword"), DRAGON_SWORD);




        //Armor Items
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "invis_helmet"), INVIS_HELMET);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "invis_chestplate"), INVIS_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "invis_leggings"), INVIS_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "invis_boots"), INVIS_BOOTS);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "heart_locket"), HEART_LOCKET);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "titanium_quartz_helmet"), TITANIUM_QUARTZ_HELMET);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "titanium_quartz_chestplate"), TITANIUM_QUARTZ_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "titanium_quartz_leggings"), TITANIUM_QUARTZ_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "titanium_quartz_boots"), TITANIUM_QUARTZ_BOOTS);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "quantum_helmet"), QUANTUM_HELMET);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "quantum_chestplate"), QUANTUM_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "quantum_leggings"), QUANTUM_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "quantum_boots"), QUANTUM_BOOTS);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "dragon_helmet"), DRAGON_HELMET);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "dragon_chestplate"), DRAGON_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "dragon_leggings"), DRAGON_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "dragon_boots"), DRAGON_BOOTS);


        //Elytra
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "dragon_elytra"), DRAGON_ELYTRA);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "dragon_chestplate_elytra"), DRAGON_CHESTPLATE_ELYTRA);


        //Spawn Eggs
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "hate_spawn_egg"), HATE_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "catboymaid_spawn_egg"), CATBOYMAID_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "founderlab_spawn_egg"), FOUNDERLAB_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "corruption_spawn_egg"), CORRUPTION_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "golem_soul_monster_spawn_egg"), GOLEM_SOUL_MONSTER_SPAWN_EGG);




        //Music Discs
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "music_disc_blank"), MUSIC_DISC_BLANK);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "music_disc_fallen_down_reprise"), MUSIC_DISC_FALLEN_DOWN_REPRISE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "music_disc_fallen_petals"), MUSIC_DISC_FALLEN_PETALS);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "music_disc_home_extended"), MUSIC_DISC_HOME_EXTENDED);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "music_disc_ruins_extended"), MUSIC_DISC_RUINS_EXTENDED);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "music_disc_snowdin_extended"), MUSIC_DISC_SNOWDIN_EXTENDED);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "music_disc_waterfall_extended"), MUSIC_DISC_WATERFALL_EXTENDED);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "music_disc_undertale"), MUSIC_DISC_UNDERTALE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "music_disc_another_medium"), MUSIC_DISC_ANOTHER_MEDIUM);




        //FoodItems
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "butterscotch_pie"), BUTTERSCOTCH_PIE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "legendaryhero"), LEGENDARYHERO);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "glamburger"), GLAMBURGER);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "nicecream"), NICECREAM);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "snowmanpiece"), SNOWMANPIECE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "spiderdonut"), SPIDERDONUT);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "monstercandy"), MONSTERCANDY);



        //Ore Items
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "titanium_quartz_ingot"), TITANIUM_QUARTZ_INGOT);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "rainbow_quartz"), RAINBOW_QUARTZ);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "titanium_ingot"), TITANIUM_INGOT);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "dragon_ingot"), DRAGON_INGOT);


        //Misc
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "quantum_stabilizer"), QUANTUM_STABILIZER);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "dragon_scale"), DRAGON_SCALE);
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "wither_essence"), WITHER_ESSENCE);



        //Images
        Registry.register(Registry.ITEM, new Identifier(UniformSouls.MOD_ID, "corrupted_nexus_logo_1"), CORRUPTED_NEXUS_LOGO_1);




    }

}
