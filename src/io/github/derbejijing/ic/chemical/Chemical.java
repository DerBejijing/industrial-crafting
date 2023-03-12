package io.github.derbejijing.ic.chemical;

import org.bukkit.Material;

public class Chemical {
    private Material material;
    private int custom_model_data;
    private ChemicalPurity purity;
    private ChemicalToxicity toxicity;
    private ChemicalReactivity reactivity;

    public Chemical(Material material, int custom_model_data, ChemicalPurity purity, ChemicalToxicity toxicity, ChemicalReactivity reactivity) {
        this.material = material;
        this.custom_model_data = custom_model_data;
        this.purity = purity;
        this.toxicity = toxicity;
        this.reactivity = reactivity;
    }
}
