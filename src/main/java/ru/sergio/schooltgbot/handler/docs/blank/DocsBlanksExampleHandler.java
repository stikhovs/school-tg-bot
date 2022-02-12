package ru.sergio.schooltgbot.handler.docs.blank;

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
import static ru.sergio.schooltgbot.util.TelegramUtil.getEmoji;

@Service
public class DocsBlanksExampleHandler implements BotHandler {
    @Override
    public PartialBotApiMethod<Message> handle(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(getChatId(update));
        sendMessage.setText("Выберите нужную опцию");

        InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(List.of(
                List.of(createInlineButton("Заявление об отсутствии в школе " + getEmoji("file_folder"), ABSENCE_BLANK_COMMAND)),
                List.of(createInlineButton("Заявление на льготное питание " + getEmoji("memo"), PRIVILEGE_FOOD_BLANK_COMMAND)),
                List.of(createInlineButton("Заявление на зачисление в коллектив доп. образования " + getEmoji("page_facing_up"), EXTRA_CURRICULAR_BLANK_COMMAND)),
                List.of(createInlineButton("Договор на оказание платных услуг " + getEmoji("scroll"), PAID_SERVICE_BLANK_COMMAND))
        ));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        return sendMessage;
    }
}
