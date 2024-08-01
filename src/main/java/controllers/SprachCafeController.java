package controllers;

import db.CafesApi;
import dto.DayTime;
import dto.Districts;
import dto.SprachCafe;
import dto.Weekdays;
import util.DayTimeResolver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class SprachCafeController {

    public static List<SprachCafe> getSprachcafes(Weekdays weekday, Districts district, DayTime daytime) {

        List<SprachCafe> result = new ArrayList<>();
        List<SprachCafe> rawList = CafesApi.getSprachCafes(weekday, district);
        Map<String, Date> map = DayTimeResolver.getStartEndTimes(daytime);

        for (int i = 0; i < rawList.size(); i++) {
            SprachCafe sc = rawList.get(i);
            if (sc.getStartTime().after(map.get("from")) && sc.getStartTime().before(map.get("to")))
                result.add(sc);
        }
        return result;
    }
}
