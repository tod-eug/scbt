package db;

import org.telegram.telegrambots.meta.api.objects.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class UsersApi {

    public static String createUser(User user, Long chatId) {

        String tgId = user.getId().toString();
        String userName = user.getUserName();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        boolean isBot = user.getIsBot();
        String languageCode = user.getLanguageCode();
        String createdDate = new SimpleDateFormat(DatabaseHelper.createDateDefaultPattern).format(new Date());

        UUID id = UUID.randomUUID();

        String insertQuery = String.format("insert into users (id, tg_id, chat_id, user_name, first_name, last_name, is_bot, language_code, create_date) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', %s, '%s', '%s');",
                id, tgId, chatId.toString(), userName, firstName, lastName, isBot, languageCode, createdDate);

        DatabaseHelper dbHelper = new DatabaseHelper();
        try {
            dbHelper.getPreparedStatement(insertQuery).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbHelper.closeConnections();
        }
        return id.toString();
    }

    public static String findUserByTgId(String tgId, User user, Long chatId) {
        String selectQuery = String.format("select id from public.users where tg_id = '%s';", tgId);

        DatabaseHelper dbHelper = new DatabaseHelper();
        String id = "";
        try {
            ResultSet st = dbHelper.getPreparedStatement(selectQuery).executeQuery();
            if (st.next()) {
                id = st.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbHelper.closeConnections();
        }

        if (id.equals(""))
            id = createUser(user, chatId);
        return id;
    }
}
