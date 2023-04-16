package io.github.derbejijing.ic.machines;

import io.github.derbejijing.ic.machines.multiblock.Centrifuge;
import io.github.derbejijing.ic.machines.multiblock.ChemicalRefinery;
import io.github.derbejijing.ic.machines.multiblock.Condenser;
import io.github.derbejijing.ic.machines.multiblock.Electrolyzer;
import io.github.derbejijing.ic.machines.multiblock.Furnace;
import io.github.derbejijing.ic.machines.multiblock.Macerator;
import io.github.derbejijing.ic.machines.multiblock.Reactor;
import io.github.derbejijing.ic.machines.multiblock.Recrystallizer;
import io.github.derbejijing.ic.machines.multiblock.SolarCondenser;
import io.github.derbejijing.ic.machines.multiblock.SolarElectrolyzer;
import io.github.derbejijing.ic.machines.multiblock.WeaponAssembly;

public class MultiblockRegistry {
    private interface Registry<T extends MultiblockMachine> {
        int get_id();
        Class<? extends MultiblockMachine> get_class();
    }

    public enum RegistryEnum implements Registry<MultiblockMachine> {
        ELECTROLYZER(1, Electrolyzer.class),
        CHEMICAL_REFINERY(2, ChemicalRefinery.class),
        CONDENSER(3, Condenser.class),
        CENTRIFUGE(4, Centrifuge.class),
        MACERATOR(5, Macerator.class),
        SOLAR_ELECTROLYZER(6, SolarElectrolyzer.class),
        FURNACE(7, Furnace.class),
        REACTOR(8, Reactor.class),
        RECRYSTALLIZER(9, Recrystallizer.class),
        WEAPON_ASSEMBLY(10, WeaponAssembly.class),
        SOLAR_CONDENSER(11, SolarCondenser.class);

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
