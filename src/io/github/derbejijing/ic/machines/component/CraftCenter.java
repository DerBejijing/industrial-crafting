package io.github.derbejijing.ic.machines.component;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.machines.MultiblockMachine;

public class CraftCenter extends MultiblockComponent {

    public CraftCenter(MultiblockMachine master, Vector location) {
        super(master, Material.AIR, location);
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


    public Location get_location_center() {
        return this.location_absolute;
    }
}
