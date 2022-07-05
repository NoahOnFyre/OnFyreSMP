package net.onfyre.onfyresmp.listeners;

import net.onfyre.onfyresmp.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnListener implements Listener {

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();

        Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                player.openInventory(DeathListener.publicStash);
                player.sendMessage(Main.getPrefix() + "Bitte beachte, dass der Stash sich bei jedem Serverneustart leert!");
                player.sendMessage(Main.getPrefix() + "Der Stash ist jederzeit mit /stash aufrufbar.");
            }
        }, 60);
    }
}
