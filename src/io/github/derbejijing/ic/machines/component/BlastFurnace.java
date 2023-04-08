package io.github.derbejijing.ic.machines.component;

import org.bukkit.Material;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.machines.MultiblockMachine;

public class BlastFurnace extends MultiblockComponent {

    public BlastFurnace(MultiblockMachine master, Vector location) {
        super(master, Material.BLAST_FURNACE, location);
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


    public void set_lit(boolean lit) {
        org.bukkit.block.Furnace f = (org.bukkit.block.Furnace) this.location_absolute.getBlock().getState();
        f.setBurnTime((short)0);
        if(lit) f.setBurnTime(Short.MAX_VALUE);
        f.update();
    }
}
