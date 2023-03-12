package io.github.derbejijing.ic.machines.component;

import org.bukkit.Location;
import org.bukkit.Material;

import io.github.derbejijing.ic.machines.MultiblockMachine;

public abstract class MultiblockComponent {
    private MultiblockMachine master;
    private Material material;
    private Location position;

    public abstract void tick();
}
