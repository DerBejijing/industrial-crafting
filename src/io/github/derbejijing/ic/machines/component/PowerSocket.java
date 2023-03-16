package io.github.derbejijing.ic.machines.component;

import org.bukkit.Material;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.machines.MultiblockMachine;

public class PowerSocket extends MultiblockComponent {

    public PowerSocket(MultiblockMachine master, Vector location) {
        super(master, Material.OBSERVER, location);
    }

    @Override
    public void tick() {}
}
