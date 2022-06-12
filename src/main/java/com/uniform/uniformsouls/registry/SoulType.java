package com.uniform.uniformsouls.registry;

public class SoulType {
    public static SoulType DETERMINATION = new SoulType(20,1000);
    int maxMagic;
    int regenRate;
    int currentMagic;
    int setCurrentMagic;
    public SoulType(int regenRate, int maxMagic) {
        this.maxMagic=maxMagic;
        this.regenRate=regenRate;
    }

    public int getMaxMagic() {
        return maxMagic;
    }

    public int getRegenRate() {
        return regenRate;
    }

    public int getCurrentMagic(){
        return this.currentMagic;
    }

    public void setCurrentMagic(int value){
        this.currentMagic = value;
    }

    public void decrementMagic() {
        this.currentMagic--;
    }

    public void incrementMagic() {
        this.currentMagic++;
    }


// etc
}