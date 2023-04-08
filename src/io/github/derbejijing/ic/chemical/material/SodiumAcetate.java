package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class SodiumAcetate extends Chemical {

    public SodiumAcetate(int count, ChemicalPurity purity) {
        super("Sodium acetate", ChemicalItem.SODIUM_ACETATE.material, ChemicalItem.SODIUM_ACETATE.id, purity, ChemicalToxicity.SLIGHTLY_HAZARDOUS, ChemicalReactivity.STABLE, count);
    }
    
}
