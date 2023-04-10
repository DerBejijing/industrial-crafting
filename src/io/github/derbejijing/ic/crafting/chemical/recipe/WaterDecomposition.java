package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;
import io.github.derbejijing.ic.machines.MultiblockMachine;

public class WaterDecomposition extends ChemicalRecipe {

    public WaterDecomposition(MultiblockMachine master) {
        super(master, 10, 1, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.DISTILLED_WATER, 3);
    }


    @Override
    public void add_requirements() {
        this.add_requirement(ChemicalItem.SULFURIC_ACID, 1);
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.HYDROGEN, 2);
        this.add_output(ChemicalItem.OXYGEN, 1);
    }
}
