package io.github.derbejijing.ic.machines.component;

import org.bukkit.Material;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.machines.MultiblockMachine;

public abstract class MultiblockComponent {
    private MultiblockMachine master;
    private Material material;
    private Vector location;

    public MultiblockComponent(MultiblockMachine master, Material material, Vector location) {
        this.master = master;
        this.material = material;
        this.location = location;
    }


    public void rotate(int orientation) {
        this.location.rotateAroundZ(orientation * Math.PI / 2);
    }


    public Vector get_location() {
        return this.location;
    }


    public Material get_material() {
        return this.material;
    }


    public abstract void tick();
}
