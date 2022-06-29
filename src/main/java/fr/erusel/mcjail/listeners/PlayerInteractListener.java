package fr.erusel.mcjail.listeners;

import fr.erusel.mcjail.items.GuardianKeyItem;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Door;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();

        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            Block block = event.getClickedBlock();

            if (player.getItemInHand().isSimilar(GuardianKeyItem.getItem())){
                if (block.getType() == Material.IRON_DOOR){
                    Door door = (Door) block.getBlockData();
                    door.setOpen(!door.isOpen());
                    block.setBlockData(door);
                }
                event.setCancelled(true);
            }
        }





    }


}
