package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class Chlorine extends Chemical {

    public Chlorine(int count, ChemicalPurity purity) {
        super("Chlorine", ChemicalItem.CHLORINE.material, ChemicalItem.CHLORINE.id, purity, ChemicalToxicity.LETHAL, ChemicalReactivity.STABLE, count);
    }
    
}
