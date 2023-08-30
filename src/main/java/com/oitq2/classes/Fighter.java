package com.oitq2.classes;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

public class Fighter implements Listener { // to use sword skill
    // give kit - items
    public void fighterKit(Player p){
        //I feel like there is a better way of doing this with fewer lines but I couldn't think of it
        p.getInventory().setItem(EquipmentSlot.HEAD, new ItemStack(Material.IRON_HELMET));
        p.getInventory().setItem(EquipmentSlot.CHEST, new ItemStack(Material.IRON_CHESTPLATE));
        p.getInventory().setItem(EquipmentSlot.LEGS, new ItemStack(Material.IRON_LEGGINGS));
        p.getInventory().setItem(EquipmentSlot.FEET, new ItemStack(Material.IRON_BOOTS));
    }

    // sword skill
    // I don't know if this should go in its own class

    @EventHandler
    public void onSwordDrop(PlayerDropItemEvent e){
        if (e.getItemDrop().equals(Material.DIAMOND_SWORD)){ //only fighters will have diamond sword
            e.getPlayer().sendMessage("Rage has been activated");
            e.getPlayer().addPotionEffect(PotionEffectType.INCREASE_DAMAGE.createEffect(10, 1));
        }
    }

}