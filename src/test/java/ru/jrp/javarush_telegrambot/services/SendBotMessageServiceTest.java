package ru.jrp.javarush_telegrambot.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.jrp.javarush_telegrambot.bot.JavaTeleBot;

@DisplayName("Unit-level testing for SendMessageService")
class SendBotMessageServiceTest {

    private SendBotMessageService sendBotMessageService;
    private JavaTeleBot javaTeleBot;

    @BeforeEach
    public void init() {
        javaTeleBot = Mockito.mock(JavaTeleBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(javaTeleBot);
    }

    @Test
    void shouldProperlySendMessage() throws TelegramApiException {

        String message = "test message";
        String chatId = "test-chat-id";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        sendMessage.enableHtml(true);

        sendBotMessageService.sendMessage(chatId, message);

        Mockito.verify(javaTeleBot).execute(sendMessage);
    }
}