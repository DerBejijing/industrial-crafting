package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class HydrochloricAcid extends Chemical {

    public HydrochloricAcid(int count, ChemicalPurity purity) {
        super("Hydrochloric acid", ChemicalItem.HYDROCHLORIC_ACID.material, ChemicalItem.HYDROCHLORIC_ACID.id, purity, ChemicalToxicity.LETHAL, ChemicalReactivity.STABLE, count);
    }
    
}
