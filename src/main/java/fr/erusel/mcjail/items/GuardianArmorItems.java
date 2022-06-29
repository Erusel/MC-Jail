package fr.erusel.mcjail.items;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class GuardianArmorItems {

    public static ItemStack getHelmet(){
        ItemStack itemStack = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) itemStack.getItemMeta();
        leatherArmorMeta.setColor(Color.BLUE);
        leatherArmorMeta.setDisplayName("§9Casque de Guardien");
        leatherArmorMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        leatherArmorMeta.setUnbreakable(true);
        itemStack.setItemMeta(leatherArmorMeta);
        return itemStack;
    }

    public static ItemStack getChestplate(){
        ItemStack itemStack = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) itemStack.getItemMeta();
        leatherArmorMeta.setColor(Color.BLUE);
        leatherArmorMeta.setDisplayName("§9Haut de Guardien");
        leatherArmorMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        leatherArmorMeta.setUnbreakable(true);
        itemStack.setItemMeta(leatherArmorMeta);
        return itemStack;
    }

    public static ItemStack getLeggings(){
        ItemStack itemStack = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) itemStack.getItemMeta();
        leatherArmorMeta.setColor(Color.BLUE);
        leatherArmorMeta.setDisplayName("§9Pantalon de Guardien");
        leatherArmorMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        leatherArmorMeta.setUnbreakable(true);
        itemStack.setItemMeta(leatherArmorMeta);
        return itemStack;
    }

    public static ItemStack getBoots(){
        ItemStack itemStack = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) itemStack.getItemMeta();
        leatherArmorMeta.setColor(Color.BLUE);
        leatherArmorMeta.setDisplayName("§9Bottes de Guardien");
        leatherArmorMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        leatherArmorMeta.setUnbreakable(true);
        itemStack.setItemMeta(leatherArmorMeta);
        return itemStack;
    }


}
