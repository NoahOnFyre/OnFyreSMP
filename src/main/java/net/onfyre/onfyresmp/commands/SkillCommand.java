package net.onfyre.onfyresmp.commands;

import net.onfyre.onfyresmp.Main;
import net.onfyre.onfyresmp.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class SkillCommand implements CommandExecutor {
    
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {
            Inventory inv = Bukkit.createInventory(null, 4 * 9, Main.getInvPrefix() + "Skillverbesserungen");
            inv.setItem(10, new ItemBuilder(Material.APPLE).setDisplayname(ChatColor.WHITE + "Herzen verbessern").build());
            inv.setItem(20, new ItemBuilder(Material.RABBIT_FOOT).setDisplayname(ChatColor.WHITE + "Sprunghöhe verbessern").build());
            inv.setItem(12, new ItemBuilder(Material.FEATHER).setDisplayname(ChatColor.WHITE + "Speed verbessern").build());
            inv.setItem(22, new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayname(ChatColor.WHITE + "Resistance verbessern").build());
            inv.setItem(14, new ItemBuilder(Material.NETHERITE_SWORD).setDisplayname(ChatColor.WHITE + "Attack-Damage verbessern").build());
            inv.setItem(24, new ItemBuilder(Material.WOODEN_AXE).setDisplayname(ChatColor.WHITE + "Hit-Cooldown verbessern").build());
            inv.setItem(16, new ItemBuilder(Material.WATER_BUCKET).setDisplayname(ChatColor.WHITE + "Atem verbessern").build());
            player.openInventory(inv);
            return false;
        } sender.sendMessage(ChatColor.DARK_RED + "Du musst ein Spieler sein um diesen Befehl auszuführen!");
        return false;
    }
}
