package io.github.derbejijing.ic.command;


import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.github.derbejijing.ic.Main;
import io.github.derbejijing.ic.crafting.chemical.ChemicalRecipeRegistry;
import io.github.derbejijing.ic.machines.MultiblockMachine;

public class SetRecipe implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            Block block = player.getTargetBlock(null, 5);
            MultiblockMachine machine = Main.get_manager().location_occupied_by(block.getLocation());

            Bukkit.getLogger().info(block.getLocation().toString());

            if(machine == null) return false;

            machine.set_recipe(ChemicalRecipeRegistry.get_type_by_id(Integer.parseInt(args[0])));

            return true;
        }

        return false;
    }
    
}
