package com.uniform.uniformsouls.materials;

import com.uniform.uniformsouls.UniformSouls;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class HeartLocketArmorMaterial implements ArmorMaterial {

    private static final int[] DURABILITY = {9999, 9999 ,9999 ,9999};
    private static final int[] PROTECTION = {10, 10, 10, 10};
    public static final HeartLocketArmorMaterial INSTANCE = new HeartLocketArmorMaterial();

    @Override
    public int getDurability(EquipmentSlot slot) {
        return DURABILITY[slot.getEntitySlotId()];
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }

    @Override
    public String getName() {
        return "heart_locket";
    }

    @Override
    public float getToughness() {
        return 5;
    }

    @Override
    public float getKnockbackResistance() {
        return 0F;
    }

}
