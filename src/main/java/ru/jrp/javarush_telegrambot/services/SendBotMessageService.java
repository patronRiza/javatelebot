package ru.jrp.javarush_telegrambot.services;

public interface SendBotMessageService {
    void sendMessage(String chatId, String message);
}
