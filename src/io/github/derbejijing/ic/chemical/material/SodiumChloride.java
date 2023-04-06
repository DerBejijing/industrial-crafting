package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class SodiumChloride extends Chemical {

    public SodiumChloride(int count, ChemicalPurity purity) {
        super("Sodium chloride", ChemicalItem.SODIUM_CHLORIDE.material, ChemicalItem.SODIUM_CHLORIDE.id, purity, ChemicalToxicity.NONE, ChemicalReactivity.STABLE, count);
    }
    
}
