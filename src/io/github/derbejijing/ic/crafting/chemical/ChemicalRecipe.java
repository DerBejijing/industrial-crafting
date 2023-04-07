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
    private class OutputItemData {
        public int amount;
        public int purity;
        public boolean has_fixed_purity;
        
        public OutputItemData(int amount, int fixed_purity) {
            this.amount = amount;
            this.purity = fixed_purity;
            this.has_fixed_purity = true;
        }

        public OutputItemData(int amount) {
            this.amount = amount;
            this.purity = 0;
            this.has_fixed_purity = false;
        }
    }


    private ArrayList<ChemicalItem> ingredients;            // items that will be consumed
    private ArrayList<ChemicalItem> requirements;           // items that are required but will not be consumed
    private HashMap<ChemicalItem, OutputItemData> outputs;         // items that will be produced 
    
    private int base_impurity;                              // result will be contaminated no matter what
    private int power_required;                             // energy required
    private int time;                                       // time (seconds) required to craft

    private int progress;


    public ChemicalRecipe(int power_required, int time, int base_impurity) {
        this.ingredients = new ArrayList<ChemicalItem>();
        this.requirements = new ArrayList<ChemicalItem>();
        this.outputs = new HashMap<ChemicalItem, OutputItemData>();
        this.power_required = power_required;
        this.time = time;
        this.base_impurity = base_impurity;
        this.progress = 0;
        this.add_ingredients();
        this.add_requirements();
        this.add_outputs();
    }


    public boolean attempt_craft(Inventory input, Inventory output, int power) {
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

        int purity_best = this.base_impurity;

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

        ++this.progress;
        if(this.progress < this.time) return false;
        this.progress = 0;

        input.setContents(inputs_copy.getContents());
        output.setContents(outputs_copy.getContents());

        return true;
    }


    public int get_power_required() {
        return this.power_required;
    }


    protected void add_ingredient(ChemicalItem ingredient, int amount) {
        for(int i = 0; i < amount; ++i) this.ingredients.add(ingredient);
    }


    protected void add_requirement(ChemicalItem requirement, int amount) {
        for(int i = 0; i < amount; ++i) this.requirements.add(requirement);
    }


    protected void add_output(ChemicalItem output, int amount) {
        this.outputs.put(output, new OutputItemData(amount));
    }


    protected void add_output(ChemicalItem output, int amount, ChemicalPurity fixed_purity) {
        this.outputs.put(output, new OutputItemData(amount, fixed_purity.purity));
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
        for(Map.Entry<ChemicalItem, OutputItemData> entry : this.outputs.entrySet()) {
            OutputItemData oid = entry.getValue();
            int purity_item = purity;
            if(oid.has_fixed_purity) purity_item = oid.purity;

            ItemStack new_item = entry.getKey().to_chemical(ChemicalPurity.get_by_id(purity_item), oid.amount).to_item();
            items.add(new_item);
        }
        return items;
    }


    public abstract void add_ingredients();

    public abstract void add_requirements();

    public abstract void add_outputs();
}