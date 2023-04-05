package io.github.derbejijing.ic.crafting.chemical;

import io.github.derbejijing.ic.crafting.chemical.recipe.GunPowder;

public enum ChemicalRecipeRegistry {
    GUNPOWDER(0, GunPowder.class);

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
