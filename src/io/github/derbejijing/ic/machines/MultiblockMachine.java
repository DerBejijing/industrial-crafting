package io.github.derbejijing.ic.machines;

import java.util.ArrayList;

import org.bukkit.Bukkit;
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
                //mc.rotate(orientation);
                //if(!mc.get_material().equals(base_location.add(mc.get_location()).getBlock().getType())) valid = false;
                //base_location.subtract(mc.get_location());
                mc.rotate(orientation);
                base_location.add(mc.get_location());
                Bukkit.getLogger().info("at [" + base_location.getX() + " " + base_location.getY() + " " + base_location.getZ() + "]: " + base_location.getBlock().getType());
                Bukkit.getLogger().info("at [" + (int)mc.get_location().getX() + " " + (int)mc.get_location().getY() + " " + (int)mc.get_location().getZ() + "]: " + mc.get_material());

                if(!base_location.getBlock().getType().equals(mc.get_material())) {
                    Bukkit.getLogger().info("invalid HERE");
                    valid = false;
                }

                base_location.subtract(mc.get_location());
            }

            if(valid) {
                m.init_and_build();
                return m;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        Bukkit.getLogger().info("invalid blocks");
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
        this.state = MultiblockState.IDLE;
    }


    public MultiblockState get_state() {
        return this.state;
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
