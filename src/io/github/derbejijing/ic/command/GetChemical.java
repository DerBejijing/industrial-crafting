package io.github.derbejijing.ic.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.derbejijing.ic.chemical.Chemical;
import io.github.derbejijing.ic.chemical.ChemicalItem;
import io.github.derbejijing.ic.chemical.property.ChemicalPurity;

public class GetChemical implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            int id = Integer.parseInt(args[0]);
            int purity = Integer.parseInt(args[1]);

            Chemical c = ChemicalItem.get_by_id(id, ChemicalPurity.get_by_id(purity), 64);

            ItemStack item = c.to_item();

            player.getInventory().addItem(item);
            
            return true;
        }

        return false;
    }
    
}
