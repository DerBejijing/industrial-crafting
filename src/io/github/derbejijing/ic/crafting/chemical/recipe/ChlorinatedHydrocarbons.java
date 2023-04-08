package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;

public class ChlorinatedHydrocarbons extends ChemicalRecipe {

    public ChlorinatedHydrocarbons() {
        super(100, 10, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.METHANE, 1);
        this.add_ingredient(ChemicalItem.CHLORINE, 1);
    }


    @Override
    public void add_requirements() {
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.CHLORINATED_HYDROCARBONS, 1);
    }
}
