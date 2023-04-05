package io.github.derbejijing.ic.chemical.property;

public enum ChemicalPurity {
    HEAVY_CONTAMINATION(0, "Heavy contaminations"),
    SLIGHT_CONTAMINATION(1, "Slight contaminations"),
    LOW_CONTAMINATION(2, "Low contaminations"),
    CONSUMER_GRADE(3, "Considered clean"),
    COMMERCIAL_GRADE(4, "Commercial grade purity"),
    INDUSTRIAL_GRADE(5, "Industrial grade purity");

    public final int purity;
    public final String description;

    private ChemicalPurity(int purity, String description) {
        this.purity = purity;
        this.description = description;
    }
}
