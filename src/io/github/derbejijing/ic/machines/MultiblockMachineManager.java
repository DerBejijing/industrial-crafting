package io.github.derbejijing.ic.machines;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class MultiblockMachineManager {
    private ArrayList<MultiblockMachine> machines;

    public MultiblockMachineManager() {

    }


    public void place(Player player, Location location, int orientation, int id) {

    }


    public void register(MultiblockMachine machine) {
        this.machines.add(machine);
    }
}
