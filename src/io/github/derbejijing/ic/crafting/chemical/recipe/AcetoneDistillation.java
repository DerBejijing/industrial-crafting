package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;

public class AcetoneDistillation extends ChemicalRecipe {

    public AcetoneDistillation() {
        super(10, 10, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.ACETIC_ACID, 1);
        this.add_ingredient(ChemicalItem.CALCIUM_CARBONATE, 1);
    }


    @Override
    public void add_requirements() {
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.ACETONE, 1);
    }
}
