package com.windeaves.managers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Config {

    private File settings = new File("plugins/Windeaves/Auth", "setting.yml");
    private FileConfiguration setting = YamlConfiguration.loadConfiguration(settings);

    private Config() {
        spawnLocation = null;
        init();
    }

    static Config instance = new Config();

    public static Config getInstance() {
        return instance;
    }

    private Location spawnLocation;

    public boolean hasSpawn() {
        return this.spawnLocation != null;
    }

    public void setSpawnLocation(Location location) {
        this.spawnLocation = location;
        this.setting.set("location.world", location.getWorld().getName());
        this.setting.set("location.x", location.getX());
        this.setting.set("location.y", location.getY());
        this.setting.set("location.z", location.getZ());
        this.setting.set("location.pitch", location.getPitch());
        this.setting.set("location.yaw", location.getYaw());
        try {
            this.setting.save(settings);
        } catch (Exception e) {
            Bukkit.getLogger().info(e.toString());
        }
    }

    public Location getSpawnLocation() {
        return this.spawnLocation;
    }

    private void init() {
        if(this.setting.getString("location.world") != null) {
            this.spawnLocation = new Location(Bukkit.getWorld(this.setting.getString("location.world")), this.setting.getDouble("location.x"),  this.setting.getDouble("location.y"),  this.setting.getDouble("location.z"), this.setting.getFloat("location.pitch"), this.setting.getFloat("location.yaw"));
        }
    }

    private FileConfiguration getSetting() {
        return this.setting;
    }
}
