package io.github.derbejijing.ic.machines;

import java.util.ArrayList;

import org.bukkit.Location;

import io.github.derbejijing.ic.machines.component.MultiblockComponent;

public class MultiblockMachine {
    private Location base_location;
    private int orientation;
    private ArrayList<MultiblockComponent> components;
    private MultiblockState state;
}
