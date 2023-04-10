package io.github.derbejijing.ic.crafting.chemical.recipe;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;
import io.github.derbejijing.ic.machines.MultiblockMachine;

public class Chloroform extends ChemicalRecipe {

    public Chloroform(MultiblockMachine master) {
        super(master, 100, 10, 0);
    }


    @Override
    public void add_ingredients() {
        this.add_ingredient(ChemicalItem.CHLORINATED_HYDROCARBONS, 4);
    }


    @Override
    public void add_requirements() {
    }


    @Override
    public void add_outputs() {
        this.add_output(ChemicalItem.CHLOROFORM, 1, ChemicalPurity.INDUSTRIAL_GRADE);
    }
}
