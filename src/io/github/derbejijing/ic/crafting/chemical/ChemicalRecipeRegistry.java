package io.github.derbejijing.ic.crafting.chemical;

import io.github.derbejijing.ic.crafting.chemical.recipe.AceticAcid;
import io.github.derbejijing.ic.crafting.chemical.recipe.AcetoneDistillation;
import io.github.derbejijing.ic.crafting.chemical.recipe.AlcoholDistillation;
import io.github.derbejijing.ic.crafting.chemical.recipe.BurnCoal;
import io.github.derbejijing.ic.crafting.chemical.recipe.CrushNetherrack;
import io.github.derbejijing.ic.crafting.chemical.recipe.CrushStone;
import io.github.derbejijing.ic.crafting.chemical.recipe.GunPowder;
import io.github.derbejijing.ic.crafting.chemical.recipe.Salt;
import io.github.derbejijing.ic.crafting.chemical.recipe.SeparateNetherrack;
import io.github.derbejijing.ic.crafting.chemical.recipe.WaterDecomposition;

public enum ChemicalRecipeRegistry {
    GUNPOWDER(0, GunPowder.class),
    WATER_DECOMPOSITION(1, WaterDecomposition.class),
    SALT(2, Salt.class),
    CRUSH_NETHERRACK(3, CrushNetherrack.class),
    CRUSH_STONE(4, CrushStone.class),
    SEPARATE_NETHERRACK(5, SeparateNetherrack.class),
    BURN_COAL(6, BurnCoal.class),
    ALCOHOL_DISTILLATION(7, AlcoholDistillation.class),
    ACETIC_ACID(8, AceticAcid.class),
    ACETONE_DISTILLATION(9, AcetoneDistillation.class);

    public final int id;
    public final Class<? extends ChemicalRecipe> recipe_class;

    private ChemicalRecipeRegistry(int id, Class<? extends ChemicalRecipe> recipe_class) {
        this.id = id;
        this.recipe_class = recipe_class;
    }


    public static ChemicalRecipe get_by_id(int id) {
        try {
            for(ChemicalRecipeRegistry crr : ChemicalRecipeRegistry.values()) if(crr.id == id) return crr.recipe_class.getConstructor().newInstance();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
    public static Class<? extends ChemicalRecipe> get_class_by_id(int id) {
        for(ChemicalRecipeRegistry crr : ChemicalRecipeRegistry.values()) if(crr.id == id) return crr.recipe_class;
        return null;
    }
}
