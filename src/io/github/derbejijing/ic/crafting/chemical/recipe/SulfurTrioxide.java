package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;

public class SulfurTrioxide extends ChemicalRecipe {

    public SulfurTrioxide() {
        super(1, 1, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.SULFUR_DIOXIDE, 1);
        this.add_ingredient(ChemicalItem.OXYGEN, 1);
    }


    @Override
    public void add_requirements() {
        // this actually involves a catalyst but whatever
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.SULFUR_TRIOXIDE, 1);
    }
}
