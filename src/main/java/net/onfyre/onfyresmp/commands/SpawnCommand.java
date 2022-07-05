package net.onfyre.onfyresmp.commands;

import net.onfyre.onfyresmp.Main;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnCommand implements CommandExecutor {

    private static World world = Bukkit.getWorld("world");

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {
            player.sendMessage(Main.getPrefix() + "Du wirst in 3 Sekunden zu deinem Ziel teleportiert!");
            Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    player.teleport(new Location(world, 0, 70, 0));
                }
            }, 60L);
            return false;
        } sender.sendMessage(ChatColor.DARK_RED + "Du musst ein Spieler sein um diesen Befehl auszuführen!");
        return false;
    }
}