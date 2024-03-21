package gg.quartzdev.qspawners;

import gg.quartzdev.qspawners.util.QPlugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class QSpawners extends JavaPlugin {

    @Override
    public void onEnable() {
        QPlugin.enable(this, true, -1);
    }

    @Override
    public void onDisable() {
        QPlugin.disable(false);
    }

}
