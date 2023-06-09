package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;
import io.github.derbejijing.ic.machines.MultiblockMachine;

public class Chloroacetone extends ChemicalRecipe {

    public Chloroacetone(MultiblockMachine master) {
        super(master, 1, 10, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.ACETONE, 1);
        this.add_ingredient(ChemicalItem.CHLORINE, 1);
    }


    @Override
    public void add_requirements() {
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.CHLOROACETONE, 1);
    }
}
