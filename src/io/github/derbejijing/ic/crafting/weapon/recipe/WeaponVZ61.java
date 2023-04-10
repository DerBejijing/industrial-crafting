package io.github.derbejijing.ic.crafting.weapon.recipe;


import org.bukkit.Material;

import io.github.derbejijing.ic.crafting.weapon.Weapon;
import io.github.derbejijing.ic.crafting.weapon.WeaponRecipe;

public class WeaponVZ61 extends WeaponRecipe {

    public WeaponVZ61() {
        super(120, 300);
    }

    @Override
    public void add_ingredients() {
        this.add_ingredient(Material.OAK_PLANKS, 1);
        this.add_ingredient(Material.IRON_INGOT, 3);
        this.add_ingredient(Material.REDSTONE_TORCH, 1);
        this.add_ingredient(Material.IRON_NUGGET, 1);
    }

    @Override
    public void set_output() {
        this.set_output(Weapon.VZ61);
    }
    
}
