package ru.sergio.schooltgbot.handler.food.cafeteria;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.sergio.schooltgbot.handler.BotHandler;

import java.util.List;

import static ru.sergio.schooltgbot.constants.CommandConstants.*;
import static ru.sergio.schooltgbot.util.TelegramUtil.*;

@Service
public class CafeteriaHandler implements BotHandler {
    @Override
    public PartialBotApiMethod<Message> handle(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(getChatId(update));
        sendMessage.setText("Выберите УК " + getEmoji("point_down"));

        InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(List.of(List.of(
                createInlineButton("УК-1", UK_1_COMMAND),
                createInlineButton("УК-2", UK_2_COMMAND),
                createInlineButton("УК-3", UK_3_COMMAND)
        )));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        return sendMessage;
    }
}
