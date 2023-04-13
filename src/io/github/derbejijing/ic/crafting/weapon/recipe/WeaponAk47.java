package io.github.derbejijing.ic.crafting.weapon.recipe;


import org.bukkit.Material;

import io.github.derbejijing.ic.crafting.weapon.Weapon;
import io.github.derbejijing.ic.crafting.weapon.WeaponRecipe;

public class WeaponAk47 extends WeaponRecipe {

    public WeaponAk47(boolean mag) {
        super(120, 500, mag);
    }

    @Override
    public void add_ingredients() {
        this.add_ingredient(Material.OAK_PLANKS, 2);
        this.add_ingredient(Material.IRON_INGOT, 5);
        this.add_ingredient(Material.REDSTONE_TORCH, 1);
    }

    @Override
    public void set_output() {
        this.set_output(Weapon.AK_47);
    }
    
}
