package ru.sergio.schooltgbot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.sergio.schooltgbot.handler.calendar.CalendarHandler;
import ru.sergio.schooltgbot.handler.docs.DocumentsHandler;
import ru.sergio.schooltgbot.handler.docs.assessment.AssessmentRuleHandler;
import ru.sergio.schooltgbot.handler.docs.blank.*;
import ru.sergio.schooltgbot.handler.docs.regulation.SchoolRegulationsHandler;
import ru.sergio.schooltgbot.handler.food.FoodHandler;
import ru.sergio.schooltgbot.handler.food.cafeteria.CafeteriaHandler;
import ru.sergio.schooltgbot.handler.food.cafeteria.uk.Uk_1_Handler;
import ru.sergio.schooltgbot.handler.food.cafeteria.uk.Uk_2_Handler;
import ru.sergio.schooltgbot.handler.food.cafeteria.uk.Uk_3_Handler;
import ru.sergio.schooltgbot.handler.food.moskvenok.MoskvenokHandler;
import ru.sergio.schooltgbot.handler.food.menu.TodayMenuHandler;
import ru.sergio.schooltgbot.handler.food.paid.PaidFoodHandler;
import ru.sergio.schooltgbot.handler.start.StartHandler;
import ru.sergio.schooltgbot.service.BotService;

import static ru.sergio.schooltgbot.constants.CommandConstants.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class BotServiceImpl implements BotService {

    private final StartHandler startHandler;
    private final CalendarHandler calendarHandler;
    private final FoodHandler foodHandler;
    private final TodayMenuHandler todayMenuHandler;
    private final MoskvenokHandler moskvenokHandler;
    private final CafeteriaHandler cafeteriaHandler;
    private final Uk_1_Handler uk_1_handler;
    private final Uk_2_Handler uk_2_handler;
    private final Uk_3_Handler uk_3_handler;
    private final PaidFoodHandler paidFoodHandler;
    private final DocumentsHandler documentsHandler;
    private final DocsBlanksExampleHandler docsBlanksExampleHandler;
    private final AbsentBlankHandler absentBlankHandler;
    private final ExtraCurricularBlankHandler extraCurricularBlankHandler;
    private final PaidServiceBlankHandler paidServiceBlankHandler;
    private final PrivilegeFoodBlankHandler privilegeFoodBlankHandler;
    private final SchoolRegulationsHandler schoolRegulationsHandler;
    private final AssessmentRuleHandler assessmentRuleHandler;

    @Override
    public PartialBotApiMethod<Message> handleUpdate(Update update) {
        String text = getUpdateText(update);

        if (text.equals("/start")) {
            return startHandler.handle(update);
        }
        // calendar
        if (text.equals(CALENDAR_COMMAND)) {
            return calendarHandler.handle(update);
        }

        // food
        if (text.equals(FOOD_COMMAND)) {
            return foodHandler.handle(update);
        }
        if (text.equals(TODAY_MENU_COMMAND)) {
            return todayMenuHandler.handle(update);
        }
        if (text.equals(MOSKVENOK_COMMAND)) {
            return moskvenokHandler.handle(update);
        }
        if (text.equals(CAFETERIA_SCHEDULE_COMMAND)) {
            return cafeteriaHandler.handle(update);
        }
        if (text.equals(UK_1_COMMAND)) {
            return uk_1_handler.handle(update);
        }
        if (text.equals(UK_2_COMMAND)) {
            return uk_2_handler.handle(update);
        }
        if (text.equals(UK_3_COMMAND)) {
            return uk_3_handler.handle(update);
        }
        if (text.equals(PAID_FOOD_DOC_COMMAND)) {
            return paidFoodHandler.handle(update);
        }

        // docs
        if (text.equals(DOCUMENTS_COMMAND)) {
            return documentsHandler.handle(update);
        }
        if (text.equals(DOCS_AND_BLANKS_EXAMPLE_COMMAND)) {
            return docsBlanksExampleHandler.handle(update);
        }
        if (text.equals(ABSENCE_BLANK_COMMAND)) {
            return absentBlankHandler.handle(update);
        }
        if (text.equals(PRIVILEGE_FOOD_BLANK_COMMAND)) {
            return privilegeFoodBlankHandler.handle(update);
        }
        if (text.equals(EXTRA_CURRICULAR_BLANK_COMMAND)) {
            return extraCurricularBlankHandler.handle(update);
        }
        if (text.equals(PAID_SERVICE_BLANK_COMMAND)) {
            return paidServiceBlankHandler.handle(update);
        }
        if (text.equals(SCHOOL_REGULATIONS_COMMAND)) {
            return schoolRegulationsHandler.handle(update);
        }
        if (text.equals(ASSESSMENT_RULE_COMMAND)) {
            return assessmentRuleHandler.handle(update);
        }

        return null;
    }

    private String getUpdateText(Update update) {
        if (update.getMessage() != null) {
            return update.getMessage().getText();
        }
        return update.getCallbackQuery().getData();
    }

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
