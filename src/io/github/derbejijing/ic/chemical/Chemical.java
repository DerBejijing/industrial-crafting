package io.github.derbejijing.ic.chemical;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import io.github.derbejijing.ic.Main;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;
import net.md_5.bungee.api.ChatColor;

public class Chemical {
    private String name;
    private Material material;
    private int custom_model_data;
    private ChemicalPurity purity;
    private ChemicalToxicity toxicity;
    private ChemicalReactivity reactivity;
    private int count;

    public Chemical(String name, Material material, int custom_model_data, ChemicalPurity purity, ChemicalToxicity toxicity, ChemicalReactivity reactivity, int count) {
        this.name = name;
        this.material = material;
        this.custom_model_data = custom_model_data;
        this.purity = purity;
        this.toxicity = toxicity;
        this.reactivity = reactivity;
        this.count = count;
    }


    public ItemStack to_item() {
        ItemStack item = new ItemStack(this.material, this.count);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(this.custom_model_data);

        NamespacedKey nsk_pure = new NamespacedKey(Main.get_main(), "chemical_purity");
        meta.getPersistentDataContainer().set(nsk_pure, PersistentDataType.BYTE, (byte)this.purity.purity);

        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Purity: " + this.purity.color + this.purity.description);
        lore.add(ChatColor.GRAY + "Toxicity: " + this.toxicity.color + this.toxicity.description);
        lore.add(ChatColor.GRAY + "Reactivity:" + this.reactivity.color + this.reactivity.description);
        meta.setLore(lore);

        meta.setDisplayName(this.name);

        item.setItemMeta(meta);

        return item;
    }


    public static Chemical get_from(ItemStack item_stack) {
        if(item_stack == null || item_stack.getType().equals(Material.AIR)) return null;
        
        ItemMeta meta = item_stack.getItemMeta();
        if(meta == null || !meta.hasCustomModelData()) return null;

        int id = meta.getCustomModelData();

        NamespacedKey nsk_pure = new NamespacedKey(Main.get_main(), "chemical_purity");
        if(!meta.getPersistentDataContainer().has(nsk_pure, PersistentDataType.BYTE)) return null;

        int purity = meta.getPersistentDataContainer().get(nsk_pure, PersistentDataType.BYTE);

        Class<? extends Chemical> chemical_class = ChemicalItem.get_by_id(id);

        if(chemical_class == null) return null;

        try {
            Chemical chemical = chemical_class.getConstructor(int.class, ChemicalPurity.class).newInstance(item_stack.getAmount(), ChemicalPurity.get_by_id(purity));
            return chemical;
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
}