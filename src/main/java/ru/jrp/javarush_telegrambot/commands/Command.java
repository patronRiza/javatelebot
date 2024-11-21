package ru.jrp.javarush_telegrambot.commands;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {
    void execute(Update update);
}
