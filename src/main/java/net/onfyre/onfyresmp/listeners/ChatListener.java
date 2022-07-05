package net.onfyre.onfyresmp.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        if(event.getPlayer().getDisplayName().equals("NoahOnFyre")) {
            event.setFormat(ChatColor.DARK_RED.toString() + ChatColor.BOLD + "Owner | " + "%1$s" + ChatColor.RESET + ChatColor.DARK_GRAY + " » " + ChatColor.WHITE + "%2$s");
            return;
        }

        if(event.getPlayer().isOp()) {
            event.setFormat(ChatColor.DARK_RED + "Admin | " + "%1$s" + ChatColor.DARK_GRAY + " » " + ChatColor.WHITE + "%2$s");
            return;
        }

        if(event.getPlayer().getDisplayName().equals("LucaOnFyre")) {
            event.setFormat(ChatColor.LIGHT_PURPLE + "Orga | " + "%1$s" + ChatColor.DARK_GRAY + " » " + ChatColor.WHITE + "%2$s");
            return;
        }

        if(event.getPlayer().getDisplayName().equals("DomiOnFyre")) {
            event.setFormat(ChatColor.DARK_PURPLE + "Mod | " + "%1$s" + ChatColor.DARK_GRAY + " » " + ChatColor.WHITE + "%2$s");
            return;
        }

        event.setFormat(ChatColor.GREEN + "Spieler | " + "%1$s" + ChatColor.DARK_GRAY + " » " + ChatColor.WHITE + "%2$s");
        return;
    }
}