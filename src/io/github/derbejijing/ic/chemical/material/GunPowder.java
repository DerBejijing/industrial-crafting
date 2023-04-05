package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class GunPowder extends Chemical {

    public GunPowder(int count, ChemicalPurity purity) {
        super("Gun powder", ChemicalItem.GUNPOWDER.material, ChemicalItem.GUNPOWDER.id, purity, ChemicalToxicity.NONE, ChemicalReactivity.EXPLOSIVE, count);
    }
    
}
