package io.github.derbejijing.ic.chemical;

public enum ChemicalFireHazard {
    INFLAMMABLE(0, "Inflammable"),
    FLAMMABLE(1, "Flammable"),
    FLAMMABLE_HIGH(2, "Highly flammable");

    public final int id;
    public final String description;

    private ChemicalFireHazard(int id, String description) {
        this.id = id;
        this.description = description;
    }
}
