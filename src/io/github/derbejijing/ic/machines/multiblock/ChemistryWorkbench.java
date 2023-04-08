package io.github.derbejijing.ic.machines.multiblock;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipeRegistry;
import io.github.derbejijing.ic.machines.MultiblockMachine;
import io.github.derbejijing.ic.machines.component.CasingIron;
import io.github.derbejijing.ic.machines.component.Generator;
import io.github.derbejijing.ic.machines.component.Interface;

public class ChemistryWorkbench extends MultiblockMachine {

    public ChemistryWorkbench(Location base_Location, int orientation) {
        super(base_Location, orientation);
    }


    protected void add_components() {
        this.add_component(new CasingIron(this, new Vector(0, 0, 0)));
        this.add_component(new Interface(this, new Vector(1, 0, 0), true));
        this.add_component(new CasingIron(this, new Vector(2, 0, 0)));
        this.add_component(new CasingIron(this, new Vector(0, 0, 1)));
        this.add_component(new Generator(this, new Vector(1, 0, 1)));
        this.add_component(new CasingIron(this, new Vector(2, 0, 1)));
    }


    protected void add_recipes() {
        this.add_recipe(ChemicalRecipeRegistry.GUNPOWDER);
        this.add_recipe(ChemicalRecipeRegistry.ACETIC_ACID);
    }


    protected void on_tick() {
    }


    protected void on_place() {
        this.set_recipe(ChemicalRecipeRegistry.GUNPOWDER);
    }


    protected void on_destroy() {
        this.base_location.getWorld().playSound(this.base_location, Sound.BLOCK_AMETHYST_BLOCK_BREAK, (float)1.0, (float)1.0);
    }


    protected void on_change_state() {
    }
}


/* NOTES
 * in constructor, there should be a method like add_recipe, that picks a recipe from some sort of registry
 * then, when a blueprint/recipe is inserted, the machine's registry will be searched for that specific recipe
 * if it is found the current recipe is set to the new one. It takes the inventory as an argument
 * 
 * every tick, the recipe.craft method is called
 * it takes as arguments: the current power level, the free space in the output and an arrayList of all input materials
 * it will consume the necessary items and add a new one to the output (using sth like master.add_output, bc it can either be the output hatch or the output slot)
 * it will return a boolean, true if everything is fine
 */