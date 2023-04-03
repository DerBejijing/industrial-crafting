package io.github.derbejijing.ic.event;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import io.github.derbejijing.ic.Main;
import io.github.derbejijing.ic.machines.component.InterfaceUtils;

public class PlayerListener implements Listener {
    
    @EventHandler
    public void player_click_block_event(PlayerInteractEvent e) {
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK && e.hasItem()) {
            Location location = e.getClickedBlock().getLocation();
            ItemStack item = e.getItem();

            if(item.getType() != Material.STICK) return;
            if(!item.getItemMeta().hasCustomModelData()) return;

            Player player = e.getPlayer();
            int rotation = (int) (int) Math.floorMod(Math.round(player.getLocation().getYaw() / 90.0), 4);
            if(rotation < 0) rotation += 4;

            Main.get_manager().place(e.getPlayer(), location, rotation, item.getItemMeta().getCustomModelData());
        }
    }


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory clickedInv = event.getClickedInventory();
        if (clickedInv != null && clickedInv.getType() == InventoryType.CHEST) {
            // check if it is part of a machine (check if occupied)
            ItemStack clicked_item = event.getCurrentItem();
            if(clicked_item != null && clicked_item.getType() != Material.AIR) if(InterfaceUtils.is_interface_item(clicked_item)) event.setCancelled(true);
        }
    }
}
