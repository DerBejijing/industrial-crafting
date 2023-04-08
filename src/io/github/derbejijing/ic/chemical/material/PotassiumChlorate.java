package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class PotassiumChlorate extends Chemical {

    public PotassiumChlorate(int count, ChemicalPurity purity) {
        super("Potassium chlorate", ChemicalItem.POTASSIUM_CHLORATE.material, ChemicalItem.POTASSIUM_CHLORATE.id, purity, ChemicalToxicity.NONE, ChemicalReactivity.STABLE, count);
    }
    
}
