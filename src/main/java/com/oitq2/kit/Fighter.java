package com.oitq2.kit;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Fighter extends Kit {

    public Fighter (Player p){
        super(p, Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS, Material.DIAMOND_SWORD);
    }

}
