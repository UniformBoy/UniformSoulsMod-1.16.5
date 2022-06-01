package com.uniform.uniformsouls.materials;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class DefaultSoulToolMaterial implements ToolMaterial {

    public static final DefaultSoulToolMaterial INSTANCE = new DefaultSoulToolMaterial();

    public int getDurability() {
        return -1;
    }

    public float getMiningSpeedMultiplier() {
        return 8.5F;
    }

    public float getAttackDamage() {
        return 5.0F;
    }

    public int getMiningLevel() {
        return 5;
    }

    public int getEnchantability() {
        return 0;
    }

    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.STICK);
    }

}
