package com.oitq2.kit;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public final class Kit {

    private List<String> abilities;

    public Kit(){
        this.abilities = new ArrayList<>();
    }

    public void itemLoadout(Player p){

        //if fighter
        p.getInventory().setItem(EquipmentSlot.HEAD, new ItemStack(Material.IRON_HELMET));
        p.getInventory().setItem(EquipmentSlot.CHEST, new ItemStack(Material.IRON_CHESTPLATE));
        p.getInventory().setItem(EquipmentSlot.LEGS, new ItemStack(Material.IRON_LEGGINGS));
        p.getInventory().setItem(EquipmentSlot.FEET, new ItemStack(Material.IRON_BOOTS));
        //if ranger

    }

    public void specialPotionEffect(PotionEffectType effect, int duration, int amplifier ){
        effect.createEffect(duration, amplifier);
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public void addAbilities(String ability) {
       abilities.add(ability);
    }
}
