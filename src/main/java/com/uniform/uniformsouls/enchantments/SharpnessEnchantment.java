package com.uniform.uniformsouls.enchantments;

import net.minecraft.enchantment.*;
import net.minecraft.entity.EquipmentSlot;

public class SharpnessEnchantment extends DamageEnchantment {

    public SharpnessEnchantment() {
        super(Rarity.RARE, 0, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinLevel() {
        return 6;
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
        return super.canAccept(other) && other != Enchantments.SHARPNESS;
    }
}

