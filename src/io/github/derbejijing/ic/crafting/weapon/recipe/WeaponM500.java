package io.github.derbejijing.ic.crafting.weapon.recipe;


import org.bukkit.Material;

import io.github.derbejijing.ic.crafting.weapon.Weapon;
import io.github.derbejijing.ic.crafting.weapon.WeaponRecipe;

public class WeaponM500 extends WeaponRecipe {

    public WeaponM500(boolean mag) {
        super(120, 500, mag);
    }

    @Override
    public void add_ingredients() {
        this.add_ingredient(Material.OAK_PLANKS, 2);
        this.add_ingredient(Material.OAK_TRAPDOOR, 1);
        this.add_ingredient(Material.IRON_INGOT, 5);
    }

    @Override
    public void set_output() {
        this.set_output(Weapon.M500);
    }
    
}

