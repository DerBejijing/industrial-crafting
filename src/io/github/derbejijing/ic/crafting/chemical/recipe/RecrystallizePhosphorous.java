package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;

public class RecrystallizePhosphorous extends ChemicalRecipe {

    public RecrystallizePhosphorous() {
        super(10, 60, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.PHOSPHOROUS, 1);
    }


    @Override
    public void add_requirements() {
        this.add_requirement(ChemicalItem.DISTILLED_WATER, 1);
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.PHOSPHOROUS, 1, ChemicalPurity.INDUSTRIAL_GRADE);
    }
}
