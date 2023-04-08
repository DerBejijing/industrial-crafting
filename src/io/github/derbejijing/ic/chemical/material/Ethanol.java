package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class Ethanol extends Chemical {

    public Ethanol(int count, ChemicalPurity purity) {
        super("Ethanol", ChemicalItem.ETHANOL.material, ChemicalItem.ETHANOL.id, purity, ChemicalToxicity.SLIGHTLY_HAZARDOUS, ChemicalReactivity.STABLE, count);
    }
    
}
