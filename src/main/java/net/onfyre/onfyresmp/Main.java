package net.onfyre.onfyresmp;

import net.onfyre.onfyresmp.commands.*;
import net.onfyre.onfyresmp.commands.carryUtils.*;
import net.onfyre.onfyresmp.listeners.*;
import net.onfyre.onfyresmp.ui.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private MainScoreboard mainScoreboard;

    private int taskID;
    private static String prefix = ChatColor.DARK_GRAY.toString() + "[" + ChatColor.AQUA + ChatColor.BOLD + "OnFyreSMP" + ChatColor.RESET + ChatColor.DARK_GRAY + "]" + ChatColor.DARK_AQUA + " » " + ChatColor.WHITE;
    private static String invPrefix = ChatColor.BOLD.toString() + ChatColor.GOLD;
    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        Server server = Bukkit.getServer();
        listenerRegistration();
        commandRegistration();
        this.mainScoreboard = new MainScoreboard();
        enableScoreboardUpdateTask();
        enableTablistUpdateTask();
        Bukkit.getConsoleSender().sendMessage(Main.getPrefix() + "Plugin gestartet!");
        instance = this;
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tps");
    }

    public void listenerRegistration() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new QuitListener(), this);
        pm.registerEvents(new DeathListener(), this);
        pm.registerEvents(new ChatListener(), this);
        pm.registerEvents(new InventoryClickListener(), this);
        pm.registerEvents(new DamageListener(), this);
        pm.registerEvents(new ItemInteractListener(), this);
        pm.registerEvents(new RespawnListener(), this);
    }

    public void commandRegistration() {
        getCommand("ping").setExecutor(new PingCommand());
        getCommand("gm").setExecutor(new GamemodeCommand());
        getCommand("ec").setExecutor(new EnderChestCommand());
        getCommand("anvil").setExecutor(new AnvilCommand());
        getCommand("craft").setExecutor(new CraftCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("skill").setExecutor(new SkillCommand());
        getCommand("warp").setExecutor(new WarpCommand());
        getCommand("event").setExecutor(new EventCommand());
        getCommand("special").setExecutor(new SpecialCommand());
        getCommand("tpa").setExecutor(new TeleportCommand());
        getCommand("stash").setExecutor(new StashCommand());
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Main.getPrefix() + "Plugin gestoppt!");
        this.getServer().getScheduler().cancelTask(taskID);
    }

    public void enableScoreboardUpdateTask() {
        taskID = this.getServer().getScheduler().scheduleSyncRepeatingTask(this, this::updateScoreboard, 1L, 100L);
    }

    public void enableTablistUpdateTask() {
        taskID = this.getServer().getScheduler().scheduleSyncRepeatingTask(this, this::updateTablist, 1L, 100L);
    }

    public void updateScoreboard() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            MainScoreboard.updateScoreBoard(player);
        }
    }

    public void updateTablist() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            new Tablist(player, player.getServer());
        }
    }

    public static String getPrefix() {
        return prefix;
    }

    public static String getInvPrefix() {
        return invPrefix;
    }
}