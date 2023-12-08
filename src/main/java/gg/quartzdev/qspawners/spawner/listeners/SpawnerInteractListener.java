package gg.quartzdev.qspawners.spawner.listeners;

import gg.quartzdev.qspawners.qSpawners;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class SpawnerInteractListener implements Listener {
    private final qSpawners plugin;

    public SpawnerInteractListener(){
        this.plugin = qSpawners.getInstance();
    }

    @EventHandler
    public void onSpawnerRightClick(PlayerInteractEvent event){

    }

}
