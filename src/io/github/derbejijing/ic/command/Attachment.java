package io.github.derbejijing.ic.command;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class Attachment implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length != 1) return false;
        
        if(sender instanceof Player) {
            Player player = (Player) sender;

            Inventory input_copy = player.getInventory();

            if(args[0].equals("none")) {
                if(!(input_copy.containsAtLeast(new ItemStack(Material.IRON_INGOT), 2) && input_copy.containsAtLeast(new ItemStack(Material.GLASS), 1))) {
                    player.sendMessage(ChatColor.RED + "required items: ");
                    player.sendMessage(ChatColor.GRAY + "2x iron ingot");
                    player.sendMessage(ChatColor.GRAY + "1x glass");
                    return false;
                }
            }

            ItemStack weapon = new ItemStack(player.getEquipment().getItemInOffHand());
            if(weapon == null || !weapon.getType().equals(Material.CARROT_ON_A_STICK)) {
                player.sendMessage(ChatColor.RED + "You do not have a weapon in your offhand");
                return true;
            }

            // this looks dangerous but should be safe as the player cannot chain commands
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute as " + player.getName() + " at @s run function mgs_catalog:attachments/" + args[0]);

            ItemStack weapon_now = new ItemStack(player.getEquipment().getItemInOffHand());
            if(weapon_now.equals(weapon)) {
                player.sendMessage(ChatColor.RED + "Could not apply attachment");
                return false;
            } else if(!args[0].equals("none")) {
                player.getInventory().removeItem(new ItemStack(Material.IRON_INGOT, 2));
                player.getInventory().removeItem(new ItemStack(Material.GLASS, 1));
                player.updateInventory();
                player.sendMessage(ChatColor.GREEN + "Attachment applied!");
                return true;
            } else player.sendMessage(ChatColor.GREEN + "Attachment removed!");
        }

        return false;
    }
    
}
