package io.github.derbejijing.ic.chemical;

import org.bukkit.Material;

import io.github.derbejijing.ic.chemical.material.AceticAcid;
import io.github.derbejijing.ic.chemical.material.Acetone;
import io.github.derbejijing.ic.chemical.material.AcetonePeroxide;
import io.github.derbejijing.ic.chemical.material.Apple;
import io.github.derbejijing.ic.chemical.material.Calcite;
import io.github.derbejijing.ic.chemical.material.CalciumCarbonate;
import io.github.derbejijing.ic.chemical.material.Carbon;
import io.github.derbejijing.ic.chemical.material.CarbonDioxide;
import io.github.derbejijing.ic.chemical.material.CarbonMonoxide;
import io.github.derbejijing.ic.chemical.material.ChlorinatedHydrocarbons;
import io.github.derbejijing.ic.chemical.material.Chlorine;
import io.github.derbejijing.ic.chemical.material.Chloroacetone;
import io.github.derbejijing.ic.chemical.material.Chloroform;
import io.github.derbejijing.ic.chemical.material.Coal;
import io.github.derbejijing.ic.chemical.material.CobbleStone;
import io.github.derbejijing.ic.chemical.material.CrushedNetherrack;
import io.github.derbejijing.ic.chemical.material.DistilledWater;
import io.github.derbejijing.ic.chemical.material.EmptyBucket;
import io.github.derbejijing.ic.chemical.material.Ethanol;
import io.github.derbejijing.ic.chemical.material.GunPowder;
import io.github.derbejijing.ic.chemical.material.HydrochloricAcid;
import io.github.derbejijing.ic.chemical.material.Hydrogen;
import io.github.derbejijing.ic.chemical.material.HydrogenPeroxide;
import io.github.derbejijing.ic.chemical.material.Liquor;
import io.github.derbejijing.ic.chemical.material.MetalDust;
import io.github.derbejijing.ic.chemical.material.Methane;
import io.github.derbejijing.ic.chemical.material.Methanol;
import io.github.derbejijing.ic.chemical.material.Netherrack;
import io.github.derbejijing.ic.chemical.material.OrganicWaste;
import io.github.derbejijing.ic.chemical.material.Oxygen;
import io.github.derbejijing.ic.chemical.material.Phosphorous;
import io.github.derbejijing.ic.chemical.material.PotassiumChlorate;
import io.github.derbejijing.ic.chemical.material.PotassiumChloride;
import io.github.derbejijing.ic.chemical.material.PotassiumHydroxide;
import io.github.derbejijing.ic.chemical.material.PotassiumHydroxideSolution;
import io.github.derbejijing.ic.chemical.material.PotassiumNitrate;
import io.github.derbejijing.ic.chemical.material.PrimerPowder;
import io.github.derbejijing.ic.chemical.material.SodiumAcetate;
import io.github.derbejijing.ic.chemical.material.SodiumCarbonate;
import io.github.derbejijing.ic.chemical.material.SodiumChloride;
import io.github.derbejijing.ic.chemical.material.SodiumHydroxide;
import io.github.derbejijing.ic.chemical.material.SodiumHydroxideSolution;
import io.github.derbejijing.ic.chemical.material.Soil;
import io.github.derbejijing.ic.chemical.material.StoneDust;
import io.github.derbejijing.ic.chemical.material.SugarCane;
import io.github.derbejijing.ic.chemical.material.Sulfur;
import io.github.derbejijing.ic.chemical.material.SulfurDioxide;
import io.github.derbejijing.ic.chemical.material.SulfurTrioxide;
import io.github.derbejijing.ic.chemical.material.SulfuricAcid;
import io.github.derbejijing.ic.chemical.material.Waste;
import io.github.derbejijing.ic.chemical.material.Water;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;

public enum ChemicalItem {
    CARBON(1, Material.SUGAR, Carbon.class, false),
    SULFUR(2, Material.SUGAR,Sulfur.class, false),
    POTASSIUM_NITRATE(3, Material.SUGAR,PotassiumNitrate.class, false),
    GUNPOWDER(4, Material.SUGAR,GunPowder.class, false),
    SODIUM_CHLORIDE(5, Material.SUGAR, SodiumChloride.class, false),
    DISTILLED_WATER(6, Material.GLASS_BOTTLE, DistilledWater.class, false),
    HYDROGEN(7, Material.GLASS_BOTTLE, Hydrogen.class, false),
    OXYGEN(8, Material.GLASS_BOTTLE, Oxygen.class, false),
    SULFURIC_ACID(9, Material.GLASS_BOTTLE, SulfuricAcid.class, false),
    WATER(10, Material.WATER_BUCKET, Water.class, true),
    SOIL(11, Material.DIRT, Soil.class, true),
    COBBLESTONE(12, Material.COBBLESTONE, CobbleStone.class, true),
    STONE_DUST(13, Material.SUGAR, StoneDust.class, false),
    METAL_DUST(14, Material.SUGAR, MetalDust.class, false),
    NETHERRACK(15, Material.NETHERRACK, Netherrack.class, true),
    CRUSHED_NETHERRACK(16, Material.SUGAR, CrushedNetherrack.class, false),
    PHOSPHOROUS(17, Material.SUGAR, Phosphorous.class, false),
    CALCITE(18, Material.CALCITE, Calcite.class, true),
    CALCIUM_CARBONATE(19, Material.SUGAR, CalciumCarbonate.class, false),
    ACETIC_ACID(20, Material.GLASS_BOTTLE, AceticAcid.class, false),
    CARBON_MONOXIDE(21, Material.GLASS_BOTTLE, CarbonMonoxide.class, false),
    METHANOL(22, Material.GLASS_BOTTLE, Methanol.class, false),
    ETHANOL(23, Material.GLASS_BOTTLE, Ethanol.class, false),
    LIQUOR(24, Material.GLASS_BOTTLE, Liquor.class, false),
    COAL(25, Material.COAL, Coal.class, true),
    CARBON_DIOXIDE(26, Material.GLASS_BOTTLE, CarbonDioxide.class, false),
    ACETONE(27, Material.GLASS_BOTTLE, Acetone.class, false),
    APPLE(28, Material.APPLE, Apple.class, true),
    ORGANIC_WASTE(29, Material.ROTTEN_FLESH, OrganicWaste.class, true),
    CHLORINE(30, Material.GLASS_BOTTLE, Chlorine.class, false),
    CHLOROACETONE(32, Material.GLASS_BOTTLE, Chloroacetone.class, false),
    POTASSIUM_CHLORIDE(33, Material.SUGAR, PotassiumChloride.class, false),
    POTASSIUM_CHLORATE(34, Material.SUGAR, PotassiumChlorate.class, false),
    POTASSIUM_HYDROXIDE(35, Material.GLASS_BOTTLE, PotassiumHydroxide.class, false),
    POTASSIUM_HYDROXIDE_SOLUTION(36, Material.GLASS_BOTTLE, PotassiumHydroxideSolution.class, false),
    PRIMER_POWDER(37, Material.SUGAR, PrimerPowder.class, false),
    HYDROGEN_PEROXIDE(38, Material.GLASS_BOTTLE, HydrogenPeroxide.class, false),
    ACETONE_PEROXIDE(39, Material.SUGAR, AcetonePeroxide.class, false),
    SUGAR_CANE(40, Material.SUGAR_CANE, SugarCane.class, true),
    EMPTY_BUCKET(41, Material.BUCKET, EmptyBucket.class, true),
    SULFUR_DIOXIDE(42, Material.GLASS_BOTTLE, SulfurDioxide.class, false),
    SULFUR_TRIOXIDE(43, Material.GLASS_BOTTLE, SulfurTrioxide.class, false),
    SODIUM_HYDROXIDE(44, Material.SUGAR, SodiumHydroxide.class, false),
    SODIUM_HYDROXIDE_SOLUTION(45, Material.GLASS_BOTTLE, SodiumHydroxideSolution.class, false),
    SODIUM_ACETATE(46, Material.SUGAR, SodiumAcetate.class, false),
    SODIUM_CARBONATE(47, Material.SUGAR, SodiumCarbonate.class, false),
    METHANE(48, Material.GLASS_BOTTLE, Methane.class, false),
    CHLOROFORM(49, Material.GLASS_BOTTLE, Chloroform.class, false),
    CHLORINATED_HYDROCARBONS(50, Material.GLASS_BOTTLE, ChlorinatedHydrocarbons.class, false),
    WASTE(51, Material.SUGAR, Waste.class, false),
    HYDROCHLORIC_ACID(52, Material.GLASS_BOTTLE, HydrochloricAcid.class, false);


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
