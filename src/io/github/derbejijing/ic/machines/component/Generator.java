package io.github.derbejijing.ic.machines.component;

import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Dispenser;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.machines.MultiblockMachine;

public class Generator extends MultiblockComponent {

    public Generator(MultiblockMachine master, Vector location) {
        super(master, Material.DISPENSER, location);
    }

    @Override
    protected void on_place() {
        BlockState block_state = this.location_absolute.getBlock().getState();
        Dispenser dispenser = (Dispenser) block_state;
        dispenser.setCustomName("Fuel input");
        dispenser.update();
    }

    @Override
    protected void on_destroy() {
    }

    @Override
    protected void on_tick() {
    }
    
}
