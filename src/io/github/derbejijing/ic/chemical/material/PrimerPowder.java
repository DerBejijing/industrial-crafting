package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class PrimerPowder extends Chemical {

    public PrimerPowder(int count, ChemicalPurity purity) {
        super("Primer powder", ChemicalItem.PRIMER_POWDER.material, ChemicalItem.PRIMER_POWDER.id, purity, ChemicalToxicity.NONE, ChemicalReactivity.EXPLOSIVE, count);
    }
    
}
