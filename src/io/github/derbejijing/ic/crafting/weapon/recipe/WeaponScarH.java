package io.github.derbejijing.ic.crafting.weapon.recipe;


import org.bukkit.Material;

import io.github.derbejijing.ic.crafting.weapon.Weapon;
import io.github.derbejijing.ic.crafting.weapon.WeaponRecipe;

public class WeaponScarH extends WeaponRecipe {

    public WeaponScarH() {
        super(10, 500);
    }

    @Override
    public void add_ingredients() {
        this.add_ingredient(Material.IRON_INGOT, 8);
        this.add_ingredient(Material.REDSTONE_TORCH, 1);
        this.add_ingredient(Material.REDSTONE_TORCH, 1);
    }

    @Override
    public void set_output() {
        this.set_output(Weapon.SCAR_H);
    }
    
}
