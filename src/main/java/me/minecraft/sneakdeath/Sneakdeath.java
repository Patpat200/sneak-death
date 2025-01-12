package me.minecraft.sneakdeath;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Sneakdeath extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Plugin start");

        // Register the event listener
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Plugin stop");
    }

    @EventHandler
    public void onPlayerSneak(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();

        // Check if the player is sneaking
        if (event.isSneaking()) {
            // Kill the player if they are in survival or adventure mode
            if (player.getGameMode() == GameMode.SURVIVAL || player.getGameMode() == GameMode.ADVENTURE) {
                player.setHealth(0.0);
                player.sendMessage(ChatColor.RED + "You sneaked and paid the ultimate price!");
            } else {
                player.sendMessage(ChatColor.YELLOW + "Sneaking is dangerous, but you're lucky to be in " + player.getGameMode().toString().toLowerCase() + " mode.");
            }
        }
    }
}