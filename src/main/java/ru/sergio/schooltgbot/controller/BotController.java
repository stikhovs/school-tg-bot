package ru.sergio.schooltgbot.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.sergio.schooltgbot.configuration.BotConfig;
import ru.sergio.schooltgbot.service.BotService;

@Component
@RequiredArgsConstructor
public class BotController extends TelegramLongPollingBot {

    private final BotConfig botConfig;

    private final BotService botService;

    @Override
    public String getBotUsername() {
        return botConfig.getName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        SendMessage message = botService.getSendMessage(update);
        execute(message);
    }
}
