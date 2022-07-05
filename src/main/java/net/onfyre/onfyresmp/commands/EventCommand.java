package net.onfyre.onfyresmp.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.onfyre.onfyresmp.Main;
import net.onfyre.onfyresmp.ui.Tablist;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class EventCommand implements CommandExecutor {

    private CommandSender sender;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(args.length >= 0)) return false;
        Server server = sender.getServer();
        TextComponent component1 = Component.text(Main.getPrefix() + "Das Event " + "'" + ChatColor.AQUA + args[0] + ChatColor.WHITE + "' " + "startet in " + ChatColor.GREEN + "10 Sekunden!");
        TextComponent component2 = Component.text(Main.getPrefix() + "Das Event " + "'" + ChatColor.AQUA + args[0] + ChatColor.WHITE + "' " + "startet!");
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
            }
        }, 200);
        return false;
    }
}