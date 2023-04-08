package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;

public class AcetonePeroxide extends ChemicalRecipe {

    public AcetonePeroxide() {
        super(1, 1, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.ACETONE, 1);
        this.add_ingredient(ChemicalItem.HYDROGEN_PEROXIDE, 1);
    }


    @Override
    public void add_requirements() {
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.ACETONE_PEROXIDE, 1);
    }
}
