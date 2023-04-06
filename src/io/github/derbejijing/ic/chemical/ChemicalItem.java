package io.github.derbejijing.ic.chemical;

import org.bukkit.Material;

import io.github.derbejijing.ic.chemical.material.Carbon;
import io.github.derbejijing.ic.chemical.material.DistilledWater;
import io.github.derbejijing.ic.chemical.material.GunPowder;
import io.github.derbejijing.ic.chemical.material.Hydrogen;
import io.github.derbejijing.ic.chemical.material.Oxygen;
import io.github.derbejijing.ic.chemical.material.PotassiumNitrate;
import io.github.derbejijing.ic.chemical.material.Sulfur;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;

public enum ChemicalItem {
    CARBON(1, Material.SUGAR, Carbon.class),
    SULFUR(2, Material.SUGAR,Sulfur.class),
    POTASSIUM_NITRATE(3, Material.SUGAR,PotassiumNitrate.class),
    GUNPOWDER(4, Material.SUGAR,GunPowder.class),
    DISTILLED_WATER(5, Material.GLASS_BOTTLE, DistilledWater.class),
    HYDROGEN(6, Material.GLASS_BOTTLE, Hydrogen.class),
    OXYGEN(7, Material.GLASS_BOTTLE, Oxygen.class);

    public final int id;
    public final Material material;
    public final Class<? extends Chemical> chemical_class;

    private ChemicalItem(int id, Material material, Class<? extends Chemical> chemical_class) {
        this.id = id;
        this.material = material;
        this.chemical_class = chemical_class;
    }


    public Chemical to_chemical(ChemicalPurity purity, int amount) {
        try {
            return this.chemical_class.getConstructor(int.class, ChemicalPurity.class).newInstance(amount, purity);
        } catch(Exception e) {}
        return null;
    }


    public static Chemical get_by_id(int id, ChemicalPurity purity, int count) {
        try {
            for(ChemicalItem item : ChemicalItem.values()) if(item.id == id) return item.chemical_class.getConstructor(int.class, ChemicalPurity.class).newInstance(count, purity);
        } catch(Exception e) {}
        return null;
    }


    public static ChemicalItem get_from(Chemical chemical) {
        for(ChemicalItem item : ChemicalItem.values()) if(item.chemical_class.equals(chemical.getClass())) return item;
        return null;
    }
}
