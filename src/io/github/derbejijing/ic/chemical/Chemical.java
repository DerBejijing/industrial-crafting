package io.github.derbejijing.ic.chemical;

import org.bukkit.Material;

public class Chemical {
    private Material material;
    private int custom_model_data;
    private ChemicalPurity purity;
    private ChemicalToxicity toxicity;
    private ChemicalReactivity reactivity;
    private int count;

    public Chemical(Material material, int custom_model_data, ChemicalPurity purity, ChemicalToxicity toxicity, ChemicalReactivity reactivity, int count) {
        this.material = material;
        this.custom_model_data = custom_model_data;
        this.purity = purity;
        this.toxicity = toxicity;
        this.reactivity = reactivity;
        this.count = count;
    }
}
