package ru.sergio.schooltgbot.handler.extra;

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
public class ExtraCurricularHandler implements BotHandler {
    @Override
    public PartialBotApiMethod<Message> handle(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(getChatId(update));
        sendMessage.setText("Выберите интересующую категорию");

        InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(List.of(
                List.of(createInlineButton("Расписание кружков " + getEmoji("saxophone"), COURSES_SCHEDULE_COMMAND)),
                List.of(createInlineButton("Заявление на доп. образование " + getEmoji("page_facing_up"), ZAYAVLENIE_NA_DOP_COMMAND)),
                List.of(createInlineButton("Заявление на платные услуги " + getEmoji("heavy_check_mark"), PAID_SERVICE_BLANK_COMMAND))
        ));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        return sendMessage;
    }
}
