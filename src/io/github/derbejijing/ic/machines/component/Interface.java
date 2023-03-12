package io.github.derbejijing.ic.machines.component;

import org.bukkit.Location;
import org.bukkit.Material;

import io.github.derbejijing.ic.machines.MultiblockMachine;

public class Interface extends MultiblockComponent {

    public Interface(MultiblockMachine master, Material material, Location location) {
        super(master, material, location);
    }

    @Override
    public void tick() {}
}
