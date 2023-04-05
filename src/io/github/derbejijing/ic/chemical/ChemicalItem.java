package io.github.derbejijing.ic.chemical;

import org.bukkit.Material;

import io.github.derbejijing.ic.chemical.material.Carbon;
import io.github.derbejijing.ic.chemical.material.GunPowder;
import io.github.derbejijing.ic.chemical.material.PotassiumNitrate;
import io.github.derbejijing.ic.chemical.material.Sulfur;

public enum ChemicalItem {
    CARBON(1, Material.SUGAR, Carbon.class),
    SULFUR(2, Material.SUGAR,Sulfur.class),
    POTASSIUM_NITRATE(3, Material.SUGAR,PotassiumNitrate.class),
    GUNPOWDER(4, Material.SUGAR,GunPowder.class);

    public final int id;
    public final Material material;
    public final Class<? extends Chemical> chemical_class;

    private ChemicalItem(int id, Material material, Class<? extends Chemical> chemical_class) {
        this.id = id;
        this.material = material;
        this.chemical_class = chemical_class;
    }


    public static Class<? extends Chemical> get_by_id(int id) {
        for(ChemicalItem item : ChemicalItem.values()) if(item.id == id) return item.chemical_class;
        return null;
    }
}
