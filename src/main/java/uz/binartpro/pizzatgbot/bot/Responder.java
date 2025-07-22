package uz.binartpro.pizzatgbot.bot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import uz.binartpro.pizzatgbot.strategy.CallbackStrategy;
import uz.binartpro.pizzatgbot.strategy.Strategy;
import uz.binartpro.pizzatgbot.strategy.TextStrategy;

@Component
@RequiredArgsConstructor
public class Responder extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return Bot.BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return Bot.BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Strategy strategy;
        try {
            SendMessage response = null;
            if (update.hasCallbackQuery()) {
                response = new CallbackStrategy().getResponse(update);
            }

            if (update.hasMessage()) {
                response = new TextStrategy().getResponse(update);
            }

            if (response == null) {
                System.out.println("ERROR: update type couldn't be determined");
                return;
            }

            sendApiMethod(response);


        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }

}
