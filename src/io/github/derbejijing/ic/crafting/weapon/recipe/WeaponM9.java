package io.github.derbejijing.ic.crafting.weapon.recipe;


import org.bukkit.Material;

import io.github.derbejijing.ic.crafting.weapon.Weapon;
import io.github.derbejijing.ic.crafting.weapon.WeaponRecipe;

public class WeaponM9 extends WeaponRecipe {

    public WeaponM9() {
        super(10, 500);
    }

    @Override
    public void add_ingredients() {
        this.add_ingredient(Material.IRON_INGOT, 3);
        this.add_ingredient(Material.IRON_NUGGET, 1);
        this.add_ingredient(Material.STONE_BUTTON, 1);
    }

    @Override
    public void set_output() {
        this.set_output(Weapon.M9);
    }
    
}
