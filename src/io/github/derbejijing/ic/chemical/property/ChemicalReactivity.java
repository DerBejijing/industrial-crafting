package io.github.derbejijing.ic.chemical.property;

import net.md_5.bungee.api.ChatColor;

public enum ChemicalReactivity {
    STABLE(0, "Stable", ChatColor.GREEN),
    UNSTABLE_ON_HEAT(1, "Unstable if heated", ChatColor.DARK_GREEN),
    UNSTABLE(2, "Violent Reaction", ChatColor.YELLOW),
    EXPLOSIVE(3, "Explosive decomposition", ChatColor.RED),
    EXPLOSIVE_UNSTABLE(4, "Spontaneous explosive decomposition", ChatColor.DARK_RED);


    public final int id;
    public final String description;
    public final ChatColor color;

    private ChemicalReactivity(int id, String description, ChatColor color) {
        this.id = id;
        this.description = description;
        this.color = color;
    }
}
