package io.github.derbejijing.ic.machines;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import io.github.derbejijing.ic.machines.MultiblockRegistry.RegistryEnum;

public class MultiblockMachineManager {
    private ArrayList<MultiblockMachine> machines;


    public MultiblockMachineManager() {

    }


    public void place(Player player, Location location, int orientation, int id) {
        MultiblockMachine.place(location, orientation, RegistryEnum.get_by_id(id));
    }


    public void register(MultiblockMachine machine) {
        if(machine == null) return;
        this.machines.add(machine);
    }
}
