package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class DistilledWater extends Chemical {

    public DistilledWater(int count, ChemicalPurity purity) {
        super("Distilled Water", ChemicalItem.DISTILLED_WATER.material, ChemicalItem.DISTILLED_WATER.id, purity, ChemicalToxicity.NONE, ChemicalReactivity.STABLE, count);
    }
    
}
