package io.github.derbejijing.ic.chemical;

public enum ChemicalReactivity {
    STABLE(0, "Stable"),
    UNSTABLE_ON_HEAT(1, "Unstable if heated"),
    UNSTABLE(2, "Violent Reaction"),
    EXPLOSIVE(3, "Explosive decomposition"),
    EXPLOSIVE_UNSTABLE(4, "Spontaneous explosive decomposition");


    public final int id;
    public final String description;

    private ChemicalReactivity(int id, String description) {
        this.id = id;
        this.description = description;
    }
}
