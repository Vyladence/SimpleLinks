package org.simplelinks.util;

import org.bukkit.ChatColor;

public class ChatFormat {
    public static String format (String message) {
        String formattedHex = ConvertHex.convert(message);
        return ChatColor.translateAlternateColorCodes('&', formattedHex);
    }
}
