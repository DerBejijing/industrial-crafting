package io.github.derbejijing.ic.crafting.weapon.recipe;


import org.bukkit.Material;

import io.github.derbejijing.ic.crafting.weapon.Weapon;
import io.github.derbejijing.ic.crafting.weapon.WeaponRecipe;

public class WeaponPPSH extends WeaponRecipe {

    public WeaponPPSH(boolean mag) {
        super(120, 400, mag);
    }

    @Override
    public void add_ingredients() {
        this.add_ingredient(Material.OAK_PLANKS, 1);
        this.add_ingredient(Material.STICK, 1);
        this.add_ingredient(Material.IRON_INGOT, 5);
        this.add_ingredient(Material.REDSTONE_TORCH, 1);
    }

    @Override
    public void set_output() {
        this.set_output(Weapon.PPSH);
    }
    
}

