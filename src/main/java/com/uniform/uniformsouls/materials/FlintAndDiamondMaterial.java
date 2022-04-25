package com.uniform.uniformsouls.materials;

import com.uniform.uniformsouls.registry.ModItems;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class FlintAndDiamondMaterial implements ToolMaterial {

    public static final FlintAndDiamondMaterial INSTANCE = new FlintAndDiamondMaterial();

    public int getDurability() {
        return 1;
    }

    public float getMiningSpeedMultiplier() {
        return 0;
    }

    public float getAttackDamage() {
        return 0;
    }

    public int getMiningLevel() {
        return 0;
    }

    public int getEnchantability() {
        return 0;
    }

    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.DIAMOND);
    }
}

