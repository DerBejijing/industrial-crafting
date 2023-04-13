package io.github.derbejijing.ic.crafting.weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import io.github.derbejijing.ic.chemical.ChemicalItem;

public abstract class WeaponRecipe {

    private ArrayList<ItemStack> ingredients;
    private ArrayList<ItemStack> ingredients_mag;
    private Weapon output;
    private boolean mag;

    private int time_required;
    private int power_required;

    private int progress;

    public WeaponRecipe(int time_required, int power_required, boolean mag) {
        this.ingredients = new ArrayList<ItemStack>();
        this.ingredients_mag = new ArrayList<ItemStack>();
        this.output = null;                     // 
        this.time_required = time_required;
        this.power_required = power_required;
        this.progress = 0;
        this.mag = mag;
        this.add_ingredients();
        this.set_output();

        this.add_ingredient_mag(Material.IRON_NUGGET, this.output.mag_size);
        this.add_ingredient_mag(Material.SUGAR, ChemicalItem.GUNPOWDER.id, this.output.mag_size / 2);
        this.add_ingredient_mag(Material.SUGAR, ChemicalItem.PRIMER_POWDER.id, this.output.mag_size / 2);
        this.add_ingredient_mag(Material.IRON_INGOT, 2);
    }


    public boolean attempt_craft(Location center, Inventory input, Inventory output, float power) {
        if(!this.mag) {
            if(power - this.power_required < 0) return false;

            Inventory inputs_copy = Bukkit.createInventory((InventoryHolder) null, input.getSize());
            inputs_copy.setContents(input.getContents());
            
            for(ItemStack item_required : this.ingredients) if(!inputs_copy.removeItem(item_required).isEmpty()) return false;

            ++this.progress;
            if(this.progress < this.time_required) return false;
            this.progress = 0;

            input.setContents(inputs_copy.getContents());

            ArmorStand armor_stand = (ArmorStand) center.getWorld().spawnEntity(center, EntityType.ARMOR_STAND);
            armor_stand.setInvisible(true);
            
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute as " + armor_stand.getUniqueId().toString() + " at @s run function " + this.output.command_weapon);

            armor_stand.setHealth(0);
            return true;
        } else {
            /*
             * Bukkit sucks ass when comparing items, so here some code violence
             */

            Inventory inputs_copy = Bukkit.createInventory((InventoryHolder)null, input.getSize());

            // create simplified copy
            for(ItemStack item : input.getContents()) {
                if(item == null) continue;
                
                ItemStack new_item = new ItemStack(item.getType(), item.getAmount());
                if(item.hasItemMeta() && item.getItemMeta().hasCustomModelData()) {
                    ItemMeta meta = new_item.getItemMeta();
                    meta.setCustomModelData(item.getItemMeta().getCustomModelData());
                    new_item.setItemMeta(meta);
                }

                inputs_copy.addItem(new_item);
            }


            // try to remove items
            for(ItemStack req : this.ingredients_mag) {
                ItemStack req_copy = new ItemStack(req);
                if(!inputs_copy.removeItem(req_copy).isEmpty()) return false;
            }


            // adjust item amounts
            for(ItemStack original : input.getContents()) {
                int location = input.first(original);

                if(location < 0) continue;

                ItemStack modified = inputs_copy.getItem(location);
                if(modified == null || modified.getAmount() == 0) continue;
                
                original.setAmount(modified.getAmount());
            }


            ArmorStand armor_stand = (ArmorStand) center.getWorld().spawnEntity(center, EntityType.ARMOR_STAND);
            armor_stand.setInvisible(true);
            
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute as " + armor_stand.getUniqueId().toString() + " at @s run function " + this.output.command_weapon + "_mag");

            armor_stand.setHealth(0);

            return false;
        }
    }



    public boolean check_inputs(ArrayList<ItemStack> requirements, Inventory input) {
        // Create a copy of the input inventory to preserve its original state
        Inventory inputCopy = Bukkit.createInventory((InventoryHolder)null, input.getSize());
        inputCopy.setContents(input.getContents());
    
        // Create a map to store the remaining amounts of each required item
        Map<String, Integer> remainingAmounts = new HashMap<>();
        for (ItemStack req : requirements) {
            Material material = req.getType();
            int amount = req.getAmount();
            Integer customModelData = req.getItemMeta().hasCustomModelData() ? req.getItemMeta().getCustomModelData() : null;
            String displayName = req.getItemMeta().hasDisplayName() ? req.getItemMeta().getDisplayName() : null;
            String lore = req.getItemMeta().hasLore() ? req.getItemMeta().getLore().toString() : null;

            // Use a unique identifier for each requirement to account for custom model data, display name, and lore
            String reqIdentifier = material.toString() + "_" + amount + "_" + customModelData + "_" + displayName + "_" + lore;
            remainingAmounts.put(reqIdentifier, amount);
        }

        // Iterate through the input inventory and try to match the requirements
        for (ItemStack item : input.getContents()) {
            if (item == null) {
                continue;
            }

            Material material = item.getType();
            int amount = item.getAmount();
            Integer customModelData = item.getItemMeta().hasCustomModelData() ? item.getItemMeta().getCustomModelData() : null;
            String displayName = item.getItemMeta().hasDisplayName() ? item.getItemMeta().getDisplayName() : null;
            String lore = item.getItemMeta().hasLore() ? item.getItemMeta().getLore().toString() : null;

            // Use a unique identifier for each item in the inventory to account for custom model data, display name, and lore
            String itemIdentifier = material.toString() + "_" + amount + "_" + customModelData + "_" + displayName + "_" + lore;

            for (ItemStack req : requirements) {
                Material reqMaterial = req.getType();
                int reqAmount = req.getAmount();
                Integer reqCustomModelData = req.getItemMeta().hasCustomModelData() ? req.getItemMeta().getCustomModelData() : null;
                String reqDisplayName = req.getItemMeta().hasDisplayName() ? req.getItemMeta().getDisplayName() : null;
                String reqLore = req.getItemMeta().hasLore() ? req.getItemMeta().getLore().toString() : null;

                // Use a unique identifier for each requirement to account for custom model data, display name, and lore
                String reqIdentifier = reqMaterial.toString() + "_" + reqAmount + "_" + reqCustomModelData + "_" + reqDisplayName + "_" + reqLore;

                if (itemIdentifier.equals(reqIdentifier) && reqAmount <= remainingAmounts.get(reqIdentifier)) {
                    int remainingAmount = remainingAmounts.get(reqIdentifier);
                    if (amount <= remainingAmount) {
                        // Enough items in the inventory to fulfill the requirement
                        remainingAmounts.put(reqIdentifier, remainingAmount - amount);
                        inputCopy.removeItem(item);
                    } else {
                        // Not enough items in the inventory, remove partial amount
                        remainingAmounts.put(reqIdentifier, 0);
                        inputCopy.removeItem(new ItemStack(material, remainingAmount));
                    }
                    break;
                }
            }
        }
    
        // Check if all requirements are fulfilled
        for (int remainingAmount : remainingAmounts.values()) {
            if (remainingAmount > 0) {
                return false;
            }
        }
    
        // Update the original input inventory to reflect the removed items
        input.setContents(inputCopy.getContents());
    
        return true;
    }



    public int get_power_required() {
        return this.power_required;
    }


    public boolean is_mag() {
        return this.mag;
    }


    protected void add_ingredient(Material material, int amount) {
        this.ingredients.add(new ItemStack(material, amount));
    }


    protected void add_ingredient(Material material, int custom_model_data, int amount) {
        ItemStack ingredient = new ItemStack(material, amount);
        ItemMeta meta = ingredient.getItemMeta();
        meta.setCustomModelData(custom_model_data);
        ingredient.setItemMeta(meta);
        this.ingredients.add(ingredient);
    }


    protected void add_ingredient_mag(Material material, int amount) {
        this.ingredients_mag.add(new ItemStack(material, amount));
    }


    protected void add_ingredient_mag(Material material, int custom_model_data, int amount) {
        ItemStack ingredient = new ItemStack(material, amount);
        ItemMeta meta = ingredient.getItemMeta();
        meta.setCustomModelData(custom_model_data);
        ingredient.setItemMeta(meta);
        this.ingredients_mag.add(ingredient);
    }


    protected void set_output(Weapon weapon) {
        this.output = weapon;
    }


    protected void set_output(Weapon weapon, boolean mag) {
        this.output = weapon;
        this.mag = true;
    }


    public abstract void add_ingredients();

    public abstract void set_output();
}
