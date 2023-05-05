package org.simplelinks.commands;

import org.simplelinks.SimpleLinks;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.simplelinks.util.PlayerSend;

public class ReloadConfig implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length >= 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                // Reload Command

                SimpleLinks.getPlugin(SimpleLinks.class).saveDefaultConfig();
                SimpleLinks.getPlugin(SimpleLinks.class).reloadConfig();

                if (sender instanceof Player player) {
                    PlayerSend.message(player, "&8[&dSimpleLinks&8] &fConfig Reloaded!");
                } else {
                    System.out.println("Config Reloaded!");
                }
            } else {
                // Unknown Command fallback

                if (sender instanceof Player player) {
                    PlayerSend.message(player, "&8[&dSimpleLinks&8] &cUnknown subcommand!");
                } else {
                    System.out.println("Unknown Subcommand!");
                }
            }
        } else {
            // Base command
            String version = SimpleLinks.getPlugin(SimpleLinks.class).getDescription().getVersion();

            if (sender instanceof Player player) {
                PlayerSend.message(player, "&8[&dSimpleLinks&8] &fRunning &fLinksPlugin &av" + version);
            } else {
                System.out.println("Running SimpleLinks v" + version);
            }
        }
        return true;
    }
}
