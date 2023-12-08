package gg.quartzdev.qspawners;

import org.bukkit.plugin.java.JavaPlugin;

public final class qSpawners extends JavaPlugin {

    private static qSpawners instance;

    public static qSpawners getInstance(){
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;





        this.setupHandlers();
    }

    @Override
    public void onDisable() {

    }

    public void setupHandlers(){

    }
}
