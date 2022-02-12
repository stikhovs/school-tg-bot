package ru.sergio.schooltgbot.service;

import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface BotService {

    PartialBotApiMethod<Message> handleUpdate(Update update);

}
