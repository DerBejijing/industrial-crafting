package io.github.derbejijing.ic.chemical;

public enum ChemicalItem {
    CARBON(0),
    SULFUR(1),
    POTASSIUM_NITRATE(2),
    GUNPOWDER(3);

    public final int id;

    private ChemicalItem(int id) {
        this.id = id;
    }
}
