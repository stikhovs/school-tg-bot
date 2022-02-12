package ru.sergio.schooltgbot.handler.docs;

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
public class DocumentsHandler implements BotHandler {
    @Override
    public PartialBotApiMethod<Message> handle(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(getChatId(update));
        sendMessage.setText("Выберите интересующую категорию");

        InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(List.of(
                List.of(createInlineButton("Образец заявлений и бланков " + getEmoji("blue_book"), DOCS_AND_BLANKS_EXAMPLE_COMMAND)),
                List.of(createInlineButton("Устав школы " + getEmoji("school") + getEmoji("green_book"), SCHOOL_REGULATIONS_COMMAND)),
                List.of(createInlineButton("Положение об оценивании " + getEmoji("notebook_with_decorative_cover"), ASSESSMENT_RULE_COMMAND))
        ));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        return sendMessage;
    }
}
