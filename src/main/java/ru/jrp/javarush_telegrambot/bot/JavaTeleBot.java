package ru.jrp.javarush_telegrambot.bot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.jrp.javarush_telegrambot.commands.CommandContainer;
import ru.jrp.javarush_telegrambot.commands.CommandName;
import ru.jrp.javarush_telegrambot.services.SendBotMessageServiceImpl;

@Component
@Slf4j
public class JavaTeleBot extends TelegramLongPollingBot {

    public static String COMMAND_PREFIX = "/";

    private final CommandContainer commandContainer;

    public JavaTeleBot(@Value("${bot.token}") String token) {
        super(token);
        commandContainer =
                new CommandContainer(new SendBotMessageServiceImpl(this));
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                String command = message.split(" ")[0].toLowerCase();

                commandContainer.retriveCommand(command).execute(update);
            } else
                commandContainer.retriveCommand(CommandName.NO.getCommandName()).execute(update);
        }
    }

    @Override
    public String getBotUsername() {
        return "test_javatele_bot";
    }
}
