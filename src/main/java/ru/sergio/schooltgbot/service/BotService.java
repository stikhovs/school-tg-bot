package ru.sergio.schooltgbot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface BotService {

    SendMessage getSendMessage(Update update);

}
