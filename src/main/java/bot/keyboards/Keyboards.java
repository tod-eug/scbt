package bot.keyboards;

import bot.commands.SysConstants;
import dto.DayTime;
import dto.Districts;
import dto.Weekdays;
import org.apache.commons.collections4.ListUtils;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class Keyboards {

    public static InlineKeyboardMarkup getWeekdaysKeyboard(List<Weekdays> list, String callbackType) {
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        if (!list.isEmpty()) {
            int buttonsInLine = 3;

            List<List<Weekdays>> dividedList = ListUtils.partition(list, buttonsInLine);

            for (List<Weekdays> l : dividedList) {
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                for (Weekdays s : l) {
                    InlineKeyboardButton button = new InlineKeyboardButton();
                    button.setText(s.getValue());
                    button.setCallbackData(callbackType + SysConstants.DELIMITER + s.getValue());
                    rowInline.add(button);
                }
                rowsInline.add(rowInline);
            }
        }

        keyboardMarkup.setKeyboard(rowsInline);
        return keyboardMarkup;
    }

    public static InlineKeyboardMarkup getDistrictsKeyboard(List<Districts> list, String callbackType) {
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        if (!list.isEmpty()) {
            int buttonsInLine = 3;

            List<List<Districts>> dividedList = ListUtils.partition(list, buttonsInLine);

            for (List<Districts> l : dividedList) {
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                for (Districts s : l) {
                    InlineKeyboardButton button = new InlineKeyboardButton();
                    button.setText(s.getValue());
                    button.setCallbackData(callbackType + SysConstants.DELIMITER + s.getValue());
                    rowInline.add(button);
                }
                rowsInline.add(rowInline);
            }
        }

        keyboardMarkup.setKeyboard(rowsInline);
        return keyboardMarkup;
    }

    public static InlineKeyboardMarkup getDayTimeKeyboard(List<DayTime> list, String callbackType) {
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        if (!list.isEmpty()) {
            int buttonsInLine = 3;

            List<List<DayTime>> dividedList = ListUtils.partition(list, buttonsInLine);

            for (List<DayTime> l : dividedList) {
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                for (DayTime s : l) {
                    InlineKeyboardButton button = new InlineKeyboardButton();
                    button.setText(s.getValue());
                    button.setCallbackData(callbackType + SysConstants.DELIMITER + s.getValue());
                    rowInline.add(button);
                }
                rowsInline.add(rowInline);
            }
        }

        keyboardMarkup.setKeyboard(rowsInline);
        return keyboardMarkup;
    }
}
