package com.uniform.uniformsouls.cardinal;

import com.uniform.uniformsouls.registry.SoulType;
import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;
import net.minecraft.nbt.NbtCompound;

public interface SoulMagicIntComponent extends ComponentV3 {
    int getCurrentMagic();
    int getMaxMagic();
    int getRegenRate();
    SoulType getSoulType();

    void setCurrentMagic(int value);
    void setSoulType(SoulType type);
    void decrementMagic(int value);
    void incrementMagic(int value);
}

class RandomSoulMagicIntComponent implements SoulMagicIntComponent, ServerTickingComponent, AutoSyncedComponent {
    @Override
    public int getCurrentMagic() {

        return this.soulType.getCurrentMagic();
    }

    @Override
    public int getMaxMagic() {
        if (this.soulType != null) { return soulType.getMaxMagic(); } else {
            return 100;
        }
    }

    @Override
    public int getRegenRate() {
        if (this.soulType != null) { return soulType.getRegenRate(); } else {
            return 100;
        }
    }

    private SoulType soulType;

    @Override
    public SoulType getSoulType() {

        return this.soulType;
    }

    @Override
    public void setSoulType(SoulType type) {
        this.soulType = type;
    }

    @Override
    public void decrementMagic(int value) {
        soulType.decrementMagic();
    }

    @Override
    public void incrementMagic(int value) {
        soulType.incrementMagic();
    }

    @Override
    public void setCurrentMagic(int value) {
        this.soulType.setCurrentMagic(value);
    }


    @Override
    public void readFromNbt(NbtCompound nbtCompound) {

    }

    @Override
    public void writeToNbt(NbtCompound nbtCompound) {

    }

    @Override
    public void serverTick() {
        this.incrementMagic(getRegenRate());
        setCurrentMagic(getCurrentMagic()+getRegenRate());
    }
}