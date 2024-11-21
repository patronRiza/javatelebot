package ru.jrp.javarush_telegrambot.commands;

import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.jrp.javarush_telegrambot.services.SendBotMessageService;

@RequiredArgsConstructor
public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String START_MESSAGE = "Привет! Я Джавателебот. Я помогу тебе быть в курсе последних " +
            "статей";

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
