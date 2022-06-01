package com.uniform.uniformsouls.materials;

import com.uniform.uniformsouls.registry.ModItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class DragonToolMaterial implements ToolMaterial {

    public static final DragonToolMaterial INSTANCE = new DragonToolMaterial();

    public int getDurability() {
        return 3000;
    }

    public float getMiningSpeedMultiplier() {
        return 25.0F;
    }

    public float getAttackDamage() {
        return 6.0F;
    }

    public int getMiningLevel() {
        return 6;
    }

    public int getEnchantability() {
        return 20;
    }

    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.DRAGON_INGOT);
    }

}
