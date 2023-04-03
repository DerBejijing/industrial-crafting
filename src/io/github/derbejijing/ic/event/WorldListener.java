package io.github.derbejijing.ic.event;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import io.github.derbejijing.ic.Main;
import io.github.derbejijing.ic.machines.component.InterfaceUtils;

public class WorldListener implements Listener {
    
    @EventHandler
    public void item_move_event(InventoryMoveItemEvent e) {
        Inventory source = e.getSource();
        Inventory destination = e.getDestination();

        if(source.getType() == InventoryType.CHEST) {
            if(Main.get_manager().location_occupied(source.getLocation())) {
                e.setCancelled(true);
            }
        }

        if(destination.getType() == InventoryType.CHEST) {
            if(Main.get_manager().location_occupied(destination.getLocation())) {
                e.setCancelled(true);
            }
        }
    }

    
    @EventHandler
    public void block_break_event(BlockBreakEvent e) {
        handle_destruction(e.getBlock());
    }


    @EventHandler
    public void entity_explode_event(EntityExplodeEvent e) {
        for(Block block : e.blockList()) {
            handle_destruction(block);
        }
    }


    private static void handle_destruction(Block block) {
        if(block.getType().equals(Material.CHEST)) {
            if(Main.get_manager().location_occupied(block.getLocation())) {
                BlockState bs = block.getState();
                InventoryHolder inventory_holder = (InventoryHolder) bs;
                Inventory inventory = inventory_holder.getInventory();

                for(ItemStack item_stack : inventory.getContents()) {
                    if(InterfaceUtils.is_interface_item(item_stack)) {
                        inventory.remove(item_stack);
                    }
                }
            }
        }
    }


    /*
     * notes
     * 
     * why check for block breaking?
     * Because no interface items shall end up in player's inventories
     * therefore, look only for destruction of chests
     */
}
