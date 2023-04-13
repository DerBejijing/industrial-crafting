package io.github.derbejijing.ic.crafting.weapon.recipe;


import org.bukkit.Material;

import io.github.derbejijing.ic.crafting.weapon.Weapon;
import io.github.derbejijing.ic.crafting.weapon.WeaponRecipe;

public class WeaponM249 extends WeaponRecipe {

    public WeaponM249(boolean mag) {
        super(240, 800, mag);
    }

    @Override
    public void add_ingredients() {
        this.add_ingredient(Material.IRON_INGOT, 16);
        this.add_ingredient(Material.GREEN_DYE, 1);
        this.add_ingredient(Material.IRON_BARS, 2);
    }

    @Override
    public void set_output() {
        this.set_output(Weapon.M249);
    }
    
}

