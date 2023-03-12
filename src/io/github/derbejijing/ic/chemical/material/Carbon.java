package io.github.derbejijing.ic.chemical.material;

import org.bukkit.Material;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalPurity;
import io.github.derbejijing.ic.chemical.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.ChemicalToxicity;

public class Carbon extends Chemical {

    public Carbon(Material material, int custom_model_data, ChemicalPurity purity, ChemicalToxicity toxicity, ChemicalReactivity reactivity) {
        super(Material.SUGAR, 1, ChemicalPurity.INDUSTRIAL_GRADE, ChemicalToxicity.NONE, ChemicalReactivity.STABLE);
    }
    
}
