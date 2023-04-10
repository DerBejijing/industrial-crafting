package io.github.derbejijing.ic.crafting.weapon.recipe;


import io.github.derbejijing.ic.crafting.weapon.Weapon;
import io.github.derbejijing.ic.crafting.weapon.WeaponRecipe;

public class WeaponFnFal extends WeaponRecipe {

    public WeaponFnFal() {
        super(10, 500);
    }

    @Override
    public void add_ingredients() {
    }

    @Override
    public void set_output() {
        this.set_output(Weapon.FN_FAL);
    }
    
}
