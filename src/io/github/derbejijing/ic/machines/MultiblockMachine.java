package io.github.derbejijing.ic.machines;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.BlockState;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import io.github.derbejijing.ic.Main;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipe;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipeRegistry;
import io.github.derbejijing.ic.crafting.weapon.WeaponRecipe;
import io.github.derbejijing.ic.crafting.weapon.WeaponRecipeRegistry;
import io.github.derbejijing.ic.machines.component.CraftCenter;
import io.github.derbejijing.ic.machines.component.Generator;
import io.github.derbejijing.ic.machines.component.InputHatch;
import io.github.derbejijing.ic.machines.component.Interface;
import io.github.derbejijing.ic.machines.component.InterfaceUtils;
import io.github.derbejijing.ic.machines.component.MultiblockComponent;
import io.github.derbejijing.ic.machines.component.OutputHatch;
import io.github.derbejijing.ic.machines.component.SolarCell;
import io.github.derbejijing.ic.machines.component.InterfaceUtils.InterfaceItem;

public abstract class MultiblockMachine {
    protected Location base_location;
    private MultiblockState state;
    private float power;

    protected ArrayList<MultiblockComponent> components;
    protected ArrayList<ChemicalRecipeRegistry> available_recipes;
    protected ArrayList<WeaponRecipeRegistry> available_weapons;

    protected boolean is_chemical;

    protected ChemicalRecipe current_recipe;
    protected WeaponRecipe current_weapon;

    public MultiblockMachine(Location base_location, int orientation, boolean is_chemical) {
        this.base_location = base_location;
        this.state = MultiblockState.BROKEN;
        this.power = 0;

        this.is_chemical = is_chemical;

        this.components = new ArrayList<MultiblockComponent>();
        this.available_recipes = new ArrayList<ChemicalRecipeRegistry>();
        this.available_weapons = new ArrayList<WeaponRecipeRegistry>();

        this.current_recipe = ChemicalRecipeRegistry.get_by_id(this, -1);
        this.current_weapon = WeaponRecipeRegistry.get_by_id(-1);

        this.add_components();
        this.add_recipes();
    }


    public static <T extends MultiblockMachine> T place(Location base_location, int orientation, Class<T> clazz) {
        try {
            T m = clazz.getConstructor(Location.class, int.class).newInstance(base_location, orientation);

            boolean valid = true;
            
            for(MultiblockComponent mc : m.components) {
                mc.rotate(orientation);
                if(!m.base_location.add(mc.get_location()).getBlock().getType().equals(mc.get_material())) {
                    valid = false;
                    Bukkit.getLogger().info("fail here [" + mc.get_material() + "]: " + base_location.getX() + " " + base_location.getY() + " " + base_location.getZ());
                }

                if(Main.get_manager().location_occupied(m.base_location)) valid = false;

                m.base_location.subtract(mc.get_location());
            }
            
            if(valid) if(m.init_and_build()) return m;

        } catch(Exception e) {
            e.printStackTrace();
        }
        Bukkit.getLogger().info("invalid location or blocks");
        return null;
    }


    public void tick() {
        if(this.check_damage()) this.destroy();
        if(this.state != MultiblockState.BROKEN) {
            this.on_tick();

            if(this.power < 1000) this.regenerate_power();
            if(this.power <= 0) this.change_state(MultiblockState.NO_POWER);

            if(this.power > 0 && this.state == MultiblockState.NO_POWER) {
                this.change_state(MultiblockState.IDLE);
            }

            if(this.is_chemical) this.get_interface().update_data(this.power / 1000.0f, ChemicalRecipeRegistry.get_name(this.current_recipe));
            else this.get_interface().update_data(this.power / 1000.0f, WeaponRecipeRegistry.get_name(this.current_weapon));
        }

        if(this.state == MultiblockState.RUNNING) {
            this.attempt_crafting();
        }
    }


    public void click_button(ItemStack button) {
        InterfaceItem interface_item = InterfaceUtils.get_interface_item(button);
        if(interface_item == InterfaceItem.NONE) return;

        if(interface_item == InterfaceItem.STATE_RUNNING || interface_item == InterfaceItem.STATE_IDLE || interface_item == InterfaceItem.STATE_NO_POWER) {
            if(this.state == MultiblockState.IDLE) {
                this.change_state(MultiblockState.RUNNING);
                Bukkit.getLogger().info("now running");
            }
            else if(this.state == MultiblockState.RUNNING) {
                this.change_state(MultiblockState.IDLE);
                Bukkit.getLogger().info("now idle");
            }
            else if(this.state == MultiblockState.NO_POWER) {
                Bukkit.getLogger().info("no power!");
            }
        }
    }


    public boolean init_and_build() {
        try {
            this.on_place();
            this.occupy_locations();
            this.load_components();
            this.change_state(MultiblockState.IDLE);
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            try {
                this.destroy();
            } catch(Exception ee) {
                ee.printStackTrace();
            }
            return false;
        }
    }


    public MultiblockState get_state() {
        return this.state;
    }


    public Location get_location() {
        return this.base_location;
    }


    public void set_recipe(ChemicalRecipeRegistry recipe) {
        for(ChemicalRecipeRegistry crr : this.available_recipes) if(crr.id == recipe.id) this.current_recipe = ChemicalRecipeRegistry.get_by_id(this, recipe.id);
    }


    public void set_recipe(WeaponRecipeRegistry weapon) {
        for(WeaponRecipeRegistry wrr : this.available_weapons) if(wrr.id == weapon.id) this.current_weapon = WeaponRecipeRegistry.get_by_id(weapon.id);
    }


    private Inventory get_input() {
        InputHatch i = this.get_input_hatch();
        if(i != null) return i.get_inventory();

        return this.get_interface().get_inventory();
    }


    private Inventory get_output() {
        OutputHatch o = this.get_output_hatch();
        if(o != null) return o.get_inventory();

        return this.get_interface().get_inventory();
    }


    private void attempt_crafting() {
        if(this.is_chemical) if(this.current_recipe != null) if(this.current_recipe.attempt_craft(this.get_input(), this.get_output(), this.power)) this.power -= this.current_recipe.get_power_required();
        if(!this.is_chemical) if(this.current_weapon != null) if(this.current_weapon.attempt_craft(this.get_center().get_location_center(), this.get_input(), this.get_output(), this.power)) this.power -= this.current_weapon.get_power_required();
    }


    private void load_components() {
        for(MultiblockComponent mc : this.components) mc.place();
    }


    private void unload_components() {
        for(MultiblockComponent mc : this.components) mc.destroy();
    }


    private void change_state(MultiblockState state) {
        this.state = state;
        this.get_interface().change_state(state);
        this.on_change_state();
    }


    private void destroy() {
        this.change_state(MultiblockState.BROKEN);
        this.free_locations();
        this.on_destroy();
        this.unload_components();
    }


    private void occupy_locations() {
        for(MultiblockComponent mc : this.components) {
            Main.get_manager().occupy_location(this, this.base_location.add(mc.get_location()));
            this.base_location.subtract(mc.get_location());
        }
    }


    private void free_locations() {
        for(MultiblockComponent mc : this.components) {
            Main.get_manager().free_location(this, this.base_location.add(mc.get_location()));
            this.base_location.subtract(mc.get_location());
        }
    }


    private boolean check_damage() {
        boolean damaged = false;

        for(MultiblockComponent mc : this.components) {
            if(!this.base_location.add(mc.get_location()).getBlock().getType().equals(mc.get_material())) damaged = true;
            this.base_location.subtract(mc.get_location());
        }

        return damaged;
    }


    private boolean regenerate_power() {
        Generator generator = this.get_generator();
        if(generator == null) return false;
        int generated = generator.generate_energy();
        this.increment_power(generated);
        return generated > 0;
    }


    protected float get_power() {
        return this.power;
    }


    protected void increment_power(float amount) {
        this.power += amount;
        if(this.power > 1500) this.power = 1500;
    }


    protected void add_component(MultiblockComponent component) {
        this.components.add(component);
    }


    protected void add_recipe(ChemicalRecipeRegistry recipe) {
        this.available_recipes.add(recipe);
    }


    protected void add_weapon(WeaponRecipeRegistry weapon) {
        this.available_weapons.add(weapon);
    }


    protected CraftCenter get_center() {
        for(MultiblockComponent mc : this.components) if(mc instanceof CraftCenter) return (CraftCenter) mc;
        return null;
    }


    protected SolarCell get_solar_cell() {
        for(MultiblockComponent mc : this.components) if(mc instanceof SolarCell) return (SolarCell) mc;
        return null;
    }


    protected Interface get_interface() {
        for(MultiblockComponent mc : this.components) if(mc instanceof Interface) return (Interface) mc;
        return null;
    }


    protected Generator get_generator() {
        for(MultiblockComponent mc : this.components) if(mc instanceof Generator) return (Generator) mc;
        return null;
    }


    protected InputHatch get_input_hatch() {
        for(MultiblockComponent mc : this.components) if(mc instanceof InputHatch) return (InputHatch) mc;
        return null;
    }


    protected OutputHatch get_output_hatch() {
        for(MultiblockComponent mc : this.components) if(mc instanceof OutputHatch) return (OutputHatch) mc;
        return null;
    }


    protected Inventory get_inventory(Class<? extends MultiblockComponent> component_type) {
        for(MultiblockComponent mbc : this.components) {
            if(mbc.getClass().getName() == component_type.getName()) {
                this.base_location.add(mbc.get_location());
                BlockState bs = this.base_location.getBlock().getState();
                this.base_location.subtract(mbc.get_location());

                if(bs instanceof InventoryHolder) {
                    InventoryHolder inventory_holder = (InventoryHolder) bs;
                    return inventory_holder.getInventory();
                }
            }
        }

        return null;
    }


    protected abstract void add_components();

    protected abstract void add_recipes();

    protected abstract void on_tick();

    protected abstract void on_place();

    protected abstract void on_destroy();

    protected abstract void on_change_state();
}