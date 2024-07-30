package db;

import dto.SprachCafe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CafesApi {

    public static List<SprachCafe> getSprachCafes(String district) {

        String selectQuery = String.format("select * from cafes where district = '%s';",
                district);

        DatabaseHelper dbHelper = new DatabaseHelper();
        List<SprachCafe> result = new ArrayList<>();
        try {
            ResultSet st = dbHelper.getPreparedStatement(selectQuery).executeQuery();
            while(st.next()) {
                result.add(new SprachCafe(st.getString("name"), st.getString("address"), st.getString("district"),
                        st.getString("contact"), st.getString("info")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbHelper.closeConnections();
        }
        return result;
    }
}
