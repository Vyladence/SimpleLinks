package org.simplelinks.commands;

import org.simplelinks.SimpleLinks;

import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class ReloadConfig implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length >= 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                // Reload Command

                SimpleLinks.getPlugin(SimpleLinks.class).saveDefaultConfig();
                SimpleLinks.getPlugin(SimpleLinks.class).reloadConfig();

                if (!(sender instanceof Player player)) {
                    System.out.println("Config Reloaded!");
                } else {
                    String sendThis = ChatColor.translateAlternateColorCodes('&', "&8[&dSimpleLinks&8] &fConfig Reloaded!");
                    player.sendMessage(sendThis);
                }
            } else {
                // Unknown Command fallback

                if (!(sender instanceof Player player)) {
                    System.out.println("Unknown Subcommand!");
                } else {
                    String sendThis = ChatColor.translateAlternateColorCodes('&', "&8[&dSimpleLinks&8] &cUnknown subcommand!");
                    player.sendMessage(sendThis);
                }
            }
        } else {
            // Base command
            String version = SimpleLinks.getPlugin(SimpleLinks.class).getDescription().getVersion();

            if (!(sender instanceof Player player)) {
                System.out.println("Running SimpleLinks v" + version);
            } else {
                String sendThis = ChatColor.translateAlternateColorCodes('&', "&8[&dSimpleLinks&8] &fRunning &fLinksPlugin &av" + version);
                player.sendMessage(sendThis);
            }
        }
        return true;
    }
}
