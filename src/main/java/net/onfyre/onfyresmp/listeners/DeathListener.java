package net.onfyre.onfyresmp.listeners;

import net.onfyre.onfyresmp.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class DeathListener implements Listener {

    public static Inventory publicStash = Bukkit.createInventory(null, 6*9, Main.getInvPrefix() + "Public Stash");

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        int playerXP = player.getExpToLevel()/2;
        event.setNewLevel(playerXP);

        for(ItemStack stack : event.getDrops()) {
            if(stack == null) return;
            publicStash.addItem(stack);

        }

        if(event.getPlayer().getKiller() != null) {
            event.setDeathMessage(Main.getPrefix() + ChatColor.AQUA + player.getDisplayName() + ChatColor.WHITE + " wurde von " + ChatColor.AQUA + event.getPlayer().getKiller().getDisplayName() + ChatColor.WHITE + " getötet.");
        }
        else {
            event.setDeathMessage(Main.getPrefix() + ChatColor.AQUA + player.getDisplayName() + ChatColor.WHITE + " ist gestorben.");
        }
    }
}