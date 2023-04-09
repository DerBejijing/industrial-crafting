package io.github.derbejijing.ic.crafting.weapon.recipe;

import org.bukkit.Material;

import io.github.derbejijing.ic.crafting.weapon.Weapon;
import io.github.derbejijing.ic.crafting.weapon.WeaponRecipe;

public class WeaponAk47 extends WeaponRecipe {

    public WeaponAk47() {
        super(60, 1000);
    }

    @Override
    public void add_ingredients() {
        this.add_ingredient(Material.IRON_INGOT, 16);
        this.add_ingredient(Material.OAK_WOOD, 1);
    }

    @Override
    public void set_output() {
        this.set_output(Weapon.AK_74);
    }
    
}
