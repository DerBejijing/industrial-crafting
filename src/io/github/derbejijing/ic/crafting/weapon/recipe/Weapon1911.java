package io.github.derbejijing.ic.crafting.weapon.recipe;


import org.bukkit.Material;

import io.github.derbejijing.ic.crafting.weapon.Weapon;
import io.github.derbejijing.ic.crafting.weapon.WeaponRecipe;

public class Weapon1911 extends WeaponRecipe {

    public Weapon1911() {
        super(120, 300);
    }

    @Override
    public void add_ingredients() {
        this.add_ingredient(Material.OAK_PLANKS, 1);
        this.add_ingredient(Material.IRON_INGOT, 3);
        this.add_ingredient(Material.STONE_BUTTON, 1);
    }

    @Override
    public void set_output() {
        this.set_output(Weapon.P1911);
    }
    
}
