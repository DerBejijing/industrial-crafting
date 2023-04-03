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
import io.github.derbejijing.ic.machines.MultiblockMachine;
import io.github.derbejijing.ic.machines.MultiblockRegistry;
import io.github.derbejijing.ic.machines.component.InterfaceUtils;
import io.github.derbejijing.ic.machines.component.InterfaceUtils.InterfaceItem;

public class PlayerListener implements Listener {
    
    @EventHandler
    public void player_click_block_event(PlayerInteractEvent e) {
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK && e.hasItem()) {
            Location location = e.getClickedBlock().getLocation();
            ItemStack item = e.getItem();

            if(item.getType() != Material.STICK) return;
            if(!item.getItemMeta().hasCustomModelData()) return;

            int id = item.getItemMeta().getCustomModelData();
            if(MultiblockRegistry.RegistryEnum.get_by_id(id) == null) return;

            Player player = e.getPlayer();
            int rotation = (int) (int) Math.floorMod(Math.round(player.getLocation().getYaw() / 90.0), 4);
            if(rotation < 0) rotation += 4;

            Main.get_manager().place(e.getPlayer(), location, rotation, id);
        }
    }


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory clicked_inventory = event.getClickedInventory();
        if (clicked_inventory != null && clicked_inventory.getType() == InventoryType.CHEST) {
            // check if it is part of a machine (check if occupied)
            ItemStack clicked_item = event.getCurrentItem();
            if(clicked_item != null && clicked_item.getType() != Material.AIR) if(InterfaceUtils.is_interface_item(clicked_item)) {
                event.setCancelled(true);

                Location location = clicked_inventory.getLocation();
                MultiblockMachine machine = Main.get_manager().location_occupied_by(location);
                machine.click_button(clicked_item);
            }
        }
    }
}
