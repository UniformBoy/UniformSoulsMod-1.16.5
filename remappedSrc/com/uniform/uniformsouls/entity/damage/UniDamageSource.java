package com.uniform.uniformsouls.entity.damage;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class UniDamageSource extends DamageSource {
    public UniDamageSource(String name) {
        super(name);
    }
    public boolean bypassesArmor;
    public boolean outOfWorld;
    public boolean unblockable;
    public float exhaustion = 0.1F;
    public boolean fire;
    public boolean projectile;
    public boolean scaleWithDifficulty;
    public boolean magic;
    public boolean explosive;

    public DamageSource setBypassesArmor() {
        this.bypassesArmor = true;
        this.exhaustion = 0.0F;
        return this;
    }

    public DamageSource setBypass() {
        this.unblockable = true;
        this.bypassesArmor = true;
        this.exhaustion = 0.0F;
        return this;
    }

}
