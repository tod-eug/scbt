package bot.commands;

import bot.ReplyConstants;
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

        SendMessage sm = new SendMessage();
        sm.setChatId(message.getChatId());
        sm.setText(ReplyConstants.START_REPLY_WELCOME);
        MessageProcessor.sendMsg(absSender, sm);
    }
}
