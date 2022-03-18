package ru.sergio.schooltgbot.handler.events;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.sergio.schooltgbot.handler.BotHandler;

import java.util.List;

import static ru.sergio.schooltgbot.constants.BotCommands.*;
import static ru.sergio.schooltgbot.util.TelegramUtil.*;

@Service
public class SchoolEventsHandler implements BotHandler {
    @Override
    public PartialBotApiMethod<Message> handle(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(getChatId(update));
        sendMessage.setText("Выберите интересующую категорию");

        InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(List.of(
                List.of(createInlineButton("Фото " + getEmoji("cricket_game"), EVENTS_PHOTO_COMMAND)),
                List.of(createInlineButton("Видео " + getEmoji("film_frames"), EVENTS_VIDEO_COMMAND))
        ));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        return sendMessage;
    }
}
