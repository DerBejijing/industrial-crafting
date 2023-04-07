package io.github.derbejijing.ic.machines.component;

import org.bukkit.Material;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.machines.MultiblockMachine;

public class CasingStoneSlab extends MultiblockComponent {

    public CasingStoneSlab(MultiblockMachine master, Vector location) {
        super(master, Material.SMOOTH_STONE_SLAB, location);
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
