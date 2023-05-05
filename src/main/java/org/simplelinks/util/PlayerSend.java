package org.simplelinks.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PlayerSend {
    public static void message (Player player, String message) {
        String formattedHex = ConvertHex.convert(message);
        String formattedYAML = ChatColor.translateAlternateColorCodes('&', formattedHex);
        player.sendMessage(formattedYAML);
    }
}
