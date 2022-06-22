package com.uniform.uniformsouls.misc;

import com.uniform.uniformsouls.UniformSouls;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class PatienceMonsterSoulTag {
    public static final Tag<Item> PATIENCE_MONSTER_SOUL_ITEM = TagRegistry.item(new Identifier(UniformSouls.MOD_ID,"patience_monster_soul_item"));
}