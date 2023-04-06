package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class SulfuricAcid extends Chemical {

    public SulfuricAcid(int count, ChemicalPurity purity) {
        super("Sulfuric Acid", ChemicalItem.SULFURIC_ACID.material, ChemicalItem.SULFURIC_ACID.id, purity, ChemicalToxicity.HAZARDOUS, ChemicalReactivity.STABLE, count);
    }
    
}
