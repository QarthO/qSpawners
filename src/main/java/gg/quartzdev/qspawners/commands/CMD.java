package gg.quartzdev.qspawners.commands;

import gg.quartzdev.qspawners.util.Messages;
import gg.quartzdev.qspawners.util.QPerm;
import gg.quartzdev.qspawners.util.QPlugin;
import gg.quartzdev.qspawners.util.Sender;
import org.bukkit.command.CommandSender;

public class CMD extends QCommand {
    public CMD(String name, QPerm permissionGroup) {
        super(name, permissionGroup);
    }

    @Override
    public boolean logic(CommandSender sender, String label, String[] args) {
        Sender.message(sender, Messages.PLUGIN_INFO.parse("version", QPlugin.getVersion()));
        return true;
    }

    @Override
    public Iterable<String> tabCompletionLogic(CommandSender sender, String[] args) {
        return null;
    }
}
