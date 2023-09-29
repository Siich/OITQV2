package com.oitq2.game.event;

import com.oitq2.game.Game;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class GameJoinEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    private final Player player; //player that joins
    private boolean cancel;

    public GameJoinEvent(Player player) {
        this.player = player;
        this.cancel = false;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancel = b;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    //this method doesn't get called but it is required
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
