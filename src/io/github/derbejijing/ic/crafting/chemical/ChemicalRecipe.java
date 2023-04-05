package io.github.derbejijing.ic.crafting.chemical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;

public abstract class ChemicalRecipe {
    private ArrayList<ChemicalComponent> ingredients;
    private ChemicalComponent output;
    
    public int power_required;

    public ChemicalRecipe(ChemicalComponent output, int power_required) {
        this.ingredients = new ArrayList<ChemicalComponent>();
        this.output = output;
        this.power_required = power_required;
        this.add_components();
    }


    public boolean attempt_craft(Inventory input, int power, int output_space) {
        if(power - this.power_required < 0) return false;
        if(this.get_yield() > output_space) return false;
        
        Inventory inputs_copy = Bukkit.createInventory((InventoryHolder) null, input.getSize());
        inputs_copy.setContents(input.getContents());

        for(ChemicalComponent cc : this.ingredients) {
            ItemStack ingredient = new ItemStack(cc.chemical.material, cc.amount);
            ItemMeta ingredient_meta = ingredient.getItemMeta();
            ingredient_meta.setCustomModelData(cc.chemical.id);
            ingredient.setItemMeta(ingredient_meta);

            HashMap<Integer, ItemStack> removal = inputs_copy.removeItem(ingredient);

            if(!removal.isEmpty()) return false;
        }

        input.setContents(inputs_copy.getContents());
        input.addItem(this.output.to_item());

        return true;
    }


    protected void add_ingredient(ChemicalComponent component) {
        this.ingredients.add(component);
    }


    private int get_yield() {
        return this.output.amount;
    }


    public abstract void add_components();
}
