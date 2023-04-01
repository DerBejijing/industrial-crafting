package io.github.derbejijing.ic.machines.component;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import io.github.derbejijing.ic.Main;

public class InterfaceUtils {

    public enum InterfaceItem {
        STATE_RUNNING(0, "Click to disable"),
        STATE_IDLE(1, "Click to enable"),
        PANE_EMPTY(3, "");

        public final int id;
        public final String text;
        
        private InterfaceItem(int id, String text) {
            this.id = id;
            this.text = text;
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
        ItemMeta meta = item_stack.getItemMeta();
        NamespacedKey nsk = new NamespacedKey(Main.get_main(), "is_interface_item");

        if(meta.getPersistentDataContainer().has(nsk, PersistentDataType.BYTE)) {
            byte value = meta.getPersistentDataContainer().get(nsk, PersistentDataType.BYTE);
            return true;
        }

        return false;
    }


    // modify an item to be an interface item
    public static void set_interface_item(ItemStack item_stack, InterfaceItem type) {
        ItemMeta meta = item_stack.getItemMeta();
        NamespacedKey nsk = new NamespacedKey(Main.get_main(), "is_interface_item");
        meta.getPersistentDataContainer().set(nsk, PersistentDataType.BYTE, (byte)type.id);
        meta.setDisplayName(type.text);
    }
}
