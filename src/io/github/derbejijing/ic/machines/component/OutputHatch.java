package io.github.derbejijing.ic.machines.component;

import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Dropper;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.machines.MultiblockMachine;

public class OutputHatch extends MultiblockComponent {

    private Inventory inventory;

    public OutputHatch(MultiblockMachine master, Vector location) {
        super(master, Material.DROPPER, location);
    }


    @Override
    public void on_place() {
        BlockState block_state = this.location_absolute.getBlock().getState();
        Dropper dropper = (Dropper) block_state;
        dropper.setCustomName("Output");
        dropper.update();

        InventoryHolder inventory_holder = (InventoryHolder) block_state;
        this.inventory = inventory_holder.getInventory();
    }


    @Override
    protected void on_destroy() {
    }


    @Override
    protected void on_tick() {
    }


    public Inventory get_inventory() {
        return this.inventory;
    }
}
