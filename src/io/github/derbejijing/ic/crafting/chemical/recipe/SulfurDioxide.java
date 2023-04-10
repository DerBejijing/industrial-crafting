package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;
import io.github.derbejijing.ic.machines.MultiblockMachine;

public class SulfurDioxide extends ChemicalRecipe {

    public SulfurDioxide(MultiblockMachine master) {
        super(master, 100, 10, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.SULFUR, 1);
        this.add_ingredient(ChemicalItem.OXYGEN, 1);
    }


    @Override
    public void add_requirements() {
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.SULFUR_DIOXIDE, 1);
    }
}
