package net.onfyre.onfyresmp.listeners;

import net.onfyre.onfyresmp.Main;
import net.onfyre.onfyresmp.ui.MainScoreboard;
import net.onfyre.onfyresmp.ui.Tablist;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.DARK_GRAY + "] " + ChatColor.GREEN + player.getDisplayName() + ChatColor.WHITE + " hat den Server betreten!");
        Bukkit.dispatchCommand(player, "tps");
        for (Player pp : Bukkit.getOnlinePlayers()) {
            new Tablist(pp, pp.getServer());
        }
        new MainScoreboard().setScoreBoard(player);
    }
}