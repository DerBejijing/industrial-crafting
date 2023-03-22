package io.github.derbejijing.ic.machines;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import io.github.derbejijing.ic.machines.multiblock.ChemistryWorkbench;

public class MultiblockMachineManager {
    private ArrayList<MultiblockMachine> machines;

    private interface MultiblockRegistry<T extends MultiblockMachine> {
        int get_id();
        Class<? extends MultiblockMachine> get_class();
    }

    public enum MultiblockRegistryEnum implements MultiblockRegistry<MultiblockMachine> {
        CHEMISTRY_WORKBENCH(0, ChemistryWorkbench.class);

        public final int id;
        public final Class<? extends MultiblockMachine> machine_class;

        private MultiblockRegistryEnum(int id, Class<? extends MultiblockMachine> machine_class) {
            this.id = id;
            this.machine_class = machine_class;
        }

        public int get_id() {
            return id;
        }

        public Class<? extends MultiblockMachine> get_class() {
            return machine_class;
        }

        public static Class<? extends MultiblockMachine> get_by_id(int id) {
            for(MultiblockRegistryEnum mr : MultiblockRegistryEnum.values()) if(id == mr.get_id()) return mr.get_class();
            return null;
        }
    }

    public MultiblockMachineManager() {

    }


    public void place(Player player, Location location, int orientation, int id) {
        MultiblockMachine.place(location, orientation, MultiblockRegistryEnum.get_by_id(id));
    }


    public void register(MultiblockMachine machine) {
        if(machine == null) return;
        this.machines.add(machine);
    }
}
