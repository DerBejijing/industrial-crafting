package io.github.derbejijing.ic;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class Main extends JavaPlugin {
    
    @Override
    public void onEnable() {
        Vector v = new Vector(2, 2, 0);
        Bukkit.getLogger().info(v.getX() + " " + v.getY() + " " + v.getZ());
        v.rotateAroundZ(Math.PI);
        Bukkit.getLogger().info(v.getX() + " " + v.getY() + " " + v.getZ());
    }
}