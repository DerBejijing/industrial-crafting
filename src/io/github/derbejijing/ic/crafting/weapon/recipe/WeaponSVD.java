package io.github.derbejijing.ic.crafting.weapon.recipe;


import org.bukkit.Material;

import io.github.derbejijing.ic.crafting.weapon.Weapon;
import io.github.derbejijing.ic.crafting.weapon.WeaponRecipe;

public class WeaponSVD extends WeaponRecipe {

    public WeaponSVD() {
        super(10, 500);
    }

    @Override
    public void add_ingredients() {
        this.add_ingredient(Material.OAK_PLANKS, 1);
        this.add_ingredient(Material.STICK, 2);
        this.add_ingredient(Material.IRON_INGOT, 10);
        this.add_ingredient(Material.LEVER, 1);
    }

    @Override
    public void set_output() {
        this.set_output(Weapon.SVD);
    }
    
}

