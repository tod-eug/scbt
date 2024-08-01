package bot.commands;

import bot.ReplyConstants;
import bot.keyboards.Keyboards;
import db.AnalyticsApi;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class SprachCafeCommand implements IBotCommand {
    @Override
    public String getCommandIdentifier() {
        return "sprachcafe";
    }

    @Override
    public String getDescription() {
        return "sprachcafe";
    }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] arguments) {

        String analyticsId = AnalyticsApi.createEvent(message.getFrom().getId(), getCommandIdentifier(),"",  "", "");

        SendMessage sm = new SendMessage();
        sm.setChatId(message.getChatId());
        sm.setText(ReplyConstants.SPRACHCAFE_REPLY_WELCOME);
        sm.setReplyMarkup(Keyboards.getWeekdaysKeyboard(SysConstants.WEEKDAYS, SysConstants.WEEKDAYS_ROOT_CALLBACK_TYPE));
        Integer messageId = MessageProcessor.sendAndReturnMessageID(absSender, sm);
        AnalyticsApi.setMessageId(analyticsId, messageId.toString());
    }
}
