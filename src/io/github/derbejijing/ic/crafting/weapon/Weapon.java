package io.github.derbejijing.ic.crafting.weapon;

public enum Weapon {
    M16A4(""),
    AK_47(""),
    FN_FAL(""),
    AUG_A3(""),
    M4A1(""),
    G3A3(""),
    FAMAS(""),
    SCAR_H(""),
    P1911(""),
    DESERT_EAGLE(""),
    GLOCK_17(""),
    GLOCK_18(""),
    M9(""),
    PM(""),
    VZ61("");

    public String command;

    private Weapon(String command) {
        this.command = command;
    }
}
