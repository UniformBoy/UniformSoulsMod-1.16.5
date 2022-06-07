package com.uniform.uniformsouls.cardinal;

import com.uniform.uniformsouls.registry.SoulType;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.nbt.NbtCompound;

public class SyncedSoulMagicIntComponent implements SoulMagicIntComponent, AutoSyncedComponent {
    private int value;

    private Object provider;

    public void SoulMagicIntComponent(Object provider) {
        this.provider = provider;
    }

    public SyncedSoulMagicIntComponent(int value, Object provider) {
        this.value = value;
        this.provider = provider;
    }

    public void setValue(int value) {
        this.value = value;
        SoulMagicComponents.SOUL_MAGIC.sync(this.provider); // assuming MAGIK is the right key for this component
    }

    @Override
    public int getCurrentMagic() {

        return this.soulType.getCurrentMana();
    }

    @Override
    public int getMaxMagic() {
        if (this.soulType != null) { return soulType.getMaxMana(); } else {
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
    public SoulType setSoulType() {

        return this.getSoulType();
    }

    @Override
    public void setCurrentMagic(int value) {
        this.soulType.setCurrentMana(value);
    }


    @Override
    public void readFromNbt(NbtCompound nbtCompound) {

    }

    @Override
    public void writeToNbt(NbtCompound nbtCompound) {

    }

    // getters, setters, and serialization methods omitted for brevity
}