package ru.sergio.schooltgbot.handler.docs.sub;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.sergio.schooltgbot.handler.BotHandler;
import ru.sergio.schooltgbot.util.TelegramUtil;

@Service
public class AbsenceBlankHandler implements BotHandler {
    @Override
    public PartialBotApiMethod<Message> handle(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(TelegramUtil.getChatId(update));
        sendMessage.setText("https://xn-----6kcabifq3axidwreu8as3czcye6c.xn--p1ai/wp-content/uploads/2020/11/zayavlenie-v-shkolu-ob-otsutstvii-rebenka-po-semejnym-obstoyatelstvam.doc");
        return sendMessage;
    }
}
