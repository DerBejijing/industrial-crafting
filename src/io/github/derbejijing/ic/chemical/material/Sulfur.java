package io.github.derbejijing.ic.chemical.material;

import org.bukkit.Material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class Sulfur extends Chemical {

    public Sulfur(int count, ChemicalPurity purity) {
        super(Material.SUGAR, 2, purity, ChemicalToxicity.HAZARDOUS, ChemicalReactivity.STABLE, count);
    }
    
}
