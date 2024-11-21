package ru.jrp.javarush_telegrambot.commands;

import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.jrp.javarush_telegrambot.services.SendBotMessageService;

@RequiredArgsConstructor
public class NoCommand implements Command {

    public final SendBotMessageService sendBotMessageService;

    public static final String NO_MESSAGE = "Я поддерживаю команды, начинающиеся со слеша (/).\n"
            + "Чтобы посмотреть список команд введите /help";

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), NO_MESSAGE);
    }
}
