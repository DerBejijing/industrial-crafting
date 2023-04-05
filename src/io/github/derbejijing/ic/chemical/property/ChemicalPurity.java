package io.github.derbejijing.ic.chemical.property;

import net.md_5.bungee.api.ChatColor;

public enum ChemicalPurity {
    HEAVY_CONTAMINATION(0, "Heavy contaminations", ChatColor.DARK_RED),
    SLIGHT_CONTAMINATION(1, "Slight contaminations", ChatColor.RED),
    LOW_CONTAMINATION(2, "Low contaminations", ChatColor.YELLOW),
    CONSUMER_GRADE(3, "Considered clean", ChatColor.YELLOW),
    COMMERCIAL_GRADE(4, "Commercial grade purity", ChatColor.DARK_GREEN),
    INDUSTRIAL_GRADE(5, "Industrial grade purity", ChatColor.GREEN);

    public final int purity;
    public final String description;
    public final ChatColor color;

    private ChemicalPurity(int purity, String description, ChatColor color) {
        this.purity = purity;
        this.description = description;
        this.color = color;
    }


    public static ChemicalPurity get_by_id(int id) {
        for(ChemicalPurity cp : ChemicalPurity.values()) if(cp.purity == id) return cp;
        return ChemicalPurity.HEAVY_CONTAMINATION;
    }
}
