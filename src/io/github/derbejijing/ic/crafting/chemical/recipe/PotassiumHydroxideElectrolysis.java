package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;

public class PotassiumHydroxideElectrolysis extends ChemicalRecipe {

    public PotassiumHydroxideElectrolysis() {
        super(10, 1, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.POTASSIUM_CHLORIDE, 1);
        this.add_ingredient(ChemicalItem.DISTILLED_WATER, 1);
    }


    @Override
    public void add_requirements() {
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.POTASSIUM_HYDROXIDE_SOLUTION, 1);
        this.add_output(ChemicalItem.CHLORINE, 1);
        this.add_output(ChemicalItem.HYDROGEN, 1);
    }
}
