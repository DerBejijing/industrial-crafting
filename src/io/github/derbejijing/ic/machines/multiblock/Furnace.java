package io.github.derbejijing.ic.machines.multiblock;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipeRegistry;
import io.github.derbejijing.ic.machines.MultiblockMachine;
import io.github.derbejijing.ic.machines.component.CasingGlassTinted;
import io.github.derbejijing.ic.machines.component.CasingStone;
import io.github.derbejijing.ic.machines.component.Generator;
import io.github.derbejijing.ic.machines.component.BlastFurnace;
import io.github.derbejijing.ic.machines.component.InputHatch;
import io.github.derbejijing.ic.machines.component.Interface;
import io.github.derbejijing.ic.machines.component.OutputHatch;

public class Furnace extends MultiblockMachine {

    public Furnace(Location base_location, int orientation) {
        super(base_location, orientation, true);
    }

    @Override
    protected void add_components() {
        this.add_component(new CasingStone(this, new Vector(0, 0, 0)));
        this.add_component(new Interface(this, new Vector(1, 0, 0), false));
        this.add_component(new CasingStone(this, new Vector(2, 0, 0)));
        this.add_component(new OutputHatch(this, new Vector(0, 0, 1)));
        this.add_component(new CasingStone(this, new Vector(1, 0, 1)));
        this.add_component(new InputHatch(this, new Vector(2, 0, 1)));
        this.add_component(new CasingStone(this, new Vector(0, 0, 2)));
        this.add_component(new Generator(this, new Vector(1, 0, 2)));
        this.add_component(new CasingStone(this, new Vector(2, 0, 2)));

        this.add_component(new CasingStone(this, new Vector(0, 1, 0)));
        this.add_component(new CasingGlassTinted(this, new Vector(1, 1, 0)));
        this.add_component(new CasingStone(this, new Vector(2, 1, 0)));
        this.add_component(new CasingStone(this, new Vector(0, 1, 1)));
        this.add_component(new BlastFurnace(this, new Vector(1, 1, 1)));
        this.add_component(new CasingStone(this, new Vector(2, 1, 1)));
        this.add_component(new CasingStone(this, new Vector(0, 1, 2)));
        this.add_component(new CasingStone(this, new Vector(1, 1, 2)));
        this.add_component(new CasingStone(this, new Vector(2, 1, 2)));

        this.add_component(new CasingStone(this, new Vector(0, 2, 0)));
        this.add_component(new CasingStone(this, new Vector(1, 2, 0)));
        this.add_component(new CasingStone(this, new Vector(2, 2, 0)));
        this.add_component(new CasingStone(this, new Vector(0, 2, 1)));
        this.add_component(new CasingStone(this, new Vector(2, 2, 1)));
        this.add_component(new CasingStone(this, new Vector(0, 2, 2)));
        this.add_component(new CasingStone(this, new Vector(1, 2, 2)));
        this.add_component(new CasingStone(this, new Vector(2, 2, 2)));

        this.add_component(new CasingStone(this, new Vector(0, 3, 0)));
        this.add_component(new CasingStone(this, new Vector(1, 3, 0)));
        this.add_component(new CasingStone(this, new Vector(2, 3, 0)));
        this.add_component(new CasingStone(this, new Vector(0, 3, 1)));
        this.add_component(new CasingStone(this, new Vector(2, 3, 1)));
        this.add_component(new CasingStone(this, new Vector(0, 3, 2)));
        this.add_component(new CasingStone(this, new Vector(1, 3, 2)));
        this.add_component(new CasingStone(this, new Vector(2, 3, 2)));
    }

    @Override
    protected void add_recipes() {
        this.add_recipe(ChemicalRecipeRegistry.BURN_COAL);
        this.add_recipe(ChemicalRecipeRegistry.SULFUR_DIOXIDE);
        this.add_recipe(ChemicalRecipeRegistry.SULFUR_TRIOXIDE);
        this.add_recipe(ChemicalRecipeRegistry.METHANE);
        this.add_recipe(ChemicalRecipeRegistry.CHLORINATED_HYDROCARBONS);
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
