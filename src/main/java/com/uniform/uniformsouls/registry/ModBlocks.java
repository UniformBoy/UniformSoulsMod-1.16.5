package com.uniform.uniformsouls.registry;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.blocks.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class ModBlocks {

    public static Boolean never(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return false;
    }

    public static Boolean always(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return true;
    }

    public static boolean always(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    public static boolean never(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }

    public static final Block CORRUPTION = new Corruption(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .requiresTool()
            .ticksRandomly()
            .strength(18000000.0F, 18000000.0F)
            .sounds(BlockSoundGroup.WART_BLOCK)
            .luminance(10)) {
        @Override
        public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
            super.randomTick(state, world, pos, random);
        }
    };

    public static final Block CHAOTIC_CORRUPTION = new ChaoticCorruption(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .requiresTool()
            .ticksRandomly()
            .strength(18000000.0F, 18000000.0F)
            .sounds(BlockSoundGroup.WART_BLOCK)
            .luminance(15)) {
        @Override
        public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
            super.randomTick(state, world, pos, random);

        }
    };


    public static final Block UNDERGROUND_PORTAL = new Block(FabricBlockSettings
            .of(Material.PORTAL)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .requiresTool()
            .blockVision(ModBlocks::always)
            .strength(18000000.0F, 18000000.0F)
            .sounds(BlockSoundGroup.METAL)
            .noCollision());

    public static final Block NETHERGROUND_PORTAL = new UniGlassBlock(FabricBlockSettings
            .of(Material.PORTAL)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .requiresTool()
            .strength(18000000.0F, 18000000.0F)
            .sounds(BlockSoundGroup.METAL)
            .nonOpaque()
            .blockVision(ModBlocks::always)
            .noCollision());

    public static final Block YELLOW_FLOWER_BED = new FlowerBed(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.SHOVELS, 0)
            .strength(0.5F, 0.2F)
            .sounds(BlockSoundGroup.GRASS));

    public static final Block KINDNESS_SHIELD_BLOCK = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .strength(18000000.0F, 18000000.0F)
            .sounds(BlockSoundGroup.GLASS)
            .nonOpaque()
            .luminance(10));

    public static final Block BARRIER = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .requiresTool()
            .emissiveLighting(AbstractBlock.AbstractBlockState::isFullCube)
            .strength(18000000.0F, 18000000.0F)
            .sounds(BlockSoundGroup.GLASS)
            .luminance(15));

    public static final Block OMEGA_STONE_BRICKS1 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 1)
            .requiresTool()
            .strength(1.5F,30.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block SUPERHEATED_OBSIDIAN = new SuperHeatedObsidian(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .requiresTool()
            .strength(60.0F, 8000.0F)
            .sounds(BlockSoundGroup.STONE)
            .luminance(10));

    public static final Block MONSTER_SOUL_LIGHT_BLOCK1 = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByHand(true)
            .luminance(15)
            .strength(3.5F,30.0F)
            .sounds(BlockSoundGroup.GLASS));

    public static final Block KINDNESS_SOUL_LIGHT_BLOCK1 = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByHand(true)
            .luminance(15)
            .strength(3.5F,30.0F)
            .sounds(BlockSoundGroup.GLASS));

    public static final Block JUSTICE_SOUL_LIGHT_BLOCK1 = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByHand(true)
            .luminance(15)
            .strength(3.5F,30.0F)
            .sounds(BlockSoundGroup.GLASS));

    public static final Block BRAVERY_SOUL_LIGHT_BLOCK1 = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByHand(true)
            .luminance(15)
            .strength(3.5F,30.0F)
            .sounds(BlockSoundGroup.GLASS));

    public static final Block PERSEVERANCE_SOUL_LIGHT_BLOCK1 = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByHand(true)
            .luminance(15)
            .strength(3.5F,30.0F)
            .sounds(BlockSoundGroup.GLASS));

    public static final Block PATIENCE_SOUL_LIGHT_BLOCK1 = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByHand(true)
            .luminance(15)
            .strength(3.5F,30.0F)
            .sounds(BlockSoundGroup.GLASS));

    public static final Block INTEGRITY_SOUL_LIGHT_BLOCK1 = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByHand(true)
            .luminance(15)
            .strength(3.5F,30.0F)
            .sounds(BlockSoundGroup.GLASS));

    public static final Block DETERMINATION_SOUL_LIGHT_BLOCK1 = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByHand(true)
            .luminance(15)
            .strength(3.5F,30.0F)
            .sounds(BlockSoundGroup.GLASS));

    public static final Block DARK_GLOWSTONE = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByHand(true)
            .luminance(5)
            .strength(2.5F,15.0F)
            .sounds(BlockSoundGroup.GLASS));

    public static final Block MENU_BLOCK_BLACK1 = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByHand(true)
            .luminance(5)
            .strength(18000000.0F,18000000.0F)
            .sounds(BlockSoundGroup.GLASS));


    public static final Block MENU_BLOCK_WHITE1 = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByHand(true)
            .luminance(5)
            .strength(18000000.0F,18000000.0F)
            .sounds(BlockSoundGroup.GLASS));

    public static final Block SOUL_CRAFTING_TABLE = new SoulCraftingTable(FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .luminance(5)
            .strength(1.0F,3.0F)
            .sounds(BlockSoundGroup.NETHERITE));

    public static final Block THE_RUINS_GRASS_BLOCK = new TheRuinsGrassBlock(FabricBlockSettings
            .of(Material.ORGANIC_PRODUCT)
            .breakByTool(FabricToolTags.SHOVELS, 0)
            .strength(0.5F, 0.2F)
            .ticksRandomly()
            .sounds(BlockSoundGroup.GRASS)) {
        @Override
        public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
            return true;
        }

        @Override
        public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
            return true;
        }

        @Override
        public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {

        }

        @Override
        public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
            super.randomTick(state, world, pos, random);
        }
    };

    public static final Block THE_RUINS_DIRT = new Block(FabricBlockSettings
            .of(Material.SOLID_ORGANIC)
            .breakByTool(FabricToolTags.SHOVELS, 0)
            .strength(0.5F,0.2F)
            .sounds(BlockSoundGroup.GRAVEL));

    public static final Block TITANIUM_BLOCK = new Block(FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES, 4)
            .requiresTool()
            .strength(51F,1300F)
            .sounds(BlockSoundGroup.NETHERITE));

    public static final Block TITANIUM_QUARTZ_BLOCK = new Block(FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES, 4)
            .requiresTool()
            .strength(52F,1400F)
            .luminance(8)
            .sounds(BlockSoundGroup.NETHERITE));

    public static final Block KINDNESS_SHIELD2_BLOCK = new UniGlassBlock(FabricBlockSettings
            .of(Material.GLASS)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .strength(18000000.0F, 18000000.0F)
            .sounds(BlockSoundGroup.GLASS)
            .nonOpaque()
            .luminance(10)
            .allowsSpawning(ModBlocks::never)
            .solidBlock(ModBlocks::never)
            .suffocates(ModBlocks::never)
            .blockVision(ModBlocks::never));

    public static final Block DETERMINATION_SHIELD_BLOCK = new UniGlassBlock(FabricBlockSettings
            .of(Material.GLASS)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .strength(18000000.0F, 18000000.0F)
            .sounds(BlockSoundGroup.GLASS)
            .nonOpaque()
            .luminance(10)
            .allowsSpawning(ModBlocks::never)
            .solidBlock(ModBlocks::never)
            .suffocates(ModBlocks::never)
            .blockVision(ModBlocks::never));

    public static final Block AETHER_CLOUD_BLOCK_WHITE_1 = new CloudBlock(FabricBlockSettings
            .of(Material.ICE)
            .breakByHand(true)
            .strength(0.2F, 5.0F)
            .sounds(BlockSoundGroup.WOOL)
            .nonOpaque()
            .luminance(15)
            .allowsSpawning(ModBlocks::never)
            .solidBlock(ModBlocks::never)
            .suffocates(ModBlocks::never)
            .blockVision(ModBlocks::never)
            .slipperiness(0.45F));

    public static final Block PURIFIED_CORRUPTION = new PurifiedCorruption(FabricBlockSettings
            .of(Material.ORGANIC_PRODUCT)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .requiresTool()
            .ticksRandomly()
            .strength(18000000.0F, 18000000.0F)
            .sounds(BlockSoundGroup.WART_BLOCK)
            .luminance(15)) {
        @Override
        public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
            super.randomTick(state, world, pos, random);
        }
    };

    public static final Block DETERMINATION_SHIELD_BLOCK_TO_AIR = new DetShieldToAir(FabricBlockSettings
            .of(Material.GLASS)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .strength(25.0F, 18000000.0F)
            .sounds(BlockSoundGroup.GLASS)
            .nonOpaque()
            .luminance(10)
            .allowsSpawning(ModBlocks::never)
            .solidBlock(ModBlocks::never)
            .suffocates(ModBlocks::never)
            .blockVision(ModBlocks::never)) {
        @Override
        public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
            super.scheduledTick(state, world, pos, random);
        }
    };

    public static final Block KINDNESS_SHIELD2_BLOCK_TO_AIR = new KinShieldToAir(FabricBlockSettings
            .of(Material.GLASS)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .strength(35.0F, 25.0F)
            .sounds(BlockSoundGroup.GLASS)
            .nonOpaque()
            .luminance(10)
            .allowsSpawning(ModBlocks::never)
            .solidBlock(ModBlocks::never)
            .suffocates(ModBlocks::never)
            .blockVision(ModBlocks::never)) {
        @Override
        public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
            super.scheduledTick(state, world, pos, random);
        }
    };

    public static final Block FEAR_SHIELD_BLOCK = new UniGlassBlock(FabricBlockSettings
            .of(Material.GLASS)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .strength(18000000.0F, 18000000.0F)
            .sounds(BlockSoundGroup.GLASS)
            .nonOpaque()
            .luminance(10)
            .allowsSpawning(ModBlocks::never)
            .solidBlock(ModBlocks::never)
            .suffocates(ModBlocks::never)
            .blockVision(ModBlocks::never));

    public static final Block FEAR_SHIELD_BLOCK_TO_AIR = new FeaShieldToAir(FabricBlockSettings
            .of(Material.GLASS)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .strength(25.0F, 18000000.0F)
            .sounds(BlockSoundGroup.GLASS)
            .nonOpaque()
            .luminance(10)
            .allowsSpawning(ModBlocks::never)
            .solidBlock(ModBlocks::never)
            .suffocates(ModBlocks::never)
            .blockVision(ModBlocks::never)) {
        @Override
        public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
            super.scheduledTick(state, world, pos, random);
        }
    };

    public static final Block CORRUPTION_INACTIVE = new CorruptionInactive(FabricBlockSettings
            .of(Material.ORGANIC_PRODUCT)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .requiresTool()
            .strength(18000000.0F, 18000000.0F)
            .sounds(BlockSoundGroup.WART_BLOCK)
            .luminance(10)) {
        @Override
        public void onSteppedOn(World world, BlockPos pos, Entity entity) {
            super.onSteppedOn(world, pos, entity);
        }
    };

    public static final Block CORRUPTION_PORTAL = new UniGlassBlock(FabricBlockSettings
            .of(Material.PORTAL)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .requiresTool()
            .blockVision(ModBlocks::always)
            .strength(18000000.0F, 18000000.0F)
            .sounds(BlockSoundGroup.METAL)
            .noCollision());

    public static final Block DESPAIR_SOUL_LIGHT_BLOCK1 = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByHand(true)
            .luminance(15)
            .strength(3.5F,30.0F)
            .sounds(BlockSoundGroup.GLASS));

    public static final Block IMMORALITY_SOUL_LIGHT_BLOCK1 = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByHand(true)
            .luminance(15)
            .strength(3.5F,30.0F)
            .sounds(BlockSoundGroup.GLASS));

    public static final Block DECEIT_SOUL_LIGHT_BLOCK1 = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByHand(true)
            .luminance(15)
            .strength(3.5F,30.0F)
            .sounds(BlockSoundGroup.GLASS));

    public static final Block APATHY_SOUL_LIGHT_BLOCK1 = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByHand(true)
            .luminance(15)
            .strength(3.5F,30.0F)
            .sounds(BlockSoundGroup.GLASS));

    public static final Block RECKLESSNESS_SOUL_LIGHT_BLOCK1 = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByHand(true)
            .luminance(15)
            .strength(3.5F,30.0F)
            .sounds(BlockSoundGroup.GLASS));

    public static final Block DISHONOR_SOUL_LIGHT_BLOCK1 = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByHand(true)
            .luminance(15)
            .strength(3.5F,30.0F)
            .sounds(BlockSoundGroup.GLASS));

    public static final Block WRATH_SOUL_LIGHT_BLOCK1 = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByHand(true)
            .luminance(15)
            .strength(3.5F,30.0F)
            .sounds(BlockSoundGroup.GLASS));

    public static final Block TERROR_SOUL_LIGHT_BLOCK1 = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByHand(true)
            .luminance(15)
            .strength(3.5F,30.0F)
            .sounds(BlockSoundGroup.GLASS));

    public static final Block HATE_SOUL_LIGHT_BLOCK1 = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByHand(true)
            .luminance(15)
            .strength(3.5F,30.0F)
            .sounds(BlockSoundGroup.GLASS));

    public static final Block CORRUPTION_SOUL_LIGHT_BLOCK1 = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByHand(true)
            .luminance(15)
            .strength(3.5F,30.0F)
            .sounds(BlockSoundGroup.GLASS));

    public static final Block HOPE_SOUL_LIGHT_BLOCK1 = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByHand(true)
            .luminance(15)
            .strength(3.5F,30.0F)
            .sounds(BlockSoundGroup.GLASS));

    public static final Block FEAR_SOUL_LIGHT_BLOCK1 = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByHand(true)
            .luminance(15)
            .strength(3.5F,30.0F)
            .sounds(BlockSoundGroup.GLASS));

    public static final Block CORRUPTED_MONSTER_SOUL_LIGHT_BLOCK1 = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByHand(true)
            .luminance(15)
            .strength(3.5F,30.0F)
            .sounds(BlockSoundGroup.GLASS));

    public static final Block AETHER_CLOUD_BLOCK_CYAN_1 = new CloudBlock(FabricBlockSettings
            .of(Material.ICE)
            .breakByHand(true)
            .strength(0.2F, 5.0F)
            .sounds(BlockSoundGroup.WOOL)
            .nonOpaque()
            .luminance(15)
            .allowsSpawning(ModBlocks::never)
            .solidBlock(ModBlocks::never)
            .suffocates(ModBlocks::never)
            .blockVision(ModBlocks::never)
            .slipperiness(0.1F)
            .materialColor(MapColor.CYAN));

    public static final Block THE_BENEATH_PORTAL = new UniGlassBlock(FabricBlockSettings
            .of(Material.PORTAL)
            .breakByTool(FabricToolTags.PICKAXES, 4)
            .requiresTool()
            .blockVision(ModBlocks::always)
            .emissiveLighting(AbstractBlock.AbstractBlockState::isFullCube)
            .strength(2.0F, 18000000.0F)
            .sounds(BlockSoundGroup.METAL)
            .noCollision());

    public static final Block STATUE_PLAYER_1 = new StatuePlayer1(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 1)
            .requiresTool()
            .strength(1.5F,30.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block OMEGA_PORTAL_1 = new OmegaPortal1Block(FabricBlockSettings
            .of(Material.PORTAL)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .requiresTool()
            .blockVision(ModBlocks::always)
            .strength(18000000.0F, 18000000.0F)
            .sounds(BlockSoundGroup.METAL)
            .nonOpaque()
            .noCollision());

    public static final Block DRAGON_BLOCK = new Block(FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES, 5)
            .requiresTool()
            .strength(53F,2000F)
            .sounds(BlockSoundGroup.NETHERITE));

    public static final Block OVERWRITE_DETERMINATION_SOUL_LIGHT_BLOCK1 = new Block(FabricBlockSettings
            .of(Material.GLASS)
            .breakByHand(true)
            .luminance(15)
            .strength(3.5F,30.0F)
            .sounds(BlockSoundGroup.GLASS));

    public static final Block TEAL_FLOWER_BED = new FlowerBed(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .requiresTool()
            .strength(18000000.0F, 18000000.0F)
            .sounds(BlockSoundGroup.GRASS));

    public static final Block RED_FLOWER_BED = new FlowerBed(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .requiresTool()
            .strength(18000000.0F, 18000000.0F)
            .sounds(BlockSoundGroup.GRASS));

    public static final Block DEEPSLATE = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block COBBLED_DEEPSLATE = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block POLISHED_DEEPSLATE = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block DEEPSLATE_BRICKS = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block DEEPSLATE_TILES = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block CHISELED_DEEPSLATE = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block CRACKED_DEEPSLATE_BRICKS = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block CRACKED_DEEPSLATE_TILES = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block COBBLED_DEEPSLATE_SLAB = new UniSlabBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block DEEPSLATE_BRICK_SLAB = new UniSlabBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block POLISHED_DEEPSLATE_SLAB = new UniSlabBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block DEEPSLATE_TILE_SLAB = new UniSlabBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block COBBLED_DEEPSLATE_STAIRS = new UniStairsBlock(COBBLED_DEEPSLATE
            .getDefaultState(), AbstractBlock.Settings.copy(COBBLED_DEEPSLATE));

    public static final Block DEEPSLATE_BRICK_STAIRS = new UniStairsBlock(DEEPSLATE_BRICKS
            .getDefaultState(), AbstractBlock.Settings.copy(DEEPSLATE_BRICKS));

    public static final Block DEEPSLATE_TILE_STAIRS = new UniStairsBlock(DEEPSLATE_TILES
            .getDefaultState(), AbstractBlock.Settings.copy(DEEPSLATE_TILES));

    public static final Block POLISHED_DEEPSLATE_STAIRS = new UniStairsBlock(POLISHED_DEEPSLATE
            .getDefaultState(), AbstractBlock.Settings.copy(POLISHED_DEEPSLATE));

    public static final Block COBBLED_DEEPSLATE_WALL = new UniWallBlock(AbstractBlock.Settings.copy(COBBLED_DEEPSLATE));

    public static final Block DEEPSLATE_BRICK_WALL = new UniWallBlock(AbstractBlock.Settings.copy(DEEPSLATE_BRICKS));

    public static final Block DEEPSLATE_TILE_WALL = new UniWallBlock(AbstractBlock.Settings.copy(DEEPSLATE_TILES));

    public static final Block POLISHED_DEEPSLATE_WALL = new UniWallBlock(AbstractBlock.Settings.copy(POLISHED_DEEPSLATE));

    public static final Block UNI_LIGHT_BLOCK = new UniLightBlock(AbstractBlock
            .Settings.of(Material.AIR)
            .strength(-1.0F, 3600000.8F)
            .dropsNothing()
            .nonOpaque()
            .luminance(UniLightBlock.STATE_TO_LUMINANCE));

    public static final Block START_GRASS = new Block(FabricBlockSettings
            .of(Material.SOLID_ORGANIC)
            .breakByTool(FabricToolTags.SHOVELS, 0)
            .strength(0.6F, 2.5F)
            .sounds(BlockSoundGroup.GRASS));

    public static final Block START_PATH_1 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block START_PATH_2 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block START_PATH_3 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block RUINS_BRICKS = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block RUINS_BRICKS_2 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block PATH_R_1 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block PATH_R_2 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block PATH_R_3 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block RED_LEAVES = new Block(FabricBlockSettings
            .of(Material.LEAVES)
            .breakByTool(FabricToolTags.SHEARS, 0)
            .strength(0.2F, 0.5F)
            .sounds(BlockSoundGroup.GRASS));

    public static final Block SNOWDIN_GRASS = new Block(FabricBlockSettings
            .of(Material.SOLID_ORGANIC)
            .breakByTool(FabricToolTags.SHOVELS, 0)
            .strength(0.6F, 2.5F)
            .sounds(BlockSoundGroup.SNOW));

    public static final Block SNOWDIN_DIRT = new Block(FabricBlockSettings
            .of(Material.SOIL)
            .breakByTool(FabricToolTags.SHOVELS, 0)
            .strength(0.7F, 2.5F)
            .sounds(BlockSoundGroup.GRAVEL));

    public static final Block SNOWDIN_PATH_1 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.SNOW));

    public static final Block WATERFALL_GROUND = new Block(FabricBlockSettings
            .of(Material.SOLID_ORGANIC)
            .breakByTool(FabricToolTags.SHOVELS, 0)
            .strength(0.6F, 2.5F)
            .sounds(BlockSoundGroup.GRAVEL));

    public static final Block WATERFALL_WALL_1 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block WATERFALL_WALL_2 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block HOTLAND_GROUND = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block HOTLAND_GROUND_CRACK = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE)
            .luminance(10));

    public static final Block HOTLAND_PIPE_TURN = new GlazedTerracottaBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block HOTLAND_PIPE_STRAIGHT = new GlazedTerracottaBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block HOTLAND_PIPE_TURN_2 = new GlazedTerracottaBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block HOTLAND_PIPE_STRAIGHT_2 = new GlazedTerracottaBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block HOTLAND_ARROW = new GlazedTerracottaBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block NH_WALL = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block NH_GROUND = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block GRAY_LEAVES = new Block(FabricBlockSettings
            .of(Material.SOLID_ORGANIC)
            .breakByTool(FabricToolTags.SHEARS, 0)
            .strength(0.6F, 2.5F)
            .sounds(BlockSoundGroup.GRASS));

    public static final Block LEAVES_1 = new Block(FabricBlockSettings
            .of(Material.SOLID_ORGANIC)
            .breakByTool(FabricToolTags.SHEARS, 0)
            .strength(0.6F, 2.5F)
            .sounds(BlockSoundGroup.GRASS));

    public static final Block HOTLAND_CONVEYOR = new GlazedTerracottaBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block TL_GROUND = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block TL_WALL_1 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block TL_WALL_2 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block NH_GROUND_2 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block NH_GROUND_3 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block BLACK_1 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block C_PIPE = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_PIPE_DAMAGED = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_PIPE_END = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_PIPE_START = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_PIPE_2 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_WIRE_1 = new GlazedTerracottaBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_WIRE_2 = new GlazedTerracottaBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_WIRE_3 = new GlazedTerracottaBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_WIRE_4 = new GlazedTerracottaBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_WALL_1 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_WALL_2 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_WALL_3 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_WALL_4 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_GROUND_1 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_VOID = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL)
            .emissiveLighting(AbstractBlock.AbstractBlockState::isFullCube)
            .luminance(15));

    public static final Block WATERFALL_TALL_GRASS = new WaterfallPlantBlock(AbstractBlock.Settings
            .of(Material.SOLID_ORGANIC)
            .noCollision()
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS));

    public static final Block WATERFALL_GRASS = new WaterfallPlantBlock(AbstractBlock.Settings
            .of(Material.SOLID_ORGANIC)
            .noCollision()
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS)
            .emissiveLighting(AbstractBlock.AbstractBlockState::isFullCube));

    public static final Block WATERFALL_MUSHROOMS = new WaterfallMushroomBlock(AbstractBlock.Settings
            .of(Material.SOLID_ORGANIC)
            .noCollision()
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS).emissiveLighting(AbstractBlock.AbstractBlockState::isFullCube));

    public static final Block WATERFALL_CRYSTALS_1 = new WaterfallCrystalBlock(FabricBlockSettings
            .of(Material.STONE)
            .noCollision()
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(0.6F, 1.0F)
            .sounds(BlockSoundGroup.STONE)
            .emissiveLighting(AbstractBlock.AbstractBlockState::isFullCube)
            .luminance(5));

    public static final Block WATERFALL_CRYSTALS_2 = new WaterfallCrystalBlock(FabricBlockSettings
            .of(Material.STONE)
            .noCollision()
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(0.6F, 1.0F)
            .sounds(BlockSoundGroup.STONE)
            .emissiveLighting(AbstractBlock.AbstractBlockState::isFullCube)
            .luminance(5));

    public static final Block WATERFALL_CRYSTALS_3 = new WaterfallCrystalBlock(FabricBlockSettings
            .of(Material.STONE)
            .noCollision()
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(0.6F, 1.0F)
            .sounds(BlockSoundGroup.STONE)
            .emissiveLighting(AbstractBlock.AbstractBlockState::isFullCube)
            .luminance(5));

    public static final Block WATERFALL_CRYSTALS_4 = new WaterfallCrystalBlock(FabricBlockSettings
            .of(Material.STONE)
            .noCollision()
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(0.6F, 1.0F)
            .sounds(BlockSoundGroup.STONE)
            .emissiveLighting(AbstractBlock.AbstractBlockState::isFullCube)
            .luminance(5));

    public static final Block WATERFALL_GROUND_CRACKED = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE)
            .emissiveLighting(AbstractBlock.AbstractBlockState::isFullCube)
            .luminance(10));

    public static final Block WATERFALL_GROUND_2 = new Block(FabricBlockSettings
            .of(Material.SOLID_ORGANIC)
            .breakByTool(FabricToolTags.SHOVELS, 0)
            .strength(0.6F, 2.5F)
            .sounds(BlockSoundGroup.GRAVEL));

    public static final Block WATERFALL_GROUND_3 = new Block(FabricBlockSettings
            .of(Material.SOLID_ORGANIC)
            .breakByTool(FabricToolTags.SHOVELS, 0)
            .strength(0.6F, 2.5F)
            .sounds(BlockSoundGroup.GRAVEL));

    public static final Block WATERFALL_GROUND_4 = new Block(FabricBlockSettings
            .of(Material.SOLID_ORGANIC)
            .breakByTool(FabricToolTags.SHOVELS, 0)
            .strength(0.6F, 2.5F)
            .sounds(BlockSoundGroup.GRAVEL));

    public static final Block WATERFALL_GROUND_5 = new Block(FabricBlockSettings
            .of(Material.SOLID_ORGANIC)
            .breakByTool(FabricToolTags.SHOVELS, 0)
            .strength(0.6F, 2.5F)
            .sounds(BlockSoundGroup.GRAVEL));

    public static final Block WATERFALL_WATER = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .emissiveLighting(AbstractBlock.AbstractBlockState::isFullCube)
            .luminance(8));

    public static final Block ECHO_FLOWER = new WaterfallFlowerBlock(StatusEffects.NAUSEA, 7, AbstractBlock.Settings
            .of(Material.SOLID_ORGANIC)
            .noCollision()
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS)
            .emissiveLighting(AbstractBlock.AbstractBlockState::isFullCube));

    public static final Block SNOWDIN_FLOWER = new SnowdinFlowerBlock(UniformSouls.CHILLEDEFFECT1, 7, AbstractBlock.Settings
            .of(Material.SOLID_ORGANIC)
            .noCollision()
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS));

    public static final Block WATERFALL_WOOD_SLAB = new UniSlabBlock(FabricBlockSettings
            .of(Material.WOOD)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .strength(2.5F, 35.0F)
            .sounds(BlockSoundGroup.WOOD));

    public static final Block WATERFALL_WOOD_WALL = new UniWallBlock(FabricBlockSettings
            .of(Material.WOOD)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .strength(2.5F, 35.0F)
            .sounds(BlockSoundGroup.WOOD));

    public static final Block WATERFALL_WOOD_SLAB_2 = new UniSlabBlock(FabricBlockSettings
            .of(Material.WOOD)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .strength(2.5F, 35.0F)
            .sounds(BlockSoundGroup.WOOD));

    public static final Block WATERFALL_WOOD_WALL_2 = new UniWallBlock(FabricBlockSettings
            .of(Material.WOOD)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .strength(2.5F, 35.0F)
            .sounds(BlockSoundGroup.WOOD));

    public static final Block C_WIRE_PLATE = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_GLASS = new UniGlassBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .nonOpaque()
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_GLASS_2 = new UniGlassBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .nonOpaque()
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_BRIDGE_LEFT = new UniDirectionalSlabBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_BRIDGE_RIGHT = new UniDirectionalSlabBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block HOTLAND_WIRE = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_WIRE_5 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_WIRE_6 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_WIRE_PLATE_2 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block ARCH_PURPLE_1 = new PillarBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block ARCH_PURPLE_2 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block ARCH_GRAY_1 = new PillarBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block ARCH_GRAY_2 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block LAB_WALL = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block LAB_GROUND = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block LAB_GROUND_2 = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block VINE = new VineBlock(AbstractBlock.Settings
            .of(Material.REPLACEABLE_PLANT)
            .noCollision()
            .nonOpaque()
            .ticksRandomly()
            .strength(0.2F)
            .sounds(BlockSoundGroup.VINE));

    public static final Block RED_LEAVES_CARPET = new UniCarpetBlock(FabricBlockSettings
            .of(Material.LEAVES)
            .breakByTool(FabricToolTags.SHEARS, 0)
            .strength(0.15F, 0.4F)
            .sounds(BlockSoundGroup.GRASS));

    public static final Block GREY_LEAVES_CARPET = new UniCarpetBlock(FabricBlockSettings
            .of(Material.LEAVES)
            .breakByTool(FabricToolTags.SHEARS, 0)
            .strength(0.15F, 0.4F)
            .sounds(BlockSoundGroup.GRASS));

    public static final Block SPIKES_1 = new UniPressurePlateBlock(PressurePlateBlock
            .ActivationRule.EVERYTHING, AbstractBlock.Settings
            .of(Material.STONE)
            .noCollision()
            .strength(1.5F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block SPIKES_2 = new SpikeBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(1.5F, 35.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_CARPET = new UniCarpetBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.SHEARS, 0)
            .strength(0.15F, 0.4F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_WIRE_WALL = new WaterfallCrystalBlock(FabricBlockSettings
            .of(Material.STONE)
            .noCollision()
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(0.85F, 1.0F)
            .sounds(BlockSoundGroup.METAL)
            .emissiveLighting(AbstractBlock.AbstractBlockState::isFullCube)
            .luminance(5));

    public static final Block C_WIRE_7 = new GlazedTerracottaBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_WIRE_8 = new GlazedTerracottaBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_BRIDGE_LEFT_2 = new UniDirectionalSlabBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block C_BRIDGE_RIGHT_2 = new UniDirectionalSlabBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block VENT_FAN = new GlazedTerracottaBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .nonOpaque()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block TV = new GlazedTerracottaBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .nonOpaque()
            .strength(3.0F, 45.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block BUTTERCUP_1 = new GlazedTerracottaBlock(FabricBlockSettings
            .of(Material.SOLID_ORGANIC)
            .breakInstantly()
            .nonOpaque()
            .noCollision()
            .sounds(BlockSoundGroup.GRASS));

    public static final Block BUTTERCUP_2 = new GlazedTerracottaBlock(FabricBlockSettings
            .of(Material.SOLID_ORGANIC)
            .breakInstantly()
            .nonOpaque()
            .noCollision()
            .sounds(BlockSoundGroup.GRASS));

    public static final Block BUTTERCUP_3 = new GlazedTerracottaBlock(FabricBlockSettings
            .of(Material.SOLID_ORGANIC)
            .breakInstantly()
            .nonOpaque()
            .noCollision()
            .sounds(BlockSoundGroup.GRASS));

    public static final Block TL_BUTTERCUP = new GlazedTerracottaBlock(FabricBlockSettings
            .of(Material.SOLID_ORGANIC)
            .breakInstantly()
            .nonOpaque()
            .noCollision()
            .sounds(BlockSoundGroup.GRASS));

    public static final Block VINE_GRAY = new VineBlock(AbstractBlock.Settings
            .of(Material.REPLACEABLE_PLANT)
            .noCollision()
            .nonOpaque()
            .ticksRandomly()
            .strength(0.2F)
            .sounds(BlockSoundGroup.VINE));










    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "corruption"), CORRUPTION);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "chaotic_corruption"), CHAOTIC_CORRUPTION);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "underground_portal"), UNDERGROUND_PORTAL);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "netherground_portal"), NETHERGROUND_PORTAL);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "yellow_flower_bed"), YELLOW_FLOWER_BED);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "kindness_shield_block"), KINDNESS_SHIELD_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "barrier"), BARRIER);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "omega_stone_bricks1"), OMEGA_STONE_BRICKS1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "superheated_obsidian"), SUPERHEATED_OBSIDIAN);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "monster_soul_light_block1"), MONSTER_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "kindness_soul_light_block1"), KINDNESS_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "justice_soul_light_block1"), JUSTICE_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "bravery_soul_light_block1"), BRAVERY_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "perseverance_soul_light_block1"), PERSEVERANCE_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "patience_soul_light_block1"), PATIENCE_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "integrity_soul_light_block1"), INTEGRITY_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "determination_soul_light_block1"), DETERMINATION_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "dark_glowstone"), DARK_GLOWSTONE);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "menu_block_black1"), MENU_BLOCK_BLACK1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "menu_block_white1"), MENU_BLOCK_WHITE1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "soul_crafting_table"), SOUL_CRAFTING_TABLE);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "the_ruins_grass_block"), THE_RUINS_GRASS_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "the_ruins_dirt"), THE_RUINS_DIRT);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "titanium_block"), TITANIUM_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "titanium_quartz_block"), TITANIUM_QUARTZ_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "kindness_shield2_block"), KINDNESS_SHIELD2_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "determination_shield_block"), DETERMINATION_SHIELD_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "aether_cloud_block_white_1"), AETHER_CLOUD_BLOCK_WHITE_1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "purified_corruption"), PURIFIED_CORRUPTION);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "determination_shield_block_to_air"), DETERMINATION_SHIELD_BLOCK_TO_AIR);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "kindness_shield2_block_to_air"), KINDNESS_SHIELD2_BLOCK_TO_AIR);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "fear_shield_block"), FEAR_SHIELD_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "fear_shield_block_to_air"), FEAR_SHIELD_BLOCK_TO_AIR);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "corruption_inactive"), CORRUPTION_INACTIVE);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "corruption_portal"), CORRUPTION_PORTAL);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "despair_soul_light_block1"), DESPAIR_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "immorality_soul_light_block1"), IMMORALITY_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "deceit_soul_light_block1"), DECEIT_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "apathy_soul_light_block1"), APATHY_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "recklessness_soul_light_block1"), RECKLESSNESS_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "dishonor_soul_light_block1"), DISHONOR_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "wrath_soul_light_block1"), WRATH_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "terror_soul_light_block1"), TERROR_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "hate_soul_light_block1"), HATE_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "corruption_soul_light_block1"), CORRUPTION_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "hope_soul_light_block1"), HOPE_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "fear_soul_light_block1"), FEAR_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "corrupted_monster_soul_light_block1"), CORRUPTED_MONSTER_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "aether_cloud_block_cyan_1"), AETHER_CLOUD_BLOCK_CYAN_1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "the_beneath_portal"), THE_BENEATH_PORTAL);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "statue_player_1"), STATUE_PLAYER_1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "omega_portal_1"), OMEGA_PORTAL_1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "dragon_block"), DRAGON_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "overwrite_determination_soul_light_block1"), OVERWRITE_DETERMINATION_SOUL_LIGHT_BLOCK1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "teal_flower_bed"), TEAL_FLOWER_BED);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "red_flower_bed"), RED_FLOWER_BED);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "deepslate"), DEEPSLATE);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "cobbled_deepslate"), COBBLED_DEEPSLATE);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "polished_deepslate"), POLISHED_DEEPSLATE);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "deepslate_bricks"), DEEPSLATE_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "deepslate_tiles"), DEEPSLATE_TILES);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "chiseled_deepslate"), CHISELED_DEEPSLATE);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "cracked_deepslate_bricks"), CRACKED_DEEPSLATE_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "cracked_deepslate_tiles"), CRACKED_DEEPSLATE_TILES);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "cobbled_deepslate_slab"), COBBLED_DEEPSLATE_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "deepslate_brick_slab"), DEEPSLATE_BRICK_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "polished_deepslate_slab"), POLISHED_DEEPSLATE_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "deepslate_tile_slab"), DEEPSLATE_TILE_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "cobbled_deepslate_stairs"), COBBLED_DEEPSLATE_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "deepslate_brick_stairs"), DEEPSLATE_BRICK_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "deepslate_tile_stairs"), DEEPSLATE_TILE_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "polished_deepslate_stairs"), POLISHED_DEEPSLATE_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "cobbled_deepslate_wall"), COBBLED_DEEPSLATE_WALL);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "deepslate_brick_wall"), DEEPSLATE_BRICK_WALL);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "deepslate_tile_wall"), DEEPSLATE_TILE_WALL);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "polished_deepslate_wall"), POLISHED_DEEPSLATE_WALL);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "uni_light_block"), UNI_LIGHT_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "start_grass"), START_GRASS);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "start_path_1"), START_PATH_1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "start_path_2"), START_PATH_2);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "start_path_3"), START_PATH_3);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "ruins_bricks"), RUINS_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "ruins_bricks_2"), RUINS_BRICKS_2);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "path_r_1"), PATH_R_1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "path_r_2"), PATH_R_2);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "path_r_3"), PATH_R_3);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "red_leaves"), RED_LEAVES);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "snowdin_grass"), SNOWDIN_GRASS);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "snowdin_dirt"), SNOWDIN_DIRT);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "snowdin_path_1"), SNOWDIN_PATH_1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "waterfall_ground"), WATERFALL_GROUND);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "waterfall_wall_1"), WATERFALL_WALL_1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "waterfall_wall_2"), WATERFALL_WALL_2);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "hotland_ground"), HOTLAND_GROUND);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "hotland_ground_crack"), HOTLAND_GROUND_CRACK);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "hotland_pipe_turn"), HOTLAND_PIPE_TURN);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "hotland_pipe_straight"), HOTLAND_PIPE_STRAIGHT);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "hotland_pipe_turn_2"), HOTLAND_PIPE_TURN_2);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "hotland_pipe_straight_2"), HOTLAND_PIPE_STRAIGHT_2);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "hotland_arrow"), HOTLAND_ARROW);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "nh_wall"), NH_WALL);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "nh_ground"), NH_GROUND);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "gray_leaves"), GRAY_LEAVES);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "leaves_1"), LEAVES_1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "hotland_conveyor"), HOTLAND_CONVEYOR);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "tl_ground"), TL_GROUND);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "tl_wall_1"), TL_WALL_1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "tl_wall_2"), TL_WALL_2);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "nh_ground_2"), NH_GROUND_2);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "nh_ground_3"), NH_GROUND_3);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "black_1"), BLACK_1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_pipe"), C_PIPE);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_pipe_damaged"), C_PIPE_DAMAGED);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_pipe_end"), C_PIPE_END);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_pipe_start"), C_PIPE_START);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_pipe_2"), C_PIPE_2);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_wire_1"), C_WIRE_1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_wire_2"), C_WIRE_2);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_wire_3"), C_WIRE_3);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_wire_4"), C_WIRE_4);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_wall_1"), C_WALL_1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_wall_2"), C_WALL_2);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_wall_3"), C_WALL_3);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_wall_4"), C_WALL_4);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_ground_1"), C_GROUND_1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_void"), C_VOID);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "waterfall_tall_grass"), WATERFALL_TALL_GRASS);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "waterfall_grass"), WATERFALL_GRASS);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "waterfall_mushrooms"), WATERFALL_MUSHROOMS);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "waterfall_crystals_1"), WATERFALL_CRYSTALS_1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "waterfall_crystals_2"), WATERFALL_CRYSTALS_2);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "waterfall_crystals_3"), WATERFALL_CRYSTALS_3);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "waterfall_crystals_4"), WATERFALL_CRYSTALS_4);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "waterfall_ground_cracked"), WATERFALL_GROUND_CRACKED);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "waterfall_ground_2"), WATERFALL_GROUND_2);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "waterfall_ground_3"), WATERFALL_GROUND_3);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "waterfall_ground_4"), WATERFALL_GROUND_4);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "waterfall_ground_5"), WATERFALL_GROUND_5);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "waterfall_water"), WATERFALL_WATER);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "echo_flower"), ECHO_FLOWER);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "snowdin_flower"), SNOWDIN_FLOWER);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "waterfall_wood_slab"), WATERFALL_WOOD_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "waterfall_wood_wall"), WATERFALL_WOOD_WALL);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "waterfall_wood_slab_2"), WATERFALL_WOOD_SLAB_2);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "waterfall_wood_wall_2"), WATERFALL_WOOD_WALL_2);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_wire_plate"), C_WIRE_PLATE);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_glass"), C_GLASS);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_glass_2"), C_GLASS_2);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_bridge_left"), C_BRIDGE_LEFT);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_bridge_right"), C_BRIDGE_RIGHT);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "hotland_wire"), HOTLAND_WIRE);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_wire_5"), C_WIRE_5);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_wire_6"), C_WIRE_6);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_wire_plate_2"), C_WIRE_PLATE_2);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "arch_purple_1"),ARCH_PURPLE_1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "arch_purple_2"), ARCH_PURPLE_2);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "arch_gray_1"), ARCH_GRAY_1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "arch_gray_2"), ARCH_GRAY_2);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "lab_wall"), LAB_WALL);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "lab_ground"), LAB_GROUND);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "lab_ground_2"), LAB_GROUND_2);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "vine"), VINE);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "red_leaves_carpet"), RED_LEAVES_CARPET);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "gray_leaves_carpet"), GREY_LEAVES_CARPET);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "spikes_1"), SPIKES_1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "spikes_2"), SPIKES_2);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_carpet"), C_CARPET);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_wire_wall"), C_WIRE_WALL);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_wire_7"), C_WIRE_7);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_wire_8"), C_WIRE_8);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_bridge_left_2"), C_BRIDGE_LEFT_2);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "c_bridge_right_2"), C_BRIDGE_RIGHT_2);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "vent_fan"), VENT_FAN);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "tv"), TV);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "buttercup_1"), BUTTERCUP_1);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "buttercup_2"), BUTTERCUP_2);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "buttercup_3"), BUTTERCUP_3);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "tl_buttercup"), TL_BUTTERCUP);
        Registry.register(Registry.BLOCK, new Identifier(UniformSouls.MOD_ID, "vine_gray"), VINE_GRAY);








    }
}
