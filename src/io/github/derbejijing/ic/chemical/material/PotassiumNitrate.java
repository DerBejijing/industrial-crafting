package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class PotassiumNitrate extends Chemical {

    public PotassiumNitrate(int count, ChemicalPurity purity) {
        super("Potassium Nitrate", ChemicalItem.POTASSIUM_NITRATE.material, ChemicalItem.POTASSIUM_NITRATE.id, purity, ChemicalToxicity.NONE, ChemicalReactivity.STABLE, count);
    }
    
}
