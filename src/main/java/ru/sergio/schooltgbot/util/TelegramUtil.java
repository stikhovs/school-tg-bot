package ru.sergio.schooltgbot.util;

import com.vdurmont.emoji.EmojiManager;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.sergio.schooltgbot.constants.BotCommands;

public final class TelegramUtil {

    // Создаем шаблон SendMessage с включенным Markdown
    public static SendMessage createMessageTemplate(String chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableMarkdown(true);
        return sendMessage;
    }

    // Создаем кнопку
    public static InlineKeyboardButton createInlineKeyboardButton(String text, String command) {
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText(text);
        inlineKeyboardButton.setCallbackData(command);
        return inlineKeyboardButton;
    }

    public static String getChatId(Update update) {
        if (update.getMessage() != null) {
            return update.getMessage().getChatId().toString();
        }
        return update.getCallbackQuery().getMessage().getChatId().toString();
    }

    public static String getUpdateText(Update update) {
        if (update.getMessage() != null) {
            return update.getMessage().getText();
        }
        return update.getCallbackQuery().getData();
    }

    public static InlineKeyboardButton createInlineButton(String text, BotCommands botCommands) {
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(text);
        button.setCallbackData(botCommands.getName());
        return button;
    }

    public static String getEmoji(String alias) {
        return EmojiManager.getForAlias(alias).getUnicode();
    }

}
