package com.uniform.uniformsouls.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.entity.EquipmentSlot;

public class UniProtectionEnchantment extends ProtectionEnchantment {

    private static final EquipmentSlot[] ALL_ARMOR;

    static {
        ALL_ARMOR = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
    }

    public UniProtectionEnchantment() {
        super(Rarity.RARE, Type.ALL, ALL_ARMOR);
    }

    @Override
    public int getMinLevel() {
        return 5;
    }

    public int getMaxLevel() {
        return 10;
    }

    public boolean isTreasure() {
        return false;
    }

    public boolean isAvailableForEnchantedBookOffer() {
        return false;
    }

    public boolean isAvailableForRandomSelection() {
        return false;
    }

    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.PROTECTION;
    }
}

