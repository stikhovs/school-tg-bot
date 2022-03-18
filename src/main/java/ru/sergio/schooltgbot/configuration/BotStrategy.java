package ru.sergio.schooltgbot.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sergio.schooltgbot.constants.BotCommands;
import ru.sergio.schooltgbot.handler.BotHandler;
import ru.sergio.schooltgbot.handler.calendar.CalendarHandler;
import ru.sergio.schooltgbot.handler.docs.DocumentsHandler;
import ru.sergio.schooltgbot.handler.docs.sub.*;
import ru.sergio.schooltgbot.handler.events.SchoolEventsHandler;
import ru.sergio.schooltgbot.handler.events.sub.PhotoHandler;
import ru.sergio.schooltgbot.handler.events.sub.VideoHandler;
import ru.sergio.schooltgbot.handler.extra.ExtraCurricularHandler;
import ru.sergio.schooltgbot.handler.extra.courses.CoursesHandler;
import ru.sergio.schooltgbot.handler.extra.paid.PaidCoursesHandler;
import ru.sergio.schooltgbot.handler.extra.sub.ExtraBlankHandler;
import ru.sergio.schooltgbot.handler.food.FoodHandler;
import ru.sergio.schooltgbot.handler.food.cafeteria.CafeteriaHandler;
import ru.sergio.schooltgbot.handler.food.menu.TodayMenuHandler;
import ru.sergio.schooltgbot.handler.food.moskvenok.MoskvenokHandler;
import ru.sergio.schooltgbot.handler.olympics.OlympicsHandler;
import ru.sergio.schooltgbot.handler.olympics.enfuture.EnFutureHandler;
import ru.sergio.schooltgbot.handler.olympics.moscow.MoscowOlympicsHandler;
import ru.sergio.schooltgbot.handler.olympics.other.OtherOlympicsHandler;
import ru.sergio.schooltgbot.handler.olympics.other.olympics.HighestProbeHandler;
import ru.sergio.schooltgbot.handler.olympics.other.olympics.LomonosovHandler;
import ru.sergio.schooltgbot.handler.olympics.other.olympics.VorobyoviGoriHandler;
import ru.sergio.schooltgbot.handler.olympics.russia.RussiaOlympicsHandler;
import ru.sergio.schooltgbot.handler.start.StartHandler;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class BotStrategy {

    private final StartHandler startHandler;
    private final CalendarHandler calendarHandler;
    private final FoodHandler foodHandler;
    private final TodayMenuHandler todayMenuHandler;
    private final MoskvenokHandler moskvenokHandler;
    private final CafeteriaHandler cafeteriaHandler;
    private final DocumentsHandler documentsHandler;
    private final AbsenceBlankHandler absenceBlankHandler;
    private final ExtraCurricularBlankHandler extraCurricularBlankHandler;
    private final PaidServiceBlankHandler paidServiceBlankHandler;
    private final PrivilegeFoodBlankHandler privilegeFoodBlankHandler;
    private final SchoolRegulationsHandler schoolRegulationsHandler;
    private final ExtraCurricularHandler extraCurricularHandler;
    private final PaidCoursesHandler paidCoursesHandler;
    private final OlympicsHandler olympicsHandler;
    private final RussiaOlympicsHandler russiaOlympicsHandler;
    private final MoscowOlympicsHandler moscowOlympicsHandler;
    private final OtherOlympicsHandler otherOlympicsHandler;
    private final HighestProbeHandler highestProbeHandler;
    private final LomonosovHandler lomonosovHandler;
    private final VorobyoviGoriHandler vorobyoviGoriHandler;
    private final EnFutureHandler enFutureHandler;
    private final SchoolEventsHandler schoolEventsHandler;
    private final PhotoHandler photoHandler;
    private final VideoHandler videoHandler;
    private final ExtraBlankHandler extraBlank;
    private final CoursesHandler coursesHandler;

    @Bean
    public Map<BotCommands, BotHandler> strategiesMap() {
        Map<BotCommands, BotHandler> strategiesMap = new HashMap<>();

        // start
        strategiesMap.put(BotCommands.START_COMMAND, startHandler);

        // calendar
        strategiesMap.put(BotCommands.CALENDAR_COMMAND, calendarHandler);

        // food
        strategiesMap.put(BotCommands.FOOD_COMMAND, foodHandler);
        strategiesMap.put(BotCommands.TODAY_MENU_COMMAND, todayMenuHandler);
        strategiesMap.put(BotCommands.MOSKVENOK_COMMAND, moskvenokHandler);
        strategiesMap.put(BotCommands.CAFETERIA_SCHEDULE_COMMAND, cafeteriaHandler);

        // docs
        strategiesMap.put(BotCommands.DOCUMENTS_COMMAND, documentsHandler);
        strategiesMap.put(BotCommands.ABSENCE_BLANK_COMMAND, absenceBlankHandler);
        strategiesMap.put(BotCommands.PRIVILEGE_FOOD_BLANK_COMMAND, privilegeFoodBlankHandler);
        strategiesMap.put(BotCommands.EXTRA_CURRICULAR_BLANK_COMMAND, extraCurricularBlankHandler);
        strategiesMap.put(BotCommands.PAID_SERVICE_BLANK_COMMAND, paidServiceBlankHandler);
        strategiesMap.put(BotCommands.SCHOOL_REGULATIONS_COMMAND, schoolRegulationsHandler);

        // Доп образование
        strategiesMap.put(BotCommands.EXTRA_CURRICULAR_COMMAND, extraCurricularHandler);
        strategiesMap.put(BotCommands.COURSES_SCHEDULE_COMMAND, coursesHandler);
        strategiesMap.put(BotCommands.PAID_COURSES_BLANK_COMMAND, paidCoursesHandler);
        strategiesMap.put(BotCommands.ZAYAVLENIE_NA_DOP_COMMAND, extraBlank);

        // Олимпиады и конкурсы
        strategiesMap.put(BotCommands.OLYMPIADS_COMMAND, olympicsHandler);
        strategiesMap.put(BotCommands.RUSSIA_OLYMPICS_COMMAND, russiaOlympicsHandler);
        strategiesMap.put(BotCommands.MOSCOW_OLYMPICS_COMMAND, moscowOlympicsHandler);
        strategiesMap.put(BotCommands.OTHER_OLYMPICS_COMMAND, otherOlympicsHandler);
        strategiesMap.put(BotCommands.HIGHEST_PROBE_COMMAND, highestProbeHandler);
        strategiesMap.put(BotCommands.LOMONOSOV_OLYMPICS_COMMAND, lomonosovHandler);
        strategiesMap.put(BotCommands.VB_OLYMPICS_COMMAND, vorobyoviGoriHandler);
        strategiesMap.put(BotCommands.EN_FUTURE_COMMAND, enFutureHandler);

        // events
        strategiesMap.put(BotCommands.SCHOOL_EVENTS_COMMAND, schoolEventsHandler);
        strategiesMap.put(BotCommands.EVENTS_PHOTO_COMMAND, photoHandler);
        strategiesMap.put(BotCommands.EVENTS_VIDEO_COMMAND, videoHandler);

        return strategiesMap;
    }

}
