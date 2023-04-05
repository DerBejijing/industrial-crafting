package io.github.derbejijing.ic.machines.component;

import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.machines.MultiblockMachine;
import io.github.derbejijing.ic.machines.MultiblockState;
import io.github.derbejijing.ic.machines.component.InterfaceUtils.InterfaceItem;

public class Interface extends MultiblockComponent {

    private Inventory inventory;

    public Interface(MultiblockMachine master, Vector location) {
        super(master, Material.CHEST, location);
    }


    @Override
    public void on_place() {
        BlockState block_state = this.location_absolute.getBlock().getState();
        Chest chest = (Chest) block_state;
        chest.setCustomName("Machine Interface");
        chest.update();

        InventoryHolder inventory_holder = (InventoryHolder) block_state;
        this.inventory = inventory_holder.getInventory();

        for(ItemStack item : this.inventory.getContents()) if(InterfaceUtils.is_interface_item(item)) this.inventory.removeItem(item);

        ItemStack pane_empty = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        InterfaceUtils.set_interface_item(pane_empty, InterfaceItem.PANE_EMPTY);

        ItemStack pane_button = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        InterfaceUtils.set_interface_item(pane_button, InterfaceItem.STATE_IDLE);

        for(int i = 0; i < 9 * 3; ++i) this.inventory.setItem(i, pane_empty);
        for(int i = 12; i < 15; ++i) this.inventory.setItem(i, new ItemStack(Material.AIR));;

        this.inventory.setItem(10, pane_button);
        this.inventory.setItem(16, new ItemStack(Material.AIR));
    }


    @Override
    protected void on_destroy() {
        InventoryHolder inventory_holder = (InventoryHolder) this.location_absolute.getBlock().getState();
        Inventory inventory = inventory_holder.getInventory();

        for(ItemStack item : inventory.getContents()) if(InterfaceUtils.is_interface_item(item)) inventory.removeItem(item);
    }


    @Override
    protected void on_tick() {
    }


    public void change_state(MultiblockState state) {
        ItemStack pane_button = new ItemStack(Material.GLASS_PANE);
    
        if(state == MultiblockState.BROKEN) InterfaceUtils.set_interface_item(pane_button, InterfaceItem.STATE_BROKEN);
        if(state == MultiblockState.IDLE) InterfaceUtils.set_interface_item(pane_button, InterfaceItem.STATE_IDLE);
        if(state == MultiblockState.NO_POWER) InterfaceUtils.set_interface_item(pane_button, InterfaceItem.STATE_NO_POWER);
        if(state == MultiblockState.RUNNING) InterfaceUtils.set_interface_item(pane_button, InterfaceItem.STATE_RUNNING);

        this.inventory.setItem(10, pane_button);
    }
}
