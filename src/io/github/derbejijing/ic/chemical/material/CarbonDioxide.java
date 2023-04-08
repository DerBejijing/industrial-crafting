package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class CarbonDioxide extends Chemical {

    public CarbonDioxide(int count, ChemicalPurity purity) {
        super("Carbon dioxide", ChemicalItem.CARBON_DIOXIDE.material, ChemicalItem.CARBON_DIOXIDE.id, purity, ChemicalToxicity.NONE, ChemicalReactivity.STABLE, count);
    }
    
}
