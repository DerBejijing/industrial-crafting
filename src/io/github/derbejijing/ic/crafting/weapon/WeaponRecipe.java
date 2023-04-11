package io.github.derbejijing.ic.crafting.weapon;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class WeaponRecipe {

    private ArrayList<ItemStack> ingredients;
    private Weapon output;
    private boolean mag;

    private int time_required;
    private int power_required;

    private int progress;

    public WeaponRecipe(int time_required, int power_required) {
        this.ingredients = new ArrayList<ItemStack>();
        this.output = null;                     // 
        this.time_required = time_required;
        this.power_required = power_required;
        this.progress = 0;
        this.add_ingredients();
        this.set_output();
    }


    public boolean attempt_craft(Location center, Inventory input, Inventory output, float power) {
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
        
        if(this.mag) Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute as " + armor_stand.getUniqueId().toString() + " at @s run function " + this.output.command_weapon + "_mag");
        else Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute as " + armor_stand.getUniqueId().toString() + " at @s run function " + this.output.command_weapon);

        armor_stand.setHealth(0);
        return true;
    }


    public int get_power_required() {
        return this.power_required;
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
