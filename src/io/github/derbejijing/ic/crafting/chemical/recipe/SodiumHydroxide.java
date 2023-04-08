package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;

public class SodiumHydroxide extends ChemicalRecipe {

    public SodiumHydroxide() {
        super(100, 10, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.SODIUM_HYDROXIDE_SOLUTION, 1);
    }


    @Override
    public void add_requirements() {
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.SODIUM_HYDROXIDE, 1, ChemicalPurity.INDUSTRIAL_GRADE);
        this.add_output(ChemicalItem.DISTILLED_WATER, 1, ChemicalPurity.INDUSTRIAL_GRADE);
    }
}
