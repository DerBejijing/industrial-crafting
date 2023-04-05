package io.github.derbejijing.ic.crafting.chemical;

import java.util.ArrayList;

import io.github.derbejijing.ic.chemical.Chemical;

public abstract class ChemicalRecipe {
    private ArrayList<ChemicalComponent> ingredients;
    private ChemicalComponent output;
    private int power_required;

    public ChemicalRecipe(ChemicalComponent output, int power_required) {
        this.output = output;
        this.power_required = power_required;
        this.add_components();
    }


    public boolean attempt_craft(ArrayList<Chemical> inputs, int power, int output_space) {
        return false;
    }


    protected void add_ingredient(ChemicalComponent component) {
        this.ingredients.add(component);
    }


    public abstract void add_components();


}
