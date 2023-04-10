package io.github.derbejijing.ic.crafting.weapon.recipe;


import org.bukkit.Material;

import io.github.derbejijing.ic.crafting.weapon.Weapon;
import io.github.derbejijing.ic.crafting.weapon.WeaponRecipe;

public class WeaponSPAS12 extends WeaponRecipe {

    public WeaponSPAS12() {
        super(120, 500);
    }

    @Override
    public void add_ingredients() {
        this.add_ingredient(Material.IRON_INGOT, 5);
        this.add_ingredient(Material.OAK_TRAPDOOR, 1);
        this.add_ingredient(Material.IRON_BARS, 1);
    }

    @Override
    public void set_output() {
        this.set_output(Weapon.SPAS12);
    }
    
}

