package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class SulfurTrioxide extends Chemical {

    public SulfurTrioxide(int count, ChemicalPurity purity) {
        super("Sulfur trioxide", ChemicalItem.SULFUR_TRIOXIDE.material, ChemicalItem.SULFUR_TRIOXIDE.id, purity, ChemicalToxicity.LETHAL, ChemicalReactivity.STABLE, count);
    }
    
}
