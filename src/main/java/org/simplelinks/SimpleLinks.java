package org.simplelinks;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import org.simplelinks.commands.CommandLinks;
import org.simplelinks.commands.ReloadConfig;

import java.util.Objects;

public class SimpleLinks extends JavaPlugin {
    public FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        config.options().copyDefaults(true);
        saveConfig();

        Objects.requireNonNull(this.getCommand("links")).setExecutor(new CommandLinks());
        Objects.requireNonNull(this.getCommand("simplelinks")).setExecutor(new ReloadConfig());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
