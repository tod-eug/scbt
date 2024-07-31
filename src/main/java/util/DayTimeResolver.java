package util;

import bot.commands.SysConstants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DayTimeResolver {

    public static Map<String, Date> getStartEndTimes(String daytime) {
        Map<String, Date> result = new HashMap<>();
        String from;
        String to;
        switch (daytime) {
            case "Morning":
                from = SysConstants.MORNING_START_TIME;
                to = SysConstants.MORNING_END_TIME;
                result.put("from", getDateFromString(from));
                result.put("to", getDateFromString(to));
                break;
            case "Day":
                from = SysConstants.DAY_START_TIME;
                to = SysConstants.DAY_END_TIME;
                result.put("from", getDateFromString(from));
                result.put("to", getDateFromString(to));
                break;
            case "Evening":
                from = SysConstants.EVENING_START_TIME;
                to = SysConstants.EVENING_END_TIME;
                result.put("from", getDateFromString(from));
                result.put("to", getDateFromString(to));
                break;
        }
        return result;
    }

    private static Date getDateFromString(String dateS) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date;
        try {
            date = formatter.parse(dateS);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }
}