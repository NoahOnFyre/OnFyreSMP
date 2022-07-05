package net.onfyre.onfyresmp.commands;

import net.onfyre.onfyresmp.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.DARK_RED + "Diesen Befehl können nur Spieler ausführen!");
            return false;
        }
        player.sendMessage(Main.getPrefix() + "Dein Ping: " + ChatColor.GREEN + player.getPing() + "ms");
        return false;
    }
}