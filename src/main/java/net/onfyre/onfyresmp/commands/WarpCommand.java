package net.onfyre.onfyresmp.commands;

import net.onfyre.onfyresmp.Main;
import net.onfyre.onfyresmp.utils.ItemBuilder;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

public class WarpCommand implements CommandExecutor {

    private static World overworld = Bukkit.getWorld("world");
    private static World nether = Bukkit.getWorld("world_nether");
    private static World end = Bukkit.getWorld("world_the_end");

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {
            Inventory warpMenu = Bukkit.createInventory(null, 3*9, Main.getInvPrefix() + "Warps");
            warpMenu.setItem(10, playerHead("Noah's Grundstück", "NoahOnFyre"));
            warpMenu.setItem(11, playerHead("Luca's Grundstück", "LucaOnFyre"));
            warpMenu.setItem(12, playerHead("Dominik's Grundstück", "DomiOnFyre"));
            warpMenu.setItem(13, playerHead("Julian's Grundstück", "julianonfyre"));
            warpMenu.setItem(14, new ItemBuilder(Material.NETHERRACK).setDisplayname(ChatColor.DARK_RED + "Nether").build());
            warpMenu.setItem(15, new ItemBuilder(Material.END_STONE).setDisplayname(ChatColor.YELLOW + "End").build());
            warpMenu.setItem(16, new ItemBuilder(Material.TERRACOTTA).setDisplayname(ChatColor.GOLD + "Mesa").build());
            player.openInventory(warpMenu);
        } sender.sendMessage(ChatColor.DARK_RED + "Du musst ein Spieler sein um diesen Befehl auszuführen!");
        return false;
    }

    public ItemStack playerHead(String itemName, String playerName) {
        ItemStack stack = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
        SkullMeta meta = (SkullMeta) stack.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA.toString() + ChatColor.BOLD + itemName);
        meta.setOwner(playerName);
        stack.setItemMeta(meta);
        return stack;
    }
}
