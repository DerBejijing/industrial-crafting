package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;

public class AceticAcid extends ChemicalRecipe {

    public AceticAcid() {
        super(10, 10, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.METHANOL, 10);
        this.add_ingredient(ChemicalItem.CARBON_MONOXIDE, get_power_required());
    }


    @Override
    public void add_requirements() {
        // actually a catalyst is needed (Rhodium)
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.ACETIC_ACID, 10);
    }
}
