package io.github.derbejijing.ic.machines.component;

import org.bukkit.Material;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.machines.MultiblockMachine;

public class Interface extends MultiblockComponent {

    public Interface(MultiblockMachine master, Vector location) {
        super(master, Material.CHEST, location);
    }

    @Override
    public void tick() {}
}
