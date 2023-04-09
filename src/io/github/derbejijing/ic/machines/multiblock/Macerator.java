package io.github.derbejijing.ic.machines.multiblock;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipeRegistry;
import io.github.derbejijing.ic.machines.MultiblockMachine;
import io.github.derbejijing.ic.machines.component.CasingStone;
import io.github.derbejijing.ic.machines.component.CasingStoneSlab;
import io.github.derbejijing.ic.machines.component.Generator;
import io.github.derbejijing.ic.machines.component.InputHatch;
import io.github.derbejijing.ic.machines.component.Interface;
import io.github.derbejijing.ic.machines.component.OutputHatch;

public class Macerator extends MultiblockMachine {

    public Macerator(Location base_location, int orientation) {
        super(base_location, orientation, true);
    }

    @Override
    protected void add_components() {
        this.add_component(new CasingStone(this, new Vector(0, 0, 0)));
        this.add_component(new Interface(this, new Vector(1, 0, 0), false));
        this.add_component(new CasingStone(this, new Vector(2, 0, 0)));
        this.add_component(new InputHatch(this, new Vector(0, 0, 1)));
        this.add_component(new Generator(this, new Vector(1, 0, 1)));
        this.add_component(new OutputHatch(this, new Vector(2, 0, 1)));

        this.add_component(new CasingStoneSlab(this, new Vector(0, 1, 0)));
        this.add_component(new CasingStoneSlab(this, new Vector(1, 1, 0)));
        this.add_component(new CasingStoneSlab(this, new Vector(2, 1, 0)));
        this.add_component(new CasingStoneSlab(this, new Vector(0, 1, 1)));
        this.add_component(new CasingStoneSlab(this, new Vector(1, 1, 1)));
        this.add_component(new CasingStoneSlab(this, new Vector(2, 1, 1)));
    }

    @Override
    protected void add_recipes() {
        this.add_recipe(ChemicalRecipeRegistry.CRUSH_NETHERRACK);
        this.add_recipe(ChemicalRecipeRegistry.CRUSH_STONE);
        this.add_recipe(ChemicalRecipeRegistry.CALCIUM_CARBONATE);
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
