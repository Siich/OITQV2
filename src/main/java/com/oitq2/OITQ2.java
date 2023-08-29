package com.oitq2;

import org.bukkit.plugin.java.JavaPlugin;

public class OITQ2 extends JavaPlugin {
    public static OITQ2 INSTANCE;
    

    public OITQ2() {

    }

    @Override
    public void onLoad() {

    }


    @Override
    public void onEnable() {
        INSTANCE = this;
        
    }

    @Override
    public void onDisable() {
    }

    public static OITQ2 getInstance() {
        return INSTANCE;
    }
}
