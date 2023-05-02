package org.simplelinks;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
public class SimpleLinks extends JavaPlugin {
    public FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        config.options().copyDefaults(true);
        saveConfig();

        this.getCommand("links").setExecutor(new CommandLinks());
        this.getCommand("simplelinks").setExecutor(new ReloadConfig());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
