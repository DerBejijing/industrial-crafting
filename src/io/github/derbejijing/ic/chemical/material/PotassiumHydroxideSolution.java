package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class PotassiumHydroxideSolution extends Chemical {

    public PotassiumHydroxideSolution(int count, ChemicalPurity purity) {
        super("Potassium hydroxide solution", ChemicalItem.POTASSIUM_HYDROXIDE_SOLUTION.material, ChemicalItem.POTASSIUM_HYDROXIDE_SOLUTION.id, purity, ChemicalToxicity.HAZARDOUS, ChemicalReactivity.STABLE, count);
    }
    
}
