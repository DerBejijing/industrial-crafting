package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class BulletShotgun extends Chemical {

    public BulletShotgun(int count, ChemicalPurity purity) {
        super("Bullet (shotgun)", ChemicalItem.BULLET_SHOTGUN.material, ChemicalItem.BULLET_SHOTGUN.id, purity, ChemicalToxicity.NONE, ChemicalReactivity.STABLE, count);
    }
    
}
