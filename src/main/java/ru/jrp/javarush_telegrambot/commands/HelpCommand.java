package ru.jrp.javarush_telegrambot.commands;

import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.jrp.javarush_telegrambot.services.SendBotMessageService;

@RequiredArgsConstructor
public class HelpCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE = String.format("<b>Доступные форматы</b> \n"
                            + "<b>Начать/закончить работу с ботом</b\n>"
                            + "<b>%s - начать работу со мной\n</b>"
                            + "<b>%s - приостановить работу со мной\n\n</b>"
                            + "<b>$s - получить помощь в работе со мной\n</b>",
            CommandName.START.getCommandName(),
            CommandName.STOP.getCommandName(),
            CommandName.HELP.getCommandName());

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
