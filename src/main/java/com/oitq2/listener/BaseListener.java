package com.oitq2.listener;

import com.oitq2.OITQ2;
import com.oitq2.game.Game;
import org.bukkit.event.Listener;

public interface BaseListener extends Listener {
    default OITQ2 getPlugin() {
        return OITQ2.getInstance();
    }

    default Game getGame() {
        return getPlugin().getGame();
    }
}
