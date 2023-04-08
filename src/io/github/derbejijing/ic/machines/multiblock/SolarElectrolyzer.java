package io.github.derbejijing.ic.machines.multiblock;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipeRegistry;
import io.github.derbejijing.ic.machines.MultiblockMachine;
import io.github.derbejijing.ic.machines.component.CasingGlass;
import io.github.derbejijing.ic.machines.component.CasingStone;
import io.github.derbejijing.ic.machines.component.InputHatch;
import io.github.derbejijing.ic.machines.component.Interface;
import io.github.derbejijing.ic.machines.component.OutputHatch;
import io.github.derbejijing.ic.machines.component.SolarCell;
import io.github.derbejijing.ic.machines.component.Water;

public class SolarElectrolyzer extends MultiblockMachine {

    private double temperature = 0;
    private float power_yield = 0;

    public SolarElectrolyzer(Location base_location, int orientation) {
        super(base_location, orientation);
    }

    @Override
    protected void add_components() {
        this.add_component(new CasingStone(this, new Vector(0, 0, 0)));
        this.add_component(new Interface(this, new Vector(1, 0, 0), false));
        this.add_component(new CasingStone(this, new Vector(2, 0, 0)));
        this.add_component(new InputHatch(this, new Vector(0, 0, 1)));
        this.add_component(new CasingStone(this, new Vector(1, 0, 1)));
        this.add_component(new OutputHatch(this, new Vector(2, 0, 1)));
        this.add_component(new CasingStone(this, new Vector(0, 0, 2)));
        this.add_component(new CasingStone(this, new Vector(1, 0, 2)));
        this.add_component(new CasingStone(this, new Vector(2, 0, 2)));

        this.add_component(new CasingStone(this, new Vector(0, 1, 0)));
        this.add_component(new CasingGlass(this, new Vector(1, 1, 0)));
        this.add_component(new CasingStone(this, new Vector(2, 1, 0)));
        this.add_component(new CasingStone(this, new Vector(0, 1, 1)));
        this.add_component(new Water(this, new Vector(1, 1, 1)));
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

        this.add_component(new SolarCell(this, new Vector(0, 3, 0)));
        this.add_component(new SolarCell(this, new Vector(1, 3, 0)));
        this.add_component(new SolarCell(this, new Vector(2, 3, 0)));
        this.add_component(new SolarCell(this, new Vector(0, 3, 1)));
        this.add_component(new SolarCell(this, new Vector(1, 3, 1)));
        this.add_component(new SolarCell(this, new Vector(2, 3, 1)));
        this.add_component(new SolarCell(this, new Vector(0, 3, 2)));
        this.add_component(new SolarCell(this, new Vector(1, 3, 2)));
        this.add_component(new SolarCell(this, new Vector(2, 3, 2)));
    }

    @Override
    protected void add_recipes() {
        this.add_recipe(ChemicalRecipeRegistry.WATER_DECOMPOSITION);
        this.add_recipe(ChemicalRecipeRegistry.WATER_DECOMPOSITION_CHEAP);
        this.add_recipe(ChemicalRecipeRegistry.POTASSIUM_HYDROXIDE_ELECTROLYSIS);
        this.add_recipe(ChemicalRecipeRegistry.HYDROGEN_PEROXIDE);
        this.add_recipe(ChemicalRecipeRegistry.HYDROGEN_PEROXIDE_CHEAP);
        this.add_recipe(ChemicalRecipeRegistry.SODIUM_HYDROXIDE_SOLUTION_ELECTROLYSIS);
    }

    @Override
    protected void on_tick() {
        if(this.get_solar_cell().has_light_access()) this.increment_power(this.power_yield);
    }

    @Override
    protected void on_place() {
        this.temperature = this.base_location.getBlock().getTemperature();

        if(this.temperature < 0.5) this.power_yield = 0;
        if(this.temperature > 0.5) this.power_yield = 0.5f;
        if(this.temperature > 1.0) this.power_yield = 1.5f;
        if(this.temperature >= 2.0) this.power_yield = 2.0f;
    }

    @Override
    protected void on_destroy() {
    }

    @Override
    protected void on_change_state() {
    }
    
}
