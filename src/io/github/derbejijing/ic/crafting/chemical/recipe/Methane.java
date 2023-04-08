package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;

public class Methane extends ChemicalRecipe {

    public Methane() {
        super(100, 10, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.SODIUM_ACETATE, 1);
        this.add_ingredient(ChemicalItem.SODIUM_HYDROXIDE, 1);
    }


    @Override
    public void add_requirements() {
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.METHANE, 2);
        this.add_output(ChemicalItem.SODIUM_CARBONATE, 1);
    }
}
