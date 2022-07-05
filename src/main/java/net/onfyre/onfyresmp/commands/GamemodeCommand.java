package net.onfyre.onfyresmp.commands;

import net.onfyre.onfyresmp.Main;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {
            if(!player.hasPermission("smp.gm")) {
                player.sendMessage(ChatColor.DARK_RED + "Keine Rechte!");
                return false;
            }
                if (player.getGameMode() == GameMode.SURVIVAL) {
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(Main.getPrefix() + "Dein Spielmodus wurde geändert!");
                    return false;
                }

                if (player.getGameMode() == GameMode.CREATIVE) {
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(Main.getPrefix() + "Dein Spielmodus wurde geändert!");
                    return false;

                } else {
                    player.sendMessage(ChatColor.DARK_RED + "Dein Gamemode wird nicht unterstützt!");
                    return false;
            }
        } sender.sendMessage(ChatColor.DARK_RED + "Du musst ein Spieler sein um diesen Befehl auszuführen!");
        return false;
    }
}