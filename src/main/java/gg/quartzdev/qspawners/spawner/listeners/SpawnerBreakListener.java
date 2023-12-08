package gg.quartzdev.qspawners.spawner.listeners;

import gg.quartzdev.qspawners.qSpawners;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class SpawnerBreakListener implements Listener {
    private final qSpawners plugin;

    public SpawnerBreakListener(){
        this.plugin = qSpawners.getInstance();
    }

    @EventHandler
    public void onSpawnerBreak(BlockBreakEvent event){

    }

}
