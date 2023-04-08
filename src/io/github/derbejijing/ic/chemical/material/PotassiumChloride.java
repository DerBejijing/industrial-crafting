package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class PotassiumChloride extends Chemical {

    public PotassiumChloride(int count, ChemicalPurity purity) {
        super("Potassium chloride", ChemicalItem.POTASSIUM_CHLORIDE.material, ChemicalItem.POTASSIUM_CHLORIDE.id, purity, ChemicalToxicity.NONE, ChemicalReactivity.STABLE, count);
    }
    
}
