package db.mappers;

import db.DatabaseHelper;
import dto.SprachCafe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SprachCafeMapper {

    public static SprachCafe mapSprachCafe(String name, String address, String district, String contact, String info, String startTimeS, String endTimeS) {

        SimpleDateFormat timeIntervalPattern = new SimpleDateFormat(DatabaseHelper.timeIntervalPattern);

        Date startTime;
        Date endTime;

        try {
            startTime = timeIntervalPattern.parse(startTimeS);
            endTime = timeIntervalPattern.parse(endTimeS);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return new SprachCafe(name, address, district, contact, info, startTime, endTime);
    }
}
