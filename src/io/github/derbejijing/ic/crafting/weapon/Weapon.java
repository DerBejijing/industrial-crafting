package io.github.derbejijing.ic.crafting.weapon;

public enum Weapon {
    M16A4(""),
    AK_47(""),
    FN_FAL(""),
    AUG_A3(""),
    M4A1(""),
    G3A3(""),
    FAMAS(""),
    SCAR_H("");

    public String command;

    private Weapon(String command) {
        this.command = command;
    }
}
