package io.github.derbejijing.ic.machines;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import io.github.derbejijing.ic.machines.MultiblockRegistry.RegistryEnum;
import io.github.derbejijing.ic.machines.component.MultiblockComponent;

public class MultiblockMachineManager {
    private ArrayList<MultiblockMachine> machines;


    public MultiblockMachineManager() {
        this.machines = new ArrayList<MultiblockMachine>();
    }


    public void tick() {
        for(MultiblockMachine mbm : this.machines) mbm.tick();
    }


    public void place(Player player, Location location, int orientation, int id) {
        Bukkit.getLogger().info("attempting to place [" + id + "] at [" + location.getX() + " " + location.getY() + " " + location.getZ() + "] [" + orientation + "]");
        this.register(MultiblockMachine.place(location, orientation, RegistryEnum.get_by_id(id)));
    }


    public boolean location_occupied(Location location) {
        return false;
    }


    public void register(MultiblockMachine machine) {
        if(machine == null) return;
        if(machine.get_state() == MultiblockState.INVALID) return;
        Bukkit.getLogger().info("machine [" + machine.getClass().getName() + "] registered");
        this.machines.add(machine);
    }
}
