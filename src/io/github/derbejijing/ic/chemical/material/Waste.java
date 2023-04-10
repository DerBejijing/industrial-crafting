package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class Waste extends Chemical {

    public Waste(int count, ChemicalPurity purity) {
        super("Waste", ChemicalItem.WASTE.material, ChemicalItem.WASTE.id, ChemicalPurity.HEAVY_CONTAMINATION, ChemicalToxicity.LETHAL, ChemicalReactivity.STABLE, count);
    }
    
}
