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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

public class TeleportCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {
            Inventory tpaMenu = Bukkit.createInventory(null, 3*9, Main.getInvPrefix() + "Teleportanfrage senden");
            for(Player allPlayers : Bukkit.getOnlinePlayers()) {
                ItemStack stack = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
                SkullMeta meta = (SkullMeta) stack.getItemMeta();
                meta.setDisplayName(ChatColor.AQUA.toString() + ChatColor.BOLD + allPlayers.getDisplayName());
                meta.setOwner(allPlayers.getDisplayName());
                stack.setItemMeta(meta);
            }
            player.openInventory(tpaMenu);
        } sender.sendMessage(ChatColor.DARK_RED + "Du musst ein Spieler sein um diesen Befehl auszuführen!");
        return false;
    }
}
