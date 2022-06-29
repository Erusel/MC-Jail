package fr.erusel.mcjail.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuardianKeyItem {

    public static ItemStack getItem(){
        ItemStack itemstack = new ItemStack(Material.TRIPWIRE_HOOK);
        ItemMeta itemMeta = itemstack.getItemMeta();
        itemMeta.setDisplayName("§7Clé de Gardien");
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemstack.setItemMeta(itemMeta);
        return itemstack;



    }



}
