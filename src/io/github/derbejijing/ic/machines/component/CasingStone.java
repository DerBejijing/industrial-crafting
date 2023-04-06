package io.github.derbejijing.ic.machines.component;

import org.bukkit.Material;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.machines.MultiblockMachine;

public class CasingStone extends MultiblockComponent {

    public CasingStone(MultiblockMachine master, Vector location) {
        super(master, Material.SMOOTH_STONE, location);
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
