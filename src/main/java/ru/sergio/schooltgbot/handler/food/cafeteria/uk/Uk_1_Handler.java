package ru.sergio.schooltgbot.handler.food.cafeteria.uk;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.sergio.schooltgbot.handler.BotHandler;
import ru.sergio.schooltgbot.util.TelegramUtil;

import java.io.InputStream;

@Service
public class Uk_1_Handler implements BotHandler {
    @Override
    public PartialBotApiMethod<Message> handle(Update update) {
        SendPhoto sendPhoto = new SendPhoto();
        InputStream img = getClass().getClassLoader().getResourceAsStream("img/food/uk-1.jpg");
        InputFile imgFile = new InputFile(img, "uk-1-img");
        sendPhoto.setCaption("УК-1");
        sendPhoto.setPhoto(imgFile);
        sendPhoto.setChatId(TelegramUtil.getChatId(update));
        return sendPhoto;
    }
}
