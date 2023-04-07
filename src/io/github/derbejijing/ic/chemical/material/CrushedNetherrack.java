package io.github.derbejijing.ic.chemical.material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class CrushedNetherrack extends Chemical {

    public CrushedNetherrack(int count, ChemicalPurity purity) {
        super("Crushed netherrack", ChemicalItem.CRUSHED_NETHERRACK.material, ChemicalItem.CRUSHED_NETHERRACK.id, purity, ChemicalToxicity.NONE, ChemicalReactivity.STABLE, count);
    }
    
}
