package ru.sergio.schooltgbot.bot;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.sergio.schooltgbot.configuration.BotConfig;
import ru.sergio.schooltgbot.service.BotService;

@Component
@RequiredArgsConstructor
public class Bot extends TelegramLongPollingBot {

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
        PartialBotApiMethod<Message> message = botService.handleUpdate(update);
        if (message.getClass().equals(SendMessage.class)) {
            execute((SendMessage)message);
            return;
        }
        if (message.getClass().equals(SendDocument.class)) {
            execute((SendDocument)message);
            return;
        }
        if (message.getClass().equals(SendPhoto.class)) {
            execute((SendPhoto)message);
            return;
        }

    }
}
