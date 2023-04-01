package io.github.derbejijing.ic.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;

public class WorldListener implements Listener {
    
    @EventHandler
    public void item_move_event(InventoryMoveItemEvent e) {
        e.setCancelled(true);
    }

}
