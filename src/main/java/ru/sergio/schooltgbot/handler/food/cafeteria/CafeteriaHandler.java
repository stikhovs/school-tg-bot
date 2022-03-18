package ru.sergio.schooltgbot.handler.food.cafeteria;

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
public class CafeteriaHandler implements BotHandler {
    @Override
    public PartialBotApiMethod<Message> handle(Update update) {
        SendPhoto sendPhoto = new SendPhoto();
        InputStream img = getClass().getClassLoader().getResourceAsStream("img/food/A360EC71-5C4B-4509-BA1E-2C38A9F35C88.jpg");
        InputFile imgFile = new InputFile(img, "cafeteria");
        sendPhoto.setCaption("Расписание столовой");
        sendPhoto.setPhoto(imgFile);
        sendPhoto.setChatId(TelegramUtil.getChatId(update));
        return sendPhoto;
    }
}
