package gg.quartzdev.qspawners.spawner;

import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class SpawnerUtil {

    public static void setSpawnerType(CreatureSpawner spawner, EntityType spawnType){
        spawner.setSpawnedType(spawnType);
        spawner.update();
    }

    public static ItemStack getSpawnerItem(CreatureSpawner spawner){
        ItemStack itemStack = new ItemStack(Material.SPAWNER);
        BlockStateMeta blockStateMeta = (BlockStateMeta) itemStack.getItemMeta();
        CreatureSpawner newCreatureSpawner = (CreatureSpawner) blockStateMeta.getBlockState();
        newCreatureSpawner.setSpawnedType(spawner.getSpawnedType());
        blockStateMeta.setBlockState(newCreatureSpawner);
        itemStack.setItemMeta(blockStateMeta);
        return itemStack;
    }

}
