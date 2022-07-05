package net.onfyre.onfyresmp.listeners;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class ItemInteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if(event.getItem() == null) return;

        ItemStack stack = event.getItem();

        player.sendMessage("Test 1");
        if(stack == new ItemStack(Material.IRON_SWORD)) {
            player.sendMessage("Test 2");
            if(event.getAction().isRightClick()) {
                player.sendMessage("Test 3");
                Location location = player.getFacing().getDirection().toLocation(player.getWorld());
                for(Player nearPlayers : location.getNearbyPlayers(10)) {
                    AreaEffectCloud cloud = nearPlayers.getWorld().spawn(nearPlayers.getLocation(), AreaEffectCloud.class);
                    cloud.setRadius(8);
                    cloud.setDuration(600);
                    PotionEffect poison = new PotionEffect(PotionEffectType.POISON, 100, 255, false, false);
                    PotionEffect slowness = new PotionEffect(PotionEffectType.SLOW, 100, 2, false, false);
                    PotionEffect glowing = new PotionEffect(PotionEffectType.GLOWING, 600,255, false, false);
                    cloud.addCustomEffect(poison, true);
                    cloud.addCustomEffect(slowness, true);
                    cloud.addCustomEffect(glowing, true);
                }
            }
        }
    }

    public ItemStack getSword(int value) {
        ItemStack stack = new ItemStack(Material.IRON_SWORD);
        ItemMeta meta = stack.getItemMeta();
        meta.setCustomModelData(value);
        stack.setItemMeta(meta);
        return stack;
    }
}
