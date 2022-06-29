package fr.erusel.mcjail.listeners;

import fr.erusel.mcjail.Mcjail;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    private final Mcjail mcjail;

    public PlayerQuitListener(Mcjail mcjail) {
        this.mcjail = mcjail;
    }

    @EventHandler
    public void onePlayerQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
    }


}
