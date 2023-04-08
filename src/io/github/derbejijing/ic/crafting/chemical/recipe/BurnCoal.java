package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;

public class BurnCoal extends ChemicalRecipe {

    public BurnCoal() {
        super(100, 10, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.COAL, 1);
        this.add_ingredient(ChemicalItem.OXYGEN, 1);
    }


    @Override
    public void add_requirements() {
    }


    @Override
    public void add_outputs() {
        // okay we are slightly diverging from reality here
        this.add_output(ChemicalItem.CARBON, 1);
        this.add_output(ChemicalItem.CARBON_MONOXIDE, 1);
        this.add_output(ChemicalItem.CARBON_DIOXIDE, 1);
    }
}
