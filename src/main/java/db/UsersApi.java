package db;

import org.telegram.telegrambots.meta.api.objects.User;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsersApi {

    public static void createUser(User user, Long chatId) {

        String tgId = user.getId().toString();
        String userName = user.getUserName();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        boolean isBot = user.getIsBot();
        String languageCode = user.getLanguageCode();
        String createdDate = new SimpleDateFormat(DatabaseHelper.createDateDefaultPattern).format(new Date());

        String insertQuery = String.format("insert into users (tg_id, chat_id, user_name, first_name, last_name, is_bot, language_code, create_date) VALUES ('%s', '%s', '%s', '%s', '%s', %s, '%s', '%s');",
                tgId, chatId.toString(), userName, firstName, lastName, isBot, languageCode, createdDate);

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
