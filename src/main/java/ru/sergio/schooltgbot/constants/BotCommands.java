package ru.sergio.schooltgbot.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
public enum BotCommands {

    START_COMMAND("/start"),

    CALENDAR_COMMAND("Календарный график"),
    FOOD_COMMAND("Питание"),
    EXTRA_CURRICULAR_COMMAND("Дополнительное образование"),
    OLYMPIADS_COMMAND("Олимпиады и конкурсы"),
    DOCUMENTS_COMMAND("Документация"),
    SCHOOL_EVENTS_COMMAND("Мероприятия"),

    // Food
    TODAY_MENU_COMMAND("today-menu"),
    MOSKVENOK_COMMAND("moskvenok"),
    CAFETERIA_SCHEDULE_COMMAND("cafeteria-schedule"),
    PAID_FOOD_DOC_COMMAND("paid-food-doc"),

    // docs
    SCHOOL_REGULATIONS_COMMAND("school-regulations"),
    ASSESSMENT_RULE_COMMAND("assessment-rule"),
    ABSENCE_BLANK_COMMAND("absence-blank"),
    PRIVILEGE_FOOD_BLANK_COMMAND("privilege-food-blank"),
    EXTRA_CURRICULAR_BLANK_COMMAND("extra-curricular-blank"),
    PAID_SERVICE_BLANK_COMMAND("paid-service-blank"),

    // Extra
    COURSES_SCHEDULE_COMMAND("courses-schedule"),
    PAID_COURSES_BLANK_COMMAND("paid-courses-schedule"),
    ZAYAVLENIE_NA_DOP_COMMAND("zayavlenie-dop-blank"),

    // Olympics
    RUSSIA_OLYMPICS_COMMAND("russia-olympics"),
    MOSCOW_OLYMPICS_COMMAND("moscow-olympics"),
    OTHER_OLYMPICS_COMMAND("other-olympics"),
    HIGHEST_PROBE_COMMAND("highest-probe"),
    LOMONOSOV_OLYMPICS_COMMAND("lomonosov-olympics"),
    VB_OLYMPICS_COMMAND("vb-olympics"),
    EN_FUTURE_COMMAND("en-future"),


    // Events
    EVENTS_PHOTO_COMMAND("photo"),
    EVENTS_VIDEO_COMMAND("video");

    @Getter
    private final String name;

    public static BotCommands getCommand(String text) {
        return Stream.of(BotCommands.values())
                .filter(botCommands -> botCommands.getName().equals(text))
                .findFirst()
                .orElse(null);
    }

}
