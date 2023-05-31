package io.github.derbejijing.ic.machines;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.BlockState;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
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

public abstract class MultiblockMachine implements ConfigurationSerializable {
    protected Location base_location;
    private MultiblockState state;
    private float power;

    protected int orientation;

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
        this.orientation = orientation;

        this.components = new ArrayList<MultiblockComponent>();
        this.available_recipes = new ArrayList<ChemicalRecipeRegistry>();
        this.available_weapons = new ArrayList<WeaponRecipeRegistry>();

        this.current_recipe = ChemicalRecipeRegistry.get_by_id(this, -1);
        this.current_weapon = WeaponRecipeRegistry.get_by_id(-1, false);

        this.add_components();
        this.add_recipes();
    }


    // save the location, the rotation and the class name and power level and current state and current job
    // when loading, set the data and reinitialize the machine

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> data = new HashMap<>();
        data.put("class_name", this.getClass().getName());
        data.put("world", this.base_location.getWorld().getName());
        data.put("base_x", this.base_location.getX());
        data.put("base_y", this.base_location.getY());
        data.put("base_z", this.base_location.getZ());
        data.put("orientation", this.orientation);
        data.put("power", this.power);
        data.put("state", this.state.id);
        data.put("current_recipe", ChemicalRecipeRegistry.get_name(this.current_recipe));
        data.put("current_weapon", WeaponRecipeRegistry.get_name(this.current_weapon));
        if(this.current_weapon != null) data.put("weapon_mag", this.current_weapon.is_mag());
        else data.put("weapon_mag", false);
        return data;
    }


    @SuppressWarnings("unchecked")
    public static MultiblockMachine deserialize(Map<String, Object> data) {
        String class_name = (String)data.get("class_name");
        String world = (String)data.get("world");
        double x = (double)data.get("base_x");
        double y = (double)data.get("base_y");
        double z = (double)data.get("base_z");
        int orientation = (int)data.get("orientation");
        double power = (double)data.get("power");
        MultiblockState state = MultiblockState.get_by_id((int)data.get("state"));
        String current_recipe = (String)data.get("current_recipe");
        String current_weapon = (String)data.get("current_weapon");
        boolean weapon_mag = (boolean)data.get("weapon_mag");

        try {
            Class<?> clazz = Class.forName(class_name);

            if(MultiblockMachine.class.isAssignableFrom(clazz)) {
                Class<? extends MultiblockMachine> machine_class = (Class<? extends MultiblockMachine>)clazz;

                MultiblockMachine machine = machine_class.getConstructor(Location.class, int.class).newInstance(new Location(Bukkit.getWorld(world), x, y, z), orientation);
                machine.set_recipe(ChemicalRecipeRegistry.get_by_string(current_recipe));
                machine.set_recipe(WeaponRecipeRegistry.get_by_string(current_weapon.replace(" (ammo)", "")), weapon_mag);
                
                machine.power = (float)power;
                machine.state = state;

                boolean valid = true;

                for(MultiblockComponent mc : machine.components) {
                    mc.rotate(orientation);
                    if(!machine.base_location.add(mc.get_location()).getBlock().getType().equals(mc.get_material())) {
                        valid = false;
                        Bukkit.getLogger().info("fail here [" + mc.get_material() + "]: " + machine.base_location.getX() + " " + machine.base_location.getY() + " " + machine.base_location.getZ());
                    }
    
                    if(Main.get_main().get_manager().location_occupied(machine.base_location)) valid = false;
    
                    machine.base_location.subtract(mc.get_location());
                }
                
                if(valid) if(machine.init_and_build()) {
                    machine.change_state(state);
                    machine.power = (float)power;
                    return machine;
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public static MultiblockMachine valueOf(Map<String, Object> data) {
        return deserialize(data);
    }


    public static <T extends MultiblockMachine> T place(Location base_location, int orientation, Class<T> clazz) {
        try {
            T m = clazz.getConstructor(Location.class, int.class).newInstance(base_location, orientation);

            boolean valid = true;
            
            m.orientation = orientation;

            for(MultiblockComponent mc : m.components) {
                mc.rotate(orientation);
                if(!m.base_location.add(mc.get_location()).getBlock().getType().equals(mc.get_material())) {
                    valid = false;
                    Bukkit.getLogger().info("fail here [" + mc.get_material() + "]: " + base_location.getX() + " " + base_location.getY() + " " + base_location.getZ());
                }

                if(Main.get_main().get_manager().location_occupied(m.base_location)) valid = false;

                m.base_location.subtract(mc.get_location());
            }
            
            if(valid) if(m.init_and_build()) return m;

        } catch(Exception e) {
            e.printStackTrace();
        }
        Bukkit.getLogger().info("invalid location or blocks");
        return null;
    }

    
    // this sucks ass but it should do it
    // as a machine may inhabit multiple chunks, this check is required
    public boolean is_loaded() {
        for(MultiblockComponent mc : this.components) {
            if(!mc.get_location_absolute().getChunk().isLoaded()) return false;
        }
        return true;
    }
    

    public void tick() {
        if(!this.is_loaded()) return;
        
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


    public void set_recipe(WeaponRecipeRegistry weapon, boolean mag) {
        for(WeaponRecipeRegistry wrr : this.available_weapons) if(wrr.id == weapon.id) this.current_weapon = WeaponRecipeRegistry.get_by_id(weapon.id, mag);
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
            Main.get_main().get_manager().occupy_location(this, this.base_location.add(mc.get_location()));
            this.base_location.subtract(mc.get_location());
        }
    }


    private void free_locations() {
        for(MultiblockComponent mc : this.components) {
            Main.get_main().get_manager().free_location(this, this.base_location.add(mc.get_location()));
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
