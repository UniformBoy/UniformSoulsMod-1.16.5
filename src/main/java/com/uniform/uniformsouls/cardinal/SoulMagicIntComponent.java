package com.uniform.uniformsouls.cardinal;

import com.uniform.uniformsouls.registry.SoulType;
import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.MathHelper;

public interface SoulMagicIntComponent extends ComponentV3 {
    int getCurrentMagic();
    int getMaxMagic();
    int getRegenRate();
    SoulType getSoulType();
    SoulType setSoulType();

    void setCurrentMagic(int value);
}

class RandomSoulMagicIntComponent implements SoulMagicIntComponent, ServerTickingComponent {
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

    @Override
    public void serverTick() {
        setCurrentMagic(getCurrentMagic()+getRegenRate());
    }
}