package ru.jrp.javarush_telegrambot.commands;

import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.jrp.javarush_telegrambot.services.SendBotMessageService;

@RequiredArgsConstructor
public class StopCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String STOP_MESSAGE = "Деактивировал все что можно...";

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
    }
}
