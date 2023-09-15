package com.oitq2.game;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public final class Game {
    private int minPlayers;
    private final int maxPlayers;

    private final int maxPoints;
    private final List<Vector> spawnPoints;

    private final List<String> players;

    public Game(int minPlayers) {
        this.minPlayers = minPlayers;
        this.maxPlayers = 20;
        this.maxPoints = 20;
        this.spawnPoints = new ArrayList<>();
        this.players = new ArrayList<>();
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

    public Location getLocation(int i, World world) {
        return spawnPoints.get(i).toLocation(world);
    }

    public void addLocation(Vector vector) {
        spawnPoints.add(vector);
    }

    public void joinPlayer(Player player) {
        players.add(player.getName());
    }

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
}
