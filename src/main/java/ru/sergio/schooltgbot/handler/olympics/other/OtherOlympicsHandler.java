package ru.sergio.schooltgbot.handler.olympics.other;

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
public class OtherOlympicsHandler implements BotHandler {
    @Override
    public PartialBotApiMethod<Message> handle(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(getChatId(update));
        sendMessage.setText("Выберите нужную опцию " + getEmoji("point_down"));

        InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(List.of(
                List.of(createInlineButton("Высшая проба " + getEmoji("first_place_medal"), HIGHEST_PROBE_COMMAND)),
                List.of(createInlineButton("Ломоносов " + getEmoji("nose") + getEmoji("punch"), LOMONOSOV_OLYMPICS_COMMAND)),
                List.of(createInlineButton("Покори Воробьевы Горы " + getEmoji("mount_fuji"), VB_OLYMPICS_COMMAND))
        ));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        return sendMessage;
    }
}
