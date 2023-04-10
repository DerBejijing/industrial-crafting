package io.github.derbejijing.ic.machines.multiblock;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.crafting.weapon.WeaponRecipeRegistry;
import io.github.derbejijing.ic.machines.MultiblockMachine;
import io.github.derbejijing.ic.machines.component.BlastFurnace;
import io.github.derbejijing.ic.machines.component.CasingGlassTinted;
import io.github.derbejijing.ic.machines.component.CasingStone;
import io.github.derbejijing.ic.machines.component.CraftCenter;
import io.github.derbejijing.ic.machines.component.Generator;
import io.github.derbejijing.ic.machines.component.Hopper;
import io.github.derbejijing.ic.machines.component.InputHatch;
import io.github.derbejijing.ic.machines.component.Interface;
import io.github.derbejijing.ic.machines.component.OutputHatch;

public class WeaponAssembly extends MultiblockMachine {

    public WeaponAssembly(Location base_location, int orientation) {
        super(base_location, orientation, false);
    }

    @Override
    protected void add_components() {
        this.add_component(new CasingStone(this, new Vector(0, 0, 0)));
        this.add_component(new Interface(this, new Vector(1, 0, 0), false));
        this.add_component(new CasingStone(this, new Vector(2, 0, 0)));
        this.add_component(new CasingStone(this, new Vector(3, 0, 0)));
        this.add_component(new CasingStone(this, new Vector(4, 0, 0)));
        this.add_component(new OutputHatch(this, new Vector(0, 0, 1)));
        this.add_component(new Hopper(this, new Vector(1, 0, 1)));
        this.add_component(new CasingStone(this, new Vector(2, 0, 1)));
        this.add_component(new CasingStone(this, new Vector(3, 0, 1)));
        this.add_component(new InputHatch(this, new Vector(4, 0, 1)));
        this.add_component(new CasingStone(this, new Vector(0, 0, 2)));
        this.add_component(new CasingStone(this, new Vector(1, 0, 2)));
        this.add_component(new Generator(this, new Vector(2, 0, 2)));
        this.add_component(new CasingStone(this, new Vector(3, 0, 2)));
        this.add_component(new CasingStone(this, new Vector(4, 0, 2)));

        this.add_component(new CasingStone(this, new Vector(0, 1, 0)));
        this.add_component(new CasingGlassTinted(this, new Vector(1, 1, 0)));
        this.add_component(new CasingStone(this, new Vector(2, 1, 0)));
        this.add_component(new BlastFurnace(this, new Vector(3, 1, 0)));
        this.add_component(new CasingStone(this, new Vector(4, 1, 0)));
        this.add_component(new CasingStone(this, new Vector(0, 1, 1)));
        this.add_component(new CraftCenter(this, new Vector(1, 1, 1)));
        this.add_component(new CasingStone(this, new Vector(2, 1, 1)));
        this.add_component(new CasingStone(this, new Vector(3, 1, 1)));
        this.add_component(new CasingStone(this, new Vector(4, 1, 1)));
        this.add_component(new CasingStone(this, new Vector(0, 1, 2)));
        this.add_component(new CasingStone(this, new Vector(1, 1, 2)));
        this.add_component(new CasingStone(this, new Vector(2, 1, 2)));
        this.add_component(new CasingStone(this, new Vector(3, 1, 2)));
        this.add_component(new CasingStone(this, new Vector(4, 1, 2)));

        this.add_component(new CasingStone(this, new Vector(0, 2, 0)));
        this.add_component(new CasingGlassTinted(this, new Vector(1, 2, 0)));
        this.add_component(new CasingStone(this, new Vector(2, 2, 0)));
        this.add_component(new BlastFurnace(this, new Vector(3, 2, 0)));
        this.add_component(new CasingStone(this, new Vector(4, 2, 0)));
        this.add_component(new CasingStone(this, new Vector(0, 2, 1)));
        this.add_component(new CasingStone(this, new Vector(2, 2, 1)));
        this.add_component(new CasingStone(this, new Vector(3, 2, 1)));
        this.add_component(new CasingStone(this, new Vector(4, 2, 1)));
        this.add_component(new CasingStone(this, new Vector(0, 2, 2)));
        this.add_component(new CasingStone(this, new Vector(1, 2, 2)));
        this.add_component(new CasingStone(this, new Vector(2, 2, 2)));
        this.add_component(new CasingStone(this, new Vector(3, 2, 2)));
        this.add_component(new CasingStone(this, new Vector(4, 2, 2)));

        this.add_component(new CasingStone(this, new Vector(0, 3, 0)));
        this.add_component(new CasingStone(this, new Vector(1, 3, 0)));
        this.add_component(new CasingStone(this, new Vector(2, 3, 0)));
        this.add_component(new CasingStone(this, new Vector(3, 3, 0)));
        this.add_component(new CasingStone(this, new Vector(4, 3, 0)));
        this.add_component(new CasingStone(this, new Vector(0, 3, 1)));
        this.add_component(new CasingStone(this, new Vector(1, 3, 1)));
        this.add_component(new CasingStone(this, new Vector(2, 3, 1)));
        this.add_component(new CasingStone(this, new Vector(3, 3, 1)));
        this.add_component(new CasingStone(this, new Vector(4, 3, 1)));
        this.add_component(new CasingStone(this, new Vector(0, 3, 2)));
        this.add_component(new CasingStone(this, new Vector(1, 3, 2)));
        this.add_component(new CasingStone(this, new Vector(2, 3, 2)));
        this.add_component(new CasingStone(this, new Vector(3, 3, 2)));
        this.add_component(new CasingStone(this, new Vector(4, 3, 2)));
    }

    @Override
    protected void add_recipes() {
        this.add_weapon(WeaponRecipeRegistry.M16A4);
        this.add_weapon(WeaponRecipeRegistry.AK_47);
        this.add_weapon(WeaponRecipeRegistry.FN_FAL);
        this.add_weapon(WeaponRecipeRegistry.AUG_A3);
        this.add_weapon(WeaponRecipeRegistry.M4A1);
        this.add_weapon(WeaponRecipeRegistry.G3A3);
        this.add_weapon(WeaponRecipeRegistry.FAMAS);
        this.add_weapon(WeaponRecipeRegistry.SCAR_H);
        this.add_weapon(WeaponRecipeRegistry.P1911);
        this.add_weapon(WeaponRecipeRegistry.M9);
        this.add_weapon(WeaponRecipeRegistry.DESERT_EAGLE);
        this.add_weapon(WeaponRecipeRegistry.PM);
        this.add_weapon(WeaponRecipeRegistry.GLOCK_17);
        this.add_weapon(WeaponRecipeRegistry.GLOCK_18);
        this.add_weapon(WeaponRecipeRegistry.MP5A3);
        this.add_weapon(WeaponRecipeRegistry.MAC10);
        this.add_weapon(WeaponRecipeRegistry.MP7A1);
        this.add_weapon(WeaponRecipeRegistry.PPSH);
        this.add_weapon(WeaponRecipeRegistry.STEN);
        this.add_weapon(WeaponRecipeRegistry.SPAS12);
        this.add_weapon(WeaponRecipeRegistry.M500);
        this.add_weapon(WeaponRecipeRegistry.M590);
        this.add_weapon(WeaponRecipeRegistry.SVD);
        this.add_weapon(WeaponRecipeRegistry.M82A1);
        this.add_weapon(WeaponRecipeRegistry.MOSIN);
        this.add_weapon(WeaponRecipeRegistry.M24A3);
        this.add_weapon(WeaponRecipeRegistry.RPG);
        this.add_weapon(WeaponRecipeRegistry.RPK);
        this.add_weapon(WeaponRecipeRegistry.M249);
    }

    @Override
    protected void on_tick() {
    }

    @Override
    protected void on_place() {
    }

    @Override
    protected void on_destroy() {
    }

    @Override
    protected void on_change_state() {
    }
    
}
