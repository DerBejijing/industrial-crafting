package io.github.derbejijing.ic.machines.multiblock;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.machines.MultiblockMachine;
import io.github.derbejijing.ic.machines.component.CasingIron;
import io.github.derbejijing.ic.machines.component.Interface;
import io.github.derbejijing.ic.machines.component.PowerSocket;

public class ChemistryWorkbench extends MultiblockMachine {

    public ChemistryWorkbench(Location base_Location, int orientation) {
        super(base_Location, orientation);
    }


    protected void add_components() {
        this.add_component(new CasingIron(this, new Vector(0, 0, 0)));
        this.add_component(new Interface(this, new Vector(1, 0, 0)));
        this.add_component(new CasingIron(this, new Vector(2, 0, 0)));
        this.add_component(new CasingIron(this, new Vector(0, 1, 0)));
        this.add_component(new PowerSocket(this, new Vector(1, 1, 0)));
        this.add_component(new CasingIron(this, new Vector(2, 0, 0)));
    }


    protected void on_tick() {
    }


    protected void on_place() {
    }


    protected void on_destroy() {
    }


    protected void on_change_state() {
    }
}
