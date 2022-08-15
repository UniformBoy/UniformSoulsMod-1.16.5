package com.uniform.uniformsouls.items;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShield;
import com.github.crimsondawn45.fabricshieldlib.lib.object.RepairItemType;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.Tag;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class WeaponShieldItem extends SwordItem implements FabricShield {

    private int cooldownTicks;
    private int enchantability;

    //Repair stuff
    private Item[] repairItems;
    private Tag<Item> repairTag;
    private Ingredient repairIngredients;

    private RepairItemType repairType;

    /**
     * @param settings item settings.
     * @param cooldownTicks ticks shield will be disabled for when it with axe. Vanilla: 100
     * @param enchantability enchantability of shield. Vanilla: 14
     */

    public WeaponShieldItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, int cooldownTicks, int enchantability, Item... repairItems) {
        super(toolMaterial, attackDamage, attackSpeed, settings);

        //Register dispenser equip behavior
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);

        //Register that item has a blocking model
        if(FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            FabricModelPredicateProviderRegistry.register(new Identifier("blocking"), (itemStack, clientWorld, livingEntity) -> {
                return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
            });
        }

        this.cooldownTicks = cooldownTicks;
        this.enchantability = enchantability;
        this.repairType = RepairItemType.ARRAY;
        this.repairItems = repairItems;
    }

    /**
     * @param settings item settings.
     * @param cooldownTicks ticks shield will be disabled for when it with axe. Vanilla: 100
     * @param material tool material.
     */
    public WeaponShieldItem(Settings settings, int attackDamage, float attackSpeed, int cooldownTicks, ToolMaterial material) {
        super(material, attackDamage, attackSpeed, settings.maxDamage(material.getDurability())); //Make durability match material

        //Register dispenser equip behavior
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);

        //Register that item has a blocking model
        if(FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            FabricModelPredicateProviderRegistry.register(new Identifier("blocking"), (itemStack, clientWorld, livingEntity) -> {
                return livingEntity != null && !livingEntity.isSneaking() && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
            });
        }

        this.cooldownTicks = cooldownTicks;
        this.enchantability = material.getEnchantability();
        this.repairType = RepairItemType.INGREDIENT;
        this.repairIngredients = material.getRepairIngredient();
    }

    /**
     * @param settings item settings.
     * @param cooldownTicks ticks shield will be disabled for when it with axe. Vanilla: 100
     * @param enchantability enchantability of shield. Vanilla: 14
     * @param repairItemTag item tag for repairing shield
     */
    public WeaponShieldItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, int cooldownTicks, int enchantability, Tag.Identified<Item> repairItemTag) {
        super(toolMaterial, attackDamage, attackSpeed, settings); //Make durability match material

        //Register dispenser equip behavior
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);

        //Register that item has a blocking model
        if(FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            FabricModelPredicateProviderRegistry.register(new Identifier("blocking"), (itemStack, clientWorld, livingEntity) -> {
                return livingEntity != null && !livingEntity.isSneaking() && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
            });
        }

        this.cooldownTicks = cooldownTicks;
        this.enchantability = enchantability;
        this.repairType = RepairItemType.TAG;
        this.repairTag = repairItemTag;
    }

    @Override
    public int getCooldownTicks() {
        return this.cooldownTicks;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BLOCK;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        return TypedActionResult.consume(itemStack);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        switch(this.repairType) {
            case ARRAY:
                for(Item item : this.repairItems) {
                    if(item.equals(ingredient.getItem())) {
                        return true;
                    }
                }
                return false;
            case TAG:           return this.repairTag.contains(ingredient.getItem());
            case INGREDIENT:    return this.repairIngredients.test(ingredient);
            default:
                return false;
        }
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return !stack.hasEnchantments();
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public boolean supportsBanner() {
        return false;
    }
}