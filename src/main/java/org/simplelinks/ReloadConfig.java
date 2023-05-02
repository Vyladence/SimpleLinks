package org.simplelinks;
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

                if (!(sender instanceof Player)) {
                    System.out.println("Config Reloaded!");
                } else {
                    String sendThis = ChatColor.translateAlternateColorCodes('&', "&8[&dSimpleLinks&8] &fConfig Reloaded!");
                    Player player = (Player) sender;
                    player.sendMessage(sendThis);
                }
            } else {
                // Unknown Command fallback

                if (!(sender instanceof Player)) {
                    System.out.println("Unknown Subcommand!");
                } else {
                    String sendThis = ChatColor.translateAlternateColorCodes('&', "&8[&dSimpleLinks&8] &cUnknown subcommand!");
                    Player player = (Player) sender;
                    player.sendMessage(sendThis);
                }
            }
            return true;
        } else {
            // Base command
            String version = SimpleLinks.getPlugin(SimpleLinks.class).getDescription().getVersion();

            if (!(sender instanceof Player)) {
                System.out.println("Running SimpleLinks v" + version);
            } else {
                String sendThis = ChatColor.translateAlternateColorCodes('&', "&8[&dSimpleLinks&8] &fRunning &fLinksPlugin &av" + version);
                Player player = (Player) sender;
                player.sendMessage(sendThis);
            }
            return true;
        }
    }
}
