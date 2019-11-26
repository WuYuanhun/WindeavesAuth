package com.windeaves.managers;

import org.bukkit.Location;

public class Config {

    private Config() {
        spawnLocation = null;
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
    }

    public Location getSpawnLocation() {
        return this.spawnLocation;
    }
}
