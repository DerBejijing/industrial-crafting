package io.github.derbejijing.ic.machines.component;

import org.bukkit.Location;
import org.bukkit.Material;

import io.github.derbejijing.ic.machines.MultiblockMachine;

public class OutputHatch extends MultiblockComponent {

    public OutputHatch(MultiblockMachine master, Material material, Location location) {
        super(master, material, location);
    }

    @Override
    public void tick() {}
}
