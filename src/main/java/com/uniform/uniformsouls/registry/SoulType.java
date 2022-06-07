package com.uniform.uniformsouls.registry;

public class SoulType {
    public static SoulType DETERMINATION = new SoulType(20,1000);
    int maxMana;
    int regenRate;
    int currentMana;
    int setCurrentMana;
    public SoulType(int regenRate, int maxMana) {
        this.maxMana=maxMana;
        this.regenRate=regenRate;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public int getRegenRate() {
        return regenRate;
    }

    public int getCurrentMana(){
        return this.currentMana;
    }

    public void setCurrentMana(int value){
        this.currentMana = value;
    }


// etc
}