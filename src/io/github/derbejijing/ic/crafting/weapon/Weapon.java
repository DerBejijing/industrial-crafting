package io.github.derbejijing.ic.crafting.weapon;

public enum Weapon {
    M16A4("mgs_catalog:assult_rifles/m16", 30),
    AK_47("mgs_catalog:assult_rifles/ak47", 30),
    FN_FAL("mgs_catalog:assult_rifles/fnfal", 20),
    AUG_A3("mgs_catalog:assult_rifles/aug", 30),
    M4A1("mgs_catalog:assult_rifles/m4", 30),
    G3A3("mgs_catalog:assult_rifles/g3", 20),
    FAMAS("mgs_catalog:assult_rifles/famas", 25),
    SCAR_H("mgs_catalog:assult_rifles/scarh", 20),
    P1911("mgs_catalog:pistols/1911", 7),
    DESERT_EAGLE("mgs_catalog:pistols/desert_eagle", 7),
    GLOCK_17("mgs_catalog:pistols/glock17", 17),
    GLOCK_18("mgs_catalog:pistols/glock18", 19),
    M9("mgs_catalog:pistols/m9", 15),
    PM("mgs_catalog:pistols/makarov", 8),
    VZ61("mgs_catalog:pistols/vz61", 20),
    MP5A3("mgs_catalog:smgs/mp5", 30),
    MAC10("mgs_catalog:smgs/mac10", 30),
    MP7A1("mgs_catalog:smgs/mp7", 40),
    PPSH("mgs_catalog:smgs/ppsh41", 71),
    STEN("mgs_catalog:smgs/sten", 32),
    SPAS12("mgs_catalog:shotguns/spas12", 8),
    M500("mgs_catalog:shotguns/m500", 5),
    M590("mgs_catalog:shotguns/m590", 8),
    SVD("mgs_catalog:sniper_rifle/dragunov", 10),
    M82A1("mgs_catalog:sniper_rifles/barrett_50cal", 10),
    MOSIN("mgs_catalog:sniper_rifles/mosin_nagant", 5),
    M24A3("mgs_catalog:sniper_rifle/m24", 5),
    RPG("mgs_catalog:special/rpg7", 1),
    RPK("mgs_catalog:special/rpk", 75),
    M249("mgs_catalog:special/m249", 150);

    public String command_weapon;
    public int mag_size;

    private Weapon(String command_weapon, int mag_size) {
        this.command_weapon = command_weapon;
        this.mag_size = mag_size;
    }
}
