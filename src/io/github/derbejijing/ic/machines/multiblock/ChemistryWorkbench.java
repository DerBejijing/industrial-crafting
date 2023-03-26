package io.github.derbejijing.ic.machines.multiblock;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.machines.MultiblockMachine;
import io.github.derbejijing.ic.machines.component.CasingIron;
import io.github.derbejijing.ic.machines.component.Interface;
import io.github.derbejijing.ic.machines.component.PowerSocket;

public class ChemistryWorkbench extends MultiblockMachine {

    public ChemistryWorkbench(Location base_Location, int orientation) {
        super(base_Location, orientation);
    }


    protected void add_components() {
        this.add_component(new CasingIron(this, new Vector(0, 0, 0)));
        this.add_component(new Interface(this, new Vector(1, 0, 0)));
        this.add_component(new CasingIron(this, new Vector(2, 0, 0)));
        this.add_component(new CasingIron(this, new Vector(0, 0, 1)));
        this.add_component(new PowerSocket(this, new Vector(1, 0, 1)));
        this.add_component(new CasingIron(this, new Vector(2, 0, 1)));
    }


    protected void on_tick() {
    }


    protected void on_place() {
        Bukkit.getLogger().info("yay");
        Inventory i = this.get_inventory(Interface.class);
        for(ItemStack is : i.getContents()) if(is != null) Bukkit.getLogger().info("Item in chest: " + is.getType());
    }


    protected void on_destroy() {
    }


    protected void on_change_state() {
    }
}
