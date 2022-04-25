package com.uniform.uniformsouls.materials;

import com.uniform.uniformsouls.registry.ModItems;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class TitaniumQuartzToolMaterial implements ToolMaterial {

    public static final TitaniumQuartzToolMaterial INSTANCE = new TitaniumQuartzToolMaterial();

    public int getDurability() {
        return 2501;
    }

    public float getMiningSpeedMultiplier() {
        return 10.0F;
    }

    public float getAttackDamage() {
        return 5.0F;
    }

    public int getMiningLevel() {
        return 5;
    }

    public int getEnchantability() {
        return 20;
    }

    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.TITANIUM_QUARTZ_INGOT);
    }

}
