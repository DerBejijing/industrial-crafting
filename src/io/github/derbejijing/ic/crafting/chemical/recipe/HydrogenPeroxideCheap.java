package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;
import io.github.derbejijing.ic.machines.MultiblockMachine;

public class HydrogenPeroxideCheap extends ChemicalRecipe {

    public HydrogenPeroxideCheap(MultiblockMachine master) {
        super(master, 10, 1, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.DISTILLED_WATER, 1);
        this.add_ingredient(ChemicalItem.OXYGEN, 1);
        this.add_ingredient(ChemicalItem.SODIUM_CHLORIDE, 1);
    }


    @Override
    public void add_requirements() {
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.HYDROGEN_PEROXIDE, 1);
        this.add_output(ChemicalItem.CHLORINE, 1);
    }
}
