package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class Liquor extends Chemical {

    public Liquor(int count, ChemicalPurity purity) {
        super("Liquor", ChemicalItem.LIQUOR.material, ChemicalItem.LIQUOR.id, purity, ChemicalToxicity.SLIGHTLY_HAZARDOUS, ChemicalReactivity.STABLE, count);
    }
    
}
