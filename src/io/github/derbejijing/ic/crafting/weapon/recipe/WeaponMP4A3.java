package io.github.derbejijing.ic.crafting.weapon.recipe;


import org.bukkit.Material;

import io.github.derbejijing.ic.crafting.weapon.Weapon;
import io.github.derbejijing.ic.crafting.weapon.WeaponRecipe;

public class WeaponMP4A3 extends WeaponRecipe {

    public WeaponMP4A3() {
        super(120, 400);
    }

    @Override
    public void add_ingredients() {
        this.add_ingredient(Material.IRON_INGOT, 4);
        this.add_ingredient(Material.IRON_BARS, 1);
        this.add_ingredient(Material.STICK, 1);
        this.add_ingredient(Material.REDSTONE_TORCH, 1);
    }

    @Override
    public void set_output() {
        this.set_output(Weapon.MP5A3);
    }
    
}

