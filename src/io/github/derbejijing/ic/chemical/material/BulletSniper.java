package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class BulletSniper extends Chemical {

    public BulletSniper(int count, ChemicalPurity purity) {
        super("Bullet (sniper)", ChemicalItem.BULLET_SNIPER.material, ChemicalItem.BULLET_SNIPER.id, purity, ChemicalToxicity.NONE, ChemicalReactivity.STABLE, count);
    }
    
}
