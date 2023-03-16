package io.github.derbejijing.ic.machines;

import java.util.ArrayList;

import org.bukkit.Location;

import io.github.derbejijing.ic.machines.component.MultiblockComponent;

public abstract class MultiblockMachine {
    private Location base_location;
    private int orientation;
    private MultiblockState state;
    private int power;

    public ArrayList<MultiblockComponent> components;

    public MultiblockMachine(Location base_location, int orientation) {
        this.base_location = base_location;
        this.orientation = orientation;
        this.add_components();
    }


    public static MultiblockMachine place_old(Location base_location, int orientation) {
        try {
            MultiblockMachine m = MultiblockMachine.class.getConstructor(Location.class, Integer.class).newInstance(base_location, orientation);

            boolean valid = true;

            for(MultiblockComponent mc : m.components) {
                mc.rotate(orientation);
                if(!mc.get_material().equals(base_location.add(mc.get_location()).getBlock().getType())) valid = false;
            }

            if(valid) {
                m.init_and_build();
                return m;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static <T extends MultiblockMachine> T place(Location base_location, int orientation, Class<T> clazz) {
        try {
            T m = clazz.getConstructor(Location.class, Integer.class).newInstance(base_location, orientation);

            boolean valid = true;

            for(MultiblockComponent mc : m.components) {
                mc.rotate(orientation);
                if(!mc.get_material().equals(base_location.add(mc.get_location()).getBlock().getType())) valid = false;
            }

            if(valid) {
                m.init_and_build();
                return m;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void tick() {
        if(this.check_damage()) {
            this.change_state(MultiblockState.BROKEN);
            this.on_destroy();
        }
        if(this.state != MultiblockState.BROKEN) this.on_tick();
    }


    public void change_state(MultiblockState state) {
        this.state = state;
        this.on_change_state();
    }


    public void power_increment(int power) {
        this.power += power;
    }


    public void init_and_build() {
        this.on_place();
    }


    private boolean check_damage() {
        return false;
    }


    protected void add_component(MultiblockComponent component) {
        this.components.add(component);
    }


    protected abstract void add_components();

    protected abstract void on_tick();

    protected abstract void on_place();

    protected abstract void on_destroy();

    protected abstract void on_change_state();

}
