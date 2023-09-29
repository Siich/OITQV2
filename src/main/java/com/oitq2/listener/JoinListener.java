package com.oitq2.listener;

import com.oitq2.kit.Fighter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffectType;

public class JoinListener implements Listener {

    @EventHandler
    public void joinEvent(PlayerJoinEvent e ){
        Fighter fighterKit = new Fighter(e.getPlayer());
        fighterKit.loadout();

    }
}
