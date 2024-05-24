package db;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class AnalyticsApi {

    public static void createEvent(Long userId, String command, String text, String callback) {

        String createdDate = new SimpleDateFormat(DatabaseHelper.createDateDefaultPattern).format(new Date());
        UUID id = UUID.randomUUID();

        String insertQuery = String.format("insert into analytics (id, user_id, command, text, callback, create_date) VALUES ('%s', '%s', '%s', '%s', '%s', '%s');",
                id, userId, command, text, callback, createdDate);

        DatabaseHelper dbHelper = new DatabaseHelper();
        try {
            dbHelper.getPreparedStatement(insertQuery).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbHelper.closeConnections();
        }
    }
}
