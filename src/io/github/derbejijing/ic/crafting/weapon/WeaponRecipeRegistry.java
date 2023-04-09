package io.github.derbejijing.ic.crafting.weapon;

import io.github.derbejijing.ic.crafting.weapon.recipe.WeaponAk47;

public enum WeaponRecipeRegistry {
    AK_47(0, "AK47", WeaponAk47.class);

    public final int id;
    public final String name;
    public final Class<? extends WeaponRecipe> recipe_class;

    private WeaponRecipeRegistry(int id, String name, Class<? extends WeaponRecipe> recipe_class) {
        this.id = id;
        this.name = name;
        this.recipe_class = recipe_class;
    }


    public static WeaponRecipe get_by_id(int id) {
        try {
            for(WeaponRecipeRegistry wrr : WeaponRecipeRegistry.values()) if(wrr.id == id) return wrr.recipe_class.getConstructor().newInstance();
        } catch(Exception e) {
        }
        return null;
    }


    public static WeaponRecipeRegistry get_type_by_id(int id) {
        try {
            for(WeaponRecipeRegistry wrr : WeaponRecipeRegistry.values()) if(wrr.id == id) return wrr;
        } catch(Exception e) {
        }
        return null;
    }


    public static String get_name(WeaponRecipe wr_lookup) {
        try {
            for(WeaponRecipeRegistry wrr : WeaponRecipeRegistry.values()) if(wrr.recipe_class.equals(wr_lookup.getClass())) return wrr.name;
        } catch(Exception e) {
        }
        return "None";
    }
}
