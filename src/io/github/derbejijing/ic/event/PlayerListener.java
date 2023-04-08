package io.github.derbejijing.ic.event;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import io.github.derbejijing.ic.Main;
import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.material.AcetonePeroxide;
import io.github.derbejijing.ic.chemical.material.Chloroacetone;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipeRegistry;
import io.github.derbejijing.ic.machines.MultiblockMachine;
import io.github.derbejijing.ic.machines.MultiblockRegistry;
import io.github.derbejijing.ic.machines.component.InterfaceUtils;

public class PlayerListener implements Listener {
    
    @EventHandler
    public void player_click_block_event(PlayerInteractEvent e) {
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK && e.hasItem()) {
            Location location = e.getClickedBlock().getLocation();
            ItemStack item = e.getItem();

            if(item == null || item.getType().equals(Material.AIR)) return;

            if(item.getType().equals(Material.PAPER)) {
                ItemMeta meta = item.getItemMeta();
                if(meta == null || !meta.hasCustomModelData() || meta.getCustomModelData() != 1) return;

                NamespacedKey nsk_recipe = new NamespacedKey(Main.get_main(), "recipe_id");
                NamespacedKey nsk_machine = new NamespacedKey(Main.get_main(), "machine_id");
                PersistentDataContainer data_container = meta.getPersistentDataContainer();

                if(data_container.has(nsk_recipe, PersistentDataType.BYTE)) {
                    MultiblockMachine machine = Main.get_manager().location_occupied_by(location);
                    if(machine == null) return;

                    machine.set_recipe(ChemicalRecipeRegistry.get_type_by_id(data_container.get(nsk_recipe, PersistentDataType.BYTE)));
                    return;
                }

                if(data_container.has(nsk_machine, PersistentDataType.BYTE)) {
                    int id = data_container.get(nsk_machine, PersistentDataType.BYTE);

                    if(MultiblockRegistry.RegistryEnum.get_by_id(id) == null) return;

                    Player player = e.getPlayer();
                    int rotation = (int) (int) Math.floorMod(Math.round(player.getLocation().getYaw() / 90.0), 4);
                    if(rotation < 0) rotation += 4;

                    Main.get_manager().place(e.getPlayer(), location, rotation, id);
                }
            }
        }

        if(e.getAction() == Action.RIGHT_CLICK_AIR && e.hasItem()) {
            ItemStack item = e.getItem();

            Chemical chemical = Chemical.get_from(item);
            if(chemical == null) return;

            Player player = e.getPlayer();

            if(chemical.getClass().equals(AcetonePeroxide.class)) {
                Arrow arrow = player.launchProjectile(Arrow.class);
                arrow.setVelocity(player.getEyeLocation().getDirection().multiply(1.0f));
                arrow.setDamage(0);
                
                PersistentDataContainer container = arrow.getPersistentDataContainer();
                NamespacedKey nsk = new NamespacedKey(Main.get_main(), "projectile_tatp");
                container.set(nsk, PersistentDataType.BYTE, (byte)1);

                item.setAmount(item.getAmount() - 1);
            }

            if(chemical.getClass().equals(Chloroacetone.class)) {
                ItemStack potion_item = new ItemStack(Material.SPLASH_POTION);
                PotionMeta potion_meta = (PotionMeta) potion_item.getItemMeta();

                potion_meta.setBasePotionData(new PotionData(PotionType.INSTANT_DAMAGE));
                potion_meta.addCustomEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 3, 10), true);
                potion_meta.addCustomEffect(new PotionEffect(PotionEffectType.CONFUSION, 20 * 7, 10), true);
                potion_item.setItemMeta(potion_meta);

                ThrownPotion potion = player.launchProjectile(ThrownPotion.class, player.getEyeLocation().getDirection().multiply(1.0f));
                potion.setItem(potion_item);

                item.setAmount(item.getAmount() - 1);
            }
        }
    }


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory clicked_inventory = event.getClickedInventory();
        if (clicked_inventory != null && clicked_inventory.getType() == InventoryType.CHEST) {
            // check if it is part of a machine (check if occupied)
            ItemStack clicked_item = event.getCurrentItem();
            if(clicked_item != null && clicked_item.getType() != Material.AIR) if(InterfaceUtils.is_interface_item(clicked_item)) {
                event.setCancelled(true);

                Location location = clicked_inventory.getLocation();
                MultiblockMachine machine = Main.get_manager().location_occupied_by(location);
                machine.click_button(clicked_item);
            }
        }
    }
}
