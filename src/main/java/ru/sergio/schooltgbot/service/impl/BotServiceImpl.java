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
import ru.sergio.schooltgbot.handler.events.SchoolEventsHandler;
import ru.sergio.schooltgbot.handler.events.educational.EducationalPlanHandler;
import ru.sergio.schooltgbot.handler.events.media.PhotoVideoHandler;
import ru.sergio.schooltgbot.handler.extra.ExtraCurricularHandler;
import ru.sergio.schooltgbot.handler.extra.enfuture.EnFutureHandler;
import ru.sergio.schooltgbot.handler.extra.moscow.MoscowOlympicsHandler;
import ru.sergio.schooltgbot.handler.extra.other.OtherOlympicsHandler;
import ru.sergio.schooltgbot.handler.extra.other.olympics.HighestProbeHandler;
import ru.sergio.schooltgbot.handler.extra.other.olympics.LomonosovHandler;
import ru.sergio.schooltgbot.handler.extra.other.olympics.VorobyoviGoriHandler;
import ru.sergio.schooltgbot.handler.extra.russia.RussiaOlympicsHandler;
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
import ru.sergio.schooltgbot.util.TelegramUtil;

import static ru.sergio.schooltgbot.constants.CommandConstants.*;
import static ru.sergio.schooltgbot.util.TelegramUtil.getUpdateText;


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
    private final ExtraCurricularHandler extraCurricularHandler;
    private final RussiaOlympicsHandler russiaOlympicsHandler;
    private final MoscowOlympicsHandler moscowOlympicsHandler;
    private final OtherOlympicsHandler otherOlympicsHandler;
    private final HighestProbeHandler highestProbeHandler;
    private final LomonosovHandler lomonosovHandler;
    private final VorobyoviGoriHandler vorobyoviGoriHandler;
    private final EnFutureHandler enFutureHandler;
    private final SchoolEventsHandler schoolEventsHandler;
    private final EducationalPlanHandler educationalPlanHandler;
    private final PhotoVideoHandler photoVideoHandler;

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


        // Доп образование
        if (text.equals(EXTRA_CURRICULAR_COMMAND)) {
            return extraCurricularHandler.handle(update);
        }
        if (text.equals(RUSSIA_OLYMPICS_COMMAND)) {
            return russiaOlympicsHandler.handle(update);
        }
        if (text.equals(MOSCOW_OLYMPICS_COMMAND)) {
            return moscowOlympicsHandler.handle(update);
        }
        if (text.equals(OTHER_OLYMPICS_COMMAND)) {
            return otherOlympicsHandler.handle(update);
        }
        if (text.equals(HIGHEST_PROBE_COMMAND)) {
            return highestProbeHandler.handle(update);
        }
        if (text.equals(LOMONOSOV_OLYMPICS_COMMAND)) {
            return lomonosovHandler.handle(update);
        }
        if (text.equals(VB_OLYMPICS_COMMAND)) {
            return vorobyoviGoriHandler.handle(update);
        }
        if (text.equals(EN_FUTURE_COMMAND)) {
            return enFutureHandler.handle(update);
        }


        // events
        if (text.equals(SCHOOL_EVENTS_COMMAND)) {
            return schoolEventsHandler.handle(update);
        }
        if (text.equals(EDUCATIONAL_PLAN_COMMAND)) {
            return educationalPlanHandler.handle(update);
        }
        if (text.equals(EVENTS_PHOTO_VIDEO_COMMAND)) {
            return photoVideoHandler.handle(update);
        }

        return handleUnknown(update);
    }

    private PartialBotApiMethod<Message> handleUnknown(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(TelegramUtil.getChatId(update));
        sendMessage.setText("Неизвестная команда " + TelegramUtil.getEmoji("mind_blown"));
        return sendMessage;
    }

}
