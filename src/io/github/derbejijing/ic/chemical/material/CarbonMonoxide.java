package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class CarbonMonoxide extends Chemical {

    public CarbonMonoxide(int count, ChemicalPurity purity) {
        super("Carbon monoxide", ChemicalItem.CARBON_MONOXIDE.material, ChemicalItem.CARBON_MONOXIDE.id, purity, ChemicalToxicity.LETHAL, ChemicalReactivity.STABLE, count);
    }
    
}
