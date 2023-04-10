package io.github.derbejijing.ic.machines.multiblock;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.machines.MultiblockMachine;
import io.github.derbejijing.ic.machines.MultiblockState;
import io.github.derbejijing.ic.machines.component.CasingGlassTinted;
import io.github.derbejijing.ic.machines.component.CasingStone;
import io.github.derbejijing.ic.machines.component.Dropper;
import io.github.derbejijing.ic.machines.component.Generator;
import io.github.derbejijing.ic.machines.component.InputHatch;
import io.github.derbejijing.ic.machines.component.Interface;
import io.github.derbejijing.ic.machines.component.OutputHatch;
import io.github.derbejijing.ic.machines.component.Water;

public class ChemicalRefinery extends MultiblockMachine {

    private int energy_required = 5;

    public ChemicalRefinery(Location base_location, int orientation) {
        super(base_location, orientation, true);
    }

    @Override
    protected void add_components() {
        this.add_component(new CasingStone(this, new Vector(0, 0, 0)));
        this.add_component(new CasingStone(this, new Vector(1, 0, 0)));
        this.add_component(new CasingStone(this, new Vector(2, 0, 0)));
        this.add_component(new Interface(this, new Vector(3, 0, 0), false));
        this.add_component(new CasingStone(this, new Vector(4, 0, 0)));
        this.add_component(new CasingStone(this, new Vector(5, 0, 0)));
        this.add_component(new CasingStone(this, new Vector(6, 0, 0)));

        this.add_component(new OutputHatch(this, new Vector(0, 0, 1)));
        this.add_component(new CasingStone(this, new Vector(1, 0, 1)));
        this.add_component(new CasingStone(this, new Vector(2, 0, 1)));
        this.add_component(new CasingStone(this, new Vector(3, 0, 1)));
        this.add_component(new CasingStone(this, new Vector(4, 0, 1)));
        this.add_component(new CasingStone(this, new Vector(5, 0, 1)));
        this.add_component(new InputHatch(this, new Vector(6, 0, 1)));

        this.add_component(new CasingStone(this, new Vector(0, 0, 2)));
        this.add_component(new CasingStone(this, new Vector(1, 0, 2)));
        this.add_component(new CasingStone(this, new Vector(2, 0, 2)));
        this.add_component(new Generator(this, new Vector(3, 0, 2)));
        this.add_component(new CasingStone(this, new Vector(4, 0, 2)));
        this.add_component(new CasingStone(this, new Vector(5, 0, 2)));
        this.add_component(new CasingStone(this, new Vector(6, 0, 2)));


        this.add_component(new CasingStone(this, new Vector(0, 1, 0)));
        this.add_component(new CasingStone(this, new Vector(1, 1, 0)));
        this.add_component(new CasingGlassTinted(this, new Vector(2, 1, 0)));
        this.add_component(new CasingGlassTinted(this, new Vector(3, 1, 0)));
        this.add_component(new CasingGlassTinted(this, new Vector(4, 1, 0)));
        this.add_component(new CasingStone(this, new Vector(5, 1, 0)));
        this.add_component(new CasingStone(this, new Vector(6, 1, 0)));

        this.add_component(new CasingStone(this, new Vector(0, 1, 1)));
        this.add_component(new Dropper(this, new Vector(1, 1, 1)));
        this.add_component(new Water(this, new Vector(2, 1, 1)));
        this.add_component(new Water(this, new Vector(3, 1, 1)));
        this.add_component(new Water(this, new Vector(4, 1, 1)));
        this.add_component(new Dropper(this, new Vector(5, 1, 1)));
        this.add_component(new CasingStone(this, new Vector(6, 1, 1)));

        this.add_component(new CasingStone(this, new Vector(0, 1, 2)));
        this.add_component(new CasingStone(this, new Vector(1, 1, 2)));
        this.add_component(new CasingStone(this, new Vector(2, 1, 2)));
        this.add_component(new CasingStone(this, new Vector(3, 1, 2)));
        this.add_component(new CasingStone(this, new Vector(4, 1, 2)));
        this.add_component(new CasingStone(this, new Vector(5, 1, 2)));
        this.add_component(new CasingStone(this, new Vector(6, 1, 2)));


        this.add_component(new CasingStone(this, new Vector(0, 2, 0)));
        this.add_component(new CasingStone(this, new Vector(1, 2, 0)));
        this.add_component(new CasingStone(this, new Vector(2, 2, 0)));
        this.add_component(new CasingStone(this, new Vector(3, 2, 0)));
        this.add_component(new CasingStone(this, new Vector(4, 2, 0)));
        this.add_component(new CasingStone(this, new Vector(5, 2, 0)));
        this.add_component(new CasingStone(this, new Vector(6, 2, 0)));

        this.add_component(new CasingStone(this, new Vector(0, 2, 1)));
        this.add_component(new CasingStone(this, new Vector(1, 2, 1)));
        this.add_component(new CasingStone(this, new Vector(2, 2, 1)));
        this.add_component(new CasingStone(this, new Vector(3, 2, 1)));
        this.add_component(new CasingStone(this, new Vector(4, 2, 1)));
        this.add_component(new CasingStone(this, new Vector(5, 2, 1)));
        this.add_component(new CasingStone(this, new Vector(6, 2, 1)));

        this.add_component(new CasingStone(this, new Vector(0, 2, 2)));
        this.add_component(new CasingStone(this, new Vector(1, 2, 2)));
        this.add_component(new CasingStone(this, new Vector(2, 2, 2)));
        this.add_component(new CasingStone(this, new Vector(3, 2, 2)));
        this.add_component(new CasingStone(this, new Vector(4, 2, 2)));
        this.add_component(new CasingStone(this, new Vector(5, 2, 2)));
        this.add_component(new CasingStone(this, new Vector(6, 2, 2)));
    }

    @Override
    protected void add_recipes() {
    }

    // sometimes this duplicates an itemstack... idk why
    @Override
    protected void on_tick() {
        if(this.get_state() != MultiblockState.RUNNING) return;
        if(this.get_power() < this.energy_required) return;

        Inventory inputs = this.get_input_hatch().get_inventory();
        Inventory outputs = this.get_output_hatch().get_inventory();

        Inventory inputs_copy = Bukkit.createInventory((InventoryHolder)null, inputs.getSize());
        Inventory outputs_copy = Bukkit.createInventory((InventoryHolder)null, outputs.getSize());

        for(ItemStack input_item : inputs.getContents()) {
            if(input_item == null || input_item.getType().equals(Material.AIR)) continue;
            if(this.get_power() < this.energy_required) return;

            inputs_copy.setContents(inputs.getContents());
            outputs_copy.setContents(outputs.getContents());

            Chemical output_chemical = ChemicalItem.get_by_material(input_item.getType(), ChemicalPurity.INDUSTRIAL_GRADE, input_item.getAmount());

            if(output_chemical != null) {
                HashMap<Integer, ItemStack> remove_item = inputs_copy.removeItem(input_item);
                HashMap<Integer, ItemStack> add_item = outputs_copy.addItem(output_chemical.to_item());

                if(add_item.isEmpty() && remove_item.isEmpty()) {
                    inputs.setContents(inputs_copy.getContents());
                    outputs.setContents(outputs_copy.getContents());

                    this.increment_power(-this.energy_required);
                }
            }
        }
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
