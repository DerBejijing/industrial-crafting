package io.github.derbejijing.ic.chemical.property;

import net.md_5.bungee.api.ChatColor;

public enum ChemicalFireHazard {
    INFLAMMABLE(0, "Inflammable", ChatColor.GREEN),
    FLAMMABLE(1, "Flammable", ChatColor.YELLOW),
    FLAMMABLE_HIGH(2, "Highly flammable", ChatColor.RED);

    public final int id;
    public final String description;
    public final ChatColor color;

    private ChemicalFireHazard(int id, String description, ChatColor color) {
        this.id = id;
        this.description = description;
        this.color = color;
    }
}
