package io.github.derbejijing.ic.chemical.material;

import org.bukkit.Material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class PotassiumNitrate extends Chemical {

    public PotassiumNitrate(int count, ChemicalPurity purity) {
        super(Material.SUGAR, 3, purity, ChemicalToxicity.NONE, ChemicalReactivity.STABLE, count);
    }
    
}
