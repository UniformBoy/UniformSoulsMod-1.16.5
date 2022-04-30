package com.uniform.uniformsouls.misc;

import com.uniform.uniformsouls.UniformSouls;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class SwingAnim1Tag {
    public static final Tag<Item> SWING_ANIM_1_ITEM = TagRegistry.item(new Identifier(UniformSouls.MOD_ID,"swing_anim_1_item"));
}