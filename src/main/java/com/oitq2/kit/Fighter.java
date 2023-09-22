package com.oitq2.kit;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class Fighter extends Kit {

    public Fighter (Player p){
        super(p, Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS, Material.DIAMOND_SWORD, PotionEffectType.GLOWING, 1);
    }



}
