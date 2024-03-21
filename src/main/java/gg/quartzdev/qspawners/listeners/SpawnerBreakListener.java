package gg.quartzdev.qspawners.listeners;

import gg.quartzdev.qspawners.QSpawners;
import gg.quartzdev.qspawners.spawner.SpawnerUtil;
import gg.quartzdev.qspawners.util.QPlugin;
import gg.quartzdev.qspawners.util.Sender;
import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public class SpawnerBreakListener implements Listener {;

    public SpawnerBreakListener(){
    }

    @EventHandler
    public void onSpawnerBreak(BlockBreakEvent event){
        if(QPlugin.getConfig().isDisabledWorld(event.getBlock().getWorld())){
            return;
        }
        if(!(event.getBlock().getState() instanceof CreatureSpawner spawner)){
            return;
        }
        if(!QPlugin.getConfig().isRequiredTool(event.getPlayer().getInventory().getItemInMainHand())){
            Sender.actionBar(event.getPlayer(), "<red>not a valid tool");
            event.setCancelled(true);
            return;
        }
        spawner.getWorld().dropItem(spawner.getLocation(), SpawnerUtil.getSpawnerItem(spawner));
        spawner.getBlock().setType(Material.AIR);
        event.setCancelled(true);
    }

}
