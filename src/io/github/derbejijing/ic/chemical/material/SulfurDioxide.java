package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class SulfurDioxide extends Chemical {

    public SulfurDioxide(int count, ChemicalPurity purity) {
        super("Sulfur dioxide", ChemicalItem.SULFUR_DIOXIDE.material, ChemicalItem.SULFUR_DIOXIDE.id, purity, ChemicalToxicity.LETHAL, ChemicalReactivity.STABLE, count);
    }
    
}
