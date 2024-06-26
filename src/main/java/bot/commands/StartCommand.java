package bot.commands;

import bot.ReplyConstants;
import db.AnalyticsApi;
import db.UsersApi;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class StartCommand implements IBotCommand {
    @Override
    public String getCommandIdentifier() { return "start"; }

    @Override
    public String getDescription() { return "start"; }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] arguments) {

        UsersApi.createUser(message.getFrom(), message.getChatId());
        AnalyticsApi.createEvent(message.getFrom().getId(), "start", "", "");

        SendMessage sm = new SendMessage();
        sm.setChatId(message.getChatId());
        sm.setText(ReplyConstants.START_REPLY_WELCOME);
        MessageProcessor.sendMsg(absSender, sm);
    }
}
