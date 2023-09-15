package com.oitq2;

import com.oitq2.game.Game;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class OITQ2 extends JavaPlugin {
    public static OITQ2 INSTANCE;
    /**current game, we keep track this, and if we want to reset game, we just redefine this variable */
    private static Game currentGame;

    public OITQ2() {

    }

    @Override
    public void onLoad() {

    }


    @Override
    public void onEnable() {
        INSTANCE = this;
        currentGame = new Game(2);
        
    }

    @Override
    public void onDisable() {
    }

    public static OITQ2 getInstance() {
        return INSTANCE;
    }

}
