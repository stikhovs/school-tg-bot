package ru.sergio.schooltgbot.handler.food;

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
public class FoodHandler implements BotHandler {
    @Override
    public PartialBotApiMethod<Message> handle(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(getChatId(update));
        sendMessage.setText("Выберите интересующую категорию");

        InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(List.of(
                List.of(createInlineButton("Меню на сегодня " + getEmoji("carrot"), TODAY_MENU_COMMAND)),
                List.of(createInlineButton("Пополнить карту Москвенок " + getEmoji("owl"), MOSKVENOK_COMMAND)),
                List.of(createInlineButton("Расписание столовой " + getEmoji("date"), CAFETERIA_SCHEDULE_COMMAND)),
                List.of(createInlineButton("Бланк заявления на платное питание " + getEmoji("moneybag"), PAID_FOOD_DOC_COMMAND))
        ));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        return sendMessage;
    }


}
