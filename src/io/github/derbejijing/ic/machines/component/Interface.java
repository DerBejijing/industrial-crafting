package io.github.derbejijing.ic.machines.component;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.machines.MultiblockMachine;
import io.github.derbejijing.ic.machines.MultiblockState;
import io.github.derbejijing.ic.machines.component.InterfaceUtils.InterfaceItem;
import net.md_5.bungee.api.ChatColor;

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


    public void change_power_level(float power) {
        ItemStack button = this.inventory.getItem(10);
        ItemMeta meta = button.getItemMeta();

        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Power: [" + progress_bar(power) + ChatColor.GRAY + "]");
        lore.add(ChatColor.GRAY + "Current job: ");
        meta.setLore(lore);

        button.setItemMeta(meta);
    }


    private static String progress_bar(float progress) {
        if(progress >= 1) progress = 1.0f;
        if(progress <= 0) progress = 0.0f;
        int green = Math.round(progress * 10);
        int red = 10 - green;
    
        StringBuilder bar = new StringBuilder();
    
        for (int i = 0; i < green; i++) {
            bar.append(ChatColor.GREEN + "I");
        }
    
        for (int i = 0; i < red; i++) {
            bar.append(ChatColor.RED + "I");
        }
    
        return bar.toString();
    }
}
