package io.github.derbejijing.ic.machines.component;

import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Dropper;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.machines.MultiblockMachine;

public class InputHatch extends MultiblockComponent {

    public InputHatch(MultiblockMachine master, Vector location) {
        super(master, Material.DROPPER, location);
    }

    
    @Override
    public void on_place() {
        BlockState block_state = this.location_absolute.getBlock().getState();
        Dropper dropper = (Dropper) block_state;
        dropper.setCustomName("Input");
        dropper.update();
    }


    @Override
    protected void on_destroy() {
    }


    @Override
    protected void on_tick() {
    }
}
