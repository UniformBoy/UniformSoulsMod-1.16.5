package com.uniform.uniformsouls.mixins;

import com.uniform.uniformsouls.UniformSouls;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(MinecraftServer.class)
public class UniformSoulsMixins {
    public void onInitialize() {

    }
}
