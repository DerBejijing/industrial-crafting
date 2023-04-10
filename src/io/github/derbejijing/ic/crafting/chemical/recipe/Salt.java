package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;
import io.github.derbejijing.ic.machines.MultiblockMachine;

public class Salt extends ChemicalRecipe {

    public Salt(MultiblockMachine master) {
        super(master, 100, 10, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.WATER, 1);
    }


    @Override
    public void add_requirements() {
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.SODIUM_CHLORIDE, 1, ChemicalPurity.CONTAMINATION);
        this.add_output(ChemicalItem.DISTILLED_WATER, 1);
        this.add_output(ChemicalItem.EMPTY_BUCKET, 1);
    }
}
