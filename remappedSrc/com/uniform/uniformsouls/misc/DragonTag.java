package com.uniform.uniformsouls.misc;

import com.uniform.uniformsouls.UniformSouls;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class DragonTag {
    public static final Tag<Item> DRAGON_ITEM = TagRegistry.item(new Identifier(UniformSouls.MOD_ID,"dragon_item"));

    public static final Tag<Item> DRAGON_ELYTRA = TagRegistry.item(new Identifier(UniformSouls.MOD_ID, "dragon_elytra"));

}
