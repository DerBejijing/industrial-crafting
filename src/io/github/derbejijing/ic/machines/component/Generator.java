package io.github.derbejijing.ic.machines.component;

import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Dispenser;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.machines.MultiblockMachine;

public class Generator extends MultiblockComponent {

    private Inventory inventory;


    private enum Fuel {
        LAVA_BUCKET(Material.LAVA_BUCKET, 500),
        COAL_BLOCK(Material.COAL_BLOCK, 400),
        DRIED_KELP_BLOCK(Material.DRIED_KELP_BLOCK, 150),
        BLAZE_ROD(Material.BLAZE_ROD, 100),
        COAL(Material.COAL, 50),
        CHARCOAL(Material.CHARCOAL, 50);
    
        public final Material type;
        public final int burn_time;
    
        private Fuel(Material type, int burn_time) {
            this.type = type;
            this.burn_time = burn_time;
        }

        public static int get_burn_time(Material material) {
            for(Fuel fuel : Fuel.values()) if(fuel.type.equals(material)) return fuel.burn_time;
            return 0;
        }

        public static int get_chemical_burn_time(ItemStack item) {
            Chemical chemical = Chemical.get_from(item);
            if(chemical == null) return 0;

            if(chemical.getClass().equals(ChemicalItem.HYDROGEN.chemical_class)) return 200;
            if(chemical.getClass().equals(ChemicalItem.ACETONE.chemical_class)) return 400;
            if(chemical.getClass().equals(ChemicalItem.ETHANOL.chemical_class)) return 100;
            if(chemical.getClass().equals(ChemicalItem.METHANOL.chemical_class)) return 100;

            return 0;
        }
    }


    public Generator(MultiblockMachine master, Vector location) {
        super(master, Material.DISPENSER, location);
    }


    @Override
    protected void on_place() {
        BlockState block_state = this.location_absolute.getBlock().getState();
        Dispenser dispenser = (Dispenser) block_state;
        dispenser.setCustomName("Fuel input");
        dispenser.update();

        this.setup_inventory();
    }


    @Override
    protected void on_destroy() {
    }


    @Override
    protected void on_tick() {
    }


    public void re_sync() {
        BlockState block_state = this.location_absolute.getBlock().getState();
        InventoryHolder inventory_holder = (InventoryHolder) block_state;
        this.inventory = inventory_holder.getInventory();
    }


    private void setup_inventory() {
        InventoryHolder inventory_holder = (InventoryHolder) this.location_absolute.getBlock().getState();
        this.inventory = inventory_holder.getInventory();
    }


    public int generate_energy() {
        for(ItemStack item : this.inventory.getContents()) {
            if(item != null && item.getType() != Material.AIR) {
                int power = Fuel.get_burn_time(item.getType());
                power += Fuel.get_chemical_burn_time(item);

                if(power > 0) {
                    item.setAmount(item.getAmount() - 1);
                    return power;
                }
            }
        }
        return 0;
    }
    
}
