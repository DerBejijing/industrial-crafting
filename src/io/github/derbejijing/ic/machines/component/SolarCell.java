package io.github.derbejijing.ic.machines.component;

import org.bukkit.Material;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.machines.MultiblockMachine;

public class SolarCell extends MultiblockComponent {

    public SolarCell(MultiblockMachine master, Vector location) {
        super(master, Material.DAYLIGHT_DETECTOR, location);
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


    public boolean has_light_access() {
        long time = this.location_absolute.getWorld().getTime();
        return this.location_absolute.getBlock().getLightFromSky() >= 15 && (time >= 0 && time < 12300 || time > 23850);
    }
}
