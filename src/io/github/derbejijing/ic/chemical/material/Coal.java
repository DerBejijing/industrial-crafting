package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class Coal extends Chemical {

    public Coal(int count, ChemicalPurity purity) {
        super("Coal", ChemicalItem.COAL.material, ChemicalItem.COAL.id, purity, ChemicalToxicity.NONE, ChemicalReactivity.STABLE, count);
    }
    
}
