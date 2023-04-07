package io.github.derbejijing.ic.chemical;

import org.bukkit.Material;

import io.github.derbejijing.ic.chemical.material.Carbon;
import io.github.derbejijing.ic.chemical.material.DistilledWater;
import io.github.derbejijing.ic.chemical.material.GunPowder;
import io.github.derbejijing.ic.chemical.material.Hydrogen;
import io.github.derbejijing.ic.chemical.material.Oxygen;
import io.github.derbejijing.ic.chemical.material.PotassiumNitrate;
import io.github.derbejijing.ic.chemical.material.Sulfur;
import io.github.derbejijing.ic.chemical.material.SulfuricAcid;
import io.github.derbejijing.ic.chemical.material.Water;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;

public enum ChemicalItem {
    CARBON(1, Material.SUGAR, Carbon.class, false),
    SULFUR(2, Material.SUGAR,Sulfur.class, false),
    POTASSIUM_NITRATE(3, Material.SUGAR,PotassiumNitrate.class, false),
    GUNPOWDER(4, Material.SUGAR,GunPowder.class, false),
    SODIUM_CHLORIDE(5, Material.SUGAR, GunPowder.class, false),
    DISTILLED_WATER(6, Material.GLASS_BOTTLE, DistilledWater.class, false),
    HYDROGEN(7, Material.GLASS_BOTTLE, Hydrogen.class, false),
    OXYGEN(8, Material.GLASS_BOTTLE, Oxygen.class, false),
    SULFURIC_ACID(9, Material.GLASS_BOTTLE, SulfuricAcid.class, false),
    WATER(10, Material.WATER_BUCKET, Water.class, true);

    public final int id;
    public final Material material;
    public final Class<? extends Chemical> chemical_class;
    public final boolean raw;

    private ChemicalItem(int id, Material material, Class<? extends Chemical> chemical_class, boolean raw) {
        this.id = id;
        this.material = material;
        this.chemical_class = chemical_class;
        this.raw = raw;
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


    public static Chemical get_by_material(Material material, ChemicalPurity purity, int count) {
        try {
            for(ChemicalItem item : ChemicalItem.values()) if(item.material.equals(material)) if(item.raw) return item.chemical_class.getConstructor(int.class, ChemicalPurity.class).newInstance(count, purity);
        } catch(Exception e) {}
        return null;
    }


    public static ChemicalItem get_from(Chemical chemical) {
        for(ChemicalItem item : ChemicalItem.values()) if(item.chemical_class.equals(chemical.getClass())) return item;
        return null;
    }
}
