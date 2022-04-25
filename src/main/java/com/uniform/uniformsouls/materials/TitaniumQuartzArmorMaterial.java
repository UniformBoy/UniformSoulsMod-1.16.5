package com.uniform.uniformsouls.materials;

import com.uniform.uniformsouls.UniformSouls;
import com.uniform.uniformsouls.registry.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

public class TitaniumQuartzArmorMaterial implements ArmorMaterial {

    //Durability Head To Feet From Right To Left

    private static final int[] DURABILITY = {1533, 1615, 1656, 1451};
    private static final int[] PROTECTION = {6, 9, 11, 6};
    public static final TitaniumQuartzArmorMaterial INSTANCE = new TitaniumQuartzArmorMaterial();


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
        return UniformSouls.TITANIUM_QUARTZ_ARMOR_EQUIP_1_EVENT;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.TITANIUM_QUARTZ_INGOT);
    }

    @Override
    public String getName() {
        return "titanium_quartz";
    }

    @Override
    public float getToughness() {
        return 6;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.15F;
    }

}
