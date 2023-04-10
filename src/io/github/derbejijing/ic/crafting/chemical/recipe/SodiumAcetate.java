package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;
import io.github.derbejijing.ic.machines.MultiblockMachine;

public class SodiumAcetate extends ChemicalRecipe {

    public SodiumAcetate(MultiblockMachine master) {
        super(master, 1, 1, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.ACETIC_ACID, 1);
        this.add_ingredient(ChemicalItem.SODIUM_HYDROXIDE, 1);
    }


    @Override
    public void add_requirements() {
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.SODIUM_ACETATE, 1);
    }
}
