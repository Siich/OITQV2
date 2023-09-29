package com.oitq2.listener;

import com.oitq2.game.GameStage;
import com.oitq2.event.game.GameJoinEvent;
import com.oitq2.kit.Fighter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;


public class JoinListener implements BaseListener {

    @EventHandler
    public void joinEvent(PlayerJoinEvent e) {
        //handles joining players to game when they join the server
        Player p = e.getPlayer();
        getGame().joinPlayer(p);

        Fighter fighterKit = new Fighter(p);
        fighterKit.loadout();

    }

    @EventHandler
    public void joinGame(GameJoinEvent e) {
        Player p = e.getPlayer();
        if (getGame().getStage() == GameStage.STARTED) {
            e.setCancelled(true);
            p.sendMessage("Game is ongoing, you are a spectator.");
        }
    }
}
