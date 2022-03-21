package runasstrive.model.cards.ablilities;

import runasstrive.model.Level;
import runasstrive.model.cards.Card;
import runasstrive.model.cards.entity.Entity;

public abstract class Ability extends Card {
    protected final int cost;
    protected int physicalDamage;
    protected int magicalDamage;
    protected int reflectPhysicalDamage;
    protected int reflectMagicalDamage;
    protected int physicalShield;
    protected int magicalShield;
    protected boolean willIncreaseFocusPoints;
    protected boolean breakFocus;


    protected Ability(Level level, int cost) {
        super(level);
        this.cost = cost;
    }

    public void use(Entity<?> caster, Entity<?> target) {
        initValues();
        caster.shield(physicalShield, magicalShield);
        caster.reflect(reflectPhysicalDamage, reflectMagicalDamage);
        target.takeDamage(physicalDamage, magicalDamage);
        caster.takeDamage(target.getReflectedPhysicalDamage(), target.getReflectedMagicalDamage());
        caster.focus(willIncreaseFocusPoints);
        target.breakFocus(breakFocus);
    }

    public abstract void initValues();

    public abstract int getDamage(Class<?> caller);
}
