package net.onfyre.onfyresmp.ui;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Tablist {

    public Tablist(@NotNull Player player, @NotNull Server server) {
        String header = ChatColor.AQUA.toString() + ChatColor.BOLD + "OnFyreSMP" + ChatColor.RESET + ChatColor.DARK_GRAY + " - " + ChatColor.GOLD + "Season 1" + ChatColor.DARK_GRAY + " - " + ChatColor.GREEN + server.getOnlinePlayers().size() + " von " + server.getMaxPlayers() + " Spielern Online!";

        String footer1 = ChatColor.AQUA.toString() + ChatColor.BOLD + "Dein Ping" + ChatColor.RESET + ChatColor.GRAY + ": " + ChatColor.DARK_AQUA + player.getPing();
        String footer2 = ChatColor.AQUA.toString() + ChatColor.BOLD + "Account" + ChatColor.RESET + ChatColor.GRAY + ": " + ChatColor.DARK_AQUA + player.getDisplayName();
        String footer3 = ChatColor.AQUA.toString() + ChatColor.BOLD + "Deine Tode" + ChatColor.RESET + ChatColor.GRAY + ": " + ChatColor.DARK_AQUA + player.getStatistic(Statistic.DEATHS);

        player.setPlayerListHeaderFooter("\n  " + header + "  \n", "\n  " + footer1 + "\n" + footer2 + "\n" + footer3 + "\n  ");
    }
}