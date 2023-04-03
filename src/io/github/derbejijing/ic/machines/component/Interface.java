package io.github.derbejijing.ic.machines.component;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.machines.MultiblockMachine;
import io.github.derbejijing.ic.machines.component.InterfaceUtils.InterfaceItem;

public class Interface extends MultiblockComponent {

    public Interface(MultiblockMachine master, Vector location) {
        super(master, Material.CHEST, location);
    }


    @Override
    public void on_place() {
        InventoryHolder inventory_holder = (InventoryHolder) this.location_absolute.getBlock().getState();
        Inventory inventory = inventory_holder.getInventory();

        for(ItemStack item : inventory.getContents()) {
            if(InterfaceUtils.is_interface_item(item)) inventory.removeItem(item);
        }

        ItemStack pane_empty = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        InterfaceUtils.set_interface_item(pane_empty, InterfaceItem.PANE_EMPTY);

        ItemStack pane_button = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        InterfaceUtils.set_interface_item(pane_button, InterfaceItem.STATE_IDLE);

        for(int i = 0; i < 9 * 3; ++i) inventory.setItem(i, pane_empty);
        for(int i = 12; i < 15; ++i) inventory.setItem(i, new ItemStack(Material.AIR));;

        inventory.setItem(10, pane_button);
        inventory.setItem(16, new ItemStack(Material.AIR));

    }


    @Override
    protected void on_tick() {
    }
}
