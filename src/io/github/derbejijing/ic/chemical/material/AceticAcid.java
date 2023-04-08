package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class AceticAcid extends Chemical {

    public AceticAcid(int count, ChemicalPurity purity) {
        super("Acetic acid", ChemicalItem.ACETIC_ACID.material, ChemicalItem.ACETIC_ACID.id, purity, ChemicalToxicity.NONE, ChemicalReactivity.STABLE, count);
    }
    
}
