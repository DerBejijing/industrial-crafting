package io.github.derbejijing.ic.crafting.weapon.recipe;


import org.bukkit.Material;

import io.github.derbejijing.ic.crafting.weapon.Weapon;
import io.github.derbejijing.ic.crafting.weapon.WeaponRecipe;

public class WeaponRPG extends WeaponRecipe {

    public WeaponRPG() {
        super(240, 800);
    }

    @Override
    public void add_ingredients() {
        this.add_ingredient(Material.OAK_PLANKS, 3);
        this.add_ingredient(Material.IRON_INGOT, 10);
        this.add_ingredient(Material.STICK, 2);
        this.add_ingredient(Material.LEVER, 1);
    }

    @Override
    public void set_output() {
        this.set_output(Weapon.RPG);
    }
    
}

