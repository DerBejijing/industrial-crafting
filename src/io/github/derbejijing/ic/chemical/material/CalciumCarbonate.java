package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class CalciumCarbonate extends Chemical {

    public CalciumCarbonate(int count, ChemicalPurity purity) {
        super("Calcium carbonate", ChemicalItem.CALCIUM_CARBONATE.material, ChemicalItem.CALCIUM_CARBONATE.id, purity, ChemicalToxicity.NONE, ChemicalReactivity.STABLE, count);
    }
    
}
