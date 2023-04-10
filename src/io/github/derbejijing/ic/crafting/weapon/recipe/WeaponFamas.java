package io.github.derbejijing.ic.crafting.weapon.recipe;


import org.bukkit.Material;

import io.github.derbejijing.ic.crafting.weapon.Weapon;
import io.github.derbejijing.ic.crafting.weapon.WeaponRecipe;

public class WeaponFamas extends WeaponRecipe {

    public WeaponFamas() {
        super(120, 500);
    }

    @Override
    public void add_ingredients() {
        this.add_ingredient(Material.IRON_INGOT, 7);
        this.add_ingredient(Material.REDSTONE_TORCH, 1);
        this.add_ingredient(Material.IRON_BARS, 2);
    }

    @Override
    public void set_output() {
        this.set_output(Weapon.FAMAS);
    }
    
}
