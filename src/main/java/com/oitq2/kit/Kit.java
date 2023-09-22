package com.oitq2.kit;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Kit {

    private Player p;
    //private Material helmet, chest, pants, boots, weapon;
    private Material[] equipment = new Material[5];
    private PotionEffectType effect;
    private int amplifier;

    public Kit(Player p, Material helmet, Material chest, Material pants, Material boots, Material weapon){
        this.p = p;
        this.equipment[0] = helmet;
        this.equipment[1] = chest;
        this.equipment[2] = pants;
        this.equipment[3] = boots;
        this.equipment[4] = weapon;
    }

    public Kit(Player p, Material[] equipment, PotionEffectType effect, int amplifier){
        this(p, equipment[0], equipment[1], equipment[2], equipment[3], equipment[4], effect, amplifier);
    }

    public Kit(Player p, Material helmet, Material chest, Material pants, Material boots, Material weapon, PotionEffectType effect, int amplifier){
        this.effect = effect;
        this.amplifier = amplifier;
        this.p = p;
        this.equipment[0] = helmet;
        this.equipment[1] = chest;
        this.equipment[2] = pants;
        this.equipment[3] = boots;
        this.equipment[4] = weapon;
    }
    // loadout method here
    public void loadout(){
        p.getInventory().setItem(EquipmentSlot.HEAD, new ItemStack(equipment[0]));
        p.getInventory().setItem(EquipmentSlot.CHEST, new ItemStack(equipment[1]));
        p.getInventory().setItem(EquipmentSlot.LEGS, new ItemStack(equipment[2]));
        p.getInventory().setItem(EquipmentSlot.FEET, new ItemStack(equipment[3]));
        p.getInventory().setItem(36, new ItemStack(equipment[4]));

        PotionEffect e = effect.createEffect(Integer.MAX_VALUE, amplifier);
        p.addPotionEffect(e);
    }

}
