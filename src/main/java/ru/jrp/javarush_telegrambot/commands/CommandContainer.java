package ru.jrp.javarush_telegrambot.commands;

import com.google.common.collect.ImmutableMap;
import ru.jrp.javarush_telegrambot.services.SendBotMessageService;

public class CommandContainer {
    ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService) {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(CommandName.START.getCommandName(), new StartCommand(sendBotMessageService))
                .put(CommandName.STOP.getCommandName(), new StopCommand(sendBotMessageService))
                .put(CommandName.HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(CommandName.NO.getCommandName(), new NoCommand(sendBotMessageService))
                .build();

        unknownCommand = new UnknowCommand(sendBotMessageService);
    }

    public Command retriveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
