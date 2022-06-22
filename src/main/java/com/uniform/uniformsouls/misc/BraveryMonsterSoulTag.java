package com.uniform.uniformsouls.misc;

import com.uniform.uniformsouls.UniformSouls;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class BraveryMonsterSoulTag {
    public static final Tag<Item> BRAVERY_MONSTER_SOUL_ITEM = TagRegistry.item(new Identifier(UniformSouls.MOD_ID,"bravery_monster_soul_item"));
}