package io.github.derbejijing.ic.machines.component;

import org.bukkit.Material;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.machines.MultiblockMachine;

public class CasingIron extends MultiblockComponent {

    public CasingIron(MultiblockMachine master, Vector location) {
        super(master, Material.IRON_BLOCK, location);
    }

    @Override
    public void tick() {
    }
    
}
