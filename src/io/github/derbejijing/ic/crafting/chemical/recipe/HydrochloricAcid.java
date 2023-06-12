package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;
import io.github.derbejijing.ic.machines.MultiblockMachine;

public class HydrochloricAcid extends ChemicalRecipe {

    public HydrochloricAcid(MultiblockMachine master) {
        super(master, 0, 1, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.DISTILLED_WATER, 1);
        this.add_ingredient(ChemicalItem.HYDROGEN, 1);
        this.add_ingredient(ChemicalItem.CHLORINE, 1);
    }


    @Override
    public void add_requirements() {
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.HYDROCHLORIC_ACID, 1);
    }
}
