package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class SodiumHydroxide extends Chemical {

    public SodiumHydroxide(int count, ChemicalPurity purity) {
        super("Sodium hydroxide", ChemicalItem.SODIUM_HYDROXIDE.material, ChemicalItem.SODIUM_HYDROXIDE.id, purity, ChemicalToxicity.HAZARDOUS, ChemicalReactivity.STABLE, count);
    }
    
}
