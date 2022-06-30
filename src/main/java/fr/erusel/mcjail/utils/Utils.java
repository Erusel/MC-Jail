package fr.erusel.mcjail.utils;

import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Utils {

    /**
     * It takes a list of UUIDs, and returns a random UUID from that list
     *
     * @param list The list of UUIDs you want to get a random UUID from.
     * @return A random UUID from the list.
     */
    public static UUID getRandomUUIDfromList(List<UUID> list)
    {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    /**
     * It resets a player's health, food, and saturation, and optionally clears their inventory
     *
     * @param player The player you want to reset.
     * @param resetInventory If true, the player's inventory will be cleared.
     */
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
