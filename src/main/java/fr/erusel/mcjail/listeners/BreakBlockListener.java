package fr.erusel.mcjail.listeners;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakBlockListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        if (!event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) event.setCancelled(true);
    }



}
