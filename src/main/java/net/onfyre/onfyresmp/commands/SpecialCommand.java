package net.onfyre.onfyresmp.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.onfyre.onfyresmp.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class SpecialCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Server server = sender.getServer();
        TextComponent component1 = Component.text(Main.getPrefix() + "Das Event " + "'" + ChatColor.AQUA + "Neue Season" + ChatColor.WHITE + "' " + "startet in " + ChatColor.GREEN + "10 Sekunden!");
        TextComponent component2 = Component.text(Main.getPrefix() + "Das Event " + "'" + ChatColor.AQUA + "Neue Season" + ChatColor.WHITE + "' " + "startet!");
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 255, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 255, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 255, false, false));
        }
        server.broadcast(component1);
        server.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                server.broadcast(component2);
                for(Player player : Bukkit.getOnlinePlayers()) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 200, 20, false, false));
                    player.sendMessage(Main.getPrefix() + "Season 1 wird gestartet...");
                }
                server.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        for(Player player : Bukkit.getOnlinePlayers()) {
                            player.kickPlayer(Main.getPrefix() + "Der Server wird geupdated! Viel Spaß in Season 1!");
                        }
                        server.shutdown();
                    }
                }, 210);
            }
        }, 200);
        return false;
    }
}
