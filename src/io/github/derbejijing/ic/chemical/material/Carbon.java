package io.github.derbejijing.ic.chemical.material;

import org.bukkit.Material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalPurity;
import io.github.derbejijing.ic.chemical.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.ChemicalToxicity;

public class Carbon extends Chemical {

    public Carbon(int count, ChemicalPurity purity) {
        super(Material.SUGAR, 1, purity, ChemicalToxicity.NONE, ChemicalReactivity.STABLE, count);
    }
    
}
