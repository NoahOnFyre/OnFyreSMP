package net.onfyre.onfyresmp.listeners;

import net.onfyre.onfyresmp.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageListener implements Listener {

    @EventHandler
    public void onDamageByPlayer(EntityDamageByEntityEvent event) {
        if(event.getEntity() instanceof Player player) {
            if(event.getDamager() instanceof Player damager) {
                ExperienceOrb orb1 = player.getWorld().spawn(player.getLocation(), ExperienceOrb.class);
                orb1.setExperience(1);
                ExperienceOrb orb2 = damager.getWorld().spawn(damager.getLocation(), ExperienceOrb.class);
                orb2.setExperience(1);
                Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        player.sendMessage(Main.getPrefix() + ChatColor.AQUA + damager.getDisplayName() + ChatColor.WHITE + " hat noch " + Math.round(damager.getHealth()) + " HP");
                        damager.sendMessage(Main.getPrefix() + ChatColor.AQUA + player.getDisplayName() + ChatColor.WHITE + " hat noch " + Math.round(player.getHealth()) + " HP");
                    }
                }, 5L);
            }
        }
    }
}
