package io.github.derbejijing.ic.machines.component;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import io.github.derbejijing.ic.Main;
import net.md_5.bungee.api.ChatColor;

public class InterfaceUtils {

    public enum InterfaceItem {
        NONE(-1, " ", null, null),
        STATE_RUNNING(0, "Click to disable", Material.LIME_STAINED_GLASS_PANE, ChatColor.GREEN),
        STATE_IDLE(1, "Click to enable", Material.RED_STAINED_GLASS_PANE, ChatColor.DARK_RED),
        STATE_NO_POWER(2, "No power", Material.ORANGE_STAINED_GLASS_PANE, ChatColor.RED),
        STATE_BROKEN(3, "Broken", Material.GLASS_PANE, ChatColor.BLACK),
        PANE_EMPTY(4, " ", Material.BLACK_STAINED_GLASS_PANE, ChatColor.BLACK);

        public final int id;
        public final String text;
        public final Material material;
        public final ChatColor color;
        
        private InterfaceItem(int id, String text, Material material, ChatColor color) {
            this.id = id;
            this.text = text;
            this.material = material;
            this.color = color;
        }

        public static InterfaceItem get_by_id(int id) {
            for(InterfaceItem value : InterfaceItem.values()) if(value.id == id) return value;
            return InterfaceItem.NONE;
        }
    }

    // toggle the color of the running "button"
    public static void toggle_running() {

    }

    
    // update the information visible when hovering the running "button"
    public static void update_status() {

    }


    // check if the clicked item is part of a machine's inventory
    public static boolean is_interface_item(ItemStack item_stack) {
        return InterfaceUtils.get_interface_item(item_stack) != InterfaceItem.NONE;
    }


    // get the type of an interface item
    public static InterfaceItem get_interface_item(ItemStack item_stack) {
        if(item_stack == null || item_stack.getType() == Material.AIR) return InterfaceItem.NONE;

        ItemMeta meta = item_stack.getItemMeta();

        if(meta == null) return InterfaceItem.NONE;

        NamespacedKey nsk = new NamespacedKey(Main.get_main(), "is_interface_item");
        PersistentDataContainer data_container = meta.getPersistentDataContainer();

        if(data_container == null) return InterfaceItem.NONE;
        if(!data_container.has(nsk, PersistentDataType.BYTE)) return InterfaceItem.NONE;

        Byte data_value = data_container.get(nsk, PersistentDataType.BYTE);

        return InterfaceItem.get_by_id(data_value);
    }


    // modify an item to be an interface item
    public static void set_interface_item(ItemStack item_stack, InterfaceItem type) {
        ItemMeta meta = item_stack.getItemMeta();
        NamespacedKey nsk = new NamespacedKey(Main.get_main(), "is_interface_item");
        meta.getPersistentDataContainer().set(nsk, PersistentDataType.BYTE, (byte)type.id);
        meta.setDisplayName(type.color + type.text);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        item_stack.setItemMeta(meta);
        item_stack.setType(type.material);
    }
}
