package net.onfyre.onfyresmp.commands.carryUtils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CraftCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {
            player.openWorkbench(null, true);
            return false;
        } sender.sendMessage(ChatColor.DARK_RED + "Du musst ein Spieler sein um diesen Befehl auszuführen!");
        return false;
    }
}
