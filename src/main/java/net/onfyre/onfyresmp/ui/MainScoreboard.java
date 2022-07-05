package net.onfyre.onfyresmp.ui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.block.BlockState;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.*;

import java.util.HashMap;
import java.util.UUID;

public class MainScoreboard {

    private static final Material currency = Material.DIAMOND;
    private static final Material currencyBlock = Material.DIAMOND_BLOCK;

    private static final HashMap<UUID, Scoreboard> SCOREBOARD_HASH_MAP = new HashMap<>();

    public MainScoreboard() {
    }

    public static void setScoreBoard(Player player) {
        if (!SCOREBOARD_HASH_MAP.containsKey(player.getUniqueId())) {
            Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective playerobjective = scoreboard.registerNewObjective(player.getUniqueId().toString(), "dummy", ChatColor.AQUA.toString() + ChatColor.BOLD + "OnFyreSMP");
            playerobjective.setDisplaySlot(DisplaySlot.SIDEBAR);
            SCOREBOARD_HASH_MAP.put(player.getUniqueId(), scoreboard);
            Objective tabHP = scoreboard.registerNewObjective(player.getDisplayName(), "health", "Health");
            tabHP.setDisplaySlot(DisplaySlot.PLAYER_LIST);
            tabHP.setRenderType(RenderType.HEARTS);
        }
        player.setScoreboard(SCOREBOARD_HASH_MAP.get(player.getUniqueId()));
    }

    public static void updateScoreBoard(Player player) {
        Scoreboard playerScoreBoard = SCOREBOARD_HASH_MAP.get(player.getUniqueId());
        Objective playerScoreBoardObjective = playerScoreBoard.getObjective(player.getUniqueId().toString());

        if (playerScoreBoardObjective == null) {
            return;
        }

        for (String entry : playerScoreBoard.getEntries()) {
            Score score = playerScoreBoardObjective.getScore(entry);
            score.resetScore();
        }

        setScore(player, ChatColor.DARK_PURPLE.toString(), 15);
        setScore(player, ChatColor.GRAY.toString() + ChatColor.BOLD + "Kontostand >>", 14);
        setScore(player, ChatColor.AQUA.toString() + countCurrency(player) + " Diamanten", 13);
        setScore(player, ChatColor.BLUE.toString(), 12);
        setScore(player, ChatColor.GRAY.toString() + ChatColor.BOLD + "Tode >>", 11);
        if (String.valueOf(player.getStatistic(Statistic.DEATHS)).equals("0")) {
            setScore(player, ChatColor.AQUA + "0", 10);
        } else {
            setScore(player, ChatColor.AQUA.toString() + player.getStatistic(Statistic.DEATHS), 10);
        }
        setScore(player, ChatColor.BLACK.toString(), 9);
        setScore(player, ChatColor.GRAY.toString() + ChatColor.BOLD + "Kills >>", 8);
        setScore(player, ChatColor.AQUA.toString() + player.getStatistic(Statistic.PLAYER_KILLS), 7);
        setScore(player, ChatColor.WHITE.toString(), 6);
        setScore(player, ChatColor.GRAY.toString() + ChatColor.BOLD + "Ping >>", 5);
        setScore(player, ChatColor.AQUA.toString() + player.getPing() + "ms", 4);
        setScore(player, ChatColor.DARK_AQUA.toString(), 3);
        setScore(player, ChatColor.GRAY.toString() + ChatColor.BOLD + "Discord >>", 2);
        setScore(player, ChatColor.AQUA + "discord.io/onfyre", 1);
    }

    public static void setScore(Player player, String text, int scoreValue) {
        Objective playerObjektiv = SCOREBOARD_HASH_MAP.get(player.getUniqueId()).getObjective(player.getUniqueId().toString());

        if (playerObjektiv == null) {
            return;
        }

        Score score = playerObjektiv.getScore(text);
        score.setScore(scoreValue);
    }

    private static int countCurrency(Player player) {
        int currencyValue = 0;

        currencyValue = currencyValue + countInventory(player.getInventory());
        currencyValue = currencyValue + countInventory(player.getEnderChest());

        return currencyValue;
    }

    private static int countInventory(Inventory inventory) {
        int count = 0;
        for (ItemStack stack : inventory) {
            if (stack != null) {
                if (stack.getType() == currency) {
                    count = count + stack.getAmount();
                }
                if (stack.getType() == currencyBlock) {
                    count = count + stack.getAmount() * 9;
                }

                ItemMeta meta = stack.getItemMeta();
                if (meta instanceof BlockStateMeta blockStateMeta) {
                    BlockState blockState = blockStateMeta.getBlockState();
                    if (blockState instanceof ShulkerBox box) {
                        for (ItemStack shulkerStack : box.getInventory()) {
                            if (shulkerStack != null) {
                                if (shulkerStack.getType() == currency) {
                                    count = count + shulkerStack.getAmount();
                                }

                                if (shulkerStack.getType() == currencyBlock) {
                                    count = count + shulkerStack.getAmount() * 9;
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}