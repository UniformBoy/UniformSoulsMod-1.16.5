package com.uniform.uniformsouls.cardinal;

import com.uniform.uniformsouls.UniformSouls;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import nerdhub.cardinal.components.api.util.RespawnCopyStrategy;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class SoulMagicComponents implements EntityComponentInitializer{
    public static final ComponentKey<SoulMagicIntComponent> SOUL_MAGIC =
            ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier("uniformsouls:soul_magic"), SoulMagicIntComponent.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        // Add the component to every PlayerEntity instance, and copy it on respawn with keepInventory
        registry.registerForPlayers(SOUL_MAGIC, player -> new RandomSoulMagicIntComponent(), RespawnCopyStrategy.ALWAYS_COPY);

    }



}