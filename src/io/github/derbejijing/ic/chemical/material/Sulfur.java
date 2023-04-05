package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class Sulfur extends Chemical {

    public Sulfur(int count, ChemicalPurity purity) {
        super("Sulfur", ChemicalItem.SULFUR.material, ChemicalItem.SULFUR.id, purity, ChemicalToxicity.HAZARDOUS, ChemicalReactivity.STABLE, count);
    }
    
}
