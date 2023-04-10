package io.github.derbejijing.ic;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;
import io.github.derbejijing.ic.crafting.weapon.WeaponRecipe;
import io.github.derbejijing.ic.machines.MultiblockMachine;
import io.github.derbejijing.ic.machines.MultiblockState;

public class DataStorage {
    
    private File file;
    private Main main;
    private FileConfiguration config;

    public DataStorage(Main main, String file_name) {
        this.main = main;
        this.file = new File(this.main.getDataFolder(), file_name);
        this.config = YamlConfiguration.loadConfiguration(this.file);
    }


    public void load() {

    }


    public void save() {

    }


    private void save_machine(MultiblockMachine machine) {

    }


    private void load_machine(Location location, MultiblockState state, int power, ChemicalRecipe recipe) {

    }


    private void load_machine(Location location, MultiblockState state, int power, WeaponRecipe recipe) {
        
    }

}
