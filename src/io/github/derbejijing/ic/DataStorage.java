package io.github.derbejijing.ic;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import io.github.derbejijing.ic.machines.MultiblockMachine;

public class DataStorage {
    
    private File file;
    private Main main;
    private YamlConfiguration config;

    public DataStorage(Main main, String file_name) {
        this.main = main;
        this.file = new File(this.main.getDataFolder(), file_name);
        this.config = YamlConfiguration.loadConfiguration(this.file);
    }


    @SuppressWarnings("unchecked")
    public void load() {
        ArrayList<MultiblockMachine> machines = new ArrayList<MultiblockMachine>();

        try {
            ArrayList<Object> serialized = (ArrayList<Object>) config.getList("machines");
            for(Object obj : serialized) {
                machines.add(MultiblockMachine.deserialize((Map<String, Object>) obj));
            }
            this.main.get_manager().set_machines(machines);
        }catch (Exception e) {
            Bukkit.getLogger().info("===== ISSUES ON LOADING MACHINES =====");
            e.printStackTrace();
        }
    }


    public void save() {
        ArrayList<Object> serialized = new ArrayList<Object>();
        for(MultiblockMachine machine : this.main.get_manager().get_machines()) serialized.add(machine.serialize());

        this.config.set("machines", serialized);

        try {
            this.config.save(this.file);
        } catch(Exception e) {
            Bukkit.getLogger().info("===== ISSUES ON LOADING MACHINES =====");
            e.printStackTrace();
        }
    }
}
