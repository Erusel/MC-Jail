package fr.erusel.mcjail.listeners;

import fr.erusel.mcjail.Mcjail;
import fr.erusel.mcjail.managers.GameManager;
import fr.erusel.mcjail.utils.Utils;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class PlayerJoinListener implements Listener {

    private final Mcjail mcjail;

    public PlayerJoinListener(Mcjail mcjail) {
        this.mcjail = mcjail;
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        if (mcjail.getGameManager().isWaiting()){
            Utils.resetPlayer(player, true);
            player.teleport(GameManager.LOBBY_LOCATION);
            mcjail.getGameManager().addIGPlayer(player.getUniqueId());
        }
        if (mcjail.getGameManager().isPlaying()){
            if (!mcjail.getGameManager().getGuardianList().contains(uuid) && !mcjail.getGameManager().getPrisoneerList().contains(uuid)){
                Utils.resetPlayer(player, true);
                player.setGameMode(GameMode.SPECTATOR);
                player.teleport(GameManager.GUARDIAN_LOCATION.get(0));
            }
        }

        event.setJoinMessage(Mcjail.prefix + player.getName() + " a rejoint le serveur");
        mcjail.getScoreboardManager().refreshWaitingScoreboard();
    }
}
