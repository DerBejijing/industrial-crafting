package io.github.derbejijing.ic.crafting.chemical;


import io.github.derbejijing.ic.crafting.chemical.recipe.AceticAcid;
import io.github.derbejijing.ic.crafting.chemical.recipe.AcetoneDistillation;
import io.github.derbejijing.ic.crafting.chemical.recipe.AlcoholDistillation;
import io.github.derbejijing.ic.crafting.chemical.recipe.Booze;
import io.github.derbejijing.ic.crafting.chemical.recipe.BurnCoal;
import io.github.derbejijing.ic.crafting.chemical.recipe.CalciumCarbonate;
import io.github.derbejijing.ic.crafting.chemical.recipe.Chloroacetone;
import io.github.derbejijing.ic.crafting.chemical.recipe.CrushNetherrack;
import io.github.derbejijing.ic.crafting.chemical.recipe.CrushStone;
import io.github.derbejijing.ic.crafting.chemical.recipe.GunPowder;
import io.github.derbejijing.ic.crafting.chemical.recipe.PotassiumHydroxide;
import io.github.derbejijing.ic.crafting.chemical.recipe.PotassiumHydroxideElectrolysis;
import io.github.derbejijing.ic.crafting.chemical.recipe.PotassiumHydroxideSolution;
import io.github.derbejijing.ic.crafting.chemical.recipe.Salt;
import io.github.derbejijing.ic.crafting.chemical.recipe.SeparateNetherrack;
import io.github.derbejijing.ic.crafting.chemical.recipe.SeparateStone;
import io.github.derbejijing.ic.crafting.chemical.recipe.WaterDecomposition;

public enum ChemicalRecipeRegistry {
    GUNPOWDER(0, GunPowder.class, "Gunpowder"),
    WATER_DECOMPOSITION(1, WaterDecomposition.class, "Water electrolysis"),
    SALT(2, Salt.class, "Salt drying"),
    CRUSH_NETHERRACK(3, CrushNetherrack.class, "Netherrack crushing"),
    CRUSH_STONE(4, CrushStone.class, "Stone crushing"),
    SEPARATE_NETHERRACK(5, SeparateNetherrack.class, "Netherrack separation"),
    BURN_COAL(6, BurnCoal.class, "Burning coal"),
    ALCOHOL_DISTILLATION(7, AlcoholDistillation.class, "Alcohol distillation"),
    ACETIC_ACID(8, AceticAcid.class, "Acetic acid"),
    ACETONE_DISTILLATION(9, AcetoneDistillation.class, "Acetone distillation"),
    CALCIUM_CARBONATE(10, CalciumCarbonate.class, "Calcium carbonate crushing"),
    BOOZE(11, Booze.class, "Booze"),
    CHLOROACETONE(12, Chloroacetone.class, "Chloroacetone"),
    SEPARATE_STONE(13, SeparateStone.class, "Stone separation"),
    POTASSIUM_HYDROXIDE(14, PotassiumHydroxide.class, "Potassium hydroxide drying"),
    POTASSIUM_HYDROXIDE_SOLUTION(15, PotassiumHydroxideSolution.class, "Potassium hydroxide solution"),
    POTASSIUM_HYDROXIDE_ELECTROLYSIS(16, PotassiumHydroxideElectrolysis.class, "Potassium hydroxide solution"),
    NONE(-1, null, "None");

    public final int id;
    public final Class<? extends ChemicalRecipe> recipe_class;
    public final String name;

    private ChemicalRecipeRegistry(int id, Class<? extends ChemicalRecipe> recipe_class, String name) {
        this.id = id;
        this.recipe_class = recipe_class;
        this.name = name;
    }


    public static ChemicalRecipe get_by_id(int id) {
        try {
            for(ChemicalRecipeRegistry crr : ChemicalRecipeRegistry.values()) if(crr.id == id) return crr.recipe_class.getConstructor().newInstance();
        } catch(Exception e) {
        }
        return null;
    }


    public static ChemicalRecipeRegistry get_type_by_id(int id) {
        try {
            for(ChemicalRecipeRegistry crr : ChemicalRecipeRegistry.values()) if(crr.id == id) return crr;
        } catch(Exception e) {
        }
        return null;
    }


    public static Class<? extends ChemicalRecipe> get_class_by_id(int id) {
        for(ChemicalRecipeRegistry crr : ChemicalRecipeRegistry.values()) if(crr.id == id) return crr.recipe_class;
        return null;
    }


    public static String get_name(ChemicalRecipe cr_lookup) {
        try {
            for(ChemicalRecipeRegistry crr : ChemicalRecipeRegistry.values()) if(crr.recipe_class.equals(cr_lookup.getClass())) return crr.name;
        } catch(Exception e) {
        }
        return "None";
    }
}
