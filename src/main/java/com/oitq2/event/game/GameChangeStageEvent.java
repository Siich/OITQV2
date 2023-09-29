package com.oitq2.event.game;

import com.oitq2.game.GameStage;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class GameChangeStageEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel;
    private final GameStage stage;

    public GameChangeStageEvent(GameStage stage) {
        this.stage = stage;
    }

    public GameStage getStage() {
        return stage;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
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
