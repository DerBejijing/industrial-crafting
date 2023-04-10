package io.github.derbejijing.ic.crafting.weapon;

import io.github.derbejijing.ic.crafting.weapon.recipe.Weapon1911;
import io.github.derbejijing.ic.crafting.weapon.recipe.WeaponAk47;
import io.github.derbejijing.ic.crafting.weapon.recipe.WeaponAugA3;
import io.github.derbejijing.ic.crafting.weapon.recipe.WeaponDesertEagle;
import io.github.derbejijing.ic.crafting.weapon.recipe.WeaponFamas;
import io.github.derbejijing.ic.crafting.weapon.recipe.WeaponFnFal;
import io.github.derbejijing.ic.crafting.weapon.recipe.WeaponG3A3;
import io.github.derbejijing.ic.crafting.weapon.recipe.WeaponGlock17;
import io.github.derbejijing.ic.crafting.weapon.recipe.WeaponGlock18;
import io.github.derbejijing.ic.crafting.weapon.recipe.WeaponM16A4;
import io.github.derbejijing.ic.crafting.weapon.recipe.WeaponM4A1;
import io.github.derbejijing.ic.crafting.weapon.recipe.WeaponM9;
import io.github.derbejijing.ic.crafting.weapon.recipe.WeaponPM;
import io.github.derbejijing.ic.crafting.weapon.recipe.WeaponScarH;

public enum WeaponRecipeRegistry {
    M16A4(0, "M16A4", WeaponM16A4.class),
    AK_47(1, "AK47", WeaponAk47.class),
    FN_FAL(2, "FnFal", WeaponFnFal.class),
    AUG_A3(3, "AUG A3", WeaponAugA3.class),
    M4A1(4, "M4A1", WeaponM4A1.class),
    G3A3(5, "G3A3", WeaponG3A3.class),
    FAMAS(6, "Famas", WeaponFamas.class),
    SCAR_H(7, "Scar H", WeaponScarH.class),
    P1911(8, "1911", Weapon1911.class),
    DESERT_EAGLE(9, "Desert Eagle", WeaponDesertEagle.class),
    GLOCK_17(10, "Glock 17", WeaponGlock17.class),
    GLOCK_18(11, "Glock 18", WeaponGlock18.class),
    M9(12, "M9", WeaponM9.class),
    PM(13, "PM", WeaponPM.class);

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
