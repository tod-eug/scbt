package bot.commands;

import dto.DayTime;
import dto.Districts;
import dto.Weekdays;

import java.util.Arrays;
import java.util.List;

import static dto.DayTime.*;
import static dto.Districts.*;
import static dto.Weekdays.*;

public interface SysConstants {

    String DELIMITER = "-";
    List<Weekdays> WEEKDAYS = Arrays.asList(Montag, Dienstag, Mittwoch, Donnerstag, Freitag, Samstag);
    List<Districts> DISTRICTS = Arrays.asList(Mitte, Friedrichshain, Pankow, Kreuzberg, Spandau, Steglitz,
            Zehlendorf, Reinickendorf, Neukölln, Tempelhof, Schöneberg, Köpenick, Hellersdorf, Wilmersdorf,
            Marzahn, Charlottenburg, Prenzlauer_Berg);
    List<DayTime> DAYTIME = Arrays.asList(Morgen, Nachmittag, Abend);
    String WEEKDAYS_ROOT_CALLBACK_TYPE = "weekdays";
    String DISTRICTS_ROOT_CALLBACK_TYPE = "districts";
    String DAYTIME_ROOT_CALLBACK_TYPE = "daytime";

    String MORNING_START_TIME = "01-01-1900 06:00:00";
    String MORNING_END_TIME = "01-01-1900 11:59:59";
    String DAY_START_TIME = "01-01-1900 12:00:00";
    String DAY_END_TIME = "01-01-1900 17:59:59";
    String EVENING_START_TIME = "01-01-1900 18:00:00";
    String EVENING_END_TIME = "01-01-1900 22:00:00";
}
