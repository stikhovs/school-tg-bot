package ru.sergio.schooltgbot.bot;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
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
import ru.sergio.schooltgbot.util.TelegramUtil;

import static ru.sergio.schooltgbot.util.TelegramUtil.getChatId;
import static ru.sergio.schooltgbot.util.TelegramUtil.getUpdateText;

@Slf4j
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
        log.info("Message text: {}, chatId: {}", getUpdateText(update), getChatId(update));
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
