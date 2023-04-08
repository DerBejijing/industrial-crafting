package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class AcetonePeroxide extends Chemical {

    public AcetonePeroxide(int count, ChemicalPurity purity) {
        super("Acetone peroxide", ChemicalItem.ACETONE_PEROXIDE.material, ChemicalItem.ACETONE_PEROXIDE.id, purity, ChemicalToxicity.NONE, ChemicalReactivity.EXPLOSIVE_UNSTABLE, count);
    }
    
}
