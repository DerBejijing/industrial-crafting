package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;

public class SeparateStone extends ChemicalRecipe {

    public SeparateStone() {
        super(10, 1, ChemicalPurity.CONTAMINATION.purity);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.STONE_DUST, 32);
    }


    @Override
    public void add_requirements() {
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.POTASSIUM_CHLORIDE, 1);
        this.add_output(ChemicalItem.SULFUR, 1);
        this.add_output(ChemicalItem.PHOSPHOROUS, 1);
        this.add_output(ChemicalItem.POTASSIUM_NITRATE, 1);
        this.add_output(ChemicalItem.SODIUM_CHLORIDE, 1);
    }
}
