package io.github.derbejijing.ic.command;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import io.github.derbejijing.ic.Main;
import io.github.derbejijing.ic.crafting.weapon.WeaponRecipe;
import io.github.derbejijing.ic.crafting.weapon.WeaponRecipeRegistry;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class SetWeapon implements CommandExecutor {

    private final int LEVELS_REQUIRED = 1;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length < 1) {
                player.sendMessage("Click one of the recipes:");
                for(WeaponRecipeRegistry wrr : WeaponRecipeRegistry.values()) {
                    int id = wrr.id;
                    String text = wrr.name;

                    if(id < 0) continue;

                    TextComponent message = new TextComponent(ChatColor.GRAY + "" + id + ChatColor.WHITE + " " + text);
                    message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/setweapon " + id));

                    player.spigot().sendMessage(message);
                }

                TextComponent url_message = new TextComponent("More info: " + ChatColor.GREEN + "https://github.com/DerBejijing/industrial-crafting");
                url_message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/DerBejijing/industrial-crafting"));
                player.spigot().sendMessage(url_message);

                return true;
            }

            int id = 0;
            try{
                id = Integer.parseInt(args[0]);
            } catch(Exception e) {
                return false;
            }

            WeaponRecipe recipe = WeaponRecipeRegistry.get_by_id(id);
            if(recipe == null) return false;

            ItemStack item = player.getInventory().getItemInMainHand();
            if(item == null || !item.getType().equals(Material.PAPER)) {
                player.sendMessage(ChatColor.RED + "You need to have a blueprint in your hand!");
                return true;
            }

            ItemMeta meta = item.getItemMeta();
            if(meta == null || !meta.hasCustomModelData() || meta.getCustomModelData() != 1) {
                player.sendMessage(ChatColor.RED + "You need to have a blueprint in your hand!");
                return true;
            }

            if(item.getAmount() > 1) {
                player.sendMessage(ChatColor.RED + "You cannot write multiple blueprints at one time!");
                return true;
            }

            if(player.getLevel() < this.LEVELS_REQUIRED) {
                player.sendMessage(ChatColor.RED + "You do not have enough levels!");
                player.sendMessage(ChatColor.RED + "Levels required: " + ChatColor.GOLD + this.LEVELS_REQUIRED);
                return true;
            }

            NamespacedKey nsk_recipe = new NamespacedKey(Main.get_main(), "recipe_id");
            NamespacedKey nsk_machine = new NamespacedKey(Main.get_main(), "machine_id");
            NamespacedKey nsk_weapon = new NamespacedKey(Main.get_main(), "weapon_id");

            if(meta.getPersistentDataContainer().has(nsk_recipe, PersistentDataType.BYTE) || meta.getPersistentDataContainer().has(nsk_machine, PersistentDataType.BYTE) || meta.getPersistentDataContainer().has(nsk_weapon, PersistentDataType.BYTE)) {
                player.sendMessage(ChatColor.RED + "You cannot overwrite blueprints!");
                return true;
            }


            player.setLevel(Math.max(0, player.getLevel() - this.LEVELS_REQUIRED));

            meta.getPersistentDataContainer().set(nsk_weapon, PersistentDataType.BYTE, (byte)id);

            List<String> lore = new ArrayList<String>();
            lore.add(ChatColor.GRAY + "Weapon: " + ChatColor.BLUE + WeaponRecipeRegistry.get_name(recipe));
            meta.setLore(lore);

            item.setItemMeta(meta);

            player.sendMessage(ChatColor.GREEN + "The recipe has been written to your blueprint!");

            return true;
        }

        return false;
    }
    
}
