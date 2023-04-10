package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;
import io.github.derbejijing.ic.machines.MultiblockMachine;

public class RecrystallizePotassiumNitrate extends ChemicalRecipe {

    public RecrystallizePotassiumNitrate(MultiblockMachine master) {
        super(master, 10, 60, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.POTASSIUM_NITRATE, 1);
    }


    @Override
    public void add_requirements() {
        this.add_requirement(ChemicalItem.DISTILLED_WATER, 1);
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.POTASSIUM_NITRATE, 1, ChemicalPurity.INDUSTRIAL_GRADE);
    }
}
