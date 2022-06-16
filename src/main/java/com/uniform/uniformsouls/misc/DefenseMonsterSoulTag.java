package com.uniform.uniformsouls.misc;

import com.uniform.uniformsouls.UniformSouls;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class DefenseMonsterSoulTag {
    public static final Tag<Item> DEFENSE_MONSTER_SOUL_ITEM = TagRegistry.item(new Identifier(UniformSouls.MOD_ID,"defense_monster_soul_item"));
}