package bot;

import bot.commands.SprachCafeCommand;
import bot.commands.StartCommand;
import bot.commands.SysConstants;
import bot.keyboards.Keyboards;
import db.AnalyticsApi;
import dto.DayTime;
import dto.Districts;
import dto.RequestParameters;
import dto.Weekdays;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import util.PropertiesProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SprachCafeBot extends TelegramLongPollingCommandBot {

    public static Map<Long, RequestParameters> stateMap = new HashMap<>();

    public SprachCafeBot() {
        super();
        register(new StartCommand());
        register(new SprachCafeCommand());
    }
    @Override
    public String getBotUsername() { return PropertiesProvider.configurationProperties.get("BotName"); }

    @Override
    public String getBotToken() { return PropertiesProvider.configurationProperties.get("BotToken"); }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        if (update.hasCallbackQuery()) {
            processCallbackQuery(update);
        }
        if (update.hasMessage()) {
            AnalyticsApi.createEvent(update.getMessage().getFrom().getId(), "", update.getMessage().getMessageId().toString(), update.getMessage().getText(), "");
            deleteMessage(update.getMessage().getChatId(), update.getMessage().getMessageId());
        }
    }

    @Override
    public void processInvalidCommandUpdate(Update update) {
        super.processInvalidCommandUpdate(update);
    }

    @Override
    public boolean filter(Message message) {
        return super.filter(message);
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    private void processCallbackQuery(Update update) {
        AnalyticsApi.createEvent(update.getCallbackQuery().getFrom().getId(), "", update.getCallbackQuery().getMessage().getMessageId().toString(), "", update.getCallbackQuery().getData());
        Long userId = update.getCallbackQuery().getFrom().getId();
        Long chatId = update.getCallbackQuery().getMessage().getChatId();
        int messageId = update.getCallbackQuery().getMessage().getMessageId();

        String[] parsedCallback = update.getCallbackQuery().getData().split(SysConstants.DELIMITER);

        switch (parsedCallback[0]) {
            case SysConstants.WEEKDAYS_ROOT_CALLBACK_TYPE:
                processWeekDayCallbackQuery(parsedCallback, userId, chatId, messageId, update.getCallbackQuery().getFrom());
                break;
            case SysConstants.DISTRICTS_ROOT_CALLBACK_TYPE:
                processDistrictCallbackQuery(parsedCallback, userId, chatId, messageId, update.getCallbackQuery().getFrom());
                break;
            case SysConstants.DAYTIME_ROOT_CALLBACK_TYPE:
                processDayTimeCallbackQuery(parsedCallback, userId, chatId, messageId, update.getCallbackQuery().getFrom());
                break;
        }
    }

    private void processWeekDayCallbackQuery(String[] parsedCallback, Long userId, Long chatId, int messageId, User user) {
        RequestParameters rp = new RequestParameters(Weekdays.valueOf(parsedCallback[1]));
        stateMap.put(userId, rp);
        editMessage(chatId, messageId, ReplyConstants.SPRACHCAFE_REPLY_DISTRICT, false,
                Keyboards.getDistrictsKeyboard(SysConstants.DISTRICTS, SysConstants.DISTRICTS_ROOT_CALLBACK_TYPE));
    }

    private void processDistrictCallbackQuery(String[] parsedCallback, Long userId, Long chatId, int messageId, User user) {
        RequestParameters rp = stateMap.get(userId);
        if (rp != null) {
            rp.setDistrict(Districts.valueOf(parsedCallback[1]));
            stateMap.put(userId, rp);
            editMessage(chatId, messageId, ReplyConstants.SPRACHCAFE_REPLY_DAYTIME, false,
                    Keyboards.getDayTimeKeyboard(SysConstants.DAYTIME, SysConstants.DAYTIME_ROOT_CALLBACK_TYPE));
        } else {
            deleteMessage(chatId, messageId);
        }
    }

    private void processDayTimeCallbackQuery(String[] parsedCallback, Long userId, Long chatId, int messageId, User user) {
        RequestParameters rp = stateMap.get(userId);
        if (rp != null) {
            rp.setDayTime(DayTime.valueOf(parsedCallback[1]));
            stateMap.put(userId, rp);
            editMessage(chatId, messageId, MessageProvider.getSprachCafeMessage(rp), true, null);
        } else {
            deleteMessage(chatId, messageId);
        }

    }

    private void editMessage(long chatId, int messageId, String text, boolean htmlParseMode, InlineKeyboardMarkup keyboard) {
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setChatId(chatId);
        editMessageText.setMessageId(messageId);
        editMessageText.setText(text);
        if (keyboard != null)
            editMessageText.setReplyMarkup(keyboard);
        if (htmlParseMode)
            editMessageText.setParseMode(ParseMode.HTML);
        try {
            execute(editMessageText);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void deleteMessage(long chatId, int messageId) {
        DeleteMessage deleteMessage = new DeleteMessage();
        deleteMessage.setChatId(Long.toString(chatId));
        deleteMessage.setMessageId(messageId);
        try {
            execute(deleteMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
