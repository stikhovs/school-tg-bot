package ru.sergio.schooltgbot.handler.calendar;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.sergio.schooltgbot.handler.BotHandler;
import ru.sergio.schooltgbot.util.TelegramUtil;

import java.io.InputStream;

@Service
public class CalendarHandler implements BotHandler {

    @Override
    public SendPhoto handle(Update update) {
        SendPhoto sendPhoto = new SendPhoto();
        InputStream img = getClass().getClassLoader().getResourceAsStream("img/calendar/Кalendarnyy-uchebnyy-grafik-na-2021--2022-uchebnyy-god.pdf");
        InputFile imgFile = new InputFile(img, "calendar");
        sendPhoto.setCaption("Календарный график");
        sendPhoto.setPhoto(imgFile);
        sendPhoto.setChatId(TelegramUtil.getChatId(update));
        return sendPhoto;
    }

}
