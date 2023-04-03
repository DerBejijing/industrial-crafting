package io.github.derbejijing.ic.machines.component;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.machines.MultiblockMachine;

public abstract class MultiblockComponent {
    private MultiblockMachine master;
    private Material material;
    private Vector location;

    protected Location location_absolute;

    public MultiblockComponent(MultiblockMachine master, Material material, Vector location) {
        this.master = master;
        this.material = material;
        this.location = location;
        this.location_absolute = master.get_location().clone();
    }


    public void tick() {
        this.on_tick();
    }


    public void place() {
        this.location_absolute = this.master.get_location().add(this.location).clone();
        this.master.get_location().subtract(this.location);
        this.on_place();
    }


    public void destroy() {
        this.on_destroy();
    }


    public void rotate(int orientation) {
        this.location.rotateAroundY(orientation * -1 * Math.PI / 2);
    }


    public Vector get_location() {
        return this.location;
    }


    public Material get_material() {
        return this.material;
    }


    protected abstract void on_place();

    protected abstract void on_destroy();

    protected abstract void on_tick();
}
