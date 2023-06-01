package io.github.derbejijing.ic.machines.component;

import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Dropper;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.machines.MultiblockMachine;

public class InputHatch extends MultiblockComponent {

    private Inventory inventory;

    public InputHatch(MultiblockMachine master, Vector location) {
        super(master, Material.DROPPER, location);
    }

    
    @Override
    public void on_place() {
        BlockState block_state = this.location_absolute.getBlock().getState();
        Dropper dropper = (Dropper) block_state;
        dropper.setCustomName("Input");
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


    public void re_sync() {
        BlockState block_state = this.location_absolute.getBlock().getState();
        InventoryHolder inventory_holder = (InventoryHolder) block_state;
        this.inventory = inventory_holder.getInventory();
    }


    public Inventory get_inventory() {
        return this.inventory;
    }
}
