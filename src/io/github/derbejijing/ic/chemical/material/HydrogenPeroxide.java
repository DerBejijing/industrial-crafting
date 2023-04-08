package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class HydrogenPeroxide extends Chemical {

    public HydrogenPeroxide(int count, ChemicalPurity purity) {
        super("Hydrogen peroxide", ChemicalItem.HYDROGEN_PEROXIDE.material, ChemicalItem.HYDROGEN_PEROXIDE.id, purity, ChemicalToxicity.NONE, ChemicalReactivity.UNSTABLE, count);
    }
    
}
