package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class SodiumHydroxideSolution extends Chemical {

    public SodiumHydroxideSolution(int count, ChemicalPurity purity) {
        super("Sodium hydroxide solution", ChemicalItem.SODIUM_HYDROXIDE_SOLUTION.material, ChemicalItem.SODIUM_HYDROXIDE_SOLUTION.id, purity, ChemicalToxicity.HAZARDOUS, ChemicalReactivity.STABLE, count);
    }
    
}
