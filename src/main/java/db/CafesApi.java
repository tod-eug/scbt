package db;

import db.mappers.SprachCafeMapper;
import dto.Districts;
import dto.SprachCafe;
import dto.Weekdays;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CafesApi {

    public static List<SprachCafe> getSprachCafes(Weekdays weekday, Districts district) {

        String selectQuery = String.format("select name, address, district, contact, info, start_time, end_time from cafes join cafes_availability on cafes.id = cafes_availability.cafe_id where cafes_availability.day_of_week = '%s' and cafes.district = '%s' order by name;",
                weekday.getValue(), district.getValue());

        DatabaseHelper dbHelper = new DatabaseHelper();
        List<SprachCafe> result = new ArrayList<>();
        try {
            ResultSet st = dbHelper.getPreparedStatement(selectQuery).executeQuery();
            while(st.next()) {
                result.add(SprachCafeMapper.mapSprachCafe(st.getString("name"), st.getString("address"), st.getString("district"),
                        st.getString("contact"), st.getString("info"), st.getString("start_time"), st.getString("end_time")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbHelper.closeConnections();
        }
        return result;
    }
}
