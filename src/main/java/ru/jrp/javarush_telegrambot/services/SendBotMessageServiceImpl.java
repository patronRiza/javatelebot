package ru.jrp.javarush_telegrambot.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.jrp.javarush_telegrambot.bot.JavaTeleBot;

@Service
@RequiredArgsConstructor
@Slf4j
public class SendBotMessageServiceImpl implements SendBotMessageService {

    private final JavaTeleBot javaTeleBot;

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            javaTeleBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
    }
}
