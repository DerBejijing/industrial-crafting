package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;

public class PotassiumHydroxideSolution extends ChemicalRecipe {

    public PotassiumHydroxideSolution() {
        super(1, 1, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.POTASSIUM_HYDROXIDE, 1);
        this.add_ingredient(ChemicalItem.DISTILLED_WATER, 1);
    }


    @Override
    public void add_requirements() {
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.POTASSIUM_HYDROXIDE_SOLUTION, 1);
    }
}
