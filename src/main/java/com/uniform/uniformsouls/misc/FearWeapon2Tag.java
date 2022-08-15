package com.uniform.uniformsouls.misc;

import com.uniform.uniformsouls.UniformSouls;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class FearWeapon2Tag {
    public static final Tag<Item> FEAR_WEAPON_ITEM_2 = TagRegistry.item(new Identifier(UniformSouls.MOD_ID,"fear_weapon_item_2"));
}