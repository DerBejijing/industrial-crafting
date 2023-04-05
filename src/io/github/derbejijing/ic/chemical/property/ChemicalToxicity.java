package io.github.derbejijing.ic.chemical.property;

import net.md_5.bungee.api.ChatColor;

public enum ChemicalToxicity {
    NONE(0, "Non-toxic", ChatColor.GREEN),
    SLIGHTLY_HAZARDOUS(1, "Slightly hazardous", ChatColor.YELLOW),
    HAZARDOUS(2, "Hazardous", ChatColor.YELLOW),
    EXTREME_DANGER(3, "Extremely hazardous", ChatColor.RED),
    LETHAL(4, "Lethal", ChatColor.DARK_RED);

    public final int id;
    public final String description;
    public final ChatColor color;

    private ChemicalToxicity(int id, String description, ChatColor color) {
        this.id = id;
        this.description = description;
        this.color = color;
    }
}
