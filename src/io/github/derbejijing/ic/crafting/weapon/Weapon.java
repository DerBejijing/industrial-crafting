package io.github.derbejijing.ic.crafting.weapon;

public enum Weapon {
    AK_74("mgs_catalog:assult_rifles/ak47");

    public String command;

    private Weapon(String command) {
        this.command = command;
    }
}
