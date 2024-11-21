package ru.jrp.javarush_telegrambot.commands;

import lombok.Getter;

@Getter
public enum CommandName {

    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    NO("");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

}
