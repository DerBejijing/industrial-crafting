package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipeFailure;
import io.github.derbejijing.ic.machines.MultiblockMachine;

public class AcetonePeroxide extends ChemicalRecipe {

    public AcetonePeroxide(MultiblockMachine master) {
        super(master, 1, 100, 0, ChemicalRecipeFailure.DETONATE);
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
