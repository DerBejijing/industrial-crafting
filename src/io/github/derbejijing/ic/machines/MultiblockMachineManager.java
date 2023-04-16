package io.github.derbejijing.ic.machines;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import io.github.derbejijing.ic.machines.MultiblockRegistry.RegistryEnum;

public class MultiblockMachineManager {
    private ArrayList<MultiblockMachine> machines;
    private HashMap<Location, MultiblockMachine> occupied_locations;
    private boolean changed;


    public MultiblockMachineManager() {
        this.machines = new ArrayList<MultiblockMachine>();
        this.occupied_locations = new HashMap<Location, MultiblockMachine>();
        this.changed = false;
    }


    public boolean has_changed() {
        boolean has_changed = this.changed;
        this.changed = false;
        return has_changed;
    }


    public ArrayList<MultiblockMachine> get_machines() {
        return this.machines;
    }


    public void set_machines(ArrayList<MultiblockMachine> machines) {
        if(machines != null) this.machines = machines;
        this.changed = true;
    }


    public void tick() {
        for(MultiblockMachine mbm : this.machines) mbm.tick();

        ArrayList<MultiblockMachine> machines_remove = new ArrayList<MultiblockMachine>();
        for(MultiblockMachine mbm : this.machines) if(mbm.get_state() == MultiblockState.BROKEN) machines_remove.add(mbm);
        if(this.machines.removeAll(machines_remove)) this.changed = true;
    }


    public void place(Player player, Location location, int orientation, int id) {
        this.register(MultiblockMachine.place(location, orientation, RegistryEnum.get_by_id(id)));
    }


    public void occupy_location(MultiblockMachine machine, Location location) {
        if(!this.location_occupied(location)) this.occupied_locations.put(location.clone(), machine);
    }


    public void free_location(MultiblockMachine machine, Location location) {
        this.occupied_locations.remove(location);
    }


    public boolean location_occupied(Location location) {
        return this.location_occupied_by(location) != null;
    }


    public MultiblockMachine location_occupied_by(Location location) {
        return this.occupied_locations.get(location);
    }


    public void register(MultiblockMachine machine) {
        if(machine == null) return;
        if(machine.get_state() == MultiblockState.BROKEN) return;
        this.machines.add(machine);
        this.changed = true;
    }
}
