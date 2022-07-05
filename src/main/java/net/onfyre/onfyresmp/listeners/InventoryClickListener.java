package net.onfyre.onfyresmp.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.Style;
import net.onfyre.onfyresmp.Main;
import net.onfyre.onfyresmp.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    private TextComponent component = Component.text(Main.getInvPrefix() + "Teleportieren");

    @EventHandler
    public void onItemClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if(event.getView().getTitle().equals(Main.getInvPrefix() + "Warps")) {
            if(event.getCurrentItem() != null) {
                event.setCancelled(true);
                if(event.getSlot() == 10) {
                    Player target = Bukkit.getPlayer(event.getCurrentItem().getI18NDisplayName().substring(2));
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            player.teleport(target.getLocation());
                        }
                    }, 100);
                }

                if(event.getSlot() == 1) {
                    Player target = Bukkit.getPlayer(event.getCurrentItem().getI18NDisplayName().substring(2));
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            player.teleport(target.getLocation());
                        }
                    }, 100);
                }

                if(event.getSlot() == 10) {
                    Player target = Bukkit.getPlayer(event.getCurrentItem().getI18NDisplayName().substring(2));
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            player.teleport(target.getLocation());
                        }
                    }, 100);
                }

                if(event.getSlot() == 10) {
                    Player target = Bukkit.getPlayer(event.getCurrentItem().getI18NDisplayName().substring(2));
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            player.teleport(target.getLocation());
                        }
                    }, 100);
                }

                if(event.getSlot() == 10) {
                    Player target = Bukkit.getPlayer(event.getCurrentItem().getI18NDisplayName().substring(2));
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            player.teleport(target.getLocation());
                        }
                    }, 100);
                }

                if(event.getSlot() == 10) {
                    Player target = Bukkit.getPlayer(event.getCurrentItem().getI18NDisplayName().substring(2));
                    Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            player.teleport(target.getLocation());
                        }
                    }, 100);
                }
            }
        }

        if(event.getView().getTitle().equals(Main.getInvPrefix() + "Teleportanfrage senden")) {
            if(event.getCurrentItem() != null) {
                event.setCancelled(true);
            }
        }
    }
}