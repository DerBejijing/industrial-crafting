package io.github.derbejijing.ic.crafting.chemical;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import io.github.derbejijing.ic.chemical.ChemicalItem;

public class ChemicalComponent {
    public ChemicalItem chemical;
    public boolean is_consumed;
    public int amount;

    public ChemicalComponent(ChemicalItem chemical, int amount, boolean is_consumed) {
        this.chemical = chemical;
        this.amount = amount;
        this.is_consumed = is_consumed;
    }


    public ItemStack to_item() {
        ItemStack item = new ItemStack(this.chemical.material, this.amount);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(this.chemical.id);
        item.setItemMeta(meta);
        return item;
    }
}
