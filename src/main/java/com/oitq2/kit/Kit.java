package com.oitq2.kit;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Kit {

    public Kit(){
    }

    public void itemLoadout(Player p, Material helmet, Material chest, Material pants, Material boots, Material weapon){ // is there a way to shortern this?

        //armor
        p.getInventory().setItem(EquipmentSlot.HEAD, new ItemStack(helmet));
        p.getInventory().setItem(EquipmentSlot.CHEST, new ItemStack(chest));
        p.getInventory().setItem(EquipmentSlot.LEGS, new ItemStack(pants));
        p.getInventory().setItem(EquipmentSlot.FEET, new ItemStack(boots));
        //sword & bow
        p.getInventory().setItem(36, new ItemStack(weapon)); // sword
        p.getInventory().setItem(37, new ItemStack(Material.BOW));

    }

    public void addEffect(Player p, PotionEffectType effect, int duration, int amplifier){
        PotionEffect e = effect.createEffect(duration, amplifier);
        p.addPotionEffect(e);
    }

}
