package io.github.derbejijing.ic.crafting.chemical.recipe;

import org.bukkit.entity.Trident;

import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.crafting.chemical.ChemicalComponent;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;

public class GunPowder extends ChemicalRecipe {

    public GunPowder() {
        super(new ChemicalComponent(ChemicalItem.GUNPOWDER, 8, false), 1);
    }


    @Override
    public void add_components() {
        this.add_ingredient(new ChemicalComponent(ChemicalItem.CARBON, 1, true));
        this.add_ingredient(new ChemicalComponent(ChemicalItem.SULFUR, 1, true));
        this.add_ingredient(new ChemicalComponent(ChemicalItem.POTASSIUM_NITRATE, 6, true));
    }
    
}
