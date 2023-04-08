package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class Methanol extends Chemical {

    public Methanol(int count, ChemicalPurity purity) {
        super("Methanol", ChemicalItem.METHANOL.material, ChemicalItem.METHANOL.id, purity, ChemicalToxicity.LETHAL, ChemicalReactivity.STABLE, count);
    }
    
}
