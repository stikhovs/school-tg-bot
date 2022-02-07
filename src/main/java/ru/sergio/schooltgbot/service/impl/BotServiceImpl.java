package ru.sergio.schooltgbot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.sergio.schooltgbot.service.BotService;


@Slf4j
@Service
@RequiredArgsConstructor
public class BotServiceImpl implements BotService {

    @Override
    public SendMessage getSendMessage(Update update) {
        Message message = update.getMessage();
        String firstName = message.getChat().getFirstName();
        String lastName = message.getChat().getLastName();

        String text = String.format("Hello, %s %s!", firstName, lastName);

        return createSendMessage(message, text);
    }

    private SendMessage createSendMessage(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        return sendMessage;
    }

}
