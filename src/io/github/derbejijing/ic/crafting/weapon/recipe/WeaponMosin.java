package io.github.derbejijing.ic.crafting.weapon.recipe;


import org.bukkit.Material;

import io.github.derbejijing.ic.crafting.weapon.Weapon;
import io.github.derbejijing.ic.crafting.weapon.WeaponRecipe;

public class WeaponMosin extends WeaponRecipe {

    public WeaponMosin() {
        super(240, 800);
    }

    @Override
    public void add_ingredients() {
        this.add_ingredient(Material.OAK_PLANKS, 5);
        this.add_ingredient(Material.IRON_INGOT, 6);
        this.add_ingredient(Material.LEVER, 1);
        this.add_ingredient(Material.STICK, 1);
    }

    @Override
    public void set_output() {
        this.set_output(Weapon.MOSIN);
    }
    
}

