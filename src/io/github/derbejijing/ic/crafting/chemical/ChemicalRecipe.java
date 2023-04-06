package io.github.derbejijing.ic.crafting.chemical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;

public abstract class ChemicalRecipe {
    private ArrayList<ChemicalItem> ingredients;         // items that will be consumed
    private ArrayList<ChemicalItem> requirements;        // items that are required but will not be consumed
    private HashMap<ChemicalItem, Integer> outputs;             // items that will be produced 
    
    public int power_required;                                  // energy required
    public int time;                                            // time (seconds) required to craft

    public ChemicalRecipe(int power_required, int time) {
        this.ingredients = new ArrayList<ChemicalItem>();
        this.requirements = new ArrayList<ChemicalItem>();
        this.outputs = new HashMap<ChemicalItem, Integer>();
        this.power_required = power_required;
        this.time = time;
        this.add_ingredients();
        this.add_requirements();
        this.add_outputs();
    }


    public boolean attempt_craft(Inventory input, Inventory output, int power, int output_space) {
        if(power - this.power_required < 0) return false;

        Inventory outputs_copy = Bukkit.createInventory((InventoryHolder)null, output.getSize());
        outputs_copy.setContents(output.getContents());

        Inventory inputs_copy = Bukkit.createInventory((InventoryHolder) null, input.getSize());
        inputs_copy.setContents(input.getContents());

        // check if input and output are the same containers
        // if so, after removal of the items, they must be synced
        boolean sync_inventories = output.getLocation().equals(input.getLocation());

        ArrayList<ChemicalItem> ingredients_copy = new ArrayList<ChemicalItem>(this.ingredients);
        ArrayList<ChemicalItem> requirements_copy = new ArrayList<ChemicalItem>(this.requirements);

        int purity_best = 0;

        // get all itemstacks and check if they are required
        // if so, get their impurities to process later
        for(ItemStack item : inputs_copy.getContents()) {
            Chemical chemical = Chemical.get_from(item);

            if(chemical != null) {
                ChemicalPurity purity = chemical.get_purity();

                // check if purity is worse than purity_best, if so, make purity_best worse
                if(purity.purity > purity_best) purity_best = purity.purity;

                ChemicalItem chemical_item = ChemicalItem.get_from(chemical);

                // check if the item is required and remove it from the copy inventory
                while(ingredients_copy.remove(chemical_item)) item.setAmount(item.getAmount() - 1);

                requirements_copy.remove(chemical_item);
            }
        }

        // check if all requirements and ingredients are present
        if(!ingredients_copy.isEmpty()) return false;
        if(!requirements_copy.isEmpty()) return false;

        // if they must be synced, do so now
        if(sync_inventories) outputs_copy.setContents(inputs_copy.getContents());

        // generate output itemstack
        ArrayList<ItemStack> outputs = this.get_output_items(purity_best);

        // all required items have been removed
        // check if output has enough space
        if(!enough_space(outputs_copy, outputs)) return false;

        input.setContents(inputs_copy.getContents());
        output.setContents(outputs_copy.getContents());

        return true;
    }


    protected void add_ingredient(ChemicalItem ingredient, int amount) {
        for(int i = 0; i < amount; ++i) this.ingredients.add(ingredient);
    }


    protected void add_requirement(ChemicalItem requirement, int amount) {
        for(int i = 0; i < amount; ++i) this.requirements.add(requirement);
    }


    protected void add_output(ChemicalItem output, int amount) {
        this.outputs.put(output, amount);
    }


    // check if output_inventory has enough space for outputs
    // if so, it will return true and add them to output_inventory
    private boolean enough_space(Inventory output_inventory, ArrayList<ItemStack> outputs) {
        Inventory output_copy = Bukkit.createInventory((InventoryHolder)null, output_inventory.getSize());
        output_copy.setContents(output_inventory.getContents());

        for(ItemStack item : outputs) {
            HashMap<Integer, ItemStack> add = output_copy.addItem(item);
            if(!add.isEmpty()) return false;
        }

        output_inventory.setContents(output_copy.getContents());
        return true;
    }


    private ArrayList<ItemStack> get_output_items(int purity) {
        ArrayList<ItemStack> items = new ArrayList<ItemStack>();
        for(Map.Entry<ChemicalItem, Integer> entry : this.outputs.entrySet()) {
            ItemStack new_item = entry.getKey().to_chemical(ChemicalPurity.get_by_id(purity), entry.getValue()).to_item();
            items.add(new_item);
        }
        return items;
    }


    public abstract void add_ingredients();

    public abstract void add_requirements();

    public abstract void add_outputs();
}