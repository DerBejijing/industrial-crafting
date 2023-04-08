package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class Acetone extends Chemical {

    public Acetone(int count, ChemicalPurity purity) {
        super("Acetone", ChemicalItem.ACETONE.material, ChemicalItem.ACETONE.id, purity, ChemicalToxicity.SLIGHTLY_HAZARDOUS, ChemicalReactivity.STABLE, count);
    }
    
}
