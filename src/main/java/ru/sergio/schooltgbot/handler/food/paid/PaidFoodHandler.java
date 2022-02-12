package ru.sergio.schooltgbot.handler.food.paid;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.sergio.schooltgbot.handler.BotHandler;
import ru.sergio.schooltgbot.util.TelegramUtil;

import java.io.InputStream;

@Service
public class PaidFoodHandler implements BotHandler {
    @Override
    public PartialBotApiMethod<Message> handle(Update update) {
        InputStream doc = getClass().getClassLoader().getResourceAsStream("img/food/PaidFoodDoc.pdf");
        InputFile file = new InputFile(doc, "Бланк заявления на платное питание.pdf");
        return new SendDocument(TelegramUtil.getChatId(update), file);
    }
}
