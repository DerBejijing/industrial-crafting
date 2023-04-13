package io.github.derbejijing.ic.crafting.weapon.recipe;


import org.bukkit.Material;

import io.github.derbejijing.ic.crafting.weapon.Weapon;
import io.github.derbejijing.ic.crafting.weapon.WeaponRecipe;

public class WeaponDesertEagle extends WeaponRecipe {

    public WeaponDesertEagle(boolean mag) {
        super(120, 300, mag);
    }

    @Override
    public void add_ingredients() {
        this.add_ingredient(Material.IRON_INGOT, 4);
        this.add_ingredient(Material.IRON_INGOT, 1);
        this.add_ingredient(Material.STONE_BUTTON, 1);
    }

    @Override
    public void set_output() {
        this.set_output(Weapon.DESERT_EAGLE);
    }
    
}
