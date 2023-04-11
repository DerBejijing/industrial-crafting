package io.github.derbejijing.ic.crafting.weapon.recipe;

import org.bukkit.Material;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.crafting.weapon.Weapon;
import io.github.derbejijing.ic.crafting.weapon.WeaponRecipe;

public class Magazine extends WeaponRecipe {

    private Weapon weapon;

    public Magazine(Weapon weapon) {
        super(1, 100);
        this.weapon = weapon;
    }

    @Override
    public void add_ingredients() {
        this.add_ingredient(Material.IRON_INGOT, 1);
        this.add_ingredient(ChemicalItem.GUNPOWDER.material, ChemicalItem.GUNPOWDER.id, this.weapon.mag_size);
        this.add_ingredient(ChemicalItem.PRIMER_POWDER.material, ChemicalItem.PRIMER_POWDER.id, this.weapon.mag_size);
    }

    @Override
    public void set_output() {
        this.set_output(this.weapon, true);
    }
}
