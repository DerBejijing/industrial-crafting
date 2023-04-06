package io.github.derbejijing.ic;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import io.github.derbejijing.ic.command.GetChemical;
import io.github.derbejijing.ic.event.PlayerListener;
import io.github.derbejijing.ic.event.WorldListener;
import io.github.derbejijing.ic.machines.MultiblockMachineManager;

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
}