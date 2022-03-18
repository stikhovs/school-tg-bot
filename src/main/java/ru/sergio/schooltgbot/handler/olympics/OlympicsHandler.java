package ru.sergio.schooltgbot.handler.olympics;

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
public class OlympicsHandler implements BotHandler {
    @Override
    public PartialBotApiMethod<Message> handle(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(getChatId(update));
        sendMessage.setText("Выберите интересующую категорию");

        InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(List.of(
                List.of(createInlineButton("Всероссийская олимпиада школьников " + getEmoji("ru"), RUSSIA_OLYMPICS_COMMAND)),
                List.of(createInlineButton("Московская олимпиада школьников " + getEmoji("trophy"), MOSCOW_OLYMPICS_COMMAND)),
                List.of(createInlineButton("Перечневые олимпиады " + getEmoji("muscle"), OTHER_OLYMPICS_COMMAND)),
                List.of(createInlineButton("Конференция 'Инженеры будущего' " + getEmoji("man_factory_worker"), EN_FUTURE_COMMAND))
        ));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        return sendMessage;
    }
}
