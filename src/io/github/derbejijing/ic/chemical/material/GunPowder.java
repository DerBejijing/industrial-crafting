package io.github.derbejijing.ic.chemical.material;

import org.bukkit.Material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class GunPowder extends Chemical {

    public GunPowder(int count, ChemicalPurity purity) {
        super(Material.SUGAR, 4, purity, ChemicalToxicity.NONE, ChemicalReactivity.EXPLOSIVE, count);
    }
    
}
