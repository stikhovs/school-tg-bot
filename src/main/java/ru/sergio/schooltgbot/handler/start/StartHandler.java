package ru.sergio.schooltgbot.handler.start;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import ru.sergio.schooltgbot.handler.BotHandler;
import ru.sergio.schooltgbot.util.TelegramUtil;

import java.util.List;

import static ru.sergio.schooltgbot.constants.CommandConstants.*;

@Service
public class StartHandler implements BotHandler {

    @Override
    public SendMessage handle(Update update) {
        ReplyKeyboardMarkup replyKeyboardMarkup = getReplyKeyboardMarkup();
        SendMessage messageTemplate = TelegramUtil.createMessageTemplate(update.getMessage().getChatId().toString());
        messageTemplate.setReplyMarkup(replyKeyboardMarkup);
        messageTemplate.setText("Здравствуйте, " +
                update.getMessage().getChat().getFirstName() + " " +
                update.getMessage().getChat().getLastName() +
                "! Пожалуйста, выберите категорию");
        return messageTemplate;
    }

    private ReplyKeyboardMarkup getReplyKeyboardMarkup() {
        KeyboardRow keyboardButtonsRow1 = new KeyboardRow();
        KeyboardButton calendar = new KeyboardButton(CALENDAR_COMMAND);
        KeyboardButton food = new KeyboardButton(FOOD_COMMAND);
        keyboardButtonsRow1.add(calendar);
        keyboardButtonsRow1.add(food);

        KeyboardRow keyboardButtonsRow2 = new KeyboardRow();
        KeyboardButton olympiads = new KeyboardButton(OLYMPIADS_COMMAND);
        KeyboardButton documents = new KeyboardButton(DOCUMENTS_COMMAND);
        keyboardButtonsRow2.add(olympiads);
        keyboardButtonsRow2.add(documents);

        KeyboardRow keyboardButtonsRow3 = new KeyboardRow();
        KeyboardButton schoolEvents = new KeyboardButton(SCHOOL_EVENTS_COMMAND);
        KeyboardButton extraCurricular = new KeyboardButton(EXTRA_CURRICULAR_COMMAND);
        keyboardButtonsRow3.add(schoolEvents);
        keyboardButtonsRow3.add(extraCurricular);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(List.of(keyboardButtonsRow1, keyboardButtonsRow2, keyboardButtonsRow3));
        return replyKeyboardMarkup;
    }

}
