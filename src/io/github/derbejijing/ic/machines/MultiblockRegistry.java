package io.github.derbejijing.ic.machines;

import io.github.derbejijing.ic.machines.multiblock.Centrifuge;
import io.github.derbejijing.ic.machines.multiblock.ChemicalRefinery;
import io.github.derbejijing.ic.machines.multiblock.ChemistryWorkbench;
import io.github.derbejijing.ic.machines.multiblock.Condenser;
import io.github.derbejijing.ic.machines.multiblock.Electrolyzer;
import io.github.derbejijing.ic.machines.multiblock.Furnace;
import io.github.derbejijing.ic.machines.multiblock.Macerator;
import io.github.derbejijing.ic.machines.multiblock.SolarElectrolyzer;

public class MultiblockRegistry {
    private interface Registry<T extends MultiblockMachine> {
        int get_id();
        Class<? extends MultiblockMachine> get_class();
    }

    public enum RegistryEnum implements Registry<MultiblockMachine> {
        CHEMISTRY_WORKBENCH(1, ChemistryWorkbench.class),
        ELECTROLYZER(2, Electrolyzer.class),
        CHEMICAL_REFINERY(3, ChemicalRefinery.class),
        CONDENSER(4, Condenser.class),
        CENTRIFUGE(5, Centrifuge.class),
        MACERATOR(6, Macerator.class),
        SOLAR_ELECTROLYZER(7, SolarElectrolyzer.class),
        FURNACE(8, Furnace.class);

        public final int id;
        public final Class<? extends MultiblockMachine> machine_class;

        private RegistryEnum(int id, Class<? extends MultiblockMachine> machine_class) {
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
            for(RegistryEnum mr : RegistryEnum.values()) if(id == mr.get_id()) return mr.get_class();
            return null;
        }
    }
}