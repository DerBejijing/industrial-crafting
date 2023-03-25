package io.github.derbejijing.ic;

import org.bukkit.plugin.java.JavaPlugin;

import io.github.derbejijing.ic.event.PlayerListener;
import io.github.derbejijing.ic.machines.MultiblockMachineManager;

public class Main extends JavaPlugin {
    
    private static Main main;
    private static MultiblockMachineManager manager;

    @Override
    public void onEnable() {
        main = this;
        manager = new MultiblockMachineManager();

        this.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
    }


    public static Main get_main() {
        return main;
    }


    public static MultiblockMachineManager get_manager() {
        return manager;
    }
}