package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;
import io.github.derbejijing.ic.machines.MultiblockMachine;

public class CalciumCarbonate extends ChemicalRecipe {

    public CalciumCarbonate(MultiblockMachine master) {
        super(master, 100, 1, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.CALCITE, 1);
    }


    @Override
    public void add_requirements() {
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.CALCIUM_CARBONATE, 1);
    }
}
