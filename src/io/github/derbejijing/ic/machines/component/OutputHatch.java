package io.github.derbejijing.ic.machines.component;

import org.bukkit.Material;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.machines.MultiblockMachine;

public class OutputHatch extends MultiblockComponent {

    public OutputHatch(MultiblockMachine master, Vector location) {
        super(master, Material.DROPPER, location);
    }


    @Override
    public void on_place() {
    }


    @Override
    protected void on_destroy() {
    }


    @Override
    protected void on_tick() {
    }
}
