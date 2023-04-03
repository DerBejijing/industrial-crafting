package io.github.derbejijing.ic.machines;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.BlockState;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import io.github.derbejijing.ic.Main;
import io.github.derbejijing.ic.machines.component.Interface;
import io.github.derbejijing.ic.machines.component.InterfaceUtils;
import io.github.derbejijing.ic.machines.component.MultiblockComponent;
import io.github.derbejijing.ic.machines.component.InterfaceUtils.InterfaceItem;

public abstract class MultiblockMachine {
    protected Location base_location;
    private int orientation;
    private MultiblockState state;
    private int power;

    protected ArrayList<MultiblockComponent> components;
    protected ArrayList<Location> occupied_locations;

    public MultiblockMachine(Location base_location, int orientation) {
        this.base_location = base_location;
        this.orientation = orientation;
        this.state = MultiblockState.INVALID;
        this.power = 0;

        this.components = new ArrayList<MultiblockComponent>();
        this.add_components();
    }


    public static <T extends MultiblockMachine> T place(Location base_location, int orientation, Class<T> clazz) {
        try {
            T m = clazz.getConstructor(Location.class, int.class).newInstance(base_location, orientation);

            boolean valid = true;
            
            for(MultiblockComponent mc : m.components) {
                mc.rotate(orientation);
                if(!m.base_location.add(mc.get_location()).getBlock().getType().equals(mc.get_material())) valid = false;

                if(Main.get_manager().location_occupied(m.base_location)) valid = false;

                m.base_location.subtract(mc.get_location());
            }
            
            if(valid) if(m.init_and_build()) return m;

        } catch(Exception e) {
            e.printStackTrace();
        }
        Bukkit.getLogger().info("invalid location or blocks");
        return null;
    }


    public void tick() {
        if(this.check_damage()) this.destroy();
        if(this.state != MultiblockState.BROKEN) this.on_tick();
    }


    public void power_increment(int power) {
        this.power += power;
    }


    public void click_button(ItemStack button) {
        InterfaceItem interface_item = InterfaceUtils.get_interface_item(button);
        if(interface_item == InterfaceItem.NONE) return;

        if(interface_item == InterfaceItem.STATE_RUNNING || interface_item == InterfaceItem.STATE_IDLE || interface_item == InterfaceItem.STATE_NO_POWER) {
            if(this.state == MultiblockState.IDLE) {
                InterfaceUtils.set_interface_item(button, InterfaceItem.STATE_RUNNING);
                this.change_state(MultiblockState.RUNNING);
                Bukkit.getLogger().info("now running");
            }
            else if(this.state == MultiblockState.RUNNING) {
                InterfaceUtils.set_interface_item(button, InterfaceItem.STATE_IDLE);
                this.change_state(MultiblockState.IDLE);
                Bukkit.getLogger().info("now idle");
            }
            else if(this.state == MultiblockState.NO_POWER) {
                InterfaceUtils.set_interface_item(button, InterfaceItem.STATE_NO_POWER);
                Bukkit.getLogger().info("no power!");
            }
        }
    }


    public boolean init_and_build() {
        try {
            this.on_place();
            this.occupy_locations();
            this.load_components();
            this.state = MultiblockState.IDLE;
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            try {
                this.destroy();
            } catch(Exception ee) {
                ee.printStackTrace();
            }
            return false;
        }
    }


    public MultiblockState get_state() {
        return this.state;
    }


    public Location get_location() {
        return this.base_location;
    }


    private void load_components() {
        for(MultiblockComponent mc : this.components) mc.place();
    }


    private void unload_components() {
        for(MultiblockComponent mc : this.components) mc.destroy();
    }


    private void change_state(MultiblockState state) {
        this.state = state;
        this.on_change_state();
    }


    private void destroy() {
        this.change_state(MultiblockState.BROKEN);
        this.free_locations();
        this.on_destroy();
        this.unload_components();
    }


    private void occupy_locations() {
        for(MultiblockComponent mc : this.components) {
            Main.get_manager().occupy_location(this, this.base_location.add(mc.get_location()));
            this.base_location.subtract(mc.get_location());
        }
    }


    private void free_locations() {
        for(MultiblockComponent mc : this.components) {
            Main.get_manager().free_location(this, this.base_location.add(mc.get_location()));
            this.base_location.subtract(mc.get_location());
        }
    }


    private boolean check_damage() {
        boolean damaged = false;

        for(MultiblockComponent mc : this.components) {
            if(!this.base_location.add(mc.get_location()).getBlock().getType().equals(mc.get_material())) damaged = true;
            this.base_location.subtract(mc.get_location());
        }

        return damaged;
    }


    protected void add_component(MultiblockComponent component) {
        this.components.add(component);
    }


    protected Interface get_interface() {
        for(MultiblockComponent mc : this.components) if(mc instanceof Interface) return (Interface) mc;
        return null;
    }


    protected void set_output(ItemStack out) {

    }


    protected Inventory get_inventory(Class<? extends MultiblockComponent> component_type) {
        for(MultiblockComponent mbc : this.components) {
            if(mbc.getClass().getName() == component_type.getName()) {
                this.base_location.add(mbc.get_location());
                BlockState bs = this.base_location.getBlock().getState();
                this.base_location.subtract(mbc.get_location());

                if(bs instanceof InventoryHolder) {
                    InventoryHolder inventory_holder = (InventoryHolder) bs;
                    return inventory_holder.getInventory();
                }
            }
        }

        return null;
    }


    protected abstract void add_components();

    protected abstract void on_tick();

    protected abstract void on_place();

    protected abstract void on_destroy();

    protected abstract void on_change_state();

}
