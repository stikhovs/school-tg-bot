package ru.sergio.schooltgbot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.sergio.schooltgbot.constants.BotCommands;
import ru.sergio.schooltgbot.handler.BotHandler;
import ru.sergio.schooltgbot.service.BotService;
import ru.sergio.schooltgbot.util.TelegramUtil;

import java.util.Map;

import static ru.sergio.schooltgbot.util.TelegramUtil.getChatId;
import static ru.sergio.schooltgbot.util.TelegramUtil.getUpdateText;


@Slf4j
@Service
@RequiredArgsConstructor
public class BotServiceImpl implements BotService {

    private final Map<BotCommands, BotHandler> strategiesMap;

    @Override
    public PartialBotApiMethod<Message> handleUpdate(Update update) {
        String text = getUpdateText(update);
        BotCommands command = BotCommands.getCommand(text);
        BotHandler handler = strategiesMap.get(command);

        if (handler != null) {
            return handler.handle(update);
        }

        return handleUnknown(update);
    }

    private PartialBotApiMethod<Message> handleUnknown(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(TelegramUtil.getChatId(update));
        sendMessage.setText("Неизвестная команда " + TelegramUtil.getEmoji("mind_blown"));
        log.error("Unknown command! Message text: {}, chatId: {}", getUpdateText(update), getChatId(update));
        return sendMessage;
    }

}
