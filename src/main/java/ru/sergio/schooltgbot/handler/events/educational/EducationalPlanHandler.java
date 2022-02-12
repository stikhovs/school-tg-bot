package ru.sergio.schooltgbot.handler.events.educational;

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
public class EducationalPlanHandler implements BotHandler {
    @Override
    public PartialBotApiMethod<Message> handle(Update update) {
        SendPhoto sendPhoto = new SendPhoto();
        InputStream img = getClass().getClassLoader().getResourceAsStream("img/events/punishment.jpg");
        InputFile imgFile = new InputFile(img, "educational-plan");
        sendPhoto.setCaption("План воспитательной работы в школе");
        sendPhoto.setPhoto(imgFile);
        sendPhoto.setChatId(TelegramUtil.getChatId(update));
        return sendPhoto;
    }
}
