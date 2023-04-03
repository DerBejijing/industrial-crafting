package io.github.derbejijing.ic.machines;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import io.github.derbejijing.ic.machines.MultiblockRegistry.RegistryEnum;

public class MultiblockMachineManager {
    private ArrayList<MultiblockMachine> machines;
    private HashMap<Location, MultiblockMachine> occupied_locations;


    public MultiblockMachineManager() {
        this.machines = new ArrayList<MultiblockMachine>();
        this.occupied_locations = new HashMap<Location, MultiblockMachine>();
    }


    public void tick() {
        for(MultiblockMachine mbm : this.machines) mbm.tick();
    }


    public void place(Player player, Location location, int orientation, int id) {
        Bukkit.getLogger().info("attempting to place [" + id + "] at [" + location.getX() + " " + location.getY() + " " + location.getZ() + "] [" + orientation + "]");
        this.register(MultiblockMachine.place(location, orientation, RegistryEnum.get_by_id(id)));
    }


    public void occupy_location(MultiblockMachine machine, Location location) {
        if(!this.location_occupied(location)) this.occupied_locations.put(location.clone(), machine);
    }


    public void free_location(MultiblockMachine machine, Location location) {

    }


    public boolean location_occupied(Location location) {
        return this.location_occupied_by(location) != null;
    }


    public MultiblockMachine location_occupied_by(Location location) {
        return this.occupied_locations.get(location);
    }


    public void register(MultiblockMachine machine) {
        if(machine == null) return;
        if(machine.get_state() == MultiblockState.INVALID) return;
        Bukkit.getLogger().info("machine [" + machine.getClass().getName() + "] registered");
        this.machines.add(machine);
    }
}
