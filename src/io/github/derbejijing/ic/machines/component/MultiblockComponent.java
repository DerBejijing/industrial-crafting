package io.github.derbejijing.ic.machines.component;

import org.bukkit.Location;
import org.bukkit.Material;

import io.github.derbejijing.ic.machines.MultiblockMachine;

public abstract class MultiblockComponent {
    private MultiblockMachine master;
    private Material material;
    private Location location;

    public MultiblockComponent(MultiblockMachine master, Material material, Location location) {
        this.master = master;
        this.material = material;
        this.location = location;
    }

    public abstract void tick();
}
