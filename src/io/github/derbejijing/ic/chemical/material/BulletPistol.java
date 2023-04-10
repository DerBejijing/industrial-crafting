package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class BulletPistol extends Chemical {

    public BulletPistol(int count, ChemicalPurity purity) {
        super("Bullet (pistol)", ChemicalItem.BULLET_PISTOL.material, ChemicalItem.BULLET_PISTOL.id, purity, ChemicalToxicity.NONE, ChemicalReactivity.STABLE, count);
    }
    
}
