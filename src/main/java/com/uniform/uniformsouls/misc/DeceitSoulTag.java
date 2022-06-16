package com.uniform.uniformsouls.misc;

import com.uniform.uniformsouls.UniformSouls;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class DeceitSoulTag {
    public static final Tag<Item> DECEIT_SOUL_ITEM = TagRegistry.item(new Identifier(UniformSouls.MOD_ID,"deceit_soul_item"));
}