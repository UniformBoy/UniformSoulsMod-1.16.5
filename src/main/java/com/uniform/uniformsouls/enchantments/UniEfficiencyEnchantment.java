package com.uniform.uniformsouls.enchantments;

import net.minecraft.enchantment.*;
import net.minecraft.entity.EquipmentSlot;

public class UniEfficiencyEnchantment extends EfficiencyEnchantment {

    public UniEfficiencyEnchantment() {
        super(Rarity.RARE, EquipmentSlot.MAINHAND);
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
        return super.canAccept(other) && other != Enchantments.EFFICIENCY;
    }
}

