package fr.erusel.mcjail;

import fr.erusel.mcjail.commands.McJailCommands;
import fr.erusel.mcjail.commands.McJailTabComplete;
import fr.erusel.mcjail.listeners.BreakBlockListener;
import fr.erusel.mcjail.listeners.PlayerInteractListener;
import fr.erusel.mcjail.listeners.PlayerJoinListener;
import fr.erusel.mcjail.listeners.PlayerQuitListener;
import fr.erusel.mcjail.managers.GameManager;
import fr.erusel.mcjail.managers.ScoreboardManager;
import fr.erusel.mcjail.utils.FastInvManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mcjail extends JavaPlugin {

    private final GameManager GameManager = new GameManager(this);
    private final ScoreboardManager scoreboardManager = new ScoreboardManager(this);
    public static String prefix = "§7[§6MC-Jail§7] ";

    @Override
    public void onEnable() {
        System.out.println("[MC-Jail] Initialisation en cours");
        FastInvManager.register(this);

        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new BreakBlockListener(), this);

        getCommand("mcjail").setExecutor(new McJailCommands(this));
        getCommand("mcjail").setTabCompleter(new McJailTabComplete());

        for (Player player : Bukkit.getOnlinePlayers()) getGameManager().addIGPlayer(player.getUniqueId());
        scoreboardManager.refreshWaitingScoreboard();
    }

    @Override
    public void onDisable() {
        System.out.println("[MC-Jail] Désactivation en cours");
    }

    public GameManager getGameManager(){
        return GameManager;
    }
    public ScoreboardManager getScoreboardManager(){
        return scoreboardManager;
    }
}
