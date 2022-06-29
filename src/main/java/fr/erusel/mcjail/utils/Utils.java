package fr.erusel.mcjail.utils;

import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Utils {

    public static UUID getRandomUUIDfromList(List<UUID> list)
    {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    public static void resetPlayer(Player player, boolean resetInventory)
    {
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setSaturation(20);
        if (resetInventory){
            player.getInventory().clear();
            player.getInventory().setBoots(null);
            player.getInventory().setLeggings(null);
            player.getInventory().setChestplate(null);
            player.getInventory().setHelmet(null);
        }
    }


}
