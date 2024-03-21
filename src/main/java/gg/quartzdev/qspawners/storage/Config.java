package gg.quartzdev.qspawners.storage;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Config extends QConfiguration {

    private final String PATH_DISABLED_WORLDS = "disabled-worlds";
    private final String PATH_REQUIRED_TOOLS = "required-tools";
    private final String PATH_REQUIRES_PERMISSION = "requires-permission";
    private final String PATH_REQUIRES_SILK_TOUCH = "requires-silktouch";
    private List<World> disabledWorlds;
    private List<Material> requiredTools;
    private boolean requiresPermission = true;
    private boolean requiresSilkTouch = true;

    public Config(String fileName) {
        super(fileName);
        disabledWorlds = new ArrayList<>();
        requiredTools = new ArrayList<>();
        loadAllData();
    }

    public void loadAllData(){
        loadDisabledWorlds();
        loadRequiredTools();
    }
    public void saveAllData(){
        saveDisabledWorlds();
    }

    public void loadDisabledWorlds(){
        disabledWorlds = getWorldList(PATH_DISABLED_WORLDS);
    }
    public boolean isDisabledWorld(World world){
        return disabledWorlds.contains(world);
    }
    public void saveDisabledWorlds(){
        List<String> worldNames = disabledWorlds.stream().map(World::getName).toList();
        yamlConfiguration.set(PATH_DISABLED_WORLDS, worldNames);
        save();
    }
    public void loadRequiredTools(){
        requiredTools = getMaterialList(PATH_REQUIRED_TOOLS);
    }
    public void loadRequiresPermission(){
        requiresPermission = yamlConfiguration.getBoolean(PATH_REQUIRES_PERMISSION);
    }
    public boolean requiresPermission(){
        return requiresPermission;
    }
    public boolean requiresSilkTouch(){
        return requiresSilkTouch;
    }
    public void loadRequiresSilkTouch(){
        requiresSilkTouch = yamlConfiguration.getBoolean(PATH_REQUIRES_SILK_TOUCH);
    }
    public boolean isRequiredTool(ItemStack itemStack){
        if(requiresSilkTouch){
            if(itemStack.getEnchantmentLevel(Enchantment.SILK_TOUCH) < 1){
                return false;
            }
        }
        return requiredTools.contains(itemStack.getType());
    }

}
