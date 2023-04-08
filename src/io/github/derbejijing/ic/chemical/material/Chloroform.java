package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class Chloroform extends Chemical {

    public Chloroform(int count, ChemicalPurity purity) {
        super("Chloroform", ChemicalItem.CHLOROFORM.material, ChemicalItem.CHLOROFORM.id, purity, ChemicalToxicity.EXTREME_DANGER, ChemicalReactivity.STABLE, count);
    }
    
}
