package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class SodiumCarbonate extends Chemical {

    public SodiumCarbonate(int count, ChemicalPurity purity) {
        super("Sodium carbonate", ChemicalItem.SODIUM_CARBONATE.material, ChemicalItem.SODIUM_CARBONATE.id, purity, ChemicalToxicity.NONE, ChemicalReactivity.STABLE, count);
    }
    
}
