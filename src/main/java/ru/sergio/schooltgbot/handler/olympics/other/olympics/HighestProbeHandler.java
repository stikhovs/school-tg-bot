package ru.sergio.schooltgbot.handler.olympics.other.olympics;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.sergio.schooltgbot.handler.BotHandler;
import ru.sergio.schooltgbot.util.TelegramUtil;

@Service
public class HighestProbeHandler implements BotHandler {
    @Override
    public PartialBotApiMethod<Message> handle(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(TelegramUtil.getChatId(update));
        sendMessage.setText("https://olymp.hse.ru/mmo/");
        return sendMessage;
    }
}
