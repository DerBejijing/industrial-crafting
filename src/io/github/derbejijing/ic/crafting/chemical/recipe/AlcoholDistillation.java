package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;

public class AlcoholDistillation extends ChemicalRecipe {

    public AlcoholDistillation() {
        super(100, 10, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.LIQUOR, 32);
    }


    @Override
    public void add_requirements() {
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.METHANOL, 1);
        this.add_output(ChemicalItem.ETHANOL, 16);
        this.add_output(ChemicalItem.DISTILLED_WATER, 16);
    }
}
