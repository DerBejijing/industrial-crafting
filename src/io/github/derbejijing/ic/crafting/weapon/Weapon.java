package io.github.derbejijing.ic.crafting.weapon;

public enum Weapon {
    M16A4("mgs_catalog:assult_rifles/m16"),
    AK_47("mgs_catalog:assult_rifles/ak47"),
    FN_FAL("mgs_catalog:assult_rifles/fnfal"),
    AUG_A3("mgs_catalog:assult_rifles/aug"),
    M4A1("mgs_catalog:assult_rifles/m4"),
    G3A3("mgs_catalog:assult_rifles/g3"),
    FAMAS("mgs_catalog:assult_rifles/famas"),
    SCAR_H("mgs_catalog:assult_rifles/scarh"),
    P1911("mgs_catalog:pistols/1911"),
    DESERT_EAGLE("mgs_catalog:assult_rifles/desert_eagle"),
    GLOCK_17("mgs_catalog:assult_rifles/glock17"),
    GLOCK_18("mgs_catalog:assult_rifles/glock18"),
    M9("mgs_catalog:assult_rifles/m9"),
    PM("mgs_catalog:assult_rifles/pm"),
    VZ61("mgs_catalog:assult_rifles/vz61"),
    MP5A3("mgs_catalog:smgs/mp5"),
    MAC10("mgs_catalog:smgs/mac10"),
    MP7A1("mgs_catalog:smgs/mp7"),
    PPSH("mgs_catalog:smgs/ppsh41"),
    STEN("mgs_catalog:smgs/sten"),
    SPAS12("mgs_catalog:shotguns/spas12"),
    M500("mgs_catalog:shotguns/m500"),
    M590("mgs_catalog:shotguns/m590"),
    SVD("mgs_catalog:sniper_rifle/dragunov"),
    M82A1("mgs_catalog:sniper_rifle/barrett_50cal"),
    MOSIN("mgs_catalog:sniper_rifle/mosin_nagant"),
    M24A3("mgs_catalog:sniper_rifle/m24"),
    RPG("mgs_catalog:special/rpg7"),
    RPK("mgs_catalog:special/rpk"),
    M249("mgs_catalog:special/m249");

    public String command;

    private Weapon(String command) {
        this.command = command;
    }
}
