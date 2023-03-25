package io.github.derbejijing.ic.machines;

import io.github.derbejijing.ic.machines.multiblock.ChemistryWorkbench;

public class MultiblockRegistry {
    private interface Registry<T extends MultiblockMachine> {
        int get_id();
        Class<? extends MultiblockMachine> get_class();
    }

    public enum RegistryEnum implements Registry<MultiblockMachine> {
        CHEMISTRY_WORKBENCH(1, ChemistryWorkbench.class);

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