package ru.jrp.javarush_telegrambot.commands;

import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.jrp.javarush_telegrambot.services.SendBotMessageService;

@RequiredArgsConstructor
public class UnknowCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String UNKNOWN_MESSAGE = "Не понимаю вас \uD83D\uDE1F, напишите /help чтобы узнать что я понимаю.";

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), UNKNOWN_MESSAGE);
    }
}
