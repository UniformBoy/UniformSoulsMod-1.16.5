package com.uniform.uniformsouls.misc;

import com.uniform.uniformsouls.UniformSouls;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class JusticeMonsterSoulTag {
    public static final Tag<Item> JUSTICE_MONSTER_SOUL_ITEM = TagRegistry.item(new Identifier(UniformSouls.MOD_ID,"justice_monster_soul_item"));
}