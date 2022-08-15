package com.uniform.uniformsouls.misc;

import com.uniform.uniformsouls.UniformSouls;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class DishonorWeaponTag {
    public static final Tag<Item> DISHONOR_WEAPON_ITEM = TagRegistry.item(new Identifier(UniformSouls.MOD_ID,"dishonor_weapon_item"));
}