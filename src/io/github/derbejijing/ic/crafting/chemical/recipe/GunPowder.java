package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;
import io.github.derbejijing.ic.machines.MultiblockMachine;

public class GunPowder extends ChemicalRecipe {

    public GunPowder(MultiblockMachine master) {
        super(master, 1, 1, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.CARBON, 1);
        this.add_ingredient(ChemicalItem.SULFUR, 1);
        this.add_ingredient(ChemicalItem.POTASSIUM_NITRATE, 6);
    }


    @Override
    public void add_requirements() {
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.GUNPOWDER, 8);
    }
}
