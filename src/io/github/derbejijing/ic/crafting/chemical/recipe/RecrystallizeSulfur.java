package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;
import io.github.derbejijing.ic.machines.MultiblockMachine;

public class RecrystallizeSulfur extends ChemicalRecipe {

    public RecrystallizeSulfur(MultiblockMachine master) {
        super(master, 10, 60, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.SULFUR, 1);
    }


    @Override
    public void add_requirements() {
        this.add_requirement(ChemicalItem.DISTILLED_WATER, 1);
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.SULFUR, 1, ChemicalPurity.INDUSTRIAL_GRADE);
    }
}
