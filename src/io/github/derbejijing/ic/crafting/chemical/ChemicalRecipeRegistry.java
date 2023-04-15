package io.github.derbejijing.ic.crafting.chemical;


import io.github.derbejijing.ic.crafting.chemical.recipe.AceticAcid;
import io.github.derbejijing.ic.crafting.chemical.recipe.AcetoneDistillation;
import io.github.derbejijing.ic.crafting.chemical.recipe.AcetonePeroxide;
import io.github.derbejijing.ic.crafting.chemical.recipe.AlcoholDistillation;
import io.github.derbejijing.ic.crafting.chemical.recipe.Booze;
import io.github.derbejijing.ic.crafting.chemical.recipe.BoozeSugarCane;
import io.github.derbejijing.ic.crafting.chemical.recipe.BurnCoal;
import io.github.derbejijing.ic.crafting.chemical.recipe.CalciumCarbonate;
import io.github.derbejijing.ic.crafting.chemical.recipe.ChlorinatedHydrocarbons;
import io.github.derbejijing.ic.crafting.chemical.recipe.Chloroacetone;
import io.github.derbejijing.ic.crafting.chemical.recipe.Chloroform;
import io.github.derbejijing.ic.crafting.chemical.recipe.CrushNetherrack;
import io.github.derbejijing.ic.crafting.chemical.recipe.CrushStone;
import io.github.derbejijing.ic.crafting.chemical.recipe.GunPowder;
import io.github.derbejijing.ic.crafting.chemical.recipe.HydrogenPeroxide;
import io.github.derbejijing.ic.crafting.chemical.recipe.HydrogenPeroxideCheap;
import io.github.derbejijing.ic.crafting.chemical.recipe.Methane;
import io.github.derbejijing.ic.crafting.chemical.recipe.PotassiumChlorate;
import io.github.derbejijing.ic.crafting.chemical.recipe.PotassiumHydroxide;
import io.github.derbejijing.ic.crafting.chemical.recipe.PotassiumHydroxideElectrolysis;
import io.github.derbejijing.ic.crafting.chemical.recipe.PotassiumHydroxideSolution;
import io.github.derbejijing.ic.crafting.chemical.recipe.PrimerPowder;
import io.github.derbejijing.ic.crafting.chemical.recipe.RecrystallizePhosphorous;
import io.github.derbejijing.ic.crafting.chemical.recipe.RecrystallizePotassiumChloride;
import io.github.derbejijing.ic.crafting.chemical.recipe.RecrystallizePotassiumNitrate;
import io.github.derbejijing.ic.crafting.chemical.recipe.RecrystallizeSodiumChloride;
import io.github.derbejijing.ic.crafting.chemical.recipe.RecrystallizeSulfur;
import io.github.derbejijing.ic.crafting.chemical.recipe.Salt;
import io.github.derbejijing.ic.crafting.chemical.recipe.SeparateNetherrack;
import io.github.derbejijing.ic.crafting.chemical.recipe.SeparateStone;
import io.github.derbejijing.ic.crafting.chemical.recipe.SodiumAcetate;
import io.github.derbejijing.ic.crafting.chemical.recipe.SodiumHydroxide;
import io.github.derbejijing.ic.crafting.chemical.recipe.SodiumHydroxideSolution;
import io.github.derbejijing.ic.crafting.chemical.recipe.SodiumHydroxideSolutionElectrolysis;
import io.github.derbejijing.ic.crafting.chemical.recipe.SulfurDioxide;
import io.github.derbejijing.ic.crafting.chemical.recipe.SulfurTrioxide;
import io.github.derbejijing.ic.crafting.chemical.recipe.SulfuricAcid;
import io.github.derbejijing.ic.crafting.chemical.recipe.WaterDecomposition;
import io.github.derbejijing.ic.crafting.chemical.recipe.WaterDecompositionCheap;
import io.github.derbejijing.ic.machines.MultiblockMachine;

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
    POTASSIUM_HYDROXIDE_ELECTROLYSIS(16, PotassiumHydroxideElectrolysis.class, "Potassium hydroxide electrolysis"),
    PRIMER_POWDER(17, PrimerPowder.class, "Primer powder"),
    HYDROGEN_PEROXIDE(18, HydrogenPeroxide.class, "Hydrogen peroxide"),
    HYDROGEN_PEROXIDE_CHEAP(19, HydrogenPeroxideCheap.class, "Hydrogen peroxide (cheap)"),
    WATER_DECOMPOSITION_CHEAP(20, WaterDecompositionCheap.class, "Water electrolysis (cheap)"),
    ACETONE_PEROXIDE(21, AcetonePeroxide.class, "Acetone peroxide"),
    BOOZE_SUGAR_CANE(22, BoozeSugarCane.class, "Sugar cane liquor (rum)"),
    SULFUR_DIOXIDE(23, SulfurDioxide.class, "Sulfur dioxide"),
    SULFUR_TRIOXIDE(24, SulfurTrioxide.class, "Sulfur trioxide"),
    SULFURIC_ACID(25, SulfuricAcid.class, "Sulfuric Acid"),
    SODIUM_ACETATE(26, SodiumAcetate.class, "Sodium Acetate"),
    SODIUM_HYDROXIDE(27, SodiumHydroxide.class, "Sodium hydroxide drying"),
    SODIUM_HYDROXIDE_SOLUTION(28, SodiumHydroxideSolution.class, "Sodium hydroxide solution"),
    SODIUM_HYDROXIDE_SOLUTION_ELECTROLYSIS(29, SodiumHydroxideSolutionElectrolysis.class, "Sodium hydroxide electrolysis"),
    METHANE(30, Methane.class, "Methane"),
    CHLORINATED_HYDROCARBONS(31, ChlorinatedHydrocarbons.class, "Chlorinated Hydrocarbons"),
    CHLOROFORM(32, Chloroform.class, "Chloroform"),
    RECRYSTALLIZE_PHOSPHOROUS(33, RecrystallizePhosphorous.class, "Recrystallize phosphorous"),
    RECRYSTALLIZE_POTASSIUM_CHLORIDE(34, RecrystallizePotassiumChloride.class, "Recrystallize potassium chloride"),
    RECRYSTALLIZE_POTASSIUM_NITRATE(35, RecrystallizePotassiumNitrate.class, "Recrystallize potassium nitrate"),
    RECRYSTALLIZE_SODIUM_CHLORIDE(36, RecrystallizeSodiumChloride.class, "Recrystallize sodium chloride"),
    RECRYSTALLIZE_SULFUR(37, RecrystallizeSulfur.class, "Recrystallize sulfur"),
    POTASSIUM_CHLORATE(38, PotassiumChlorate.class, "Potassium chlorate"),
    NONE(-1, null, "None");

    public final int id;
    public final Class<? extends ChemicalRecipe> recipe_class;
    public final String name;

    private ChemicalRecipeRegistry(int id, Class<? extends ChemicalRecipe> recipe_class, String name) {
        this.id = id;
        this.recipe_class = recipe_class;
        this.name = name;
    }


    public static ChemicalRecipe get_by_id(MultiblockMachine master, int id) {
        try {
            for(ChemicalRecipeRegistry crr : ChemicalRecipeRegistry.values()) if(crr.id == id) return crr.recipe_class.getConstructor(MultiblockMachine.class).newInstance(master);
        } catch(Exception e) {
        }
        return null;
    }


    public static ChemicalRecipeRegistry get_by_string(String name) {
        try {
            for(ChemicalRecipeRegistry crr : ChemicalRecipeRegistry.values()) if(crr.name.equals(name)) return crr;
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
