package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class ChlorinatedHydrocarbons extends Chemical {

    public ChlorinatedHydrocarbons(int count, ChemicalPurity purity) {
        super("Chlorinated hydrocarbons", ChemicalItem.CHLORINATED_HYDROCARBONS.material, ChemicalItem.CHLORINATED_HYDROCARBONS.id, purity, ChemicalToxicity.EXTREME_DANGER, ChemicalReactivity.STABLE, count);
    }
    
}
