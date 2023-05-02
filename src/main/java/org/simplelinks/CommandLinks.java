package org.simplelinks;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.bukkit.ChatColor.COLOR_CHAR;

public class CommandLinks implements CommandExecutor {
    public String translateHexColorCodes(String startTag, String endTag, String message)
    {
        final Pattern hexPattern = Pattern.compile(startTag + "([A-Fa-f0-9]{6})" + endTag);
        Matcher matcher = hexPattern.matcher(message);
        StringBuilder buffer = new StringBuilder(message.length() + 4 * 8);
        while (matcher.find())
        {
            String group = matcher.group(1);
            matcher.appendReplacement(buffer, COLOR_CHAR + "x"
                    + COLOR_CHAR + group.charAt(0) + COLOR_CHAR + group.charAt(1)
                    + COLOR_CHAR + group.charAt(2) + COLOR_CHAR + group.charAt(3)
                    + COLOR_CHAR + group.charAt(4) + COLOR_CHAR + group.charAt(5)
            );
        }
        return matcher.appendTail(buffer).toString();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String[] lines = SimpleLinks.getPlugin(SimpleLinks.class).getConfig().getStringList("lines").toArray(new String[0]);

        if (sender instanceof Player player) {
            for (String line : lines) {
                String replaceStandardHex = translateHexColorCodes("&#", "", line);
                String replaceHex = translateHexColorCodes("#", "", replaceStandardHex);
                String replaceColorCodes = ChatColor.translateAlternateColorCodes('&', replaceHex);
                player.sendMessage(replaceColorCodes);
            }
        } else {
            for (String line : lines) {
                String replaceStandardHex = translateHexColorCodes("&#", "", line);
                String replaceHex = translateHexColorCodes("#", "", replaceStandardHex);
                String replaceColorCodes = ChatColor.translateAlternateColorCodes('&', replaceHex);
                System.out.println(replaceColorCodes);
            }
        }
        return true;
    }
}
