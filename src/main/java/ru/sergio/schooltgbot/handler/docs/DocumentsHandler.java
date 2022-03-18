package ru.sergio.schooltgbot.handler.docs;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.sergio.schooltgbot.constants.BotCommands;
import ru.sergio.schooltgbot.handler.BotHandler;

import java.util.List;

import static ru.sergio.schooltgbot.constants.BotCommands.*;
import static ru.sergio.schooltgbot.util.TelegramUtil.*;

@Service
public class DocumentsHandler implements BotHandler {
    @Override
    public PartialBotApiMethod<Message> handle(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(getChatId(update));
        sendMessage.setText("Выберите интересующую категорию");

        InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(List.of(
                List.of(createInlineButton("Заявление на льготное питание " + getEmoji("notebook_with_decorative_cover"), PRIVILEGE_FOOD_BLANK_COMMAND)),
                List.of(createInlineButton("Устав школы " + getEmoji("school") + getEmoji("green_book"), SCHOOL_REGULATIONS_COMMAND)),
                List.of(createInlineButton("Заявление на зачисление в коллектив " + getEmoji("page_facing_up"), EXTRA_CURRICULAR_BLANK_COMMAND)),
                List.of(createInlineButton("Платные услуги школы " + getEmoji("moneybag"), PAID_SERVICE_BLANK_COMMAND)),
                List.of(createInlineButton("Заявление об отсутствии " + getEmoji("blue_book"), ABSENCE_BLANK_COMMAND))
        ));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        return sendMessage;
    }
}
