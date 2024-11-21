package ru.jrp.javarush_telegrambot.commands;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.jrp.javarush_telegrambot.bot.JavaTeleBot;
import ru.jrp.javarush_telegrambot.services.SendBotMessageService;
import ru.jrp.javarush_telegrambot.services.SendBotMessageServiceImpl;

abstract class AbstractCommandTest {
    protected JavaTeleBot javaBot = Mockito.mock(JavaTeleBot.class);
    protected SendBotMessageService sendBotMessageService = new SendBotMessageServiceImpl(javaBot);

    abstract String getCommandName();

    abstract String getCommandMessage();

    abstract Command getCommand();

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {

        Long chatId = 1234567824356L;

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandName());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);

        getCommand().execute(update);

        Mockito.verify(javaBot).execute(sendMessage);
    }
}
