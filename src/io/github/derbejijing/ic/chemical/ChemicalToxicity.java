package io.github.derbejijing.ic.chemical;

public enum ChemicalToxicity {
    NONE(0, "Non-toxic"),
    SLIGHTLY_HAZARDOUS(1, "Slightly hazardous"),
    HAZARDOUS(2, "Hazardous"),
    EXTREME_DANGER(3, "Extremely hazardous"),
    LETHAL(4, "Lethal");

    public final int id;
    public final String description;

    private ChemicalToxicity(int id, String description) {
        this.id = id;
        this.description = description;
    }
}
