package io.github.derbejijing.ic.crafting.weapon.recipe;


import io.github.derbejijing.ic.crafting.weapon.Weapon;
import io.github.derbejijing.ic.crafting.weapon.WeaponRecipe;

public class WeaponM9 extends WeaponRecipe {

    public WeaponM9() {
        super(10, 500);
    }

    @Override
    public void add_ingredients() {
    }

    @Override
    public void set_output() {
        this.set_output(Weapon.M9);
    }
    
}