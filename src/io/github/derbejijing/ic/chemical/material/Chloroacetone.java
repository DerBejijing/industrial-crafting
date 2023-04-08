package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class Chloroacetone extends Chemical {

    public Chloroacetone(int count, ChemicalPurity purity) {
        super("Chloroacetone", ChemicalItem.CHLOROACETONE.material, ChemicalItem.CHLOROACETONE.id, purity, ChemicalToxicity.EXTREME_DANGER, ChemicalReactivity.STABLE, count);
    }
    
}
