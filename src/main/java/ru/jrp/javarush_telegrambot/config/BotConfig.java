package ru.jrp.javarush_telegrambot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.jrp.javarush_telegrambot.bot.JavaTeleBot;

@Configuration
public class BotConfig {
    @Bean
    public TelegramBotsApi telegramBotsApi(JavaTeleBot javaBot) throws TelegramApiException {
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(javaBot);
        return api;
    }
}
