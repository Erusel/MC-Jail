package fr.erusel.mcjail.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class McJailTabComplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        List<String> list = new ArrayList<>();

        // 1er argument
        if (args.length == 1){
            list.add("give");
            list.add("config");
            list.add("start");
            return list;
        }
        // 2eme argument
        else if (args.length == 2){
            // Les différents items givable
            if (args[0].equalsIgnoreCase("give")){
                list.add("guardiankey");
                list.add("guardianarmor");
                list.add("prisonnerarmor");
            }

            return list;
        }

        return null;
    }
}
