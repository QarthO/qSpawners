package gg.quartzdev.qspawners.util;

import gg.quartzdev.qspawners.commands.CMD;
import gg.quartzdev.qspawners.commands.CMDreload;
import gg.quartzdev.qspawners.commands.CommandManager;
import gg.quartzdev.qspawners.commands.QCommand;

import java.util.*;

public class QCommandMap {

    private HashMap<String, CommandManager> commands;

    public QCommandMap(){
        commands = new HashMap<>();
        setupDefaultCommand();
    }

    public void setupDefaultCommand(){
        CommandManager baseCmd = new CommandManager(
                QPlugin.getName(),
                List.of(QPlugin.getName().replaceFirst("q", "")));
        commands.put(QPlugin.getName().toLowerCase(), baseCmd);
    }

    public void add(String label, QCommand command){
        CommandManager cm = commands.get(label);
        if(cm == null){
            QLogger.error(Messages.ERROR_SAVE_FILE);
            return;
        }
        cm.add(label, command);
    }

    public void d(){
//        List<String> aliases = new ArrayList<>();
//        aliases.add("spawners");
//        HashMap<String, QCommand> subCommands = new HashMap<>();
//        subCommands.put("", new CMD("info", QPerm.GROUP_BASIC));
//        subCommands.put("reload", new CMDreload("reload", QPerm.GROUP_ADMIN));
//        new CommandManager(getName(), aliases, subCommands);
    }

}
