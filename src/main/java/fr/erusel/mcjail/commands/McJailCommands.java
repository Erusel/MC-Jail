package fr.erusel.mcjail.commands;

import fr.erusel.mcjail.Mcjail;
import fr.erusel.mcjail.items.GuardianArmorItems;
import fr.erusel.mcjail.items.GuardianKeyItem;
import fr.erusel.mcjail.items.PrisonnerArmorItems;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class McJailCommands implements CommandExecutor {

    Mcjail mcjail;

    public McJailCommands(Mcjail mcjail) {
        this.mcjail = mcjail;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;


            // Commande avec 0 argument ( Donc la commande l'help )
            if (args.length == 0){
                player.sendMessage("HELP MEC");
                return true;
            }
            // Commande give (Pour se giver les différents items)
            if (args[0].equalsIgnoreCase("give")){
                if (args[1] == null) player.sendMessage("Veuillez entrer un truc a give !");

                switch (args[1]){
                    case "guardiankey":
                        player.getInventory().addItem(GuardianKeyItem.getItem());
                    case "guardianarmor":
                        player.getInventory().addItem(GuardianArmorItems.getHelmet());
                        player.getInventory().addItem(GuardianArmorItems.getChestplate());
                        player.getInventory().addItem(GuardianArmorItems.getLeggings());
                        player.getInventory().addItem(GuardianArmorItems.getBoots());
                    case "prisonnerarmor":
                        player.getInventory().addItem(PrisonnerArmorItems.getHelmet());
                        player.getInventory().addItem(PrisonnerArmorItems.getChestplate());
                        player.getInventory().addItem(PrisonnerArmorItems.getLeggings());
                        player.getInventory().addItem(PrisonnerArmorItems.getBoots());
                }
                return true;
            }
            if (args[0].equalsIgnoreCase("start")){
                mcjail.getGameManager().launchGame();
            }
        }
        return false;
    }


}
