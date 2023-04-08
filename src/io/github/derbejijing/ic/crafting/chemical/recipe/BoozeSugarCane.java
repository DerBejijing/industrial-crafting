package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;

public class BoozeSugarCane extends ChemicalRecipe {

    public BoozeSugarCane() {
        super(1, 10, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.ORGANIC_WASTE, 1);
        this.add_ingredient(ChemicalItem.SUGAR_CANE, 1);
        this.add_ingredient(ChemicalItem.WATER, 5);
    }


    @Override
    public void add_requirements() {
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.LIQUOR, 5);
        this.add_output(ChemicalItem.EMPTY_BUCKET, 5);
    }
}
