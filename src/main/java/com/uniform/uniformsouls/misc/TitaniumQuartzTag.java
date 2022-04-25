package com.uniform.uniformsouls.misc;

import com.uniform.uniformsouls.UniformSouls;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class TitaniumQuartzTag {
    public static final Tag<Item> TITANIUM_QUARTZ_ITEM = TagRegistry.item(new Identifier(UniformSouls.MOD_ID,"titanium_quartz_item"));
}