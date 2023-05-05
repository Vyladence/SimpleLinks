package org.simplelinks.commands;

import org.simplelinks.SimpleLinks;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import org.simplelinks.util.PlayerSend;

public class LinksCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String[] lines = SimpleLinks.getPlugin(SimpleLinks.class).getConfig().getStringList("lines").toArray(new String[0]);

        if (sender instanceof Player player) {
            for (String line : lines) {
                PlayerSend.message(player, line);
            }
        } else {
            System.out.println("This command can only run in-game!");
        }

        return true;
    }
}
