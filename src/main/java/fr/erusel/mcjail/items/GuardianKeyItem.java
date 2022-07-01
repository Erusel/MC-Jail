package fr.erusel.mcjail.items;

import fr.erusel.mcjail.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public class GuardianKeyItem {

    public static ItemStack getItem(){
        ItemBuilder item = new ItemBuilder(Material.TRIPWIRE_HOOK);
        item.name("§7Clé de Gardien").flags(ItemFlag.HIDE_ATTRIBUTES).unbreakable(true);
        return item.build();
    }



}
