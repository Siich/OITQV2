package com.oitq2.game;

import com.oitq2.event.game.GameChangeStageEvent;
import com.oitq2.event.game.GameJoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public final class Game {
    private int minPlayers;
    private GameStage currentStage;

    private final int maxPlayers;

    private final int maxPoints;
    private final List<Vector> spawnPoints;

    private final List<String> players;

    public Game() {
        this(2);
    }

    public Game(int minPlayers) {
        this.minPlayers = minPlayers;
        this.maxPlayers = 20;
        this.maxPoints = 20;
        this.spawnPoints = new ArrayList<>();
        this.players = new ArrayList<>();
        this.currentStage = GameStage.NOT_STARTED;
    }

    public int getMinPlayers() {
        return minPlayers;
    }
    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public List<Vector> getSpawnPoints() {
        return spawnPoints;
    }
    public int getSpawnSize() {
        return this.spawnPoints.size();
    }
    public Location getLocation(int i, World world) {
        return spawnPoints.get(i).toLocation(world);
    }

    public GameStage getStage() {
        return currentStage;
    }

    public void addLocation(Vector vector) {
        spawnPoints.add(vector);
    }

    public void joinPlayer(Player player) {
        GameJoinEvent gameJoinEvent = new GameJoinEvent(player);
        Bukkit.getPluginManager().callEvent(gameJoinEvent);
        if (!gameJoinEvent.isCancelled()) {
            players.add(player.getName());
        }

    }

    //this is sich
    public void leavePlayer(Player player) {
        players.remove(player.getName());
    }

    /**
     * Check if player is playing the game
     * @param player player to test for
     * @return true if player is spectator
     *         false if player is playing the game
     */
    public boolean isSpectator(Player player) {
        return !players.contains(player.getName());
    }

    public List<Player> getPlayers() { //todo: use an iterator instead
        List<Player> players = new ArrayList<>();
        for (String name : this.players) {
            players.add(Bukkit.getPlayer(name));
        }
        return players;
    }

    public Game copy() {
        Game copyGame = new Game();
        copyGame.minPlayers = this.minPlayers;
        copyGame.players.addAll(this.players);

        return copyGame;
    }

    public void clear() {

    }

    /**
     *
     * @param newStage the stage to change into
     * @return true if changing game stage was successful, false if not
     */
    public boolean changeStage(GameStage newStage) {
        GameChangeStageEvent changeStageEvent = new GameChangeStageEvent(newStage);
        Bukkit.getPluginManager().callEvent(changeStageEvent);
        if (changeStageEvent.isCancelled()) {
            return false;
        } else {
            currentStage = newStage;
            return true;
        }
    }

    public void countdown() {
        if (currentStage != GameStage.NOT_STARTED) return;
        if (!changeStage(GameStage.COUNTDOWN)) return;

        //todo: run stuff, load world, load spawnpoints here
    }

    //todo: do we need a game start event?
    public void start() {
        if (currentStage != GameStage.COUNTDOWN) return;
        if (!changeStage(GameStage.STARTED)) return;

        //teleporting players to their starting positions
        Collection<? extends Player> players = Bukkit.getOnlinePlayers();
        int numSpawns = this.getSpawnSize();
        final World world = Bukkit.getWorld("world"); //todo: hardcoded world
        int i = 0;
        for (Player player : players) {
            if (isSpectator(player)) {
                Location spawn = getLocation(0, world);
                player.teleport(spawn);
            } else {
                Location spawn = getLocation(i % numSpawns, world);
                player.teleport(spawn);
                i++;
            }
        }


    }

}
