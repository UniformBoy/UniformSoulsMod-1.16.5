package com.uniform.uniformsouls.items.soul_weapons;

            import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShield;
            import com.github.crimsondawn45.fabricshieldlib.lib.object.RepairItemType;
            import com.uniform.uniformsouls.UniformSouls;
            import com.uniform.uniformsouls.registry.ModItems;
            import net.fabricmc.api.EnvType;
            import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
            import net.fabricmc.loader.api.FabricLoader;
            import net.minecraft.block.DispenserBlock;
            import net.minecraft.entity.player.PlayerEntity;
            import net.minecraft.item.*;
            import net.minecraft.nbt.NbtCompound;
            import net.minecraft.recipe.Ingredient;
            import net.minecraft.sound.SoundEvents;
            import net.minecraft.stat.Stats;
            import net.minecraft.tag.Tag;
            import net.minecraft.util.Hand;
            import net.minecraft.util.Identifier;
            import net.minecraft.util.TypedActionResult;
            import net.minecraft.util.UseAction;
            import net.minecraft.world.World;

public class CreativityBattleAxe extends SwordItem implements FabricShield {

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

    public CreativityBattleAxe(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, int cooldownTicks, int enchantability, Item... repairItems) {
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
    public CreativityBattleAxe(Settings settings, int attackDamage, float attackSpeed, int cooldownTicks, ToolMaterial material) {
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
    public CreativityBattleAxe(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, int cooldownTicks, int enchantability, Tag.Identified<Item> repairItemTag) {
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
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){
        if (!playerEntity.isSneaking()) {
            ItemStack itemStack = playerEntity.getStackInHand(hand);
            playerEntity.setCurrentHand(hand);

            return TypedActionResult.consume(itemStack);
        } else {
            ItemStack itemStack = new ItemStack(ModItems.CREATIVITY_SOUL);
            ItemStack itemStack2 = playerEntity.getStackInHand(hand);
            NbtCompound nbtCompound = itemStack2.getTag();
            if (nbtCompound != null) {
                itemStack.setTag(nbtCompound.copy());
            }
            itemStack2.decrement(1);
            playerEntity.getItemCooldownManager().set(this, 50);

            playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
            playerEntity.playSound(UniformSouls.SUMMON_SWORD_OR_SHIELD_1_EVENT, 0.5F, 1.0F);
            if (itemStack2.isEmpty()) {
                return TypedActionResult.success(itemStack, world.isClient());
            } else {
                if (!playerEntity.inventory.insertStack(itemStack.copy())) {
                    playerEntity.dropItem(itemStack, false);
                }

                return TypedActionResult.success(itemStack2, world.isClient());
            }
        }
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