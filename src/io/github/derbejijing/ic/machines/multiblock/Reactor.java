package io.github.derbejijing.ic.machines.multiblock;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipeRegistry;
import io.github.derbejijing.ic.machines.MultiblockMachine;
import io.github.derbejijing.ic.machines.component.CasingGlassTinted;
import io.github.derbejijing.ic.machines.component.CasingStone;
import io.github.derbejijing.ic.machines.component.Cauldron;
import io.github.derbejijing.ic.machines.component.Generator;
import io.github.derbejijing.ic.machines.component.InputHatch;
import io.github.derbejijing.ic.machines.component.Interface;
import io.github.derbejijing.ic.machines.component.LightningRod;
import io.github.derbejijing.ic.machines.component.OutputHatch;

public class Reactor extends MultiblockMachine {

    public Reactor(Location base_location, int orientation) {
        super(base_location, orientation);
    }

    @Override
    protected void add_components() {
        this.add_component(new CasingStone(this, new Vector(0, 0, 0)));
        this.add_component(new Interface(this, new Vector(1, 0, 0), false));
        this.add_component(new CasingStone(this, new Vector(2, 0, 0)));
        this.add_component(new InputHatch(this, new Vector(0, 0, 1)));
        this.add_component(new Cauldron(this, new Vector(1, 0, 1)));
        this.add_component(new OutputHatch(this, new Vector(2, 0, 1)));
        this.add_component(new CasingStone(this, new Vector(0, 0, 2)));
        this.add_component(new Generator(this, new Vector(1, 0, 2)));
        this.add_component(new CasingStone(this, new Vector(2, 0, 2)));

        this.add_component(new CasingStone(this, new Vector(0, 1, 0)));
        this.add_component(new CasingGlassTinted(this, new Vector(1, 1, 0)));
        this.add_component(new CasingStone(this, new Vector(2, 1, 0)));
        this.add_component(new CasingStone(this, new Vector(0, 1, 1)));
        this.add_component(new LightningRod(this, new Vector(1, 1, 1)));
        this.add_component(new CasingStone(this, new Vector(2, 1, 1)));
        this.add_component(new CasingStone(this, new Vector(0, 1, 2)));
        this.add_component(new CasingStone(this, new Vector(1, 1, 2)));
        this.add_component(new CasingStone(this, new Vector(2, 1, 2)));

        this.add_component(new CasingStone(this, new Vector(0, 2, 0)));
        this.add_component(new CasingStone(this, new Vector(1, 2, 0)));
        this.add_component(new CasingStone(this, new Vector(2, 2, 0)));
        this.add_component(new CasingStone(this, new Vector(0, 2, 1)));
        this.add_component(new CasingStone(this, new Vector(1, 2, 1)));
        this.add_component(new CasingStone(this, new Vector(2, 2, 1)));
        this.add_component(new CasingStone(this, new Vector(0, 2, 2)));
        this.add_component(new CasingStone(this, new Vector(1, 2, 2)));
        this.add_component(new CasingStone(this, new Vector(2, 2, 2)));
    }

    @Override
    protected void add_recipes() {
        this.add_recipe(ChemicalRecipeRegistry.ACETIC_ACID);
        this.add_recipe(ChemicalRecipeRegistry.ACETONE_PEROXIDE);
        this.add_recipe(ChemicalRecipeRegistry.GUNPOWDER);
        this.add_recipe(ChemicalRecipeRegistry.BOOZE);
        this.add_recipe(ChemicalRecipeRegistry.BOOZE_SUGAR_CANE);
        this.add_recipe(ChemicalRecipeRegistry.CHLOROACETONE);
        this.add_recipe(ChemicalRecipeRegistry.POTASSIUM_HYDROXIDE_SOLUTION);
        this.add_recipe(ChemicalRecipeRegistry.PRIMER_POWDER);
        this.add_recipe(ChemicalRecipeRegistry.ACETONE_PEROXIDE);
        this.add_recipe(ChemicalRecipeRegistry.SULFURIC_ACID);
        this.add_recipe(ChemicalRecipeRegistry.SODIUM_ACETATE);
        this.add_recipe(ChemicalRecipeRegistry.SODIUM_HYDROXIDE_SOLUTION);
    }

    @Override
    protected void on_tick() {
    }

    @Override
    protected void on_place() {
    }

    @Override
    protected void on_destroy() {
    }

    @Override
    protected void on_change_state() {
    }
    
}
