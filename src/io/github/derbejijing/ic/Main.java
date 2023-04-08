package io.github.derbejijing.ic;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import io.github.derbejijing.ic.command.GetChemical;
import io.github.derbejijing.ic.command.SetMachine;
import io.github.derbejijing.ic.command.SetRecipe;
import io.github.derbejijing.ic.event.PlayerListener;
import io.github.derbejijing.ic.event.WorldListener;
import io.github.derbejijing.ic.machines.MultiblockMachineManager;
import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
    
    private static Main main;
    private static MultiblockMachineManager manager;

    @Override
    public void onEnable() {
        main = this;
        manager = new MultiblockMachineManager();

        this.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        this.getServer().getPluginManager().registerEvents(new WorldListener(), this);

        this.getCommand("getchemical").setExecutor(new GetChemical());
        this.getCommand("setrecipe").setExecutor(new SetRecipe());
        this.getCommand("setmachine").setExecutor(new SetMachine());

        this.add_recipes();

        new BukkitRunnable() {       
            @Override
            public void run() {
                manager.tick();
            }
        }.runTaskTimer(this, 0, 20);
    }


    public static Main get_main() {
        return main;
    }


    public static MultiblockMachineManager get_manager() {
        return manager;
    }


    private void add_recipes() {
        ItemStack blueprint_item = new ItemStack(Material.PAPER);
        ItemMeta meta = blueprint_item.getItemMeta();

        meta.setDisplayName(ChatColor.RESET + "Blueprint");
        meta.setCustomModelData(1);
        blueprint_item.setItemMeta(meta);

        NamespacedKey nsk = new NamespacedKey(this, "blueprint_item");

        ShapedRecipe recipe = new ShapedRecipe(nsk, blueprint_item);
        
        recipe.shape("PB ");
        recipe.setIngredient('P', Material.PAPER);
        recipe.setIngredient('B', Material.BLUE_DYE);

        Bukkit.addRecipe(recipe);
    }
}



/*Notes
 * swap locations of in and out
 * 
 * add recrystallisation to purify chemicals
 */