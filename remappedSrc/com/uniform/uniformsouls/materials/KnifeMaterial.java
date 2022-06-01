package com.uniform.uniformsouls.materials;

import com.uniform.uniformsouls.registry.ModItems;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class KnifeMaterial implements ToolMaterial {

    public static final KnifeMaterial INSTANCE = new KnifeMaterial();

    public int getDurability() {
        return 99999;
    }

    public float getMiningSpeedMultiplier() {
        return 8.5F;
    }

    public float getAttackDamage() {
        return 99.0F;
    }


    public int getMiningLevel() {
        return 5;
    }

    public int getEnchantability() {
        return 0;
    }

    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }
}
