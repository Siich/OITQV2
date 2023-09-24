package com.oitq2;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.github.retrooper.packetevents.PacketEvents;
import com.oitq2.game.Game;
import io.github.retrooper.packetevents.factory.spigot.SpigotPacketEventsBuilder;
import io.github.rysefoxx.inventory.plugin.pagination.InventoryManager;
import net.megavex.scoreboardlibrary.api.ScoreboardLibrary;
import net.megavex.scoreboardlibrary.api.exception.NoPacketAdapterAvailableException;
import net.megavex.scoreboardlibrary.api.noop.NoopScoreboardLibrary;
import org.bukkit.plugin.java.JavaPlugin;

public class OITQ2 extends JavaPlugin {
    public static OITQ2 INSTANCE;
    private final InventoryManager inventoryManager = new InventoryManager(this);
    private ProtocolManager protocolLib;
    private ScoreboardLibrary scoreboardLibrary;
    /**current game, we keep track this, and if we want to reset game, we just redefine this variable */
    private static Game currentGame;


    public OITQ2() {

    }

    @Override
    public void onLoad() {
        //packets
        protocolLib = ProtocolLibrary.getProtocolManager(); //don't use this
        PacketEvents.setAPI(SpigotPacketEventsBuilder.build(this));
        PacketEvents.getAPI().getSettings().reEncodeByDefault(false)
            .checkForUpdates(true)
            .bStats(true);
        PacketEvents.getAPI().load();
    }


    @Override
    public void onEnable() {
        INSTANCE = this;
        // inventory
        inventoryManager.invoke();
        // scoreboard
        try {
            scoreboardLibrary = ScoreboardLibrary.loadScoreboardLibrary(this);
        } catch (NoPacketAdapterAvailableException e) {
            scoreboardLibrary = new NoopScoreboardLibrary();
        }
        //packets
        //extra things to load, do so before init
        PacketEvents.getAPI().init();
        //game
        currentGame = new Game(2);

    }

    @Override
    public void onDisable() {
        scoreboardLibrary.close();
    }

    /** PUT GETTERS BELOW HERE */

    public static OITQ2 getInstance() {
        return INSTANCE;
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public ProtocolManager getProtocolLib() {
        return protocolLib;
    }

    public ScoreboardLibrary getScoreboardLibrary() {
        return scoreboardLibrary;
    }
}
