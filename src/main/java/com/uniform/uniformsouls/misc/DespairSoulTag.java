package com.uniform.uniformsouls.misc;

import com.uniform.uniformsouls.UniformSouls;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class DespairSoulTag {
    public static final Tag<Item> DESPAIR_SOUL_ITEM = TagRegistry.item(new Identifier(UniformSouls.MOD_ID,"despair_soul_item"));
}