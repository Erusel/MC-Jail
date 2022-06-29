package fr.erusel.mcjail.managers;

import fr.erusel.mcjail.Mcjail;
import fr.erusel.mcjail.enums.GState;
import fr.erusel.mcjail.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GameManager {

    private final Mcjail mcJail;
    private GState gameState;

    public final static World GAMEWORLD = Bukkit.getWorld("world");
    public final static Location LOBBY_LOCATION = new Location(GAMEWORLD, 126, 4, -102);
    public static List<Location> PRISONEER_LOCATION = new ArrayList<>();
    public static List<Location> GUARDIAN_LOCATION = new ArrayList<>();

    private List<UUID> playersList = new ArrayList<>();
    private List<UUID> prisoneerList = new ArrayList<>();
    private List<UUID> guardianList = new ArrayList<>();
    private List<UUID> spectatorList = new ArrayList<>();

    public GameManager(Mcjail mcJail) {
        this.mcJail = mcJail;
        this.gameState = GState.WAITING;
    }

    public void launchGame(){
        // 30% de guardien
        int playercount = playersList.size();
        int guardiancount;
        int prisoneercount;

        guardiancount = (int) Math.round(playercount*0.30);
        prisoneercount = playercount - guardiancount;

        Bukkit.broadcastMessage("Guardien : " + guardiancount);
        Bukkit.broadcastMessage("Prisonnier : " + prisoneercount);

        int teleportcount = 0;
        // On sets les joueurs Guardien
        for (int i=0; i < guardiancount;) {
            UUID uuid = Utils.getRandomUUIDfromList(playersList);

            if (!guardianList.contains(uuid)){
                Player player = Bukkit.getPlayer(uuid);
                guardianList.add(uuid);
                playersList.remove(uuid);
                System.out.println("L'uuid  : " + uuid + " a été désigné comme Guardian");
                Bukkit.broadcastMessage(Bukkit.getPlayer(uuid) + " = Guardien");

                player.teleport(getGuardianLocations().get(teleportcount));
                teleportcount++;
                i++;
            }

        }
        teleportcount = 0;
        // On set les joueurs Prisonnier
        for (UUID uuid : playersList){
            Player player = Bukkit.getPlayer(uuid);
            prisoneerList.add(uuid);
            playersList.remove(uuid);
            Bukkit.broadcastMessage(Bukkit.getPlayer(uuid) + " = Prisonnier");

            player.teleport(getPrisoneerLocations().get(teleportcount));
            teleportcount++;

        }

    }

    public void stopGame(){

        prisoneerList.clear();
        guardianList.clear();

        for (UUID uuid : playersList){
            Player player = Bukkit.getPlayer(uuid);

            player.teleport(LOBBY_LOCATION);
            player.getInventory().clear();
        }


    }

    public void addIGPlayer(UUID uuid){
        if (!playersList.contains(uuid)) playersList.add(uuid);
    }

    public void removeIGPlayer(UUID uuid){
        if (playersList.contains(uuid)) playersList.remove(uuid);
    }

    public void addPrisonnerPlayer(UUID uuid){
        if (!prisoneerList.contains(uuid)) prisoneerList.add(uuid);
    }

    public void removePrisonnerPlayer(UUID uuid){
        if (prisoneerList.contains(uuid)) prisoneerList.add(uuid);
    }

    public void addGuardianPlayer(UUID uuid){
        if (!guardianList.contains(uuid)) guardianList.add(uuid);
    }

    public void removeGuardianPlayer(UUID uuid){
        if (guardianList.contains(uuid)) guardianList.remove(uuid);
    }

    public GState getGameState(){
        return gameState;
    }

    public void setGameState(GState state){
        gameState = state;
    }

    public List<Location> getPrisoneerLocations(){
        List<Location> list = new ArrayList<>();
        list.add(new Location(GAMEWORLD, 46, 8, -150));
        list.add(new Location(GAMEWORLD, 46, 8, -146));
        list.add(new Location(GAMEWORLD, 46, 8, -142));
        return list;
    }

    public List<Location> getGuardianLocations(){
        List<Location> list = new ArrayList<>();
        list.add(new Location(GAMEWORLD, 64, 4, -142));
        return list;
    }

    public List<UUID> getPrisoneerList(){
        return prisoneerList;
    }

    public List<UUID> getGuardianList(){
        return guardianList;
    }
}
