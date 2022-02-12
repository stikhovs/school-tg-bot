package ru.sergio.schooltgbot.handler.extra;

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
public class ExtraCurricularHandler implements BotHandler {
    @Override
    public PartialBotApiMethod<Message> handle(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(getChatId(update));
        sendMessage.setText("Выберите интересующую категорию");

        InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(List.of(
                List.of(createInlineButton("Расписание бюджетных кружков " + getEmoji("saxophone"), FREE_COURSES_SCHEDULE_COMMAND)),
                List.of(createInlineButton("Расписание платных кружков " + getEmoji("violin"), PAID_COURSES_SCHEDULE_COMMAND)),
                List.of(createInlineButton("Заявление на зачисление в коллектив доп. образования " + getEmoji("page_facing_up"), EXTRA_CURRICULAR_BLANK_COMMAND)),
                List.of(createInlineButton("Записаться в кружок " + getEmoji("heavy_check_mark"), COURSE_SIGN_IN_COMMAND))
        ));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        return sendMessage;
    }
}
