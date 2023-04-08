package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class OrganicWaste extends Chemical {

    public OrganicWaste(int count, ChemicalPurity purity) {
        super("Organic waste", ChemicalItem.ORGANIC_WASTE.material, ChemicalItem.ORGANIC_WASTE.id, purity, ChemicalToxicity.LETHAL, ChemicalReactivity.STABLE, count);
    }
    
}
