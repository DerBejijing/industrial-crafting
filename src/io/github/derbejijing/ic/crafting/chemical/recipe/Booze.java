package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;

public class Booze extends ChemicalRecipe {

    public Booze() {
        super(1, 10, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.ORGANIC_WASTE, 1);
        this.add_ingredient(ChemicalItem.APPLE, 1);
        this.add_ingredient(ChemicalItem.WATER, 1);
    }


    @Override
    public void add_requirements() {
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.LIQUOR, 1);
        this.add_output(ChemicalItem.EMPTY_BUCKET, 1);
    }
}
