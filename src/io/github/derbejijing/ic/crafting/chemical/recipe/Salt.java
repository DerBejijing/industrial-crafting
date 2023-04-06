package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;

public class Salt extends ChemicalRecipe {

    public Salt() {
        super(100, 10);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.WATER, 1);
    }


    @Override
    public void add_requirements() {
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.SODIUM_CHLORIDE, 1);
    }
}
