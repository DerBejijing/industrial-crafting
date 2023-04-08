package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class PotassiumHydroxide extends Chemical {

    public PotassiumHydroxide(int count, ChemicalPurity purity) {
        super("Potassium hydroxide", ChemicalItem.POTASSIUM_HYDROXIDE.material, ChemicalItem.POTASSIUM_HYDROXIDE.id, purity, ChemicalToxicity.NONE, ChemicalReactivity.STABLE, count);
    }
    
}
