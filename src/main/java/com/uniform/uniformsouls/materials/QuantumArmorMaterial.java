package com.uniform.uniformsouls.materials;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.registry.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class QuantumArmorMaterial implements ArmorMaterial {

    //Durability Head To Feet From Right To Left

    private static final int[] DURABILITY = {700,700, 700, 700};
    private static final int[] PROTECTION = {3, 6, 8, 3};
    public static final QuantumArmorMaterial INSTANCE = new QuantumArmorMaterial();


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
        return 20;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.BLOCK_NETHERITE_BLOCK_PLACE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.TITANIUM_QUARTZ_INGOT);
    }

    @Override
    public String getName() {
        return "quantum";
    }

    @Override
    public float getToughness() {
        return 3;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.05F;
    }

}
