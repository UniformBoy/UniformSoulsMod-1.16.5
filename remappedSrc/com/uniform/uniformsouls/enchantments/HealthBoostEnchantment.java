package com.uniform.uniformsouls.enchantments;

import com.uniform.uniformsouls.UniformSouls;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;

import java.util.Iterator;

public class HealthBoostEnchantment extends Enchantment {

    public HealthBoostEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[] {EquipmentSlot.CHEST});
    }
    @Override
    public int getMinPower(int level) {
        return 1;
    }

    public int getMaxPower(int level) {
        return 3;
    }
    public static boolean hasHealthBoost(LivingEntity entity) {
        return getEquipmentLevel(UniformSouls.HEALTH_BOOST, entity) > 0;
    }
    public static int getEquipmentLevel(Enchantment enchantment, LivingEntity entity) {
        Iterable<ItemStack> iterable = enchantment.getEquipment(entity).values();
        if (iterable == null) {
            return 0;
        } else {
            int i = 0;
            Iterator var4 = iterable.iterator();

            while(var4.hasNext()) {
                ItemStack itemStack = (ItemStack)var4.next();
                int j = getLevel(enchantment, itemStack);
                if (j > i) {
                    i = j;
                }
            }

            return i;
        }
    }
    public static int getLevel(Enchantment enchantment, ItemStack stack) {
        if (stack.isEmpty()) {
            return 0;
        } else {
            Identifier identifier = Registry.ENCHANTMENT.getId(enchantment);
            NbtList listTag = stack.getEnchantments();

            for(int i = 0; i < listTag.size(); ++i) {
                NbtCompound compoundTag = listTag.getCompound(i);
                Identifier identifier2 = Identifier.tryParse(compoundTag.getString("id"));
                if (identifier2 != null && identifier2.equals(identifier)) {
                    return MathHelper.clamp(compoundTag.getInt("lvl"), 0, 255);
                }
            }

            return 0;
        }

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

}