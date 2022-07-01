package fr.erusel.mcjail.managers;

import fr.erusel.mcjail.Mcjail;
import fr.erusel.mcjail.utils.FastBoard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class ScoreboardManager {

    FastBoard board;
    private final HashMap<UUID, FastBoard> waitingscoreboard;
    private final HashMap<UUID, FastBoard> playingscoreboard;
    Mcjail mainclass;
    FastBoard waitingboard;
    FastBoard playingboard;

    public ScoreboardManager(Mcjail mainclass) {

        this.mainclass = mainclass;
        this.waitingscoreboard = new HashMap<>();
        this.playingscoreboard = new HashMap<>();

    }

    public void refreshWaitingScoreboard(){

        for (Player player: Bukkit.getOnlinePlayers()){

            UUID playeruuid = player.getUniqueId();
            String playerTeam = "Aucune";

            if (waitingscoreboard.containsKey(playeruuid)) waitingboard = waitingscoreboard.get(playeruuid);
            else{
                waitingboard = new FastBoard(player);
                waitingboard.updateTitle("§6MC-Jail");
                waitingboard.updateLine(4, "    §dBy Erusel");
            }

            waitingboard.updateLine(1,"§7Joueurs : " + Bukkit.getOnlinePlayers().size() + "§3/" + ChatColor.GRAY + Bukkit.getMaxPlayers());

        }
    }

    public void refreshPlayingScoreboard(){

        for (Player player: Bukkit.getOnlinePlayers()){

            UUID playeruuid = player.getUniqueId();

            if (playingscoreboard.containsKey(playeruuid)) playingboard = playingscoreboard.get(playeruuid);
            else{
                playingboard = new FastBoard(player);
                playingboard.updateTitle("§6MC-Jail");
                playingboard.updateLine(4, "    §dBy Erusel");
            }

            playingboard.updateLine(1, ChatColor.GRAY + "Joueurs : " + Bukkit.getOnlinePlayers().size() + "§3/" + ChatColor.GRAY + Bukkit.getMaxPlayers());

        }
    }
}
