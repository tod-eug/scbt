package bot.commands;

import java.util.Arrays;
import java.util.List;

public interface SysConstants {

    String DELIMITER = "-";
    List<String> WEEKDAYS = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
    List<String> DISTRICTS = Arrays.asList("Mitte", "Kreuzberg", "Pankow", "Spandau");
    List<String> DAYTIMES = Arrays.asList("Morning", "Day", "Evening");
    String WEEKDAYS_ROOT_CALLBACK_TYPE = "weekdays";
    String DISTRICTS_ROOT_CALLBACK_TYPE = "districts";
    String DAYTIMES_ROOT_CALLBACK_TYPE = "daytime";

    String MORNING_START_TIME = "01-01-1900 00:00:00";
    String MORNING_END_TIME = "01-01-1900 11:59:59";
    String DAY_START_TIME = "01-01-1900 12:00:00";
    String DAY_END_TIME = "01-01-1900 17:59:59";
    String EVENING_START_TIME = "01-01-1900 18:00:00";
    String EVENING_END_TIME = "01-01-1900 23:59:59";
}