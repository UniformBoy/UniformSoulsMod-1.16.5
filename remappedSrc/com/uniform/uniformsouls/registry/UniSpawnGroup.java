//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.uniform.uniformsouls.registry;

import com.mojang.serialization.Codec;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import net.minecraft.util.StringIdentifiable;

public enum UniSpawnGroup implements StringIdentifiable {
    CORRUPTION("corrutpion", 300, false, false, 256),
    MONSTER("monster", 70, false, false, 128),
    CREATURE("creature", 10, true, true, 128),
    AMBIENT("ambient", 15, true, false, 128),
    WATER_CREATURE("water_creature", 5, true, false, 128),
    WATER_AMBIENT("water_ambient", 20, true, false, 64),
    MISC("misc", -1, true, true, 128);

    public static final Codec<UniSpawnGroup> CODEC = StringIdentifiable.createCodec(UniSpawnGroup::values, UniSpawnGroup::byName);
    public static final Map<String, UniSpawnGroup> BY_NAME = (Map)Arrays.stream(values()).collect(Collectors.toMap(UniSpawnGroup::getName, (spawnGroup) -> {
        return spawnGroup;
    }));
    public final int capacity;
    public final boolean peaceful;
    public final boolean animal;
    public final String name;
    public final int despawnStartRange = 32;
    public final int immediateDespawnRange;

    private UniSpawnGroup(String name, int spawnCap, boolean peaceful, boolean bl, int j) {
        this.name = name;
        this.capacity = spawnCap;
        this.peaceful = peaceful;
        this.animal = bl;
        this.immediateDespawnRange = j;
    }

    public String getName() {
        return this.name;
    }

    public String asString() {
        return this.name;
    }

    public static UniSpawnGroup byName(String name) {
        return (UniSpawnGroup)BY_NAME.get(name);
    }

    public int getCapacity() {
        return this.capacity;
    }

    public boolean isPeaceful() {
        return this.peaceful;
    }

    public boolean isAnimal() {
        return this.animal;
    }

    public int getImmediateDespawnRange() {
        return this.immediateDespawnRange;
    }

    public int getDespawnStartRange() {
        return 32;
    }
}
